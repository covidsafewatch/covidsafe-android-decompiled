package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDecorPadding = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.mDecorPadding.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            android.content.Context r0 = r13.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r1 = r0.widthPixels
            int r2 = r0.heightPixels
            r3 = 1
            r4 = 0
            if (r1 >= r2) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            int r2 = android.view.View.MeasureSpec.getMode(r14)
            int r5 = android.view.View.MeasureSpec.getMode(r15)
            r6 = 6
            r7 = 5
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 1073741824(0x40000000, float:2.0)
            if (r2 != r8) goto L_0x0068
            if (r1 == 0) goto L_0x002c
            android.util.TypedValue r10 = r13.mFixedWidthMinor
            goto L_0x002e
        L_0x002c:
            android.util.TypedValue r10 = r13.mFixedWidthMajor
        L_0x002e:
            if (r10 == 0) goto L_0x0068
            int r11 = r10.type
            if (r11 == 0) goto L_0x0068
            int r11 = r10.type
            if (r11 != r7) goto L_0x003e
            float r10 = r10.getDimension(r0)
        L_0x003c:
            int r10 = (int) r10
            goto L_0x004e
        L_0x003e:
            int r11 = r10.type
            if (r11 != r6) goto L_0x004d
            int r11 = r0.widthPixels
            float r11 = (float) r11
            int r12 = r0.widthPixels
            float r12 = (float) r12
            float r10 = r10.getFraction(r11, r12)
            goto L_0x003c
        L_0x004d:
            r10 = 0
        L_0x004e:
            if (r10 <= 0) goto L_0x0068
            android.graphics.Rect r11 = r13.mDecorPadding
            int r11 = r11.left
            android.graphics.Rect r12 = r13.mDecorPadding
            int r12 = r12.right
            int r11 = r11 + r12
            int r10 = r10 - r11
            int r14 = android.view.View.MeasureSpec.getSize(r14)
            int r14 = java.lang.Math.min(r10, r14)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r9)
            r10 = 1
            goto L_0x0069
        L_0x0068:
            r10 = 0
        L_0x0069:
            if (r5 != r8) goto L_0x00aa
            if (r1 == 0) goto L_0x0070
            android.util.TypedValue r5 = r13.mFixedHeightMajor
            goto L_0x0072
        L_0x0070:
            android.util.TypedValue r5 = r13.mFixedHeightMinor
        L_0x0072:
            if (r5 == 0) goto L_0x00aa
            int r11 = r5.type
            if (r11 == 0) goto L_0x00aa
            int r11 = r5.type
            if (r11 != r7) goto L_0x0082
            float r5 = r5.getDimension(r0)
        L_0x0080:
            int r5 = (int) r5
            goto L_0x0092
        L_0x0082:
            int r11 = r5.type
            if (r11 != r6) goto L_0x0091
            int r11 = r0.heightPixels
            float r11 = (float) r11
            int r12 = r0.heightPixels
            float r12 = (float) r12
            float r5 = r5.getFraction(r11, r12)
            goto L_0x0080
        L_0x0091:
            r5 = 0
        L_0x0092:
            if (r5 <= 0) goto L_0x00aa
            android.graphics.Rect r11 = r13.mDecorPadding
            int r11 = r11.top
            android.graphics.Rect r12 = r13.mDecorPadding
            int r12 = r12.bottom
            int r11 = r11 + r12
            int r5 = r5 - r11
            int r15 = android.view.View.MeasureSpec.getSize(r15)
            int r15 = java.lang.Math.min(r5, r15)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r9)
        L_0x00aa:
            super.onMeasure(r14, r15)
            int r14 = r13.getMeasuredWidth()
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r9)
            if (r10 != 0) goto L_0x00f3
            if (r2 != r8) goto L_0x00f3
            if (r1 == 0) goto L_0x00be
            android.util.TypedValue r1 = r13.mMinWidthMinor
            goto L_0x00c0
        L_0x00be:
            android.util.TypedValue r1 = r13.mMinWidthMajor
        L_0x00c0:
            if (r1 == 0) goto L_0x00f3
            int r2 = r1.type
            if (r2 == 0) goto L_0x00f3
            int r2 = r1.type
            if (r2 != r7) goto L_0x00d0
            float r0 = r1.getDimension(r0)
        L_0x00ce:
            int r0 = (int) r0
            goto L_0x00e0
        L_0x00d0:
            int r2 = r1.type
            if (r2 != r6) goto L_0x00df
            int r2 = r0.widthPixels
            float r2 = (float) r2
            int r0 = r0.widthPixels
            float r0 = (float) r0
            float r0 = r1.getFraction(r2, r0)
            goto L_0x00ce
        L_0x00df:
            r0 = 0
        L_0x00e0:
            if (r0 <= 0) goto L_0x00ec
            android.graphics.Rect r1 = r13.mDecorPadding
            int r1 = r1.left
            android.graphics.Rect r2 = r13.mDecorPadding
            int r2 = r2.right
            int r1 = r1 + r2
            int r0 = r0 - r1
        L_0x00ec:
            if (r14 >= r0) goto L_0x00f3
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
            goto L_0x00f4
        L_0x00f3:
            r3 = 0
        L_0x00f4:
            if (r3 == 0) goto L_0x00f9
            super.onMeasure(r5, r15)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }
}
