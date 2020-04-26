package com.github.razir.progressbutton;

import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonHolder;", "Landroidx/lifecycle/LifecycleEventObserver;", "textView", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "(Ljava/lang/ref/WeakReference;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProgressButtonHolder.kt */
final class ProgressButtonHolder implements LifecycleEventObserver {
    private final WeakReference<TextView> textView;

    public ProgressButtonHolder(WeakReference<TextView> weakReference) {
        Intrinsics.checkParameterIsNotNull(weakReference, "textView");
        this.textView = weakReference;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        TextView textView2;
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "source");
        Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY && (textView2 = (TextView) this.textView.get()) != null) {
            Intrinsics.checkExpressionValueIsNotNull(textView2, "it");
            ButtonTextAnimatorExtensionsKt.cancelAnimations(textView2);
            ProgressButtonHolderKt.cleanUpDrawable(textView2);
            ProgressButtonHolderKt.removeTextAnimationAttachViewListener(textView2);
            ProgressButtonHolderKt.removeDrawableAttachViewListener(textView2);
            TextChangeAnimatorParams remove = ProgressButtonHolderKt.getAttachedViews().remove(textView2);
        }
    }
}
