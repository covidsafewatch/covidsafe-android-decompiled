package au.gov.health.covidsafe.ui.upload;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.PagerContainer;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.view.SegmentedProgressBar;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.github.razir.progressbutton.ProgressParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0019\u0010\u0007\u001a\u00020\u00052\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0017\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u001e"}, d2 = {"Lau/gov/health/covidsafe/ui/upload/UploadContainerFragment;", "Landroidx/fragment/app/Fragment;", "Lau/gov/health/covidsafe/ui/PagerContainer;", "()V", "disableNextButton", "", "enableNextButton", "hideLoading", "stringRes", "", "(Ljava/lang/Integer;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "refreshButton", "uploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "setNavigationIcon", "navigationIcon", "showLoading", "updateProgressBar", "stepProgress", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UploadContainerFragment.kt */
public final class UploadContainerFragment extends Fragment implements PagerContainer {
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_upload_master, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener(new UploadContainerFragment$onResume$1(this));
    }

    public void onPause() {
        super.onPause();
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener((View.OnClickListener) null);
    }

    public void updateProgressBar(Integer num) {
        if (num == null) {
            SegmentedProgressBar segmentedProgressBar = (SegmentedProgressBar) _$_findCachedViewById(R.id.upload_progress);
            Intrinsics.checkExpressionValueIsNotNull(segmentedProgressBar, "upload_progress");
            segmentedProgressBar.setVisibility(4);
            return;
        }
        SegmentedProgressBar segmentedProgressBar2 = (SegmentedProgressBar) _$_findCachedViewById(R.id.upload_progress);
        Intrinsics.checkExpressionValueIsNotNull(segmentedProgressBar2, "upload_progress");
        segmentedProgressBar2.setVisibility(0);
        ((SegmentedProgressBar) _$_findCachedViewById(R.id.upload_progress)).setProgress(num.intValue());
    }

    public void setNavigationIcon(Integer num) {
        if (num == null) {
            Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(R.id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar2, "toolbar");
            toolbar2.setNavigationIcon(ContextCompat.getDrawable(activity, num.intValue()));
        }
    }

    public void refreshButton(UploadButtonLayout uploadButtonLayout) {
        Intrinsics.checkParameterIsNotNull(uploadButtonLayout, "uploadButtonLayout");
        if (uploadButtonLayout instanceof UploadButtonLayout.ContinueLayout) {
            ((Button) _$_findCachedViewById(R.id.upload_continue)).setOnClickListener(new UploadContainerFragment$refreshButton$1(uploadButtonLayout));
            ((Button) _$_findCachedViewById(R.id.upload_continue)).setText(((UploadButtonLayout.ContinueLayout) uploadButtonLayout).getButtonText());
            Button button = (Button) _$_findCachedViewById(R.id.upload_continue);
            Intrinsics.checkExpressionValueIsNotNull(button, "upload_continue");
            button.setVisibility(0);
        }
    }

    public void enableNextButton() {
        Button button = (Button) _$_findCachedViewById(R.id.upload_continue);
        Intrinsics.checkExpressionValueIsNotNull(button, "upload_continue");
        button.setEnabled(true);
    }

    public void disableNextButton() {
        Button button = (Button) _$_findCachedViewById(R.id.upload_continue);
        Intrinsics.checkExpressionValueIsNotNull(button, "upload_continue");
        button.setEnabled(false);
    }

    public void showLoading() {
        Button button = (Button) _$_findCachedViewById(R.id.upload_continue);
        Intrinsics.checkExpressionValueIsNotNull(button, "upload_continue");
        DrawableButtonExtensionsKt.showProgress((TextView) button, (Function1<? super ProgressParams, Unit>) UploadContainerFragment$showLoading$1.INSTANCE);
    }

    public void hideLoading(Integer num) {
        if (num == null) {
            Button button = (Button) _$_findCachedViewById(R.id.upload_continue);
            Intrinsics.checkExpressionValueIsNotNull(button, "upload_continue");
            DrawableButtonExtensionsKt.hideProgress$default(button, (String) null, 1, (Object) null);
            return;
        }
        Button button2 = (Button) _$_findCachedViewById(R.id.upload_continue);
        Intrinsics.checkExpressionValueIsNotNull(button2, "upload_continue");
        DrawableButtonExtensionsKt.hideProgress((TextView) button2, num.intValue());
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((LinearLayout) _$_findCachedViewById(R.id.root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }
}
