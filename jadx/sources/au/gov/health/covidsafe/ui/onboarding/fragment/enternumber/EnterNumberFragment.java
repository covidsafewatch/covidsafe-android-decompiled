package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.onboarding.fragment.enterpin.EnterPinFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0018J&\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u001a\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0016J\b\u0010+\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u0004\u0018\u00010\u0006XD¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012¨\u0006-"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "alertDialog", "Landroid/app/AlertDialog;", "destinationId", "", "Ljava/lang/Integer;", "enterNumberPresenter", "Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;", "navigationIcon", "getNavigationIcon", "()Ljava/lang/Integer;", "phoneNumberTextWatcher", "Landroid/text/TextWatcher;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "navigateToOTPPage", "", "session", "", "challengeName", "phoneNumber", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "showCheckInternetError", "showGenericError", "showInvalidPhoneNumber", "updateButtonState", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberFragment.kt */
public final class EnterNumberFragment extends PagerChildFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ENTER_NUMBER_DESTINATION_ID = "destination_id";
    public static final String ENTER_NUMBER_PROGRESS = "progress";
    private HashMap _$_findViewCache;
    private AlertDialog alertDialog;
    private Integer destinationId;
    /* access modifiers changed from: private */
    public final EnterNumberPresenter enterNumberPresenter = new EnterNumberPresenter(this);
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    private final TextWatcher phoneNumberTextWatcher = new EnterNumberFragment$phoneNumberTextWatcher$1(this);
    private Integer stepProgress = 2;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$Companion;", "", "()V", "ENTER_NUMBER_DESTINATION_ID", "", "ENTER_NUMBER_PROGRESS", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: EnterNumberFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Integer getNavigationIcon() {
        return this.navigationIcon;
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_enter_number, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.use_oz_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view.use_oz_phone_number");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.destinationId = Integer.valueOf(arguments.getInt("destination_id"));
            setStepProgress(arguments.containsKey("progress") ? Integer.valueOf(arguments.getInt("progress")) : null);
        }
    }

    public void onResume() {
        super.onResume();
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).selectAll();
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).addTextChangedListener(this.phoneNumberTextWatcher);
        updateButtonState();
    }

    public void onPause() {
        super.onPause();
        ((EditText) _$_findCachedViewById(R.id.enter_number_phone_number)).removeTextChangedListener(this.phoneNumberTextWatcher);
    }

    public final void showInvalidPhoneNumber() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.invalid_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "invalid_phone_number");
        textView.setVisibility(0);
        EditText editText = (EditText) _$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        Context context = getContext();
        editText.setBackground(context != null ? context.getDrawable(R.drawable.phone_number_invalid_background) : null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r1.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateButtonState() {
        /*
            r2 = this;
            au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberPresenter r0 = r2.enterNumberPresenter
            int r1 = au.gov.health.covidsafe.R.id.enter_number_phone_number
            android.view.View r1 = r2._$_findCachedViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0017
            android.text.Editable r1 = r1.getText()
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = r1.toString()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            boolean r0 = r0.validateAuNumber$app_release(r1)
            if (r0 == 0) goto L_0x0022
            r2.enableContinueButton()
            goto L_0x0025
        L_0x0022:
            r2.disableContinueButton()
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.ui.onboarding.fragment.enternumber.EnterNumberFragment.updateButtonState():void");
    }

    public final void showGenericError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }

    public final void navigateToOTPPage(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str3, "phoneNumber");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(EnterPinFragment.ENTER_PIN_SESSION, str), TuplesKt.to(EnterPinFragment.ENTER_PIN_CHALLENGE_NAME, str2), TuplesKt.to(EnterPinFragment.ENTER_PIN_PHONE_NUMBER, str3), TuplesKt.to("destination_id", this.destinationId));
        Integer stepProgress2 = getStepProgress();
        if (stepProgress2 != null) {
            bundleOf.putInt("progress", stepProgress2.intValue() + 1);
        }
        BaseFragment.navigateTo$default(this, R.id.action_enterNumberFragment_to_otpFragment, bundleOf, (Navigator.Extras) null, 4, (Object) null);
    }

    public void onDestroyView() {
        super.onDestroyView();
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.enter_number_button, new EnterNumberFragment$getUploadButtonLayout$1(this));
    }

    public final void showCheckInternetError() {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.alertDialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_internet_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }
}
