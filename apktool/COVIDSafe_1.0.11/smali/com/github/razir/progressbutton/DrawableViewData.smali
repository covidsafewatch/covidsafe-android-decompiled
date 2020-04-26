.class public final Lcom/github/razir/progressbutton/DrawableViewData;
.super Ljava/lang/Object;
.source "DrawableButtonExtensions.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c\u00a8\u0006\u0017"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/DrawableViewData;",
        "",
        "drawable",
        "Landroid/graphics/drawable/Drawable;",
        "callback",
        "Landroid/graphics/drawable/Drawable$Callback;",
        "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)V",
        "getCallback",
        "()Landroid/graphics/drawable/Drawable$Callback;",
        "getDrawable",
        "()Landroid/graphics/drawable/Drawable;",
        "setDrawable",
        "(Landroid/graphics/drawable/Drawable;)V",
        "component1",
        "component2",
        "copy",
        "equals",
        "",
        "other",
        "hashCode",
        "",
        "toString",
        "",
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
.field private final callback:Landroid/graphics/drawable/Drawable$Callback;

.field private drawable:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)V
    .locals 1

    const-string v0, "drawable"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "callback"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 257
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    iput-object p2, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    return-void
.end method

.method public static synthetic copy$default(Lcom/github/razir/progressbutton/DrawableViewData;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;ILjava/lang/Object;)Lcom/github/razir/progressbutton/DrawableViewData;
    .locals 0

    and-int/lit8 p4, p3, 0x1

    if-eqz p4, :cond_0

    iget-object p1, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    :cond_0
    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_1

    iget-object p2, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/github/razir/progressbutton/DrawableViewData;->copy(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)Lcom/github/razir/progressbutton/DrawableViewData;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Landroid/graphics/drawable/Drawable;
    .locals 1

    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public final component2()Landroid/graphics/drawable/Drawable$Callback;
    .locals 1

    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    return-object v0
.end method

.method public final copy(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)Lcom/github/razir/progressbutton/DrawableViewData;
    .locals 1

    const-string v0, "drawable"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "callback"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lcom/github/razir/progressbutton/DrawableViewData;

    invoke-direct {v0, p1, p2}, Lcom/github/razir/progressbutton/DrawableViewData;-><init>(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable$Callback;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p0, p1, :cond_1

    instance-of v0, p1, Lcom/github/razir/progressbutton/DrawableViewData;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/github/razir/progressbutton/DrawableViewData;

    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    iget-object v1, p1, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    iget-object p1, p1, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    return p1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    return p1
.end method

.method public final getCallback()Landroid/graphics/drawable/Drawable$Callback;
    .locals 1

    .line 257
    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    return-object v0
.end method

.method public final getDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 257
    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    iget-object v0, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_1
    add-int/2addr v0, v1

    return v0
.end method

.method public final setDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 257
    iput-object p1, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "DrawableViewData(drawable="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/github/razir/progressbutton/DrawableViewData;->drawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", callback="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/github/razir/progressbutton/DrawableViewData;->callback:Landroid/graphics/drawable/Drawable$Callback;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
