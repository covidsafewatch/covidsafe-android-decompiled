package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0018JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006 "}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/GetOtpParams;", "", "phoneNumber", "", "deviceId", "postCode", "age", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge$app_release", "()Ljava/lang/String;", "getDeviceId$app_release", "getName$app_release", "getPhoneNumber$app_release", "getPostCode$app_release", "component1", "component1$app_release", "component2", "component2$app_release", "component3", "component3$app_release", "component4", "component4$app_release", "component5", "component5$app_release", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: GetOnboardingOtp.kt */
public final class GetOtpParams {
    private final String age;
    private final String deviceId;
    private final String name;
    private final String phoneNumber;
    private final String postCode;

    public static /* synthetic */ GetOtpParams copy$default(GetOtpParams getOtpParams, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getOtpParams.phoneNumber;
        }
        if ((i & 2) != 0) {
            str2 = getOtpParams.deviceId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = getOtpParams.postCode;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = getOtpParams.age;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = getOtpParams.name;
        }
        return getOtpParams.copy(str, str6, str7, str8, str5);
    }

    public final String component1$app_release() {
        return this.phoneNumber;
    }

    public final String component2$app_release() {
        return this.deviceId;
    }

    public final String component3$app_release() {
        return this.postCode;
    }

    public final String component4$app_release() {
        return this.age;
    }

    public final String component5$app_release() {
        return this.name;
    }

    public final GetOtpParams copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "phoneNumber");
        Intrinsics.checkParameterIsNotNull(str2, "deviceId");
        return new GetOtpParams(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOtpParams)) {
            return false;
        }
        GetOtpParams getOtpParams = (GetOtpParams) obj;
        return Intrinsics.areEqual((Object) this.phoneNumber, (Object) getOtpParams.phoneNumber) && Intrinsics.areEqual((Object) this.deviceId, (Object) getOtpParams.deviceId) && Intrinsics.areEqual((Object) this.postCode, (Object) getOtpParams.postCode) && Intrinsics.areEqual((Object) this.age, (Object) getOtpParams.age) && Intrinsics.areEqual((Object) this.name, (Object) getOtpParams.name);
    }

    public int hashCode() {
        String str = this.phoneNumber;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.postCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.age;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.name;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "GetOtpParams(phoneNumber=" + this.phoneNumber + ", deviceId=" + this.deviceId + ", postCode=" + this.postCode + ", age=" + this.age + ", name=" + this.name + ")";
    }

    public GetOtpParams(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, "phoneNumber");
        Intrinsics.checkParameterIsNotNull(str2, "deviceId");
        this.phoneNumber = str;
        this.deviceId = str2;
        this.postCode = str3;
        this.age = str4;
        this.name = str5;
    }

    public final String getPhoneNumber$app_release() {
        return this.phoneNumber;
    }

    public final String getDeviceId$app_release() {
        return this.deviceId;
    }

    public final String getPostCode$app_release() {
        return this.postCode;
    }

    public final String getAge$app_release() {
        return this.age;
    }

    public final String getName$app_release() {
        return this.name;
    }
}
