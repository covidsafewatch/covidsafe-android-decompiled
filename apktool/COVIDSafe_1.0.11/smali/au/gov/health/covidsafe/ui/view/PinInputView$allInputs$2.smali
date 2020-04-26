.class final Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;
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
        "Ljava/util/List<",
        "+",
        "Landroid/widget/EditText;",
        ">;>;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0003"
    }
    d2 = {
        "<anonymous>",
        "",
        "Landroid/widget/EditText;",
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

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 13
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->invoke()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroid/widget/EditText;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x6

    new-array v0, v0, [Landroid/widget/EditText;

    .line 24
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinOne$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x0

    aput-object v1, v0, v2

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinTwo$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x1

    aput-object v1, v0, v2

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinThree$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x2

    aput-object v1, v0, v2

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinFour$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x3

    aput-object v1, v0, v2

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinFive$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x4

    aput-object v1, v0, v2

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$allInputs$2;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-static {v1}, Lau/gov/health/covidsafe/ui/view/PinInputView;->access$getPinSix$p(Lau/gov/health/covidsafe/ui/view/PinInputView;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x5

    aput-object v1, v0, v2

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
