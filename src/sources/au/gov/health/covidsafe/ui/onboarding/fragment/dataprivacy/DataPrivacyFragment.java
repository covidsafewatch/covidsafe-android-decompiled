package au.gov.health.covidsafe.ui.onboarding.fragment.dataprivacy;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004XD¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/dataprivacy/DataPrivacyFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onResume", "onViewCreated", "view", "updateButtonState", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DataPrivacyFragment.kt */
public final class DataPrivacyFragment extends PagerChildFragment {
    private HashMap _$_findViewCache;
    private final Integer navigationIcon = Integer.valueOf(R.drawable.ic_up);
    private Integer stepProgress;

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
        return layoutInflater.inflate(R.layout.fragment_data_privacy, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.data_privacy_content);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view.data_privacy_content");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onResume() {
        super.onResume();
        ((TextView) _$_findCachedViewById(R.id.data_privacy_headline)).sendAccessibilityEvent(8);
    }

    public UploadButtonLayout.ContinueLayout getUploadButtonLayout() {
        return new UploadButtonLayout.ContinueLayout(R.string.data_privacy_button, new DataPrivacyFragment$getUploadButtonLayout$1(this));
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
