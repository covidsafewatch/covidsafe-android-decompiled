package com.github.razir.progressbutton;

import android.view.View;
import android.widget.TextView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProgressButtonHolder.kt */
public final class ProgressButtonHolderKt$textAnimationsAttachListener$1 implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
    }

    ProgressButtonHolderKt$textAnimationsAttachListener$1() {
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Map attachedViews = ProgressButtonHolderKt.getAttachedViews();
        if (attachedViews == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        } else if (attachedViews.containsKey(view)) {
            ButtonTextAnimatorExtensionsKt.cancelAnimations((TextView) view);
        }
    }
}
