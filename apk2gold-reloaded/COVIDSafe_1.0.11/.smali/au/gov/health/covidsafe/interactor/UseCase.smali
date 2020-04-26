.class public abstract Lau/gov/health/covidsafe/interactor/UseCase;
.super Ljava/lang/Object;
.source "UseCase.kt"

# interfaces
.implements Lkotlinx/coroutines/CoroutineScope;
.implements Landroidx/lifecycle/LifecycleObserver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/interactor/UseCase$None;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Type:",
        "Ljava/lang/Object;",
        "Params:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lkotlinx/coroutines/CoroutineScope;",
        "Landroidx/lifecycle/LifecycleObserver;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UseCase.kt\nau/gov/health/covidsafe/interactor/UseCase\n*L\n1#1,76:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000`\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008&\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0001*\u0006\u0008\u0001\u0010\u0002 \u00002\u00020\u00032\u00020\u0004:\u0001$B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007JB\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0008\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u000f0\u0012H\u0086\u0002\u00a2\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u000fH\u0007J\u0008\u0010\u0018\u001a\u00020\u000fH\u0007J#\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001cH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H \u0018\u00010\u001f\"\u0004\u0008\u0002\u0010 2\u0014\u0010\u001b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H \u0018\u00010\u001f0\u001cH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ)\u0010!\u001a\u0012\u0012\u0008\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0010\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#R\u0012\u0010\u0008\u001a\u00020\tX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006%"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/UseCase;",
        "Type",
        "Params",
        "Lkotlinx/coroutines/CoroutineScope;",
        "Landroidx/lifecycle/LifecycleObserver;",
        "lifecycle",
        "Landroidx/lifecycle/Lifecycle;",
        "(Landroidx/lifecycle/Lifecycle;)V",
        "coroutineContext",
        "Lkotlin/coroutines/CoroutineContext;",
        "getCoroutineContext",
        "()Lkotlin/coroutines/CoroutineContext;",
        "job",
        "Lkotlinx/coroutines/Job;",
        "invoke",
        "",
        "params",
        "onSuccess",
        "Lkotlin/Function1;",
        "onFailure",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V",
        "onDestroy",
        "onStop",
        "retryOkhttpCall",
        "Lokhttp3/Response;",
        "call",
        "Lkotlin/Function0;",
        "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "retryRetrofitCall",
        "Lretrofit2/Response;",
        "S",
        "run",
        "Lau/gov/health/covidsafe/interactor/Either;",
        "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "None",
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
.field private final synthetic $$delegate_0:Lkotlinx/coroutines/CoroutineScope;

.field private job:Lkotlinx/coroutines/Job;


# direct methods
.method public constructor <init>(Landroidx/lifecycle/Lifecycle;)V
    .locals 2

    const-string v0, "lifecycle"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Lkotlinx/coroutines/CoroutineScopeKt;->MainScope()Lkotlinx/coroutines/CoroutineScope;

    move-result-object v0

    iput-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase;->$$delegate_0:Lkotlinx/coroutines/CoroutineScope;

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 14
    invoke-static {v0, v1, v0}, Lkotlinx/coroutines/JobKt;->Job$default(Lkotlinx/coroutines/Job;ILjava/lang/Object;)Lkotlinx/coroutines/CompletableJob;

    move-result-object v0

    check-cast v0, Lkotlinx/coroutines/Job;

    iput-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase;->job:Lkotlinx/coroutines/Job;

    .line 17
    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method


# virtual methods
.method public getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase;->$$delegate_0:Lkotlinx/coroutines/CoroutineScope;

    invoke-interface {v0}, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;

    move-result-object v0

    return-object v0
.end method

