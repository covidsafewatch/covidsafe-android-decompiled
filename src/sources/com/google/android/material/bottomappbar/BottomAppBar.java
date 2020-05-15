package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    /* access modifiers changed from: private */
    public int bottomInset;
    /* access modifiers changed from: private */
    public int fabAlignmentMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    /* access modifiers changed from: private */
    public boolean fabAttached;
    private final int fabOffsetEndMode;
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable materialShapeDrawable;
    /* access modifiers changed from: private */
    public Animator menuAnimator;
    private Animator modeAnimator;

    interface AnimationListener {
        void onAnimationEnd(BottomAppBar bottomAppBar);

        void onAnimationStart(BottomAppBar bottomAppBar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(ThemeEnforcement.createThemedContext(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.materialShapeDrawable = new MaterialShapeDrawable();
        this.animatingModeChangeCounter = 0;
        this.fabAttached = true;
        this.fabAnimationListener = new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.maybeAnimateMenuView(bottomAppBar.fabAlignmentMode, BottomAppBar.this.fabAttached);
            }
        };
        this.fabTransformationCallback = new TransformationCallback<FloatingActionButton>() {
            public void onScaleChanged(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }

            public void onTranslationChanged(FloatingActionButton floatingActionButton) {
                float translationX = floatingActionButton.getTranslationX();
                if (BottomAppBar.this.getTopEdgeTreatment().getHorizontalOffset() != translationX) {
                    BottomAppBar.this.getTopEdgeTreatment().setHorizontalOffset(translationX);
                    BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                float f = -floatingActionButton.getTranslationY();
                if (BottomAppBar.this.getTopEdgeTreatment().getCradleVerticalOffset() != f) {
                    BottomAppBar.this.getTopEdgeTreatment().setCradleVerticalOffset(f);
                    BottomAppBar.this.materialShapeDrawable.invalidateSelf();
                }
                BottomAppBar.this.materialShapeDrawable.setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        };
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BottomAppBar, i, DEF_STYLE_RES, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment((float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0))).build());
        this.materialShapeDrawable.setShadowCompatibilityMode(2);
        this.materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        this.materialShapeDrawable.initializeElevationOverlay(context2);
        setElevation((float) dimensionPixelSize);
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
        ViewCompat.setBackground(this, this.materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                int unused = BottomAppBar.this.bottomInset = windowInsetsCompat.getSystemWindowInsetBottom();
                relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public void setFabAlignmentMode(int i) {
        maybeAnimateModeChange(i);
        maybeAnimateMenuView(i, this.fabAttached);
        this.fabAlignmentMode = i;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.materialShapeDrawable, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutState();
        }
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void setElevation(float f) {
        this.materialShapeDrawable.setElevation(f);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void replaceMenu(int i) {
        getMenu().clear();
        inflateMenu(i);
    }

    /* access modifiers changed from: package-private */
    public void addAnimationListener(AnimationListener animationListener) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(animationListener);
    }

    /* access modifiers changed from: package-private */
    public void removeAnimationListener(AnimationListener animationListener) {
        ArrayList<AnimationListener> arrayList = this.animationListeners;
        if (arrayList != null) {
            arrayList.remove(animationListener);
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationStart() {
        ArrayList<AnimationListener> arrayList;
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i == 0 && (arrayList = this.animationListeners) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchAnimationEnd() {
        ArrayList<AnimationListener> arrayList;
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i == 0 && (arrayList = this.animationListeners) != null) {
            Iterator<AnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setFabDiameter(int i) {
        float f = (float) i;
        if (f == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(f);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode != i && ViewCompat.isLaidOut(this)) {
            Animator animator = this.modeAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.fabAnimationMode == 1) {
                createFabTranslationXAnimation(i, arrayList);
            } else {
                createFabDefaultXAnimation(i, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.modeAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.dispatchAnimationStart();
                }

                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.dispatchAnimationEnd();
                }
            });
            this.modeAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton findDependentFab() {
        View findDependentView = findDependentView();
        if (findDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) findDependentView;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findDependentView() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.findDependentView():android.view.View");
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    /* access modifiers changed from: protected */
    public void createFabDefaultXAnimation(final int i, List<Animator> list) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab != null && !findDependentFab.isOrWillBeHidden()) {
            dispatchAnimationStart();
            findDependentFab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
                public void onHidden(FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.getFabTranslationX(i));
                    floatingActionButton.show(new FloatingActionButton.OnVisibilityChangedListener() {
                        public void onShown(FloatingActionButton floatingActionButton) {
                            BottomAppBar.this.dispatchAnimationEnd();
                        }
                    });
                }
            });
        }
    }

    private void createFabTranslationXAnimation(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(i)});
        ofFloat.setDuration(ANIMATION_DURATION);
        list.add(ofFloat);
    }

    /* access modifiers changed from: private */
    public void maybeAnimateMenuView(int i, boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            Animator animator = this.menuAnimator;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!isFabVisibleOrWillBeShown()) {
                i = 0;
                z = false;
            }
            createMenuViewTranslationAnimation(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.menuAnimator = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.dispatchAnimationStart();
                }

                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.dispatchAnimationEnd();
                    Animator unused = BottomAppBar.this.menuAnimator = null;
                }
            });
            this.menuAnimator.start();
        }
    }

    private void createMenuViewTranslationAnimation(final int i, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if (Math.abs(actionMenuView.getTranslationX() - ((float) getActionMenuViewTranslationX(actionMenuView, i, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    public boolean cancelled;

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.cancelled) {
                            BottomAppBar.this.translateActionMenuView(actionMenuView, i, z);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX(int i) {
        int i2 = 1;
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.fabOffsetEndMode;
        if (z) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z) {
        actionMenuView.setTranslationX((float) getActionMenuViewTranslationX(actionMenuView, i, z));
    }

    /* access modifiers changed from: protected */
    public int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int measuredWidth = z2 ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                if (z2) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        int right = measuredWidth - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft());
        if (i != 1 || !z) {
            return 0;
        }
        return right;
    }

    private void cancelAnimations() {
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.modeAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            cancelAnimations();
            setCutoutState();
        }
        setActionMenuViewPosition();
    }

    /* access modifiers changed from: private */
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    /* access modifiers changed from: private */
    public void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        View findDependentView = findDependentView();
        this.materialShapeDrawable.setInterpolation((!this.fabAttached || !isFabVisibleOrWillBeShown()) ? 0.0f : 1.0f);
        if (findDependentView != null) {
            findDependentView.setTranslationY(getFabTranslationY());
            findDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!isFabVisibleOrWillBeShown()) {
                translateActionMenuView(actionMenuView, 0, false);
            } else {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
            }
        }
    }

    /* access modifiers changed from: private */
    public void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
                FloatingActionButton access$1100 = BottomAppBar.this.findDependentFab();
                if (access$1100 != null) {
                    access$1100.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.bottomInset;
    }

    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */
        public final Rect fabContentRect = new Rect();
        private final View.OnLayoutChangeListener fabLayoutListener = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.viewRef.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.getMeasuredContentRect(Behavior.this.fabContentRect);
                int height = Behavior.this.fabContentRect.height();
                bottomAppBar.setFabDiameter(height);
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.originalBottomMargin == 0) {
                    int dimensionPixelOffset = bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin);
                    layoutParams.bottomMargin = bottomAppBar.getBottomInset() + (dimensionPixelOffset - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                }
            }
        };
        /* access modifiers changed from: private */
        public int originalBottomMargin;
        /* access modifiers changed from: private */
        public WeakReference<BottomAppBar> viewRef;

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.viewRef = new WeakReference<>(bottomAppBar);
            View access$1700 = bottomAppBar.findDependentView();
            if (access$1700 != null && !ViewCompat.isLaidOut(access$1700)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) access$1700.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.originalBottomMargin = layoutParams.bottomMargin;
                if (access$1700 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) access$1700;
                    floatingActionButton.addOnLayoutChangeListener(this.fabLayoutListener);
                    bottomAppBar.addFabAnimationListeners(floatingActionButton);
                }
                bottomAppBar.setCutoutState();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int fabAlignmentMode;
        boolean fabAttached;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }
}
