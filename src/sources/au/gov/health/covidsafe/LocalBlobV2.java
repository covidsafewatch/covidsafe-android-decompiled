package au.gov.health.covidsafe;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lau/gov/health/covidsafe/LocalBlobV2;", "", "modelP", "", "modelC", "txPower", "", "rssi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getModelC", "()Ljava/lang/String;", "getModelP", "getRssi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTxPower", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LocalBlobV2.kt */
public final class LocalBlobV2 {
    private final String modelC;
    private final String modelP;
    private final Integer rssi;
    private final Integer txPower;

    public LocalBlobV2(String str, String str2, Integer num, Integer num2) {
        this.modelP = str;
        this.modelC = str2;
        this.txPower = num;
        this.rssi = num2;
    }

    public final String getModelC() {
        return this.modelC;
    }

    public final String getModelP() {
        return this.modelP;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final Integer getTxPower() {
        return this.txPower;
    }
}
