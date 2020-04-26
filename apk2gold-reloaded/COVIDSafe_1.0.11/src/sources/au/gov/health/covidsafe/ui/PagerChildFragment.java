package au.gov.health.covidsafe.ui;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.ui.UploadButtonLayout.ContinueLayout;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\u000fH&J\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\fH\u0016J\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lau/gov/health/covidsafe/ui/PagerChildFragment;", "Lau/gov/health/covidsafe/ui/BaseFragment;", "()V", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "disableContinueButton", "", "enableContinueButton", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "hideLoading", "onResume", "showLoading", "updateButton", "updateButtonState", "updateProgressBar", "updateToolBar", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PagerChildFragment.kt */
public abstract class PagerChildFragment extends BaseFragment {
    private HashMap _$_findViewCache;

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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public abstract Integer getNavigationIcon();

    public abstract Integer getStepProgress();

    public abstract UploadButtonLayout getUploadButtonLayout();

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public abstract void setStepProgress(Integer num);

    public abstract void updateButtonState();

    public void onResume() {
        super.onResume();
        updateToolBar();
        updateButton();
        updateProgressBar();
        updateButtonState();
    }

    private final void updateProgressBar() {
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.updateProgressBar(getStepProgress());
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.updateProgressBar(getStepProgress());
        }
    }

    private final void updateToolBar() {
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.setNavigationIcon(getNavigationIcon());
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.setNavigationIcon(getNavigationIcon());
        }
    }

    private final void updateButton() {
        UploadButtonLayout uploadButtonLayout = getUploadButtonLayout();
        if (uploadButtonLayout instanceof ContinueLayout) {
            updateButtonState();
        }
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.refreshButton(uploadButtonLayout);
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.refreshButton(uploadButtonLayout);
        }
    }

    public final void enableContinueButton() {
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.enableNextButton();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.enableNextButton();
        }
    }

    public final void disableContinueButton() {
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.disableNextButton();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.disableNextButton();
        }
    }

    public final void showLoading() {
        Fragment parentFragment = getParentFragment();
        PagerContainer pagerContainer = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) parentFragment2;
        if (pagerContainer2 != null) {
            pagerContainer2.showLoading();
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof PagerContainer) {
            pagerContainer = activity;
        }
        PagerContainer pagerContainer3 = pagerContainer;
        if (pagerContainer3 != null) {
            pagerContainer3.showLoading();
        }
    }

    public final void hideLoading() {
        Fragment parentFragment = getParentFragment();
        Integer num = null;
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof PagerContainer)) {
            parentFragment2 = null;
        }
        PagerContainer pagerContainer = (PagerContainer) parentFragment2;
        if (pagerContainer != null) {
            UploadButtonLayout uploadButtonLayout = getUploadButtonLayout();
            if (!(uploadButtonLayout instanceof ContinueLayout)) {
                uploadButtonLayout = null;
            }
            ContinueLayout continueLayout = (ContinueLayout) uploadButtonLayout;
            pagerContainer.hideLoading(continueLayout != null ? Integer.valueOf(continueLayout.getButtonText()) : null);
        }
        FragmentActivity activity = getActivity();
        if (!(activity instanceof PagerContainer)) {
            activity = null;
        }
        PagerContainer pagerContainer2 = (PagerContainer) activity;
        if (pagerContainer2 != null) {
            UploadButtonLayout uploadButtonLayout2 = getUploadButtonLayout();
            if (!(uploadButtonLayout2 instanceof ContinueLayout)) {
                uploadButtonLayout2 = null;
            }
            ContinueLayout continueLayout2 = (ContinueLayout) uploadButtonLayout2;
            if (continueLayout2 != null) {
                num = Integer.valueOf(continueLayout2.getButtonText());
            }
            pagerContainer2.hideLoading(num);
        }
    }
}
