package com.github.razir.progressbutton;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\bH\u0000\u001a%\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\r\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\f\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0002\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0002\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0016"}, d2 = {"addAnimator", "", "Landroid/widget/TextView;", "animator", "Landroid/animation/Animator;", "animateTextChange", "newText", "Landroid/text/SpannableString;", "", "attachTextChangeAnimator", "params", "Lkotlin/Function1;", "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;", "Lkotlin/ExtensionFunctionType;", "cancelAnimations", "cleaAnimator", "detachTextChangeAnimator", "getAnimateTextColor", "", "isAnimatorAttached", "", "resetColor", "progressbutton_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: ButtonTextAnimatorExtensions.kt */
public final class ButtonTextAnimatorExtensionsKt {
    public static /* synthetic */ void attachTextChangeAnimator$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = ButtonTextAnimatorExtensionsKt$attachTextChangeAnimator$1.INSTANCE;
        }
        attachTextChangeAnimator(textView, function1);
    }

    public static final void attachTextChangeAnimator(TextView textView, Function1<? super TextChangeAnimatorParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$attachTextChangeAnimator");
        Intrinsics.checkParameterIsNotNull(function1, "params");
        TextChangeAnimatorParams textChangeAnimatorParams = new TextChangeAnimatorParams();
        function1.invoke(textChangeAnimatorParams);
        attachTextChangeAnimator(textView, textChangeAnimatorParams);
    }

    public static final void attachTextChangeAnimator(TextView textView, TextChangeAnimatorParams textChangeAnimatorParams) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$attachTextChangeAnimator");
        TextChangeAnimatorParams textChangeAnimatorParams2 = textChangeAnimatorParams != null ? textChangeAnimatorParams : new TextChangeAnimatorParams();
        if (textChangeAnimatorParams2.getUseCurrentTextColor()) {
            textChangeAnimatorParams2.setTextColorList(textView.getTextColors());
        } else if (textChangeAnimatorParams2.getTextColorRes() != null) {
            Context context = textView.getContext();
            Integer textColorRes = textChangeAnimatorParams2.getTextColorRes();
            if (textColorRes == null) {
                Intrinsics.throwNpe();
            }
            textChangeAnimatorParams2.setTextColor(ContextCompat.getColor(context, textColorRes.intValue()));
        }
        ProgressButtonHolderKt.addTextAnimationAttachViewListener(textView);
        ProgressButtonHolderKt.getAttachedViews().put(textView, textChangeAnimatorParams);
    }

    public static final void detachTextChangeAnimator(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$detachTextChangeAnimator");
        if (ProgressButtonHolderKt.getAttachedViews().containsKey(textView)) {
            cancelAnimations(textView);
            ProgressButtonHolderKt.getAttachedViews().remove(textView);
            ProgressButtonHolderKt.removeTextAnimationAttachViewListener(textView);
        }
    }

    public static final boolean isAnimatorAttached(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$isAnimatorAttached");
        return ProgressButtonHolderKt.getAttachedViews().containsKey(textView);
    }

    public static final void animateTextChange(TextView textView, String str) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$animateTextChange");
        animateTextChange(textView, str != null ? new SpannableString(str) : null);
    }

    public static final void animateTextChange(TextView textView, SpannableString spannableString) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$animateTextChange");
        cancelAnimations(textView);
        Object obj = ProgressButtonHolderKt.getAttachedViews().get(textView);
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(obj, "attachedViews[this]!!");
        TextChangeAnimatorParams textChangeAnimatorParams = (TextChangeAnimatorParams) obj;
        int animateTextColor = getAnimateTextColor(textView);
        String str = "textColor";
        ObjectAnimator ofInt = ObjectAnimator.ofInt(textView, str, new int[]{ColorUtils.setAlphaComponent(animateTextColor, 0), animateTextColor});
        ofInt.setDuration(textChangeAnimatorParams.getFadeInMills());
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.addListener(new ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1(textView, textChangeAnimatorParams));
        ofInt.start();
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(textView, str, new int[]{animateTextColor, ColorUtils.setAlphaComponent(animateTextColor, 0)});
        ofInt2.setDuration(textChangeAnimatorParams.getFadeOutMills());
        ofInt2.setEvaluator(new ArgbEvaluator());
        ofInt2.addListener(new ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2(textView, textChangeAnimatorParams, spannableString, ofInt));
        ofInt2.start();
    }

    /* access modifiers changed from: private */
    public static final void addAnimator(TextView textView, Animator animator) {
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(textView)) {
            List list = (List) ProgressButtonHolderKt.getActiveAnimations().get(textView);
            if (list != null) {
                list.add(animator);
                return;
            }
            return;
        }
        ProgressButtonHolderKt.getActiveAnimations().put(textView, CollectionsKt.mutableListOf(animator));
    }

    /* access modifiers changed from: private */
    public static final void cleaAnimator(TextView textView, Animator animator) {
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(textView)) {
            Object obj = ProgressButtonHolderKt.getActiveAnimations().get(textView);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(obj, "activeAnimations[this]!!");
            List list = (List) obj;
            list.remove(animator);
            if (list.isEmpty()) {
                ProgressButtonHolderKt.getActiveAnimations().remove(textView);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void resetColor(TextView textView) {
        if (isAnimatorAttached(textView)) {
            Object obj = ProgressButtonHolderKt.getAttachedViews().get(textView);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(obj, "attachedViews[this]!!");
            TextChangeAnimatorParams textChangeAnimatorParams = (TextChangeAnimatorParams) obj;
            ColorStateList textColorList = textChangeAnimatorParams.getTextColorList();
            if (textColorList != null) {
                textView.setTextColor(textColorList);
            } else {
                textView.setTextColor(textChangeAnimatorParams.getTextColor());
            }
        }
    }

    public static final void cancelAnimations(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$cancelAnimations");
        if (ProgressButtonHolderKt.getActiveAnimations().containsKey(textView)) {
            Object obj = ProgressButtonHolderKt.getActiveAnimations().get(textView);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(obj, "activeAnimations[this]!!");
            for (Animator cancel : new ArrayList((List) obj)) {
                cancel.cancel();
            }
            ProgressButtonHolderKt.getActiveAnimations().remove(textView);
        }
    }

    private static final int getAnimateTextColor(TextView textView) {
        Object obj = ProgressButtonHolderKt.getAttachedViews().get(textView);
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(obj, "attachedViews[this]!!");
        TextChangeAnimatorParams textChangeAnimatorParams = (TextChangeAnimatorParams) obj;
        if (textChangeAnimatorParams.getTextColorList() == null) {
            return textChangeAnimatorParams.getTextColor();
        }
        int[] drawableState = textView.getDrawableState();
        ColorStateList textColorList = textChangeAnimatorParams.getTextColorList();
        if (textColorList == null) {
            Intrinsics.throwNpe();
        }
        return textColorList.getColorForState(drawableState, ViewCompat.MEASURED_STATE_MASK);
    }
}
