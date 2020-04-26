.class public final Lau/gov/health/covidsafe/interactor/usecase/UploadData;
.super Lau/gov/health/covidsafe/interactor/UseCase;
.source "UploadData.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lau/gov/health/covidsafe/interactor/UseCase<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUploadData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UploadData.kt\nau/gov/health/covidsafe/interactor/usecase/UploadData\n*L\n1#1,88:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ)\u0010\r\u001a\u0012\u0012\u0008\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J)\u0010\u0013\u001a\u0012\u0012\u0008\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u000c\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0015"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/UploadData;",
        "Lau/gov/health/covidsafe/interactor/UseCase;",
        "",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "okHttpClient",
        "Lokhttp3/OkHttpClient;",
        "context",
        "Landroid/content/Context;",
        "lifecycle",
        "Landroidx/lifecycle/Lifecycle;",
        "(Lau/gov/health/covidsafe/networking/service/AwsClient;Lokhttp3/OkHttpClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V",
        "TAG",
        "run",
        "Lau/gov/health/covidsafe/interactor/Either;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "params",
        "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "zipAndUploadData",
        "uploadLink",
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
.field private final TAG:Ljava/lang/String;

.field private final awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

.field private final context:Landroid/content/Context;

.field private final okHttpClient:Lokhttp3/OkHttpClient;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Lokhttp3/OkHttpClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V
    .locals 1

    const-string v0, "awsClient"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "okHttpClient"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 24
    invoke-direct {p0, p4}, Lau/gov/health/covidsafe/interactor/UseCase;-><init>(Landroidx/lifecycle/Lifecycle;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    iput-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->okHttpClient:Lokhttp3/OkHttpClient;

    iput-object p3, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->context:Landroid/content/Context;

    .line 26
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string p2, "this.javaClass.simpleName"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->TAG:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$getAwsClient$p(Lau/gov/health/covidsafe/interactor/usecase/UploadData;)Lau/gov/health/covidsafe/networking/service/AwsClient;
    .locals 0

    .line 20
    iget-object p0, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    return-object p0
.end method

.method public static final synthetic access$getOkHttpClient$p(Lau/gov/health/covidsafe/interactor/usecase/UploadData;)Lokhttp3/OkHttpClient;
    .locals 0

    .line 20
    iget-object p0, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->okHttpClient:Lokhttp3/OkHttpClient;

    return-object p0
.end method


# virtual methods
.method public bridge synthetic run(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0

    .line 20
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->run(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public run(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;

    iget v1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_0

    iget p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    sub-int/2addr p2, v2

    iput p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;

    invoke-direct {v0, p0, p2}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;-><init>(Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lkotlin/coroutines/Continuation;)V

    :goto_0
    iget-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 29
    iget v2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    const/4 v3, 0x2

    const/4 v4, 0x1

    if-eqz v2, :cond_3

    if-eq v2, v4, :cond_2

    if-ne v2, v3, :cond_1

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$5:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$4:Ljava/lang/Object;

    check-cast p1, Lretrofit2/Response;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$3:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$2:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$1:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$0:Ljava/lang/Object;

    check-cast p1, Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    :try_start_0
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_4

    :catch_0
    move-exception p2

    goto/16 :goto_6

    .line 55
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 29
    :cond_2
    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$3:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object v2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$2:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    iget-object v5, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$1:Ljava/lang/Object;

    check-cast v5, Ljava/lang/String;

    iget-object v6, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$0:Ljava/lang/Object;

    check-cast v6, Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    :try_start_1
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-object v9, p2

    move-object p2, p1

    move-object p1, v6

    move-object v6, v2

    move-object v2, v9

    goto :goto_1

    :catch_1
    move-exception p2

    move-object p1, v6

    goto/16 :goto_6

    :cond_3
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 30
    sget-object p2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->context:Landroid/content/Context;

    invoke-virtual {p2, v2}, Lau/gov/health/covidsafe/Preference;->getEncrypterJWTToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p2

    if-eqz p2, :cond_e

    .line 33
    :try_start_2
    new-instance v2, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;

    invoke-direct {v2, p2, p0, v0, p1}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;-><init>(Ljava/lang/String;Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    iput-object p0, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$0:Ljava/lang/Object;

    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$1:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$2:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$3:Ljava/lang/Object;

    iput v4, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    invoke-virtual {p0, v2, v0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->retryRetrofitCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v2
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    if-ne v2, v1, :cond_4

    return-object v1

    :cond_4
    move-object v5, p1

    move-object v6, p2

    move-object p1, p0

    .line 29
    :goto_1
    :try_start_3
    check-cast v2, Lretrofit2/Response;

    if-nez v2, :cond_5

    .line 37
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    sget-object v0, Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;

    goto/16 :goto_7

    .line 38
    :cond_5
    invoke-virtual {v2}, Lretrofit2/Response;->isSuccessful()Z

    move-result v7

    if-eqz v7, :cond_b

    .line 39
    invoke-virtual {v2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;

    if-eqz v7, :cond_6

    invoke-virtual {v7}, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->getUploadLink()Ljava/lang/String;

    move-result-object v7

    goto :goto_2

    :cond_6
    const/4 v7, 0x0

    .line 40
    :goto_2
    move-object v8, v7

    check-cast v8, Ljava/lang/CharSequence;

    if-eqz v8, :cond_8

    invoke-interface {v8}, Ljava/lang/CharSequence;->length()I

    move-result v8

    if-nez v8, :cond_7

    goto :goto_3

    :cond_7
    const/4 v4, 0x0

    :cond_8
    :goto_3
    if-eqz v4, :cond_9

    .line 41
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_7

    .line 43
    :cond_9
    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$0:Ljava/lang/Object;

    iput-object v5, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$1:Ljava/lang/Object;

    iput-object v6, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$2:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$3:Ljava/lang/Object;

    iput-object v2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$4:Ljava/lang/Object;

    iput-object v7, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->L$5:Ljava/lang/Object;

    iput v3, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$1;->label:I

    invoke-virtual {p1, v7, v0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->zipAndUploadData(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p2

    if-ne p2, v1, :cond_a

    return-object v1

    .line 29
    :cond_a
    :goto_4
    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_7

    .line 45
    :cond_b
    invoke-virtual {v2}, Lretrofit2/Response;->code()I

    move-result p2

    const/16 v0, 0x190

    if-ne p2, v0, :cond_c

    .line 46
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    sget-object v0, Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataIncorrectPinException;

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    goto :goto_5

    .line 47
    :cond_c
    invoke-virtual {v2}, Lretrofit2/Response;->code()I

    move-result p2

    const/16 v0, 0x193

    if-ne p2, v0, :cond_d

    .line 48
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    sget-object v0, Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/UploadDataException$UploadDataJwtExpiredException;

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    goto :goto_5

    .line 50
    :cond_d
    new-instance p2, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    invoke-direct {p2, v0}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    .line 45
    :goto_5
    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_7

    :catch_2
    move-exception p2

    move-object p1, p0

    .line 53
    :goto_6
    new-instance v0, Lau/gov/health/covidsafe/interactor/Failure;

    invoke-direct {v0, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    move-object p2, v0

    check-cast p2, Lau/gov/health/covidsafe/interactor/Either;

    :goto_7
    if-eqz p2, :cond_f

    return-object p2

    :cond_e
    move-object p1, p0

    .line 55
    :cond_f
    check-cast p1, Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    .line 56
    new-instance p1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance p2, Ljava/lang/Exception;

    invoke-direct {p2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    return-object p1
.end method

.method final synthetic zipAndUploadData(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;

    iget v1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_0

    iget p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->label:I

    sub-int/2addr p2, v2

    iput p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;

    invoke-direct {v0, p0, p2}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;-><init>(Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lkotlin/coroutines/Continuation;)V

    :goto_0
    iget-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 60
    iget v2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->label:I

    const/4 v3, 0x1

    if-eqz v2, :cond_2

    if-ne v2, v3, :cond_1

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$4:Ljava/lang/Object;

    check-cast p1, Lokhttp3/Request;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$3:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$2:Ljava/lang/Object;

    check-cast p1, Lau/gov/health/covidsafe/ui/upload/model/ExportData;

    iget-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$1:Ljava/lang/Object;

    check-cast p1, Ljava/lang/String;

    iget-object v0, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$0:Ljava/lang/Object;

    check-cast v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    :try_start_0
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 70
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 60
    :cond_2
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 61
    new-instance p2, Lau/gov/health/covidsafe/ui/upload/model/ExportData;

    new-instance v2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    sget-object v4, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v4}, Lau/gov/health/covidsafe/TracerApp$Companion;->getAppContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v2, v4}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->getAllRecords()Ljava/util/List;

    move-result-object v2

    invoke-direct {p2, v2}, Lau/gov/health/covidsafe/ui/upload/model/ExportData;-><init>(Ljava/util/List;)V

    .line 62
    sget-object v2, Lau/gov/health/covidsafe/logging/CentralLog;->Companion:Lau/gov/health/covidsafe/logging/CentralLog$Companion;

    iget-object v4, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "records: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/ui/upload/model/ExportData;->getRecords()Ljava/util/List;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lau/gov/health/covidsafe/logging/CentralLog$Companion;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v2, p2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 66
    new-instance v4, Lokhttp3/Request$Builder;

    invoke-direct {v4}, Lokhttp3/Request$Builder;-><init>()V

    .line 67
    invoke-virtual {v4, p1}, Lokhttp3/Request$Builder;->url(Ljava/lang/String;)Lokhttp3/Request$Builder;

    move-result-object v4

    .line 68
    sget-object v5, Lokhttp3/RequestBody;->Companion:Lokhttp3/RequestBody$Companion;

    const-string v6, "jsonData"

    invoke-static {v2, v6}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v6, 0x0

    invoke-virtual {v5, v2, v6}, Lokhttp3/RequestBody$Companion;->create(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;

    move-result-object v5

    invoke-virtual {v4, v5}, Lokhttp3/Request$Builder;->put(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;

    move-result-object v4

    .line 69
    invoke-virtual {v4}, Lokhttp3/Request$Builder;->build()Lokhttp3/Request;

    move-result-object v4

    .line 71
    :try_start_1
    new-instance v5, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;

    invoke-direct {v5, p0, v4}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;-><init>(Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lokhttp3/Request;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    iput-object p0, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$0:Ljava/lang/Object;

    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$1:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$2:Ljava/lang/Object;

    iput-object v2, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$3:Ljava/lang/Object;

    iput-object v4, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->L$4:Ljava/lang/Object;

    iput v3, v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$1;->label:I

    invoke-virtual {p0, v5, v0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->retryOkhttpCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p2

    if-ne p2, v1, :cond_3

    return-object v1

    .line 60
    :cond_3
    :goto_1
    check-cast p2, Lokhttp3/Response;

    if-nez p2, :cond_4

    .line 73
    new-instance p1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance p2, Ljava/lang/Exception;

    invoke-direct {p2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_2

    .line 75
    :cond_4
    new-instance p2, Lau/gov/health/covidsafe/interactor/Success;

    invoke-direct {p2, p1}, Lau/gov/health/covidsafe/interactor/Success;-><init>(Ljava/lang/Object;)V

    move-object p1, p2

    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    :goto_2
    return-object p1

    .line 78
    :catch_0
    new-instance p1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance p2, Ljava/lang/Exception;

    invoke-direct {p2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {p1, p2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    return-object p1
.end method
