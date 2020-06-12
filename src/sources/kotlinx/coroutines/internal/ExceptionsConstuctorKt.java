package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: ExceptionsConstuctor.kt */
public final class ExceptionsConstuctorKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x0028
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.CopyableThrowable r9 = (kotlinx.coroutines.CopyableThrowable) r9     // Catch:{ all -> 0x0012 }
            java.lang.Throwable r9 = r9.createCopy()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlin.Result.m4constructorimpl(r9)     // Catch:{ all -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m4constructorimpl(r9)
        L_0x001d:
            boolean r0 = kotlin.Result.m10isFailureimpl(r9)
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = r9
        L_0x0025:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0028:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r2 = exceptionCtors     // Catch:{ all -> 0x0125 }
            java.lang.Class r3 = r9.getClass()     // Catch:{ all -> 0x0125 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0125 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x0125 }
            r0.unlock()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r9 = r2.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0049:
            int r0 = throwableFields
            java.lang.Class r2 = r9.getClass()
            r3 = 0
            int r2 = fieldsCountOrDefault(r2, r3)
            if (r0 == r2) goto L_0x00a0
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r4 = r0.getWriteHoldCount()
            if (r4 != 0) goto L_0x0067
            int r4 = r0.getReadHoldCount()
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            r5 = 0
        L_0x0069:
            if (r5 >= r4) goto L_0x0071
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0071:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r5 = exceptionCtors     // Catch:{ all -> 0x0093 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0093 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0093 }
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r6 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x0093 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0093 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0093 }
        L_0x0087:
            if (r3 >= r4) goto L_0x008f
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0087
        L_0x008f:
            r0.unlock()
            return r1
        L_0x0093:
            r9 = move-exception
        L_0x0094:
            if (r3 >= r4) goto L_0x009c
            r2.lock()
            int r3 = r3 + 1
            goto L_0x0094
        L_0x009c:
            r0.unlock()
            throw r9
        L_0x00a0:
            r0 = r1
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Class r2 = r9.getClass()
            java.lang.reflect.Constructor[] r2 = r2.getConstructors()
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 r4 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
            r4.<init>()
            java.util.Comparator r4 = (java.util.Comparator) r4
            java.util.List r2 = kotlin.collections.ArraysKt.sortedWith((T[]) r2, r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x00ba:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00cc
            java.lang.Object r0 = r2.next()
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            kotlin.jvm.functions.Function1 r0 = createConstructor(r0)
            if (r0 == 0) goto L_0x00ba
        L_0x00cc:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r2.readLock()
            int r5 = r2.getWriteHoldCount()
            if (r5 != 0) goto L_0x00dd
            int r5 = r2.getReadHoldCount()
            goto L_0x00de
        L_0x00dd:
            r5 = 0
        L_0x00de:
            r6 = 0
        L_0x00df:
            if (r6 >= r5) goto L_0x00e7
            r4.unlock()
            int r6 = r6 + 1
            goto L_0x00df
        L_0x00e7:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r6 = exceptionCtors     // Catch:{ all -> 0x0118 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x0118 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0118 }
            if (r0 == 0) goto L_0x00fa
            r8 = r0
            goto L_0x00fe
        L_0x00fa:
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1 r8 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x0118 }
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch:{ all -> 0x0118 }
        L_0x00fe:
            r6.put(r7, r8)     // Catch:{ all -> 0x0118 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0118 }
        L_0x0103:
            if (r3 >= r5) goto L_0x010b
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0103
        L_0x010b:
            r2.unlock()
            if (r0 == 0) goto L_0x0117
            java.lang.Object r9 = r0.invoke(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0117:
            return r1
        L_0x0118:
            r9 = move-exception
        L_0x0119:
            if (r3 >= r5) goto L_0x0121
            r4.lock()
            int r3 = r3 + 1
            goto L_0x0119
        L_0x0121:
            r2.unlock()
            throw r9
        L_0x0125:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }

    private static final Function1<Throwable, Throwable> createConstructor(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class cls = parameterTypes[0];
            if (Intrinsics.areEqual((Object) cls, (Object) Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return new ExceptionsConstuctorKt$safeCtor$1(function1);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m4constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m4constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m10isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i2 = 0;
            Class<? super Object> cls2 = cls;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i;
    }
}