.method public final invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TParams;",
            "Lkotlin/jvm/functions/Function1<",
            "-TType;",
            "Lkotlin/Unit;",
            ">;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Ljava/lang/Exception;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "onSuccess"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "onFailure"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 23
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase;->job:Lkotlinx/coroutines/Job;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, v1, v2, v1}, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    .line 24
    invoke-virtual {p0}, Lau/gov/health/covidsafe/interactor/UseCase;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;

    move-result-object v4

    new-instance v0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;

    const/4 v10, 0x0

    move-object v5, v0

    move-object v6, p0

    move-object v7, p1

    move-object v8, p3

    move-object v9, p2

    invoke-direct/range {v5 .. v10}, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;-><init>(Lau/gov/health/covidsafe/interactor/UseCase;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V

    move-object v6, v0

    check-cast v6, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x0

    const/4 v7, 0x2

    const/4 v8, 0x0

    move-object v3, p0

    invoke-static/range {v3 .. v8}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase;->job:Lkotlinx/coroutines/Job;

    return-void
.end method

.method public final onDestroy()V
    .locals 2
    .annotation runtime Landroidx/lifecycle/OnLifecycleEvent;
        value = .enum Landroidx/lifecycle/Lifecycle$Event;->ON_DESTROY:Landroidx/lifecycle/Lifecycle$Event;
    .end annotation

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 42
    invoke-static {p0, v0, v1, v0}, Lkotlinx/coroutines/CoroutineScopeKt;->cancel$default(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    return-void
.end method

.method public final onStop()V
    .locals 3
    .annotation runtime Landroidx/lifecycle/OnLifecycleEvent;
        value = .enum Landroidx/lifecycle/Lifecycle$Event;->ON_STOP:Landroidx/lifecycle/Lifecycle$Event;
    .end annotation

    .line 37
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase;->job:Lkotlinx/coroutines/Job;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, v1, v2, v1}, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;ILjava/lang/Object;)V

    return-void
.end method

.method protected final retryOkhttpCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function0<",
            "Lokhttp3/Response;",
            ">;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lokhttp3/Response;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;

    iget v1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_0

    iget p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    sub-int/2addr p2, v2

    iput p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;

    invoke-direct {v0, p0, p2}, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;-><init>(Lau/gov/health/covidsafe/interactor/UseCase;Lkotlin/coroutines/Continuation;)V

    :goto_0
    iget-object p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 57
    iget v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    const/4 v3, 0x1

    if-eqz v2, :cond_2

    if-ne v2, v3, :cond_1

    iget-wide v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->J$0:J

    iget p1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->I$0:I

    iget-object v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$2:Ljava/lang/Object;

    check-cast v2, Lokhttp3/Response;

    iget-object v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$1:Ljava/lang/Object;

    check-cast v2, Lkotlin/jvm/functions/Function0;

    iget-object v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$0:Ljava/lang/Object;

    check-cast v4, Lau/gov/health/covidsafe/interactor/UseCase;

    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v9, v2

    move v2, p1

    move-object p1, v9

    goto :goto_2

    .line 66
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 57
    :cond_2
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 58
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lokhttp3/Response;

    const/4 v2, 0x0

    move-object v4, p0

    :goto_1
    if-eqz p2, :cond_3

    .line 60
    invoke-virtual {p2}, Lokhttp3/Response;->isSuccessful()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-virtual {p2}, Lokhttp3/Response;->body()Lokhttp3/ResponseBody;

    move-result-object v5

    if-nez v5, :cond_5

    :cond_3
    invoke-static {}, Lau/gov/health/covidsafe/interactor/UseCaseKt;->access$getRETRIES_LIMIT$p()I

    move-result v5

    if-ge v2, v5, :cond_5

    const/4 v5, 0x2

    int-to-double v5, v5

    int-to-double v7, v2

    .line 61
    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    double-to-long v5, v5

    const/16 v7, 0x3e8

    int-to-long v7, v7

    mul-long/2addr v5, v7

    .line 62
    iput-object v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$0:Ljava/lang/Object;

    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$1:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->L$2:Ljava/lang/Object;

    iput v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->I$0:I

    iput-wide v5, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->J$0:J

    iput v3, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    invoke-static {v5, v6, v0}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p2

    if-ne p2, v1, :cond_4

    return-object v1

    .line 63
    :cond_4
    :goto_2
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lokhttp3/Response;

    add-int/2addr v2, v3

    goto :goto_1

    :cond_5
    if-eqz p2, :cond_6

    .line 66
    invoke-virtual {p2}, Lokhttp3/Response;->isSuccessful()Z

    move-result p1

    if-eqz p1, :cond_6

    goto :goto_3

    :cond_6
    const/4 p2, 0x0

    :goto_3
    return-object p2
