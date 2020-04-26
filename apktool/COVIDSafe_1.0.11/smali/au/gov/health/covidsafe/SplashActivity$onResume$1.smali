.class final Lau/gov/health/covidsafe/SplashActivity$onResume$1;
.super Ljava/lang/Object;
.source "SplashActivity.kt"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/SplashActivity;->onResume()V
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
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
        "run"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/SplashActivity;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/SplashActivity;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/SplashActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SplashActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 61
    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SplashActivity;

    invoke-static {v0}, Lau/gov/health/covidsafe/SplashActivity;->access$goToNextScreen(Lau/gov/health/covidsafe/SplashActivity;)V

    .line 62
    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity$onResume$1;->this$0:Lau/gov/health/covidsafe/SplashActivity;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/SplashActivity;->finish()V

    return-void
.end method
