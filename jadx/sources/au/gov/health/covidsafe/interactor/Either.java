package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0002\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00060\bH\b¢\u0006\u0002\u0010\n\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lau/gov/health/covidsafe/interactor/Either;", "F", "S", "", "()V", "fold", "T", "failed", "Lkotlin/Function1;", "succeeded", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lau/gov/health/covidsafe/interactor/Failure;", "Lau/gov/health/covidsafe/interactor/Success;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Either.kt */
public abstract class Either<F, S> {
    private Either() {
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <T> T fold(Function1<? super F, ? extends T> function1, Function1<? super S, ? extends T> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "failed");
        Intrinsics.checkParameterIsNotNull(function12, "succeeded");
        if (this instanceof Failure) {
            return function1.invoke(((Failure) this).getFailure());
        }
        if (this instanceof Success) {
            return function12.invoke(((Success) this).getSuccess());
        }
        throw new NoWhenBranchMatchedException();
    }
}
