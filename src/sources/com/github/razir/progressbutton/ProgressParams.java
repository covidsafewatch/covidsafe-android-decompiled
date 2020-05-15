package com.github.razir.progressbutton;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\b¨\u0006!"}, d2 = {"Lcom/github/razir/progressbutton/ProgressParams;", "Lcom/github/razir/progressbutton/DrawableParams;", "()V", "progressColor", "", "getProgressColor", "()Ljava/lang/Integer;", "setProgressColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "progressColorRes", "getProgressColorRes", "setProgressColorRes", "progressColors", "", "getProgressColors", "()[I", "setProgressColors", "([I)V", "progressRadiusPx", "getProgressRadiusPx", "()I", "setProgressRadiusPx", "(I)V", "progressRadiusRes", "getProgressRadiusRes", "setProgressRadiusRes", "progressStrokePx", "getProgressStrokePx", "setProgressStrokePx", "progressStrokeRes", "getProgressStrokeRes", "setProgressStrokeRes", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ProgressParams.kt */
public class ProgressParams extends DrawableParams {
    private Integer progressColor;
    private Integer progressColorRes;
    private int[] progressColors;
    private int progressRadiusPx = -1;
    private Integer progressRadiusRes;
    private int progressStrokePx = -1;
    private Integer progressStrokeRes;

    public final Integer getProgressRadiusRes() {
        return this.progressRadiusRes;
    }

    public final void setProgressRadiusRes(Integer num) {
        this.progressRadiusRes = num;
    }

    public final int getProgressRadiusPx() {
        return this.progressRadiusPx;
    }

    public final void setProgressRadiusPx(int i) {
        this.progressRadiusPx = i;
    }

    public final Integer getProgressStrokeRes() {
        return this.progressStrokeRes;
    }

    public final void setProgressStrokeRes(Integer num) {
        this.progressStrokeRes = num;
    }

    public final int getProgressStrokePx() {
        return this.progressStrokePx;
    }

    public final void setProgressStrokePx(int i) {
        this.progressStrokePx = i;
    }

    public final Integer getProgressColor() {
        return this.progressColor;
    }

    public final void setProgressColor(Integer num) {
        this.progressColor = num;
    }

    public final Integer getProgressColorRes() {
        return this.progressColorRes;
    }

    public final void setProgressColorRes(Integer num) {
        this.progressColorRes = num;
    }

    public final int[] getProgressColors() {
        return this.progressColors;
    }

    public final void setProgressColors(int[] iArr) {
        this.progressColors = iArr;
    }
}