.end method

.method protected final retryRetrofitCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function0<",
            "Lretrofit2/Response<",
            "TS;>;>;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lretrofit2/Response<",
            "TS;>;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    instance-of v0, p2, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;

    if-eqz v0, :cond_0

    move-object v0, p2

    check-cast v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;

    iget v1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->label:I

    const/high16 v2, -0x80000000

    and-int/2addr v1, v2

    if-eqz v1, :cond_0

    iget p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->label:I

    sub-int/2addr p2, v2

    iput p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->label:I

    goto :goto_0

    :cond_0
    new-instance v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;

    invoke-direct {v0, p0, p2}, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;-><init>(Lau/gov/health/covidsafe/interactor/UseCase;Lkotlin/coroutines/Continuation;)V

    :goto_0
    iget-object p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->result:Ljava/lang/Object;

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v1

    .line 45
    iget v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->label:I

    const/4 v3, 0x1

    if-eqz v2, :cond_2

    if-ne v2, v3, :cond_1

    iget-wide v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->J$0:J

    iget p1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->I$0:I

    iget-object v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$2:Ljava/lang/Object;

    check-cast v2, Lretrofit2/Response;

    iget-object v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$1:Ljava/lang/Object;

    check-cast v2, Lkotlin/jvm/functions/Function0;

    iget-object v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$0:Ljava/lang/Object;

    check-cast v4, Lau/gov/health/covidsafe/interactor/UseCase;

    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    move-object v9, v2

    move v2, p1

    move-object p1, v9

    goto :goto_2

    .line 54
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 45
    :cond_2
    invoke-static {p2}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    .line 46
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lretrofit2/Response;

    const/4 v2, 0x0

    move-object v4, p0

    :goto_1
    if-eqz p2, :cond_4

    .line 48
    invoke-virtual {p2}, Lretrofit2/Response;->isSuccessful()Z

    move-result v5

    if-nez v5, :cond_3

    invoke-virtual {p2}, Lretrofit2/Response;->code()I

    move-result v5

    const/16 v6, 0x193

    if-ne v5, v6, :cond_4

    :cond_3
    invoke-virtual {p2}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v5

    if-nez v5, :cond_6

    :cond_4
    invoke-static {}, Lau/gov/health/covidsafe/interactor/UseCaseKt;->access$getRETRIES_LIMIT$p()I

    move-result v5

    if-ge v2, v5, :cond_6

    const/4 v5, 0x2

    int-to-double v5, v5

    int-to-double v7, v2

    .line 49
    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    double-to-long v5, v5

    const/16 v7, 0x3e8

    int-to-long v7, v7

    mul-long/2addr v5, v7

    .line 50
    iput-object v4, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$0:Ljava/lang/Object;

    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$1:Ljava/lang/Object;

    iput-object p2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->L$2:Ljava/lang/Object;

    iput v2, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->I$0:I

    iput-wide v5, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->J$0:J

    iput v3, v0, Lau/gov/health/covidsafe/interactor/UseCase$retryRetrofitCall$1;->label:I

    invoke-static {v5, v6, v0}, Lkotlinx/coroutines/DelayKt;->delay(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p2

    if-ne p2, v1, :cond_5

    return-object v1

    .line 51
    :cond_5
    :goto_2
    invoke-interface {p1}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lretrofit2/Response;

    add-int/2addr v2, v3

    goto :goto_1

    :cond_6
    return-object p2
.end method

.method public abstract run(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TParams;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lau/gov/health/covidsafe/interactor/Either<",
            "+",
            "Ljava/lang/Exception;",
            "+TType;>;>;)",
            "Ljava/lang/Object;"
        }
    .end annotation
.end method
