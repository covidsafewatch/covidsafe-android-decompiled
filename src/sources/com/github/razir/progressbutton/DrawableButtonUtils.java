package com.github.razir.progressbutton;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/github/razir/progressbutton/DrawableButtonUtils;", "", "()V", "Companion", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawableButtonUtils.kt */
public final class DrawableButtonUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void hideDrawable(TextView textView, int i) {
        Companion.hideDrawable(textView, i);
    }

    @JvmStatic
    public static final void hideDrawable(TextView textView, String str) {
        Companion.hideDrawable(textView, str);
    }

    @JvmStatic
    public static final boolean isDrawableActive(TextView textView) {
        return Companion.isDrawableActive(textView);
    }

    @JvmStatic
    public static final void showDrawable(TextView textView, Drawable drawable, DrawableParams drawableParams) {
        Companion.showDrawable(textView, drawable, drawableParams);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;", "", "()V", "hideDrawable", "", "view", "Landroid/widget/TextView;", "newTextRes", "", "newText", "", "isDrawableActive", "", "textView", "showDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "params", "Lcom/github/razir/progressbutton/DrawableParams;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DrawableButtonUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showDrawable(TextView textView, Drawable drawable, DrawableParams drawableParams) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(drawable, "drawable");
            Intrinsics.checkParameterIsNotNull(drawableParams, "params");
            DrawableButtonExtensionsKt.showDrawable(textView, drawable, drawableParams);
        }

        @JvmStatic
        public final boolean isDrawableActive(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            return DrawableButtonExtensionsKt.isDrawableActive(textView);
        }

        @JvmStatic
        public final void hideDrawable(TextView textView, String str) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            DrawableButtonExtensionsKt.hideDrawable(textView, str);
        }

        @JvmStatic
        public final void hideDrawable(TextView textView, int i) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            DrawableButtonExtensionsKt.hideDrawable(textView, i);
        }
    }
}
