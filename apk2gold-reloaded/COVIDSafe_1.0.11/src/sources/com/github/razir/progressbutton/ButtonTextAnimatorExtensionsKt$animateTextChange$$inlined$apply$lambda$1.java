package com.github.razir.progressbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$fadeInAnim$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ButtonTextAnimatorExtensions.kt */
public final class ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1 implements AnimatorListener {
    final /* synthetic */ TextChangeAnimatorParams $params$inlined;
    final /* synthetic */ TextView $this_animateTextChange$inlined;

    public void onAnimationRepeat(Animator animator) {
    }

    ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1(TextView textView, TextChangeAnimatorParams textChangeAnimatorParams) {
        this.$this_animateTextChange$inlined = textView;
        this.$params$inlined = textChangeAnimatorParams;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        ButtonTextAnimatorExtensionsKt.cleaAnimator(this.$this_animateTextChange$inlined, animator);
        ButtonTextAnimatorExtensionsKt.resetColor(this.$this_animateTextChange$inlined);
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        ButtonTextAnimatorExtensionsKt.resetColor(this.$this_animateTextChange$inlined);
        ButtonTextAnimatorExtensionsKt.cleaAnimator(this.$this_animateTextChange$inlined, animator);
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animation");
        ButtonTextAnimatorExtensionsKt.addAnimator(this.$this_animateTextChange$inlined, animator);
    }
}
