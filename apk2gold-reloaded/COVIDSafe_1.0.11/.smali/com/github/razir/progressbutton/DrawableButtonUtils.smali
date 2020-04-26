.class public final Lcom/github/razir/progressbutton/DrawableButtonUtils;
.super Ljava/lang/Object;
.source "DrawableButtonUtils.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"
    }
    d2 = {
        "Lcom/github/razir/progressbutton/DrawableButtonUtils;",
        "",
        "()V",
        "Companion",
        "progressbutton_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/github/razir/progressbutton/DrawableButtonUtils;->Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final hideDrawable(Landroid/widget/TextView;I)V
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lcom/github/razir/progressbutton/DrawableButtonUtils;->Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    invoke-virtual {v0, p0, p1}, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;->hideDrawable(Landroid/widget/TextView;I)V

    return-void
.end method

.method public static final hideDrawable(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lcom/github/razir/progressbutton/DrawableButtonUtils;->Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    invoke-virtual {v0, p0, p1}, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;->hideDrawable(Landroid/widget/TextView;Ljava/lang/String;)V

    return-void
.end method

.method public static final isDrawableActive(Landroid/widget/TextView;)Z
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lcom/github/razir/progressbutton/DrawableButtonUtils;->Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    invoke-virtual {v0, p0}, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;->isDrawableActive(Landroid/widget/TextView;)Z

    move-result p0

    return p0
.end method

.method public static final showDrawable(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Lcom/github/razir/progressbutton/DrawableParams;)V
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lcom/github/razir/progressbutton/DrawableButtonUtils;->Companion:Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;

    invoke-virtual {v0, p0, p1, p2}, Lcom/github/razir/progressbutton/DrawableButtonUtils$Companion;->showDrawable(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;Lcom/github/razir/progressbutton/DrawableParams;)V

    return-void
.end method
