package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/interactor/Failure;", "F", "Lau/gov/health/covidsafe/interactor/Either;", "", "failure", "(Ljava/lang/Object;)V", "getFailure", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lau/gov/health/covidsafe/interactor/Failure;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Either.kt */
public final class Failure<F> extends Either {
    private final F failure;

    public static /* synthetic */ Failure copy$default(Failure failure2, F f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = failure2.failure;
        }
        return failure2.copy(f);
    }

    public final F component1() {
        return this.failure;
    }

    public final Failure<F> copy(F f) {
        return new Failure<>(f);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.failure, (Object) ((Failure) obj).failure);
        }
        return true;
    }

    public int hashCode() {
        F f = this.failure;
        if (f != null) {
            return f.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Failure(failure=" + this.failure + ")";
    }

    public Failure(F f) {
        super((DefaultConstructorMarker) null);
        this.failure = f;
    }

    public final F getFailure() {
        return this.failure;
    }
}
