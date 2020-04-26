.class public final Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;
.super Ljava/lang/Object;
.source "NetworkFactory.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/factory/NetworkFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nNetworkFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkFactory.kt\nau/gov/health/covidsafe/factory/NetworkFactory$Companion\n*L\n1#1,44:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u000c8FX\u0086\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u000f\u0010\u0008\u001a\u0004\u0008\r\u0010\u000e\u00a8\u0006\u0010"
    }
    d2 = {
        "Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;",
        "",
        "()V",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "getAwsClient",
        "()Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "awsClient$delegate",
        "Lkotlin/Lazy;",
        "logging",
        "Lokhttp3/logging/HttpLoggingInterceptor;",
        "okHttpClient",
        "Lokhttp3/OkHttpClient;",
        "getOkHttpClient",
        "()Lokhttp3/OkHttpClient;",
        "okHttpClient$delegate",
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
.field static final synthetic $$INSTANCE:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

.field private static final awsClient$delegate:Lkotlin/Lazy;

.field private static final logging:Lokhttp3/logging/HttpLoggingInterceptor;

.field private static final okHttpClient$delegate:Lkotlin/Lazy;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 11
    new-instance v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-direct {v0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->$$INSTANCE:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    .line 12
    new-instance v1, Lokhttp3/logging/HttpLoggingInterceptor;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3, v2}, Lokhttp3/logging/HttpLoggingInterceptor;-><init>(Lokhttp3/logging/HttpLoggingInterceptor$Logger;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 13
    sget-object v2, Lokhttp3/logging/HttpLoggingInterceptor$Level;->BODY:Lokhttp3/logging/HttpLoggingInterceptor$Level;

    invoke-virtual {v1, v2}, Lokhttp3/logging/HttpLoggingInterceptor;->setLevel(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;

    move-result-object v1

    sput-object v1, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->logging:Lokhttp3/logging/HttpLoggingInterceptor;

    .line 15
    sget-object v1, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;->INSTANCE:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$awsClient$2;

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-static {v1}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v1

    sput-object v1, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->awsClient$delegate:Lkotlin/Lazy;

    .line 19
    new-instance v1, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;

    invoke-direct {v1, v0}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion$okHttpClient$2;-><init>(Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;)V

    check-cast v1, Lkotlin/jvm/functions/Function0;

    invoke-static {v1}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    sput-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->okHttpClient$delegate:Lkotlin/Lazy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final synthetic access$getLogging$p(Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;)Lokhttp3/logging/HttpLoggingInterceptor;
    .locals 0

    .line 11
    sget-object p0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->logging:Lokhttp3/logging/HttpLoggingInterceptor;

    return-object p0
.end method


# virtual methods
.method public final getAwsClient()Lau/gov/health/covidsafe/networking/service/AwsClient;
    .locals 1

    sget-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->awsClient$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lau/gov/health/covidsafe/networking/service/AwsClient;

    return-object v0
.end method

.method public final getOkHttpClient()Lokhttp3/OkHttpClient;
    .locals 1

    sget-object v0, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->okHttpClient$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lokhttp3/OkHttpClient;

    return-object v0
.end method
