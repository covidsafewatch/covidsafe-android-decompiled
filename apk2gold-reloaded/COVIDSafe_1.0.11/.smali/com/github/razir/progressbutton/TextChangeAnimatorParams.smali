.class public final Lcom/github/razir/progressbutton/TextChangeAnimatorParams;
.super Ljava/lang/Object;
.source "TextChangeAnimatorParams.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u0006\"\u0004\u0008\u000b\u0010\u0008R\u001e\u0010\u000c\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#\u00a8\u0006$"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
        "",
        "()V",
        "fadeInMills",
        "",
        "getFadeInMills",
        "()J",
        "setFadeInMills",
        "(J)V",
        "fadeOutMills",
        "getFadeOutMills",
        "setFadeOutMills",
        "textColor",
        "",
        "getTextColor",
        "()I",
        "setTextColor",
        "(I)V",
        "textColorList",
        "Landroid/content/res/ColorStateList;",
        "getTextColorList",
        "()Landroid/content/res/ColorStateList;",
        "setTextColorList",
        "(Landroid/content/res/ColorStateList;)V",
        "textColorRes",
        "getTextColorRes",
        "()Ljava/lang/Integer;",
        "setTextColorRes",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "useCurrentTextColor",
        "",
        "getUseCurrentTextColor",
        "()Z",
        "setUseCurrentTextColor",
        "(Z)V",
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
.field private fadeInMills:J

.field private fadeOutMills:J

.field private textColor:I

.field private textColorList:Landroid/content/res/ColorStateList;

.field private textColorRes:Ljava/lang/Integer;

.field private useCurrentTextColor:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    .line 17
    iput-boolean v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->useCurrentTextColor:Z

    const-wide/16 v0, 0x96

    .line 39
    iput-wide v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeInMills:J

    .line 44
    iput-wide v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeOutMills:J

    return-void
.end method


# virtual methods
.method public final getFadeInMills()J
    .locals 2

    .line 39
    iget-wide v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeInMills:J

    return-wide v0
.end method

.method public final getFadeOutMills()J
    .locals 2

    .line 44
    iget-wide v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeOutMills:J

    return-wide v0
.end method

.method public final getTextColor()I
    .locals 1

    .line 23
    iget v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColor:I

    return v0
.end method

.method public final getTextColorList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 28
    iget-object v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColorList:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public final getTextColorRes()Ljava/lang/Integer;
    .locals 1

    .line 34
    iget-object v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColorRes:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getUseCurrentTextColor()Z
    .locals 1

    .line 17
    iget-boolean v0, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->useCurrentTextColor:Z

    return v0
.end method

.method public final setFadeInMills(J)V
    .locals 0

    .line 39
    iput-wide p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeInMills:J

    return-void
.end method

.method public final setFadeOutMills(J)V
    .locals 0

    .line 44
    iput-wide p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->fadeOutMills:J

    return-void
.end method

.method public final setTextColor(I)V
    .locals 0

    .line 23
    iput p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColor:I

    return-void
.end method

.method public final setTextColorList(Landroid/content/res/ColorStateList;)V
    .locals 0

    .line 28
    iput-object p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColorList:Landroid/content/res/ColorStateList;

    return-void
.end method

.method public final setTextColorRes(Ljava/lang/Integer;)V
    .locals 0

    .line 34
    iput-object p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->textColorRes:Ljava/lang/Integer;

    return-void
.end method

.method public final setUseCurrentTextColor(Z)V
    .locals 0

    .line 17
    iput-boolean p1, p0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->useCurrentTextColor:Z

    return-void
.end method
