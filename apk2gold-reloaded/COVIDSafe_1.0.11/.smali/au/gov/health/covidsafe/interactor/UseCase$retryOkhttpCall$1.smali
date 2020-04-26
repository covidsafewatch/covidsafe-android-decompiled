.class final Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "UseCase.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/interactor/UseCase;->retryOkhttpCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\u0008\u0000\u0010\u0002 \u0001\"\u0006\u0008\u0001\u0010\u0003 \u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0008H\u0084@"
    }
    d2 = {
        "retryOkhttpCall",
        "",
        "Type",
        "Params",
        "call",
        "Lkotlin/Function0;",
        "Lokhttp3/Response;",
        "continuation",
        "Lkotlin/coroutines/Continuation;"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation

.annotation runtime Lkotlin/coroutines/jvm/internal/DebugMetadata;
    c = "au.gov.health.covidsafe.interactor.UseCase"
    f = "UseCase.kt"
    i = {
        0x0,
        0x0,
        0x0,
        0x0,
        0x0
    }
    l = {
        0x3e
    }
    m = "retryOkhttpCall"
    n = {
        "this",
        "call",
        "response",
        "retryCount",
        "interval"
    }
    s = {
        "L$0",
        "L$1",
        "L$2",
        "I$0",
        "J$0"
    }
.end annotation


# instance fields
.field I$0:I

.field J$0:J

.field L$0:Ljava/lang/Object;

.field L$1:Ljava/lang/Object;

.field L$2:Ljava/lang/Object;

.field label:I

.field synthetic result:Ljava/lang/Object;

.field final synthetic this$0:Lau/gov/health/covidsafe/interactor/UseCase;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/interactor/UseCase;Lkotlin/coroutines/Continuation;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->this$0:Lau/gov/health/covidsafe/interactor/UseCase;

    invoke-direct {p0, p2}, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V

    return-void
.end method


# virtual methods
.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->result:Ljava/lang/Object;

    iget p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    const/high16 v0, -0x80000000

    or-int/2addr p1, v0

    iput p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->label:I

    iget-object p1, p0, Lau/gov/health/covidsafe/interactor/UseCase$retryOkhttpCall$1;->this$0:Lau/gov/health/covidsafe/interactor/UseCase;

    const/4 v0, 0x0

    invoke-virtual {p1, v0, p0}, Lau/gov/health/covidsafe/interactor/UseCase;->retryOkhttpCall(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method
