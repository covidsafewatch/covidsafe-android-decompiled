package com.github.razir.progressbutton;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJP\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J2\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/github/razir/progressbutton/DrawableSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "paddingStart", "", "paddingEnd", "useTextAlpha", "", "(Landroid/graphics/drawable/Drawable;IIZ)V", "getPaddingEnd", "()I", "setPaddingEnd", "(I)V", "getPaddingStart", "setPaddingStart", "getUseTextAlpha", "()Z", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawableSpan.kt */
public final class DrawableSpan extends ImageSpan {
    private int paddingEnd;
    private int paddingStart;
    private final boolean useTextAlpha;

    public /* synthetic */ DrawableSpan(Drawable drawable, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(drawable, i, i2, z);
    }

    public final int getPaddingEnd() {
        return this.paddingEnd;
    }

    public final int getPaddingStart() {
        return this.paddingStart;
    }

    public final boolean getUseTextAlpha() {
        return this.useTextAlpha;
    }

    public final void setPaddingEnd(int i) {
        this.paddingEnd = i;
    }

    public final void setPaddingStart(int i) {
        this.paddingStart = i;
    }

    public DrawableSpan(Drawable drawable, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(drawable, "drawable");
        super(drawable);
        this.paddingStart = i;
        this.paddingEnd = i2;
        this.useTextAlpha = z;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Drawable drawable = getDrawable();
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        Rect bounds = drawable.getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds, "drawable.bounds");
        if (fontMetricsInt != null) {
            FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = fontMetricsInt2.top + (i3 / 2);
            int max = Math.max(i3, bounds.bottom - bounds.top) / 2;
            fontMetricsInt.ascent = i4 - max;
            fontMetricsInt.descent = i4 + max;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return bounds.width() + this.paddingStart + this.paddingEnd;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = (i4 + fontMetricsInt.descent) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2);
        Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
        int height = i6 - (drawable.getBounds().height() / 2);
        int i7 = this.paddingStart;
        if (i7 != 0) {
            canvas.translate(f + ((float) i7), (float) height);
        } else {
            canvas.translate(f, (float) height);
        }
        if (this.useTextAlpha) {
            drawable.setAlpha(Color.alpha(paint.getColor()));
        }
        drawable.draw(canvas);
        canvas.restore();
    }
}
