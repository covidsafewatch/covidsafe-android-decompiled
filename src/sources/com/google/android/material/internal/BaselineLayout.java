package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline = -1;

    public BaselineLayout(Context context) {
        super(context, (AttributeSet) null, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int baseline2 = childAt.getBaseline();
                if (baseline2 != -1) {
                    i6 = Math.max(i6, baseline2);
                    i7 = Math.max(i7, childAt.getMeasuredHeight() - baseline2);
                }
                i4 = Math.max(i4, childAt.getMeasuredWidth());
                i3 = Math.max(i3, childAt.getMeasuredHeight());
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
            }
        }
        if (i6 != -1) {
            i3 = Math.max(i3, Math.max(i7, getPaddingBottom()) + i6);
            this.baseline = i6;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumWidth()), i, i5), View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumHeight()), i2, i5 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i3 - i) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((paddingRight - measuredWidth) / 2) + paddingLeft;
                int baseline2 = (this.baseline == -1 || childAt.getBaseline() == -1) ? paddingTop : (this.baseline + paddingTop) - childAt.getBaseline();
                childAt.layout(i6, baseline2, measuredWidth + i6, measuredHeight + baseline2);
            }
        }
    }

    public int getBaseline() {
        return this.baseline;
    }
}
