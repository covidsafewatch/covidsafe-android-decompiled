package kotlin;

import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/LazyKt")
/* compiled from: LazyJVM.kt */
class LazyKt__LazyJVMKt {
    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        return new SynchronizedLazyImpl<>(function0, (Object) null, 2, (DefaultConstructorMarker) null);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(lazyThreadSafetyMode, "mode");
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        int i = LazyKt.WhenMappings.$EnumSwitchMapping$0[lazyThreadSafetyMode.ordinal()];
        if (i == 1) {
            return new SynchronizedLazyImpl<>(function0, (Object) null, 2, (DefaultConstructorMarker) null);
        }
        if (i == 2) {
            return new SafePublicationLazyImpl<>(function0);
        }
        if (i == 3) {
            return new UnsafeLazyImpl<>(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Lazy<T> lazy(Object obj, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "initializer");
        return new SynchronizedLazyImpl<>(function0, obj);
    }
}
