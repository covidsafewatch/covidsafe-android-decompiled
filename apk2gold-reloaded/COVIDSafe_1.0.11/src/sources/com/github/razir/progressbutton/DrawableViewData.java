package com.github.razir.progressbutton;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/github/razir/progressbutton/DrawableViewData;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)V", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawableButtonExtensions.kt */
public final class DrawableViewData {
    private final Callback callback;
    private Drawable drawable;

    public static /* synthetic */ DrawableViewData copy$default(DrawableViewData drawableViewData, Drawable drawable2, Callback callback2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable2 = drawableViewData.drawable;
        }
        if ((i & 2) != 0) {
            callback2 = drawableViewData.callback;
        }
        return drawableViewData.copy(drawable2, callback2);
    }

    public final Drawable component1() {
        return this.drawable;
    }

    public final Callback component2() {
        return this.callback;
    }

    public final DrawableViewData copy(Drawable drawable2, Callback callback2) {
        Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
        Intrinsics.checkParameterIsNotNull(callback2, "callback");
        return new DrawableViewData(drawable2, callback2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.callback, (java.lang.Object) r3.callback) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.github.razir.progressbutton.DrawableViewData
            if (r0 == 0) goto L_0x001d
            com.github.razir.progressbutton.DrawableViewData r3 = (com.github.razir.progressbutton.DrawableViewData) r3
            android.graphics.drawable.Drawable r0 = r2.drawable
            android.graphics.drawable.Drawable r1 = r3.drawable
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            android.graphics.drawable.Drawable$Callback r0 = r2.callback
            android.graphics.drawable.Drawable$Callback r3 = r3.callback
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.razir.progressbutton.DrawableViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Drawable drawable2 = this.drawable;
        int i = 0;
        int hashCode = (drawable2 != null ? drawable2.hashCode() : 0) * 31;
        Callback callback2 = this.callback;
        if (callback2 != null) {
            i = callback2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DrawableViewData(drawable=");
        sb.append(this.drawable);
        sb.append(", callback=");
        sb.append(this.callback);
        sb.append(")");
        return sb.toString();
    }

    public DrawableViewData(Drawable drawable2, Callback callback2) {
        Intrinsics.checkParameterIsNotNull(drawable2, "drawable");
        Intrinsics.checkParameterIsNotNull(callback2, "callback");
        this.drawable = drawable2;
        this.callback = callback2;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final void setDrawable(Drawable drawable2) {
        Intrinsics.checkParameterIsNotNull(drawable2, "<set-?>");
        this.drawable = drawable2;
    }
}
