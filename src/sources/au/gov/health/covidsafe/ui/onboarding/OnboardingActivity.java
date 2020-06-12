package au.gov.health.covidsafe.ui.onboarding;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.HasBlockingState;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.PagerContainer;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.view.SegmentedProgressBar;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.github.razir.progressbutton.ProgressButtonHolderKt;
import com.github.razir.progressbutton.ProgressParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0019\u0010\u000e\u001a\u00020\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u001f\u001a\u00020\fH\u0016J\u0017\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lau/gov/health/covidsafe/HasBlockingState;", "Lau/gov/health/covidsafe/ui/PagerContainer;", "()V", "value", "", "isUiBlocked", "()Z", "setUiBlocked", "(Z)V", "disableNextButton", "", "enableNextButton", "hideLoading", "stringRes", "", "(Ljava/lang/Integer;)V", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "refreshButton", "updateButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "setNavigationIcon", "navigationIcon", "showLoading", "updateProgressBar", "stepProgress", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: OnboardingActivity.kt */
public final class OnboardingActivity extends FragmentActivity implements HasBlockingState, PagerContainer {
    private HashMap _$_findViewCache;
    private boolean isUiBlocked;

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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public boolean isUiBlocked() {
        return this.isUiBlocked;
    }

    public void setUiBlocked(boolean z) {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.loadingProgressBarFrame);
        if (frameLayout != null) {
            ViewKt.setVisible(frameLayout, z);
        }
        this.isUiBlocked = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        FrameLayout frameLayout;
        super.onCreate(bundle);
        setContentView(R.layout.activity_onboarding);
        Button button = (Button) _$_findCachedViewById(R.id.onboarding_next);
        Intrinsics.checkExpressionValueIsNotNull(button, "onboarding_next");
        ProgressButtonHolderKt.bindProgressButton(this, button);
        if (isUiBlocked() && (frameLayout = (FrameLayout) _$_findCachedViewById(R.id.loadingProgressBarFrame)) != null) {
            ViewKt.setVisible(frameLayout, true);
        }
    }

    public void onAttachFragment(Fragment fragment) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        super.onAttachFragment(fragment);
        setUiBlocked(false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener(new OnboardingActivity$onResume$1(this));
    }

    public void updateProgressBar(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            SegmentedProgressBar segmentedProgressBar = (SegmentedProgressBar) _$_findCachedViewById(R.id.onboarding_progress_bar);
            Intrinsics.checkExpressionValueIsNotNull(segmentedProgressBar, "onboarding_progress_bar");
            segmentedProgressBar.setVisibility(0);
            ((SegmentedProgressBar) _$_findCachedViewById(R.id.onboarding_progress_bar)).setProgress(intValue);
            return;
        }
        SegmentedProgressBar segmentedProgressBar2 = (SegmentedProgressBar) _$_findCachedViewById(R.id.onboarding_progress_bar);
        Intrinsics.checkExpressionValueIsNotNull(segmentedProgressBar2, "onboarding_progress_bar");
        segmentedProgressBar2.setVisibility(8);
    }

    public void setNavigationIcon(Integer num) {
        if (num == null) {
            Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar2, "toolbar");
        toolbar2.setNavigationIcon(ContextCompat.getDrawable(this, num.intValue()));
    }

    public void refreshButton(UploadButtonLayout uploadButtonLayout) {
        Intrinsics.checkParameterIsNotNull(uploadButtonLayout, "updateButtonLayout");
        if (uploadButtonLayout instanceof UploadButtonLayout.ContinueLayout) {
            ((Button) _$_findCachedViewById(R.id.onboarding_next)).setText(((UploadButtonLayout.ContinueLayout) uploadButtonLayout).getButtonText());
            ((Button) _$_findCachedViewById(R.id.onboarding_next)).setOnClickListener(new OnboardingActivity$refreshButton$1(uploadButtonLayout));
            TextView textView = (TextView) _$_findCachedViewById(R.id.onboarding_next_secondary);
            Intrinsics.checkExpressionValueIsNotNull(textView, "onboarding_next_secondary");
            textView.setVisibility(8);
        } else if (uploadButtonLayout instanceof UploadButtonLayout.TwoChoiceContinueLayout) {
            UploadButtonLayout.TwoChoiceContinueLayout twoChoiceContinueLayout = (UploadButtonLayout.TwoChoiceContinueLayout) uploadButtonLayout;
            ((Button) _$_findCachedViewById(R.id.onboarding_next)).setText(twoChoiceContinueLayout.getPrimaryButtonText());
            ((Button) _$_findCachedViewById(R.id.onboarding_next)).setOnClickListener(new OnboardingActivity$refreshButton$2(uploadButtonLayout));
            ((TextView) _$_findCachedViewById(R.id.onboarding_next_secondary)).setText(twoChoiceContinueLayout.getSecondaryButtonText());
            ((TextView) _$_findCachedViewById(R.id.onboarding_next_secondary)).setOnClickListener(new OnboardingActivity$refreshButton$3(uploadButtonLayout));
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.onboarding_next_secondary);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "onboarding_next_secondary");
            textView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ((Button) _$_findCachedViewById(R.id.onboarding_next)).setOnClickListener((View.OnClickListener) null);
        ((Toolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener((View.OnClickListener) null);
    }

    public void enableNextButton() {
        Button button = (Button) _$_findCachedViewById(R.id.onboarding_next);
        Intrinsics.checkExpressionValueIsNotNull(button, "onboarding_next");
        button.setEnabled(true);
    }

    public void disableNextButton() {
        Button button = (Button) _$_findCachedViewById(R.id.onboarding_next);
        Intrinsics.checkExpressionValueIsNotNull(button, "onboarding_next");
        button.setEnabled(false);
    }

    public void showLoading() {
        Button button = (Button) _$_findCachedViewById(R.id.onboarding_next);
        Intrinsics.checkExpressionValueIsNotNull(button, "onboarding_next");
        DrawableButtonExtensionsKt.showProgress((TextView) button, (Function1<? super ProgressParams, Unit>) OnboardingActivity$showLoading$1.INSTANCE);
    }

    public void hideLoading(Integer num) {
        if (num == null) {
            Button button = (Button) _$_findCachedViewById(R.id.onboarding_next);
            Intrinsics.checkExpressionValueIsNotNull(button, "onboarding_next");
            DrawableButtonExtensionsKt.hideProgress$default(button, (String) null, 1, (Object) null);
            return;
        }
        Button button2 = (Button) _$_findCachedViewById(R.id.onboarding_next);
        Intrinsics.checkExpressionValueIsNotNull(button2, "onboarding_next");
        DrawableButtonExtensionsKt.hideProgress((TextView) button2, num.intValue());
    }
}
