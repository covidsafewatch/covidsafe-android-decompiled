.class public final Lau/gov/health/covidsafe/logging/CentralLog;
.super Ljava/lang/Object;
.source "CentralLog.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/logging/CentralLog$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"
    }
    d2 = {
        "Lau/gov/health/covidsafe/logging/CentralLog;",
        "",
        "()V",
        "Companion",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

.field private static pm:Landroid/os/PowerManager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final synthetic access$getPm$cp()Landroid/os/PowerManager;
    .locals 1

    .line 8
    sget-object v0, Lau/gov/health/covidsafe/logging/CentralLog;->pm:Landroid/os/PowerManager;

    return-object v0
.end method

.method public static final synthetic access$setPm$cp(Landroid/os/PowerManager;)V
    .locals 0

    .line 8
    sput-object p0, Lau/gov/health/covidsafe/logging/CentralLog;->pm:Landroid/os/PowerManager;

    return-void
.end method
