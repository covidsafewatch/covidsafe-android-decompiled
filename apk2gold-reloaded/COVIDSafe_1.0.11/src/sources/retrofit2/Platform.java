package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter.Factory;

class Platform {
    private static final Platform PLATFORM = findPlatform();

    static class Android extends Platform {

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        Android() {
        }

        /* access modifiers changed from: 0000 */
        public boolean isDefaultMethod(Method method) {
            if (VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* access modifiers changed from: 0000 */
        public List<? extends Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
            if (executor != null) {
                DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
                if (VERSION.SDK_INT < 24) {
                    return Collections.singletonList(defaultCallAdapterFactory);
                }
                return Arrays.asList(new Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory});
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        public int defaultCallAdapterFactoriesSize() {
            return VERSION.SDK_INT >= 24 ? 2 : 1;
        }

        /* access modifiers changed from: 0000 */
        public List<? extends Converter.Factory> defaultConverterFactories() {
            if (VERSION.SDK_INT >= 24) {
                return Collections.singletonList(OptionalConverterFactory.INSTANCE);
            }
            return Collections.emptyList();
        }

        /* access modifiers changed from: 0000 */
        public int defaultConverterFactoriesSize() {
            return VERSION.SDK_INT >= 24 ? 1 : 0;
        }
    }

    static class Java8 extends Platform {
        /* access modifiers changed from: 0000 */
        public int defaultCallAdapterFactoriesSize() {
            return 2;
        }

        /* access modifiers changed from: 0000 */
        public int defaultConverterFactoriesSize() {
            return 1;
        }

        Java8() {
        }

        /* access modifiers changed from: 0000 */
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: 0000 */
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return ((Lookup) declaredConstructor.newInstance(new Object[]{cls, Integer.valueOf(-1)})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        /* access modifiers changed from: 0000 */
        public List<? extends Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(CompletableFutureCallAdapterFactory.INSTANCE);
            arrayList.add(new DefaultCallAdapterFactory(executor));
            return Collections.unmodifiableList(arrayList);
        }

        /* access modifiers changed from: 0000 */
        public List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }
    }

    /* access modifiers changed from: 0000 */
    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int defaultConverterFactoriesSize() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean isDefaultMethod(Method method) {
        return false;
    }

    Platform() {
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException unused2) {
            return new Platform();
        }
    }

    /* access modifiers changed from: 0000 */
    public List<? extends Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    /* access modifiers changed from: 0000 */
    public List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
