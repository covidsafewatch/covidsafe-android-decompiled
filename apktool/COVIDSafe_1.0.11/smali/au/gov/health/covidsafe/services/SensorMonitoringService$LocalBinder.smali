.class public final Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;
.super Landroid/os/Binder;
.source "SensorMonitoringService.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/services/SensorMonitoringService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "LocalBinder"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;",
        "Landroid/os/Binder;",
        "(Lau/gov/health/covidsafe/services/SensorMonitoringService;)V",
        "getService",
        "Lau/gov/health/covidsafe/services/SensorMonitoringService;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/services/SensorMonitoringService;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/services/SensorMonitoringService;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 52
    iput-object p1, p0, Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;->this$0:Lau/gov/health/covidsafe/services/SensorMonitoringService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method


# virtual methods
.method public final getService()Lau/gov/health/covidsafe/services/SensorMonitoringService;
    .locals 1

    .line 54
    iget-object v0, p0, Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;->this$0:Lau/gov/health/covidsafe/services/SensorMonitoringService;

    return-object v0
.end method
