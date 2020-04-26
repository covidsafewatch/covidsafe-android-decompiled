package com.github.razir.progressbutton;

import android.content.res.ColorStateList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/github/razir/progressbutton/TextChangeAnimatorParams;", "", "()V", "fadeInMills", "", "getFadeInMills", "()J", "setFadeInMills", "(J)V", "fadeOutMills", "getFadeOutMills", "setFadeOutMills", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "textColorList", "Landroid/content/res/ColorStateList;", "getTextColorList", "()Landroid/content/res/ColorStateList;", "setTextColorList", "(Landroid/content/res/ColorStateList;)V", "textColorRes", "getTextColorRes", "()Ljava/lang/Integer;", "setTextColorRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "useCurrentTextColor", "", "getUseCurrentTextColor", "()Z", "setUseCurrentTextColor", "(Z)V", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TextChangeAnimatorParams.kt */
public final class TextChangeAnimatorParams {
    private long fadeInMills = 150;
    private long fadeOutMills = 150;
    private int textColor;
    private ColorStateList textColorList;
    private Integer textColorRes;
    private boolean useCurrentTextColor = true;

    public final boolean getUseCurrentTextColor() {
        return this.useCurrentTextColor;
    }

    public final void setUseCurrentTextColor(boolean z) {
        this.useCurrentTextColor = z;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final ColorStateList getTextColorList() {
        return this.textColorList;
    }

    public final void setTextColorList(ColorStateList colorStateList) {
        this.textColorList = colorStateList;
    }

    public final Integer getTextColorRes() {
        return this.textColorRes;
    }

    public final void setTextColorRes(Integer num) {
        this.textColorRes = num;
    }

    public final long getFadeInMills() {
        return this.fadeInMills;
    }

    public final void setFadeInMills(long j) {
        this.fadeInMills = j;
    }

    public final long getFadeOutMills() {
        return this.fadeOutMills;
    }

    public final void setFadeOutMills(long j) {
        this.fadeOutMills = j;
    }
}
