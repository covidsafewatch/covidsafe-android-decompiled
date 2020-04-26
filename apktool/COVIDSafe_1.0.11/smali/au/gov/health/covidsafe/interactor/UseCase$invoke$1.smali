.class final Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UseCase.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/interactor/UseCase;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/coroutines/jvm/internal/SuspendLambda;",
        "Lkotlin/jvm/functions/Function2<",
        "Lkotlinx/coroutines/CoroutineScope;",
        "Lkotlin/coroutines/Continuation<",
        "-",
        "Lkotlin/Unit;",
        ">;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UseCase.kt\nau/gov/health/covidsafe/interactor/UseCase$invoke$1\n+ 2 Either.kt\nau/gov/health/covidsafe/interactor/Either\n*L\n1#1,76:1\n6#2,4:77\n*E\n*S KotlinDebug\n*F\n+ 1 UseCase.kt\nau/gov/health/covidsafe/interactor/UseCase$invoke$1\n*L\n28#1,4:77\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002 \u0001\"\u0006\u0008\u0001\u0010\u0003 \u0000*\u00020\u0004H\u008a@\u00a2\u0006\u0004\u0008\u0005\u0010\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "Type",
        "Params",
        "Lkotlinx/coroutines/CoroutineScope;",
        "invoke",
        "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation

.annotation runtime Lkotlin/coroutines/jvm/internal/DebugMetadata;
    c = "au.gov.health.covidsafe.interactor.UseCase$invoke$1"
    f = "UseCase.kt"
    i = {
        0x0,
        0x0
    }
    l = {
        0x1c
    }
    m = "invokeSuspend"
    n = {
        "$this$launch",
        "result"
    }
    s = {
        "L$0",
        "L$1"
    }
.end annotation


# instance fields
.field final synthetic $onFailure:Lkotlin/jvm/functions/Function1;

.field final synthetic $onSuccess:Lkotlin/jvm/functions/Function1;

.field final synthetic $params:Ljava/lang/Object;

.field L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field label:I

.field private p$:Lkotlinx/coroutines/CoroutineScope;

.field final synthetic this$0:Lau/gov/health/covidsafe/interactor/UseCase;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/interactor/UseCase;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->this$0:Lau/gov/health/covidsafe/interactor/UseCase;

    iput-object p2, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$params:Ljava/lang/Object;

    iput-object p3, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onFailure:Lkotlin/jvm/functions/Function1;

    iput-object p4, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onSuccess:Lkotlin/jvm/functions/Function1;

    const/4 p1, 0x2

    invoke-direct {p0, p1, p5}, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(ILkotlin/coroutines/Continuation;)V

    return-void
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lkotlin/coroutines/Continuation<",
            "*>;)",
            "Lkotlin/coroutines/Continuation<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    const-string v0, "completion"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;

    iget-object v2, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->this$0:Lau/gov/health/covidsafe/interactor/UseCase;

    iget-object v3, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$params:Ljava/lang/Object;

    iget-object v4, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onFailure:Lkotlin/jvm/functions/Function1;

    iget-object v5, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onSuccess:Lkotlin/jvm/functions/Function1;

    move-object v1, v0

    move-object v6, p2

    invoke-direct/range {v1 .. v6}, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;-><init>(Lau/gov/health/covidsafe/interactor/UseCase;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V

    check-cast p1, Lkotlinx/coroutines/CoroutineScope;

    iput-object p1, v0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->p$:Lkotlinx/coroutines/CoroutineScope;

    return-object v0
.end method

.method public final invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    check-cast p2, Lkotlin/coroutines/Continuation;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->create(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;

    move-result-object p1

    check-cast p1, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;

    sget-object p2, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    invoke-virtual {p1, p2}, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 9

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object v0

    .line 24
    iget v1, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->label:I

    const/4 v2, 0x1

    if-eqz v1, :cond_1

    if-ne v1, v2, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->L$1:Ljava/lang/Object;

    check-cast v0, Lkotlinx/coroutines/Deferred;

    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->L$0:Ljava/lang/Object;

    check-cast v0, Lkotlinx/coroutines/CoroutineScope;

    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    goto :goto_0

    .line 32
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 24
    :cond_1
    invoke-static {p1}, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V

    iget-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->p$:Lkotlinx/coroutines/CoroutineScope;

    .line 25
    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Lkotlin/coroutines/CoroutineContext;

    const/4 v5, 0x0

    new-instance v1, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1$result$1;

    const/4 v3, 0x0

    invoke-direct {v1, p0, v3}, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1$result$1;-><init>(Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;Lkotlin/coroutines/Continuation;)V

    move-object v6, v1

    check-cast v6, Lkotlin/jvm/functions/Function2;

    const/4 v7, 0x2

    const/4 v8, 0x0

    move-object v3, p1

    invoke-static/range {v3 .. v8}, Lkotlinx/coroutines/BuildersKt;->async$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Deferred;

    move-result-object v1

    .line 28
    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->L$0:Ljava/lang/Object;

    iput-object v1, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->L$1:Ljava/lang/Object;

    iput v2, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->label:I

    invoke-interface {v1, p0}, Lkotlinx/coroutines/Deferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    if-ne p1, v0, :cond_2

    return-object v0

    .line 24
    :cond_2
    :goto_0
    check-cast p1, Lau/gov/health/covidsafe/interactor/Either;

    .line 78
    instance-of v0, p1, Lau/gov/health/covidsafe/interactor/Failure;

    if-eqz v0, :cond_3

    check-cast p1, Lau/gov/health/covidsafe/interactor/Failure;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/Failure;->getFailure()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Exception;

    .line 29
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onFailure:Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 79
    :cond_3
    instance-of v0, p1, Lau/gov/health/covidsafe/interactor/Success;

    if-eqz v0, :cond_4

    check-cast p1, Lau/gov/health/covidsafe/interactor/Success;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/interactor/Success;->getSuccess()Ljava/lang/Object;

    move-result-object p1

    .line 30
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/UseCase$invoke$1;->$onSuccess:Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, p1}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    :goto_1
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1

    .line 30
    :cond_4
    new-instance p1, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p1}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p1
.end method
