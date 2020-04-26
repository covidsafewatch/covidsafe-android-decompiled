.class public interface abstract Lrx/observers/AssertableSubscriber;
.super Ljava/lang/Object;
.source "AssertableSubscriber.java"

# interfaces
.implements Lrx/Observer;
.implements Lrx/Subscription;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lrx/Observer<",
        "TT;>;",
        "Lrx/Subscription;"
    }
.end annotation


# virtual methods
.method public abstract assertCompleted()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertError(Ljava/lang/Class;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/lang/Throwable;",
            ">;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertError(Ljava/lang/Throwable;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public varargs abstract assertFailure(Ljava/lang/Class;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/lang/Throwable;",
            ">;[TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public varargs abstract assertFailureAndMessage(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Ljava/lang/Throwable;",
            ">;",
            "Ljava/lang/String;",
            "[TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertNoErrors()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertNoTerminalEvent()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertNoValues()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertNotCompleted()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertReceivedOnNext(Ljava/util/List;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "TT;>;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public varargs abstract assertResult([Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertTerminalEvent()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertUnsubscribed()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertValue(Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract assertValueCount(I)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public varargs abstract assertValues([Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public varargs abstract assertValuesAndClear(Ljava/lang/Object;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract awaitTerminalEvent()Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract awaitTerminalEvent(JLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract awaitTerminalEventAndUnsubscribeOnTimeout(JLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract awaitValueCount(IJLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract getCompletions()I
.end method

.method public abstract getLastSeenThread()Ljava/lang/Thread;
.end method

.method public abstract getOnErrorEvents()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/Throwable;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getOnNextEvents()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract getValueCount()I
.end method

.method public abstract isUnsubscribed()Z
.end method

.method public abstract onStart()V
.end method

.method public abstract perform(Lrx/functions/Action0;)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Action0;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract requestMore(J)Lrx/observers/AssertableSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation
.end method

.method public abstract setProducer(Lrx/Producer;)V
.end method

.method public abstract unsubscribe()V
.end method
