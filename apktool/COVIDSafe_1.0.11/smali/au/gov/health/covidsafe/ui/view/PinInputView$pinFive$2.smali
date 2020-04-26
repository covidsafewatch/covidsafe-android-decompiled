.class final Lau/gov/health/covidsafe/ui/view/PinInputView$pinFive$2;
.super Lkotlin/jvm/internal/Lambda;
.source "PinInputView.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/view/PinInputView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lcom/google/android/material/textfield/TextInputEditText;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\u0008\u0003"
    }
    d2 = {
        "<anonymous>",
        "Lcom/google/android/material/textfield/TextInputEditText;",
        "kotlin.jvm.PlatformType",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/view/PinInputView;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$pinFive$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final invoke()Lcom/google/android/material/textfield/TextInputEditText;
    .locals 2

    .line 19
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$pinFive$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    sget v1, Lau/gov/health/covidsafe/R$id;->pin_5:I

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/textfield/TextInputEditText;

    return-object v0
.end method

.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 13
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/PinInputView$pinFive$2;->invoke()Lcom/google/android/material/textfield/TextInputEditText;

    move-result-object v0

    return-object v0
.end method
