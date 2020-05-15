package au.gov.health.covidsafe.streetpass.view;

import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;", "", "record", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V", "number", "", "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V", "modelC", "", "getModelC", "()Ljava/lang/String;", "modelP", "getModelP", "msg", "getMsg", "getNumber", "()I", "org", "getOrg", "rssi", "getRssi", "timeStamp", "", "getTimeStamp", "()J", "transmissionPower", "getTransmissionPower", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "version", "getVersion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassRecordViewModel.kt */
public final class StreetPassRecordViewModel {
    private final String modelC;
    private final String modelP;
    private final String msg;
    private final int number;

    /* renamed from: org  reason: collision with root package name */
    private final String f9org;
    private final int rssi;
    private final long timeStamp;
    private final Integer transmissionPower;
    private final int version;

    public StreetPassRecordViewModel(StreetPassRecord streetPassRecord, int i) {
        Intrinsics.checkParameterIsNotNull(streetPassRecord, "record");
        this.number = i;
        this.version = streetPassRecord.getV();
        this.modelC = streetPassRecord.getModelC();
        this.modelP = streetPassRecord.getModelP();
        this.msg = streetPassRecord.getMsg();
        this.timeStamp = streetPassRecord.getTimestamp();
        this.rssi = streetPassRecord.getRssi();
        this.transmissionPower = streetPassRecord.getTxPower();
        this.f9org = streetPassRecord.getOrg();
    }

    public final int getNumber() {
        return this.number;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getModelC() {
        return this.modelC;
    }

    public final String getModelP() {
        return this.modelP;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final Integer getTransmissionPower() {
        return this.transmissionPower;
    }

    public final String getOrg() {
        return this.f9org;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StreetPassRecordViewModel(StreetPassRecord streetPassRecord) {
        this(streetPassRecord, 1);
        Intrinsics.checkParameterIsNotNull(streetPassRecord, "record");
    }
}
