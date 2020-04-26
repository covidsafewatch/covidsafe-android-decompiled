package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation = new int[2];
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
        public void onScrollChanged() {
            InterpolateOnScrollPositionChangeHelper.this.updateInterpolationForScreenPosition();
        }
    };
    private final int[] scrollLocation = new int[2];
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable2, ScrollView scrollView) {
        this.shapedView = view;
        this.materialShapeDrawable = materialShapeDrawable2;
        this.containingScrollView = scrollView;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable2) {
        this.materialShapeDrawable = materialShapeDrawable2;
    }

    public void setContainingScrollView(ScrollView scrollView) {
        this.containingScrollView = scrollView;
    }

    public void startListeningForScrollChanges(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView scrollView = this.containingScrollView;
        if (scrollView != null) {
            if (scrollView.getChildCount() != 0) {
                this.containingScrollView.getLocationInWindow(this.scrollLocation);
                this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
                int top = (this.shapedView.getTop() - this.scrollLocation[1]) + this.containerLocation[1];
                int height = this.shapedView.getHeight();
                int height2 = this.containingScrollView.getHeight();
                if (top < 0) {
                    this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, (((float) top) / ((float) height)) + 1.0f)));
                    this.shapedView.invalidate();
                    return;
                }
                int i = top + height;
                if (i > height2) {
                    this.materialShapeDrawable.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - (((float) (i - height2)) / ((float) height)))));
                    this.shapedView.invalidate();
                } else if (this.materialShapeDrawable.getInterpolation() != 1.0f) {
                    this.materialShapeDrawable.setInterpolation(1.0f);
                    this.shapedView.invalidate();
                }
            } else {
                throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
            }
        }
    }
}
