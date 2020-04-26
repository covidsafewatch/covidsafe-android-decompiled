package com.github.razir.progressbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.SpannableString;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a2\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u0019\u001a\u00020\t*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0016*\u00020\u00182\b\b\u0001\u0010\u001c\u001a\u00020\t\u001a\u0016\u0010\u001b\u001a\u00020\u0016*\u00020\u00182\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u001a\u0014\u0010\u001e\u001a\u00020\u0016*\u00020\u00182\b\b\u0001\u0010\u001c\u001a\u00020\t\u001a\u0016\u0010\u001e\u001a\u00020\u0016*\u00020\u00182\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u001a\n\u0010\u001f\u001a\u00020\u0014*\u00020\u0018\u001a\n\u0010 \u001a\u00020\u0014*\u00020\u0018\u001a\u001c\u0010!\u001a\u00020\u0016*\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0000\u001a-\u0010!\u001a\u00020\u0016*\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00160%¢\u0006\u0002\b&\u001a.\u0010!\u001a\u00020\u0016*\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002\u001a\u0014\u0010(\u001a\u00020\u0016*\u00020\u00182\u0006\u0010$\u001a\u00020)H\u0000\u001a%\u0010(\u001a\u00020\u0016*\u00020\u00182\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160%¢\u0006\u0002\b&\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"DEFAULT_DRAWABLE_MARGIN_DP", "", "generateProgressDrawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "context", "Landroid/content/Context;", "progressColors", "", "progressRadiusPx", "", "progressStrokePx", "getDrawableSpannable", "Landroid/text/SpannableString;", "drawable", "Landroid/graphics/drawable/Drawable;", "text", "", "gravity", "drawableMarginPx", "useTextAlpha", "", "setupDrawableCallback", "", "textView", "Landroid/widget/TextView;", "dpToPixels", "dpValue", "hideDrawable", "newTextRes", "newText", "hideProgress", "isDrawableActive", "isProgressActive", "showDrawable", "paramValues", "Lcom/github/razir/progressbutton/DrawableParams;", "params", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "textMarginPx", "showProgress", "Lcom/github/razir/progressbutton/ProgressParams;", "progressbutton_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: DrawableButtonExtensions.kt */
public final class DrawableButtonExtensionsKt {
    private static final float DEFAULT_DRAWABLE_MARGIN_DP = 10.0f;

    public static /* synthetic */ void showProgress$default(TextView textView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DrawableButtonExtensionsKt$showProgress$1.INSTANCE;
        }
        showProgress(textView, function1);
    }

    public static final void showProgress(TextView textView, Function1<? super ProgressParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$showProgress");
        Intrinsics.checkParameterIsNotNull(function1, "params");
        ProgressParams progressParams = new ProgressParams();
        function1.invoke(progressParams);
        showProgress(textView, progressParams);
    }

    public static /* synthetic */ void showDrawable$default(TextView textView, Drawable drawable, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = DrawableButtonExtensionsKt$showDrawable$1.INSTANCE;
        }
        showDrawable(textView, drawable, function1);
    }

    public static final void showDrawable(TextView textView, Drawable drawable, Function1<? super DrawableParams, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$showDrawable");
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        Intrinsics.checkParameterIsNotNull(function1, "params");
        DrawableParams drawableParams = new DrawableParams();
        function1.invoke(drawableParams);
        showDrawable(textView, drawable, drawableParams);
    }

    public static final boolean isProgressActive(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$isProgressActive");
        return isDrawableActive(textView);
    }

    public static final boolean isDrawableActive(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$isDrawableActive");
        return ProgressButtonHolderKt.getActiveViews().containsKey(textView);
    }

    public static final void hideProgress(TextView textView, String str) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$hideProgress");
        hideDrawable(textView, str);
    }

    public static /* synthetic */ void hideProgress$default(TextView textView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        hideProgress(textView, str);
    }

    public static final void hideProgress(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$hideProgress");
        hideDrawable(textView, i);
    }

    public static /* synthetic */ void hideDrawable$default(TextView textView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        hideDrawable(textView, str);
    }

    public static final void hideDrawable(TextView textView, String str) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$hideDrawable");
        ProgressButtonHolderKt.cleanUpDrawable(textView);
        if (ButtonTextAnimatorExtensionsKt.isAnimatorAttached(textView)) {
            ButtonTextAnimatorExtensionsKt.animateTextChange(textView, str);
        } else {
            textView.setText(str);
        }
    }

    public static final void hideDrawable(TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "$this$hideDrawable");
        hideDrawable(textView, textView.getContext().getString(i));
    }

    public static final void showProgress(TextView textView, ProgressParams progressParams) {
        int[] iArr;
        Intrinsics.checkParameterIsNotNull(textView, "$this$showProgress");
        Intrinsics.checkParameterIsNotNull(progressParams, "params");
        Context context = textView.getContext();
        String str = "context";
        Intrinsics.checkExpressionValueIsNotNull(context, str);
        Resources resources = context.getResources();
        Integer progressStrokeRes = progressParams.getProgressStrokeRes();
        int dimensionPixelSize = progressStrokeRes != null ? resources.getDimensionPixelSize(progressStrokeRes.intValue()) : progressParams.getProgressStrokePx();
        Integer progressRadiusRes = progressParams.getProgressRadiusRes();
        int dimensionPixelSize2 = progressRadiusRes != null ? resources.getDimensionPixelSize(progressRadiusRes.intValue()) : progressParams.getProgressRadiusPx();
        if (progressParams.getProgressColorRes() != null) {
            iArr = new int[1];
            Context context2 = textView.getContext();
            Integer progressColorRes = progressParams.getProgressColorRes();
            if (progressColorRes == null) {
                Intrinsics.throwNpe();
            }
            iArr[0] = ContextCompat.getColor(context2, progressColorRes.intValue());
        } else if (progressParams.getProgressColor() != null) {
            iArr = new int[1];
            Integer progressColor = progressParams.getProgressColor();
            if (progressColor == null) {
                Intrinsics.throwNpe();
            }
            iArr[0] = progressColor.intValue();
        } else if (progressParams.getProgressColors() != null) {
            iArr = progressParams.getProgressColors();
            if (iArr == null) {
                Intrinsics.throwNpe();
            }
        } else {
            iArr = new int[0];
        }
        Context context3 = textView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, str);
        showDrawable(textView, (Drawable) generateProgressDrawable(context3, iArr, dimensionPixelSize2, dimensionPixelSize), (DrawableParams) progressParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0030, code lost:
        if (r1 != null) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void showDrawable(android.widget.TextView r3, android.graphics.drawable.Drawable r4, com.github.razir.progressbutton.DrawableParams r5) {
        /*
            java.lang.String r0 = "$this$showDrawable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "drawable"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "paramValues"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            android.content.Context r0 = r3.getContext()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.res.Resources r0 = r0.getResources()
            java.lang.Integer r1 = r5.getButtonTextRes()
            if (r1 == 0) goto L_0x0033
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            android.content.Context r2 = r3.getContext()
            java.lang.String r1 = r2.getString(r1)
            if (r1 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            java.lang.String r1 = r5.getButtonText()
        L_0x0037:
            java.lang.Integer r2 = r5.getTextMarginRes()
            if (r2 == 0) goto L_0x0048
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r0 = r0.getDimensionPixelSize(r2)
            goto L_0x004c
        L_0x0048:
            int r0 = r5.getTextMarginPx()
        L_0x004c:
            int r5 = r5.getGravity()
            showDrawable(r3, r4, r1, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.razir.progressbutton.DrawableButtonExtensionsKt.showDrawable(android.widget.TextView, android.graphics.drawable.Drawable, com.github.razir.progressbutton.DrawableParams):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void showDrawable(android.widget.TextView r3, android.graphics.drawable.Drawable r4, java.lang.String r5, int r6, int r7) {
        /*
            boolean r0 = isDrawableActive(r3)
            if (r0 == 0) goto L_0x0009
            com.github.razir.progressbutton.ProgressButtonHolderKt.cleanUpDrawable(r3)
        L_0x0009:
            android.text.method.TransformationMethod r0 = r3.getTransformationMethod()
            if (r0 == 0) goto L_0x001a
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = r0.getName()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            java.lang.String r1 = "android.text.method.AllCapsTransformationMethod"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            java.lang.String r1 = "context"
            if (r0 != 0) goto L_0x002d
            android.text.method.TransformationMethod r0 = r3.getTransformationMethod()
            boolean r0 = r0 instanceof androidx.appcompat.text.AllCapsTransformationMethod
            if (r0 == 0) goto L_0x003e
        L_0x002d:
            com.github.razir.progressbutton.AllCapsSpannedTransformationMethod r0 = new com.github.razir.progressbutton.AllCapsSpannedTransformationMethod
            android.content.Context r2 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r1)
            r0.<init>(r2)
            android.text.method.TransformationMethod r0 = (android.text.method.TransformationMethod) r0
            r3.setTransformationMethod(r0)
        L_0x003e:
            r0 = -1
            if (r7 != r0) goto L_0x004e
            android.content.Context r7 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            r0 = 1092616192(0x41200000, float:10.0)
            int r7 = dpToPixels(r7, r0)
        L_0x004e:
            boolean r0 = com.github.razir.progressbutton.ButtonTextAnimatorExtensionsKt.isAnimatorAttached(r3)
            android.text.SpannableString r5 = getDrawableSpannable(r4, r5, r6, r7, r0)
            if (r0 == 0) goto L_0x005c
            com.github.razir.progressbutton.ButtonTextAnimatorExtensionsKt.animateTextChange(r3, r5)
            goto L_0x0061
        L_0x005c:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x0061:
            com.github.razir.progressbutton.ProgressButtonHolderKt.addDrawableAttachViewListener(r3)
            setupDrawableCallback(r3, r4)
            boolean r3 = r4 instanceof android.graphics.drawable.Animatable
            if (r3 == 0) goto L_0x0070
            android.graphics.drawable.Animatable r4 = (android.graphics.drawable.Animatable) r4
            r4.start()
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.razir.progressbutton.DrawableButtonExtensionsKt.showDrawable(android.widget.TextView, android.graphics.drawable.Drawable, java.lang.String, int, int):void");
    }

    private static final void setupDrawableCallback(TextView textView, Drawable drawable) {
        Callback drawableButtonExtensionsKt$setupDrawableCallback$callback$1 = new DrawableButtonExtensionsKt$setupDrawableCallback$callback$1(textView);
        ProgressButtonHolderKt.getActiveViews().put(textView, new DrawableViewData(drawable, drawableButtonExtensionsKt$setupDrawableCallback$callback$1));
        drawable.setCallback(drawableButtonExtensionsKt$setupDrawableCallback$callback$1);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    private static final CircularProgressDrawable generateProgressDrawable(Context context, int[] iArr, int i, int i2) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStyle(1);
        if (true ^ (iArr.length == 0)) {
            circularProgressDrawable.setColorSchemeColors(Arrays.copyOf(iArr, iArr.length));
        }
        if (i != -1) {
            circularProgressDrawable.setCenterRadius((float) i);
        }
        if (i2 != -1) {
            circularProgressDrawable.setStrokeWidth((float) i2);
        }
        int centerRadius = ((int) (circularProgressDrawable.getCenterRadius() + circularProgressDrawable.getStrokeWidth())) * 2;
        circularProgressDrawable.setBounds(0, 0, centerRadius, centerRadius);
        return circularProgressDrawable;
    }

    private static final SpannableString getDrawableSpannable(Drawable drawable, String str, int i, int i2, boolean z) {
        SpannableString spannableString;
        DrawableSpan drawableSpan = new DrawableSpan(drawable, 0, 0, z, 6, null);
        String str2 = "";
        if (i == 0) {
            drawableSpan.setPaddingEnd(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            if (str == null) {
                str = str2;
            }
            sb.append(str);
            spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(drawableSpan, 0, 1, 33);
        } else if (i == 1) {
            drawableSpan.setPaddingStart(i2);
            StringBuilder sb2 = new StringBuilder();
            if (str == null) {
                str = str2;
            }
            sb2.append(str);
            sb2.append(' ');
            spannableString = new SpannableString(sb2.toString());
            spannableString.setSpan(drawableSpan, spannableString.length() - 1, spannableString.length(), 33);
        } else if (i == 2) {
            SpannableString spannableString2 = new SpannableString(" ");
            spannableString2.setSpan(drawableSpan, 0, 1, 33);
            return spannableString2;
        } else {
            throw new IllegalArgumentException("Please set the correct gravity");
        }
        return spannableString;
    }

    private static final int dpToPixels(Context context, float f) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
