.class final Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;
.super Lkotlin/jvm/internal/Lambda;
.source "HomeFragment.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/home/HomeFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/home/HomeFragment;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 34
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 2

    .line 94
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/home/HomeFragment$onViewCreated$3;->this$0:Lau/gov/health/covidsafe/ui/home/HomeFragment;

    invoke-static {v0}, Landroidx/navigation/fragment/FragmentKt;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object v0

    sget-object v1, Lau/gov/health/covidsafe/ui/home/HomeFragmentDirections;->Companion:Lau/gov/health/covidsafe/ui/home/HomeFragmentDirections$Companion;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/ui/home/HomeFragmentDirections$Companion;->actionHomeFragmentToHelpFragment()Landroidx/navigation/NavDirections;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/navigation/NavController;->navigate(Landroidx/navigation/NavDirections;)V

    return-void
.end method
