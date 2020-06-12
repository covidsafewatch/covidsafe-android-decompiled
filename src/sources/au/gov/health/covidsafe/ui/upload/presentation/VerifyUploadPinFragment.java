package au.gov.health.covidsafe.ui.upload.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.view.PinInputView;
import au.gov.health.covidsafe.ui.view.UploadingDialog;
import au.gov.health.covidsafe.ui.view.UploadingErrorDialog;
import com.atlassian.mobilekit.module.core.utils.SystemUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010'\u001a\u00020\u0013J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\u0006\u0010*\u001a\u00020\u0013J\b\u0010+\u001a\u00020\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006XD¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000f¨\u0006-"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "dialog", "Landroid/app/Dialog;", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "presenter", "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "hideInvalidOtp", "", "hideKeyboard", "isIncorrectPinFormat", "", "navigateToNextPage", "navigateToRegister", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onStop", "onViewCreated", "view", "showCheckInternetError", "showDialogLoading", "showGenericError", "showInvalidOtp", "updateButtonState", "OnUploadErrorInterface", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinFragment.kt */
public final class VerifyUploadPinFragment extends PagerChildFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Dialog dialog;
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    /* access modifiers changed from: private */
    public VerifyUploadPinPresenter presenter;
    private Integer stepProgress;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;", "", "onNegativeClicked", "", "onPositiveClicked", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: VerifyUploadPinFragment.kt */
    public interface OnUploadErrorInterface {
        void onNegativeClicked();

        void onPositiveClicked();
    }

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

    public static final /* synthetic */ VerifyUploadPinPresenter access$getPresenter$p(VerifyUploadPinFragment verifyUploadPinFragment) {
        VerifyUploadPinPresenter verifyUploadPinPresenter = verifyUploadPinFragment.presenter;
        if (verifyUploadPinPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return verifyUploadPinPresenter;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verify_upload_pin, viewGroup, false);
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

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        this.presenter = new VerifyUploadPinPresenter(this);
    }

    public void onResume() {
        super.onResume();
        ((PinInputView) _$_findCachedViewById(R.id.pin)).setOnPinChanged(new VerifyUploadPinFragment$onResume$1(this));
        ((TextView) _$_findCachedViewById(R.id.header)).sendAccessibilityEvent(8);
    }

    public void onPause() {
        super.onPause();
        ((PinInputView) _$_findCachedViewById(R.id.pin)).setOnPinChanged((Function0<Unit>) null);
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.action_verify_upload_pin, new VerifyUploadPinFragment$getUploadButtonLayout$1(this));
    }

    public void updateButtonState() {
        if (isIncorrectPinFormat()) {
            disableContinueButton();
        } else {
            enableContinueButton();
        }
    }

    private final boolean isIncorrectPinFormat() {
        View requireView = requireView();
        Intrinsics.checkExpressionValueIsNotNull(requireView, "requireView()");
        return ((PinInputView) requireView.findViewById(R.id.pin)).isIncomplete();
    }

    public final void hideKeyboard() {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            SystemUtils.hideSoftKeyboard(currentFocus);
        }
    }

    public final void showInvalidOtp() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.enter_pin_error_label);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "enter_pin_error_label");
        appCompatTextView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void hideInvalidOtp() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.enter_pin_error_label);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "enter_pin_error_label");
        appCompatTextView.setVisibility(8);
    }

    public final void showGenericError() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkExpressionValueIsNotNull(activity, "it");
            Dialog uploadingErrorDialog = new UploadingErrorDialog(activity, new VerifyUploadPinFragment$showGenericError$$inlined$let$lambda$1(this));
            this.dialog = uploadingErrorDialog;
            if (uploadingErrorDialog != null) {
                uploadingErrorDialog.show();
            }
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }

    public final void navigateToRegister() {
        BaseFragment.navigateTo$default(this, VerifyUploadPinFragmentDirections.Companion.actionVerifyUploadPinFragmentToEnterNumberFragment().getActionId(), BundleKt.bundleOf(TuplesKt.to("destination_id", Integer.valueOf(R.id.action_enterPinFragment_to_uploadStepFourFragment))), (Navigator.Extras) null, 4, (Object) null);
    }

    public final void navigateToNextPage() {
        BaseFragment.navigateTo$default(this, R.id.action_verifyUploadPinFragment_to_uploadFinishedFragment, (Bundle) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public final void showDialogLoading() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Dialog uploadingDialog = new UploadingDialog(requireActivity);
        this.dialog = uploadingDialog;
        if (uploadingDialog != null) {
            uploadingDialog.show();
        }
    }

    public final void showCheckInternetError() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        this.dialog = new AlertDialog.Builder(getActivity()).setMessage(R.string.generic_internet_error).setIcon(17301543).setPositiveButton(17039379, (DialogInterface.OnClickListener) null).show();
    }
}
