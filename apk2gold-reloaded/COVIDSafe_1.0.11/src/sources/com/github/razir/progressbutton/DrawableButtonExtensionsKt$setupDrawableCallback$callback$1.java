package com.github.razir.progressbutton;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"com/github/razir/progressbutton/DrawableButtonExtensionsKt$setupDrawableCallback$callback$1", "Landroid/graphics/drawable/Drawable$Callback;", "invalidateDrawable", "", "who", "Landroid/graphics/drawable/Drawable;", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawableButtonExtensions.kt */
public final class DrawableButtonExtensionsKt$setupDrawableCallback$callback$1 implements Callback {
    final /* synthetic */ TextView $textView;

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Intrinsics.checkParameterIsNotNull(drawable, "who");
        Intrinsics.checkParameterIsNotNull(runnable, "what");
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(drawable, "who");
        Intrinsics.checkParameterIsNotNull(runnable, "what");
    }

    DrawableButtonExtensionsKt$setupDrawableCallback$callback$1(TextView textView) {
        this.$textView = textView;
    }

    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkParameterIsNotNull(drawable, "who");
        this.$textView.invalidate();
    }
}
