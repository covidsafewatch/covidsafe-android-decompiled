.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;
.super Lkotlin/jvm/internal/Lambda;
.source "PermissionFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;->getUploadButtonLayout()Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPermissionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionFragment.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1\n*L\n1#1,116:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 24
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 3

    .line 100
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 101
    sget-object v1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    const-string v2, "it"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/content/Context;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lau/gov/health/covidsafe/Preference;->putIsOnBoarded(Landroid/content/Context;Z)V

    .line 103
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment;

    new-instance v1, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1$2;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1$2;-><init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/permission/PermissionFragment$getUploadButtonLayout$1;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-static {v0, v1}, Lau/gov/health/covidsafe/extensions/PermissionExtensionsKt;->requestAllPermissions(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V

    return-void
.end method
