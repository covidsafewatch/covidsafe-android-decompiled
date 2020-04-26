package com.github.razir.progressbutton;

import android.animation.Animator;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u000e\u0011\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0002H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002\u001a\n\u0010\u0019\u001a\u00020\u0014*\u00020\u0002\u001a\f\u0010\u001a\u001a\u00020\u0014*\u00020\u0002H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0014*\u00020\u0002H\u0000\"&\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\" \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000f\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u001c"}, d2 = {"activeAnimations", "Ljava/util/WeakHashMap;", "Landroid/widget/TextView;", "", "Landroid/animation/Animator;", "getActiveAnimations", "()Ljava/util/WeakHashMap;", "activeViews", "Lcom/github/razir/progressbutton/DrawableViewData;", "getActiveViews", "attachedViews", "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;", "getAttachedViews", "drawablesAttachListener", "com/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1", "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;", "textAnimationsAttachListener", "com/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1", "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;", "addDrawableAttachViewListener", "", "addTextAnimationAttachViewListener", "bindProgressButton", "Landroidx/lifecycle/LifecycleOwner;", "button", "cleanUpDrawable", "removeDrawableAttachViewListener", "removeTextAnimationAttachViewListener", "progressbutton_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: ProgressButtonHolder.kt */
public final class ProgressButtonHolderKt {
    private static final WeakHashMap<TextView, List<Animator>> activeAnimations = new WeakHashMap<>();
    private static final WeakHashMap<TextView, DrawableViewData> activeViews = new WeakHashMap<>();
    private static final WeakHashMap<TextView, TextChangeAnimatorParams> attachedViews = new WeakHashMap<>();
    private static final ProgressButtonHolderKt$drawablesAttachListener$1 drawablesAttachListener = new ProgressButtonHolderKt$drawablesAttachListener$1();
    private static final ProgressButtonHolderKt$textAnimationsAttachListener$1 textAnimationsAttachListener = new ProgressButtonHolderKt$textAnimationsAttachListener$1();

    public static final WeakHashMap<TextView, TextChangeAnimatorParams> getAttachedViews() {
        return attachedViews;
    }

    public static final WeakHashMap<TextView, List<Animator>> getActiveAnimations() {
        return activeAnimations;
    }

    public static final WeakHashMap<TextView, DrawableViewData> getActiveViews() {
        return activeViews;
    }

    public static final void bindProgressButton(LifecycleOwner lifecycleOwner, TextView textView) {
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "$this$bindProgressButton");
        Intrinsics.checkParameterIsNotNull(textView, "button");
        lifecycleOwner.getLifecycle().addObserver(new ProgressButtonHolder(new WeakReference(textView)));
    }

    public static final void cleanUpDrawable(TextView textView) {
        Drawable drawable;
        Intrinsics.checkParameterIsNotNull(textView, "$this$cleanUpDrawable");
        if (activeViews.containsKey(textView)) {
            DrawableViewData drawableViewData = activeViews.get(textView);
            if (!(drawableViewData == null || (drawable = drawableViewData.getDrawable()) == null)) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                drawable.setCallback((Drawable.Callback) null);
            }
            activeViews.remove(textView);
        }
    }

    public static final void addTextAnimationAttachViewListener(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$addTextAnimationAttachViewListener");
        textView.addOnAttachStateChangeListener(textAnimationsAttachListener);
    }

    public static final void removeTextAnimationAttachViewListener(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$removeTextAnimationAttachViewListener");
        textView.removeOnAttachStateChangeListener(textAnimationsAttachListener);
    }

    public static final void addDrawableAttachViewListener(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$addDrawableAttachViewListener");
        textView.addOnAttachStateChangeListener(drawablesAttachListener);
    }

    /* access modifiers changed from: private */
    public static final void removeDrawableAttachViewListener(TextView textView) {
        textView.removeOnAttachStateChangeListener(drawablesAttachListener);
    }
}
