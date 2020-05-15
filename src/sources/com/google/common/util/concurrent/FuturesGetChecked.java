package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function<Constructor<?>, Boolean>() {
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }).reverse();

    interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> cls);
    }

    static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) throws Exception {
        return getChecked(bestGetCheckedTypeValidator(), future, cls);
    }

    static <V, X extends Exception> V getChecked(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        getCheckedTypeValidator.validateClass(cls);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e);
        } catch (ExecutionException e2) {
            wrapAndThrowExceptionOrError(e2.getCause(), cls);
            throw new AssertionError();
        }
    }

    static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        bestGetCheckedTypeValidator().validateClass(cls);
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(cls, e);
        } catch (TimeoutException e2) {
            throw newWithCause(cls, e2);
        } catch (ExecutionException e3) {
            wrapAndThrowExceptionOrError(e3.getCause(), cls);
            throw new AssertionError();
        }
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    static GetCheckedTypeValidator classValueValidator() {
        return GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
    }

    static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();
        static final String CLASS_VALUE_VALIDATOR_NAME = (GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator");

        GetCheckedTypeValidatorHolder() {
        }

        enum ClassValueValidator implements GetCheckedTypeValidator {
            INSTANCE;
            
            private static final ClassValue<Boolean> isValidClass = null;

            static {
                isValidClass = new ClassValue<Boolean>() {
                    /* access modifiers changed from: protected */
                    public Boolean computeValue(Class<?> cls) {
                        FuturesGetChecked.checkExceptionClassValidity(cls.asSubclass(Exception.class));
                        return true;
                    }
                };
            }

            public void validateClass(Class<? extends Exception> cls) {
                isValidClass.get(cls);
            }
        }

        enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;
            
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            static {
                validClasses = new CopyOnWriteArraySet();
            }

            public void validateClass(Class<? extends Exception> cls) {
                for (WeakReference<Class<? extends Exception>> weakReference : validClasses) {
                    if (cls.equals(weakReference.get())) {
                        return;
                    }
                }
                FuturesGetChecked.checkExceptionClassValidity(cls);
                if (validClasses.size() > 1000) {
                    validClasses.clear();
                }
                validClasses.add(new WeakReference(cls));
            }
        }

        static GetCheckedTypeValidator getBestValidator() {
            try {
                return (GetCheckedTypeValidator) Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
            } catch (Throwable unused) {
                return FuturesGetChecked.weakSetValidator();
            }
        }
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw newWithCause(cls, th);
        }
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> cls) {
        try {
            newWithCause(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static <X extends Exception> X newWithCause(Class<X> cls, Throwable th) {
        for (Constructor newFromConstructor : preferringStrings(Arrays.asList(cls.getConstructors()))) {
            X x = (Exception) newFromConstructor(newFromConstructor, th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> list) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    @NullableDecl
    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class cls = parameterTypes[i];
            if (cls.equals(String.class)) {
                objArr[i] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    static boolean isCheckedException(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    static void checkExceptionClassValidity(Class<? extends Exception> cls) {
        Preconditions.checkArgument(isCheckedException(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", (Object) cls);
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", (Object) cls);
    }

    private FuturesGetChecked() {
    }
}
