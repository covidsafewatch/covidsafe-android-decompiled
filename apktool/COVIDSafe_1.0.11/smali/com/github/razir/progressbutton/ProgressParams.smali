.class public Lcom/github/razir/progressbutton/ProgressParams;
.super Lcom/github/razir/progressbutton/DrawableParams;
.source "ProgressParams.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0015\n\u0002\u0008\u0013\u0008\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u000b\u0010\u0006\"\u0004\u0008\u000c\u0010\u0008R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u0019\u0010\u0006\"\u0004\u0008\u001a\u0010\u0008R\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015\"\u0004\u0008\u001d\u0010\u0017R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u001f\u0010\u0006\"\u0004\u0008 \u0010\u0008\u00a8\u0006!"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/ProgressParams;",
        "Lcom/github/razir/progressbutton/DrawableParams;",
        "()V",
        "progressColor",
        "",
        "getProgressColor",
        "()Ljava/lang/Integer;",
        "setProgressColor",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "progressColorRes",
        "getProgressColorRes",
        "setProgressColorRes",
        "progressColors",
        "",
        "getProgressColors",
        "()[I",
        "setProgressColors",
        "([I)V",
        "progressRadiusPx",
        "getProgressRadiusPx",
        "()I",
        "setProgressRadiusPx",
        "(I)V",
        "progressRadiusRes",
        "getProgressRadiusRes",
        "setProgressRadiusRes",
        "progressStrokePx",
        "getProgressStrokePx",
        "setProgressStrokePx",
        "progressStrokeRes",
        "getProgressStrokeRes",
        "setProgressStrokeRes",
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
.field private progressColor:Ljava/lang/Integer;

.field private progressColorRes:Ljava/lang/Integer;

.field private progressColors:[I

.field private progressRadiusPx:I

.field private progressRadiusRes:Ljava/lang/Integer;

.field private progressStrokePx:I

.field private progressStrokeRes:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 12
    invoke-direct {p0}, Lcom/github/razir/progressbutton/DrawableParams;-><init>()V

    const/4 v0, -0x1

    .line 25
    iput v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressRadiusPx:I

    .line 38
    iput v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressStrokePx:I

    return-void
.end method


# virtual methods
.method public final getProgressColor()Ljava/lang/Integer;
    .locals 1

    .line 44
    iget-object v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColor:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getProgressColorRes()Ljava/lang/Integer;
    .locals 1

    .line 50
    iget-object v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColorRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getProgressColors()[I
    .locals 1

    .line 55
    iget-object v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColors:[I

    return-object v0
.end method

.method public final getProgressRadiusPx()I
    .locals 1

    .line 25
    iget v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressRadiusPx:I

    return v0
.end method

.method public final getProgressRadiusRes()Ljava/lang/Integer;
    .locals 1

    .line 19
    iget-object v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressRadiusRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getProgressStrokePx()I
    .locals 1

    .line 38
    iget v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressStrokePx:I

    return v0
.end method

.method public final getProgressStrokeRes()Ljava/lang/Integer;
    .locals 1

    .line 32
    iget-object v0, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressStrokeRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final setProgressColor(Ljava/lang/Integer;)V
    .locals 0

    .line 44
    iput-object p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColor:Ljava/lang/Integer;

    return-void
.end method

.method public final setProgressColorRes(Ljava/lang/Integer;)V
    .locals 0

    .line 50
    iput-object p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColorRes:Ljava/lang/Integer;

    return-void
.end method

.method public final setProgressColors([I)V
    .locals 0

    .line 55
    iput-object p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressColors:[I

    return-void
.end method

.method public final setProgressRadiusPx(I)V
    .locals 0

    .line 25
    iput p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressRadiusPx:I

    return-void
.end method

.method public final setProgressRadiusRes(Ljava/lang/Integer;)V
    .locals 0

    .line 19
    iput-object p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressRadiusRes:Ljava/lang/Integer;

    return-void
.end method

.method public final setProgressStrokePx(I)V
    .locals 0

    .line 38
    iput p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressStrokePx:I

    return-void
.end method

.method public final setProgressStrokeRes(Ljava/lang/Integer;)V
    .locals 0

    .line 32
    iput-object p1, p0, Lcom/github/razir/progressbutton/ProgressParams;->progressStrokeRes:Ljava/lang/Integer;

    return-void
.end method
