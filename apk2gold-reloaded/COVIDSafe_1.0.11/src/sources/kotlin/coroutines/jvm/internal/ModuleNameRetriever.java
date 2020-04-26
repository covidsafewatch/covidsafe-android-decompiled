package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: DebugMetadata.kt */
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    public static Cache cache;
    private static final Cache notOnJava9 = new Cache(null, null, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DebugMetadata.kt */
    private static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getModuleName(kotlin.coroutines.jvm.internal.BaseContinuationImpl r6) {
        /*
            r5 = this;
            java.lang.String r0 = "continuation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            kotlin.coroutines.jvm.internal.ModuleNameRetriever$Cache r0 = cache
            if (r0 == 0) goto L_0x000a
            goto L_0x000e
        L_0x000a:
            kotlin.coroutines.jvm.internal.ModuleNameRetriever$Cache r0 = r5.buildCache(r6)
        L_0x000e:
            kotlin.coroutines.jvm.internal.ModuleNameRetriever$Cache r1 = notOnJava9
            r2 = 0
            if (r0 != r1) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.reflect.Method r1 = r0.getModuleMethod
            if (r1 == 0) goto L_0x0045
            java.lang.Class r6 = r6.getClass()
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Object r6 = r1.invoke(r6, r4)
            if (r6 == 0) goto L_0x0045
            java.lang.reflect.Method r1 = r0.getDescriptorMethod
            if (r1 == 0) goto L_0x0045
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.Object r6 = r1.invoke(r6, r4)
            if (r6 == 0) goto L_0x0045
            java.lang.reflect.Method r0 = r0.nameMethod
            if (r0 == 0) goto L_0x003c
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.Object r6 = r0.invoke(r6, r1)
            goto L_0x003d
        L_0x003c:
            r6 = r2
        L_0x003d:
            boolean r0 = r6 instanceof java.lang.String
            if (r0 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r2 = r6
        L_0x0043:
            java.lang.String r2 = (java.lang.String) r2
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.jvm.internal.ModuleNameRetriever.getModuleName(kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.String");
    }

    private final Cache buildCache(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache2 = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            cache = cache2;
            return cache2;
        } catch (Exception unused) {
            Cache cache3 = notOnJava9;
            cache = cache3;
            return cache3;
        }
    }
}
