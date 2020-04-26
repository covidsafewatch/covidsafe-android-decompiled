package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.OnChangedCallback;
import java.util.List;

interface MotionStrategy {
    void addAnimationListener(AnimatorListener animatorListener);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    int getDefaultMotionSpecResource();

    List<AnimatorListener> getListeners();

    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator animator);

    void onChange(OnChangedCallback onChangedCallback);

    void performNow();

    void removeAnimationListener(AnimatorListener animatorListener);

    void setMotionSpec(MotionSpec motionSpec);

    boolean shouldCancel();
}
