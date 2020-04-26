package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ&\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\u0017\u0010\u0015\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u0016J$\u0010\u0017\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;", "", "personalDetailsFragment", "Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;", "(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V", "POST_CODE_REGEX", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "TAG", "", "isPostCodeValid", "", "postCode", "saveInfos", "", "name", "age", "showFieldsError", "updateAgeFieldError", "updateNameFieldError", "updatePostcodeFieldError", "validateInlinePostCode", "validateInlinePostCode$app_release", "validateInputsForButtonUpdate", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PersonalDetailsPresenter.kt */
public final class PersonalDetailsPresenter {
    private final Pattern POST_CODE_REGEX = Pattern.compile("^(?:(?:[2-8]\\d|9[0-7]|0?[28]|0?9(?=09))(?:\\d{2}))$");
    private final String TAG;
    private final PersonalDetailsFragment personalDetailsFragment;

    public PersonalDetailsPresenter(PersonalDetailsFragment personalDetailsFragment2) {
        Intrinsics.checkParameterIsNotNull(personalDetailsFragment2, "personalDetailsFragment");
        this.personalDetailsFragment = personalDetailsFragment2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void saveInfos(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = this;
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r0 = r7.personalDetailsFragment
            r0.showLoading()
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r0 = r7.personalDetailsFragment
            android.content.Context r0 = r0.getContext()
            if (r0 == 0) goto L_0x00b9
            if (r10 == 0) goto L_0x0014
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r10)
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r2 = r8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0025
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r2 = r4
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            r2 = r2 ^ r3
            r5 = r9
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0035
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r5 = r4
            goto L_0x0036
        L_0x0035:
            r5 = r3
        L_0x0036:
            if (r5 != 0) goto L_0x0040
            boolean r5 = r7.isPostCodeValid(r9)
            if (r5 == 0) goto L_0x0040
            r5 = r3
            goto L_0x0041
        L_0x0040:
            r5 = r4
        L_0x0041:
            r6 = r10
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x004f
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            if (r6 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r6 = r4
            goto L_0x0050
        L_0x004f:
            r6 = r3
        L_0x0050:
            r6 = r6 ^ r3
            if (r2 == 0) goto L_0x00b0
            if (r5 == 0) goto L_0x00b0
            if (r6 == 0) goto L_0x00b0
            java.lang.String r2 = "context"
            if (r8 == 0) goto L_0x0065
            au.gov.health.covidsafe.Preference r5 = au.gov.health.covidsafe.Preference.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            boolean r8 = r5.putName(r0, r8)
            goto L_0x0066
        L_0x0065:
            r8 = r4
        L_0x0066:
            if (r8 == 0) goto L_0x0088
            if (r10 == 0) goto L_0x0074
            au.gov.health.covidsafe.Preference r8 = au.gov.health.covidsafe.Preference.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            boolean r8 = r8.putAge(r0, r10)
            goto L_0x0075
        L_0x0074:
            r8 = r4
        L_0x0075:
            if (r8 == 0) goto L_0x0088
            if (r9 == 0) goto L_0x0083
            au.gov.health.covidsafe.Preference r8 = au.gov.health.covidsafe.Preference.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            boolean r8 = r8.putPostCode(r0, r9)
            goto L_0x0084
        L_0x0083:
            r8 = r4
        L_0x0084:
            if (r8 == 0) goto L_0x0088
            r8 = r3
            goto L_0x0089
        L_0x0088:
            r8 = r4
        L_0x0089:
            if (r8 == 0) goto L_0x00a5
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r7.personalDetailsFragment
            r8.hideLoading()
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r7.personalDetailsFragment
            if (r1 == 0) goto L_0x00a1
            java.lang.Number r1 = (java.lang.Number) r1
            int r9 = r1.intValue()
            r10 = 16
            if (r9 >= r10) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r3 = r4
        L_0x00a0:
            r4 = r3
        L_0x00a1:
            r8.navigateToNextPage(r4)
            goto L_0x00c6
        L_0x00a5:
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r7.personalDetailsFragment
            r8.hideLoading()
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r7.personalDetailsFragment
            r8.showGenericError()
            goto L_0x00c6
        L_0x00b0:
            r7.showFieldsError(r8, r9, r10)
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r7.personalDetailsFragment
            r8.hideLoading()
            goto L_0x00c6
        L_0x00b9:
            r8 = r7
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsPresenter r8 = (au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsPresenter) r8
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r9 = r8.personalDetailsFragment
            r9.hideLoading()
            au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsFragment r8 = r8.personalDetailsFragment
            r8.showGenericError()
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.ui.onboarding.fragment.personal.PersonalDetailsPresenter.saveInfos(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final void showFieldsError(String str, String str2, String str3) {
        updateNameFieldError(str);
        updateAgeFieldError(str3);
        updatePostcodeFieldError(str2);
    }

    private final void updateAgeFieldError(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.personalDetailsFragment.showAgeError();
        } else {
            this.personalDetailsFragment.hideAgeError();
        }
    }

    private final void updateNameFieldError(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.personalDetailsFragment.showNameError();
        } else {
            this.personalDetailsFragment.hideNameError();
        }
    }

    private final void updatePostcodeFieldError(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.personalDetailsFragment.showPostcodeError();
        } else {
            this.personalDetailsFragment.hidePostcodeError();
        }
    }

    public final boolean validateInputsForButtonUpdate(String str, String str2, String str3) {
        CharSequence charSequence = str;
        boolean z = !(charSequence == null || StringsKt.isBlank(charSequence));
        CharSequence charSequence2 = str2;
        boolean z2 = !(charSequence2 == null || StringsKt.isBlank(charSequence2)) && isPostCodeValid(str2);
        CharSequence charSequence3 = str3;
        boolean z3 = !(charSequence3 == null || StringsKt.isBlank(charSequence3));
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    public final void validateInlinePostCode$app_release(String str) {
        CharSequence charSequence = str;
        if ((charSequence == null || charSequence.length() == 0) || str.length() != 4 || isPostCodeValid(str)) {
            this.personalDetailsFragment.hidePostcodeError();
        } else {
            this.personalDetailsFragment.showPostcodeError();
        }
    }

    private final boolean isPostCodeValid(String str) {
        return this.POST_CODE_REGEX.matcher(String.valueOf(str)).matches();
    }
}
