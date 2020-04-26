.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$1$2;
.super Ljava/lang/Object;
.source "PersonalDetailsFragment.kt"

# interfaces
.implements Landroid/widget/NumberPicker$OnValueChangeListener;


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
        "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n\u00a2\u0006\u0002\u0008\u0008"
    }
    d2 = {
        "<anonymous>",
        "",
        "<anonymous parameter 0>",
        "Landroid/widget/NumberPicker;",
        "kotlin.jvm.PlatformType",
        "<anonymous parameter 1>",
        "",
        "newVal",
        "onValueChange"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $selected:Lkotlin/jvm/internal/Ref$IntRef;


# direct methods
.method constructor <init>(Lkotlin/jvm/internal/Ref$IntRef;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$1$2;->$selected:Lkotlin/jvm/internal/Ref$IntRef;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onValueChange(Landroid/widget/NumberPicker;II)V
    .locals 0

    .line 154
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$showAgePicker$1$2;->$selected:Lkotlin/jvm/internal/Ref$IntRef;

    iput p3, p1, Lkotlin/jvm/internal/Ref$IntRef;->element:I

    return-void
.end method
