.class public final Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;
.super Lau/gov/health/covidsafe/interactor/UseCase;
.source "UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lau/gov/health/covidsafe/interactor/UseCase<",
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt\nau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff\n*L\n1#1,69:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J+\u0010\u0012\u001a\u0012\u0012\u0008\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00020\u00132\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0018"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;",
        "Lau/gov/health/covidsafe/interactor/UseCase;",
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
        "Ljava/lang/Void;",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "context",
        "Landroid/content/Context;",
        "lifecycle",
        "Landroidx/lifecycle/Lifecycle;",
        "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V",
        "RETRIES_LIMIT",
        "",
        "TAG",
        "",
        "call",
        "Lretrofit2/Response;",
        "jwtToken",
        "run",
        "Lau/gov/health/covidsafe/interactor/Either;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "params",
        "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
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
.field private final RETRIES_LIMIT:I

.field private final TAG:Ljava/lang/String;

.field private final awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

.field private final context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V
    .locals 1

    const-string v0, "awsClient"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "context"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "lifecycle"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 19
    invoke-direct {p0, p3}, Lau/gov/health/covidsafe/interactor/UseCase;-><init>(Landroidx/lifecycle/Lifecycle;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    iput-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->context:Landroid/content/Context;

    .line 21
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string p2, "this.javaClass.simpleName"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->TAG:Ljava/lang/String;

    const/4 p1, 0x3

    .line 22
    iput p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->RETRIES_LIMIT:I

    return-void
.end method

.method private final call(Ljava/lang/String;)Lretrofit2/Response;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lretrofit2/Response<",
            "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
            ">;"
        }
    .end annotation

    .line 63
    :try_start_0
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bearer "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-interface {v0, p1}, Lau/gov/health/covidsafe/networking/service/AwsClient;->getTempId(Ljava/lang/String;)Lretrofit2/Call;

    move-result-object p1

    invoke-interface {p1}, Lretrofit2/Call;->execute()Lretrofit2/Response;

    move-result-object p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    const/4 p1, 0x0

    :goto_0
    return-object p1
.end method


