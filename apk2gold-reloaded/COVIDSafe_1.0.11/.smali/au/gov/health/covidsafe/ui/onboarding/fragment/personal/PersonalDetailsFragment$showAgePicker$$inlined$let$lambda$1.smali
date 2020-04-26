.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;
.super Ljava/lang/Object;
.source "PersonalDetailsFragment.kt"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->showAgePicker()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\u0008\u0007\u00a8\u0006\u0008"
    }
    d2 = {
        "<anonymous>",
        "",
        "<anonymous parameter 0>",
        "Landroid/content/DialogInterface;",
        "kotlin.jvm.PlatformType",
        "<anonymous parameter 1>",
        "",
        "onClick",
        "au/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$1$3"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $ages:Ljava/util/List;

.field final synthetic $selected:Lkotlin/jvm/internal/Ref$IntRef;

.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;


# direct methods
.method constructor <init>(Ljava/util/List;Lkotlin/jvm/internal/Ref$IntRef;Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$ages:Ljava/util/List;

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$selected:Lkotlin/jvm/internal/Ref$IntRef;

    iput-object p3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .line 162
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$ages:Ljava/util/List;

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$selected:Lkotlin/jvm/internal/Ref$IntRef;

    iget v0, v0, Lkotlin/jvm/internal/Ref$IntRef;->element:I

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lkotlin/Pair;

    invoke-static {p1, p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->access$setAgeSelected$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;Lkotlin/Pair;)V

    .line 163
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    sget p2, Lau/gov/health/covidsafe/R$id;->personal_details_age:I

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    const-string p2, "personal_details_age"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$ages:Ljava/util/List;

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->$selected:Lkotlin/jvm/internal/Ref$IntRef;

    iget v0, v0, Lkotlin/jvm/internal/Ref$IntRef;->element:I

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lkotlin/Pair;

    invoke-virtual {p2}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 164
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideAgeError()V

    .line 165
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->updateButtonState()V

    return-void
.end method
