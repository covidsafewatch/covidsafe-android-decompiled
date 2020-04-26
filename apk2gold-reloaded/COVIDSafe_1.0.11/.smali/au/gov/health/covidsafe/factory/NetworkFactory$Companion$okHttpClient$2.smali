.class final Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;
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
        "Lokhttp3/OkHttpClient;",
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
        "Lokhttp3/OkHttpClient;",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;->this$0:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 11
    invoke-virtual {p0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;->invoke()Lokhttp3/OkHttpClient;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Lokhttp3/OkHttpClient;
    .locals 3

    .line 20
    new-instance v0, Lokhttp3/OkHttpClient$Builder;

    invoke-direct {v0}, Lokhttp3/OkHttpClient$Builder;-><init>()V

    .line 21
    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->interceptors()Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;->this$0:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-static {v2}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->access$getLogging$p(Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;)Lokhttp3/logging/HttpLoggingInterceptor;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    .line 24
    invoke-virtual {v0}, Lokhttp3/OkHttpClient$Builder;->build()Lokhttp3/OkHttpClient;

    move-result-object v0

    return-object v0
.end method
