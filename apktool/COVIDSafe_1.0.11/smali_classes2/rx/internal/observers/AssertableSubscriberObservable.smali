.class public Lrx/internal/observers/AssertableSubscriberObservable;
.super Lrx/Subscriber;
.source "AssertableSubscriberObservable.java"

# interfaces
.implements Lrx/observers/AssertableSubscriber;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;",
        "Lrx/observers/AssertableSubscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final ts:Lrx/observers/TestSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/observers/TestSubscriber<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/observers/TestSubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/observers/TestSubscriber<",
            "TT;>;)V"
        }
    .end annotation

    .line 41
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 42
    iput-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    return-void
.end method

.method public static create(J)Lrx/internal/observers/AssertableSubscriberObservable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(J)",
            "Lrx/internal/observers/AssertableSubscriberObservable<",
            "TT;>;"
        }
    .end annotation

    .line 46
    new-instance v0, Lrx/observers/TestSubscriber;

    invoke-direct {v0, p0, p1}, Lrx/observers/TestSubscriber;-><init>(J)V

    .line 47
    new-instance p0, Lrx/internal/observers/AssertableSubscriberObservable;

    invoke-direct {p0, v0}, Lrx/internal/observers/AssertableSubscriberObservable;-><init>(Lrx/observers/TestSubscriber;)V

    .line 48
    invoke-virtual {p0, v0}, Lrx/internal/observers/AssertableSubscriberObservable;->add(Lrx/Subscription;)V

    return-object p0
.end method


# virtual methods
.method public assertCompleted()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 212
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertCompleted()V

    return-object p0
.end method

.method public assertError(Ljava/lang/Class;)Lrx/observers/AssertableSubscriber;
    .locals 1
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

    .line 230
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertError(Ljava/lang/Class;)V

    return-object p0
.end method

