package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0016J\b\u0010*\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "age", "", "ageSelected", "Lkotlin/Pair;", "", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "name", "navigationIcon", "getNavigationIcon", "()Ljava/lang/Integer;", "picker", "Landroid/widget/NumberPicker;", "postcode", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "isFullName", "", "isValidAge", "isValidPostcode", "navigateToNextPage", "", "isUnder16", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "updateButtonState", "updatePersonalDetailsDataField", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
public final class PersonalDetailsFragment extends PagerChildFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int age = -1;
    /* access modifiers changed from: private */
    public Pair<Integer, String> ageSelected = new Pair<>(-1, "");
    /* access modifiers changed from: private */
    public AlertDialog alertDialog;
    /* access modifiers changed from: private */
    public String name;
    private final int navigationIcon = R.drawable.ic_up;
    /* access modifiers changed from: private */
    public NumberPicker picker;
    /* access modifiers changed from: private */
    public String postcode;
    private Integer stepProgress = 1;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ String access$getName$p(PersonalDetailsFragment personalDetailsFragment) {
        String str = personalDetailsFragment.name;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
        }
        return str;
    }

    public static final /* synthetic */ String access$getPostcode$p(PersonalDetailsFragment personalDetailsFragment) {
        String str = personalDetailsFragment.postcode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postcode");
        }
        return str;
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    public Integer getNavigationIcon() {
        return Integer.valueOf(this.navigationIcon);
    }

    /* access modifiers changed from: private */
    public final void updatePersonalDetailsDataField() {
        EditText editText = (EditText) _$_findCachedViewById(R.id.personal_details_name);
        Intrinsics.checkExpressionValueIsNotNull(editText, "personal_details_name");
        this.name = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.personal_details_post_code);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "personal_details_post_code");
        this.postcode = editText2.getText().toString();
        this.age = this.ageSelected.getFirst().intValue();
    }

    /* access modifiers changed from: private */
    public final boolean isFullName() {
        String str = this.name;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("name");
        }
        if (str != null) {
            return StringsKt.trim((CharSequence) str).toString().length() > 1;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    /* access modifiers changed from: private */
    public final boolean isValidAge() {
        return this.age >= 0;
    }

    /* access modifiers changed from: private */
    public final boolean isValidPostcode() {
        String str = this.postcode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postcode");
        }
        if (str.length() == 4) {
            Pattern access$getPOST_CODE_REGEX$p = PersonalDetailsFragmentKt.POST_CODE_REGEX;
            String str2 = this.postcode;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postcode");
            }
            if (access$getPOST_CODE_REGEX$p.matcher(str2).matches()) {
                return true;
            }
        }
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_personal_details, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        ((EditText) _$_findCachedViewById(R.id.personal_details_age)).setText(this.ageSelected.getSecond());
        PersonalDetailsFragment$onResume$1 personalDetailsFragment$onResume$1 = new PersonalDetailsFragment$onResume$1(this);
        ((EditText) _$_findCachedViewById(R.id.personal_details_name)).setOnFocusChangeListener(new PersonalDetailsFragment$onResume$2(this));
        ((EditText) _$_findCachedViewById(R.id.personal_details_post_code)).setOnFocusChangeListener(new PersonalDetailsFragment$onResume$3(this));
        ((EditText) _$_findCachedViewById(R.id.personal_details_post_code)).setOnEditorActionListener(new PersonalDetailsFragment$onResume$4(this));
        ((EditText) _$_findCachedViewById(R.id.personal_details_age)).setOnFocusChangeListener(new PersonalDetailsFragment$onResume$5(personalDetailsFragment$onResume$1));
        ((EditText) _$_findCachedViewById(R.id.personal_details_age)).setOnClickListener(new PersonalDetailsFragment$onResume$6(personalDetailsFragment$onResume$1));
        ((TextView) _$_findCachedViewById(R.id.personal_details_headline)).sendAccessibilityEvent(8);
    }

    public void onPause() {
        super.onPause();
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
    }

    public UploadButtonLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.personal_details_button, new PersonalDetailsFragment$getUploadButtonLayout$1(this));
    }

    public void updateButtonState() {
        updatePersonalDetailsDataField();
        if (!isFullName() || !isValidAge() || !isValidPostcode()) {
            disableContinueButton();
        } else {
            enableContinueButton();
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToNextPage(boolean z) {
        if (z) {
            BaseFragment.navigateTo$default(this, PersonalDetailsFragmentDirections.Companion.actionPersonalDetailsToUnderSixteenFragment().getActionId(), (Bundle) null, (Navigator.Extras) null, 6, (Object) null);
            return;
        }
        BaseFragment.navigateTo$default(this, PersonalDetailsFragmentDirections.Companion.actionPersonalDetailsToEnterNumberFragment().getActionId(), BundleKt.bundleOf(TuplesKt.to("destination_id", Integer.valueOf(R.id.action_otpFragment_to_permissionFragment)), TuplesKt.to("progress", 2)), (Navigator.Extras) null, 4, (Object) null);
    }
}
