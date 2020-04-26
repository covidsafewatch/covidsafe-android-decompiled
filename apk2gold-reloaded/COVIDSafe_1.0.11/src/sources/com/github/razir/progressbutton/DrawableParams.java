package com.github.razir.progressbutton;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/github/razir/progressbutton/DrawableParams;", "", "()V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "buttonTextRes", "", "getButtonTextRes", "()Ljava/lang/Integer;", "setButtonTextRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "gravity", "getGravity", "()I", "setGravity", "(I)V", "textMarginPx", "getTextMarginPx", "setTextMarginPx", "textMarginRes", "getTextMarginRes", "setTextMarginRes", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DrawableParams.kt */
public class DrawableParams {
    private String buttonText;
    private Integer buttonTextRes;
    private int gravity = 1;
    private int textMarginPx = -1;
    private Integer textMarginRes;

    public final Integer getButtonTextRes() {
        return this.buttonTextRes;
    }

    public final void setButtonTextRes(Integer num) {
        this.buttonTextRes = num;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final Integer getTextMarginRes() {
        return this.textMarginRes;
    }

    public final void setTextMarginRes(Integer num) {
        this.textMarginRes = num;
    }

    public final int getTextMarginPx() {
        return this.textMarginPx;
    }

    public final void setTextMarginPx(int i) {
        this.textMarginPx = i;
    }
}
