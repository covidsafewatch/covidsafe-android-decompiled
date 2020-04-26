package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/interactor/Success;", "S", "Lau/gov/health/covidsafe/interactor/Either;", "", "success", "(Ljava/lang/Object;)V", "getSuccess", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lau/gov/health/covidsafe/interactor/Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Either.kt */
public final class Success<S> extends Either {
    private final S success;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=S, for r1v0, types: [java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ au.gov.health.covidsafe.interactor.Success copy$default(au.gov.health.covidsafe.interactor.Success r0, S r1, int r2, java.lang.Object r3) {
        /*
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0006
            S r1 = r0.success
        L_0x0006:
            au.gov.health.covidsafe.interactor.Success r0 = r0.copy(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.Success.copy$default(au.gov.health.covidsafe.interactor.Success, java.lang.Object, int, java.lang.Object):au.gov.health.covidsafe.interactor.Success");
    }

    public final S component1() {
        return this.success;
    }

    public final Success<S> copy(S s) {
        return new Success<>(s);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.success, (java.lang.Object) ((au.gov.health.covidsafe.interactor.Success) r2).success) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof au.gov.health.covidsafe.interactor.Success
            if (r0 == 0) goto L_0x0013
            au.gov.health.covidsafe.interactor.Success r2 = (au.gov.health.covidsafe.interactor.Success) r2
            S r0 = r1.success
            S r2 = r2.success
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.Success.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        S s = this.success;
        if (s != null) {
            return s.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Success(success=");
        sb.append(this.success);
        sb.append(")");
        return sb.toString();
    }

    public Success(S s) {
        super(null);
        this.success = s;
    }

    public final S getSuccess() {
        return this.success;
    }
}
