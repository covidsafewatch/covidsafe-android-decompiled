package au.gov.health.covidsafe.networking.request;

import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;", "", "phone_number", "", "device_id", "postcode", "age", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "getDevice_id", "getName", "getPhone_number", "getPostcode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: OTPChallengeRequest.kt */
public final class OTPChallengeRequest {
    private final String age;
    private final String device_id;
    private final String name;
    private final String phone_number;
    private final String postcode;

    public static /* synthetic */ OTPChallengeRequest copy$default(OTPChallengeRequest oTPChallengeRequest, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oTPChallengeRequest.phone_number;
        }
        if ((i & 2) != 0) {
            str2 = oTPChallengeRequest.device_id;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = oTPChallengeRequest.postcode;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = oTPChallengeRequest.age;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = oTPChallengeRequest.name;
        }
        return oTPChallengeRequest.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.phone_number;
    }

    public final String component2() {
        return this.device_id;
    }

    public final String component3() {
        return this.postcode;
    }

    public final String component4() {
        return this.age;
    }

    public final String component5() {
        return this.name;
    }

    public final OTPChallengeRequest copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, EnterPinFragment.ENTER_PIN_PHONE_NUMBER);
        Intrinsics.checkParameterIsNotNull(str2, "device_id");
        return new OTPChallengeRequest(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTPChallengeRequest)) {
            return false;
        }
        OTPChallengeRequest oTPChallengeRequest = (OTPChallengeRequest) obj;
        return Intrinsics.areEqual((Object) this.phone_number, (Object) oTPChallengeRequest.phone_number) && Intrinsics.areEqual((Object) this.device_id, (Object) oTPChallengeRequest.device_id) && Intrinsics.areEqual((Object) this.postcode, (Object) oTPChallengeRequest.postcode) && Intrinsics.areEqual((Object) this.age, (Object) oTPChallengeRequest.age) && Intrinsics.areEqual((Object) this.name, (Object) oTPChallengeRequest.name);
    }

    public int hashCode() {
        String str = this.phone_number;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.device_id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.postcode;
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
        return "OTPChallengeRequest(phone_number=" + this.phone_number + ", device_id=" + this.device_id + ", postcode=" + this.postcode + ", age=" + this.age + ", name=" + this.name + ")";
    }

    public OTPChallengeRequest(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(str, EnterPinFragment.ENTER_PIN_PHONE_NUMBER);
        Intrinsics.checkParameterIsNotNull(str2, "device_id");
        this.phone_number = str;
        this.device_id = str2;
        this.postcode = str3;
        this.age = str4;
        this.name = str5;
    }

    public final String getPhone_number() {
        return this.phone_number;
    }

    public final String getDevice_id() {
        return this.device_id;
    }

    public final String getPostcode() {
        return this.postcode;
    }

    public final String getAge() {
        return this.age;
    }

    public final String getName() {
        return this.name;
    }
}