.method public assertError(Ljava/lang/Throwable;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 239
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertError(Ljava/lang/Throwable;)V

    return-object p0
.end method

.method public final varargs assertFailure(Ljava/lang/Class;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 1
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

    .line 322
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p2}, Lrx/observers/TestSubscriber;->assertValues([Ljava/lang/Object;)V

    .line 323
    iget-object p2, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p2, p1}, Lrx/observers/TestSubscriber;->assertError(Ljava/lang/Class;)V

    .line 324
    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->assertNotCompleted()V

    return-object p0
.end method

.method public final varargs assertFailureAndMessage(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 2
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

    .line 331
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p3}, Lrx/observers/TestSubscriber;->assertValues([Ljava/lang/Object;)V

    .line 332
    iget-object p3, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p3, p1}, Lrx/observers/TestSubscriber;->assertError(Ljava/lang/Class;)V

    .line 333
    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->assertNotCompleted()V

    .line 335
    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->getOnErrorEvents()Ljava/util/List;

    move-result-object p1

    const/4 p3, 0x0

    invoke-interface {p1, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    if-eq p1, p2, :cond_1

    if-eqz p2, :cond_0

    .line 336
    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p3

    if-eqz p3, :cond_0

    goto :goto_0

    .line 337
    :cond_0
    new-instance p3, Ljava/lang/AssertionError;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Error message differs. Expected: \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p2, "\', Received: \'"

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, "\'"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw p3

    :cond_1
    :goto_0
    return-object p0
.end method

.method public assertNoErrors()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 167
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertNoErrors()V

    return-object p0
.end method

.method public assertNoTerminalEvent()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 248
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertNoTerminalEvent()V

    return-object p0
.end method

.method public assertNoValues()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 257
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertNoValues()V

    return-object p0
.end method

.method public assertNotCompleted()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 221
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertNotCompleted()V

    return-object p0
.end method

.method public assertReceivedOnNext(Ljava/util/List;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "TT;>;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 129
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertReceivedOnNext(Ljava/util/List;)V

    return-object p0
.end method

.method public final varargs assertResult([Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 314
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertValues([Ljava/lang/Object;)V

    .line 315
    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->assertNoErrors()V

    .line 316
    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->assertCompleted()V

    return-object p0
.end method

.method public assertTerminalEvent()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 149
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertTerminalEvent()V

    return-object p0
.end method

.method public assertUnsubscribed()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 158
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->assertUnsubscribed()V

    return-object p0
.end method

.method public assertValue(Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 284
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertValue(Ljava/lang/Object;)V

    return-object p0
.end method

.method public assertValueCount(I)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 266
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertValueCount(I)V

    return-object p0
.end method

.method public varargs assertValues([Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 275
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->assertValues([Ljava/lang/Object;)V

    return-object p0
.end method

.method public final varargs assertValuesAndClear(Ljava/lang/Object;[Ljava/lang/Object;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;[TT;)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 294
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1, p2}, Lrx/observers/TestSubscriber;->assertValuesAndClear(Ljava/lang/Object;[Ljava/lang/Object;)V

    return-object p0
.end method

.method public awaitTerminalEvent()Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 176
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->awaitTerminalEvent()V

    return-object p0
.end method

.method public awaitTerminalEvent(JLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 185
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1, p2, p3}, Lrx/observers/TestSubscriber;->awaitTerminalEvent(JLjava/util/concurrent/TimeUnit;)V

    return-object p0
.end method

.method public awaitTerminalEventAndUnsubscribeOnTimeout(JLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 195
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1, p2, p3}, Lrx/observers/TestSubscriber;->awaitTerminalEventAndUnsubscribeOnTimeout(JLjava/util/concurrent/TimeUnit;)V

    return-object p0
.end method

.method public final awaitValueCount(IJLjava/util/concurrent/TimeUnit;)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IJ",
            "Ljava/util/concurrent/TimeUnit;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 138
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1, p2, p3, p4}, Lrx/observers/TestSubscriber;->awaitValueCount(IJLjava/util/concurrent/TimeUnit;)Z

    move-result p2

    if-eqz p2, :cond_0

    return-object p0

    .line 139
    :cond_0
    new-instance p2, Ljava/lang/AssertionError;

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string p4, "Did not receive enough values in time. Expected: "

    invoke-virtual {p3, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ", Actual: "

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {p1}, Lrx/observers/TestSubscriber;->getValueCount()I

    move-result p1

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw p2
.end method

.method public final getCompletions()I
    .locals 1

    .line 78
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->getCompletions()I

    move-result v0

    return v0
.end method

.method public getLastSeenThread()Ljava/lang/Thread;
    .locals 1

    .line 204
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->getLastSeenThread()Ljava/lang/Thread;

    move-result-object v0

    return-object v0
.end method

.method public getOnErrorEvents()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/Throwable;",
            ">;"
        }
    .end annotation

    .line 91
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->getOnErrorEvents()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getOnNextEvents()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation

    .line 121
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->getOnNextEvents()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final getValueCount()I
    .locals 1

    .line 104
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->getValueCount()I

    move-result v0

    return v0
.end method

.method public onCompleted()V
    .locals 1

    .line 62
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 83
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 96
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->onNext(Ljava/lang/Object;)V

    return-void
.end method

.method public onStart()V
    .locals 1

    .line 57
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Lrx/observers/TestSubscriber;->onStart()V

    return-void
.end method

.method public final perform(Lrx/functions/Action0;)Lrx/observers/AssertableSubscriber;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Action0;",
            ")",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 303
    invoke-interface {p1}, Lrx/functions/Action0;->call()V

    return-object p0
.end method

.method public requestMore(J)Lrx/observers/AssertableSubscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)",
            "Lrx/observers/AssertableSubscriber<",
            "TT;>;"
        }
    .end annotation

    .line 112
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1, p2}, Lrx/observers/TestSubscriber;->requestMore(J)V

    return-object p0
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 1

    .line 70
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0, p1}, Lrx/observers/TestSubscriber;->setProducer(Lrx/Producer;)V

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .line 309
    iget-object v0, p0, Lrx/internal/observers/AssertableSubscriberObservable;->ts:Lrx/observers/TestSubscriber;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
