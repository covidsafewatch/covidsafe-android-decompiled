.class final Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;
.super Lrx/Subscriber;
.source "OnSubscribeTimeoutTimedWithFallback.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "FallbackSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final actual:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final arbiter:Lrx/internal/producers/ProducerArbiter;


# direct methods
.method constructor <init>(Lrx/Subscriber;Lrx/internal/producers/ProducerArbiter;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;",
            "Lrx/internal/producers/ProducerArbiter;",
            ")V"
        }
    .end annotation

    .line 202
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 203
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->actual:Lrx/Subscriber;

    .line 204
    iput-object p2, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 219
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 214
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 209
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    return-void
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 1

    .line 224
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeTimeoutTimedWithFallback$FallbackSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    invoke-virtual {v0, p1}, Lrx/internal/producers/ProducerArbiter;->setProducer(Lrx/Producer;)V

    return-void
.end method
