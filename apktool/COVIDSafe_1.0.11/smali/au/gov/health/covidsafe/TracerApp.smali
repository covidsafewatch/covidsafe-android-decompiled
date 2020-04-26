.class public final Lau/gov/health/covidsafe/TracerApp;
.super Landroid/app/Application;
.source "TracerApp.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/TracerApp$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"
    }
    d2 = {
        "Lau/gov/health/covidsafe/TracerApp;",
        "Landroid/app/Application;",
        "()V",
        "onCreate",
        "",
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
.field public static AppContext:Landroid/content/Context; = null

.field public static final Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

.field public static final ORG:Ljava/lang/String; = "AU_DTA"

.field private static final TAG:Ljava/lang/String; = "TracerApp"

.field public static final protocolVersion:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lau/gov/health/covidsafe/TracerApp$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/TracerApp$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 13
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method

.method public static final synthetic access$getAppContext$cp()Landroid/content/Context;
    .locals 1

    .line 13
    sget-object v0, Lau/gov/health/covidsafe/TracerApp;->AppContext:Landroid/content/Context;

    return-object v0
.end method

.method public static final synthetic access$setAppContext$cp(Landroid/content/Context;)V
    .locals 0

    .line 13
    sput-object p0, Lau/gov/health/covidsafe/TracerApp;->AppContext:Landroid/content/Context;

    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 2

    .line 16
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 17
    invoke-virtual {p0}, Lau/gov/health/covidsafe/TracerApp;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "applicationContext"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lau/gov/health/covidsafe/TracerApp;->AppContext:Landroid/content/Context;

    .line 18
    move-object v0, p0

    check-cast v0, Landroid/app/Application;

    invoke-static {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->init(Landroid/app/Application;)V

    return-void
.end method
