.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$onResume$1;
.super Ljava/lang/Object;
.source "RegistrationContentFragment.kt"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;->onResume()V
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
        "\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\u0008\u0007"
    }
    d2 = {
        "<anonymous>",
        "",
        "buttonView",
        "Landroid/widget/CompoundButton;",
        "kotlin.jvm.PlatformType",
        "isChecked",
        "",
        "onCheckedChanged"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$onResume$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 0

    .line 24
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment$onResume$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/registrationcontent/RegistrationContentFragment;->updateButtonState()V

    return-void
.end method
