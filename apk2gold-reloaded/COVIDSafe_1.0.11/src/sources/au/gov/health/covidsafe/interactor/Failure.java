package au.gov.health.covidsafe.interactor;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lau/gov/health/covidsafe/interactor/Failure;", "F", "Lau/gov/health/covidsafe/interactor/Either;", "", "failure", "(Ljava/lang/Object;)V", "getFailure", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lau/gov/health/covidsafe/interactor/Failure;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Either.kt */
public final class Failure<F> extends Either {
    private final F failure;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=F, for r1v0, types: [java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ au.gov.health.covidsafe.interactor.Failure copy$default(au.gov.health.covidsafe.interactor.Failure r0, F r1, int r2, java.lang.Object r3) {
        /*
            r2 = r2 & 1
            if (r2 == 0) goto L_0x0006
            F r1 = r0.failure
        L_0x0006:
            au.gov.health.covidsafe.interactor.Failure r0 = r0.copy(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.Failure.copy$default(au.gov.health.covidsafe.interactor.Failure, java.lang.Object, int, java.lang.Object):au.gov.health.covidsafe.interactor.Failure");
    }

    public final F component1() {
        return this.failure;
    }

    public final Failure<F> copy(F f) {
        return new Failure<>(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.failure, (java.lang.Object) ((au.gov.health.covidsafe.interactor.Failure) r2).failure) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof au.gov.health.covidsafe.interactor.Failure
            if (r0 == 0) goto L_0x0013
            au.gov.health.covidsafe.interactor.Failure r2 = (au.gov.health.covidsafe.interactor.Failure) r2
            F r0 = r1.failure
            F r2 = r2.failure
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
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.Failure.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        F f = this.failure;
        if (f != null) {
            return f.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Failure(failure=");
        sb.append(this.failure);
        sb.append(")");
        return sb.toString();
    }

    public Failure(F f) {
        super(null);
        this.failure = f;
    }

    public final F getFailure() {
        return this.failure;
    }
}
