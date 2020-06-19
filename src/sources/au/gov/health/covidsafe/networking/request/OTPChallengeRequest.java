package au.gov.health.covidsafe.networking.request;

import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lau/gov/health/covidsafe/networking/request/OTPChallengeRequest;", "", "country_code", "", "phone_number", "device_id", "postcode", "age", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "getCountry_code", "getDevice_id", "getName", "getPhone_number", "getPostcode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: OTPChallengeRequest.kt */
public final class OTPChallengeRequest {
    private final String age;
    private final String country_code;
    private final String device_id;
    private final String name;
    private final String phone_number;
    private final String postcode;

    public static /* synthetic */ OTPChallengeRequest copy$default(OTPChallengeRequest oTPChallengeRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oTPChallengeRequest.country_code;
        }
        if ((i & 2) != 0) {
            str2 = oTPChallengeRequest.phone_number;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = oTPChallengeRequest.device_id;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = oTPChallengeRequest.postcode;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = oTPChallengeRequest.age;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = oTPChallengeRequest.name;
        }
        return oTPChallengeRequest.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.country_code;
    }

    public final String component2() {
        return this.phone_number;
    }

    public final String component3() {
        return this.device_id;
    }

    public final String component4() {
        return this.postcode;
    }

    public final String component5() {
        return this.age;
    }

    public final String component6() {
        return this.name;
    }

    public final OTPChallengeRequest copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "country_code");
        Intrinsics.checkParameterIsNotNull(str2, EnterPinFragment.ENTER_PIN_PHONE_NUMBER);
        Intrinsics.checkParameterIsNotNull(str3, "device_id");
        return new OTPChallengeRequest(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTPChallengeRequest)) {
            return false;
        }
        OTPChallengeRequest oTPChallengeRequest = (OTPChallengeRequest) obj;
        return Intrinsics.areEqual((Object) this.country_code, (Object) oTPChallengeRequest.country_code) && Intrinsics.areEqual((Object) this.phone_number, (Object) oTPChallengeRequest.phone_number) && Intrinsics.areEqual((Object) this.device_id, (Object) oTPChallengeRequest.device_id) && Intrinsics.areEqual((Object) this.postcode, (Object) oTPChallengeRequest.postcode) && Intrinsics.areEqual((Object) this.age, (Object) oTPChallengeRequest.age) && Intrinsics.areEqual((Object) this.name, (Object) oTPChallengeRequest.name);
    }

    public int hashCode() {
        String str = this.country_code;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.phone_number;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.device_id;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.postcode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.age;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "OTPChallengeRequest(country_code=" + this.country_code + ", phone_number=" + this.phone_number + ", device_id=" + this.device_id + ", postcode=" + this.postcode + ", age=" + this.age + ", name=" + this.name + ")";
    }

    public OTPChallengeRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkParameterIsNotNull(str, "country_code");
        Intrinsics.checkParameterIsNotNull(str2, EnterPinFragment.ENTER_PIN_PHONE_NUMBER);
        Intrinsics.checkParameterIsNotNull(str3, "device_id");
        this.country_code = str;
        this.phone_number = str2;
        this.device_id = str3;
        this.postcode = str4;
        this.age = str5;
        this.name = str6;
    }

    public final String getCountry_code() {
        return this.country_code;
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
