.class public Lcom/github/razir/progressbutton/DrawableParams;
.super Ljava/lang/Object;
.source "DrawableParams.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0011\u0008\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012\"\u0004\u0008\u0017\u0010\u0014R\"\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u0019\u0010\u000c\"\u0004\u0008\u001a\u0010\u000e\u00a8\u0006\u001b"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/DrawableParams;",
        "",
        "()V",
        "buttonText",
        "",
        "getButtonText",
        "()Ljava/lang/String;",
        "setButtonText",
        "(Ljava/lang/String;)V",
        "buttonTextRes",
        "",
        "getButtonTextRes",
        "()Ljava/lang/Integer;",
        "setButtonTextRes",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "gravity",
        "getGravity",
        "()I",
        "setGravity",
        "(I)V",
        "textMarginPx",
        "getTextMarginPx",
        "setTextMarginPx",
        "textMarginRes",
        "getTextMarginRes",
        "setTextMarginRes",
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
.field private buttonText:Ljava/lang/String;

.field private buttonTextRes:Ljava/lang/Integer;

.field private gravity:I

.field private textMarginPx:I

.field private textMarginRes:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    .line 26
    iput v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->gravity:I

    const/4 v0, -0x1

    .line 37
    iput v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->textMarginPx:I

    return-void
.end method


# virtual methods
.method public final getButtonText()Ljava/lang/String;
    .locals 1

    .line 20
    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->buttonText:Ljava/lang/String;

    return-object v0
.end method

.method public final getButtonTextRes()Ljava/lang/Integer;
    .locals 1

    .line 15
    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->buttonTextRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getGravity()I
    .locals 1

    .line 26
    iget v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->gravity:I

    return v0
.end method

.method public final getTextMarginPx()I
    .locals 1

    .line 37
    iget v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->textMarginPx:I

    return v0
.end method

.method public final getTextMarginRes()Ljava/lang/Integer;
    .locals 1

    .line 32
    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableParams;->textMarginRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final setButtonText(Ljava/lang/String;)V
    .locals 0

    .line 20
    iput-object p1, p0, Lcom/github/razir/progressbutton/DrawableParams;->buttonText:Ljava/lang/String;

    return-void
.end method

.method public final setButtonTextRes(Ljava/lang/Integer;)V
    .locals 0

    .line 15
    iput-object p1, p0, Lcom/github/razir/progressbutton/DrawableParams;->buttonTextRes:Ljava/lang/Integer;

    return-void
.end method

.method public final setGravity(I)V
    .locals 0

    .line 26
    iput p1, p0, Lcom/github/razir/progressbutton/DrawableParams;->gravity:I

    return-void
.end method

.method public final setTextMarginPx(I)V
    .locals 0

    .line 37
    iput p1, p0, Lcom/github/razir/progressbutton/DrawableParams;->textMarginPx:I

    return-void
.end method

.method public final setTextMarginRes(Ljava/lang/Integer;)V
    .locals 0

    .line 32
    iput-object p1, p0, Lcom/github/razir/progressbutton/DrawableParams;->textMarginRes:Ljava/lang/Integer;

    return-void
.end method