# virtual methods
.method public bridge synthetic run(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0

    .line 17
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->run(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public run(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Void;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
            ">;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    instance-of v2, v1, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;

    if-eqz v2, :cond_0

    move-object v2, v1

    check-cast v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;

    iget v3, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->label:I

    const/high16 v4, -0x80000000

    and-int/2addr v3, v4

    if-eqz v3, :cond_0

    iget v1, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->label:I

    sub-int/2addr v1, v4

    iput v1, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;

    invoke-direct {v2, v0, v1}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;-><init>(Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;Lkotlin/coroutines/Continuation;)V

    :goto_0
    iget-object v1, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v3

    .line 24
    iget v4, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->label:I

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-eqz v4, :cond_2

    if-ne v4, v6, :cond_1

    iget-wide v7, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->J$0:J

    iget v4, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->I$0:I

    iget-object v7, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$4:Ljava/lang/Object;

    check-cast v7, Lretrofit2/Response;

    iget-object v7, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$3:Ljava/lang/Object;

    check-cast v7, Ljava/lang/String;

    iget-object v8, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$2:Ljava/lang/Object;

    check-cast v8, Ljava/lang/String;

    iget-object v9, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$1:Ljava/lang/Object;

    check-cast v9, Ljava/lang/Void;

    iget-object v10, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$0:Ljava/lang/Object;

    check-cast v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    invoke-static {v1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v1, v9

    move-object v9, v8

    move-object v8, v7

    goto :goto_2

    .line 56
    :cond_1
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 24
    :cond_2
    invoke-static {v1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 25
    sget-object v1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v4, v0, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->context:Landroid/content/Context;

    invoke-virtual {v1, v4}, Lau/gov/health/covidsafe/Preference;->getEncrypterJWTToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_d

    .line 27
    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->call(Ljava/lang/String;)Lretrofit2/Response;

    move-result-object v4

    move-object v10, v0

    move-object v8, v1

    move-object v9, v8

    move v7, v5

    move-object/from16 v1, p1

    :goto_1
    const/16 v11, 0x3e8

    if-eqz v4, :cond_3

    .line 29
    invoke-virtual {v4}, Lretrofit2/Response;->isSuccessful()Z

    move-result v12

    if-eqz v12, :cond_3

    invoke-virtual {v4}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v12

    if-nez v12, :cond_5

    :cond_3
    iget v12, v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->RETRIES_LIMIT:I

    if-ge v7, v12, :cond_5

    const/4 v12, 0x2

    int-to-double v12, v12

    int-to-double v14, v7

    .line 30
    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v12

    double-to-long v12, v12

    int-to-long v14, v11

    mul-long/2addr v12, v14

    .line 31
    iput-object v10, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$0:Ljava/lang/Object;

    iput-object v1, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$1:Ljava/lang/Object;

    iput-object v9, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$2:Ljava/lang/Object;

    iput-object v8, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$3:Ljava/lang/Object;

    iput-object v4, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->L$4:Ljava/lang/Object;

    iput v7, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->I$0:I

    iput-wide v12, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->J$0:J

    iput v6, v2, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1;->label:I

    invoke-static {v12, v13, v2}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object v4

    if-ne v4, v3, :cond_4

    return-object v3

    :cond_4
    move v4, v7

    .line 32
    :goto_2
    invoke-direct {v10, v8}, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->call(Ljava/lang/String;)Lretrofit2/Response;

    move-result-object v7

    add-int/2addr v4, v6

    move-object/from16 v16, v7

    move v7, v4

    move-object/from16 v4, v16

    goto :goto_1

    :cond_5
    if-eqz v4, :cond_c

    .line 36
    invoke-virtual {v4}, Lretrofit2/Response;->isSuccessful()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 37
    invoke-virtual {v4}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    if-eqz v1, :cond_b

    .line 38
    invoke-virtual {v1}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->getTempId()Ljava/lang/String;

    move-result-object v2

    check-cast v2, Ljava/lang/CharSequence;

    if-eqz v2, :cond_6

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    if-nez v2, :cond_7

    :cond_6
    move v5, v6

    :cond_7
    if-eqz v5, :cond_8

    .line 39
    new-instance v1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v2, Ljava/lang/Exception;

    invoke-direct {v2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {v1, v2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast v1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_4

    .line 41
    :cond_8
    invoke-virtual {v1}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->getExpiryTime()Ljava/lang/String;

    move-result-object v2

    const-wide/16 v3, 0x0

    if-eqz v2, :cond_9

    .line 42
    invoke-static {v2}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_9

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    goto :goto_3

    :cond_9
    move-wide v5, v3

    .line 43
    :goto_3
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v7, v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->context:Landroid/content/Context;

    int-to-long v8, v11

    mul-long/2addr v5, v8

    invoke-virtual {v2, v7, v5, v6}, Lau/gov/health/covidsafe/Preference;->putExpiryTimeInMillis(Landroid/content/Context;J)V

    .line 44
    invoke-virtual {v1}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->getRefreshTime()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_a

    .line 45
    invoke-static {v2}, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    if-eqz v2, :cond_a

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 46
    :cond_a
    sget-object v2, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    iget-object v5, v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->context:Landroid/content/Context;

    mul-long/2addr v3, v8

    invoke-virtual {v2, v5, v3, v4}, Lau/gov/health/covidsafe/Preference;->putNextFetchTimeInMillis(Landroid/content/Context;J)V

    .line 47
    sget-object v2, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    iget-object v3, v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;->context:Landroid/content/Context;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->getTempId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lau/gov/health/covidsafe/Utils;->storeBroadcastMessage(Landroid/content/Context;Ljava/lang/String;)V

    .line 48
    new-instance v2, Lau/gov/health/covidsafe/interactor/Success;

    invoke-direct {v2, v1}, Lau/gov/health/covidsafe/interactor/Success;-><init>(Ljava/lang/Object;)V

    move-object v1, v2

    check-cast v1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_4

    .line 50
    :cond_b
    check-cast v10, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    .line 51
    new-instance v1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v2, Ljava/lang/Exception;

    invoke-direct {v2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {v1, v2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    .line 50
    check-cast v1, Lau/gov/health/covidsafe/interactor/Either;

    goto :goto_4

    .line 54
    :cond_c
    new-instance v1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v2, Ljava/lang/Exception;

    invoke-direct {v2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {v1, v2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    check-cast v1, Lau/gov/health/covidsafe/interactor/Either;

    :goto_4
    return-object v1

    .line 56
    :cond_d
    move-object v1, v0

    check-cast v1, Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;

    .line 57
    new-instance v1, Lau/gov/health/covidsafe/interactor/Failure;

    new-instance v2, Ljava/lang/Exception;

    invoke-direct {v2}, Ljava/lang/Exception;-><init>()V

    invoke-direct {v1, v2}, Lau/gov/health/covidsafe/interactor/Failure;-><init>(Ljava/lang/Object;)V

    return-object v1
.end method
