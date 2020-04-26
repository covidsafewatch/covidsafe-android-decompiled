.class public final Lcom/github/razir/progressbutton/DrawableSpan;
.super Landroid/text/style/ImageSpan;
.source "DrawableSpan.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nDrawableSpan.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawableSpan.kt\ncom/github/razir/progressbutton/DrawableSpan\n*L\n1#1,58:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u00a2\u0006\u0002\u0010\tJP\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0016J2\u0010!\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0008\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u00a8\u0006$"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/DrawableSpan;",
        "Landroid/text/style/ImageSpan;",
        "drawable",
        "Landroid/graphics/drawable/Drawable;",
        "paddingStart",
        "",
        "paddingEnd",
        "useTextAlpha",
        "",
        "(Landroid/graphics/drawable/Drawable;IIZ)V",
        "getPaddingEnd",
        "()I",
        "setPaddingEnd",
        "(I)V",
        "getPaddingStart",
        "setPaddingStart",
        "getUseTextAlpha",
        "()Z",
        "draw",
        "",
        "canvas",
        "Landroid/graphics/Canvas;",
        "text",
        "",
        "start",
        "end",
        "x",
        "",
        "top",
        "y",
        "bottom",
        "paint",
        "Landroid/graphics/Paint;",
        "getSize",
        "fontMetricsInt",
        "Landroid/graphics/Paint$FontMetricsInt;",
        "progressbutton_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private paddingEnd:I

.field private paddingStart:I

.field private final useTextAlpha:Z


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;IIZ)V
    .locals 1

    const-string v0, "drawable"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    invoke-direct {p0, p1}, Landroid/text/style/ImageSpan;-><init>(Landroid/graphics/drawable/Drawable;)V

    iput p2, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingStart:I

    iput p3, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingEnd:I

    iput-boolean p4, p0, Lcom/github/razir/progressbutton/DrawableSpan;->useTextAlpha:Z

    return-void
.end method

.method public synthetic constructor <init>(Landroid/graphics/drawable/Drawable;IIZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 1

    and-int/lit8 p6, p5, 0x2

    const/4 v0, 0x0

    if-eqz p6, :cond_0

    move p2, v0

    :cond_0
    and-int/lit8 p5, p5, 0x4

    if-eqz p5, :cond_1

    move p3, v0

    .line 9
    :cond_1
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/github/razir/progressbutton/DrawableSpan;-><init>(Landroid/graphics/drawable/Drawable;IIZ)V

    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V
    .locals 0

    const-string p3, "canvas"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p3, "text"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "paint"

    invoke-static {p9, p2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    invoke-virtual {p0}, Lcom/github/razir/progressbutton/DrawableSpan;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object p2

    .line 40
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 41
    invoke-virtual {p9}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object p3

    .line 42
    iget p4, p3, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iget p6, p3, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr p4, p6

    .line 43
    iget p3, p3, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr p7, p3

    div-int/lit8 p4, p4, 0x2

    sub-int/2addr p7, p4

    const-string p3, "drawable"

    .line 44
    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object p3

    invoke-virtual {p3}, Landroid/graphics/Rect;->height()I

    move-result p3

    div-int/lit8 p3, p3, 0x2

    sub-int/2addr p7, p3

    .line 45
    iget p3, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingStart:I

    if-eqz p3, :cond_0

    int-to-float p3, p3

    add-float/2addr p5, p3

    int-to-float p3, p7

    .line 46
    invoke-virtual {p1, p5, p3}, Landroid/graphics/Canvas;->translate(FF)V

    goto :goto_0

    :cond_0
    int-to-float p3, p7

    .line 48
    invoke-virtual {p1, p5, p3}, Landroid/graphics/Canvas;->translate(FF)V

    .line 50
    :goto_0
    iget-boolean p3, p0, Lcom/github/razir/progressbutton/DrawableSpan;->useTextAlpha:Z

    if-eqz p3, :cond_1

    .line 51
    invoke-virtual {p9}, Landroid/graphics/Paint;->getColor()I

    move-result p3

    invoke-static {p3}, Landroid/graphics/Color;->alpha(I)I

    move-result p3

    .line 52
    invoke-virtual {p2, p3}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 54
    :cond_1
    invoke-virtual {p2, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 55
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    return-void
.end method

.method public final getPaddingEnd()I
    .locals 1

    .line 9
    iget v0, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingEnd:I

    return v0
.end method

.method public final getPaddingStart()I
    .locals 1

    .line 9
    iget v0, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingStart:I

    return v0
.end method

.method public getSize(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I
    .locals 1

    const-string p3, "paint"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p3, "text"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 16
    invoke-virtual {p0}, Lcom/github/razir/progressbutton/DrawableSpan;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object p2

    const-string p3, "drawable"

    .line 17
    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object p2

    const-string p3, "drawable.bounds"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p5, :cond_0

    .line 19
    invoke-virtual {p1}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object p1

    .line 20
    iget p3, p1, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    iget p4, p1, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p3, p4

    .line 21
    iget p4, p2, Landroid/graphics/Rect;->bottom:I

    iget v0, p2, Landroid/graphics/Rect;->top:I

    sub-int/2addr p4, v0

    invoke-static {p3, p4}, Ljava/lang/Math;->max(II)I

    move-result p4

    .line 22
    iget p1, p1, Landroid/graphics/Paint$FontMetricsInt;->top:I

    div-int/lit8 p3, p3, 0x2

    add-int/2addr p1, p3

    .line 24
    div-int/lit8 p4, p4, 0x2

    sub-int p3, p1, p4

    iput p3, p5, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    add-int/2addr p1, p4

    .line 25
    iput p1, p5, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 26
    iget p1, p5, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    iput p1, p5, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 27
    iget p1, p5, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iput p1, p5, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 30
    :cond_0
    invoke-virtual {p2}, Landroid/graphics/Rect;->width()I

    move-result p1

    iget p2, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingStart:I

    add-int/2addr p1, p2

    iget p2, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingEnd:I

    add-int/2addr p1, p2

    return p1
.end method

.method public final getUseTextAlpha()Z
    .locals 1

    .line 9
    iget-boolean v0, p0, Lcom/github/razir/progressbutton/DrawableSpan;->useTextAlpha:Z

    return v0
.end method

.method public final setPaddingEnd(I)V
    .locals 0

    .line 9
    iput p1, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingEnd:I

    return-void
.end method

.method public final setPaddingStart(I)V
    .locals 0

    .line 9
    iput p1, p0, Lcom/github/razir/progressbutton/DrawableSpan;->paddingStart:I

    return-void
.end method
