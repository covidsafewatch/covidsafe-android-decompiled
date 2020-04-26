.class final Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;
.super Lkotlin/jvm/internal/Lambda;
.source "NetworkFactory.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
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
        "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final INSTANCE:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;

    invoke-direct {v0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;->INSTANCE:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final invoke()Lau/gov/health/covidsafe/networking/service/AwsClient;
    .locals 2

    .line 16
    sget-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->INSTANCE:Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;

    const-class v1, Lau/gov/health/covidsafe/networking/service/AwsClient;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->createService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/networking/service/AwsClient;

    return-object v0
.end method

.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 11
    invoke-virtual {p0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;->invoke()Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object v0

    return-object v0
.end method
