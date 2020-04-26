package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;
    private MotionSpec defaultMotionSpec;
    private final ExtendedFloatingActionButton fab;
    private final ArrayList<AnimatorListener> listeners = new ArrayList<>();
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    BaseMotionStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    public final void setMotionSpec(MotionSpec motionSpec2) {
        this.motionSpec = motionSpec2;
    }

    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec motionSpec2 = this.motionSpec;
        if (motionSpec2 != null) {
            return motionSpec2;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    public final void addAnimationListener(AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public final void removeAnimationListener(AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public final List<AnimatorListener> getListeners() {
        return this.listeners;
    }

    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    public void onAnimationStart(Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    public void onAnimationEnd() {
        this.tracker.clear();
    }

    public void onAnimationCancel() {
        this.tracker.clear();
    }

    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    /* access modifiers changed from: 0000 */
    public AnimatorSet createAnimator(MotionSpec motionSpec2) {
        ArrayList arrayList = new ArrayList();
        String str = "opacity";
        if (motionSpec2.hasPropertyValues(str)) {
            arrayList.add(motionSpec2.getAnimator(str, this.fab, View.ALPHA));
        }
        String str2 = "scale";
        if (motionSpec2.hasPropertyValues(str2)) {
            arrayList.add(motionSpec2.getAnimator(str2, this.fab, View.SCALE_Y));
            arrayList.add(motionSpec2.getAnimator(str2, this.fab, View.SCALE_X));
        }
        String str3 = "width";
        if (motionSpec2.hasPropertyValues(str3)) {
            arrayList.add(motionSpec2.getAnimator(str3, this.fab, ExtendedFloatingActionButton.WIDTH));
        }
        String str4 = "height";
        if (motionSpec2.hasPropertyValues(str4)) {
            arrayList.add(motionSpec2.getAnimator(str4, this.fab, ExtendedFloatingActionButton.HEIGHT));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
