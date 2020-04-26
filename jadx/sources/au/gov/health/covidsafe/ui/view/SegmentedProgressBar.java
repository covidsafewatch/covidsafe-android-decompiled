package au.gov.health.covidsafe.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import au.gov.health.covidsafe.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxValue", "value", "progress", "getProgress", "()I", "setProgress", "(I)V", "segmentSpacing", "drawProgress", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SegmentedProgressBar.kt */
public final class SegmentedProgressBar extends LinearLayout {
    private HashMap _$_findViewCache;
    private final int maxValue;
    private int progress;
    private final int segmentSpacing;

    public SegmentedProgressBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public SegmentedProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentedProgressBar, i, 0);
        this.maxValue = obtainStyledAttributes.getInt(0, 5);
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        this.segmentSpacing = obtainStyledAttributes.getDimensionPixelSize(2, ((int) resources.getDisplayMetrics().density) * 4);
        setProgress(obtainStyledAttributes.getInt(1, 0));
        drawProgress();
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SegmentedProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? -1 : i);
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
        int childCount = getChildCount();
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    childAt.setSelected(i2 + 1 <= this.progress);
                }
                if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private final void drawProgress() {
        int i = this.maxValue;
        int i2 = 0;
        while (i2 < i) {
            LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.height = -2;
            generateDefaultLayoutParams.width = 0;
            generateDefaultLayoutParams.weight = 1.0f;
            boolean z = true;
            generateDefaultLayoutParams.rightMargin = (1 <= i2 && this.maxValue - 1 > i2) ? this.segmentSpacing : 0;
            generateDefaultLayoutParams.leftMargin = i2 > 0 ? this.segmentSpacing : 0;
            View view = new View(getContext());
            view.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.progress_segment));
            i2++;
            if (i2 > this.progress) {
                z = false;
            }
            view.setSelected(z);
            addView(view, generateDefaultLayoutParams);
        }
    }
}
