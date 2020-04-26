.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$nameTextWatcher$1;
.super Ljava/lang/Object;
.source "PersonalDetailsFragment.kt"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\u000c\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$nameTextWatcher$1",
        "Landroid/text/TextWatcher;",
        "afterTextChanged",
        "",
        "s",
        "Landroid/text/Editable;",
        "beforeTextChanged",
        "",
        "start",
        "",
        "count",
        "after",
        "onTextChanged",
        "before",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 34
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$nameTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .line 36
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$nameTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->hideNameError()V

    .line 37
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment$nameTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;->updateButtonState()V

    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method
