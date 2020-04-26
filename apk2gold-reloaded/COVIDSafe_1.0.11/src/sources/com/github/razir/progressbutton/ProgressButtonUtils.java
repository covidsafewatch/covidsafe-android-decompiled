package com.github.razir.progressbutton;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonUtils;", "", "()V", "Companion", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProgressButtonUtils.kt */
public final class ProgressButtonUtils {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/github/razir/progressbutton/ProgressButtonUtils$Companion;", "", "()V", "hideProgress", "", "textView", "Landroid/widget/TextView;", "newTextRes", "", "newText", "", "isProgressActive", "", "showProgress", "progressParams", "Lcom/github/razir/progressbutton/ProgressParams;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ProgressButtonUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showProgress(TextView textView, ProgressParams progressParams) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            Intrinsics.checkParameterIsNotNull(progressParams, "progressParams");
            DrawableButtonExtensionsKt.showProgress(textView, progressParams);
        }

        @JvmStatic
        public final boolean isProgressActive(TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            return DrawableButtonExtensionsKt.isProgressActive(textView);
        }

        @JvmStatic
        public final void hideProgress(TextView textView, String str) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            DrawableButtonExtensionsKt.hideProgress(textView, str);
        }

        @JvmStatic
        public final void hideProgress(TextView textView, int i) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            DrawableButtonExtensionsKt.hideProgress(textView, i);
        }
    }

    @JvmStatic
    public static final void hideProgress(TextView textView, int i) {
        Companion.hideProgress(textView, i);
    }

    @JvmStatic
    public static final void hideProgress(TextView textView, String str) {
        Companion.hideProgress(textView, str);
    }

    @JvmStatic
    public static final boolean isProgressActive(TextView textView) {
        return Companion.isProgressActive(textView);
    }

    @JvmStatic
    public static final void showProgress(TextView textView, ProgressParams progressParams) {
        Companion.showProgress(textView, progressParams);
    }
}
