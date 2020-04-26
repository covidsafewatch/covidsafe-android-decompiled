.class public final Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;
.super Ljava/lang/Object;
.source "NetworkFactory.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\r\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"
    }
    d2 = {
        "Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;",
        "",
        "()V",
        "BASE_URL",
        "",
        "builder",
        "Lretrofit2/Retrofit$Builder;",
        "kotlin.jvm.PlatformType",
        "retrofit",
        "Lretrofit2/Retrofit;",
        "createService",
        "S",
        "serviceClass",
        "Ljava/lang/Class;",
        "(Ljava/lang/Class;)Ljava/lang/Object;",
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
.field private static final BASE_URL:Ljava/lang/String; = "https://device-api.uat.unp.aws.covidsafe.gov.au"

.field public static final INSTANCE:Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;

.field private static final builder:Lretrofit2/Retrofit$Builder;

.field private static retrofit:Lretrofit2/Retrofit;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 29
    new-instance v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;

    invoke-direct {v0}, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->INSTANCE:Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;

    .line 31
    new-instance v0, Lretrofit2/Retrofit$Builder;

    invoke-direct {v0}, Lretrofit2/Retrofit$Builder;-><init>()V

    const-string v1, "https://device-api.prod.lp.aws.covidsafe.gov.au"

    .line 32
    invoke-virtual {v0, v1}, Lretrofit2/Retrofit$Builder;->baseUrl(Ljava/lang/String;)Lretrofit2/Retrofit$Builder;

    move-result-object v0

    .line 33
    invoke-static {}, Lretrofit2/converter/gson/GsonConverterFactory;->create()Lretrofit2/converter/gson/GsonConverterFactory;

    move-result-object v1

    check-cast v1, Lretrofit2/Converter$Factory;

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit$Builder;->addConverterFactory(Lretrofit2/Converter$Factory;)Lretrofit2/Retrofit$Builder;

    move-result-object v0

    sput-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->builder:Lretrofit2/Retrofit$Builder;

    .line 35
    invoke-virtual {v0}, Lretrofit2/Retrofit$Builder;->build()Lretrofit2/Retrofit;

    move-result-object v0

    sput-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->retrofit:Lretrofit2/Retrofit;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final createService(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TS;>;)TS;"
        }
    .end annotation

    const-string v0, "serviceClass"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    sget-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->builder:Lretrofit2/Retrofit$Builder;

    sget-object v1, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getOkHttpClient()Lokhttp3/OkHttpClient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lretrofit2/Retrofit$Builder;->client(Lokhttp3/OkHttpClient;)Lretrofit2/Retrofit$Builder;

    .line 40
    sget-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->builder:Lretrofit2/Retrofit$Builder;

    invoke-virtual {v0}, Lretrofit2/Retrofit$Builder;->build()Lretrofit2/Retrofit;

    move-result-object v0

    sput-object v0, Lau/gov/health/covidsafe/factory/RetrofitServiceGenerator;->retrofit:Lretrofit2/Retrofit;

    .line 42
    invoke-virtual {v0, p1}, Lretrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
