package au.gov.health.covidsafe.ui.onboarding.fragment.permission;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.navigation.Navigator;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004XD¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionDeviceNameFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$TwoChoiceContinueLayout;", "navigateToNextPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "updateButtonState", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PermissionDeviceNameFragment.kt */
public final class PermissionDeviceNameFragment extends PagerChildFragment {
    private HashMap _$_findViewCache;
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    private Integer stepProgress = 5;

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
        return layoutInflater.inflate(R.layout.fragment_permission_device_name, viewGroup, false);
    }

    public void onResume() {
        CharSequence charSequence;
        super.onResume();
        Context context = getContext();
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<b>");
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            sb.append(defaultAdapter != null ? defaultAdapter.getName() : null);
            sb.append("</b>");
            String string = context.getString(R.string.change_device_name_content_line_1, new Object[]{sb.toString()});
            Intrinsics.checkExpressionValueIsNotNull(string, "it.getString(R.string.ch…ntent_line_1, deviceName)");
            String str = string + ("<br/><br/>" + context.getString(R.string.change_device_name_content_line_2));
            TextView textView = (TextView) _$_findCachedViewById(R.id.change_device_name_content);
            Intrinsics.checkExpressionValueIsNotNull(textView, "change_device_name_content");
            if (Build.VERSION.SDK_INT >= 24) {
                charSequence = Html.fromHtml(str, 63);
            } else {
                charSequence = Html.fromHtml(str);
            }
            textView.setText(charSequence);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToNextPage() {
        BaseFragment.navigateTo$default(this, R.id.action_permissionDeviceNameFragment_to_permissionSuccessFragment, (Bundle) null, (Navigator.Extras) null, 6, (Object) null);
    }

    public UploadButtonLayout.TwoChoiceContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.TwoChoiceContinueLayout(R.string.change_device_name_primary_action, new PermissionDeviceNameFragment$getUploadButtonLayout$1(this), R.string.change_device_name_secondary_action, new PermissionDeviceNameFragment$getUploadButtonLayout$2(this));
    }

    public void updateButtonState() {
        enableContinueButton();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((ScrollView) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }
}
