package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/interactor/Success;", "S", "Lau/gov/health/covidsafe/interactor/Either;", "", "success", "(Ljava/lang/Object;)V", "getSuccess", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lau/gov/health/covidsafe/interactor/Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Either.kt */
public final class Success<S> extends Either {
    private final S success;

    public static /* synthetic */ Success copy$default(Success success2, S s, int i, Object obj) {
        if ((i & 1) != 0) {
            s = success2.success;
        }
        return success2.copy(s);
    }

    public final S component1() {
        return this.success;
    }

    public final Success<S> copy(S s) {
        return new Success<>(s);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.success, (Object) ((Success) obj).success);
        }
        return true;
    }

    public int hashCode() {
        S s = this.success;
        if (s != null) {
            return s.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Success(success=" + this.success + ")";
    }

    public Success(S s) {
        super((DefaultConstructorMarker) null);
        this.success = s;
    }

    public final S getSuccess() {
        return this.success;
    }
}
