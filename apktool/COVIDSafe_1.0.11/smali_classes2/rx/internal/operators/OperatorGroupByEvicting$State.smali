.class final Lrx/internal/operators/OperatorGroupByEvicting$State;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "OperatorGroupByEvicting.java"

# interfaces
.implements Lrx/Producer;
.implements Lrx/Subscription;
.implements Lrx/Observable$OnSubscribe;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorGroupByEvicting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "K:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/concurrent/atomic/AtomicInteger;",
        "Lrx/Producer;",
        "Lrx/Subscription;",
        "Lrx/Observable$OnSubscribe<",
        "TT;>;"
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = -0x35762a4bbab31538L


# instance fields
.field final actual:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference<",
            "Lrx/Subscriber<",
            "-TT;>;>;"
        }
    .end annotation
.end field

.field final cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final delayError:Z

.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field final key:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TK;"
        }
    .end annotation
.end field

.field final once:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber<",
            "*TK;TT;>;"
        }
    .end annotation
.end field

.field final queue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;


# direct methods
.method public constructor <init>(ILrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;Ljava/lang/Object;Z)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber<",
            "*TK;TT;>;TK;Z)V"
        }
    .end annotation

    .line 445
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 446
    new-instance p1, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->queue:Ljava/util/Queue;

    .line 447
    iput-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    .line 448
    iput-object p3, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->key:Ljava/lang/Object;

    .line 449
    iput-boolean p4, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->delayError:Z

    .line 450
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 451
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->actual:Ljava/util/concurrent/atomic/AtomicReference;

    .line 452
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 453
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .line 424
    check-cast p1, Lrx/Subscriber;

    invoke-virtual {p0, p1}, Lrx/internal/operators/OperatorGroupByEvicting$State;->call(Lrx/Subscriber;)V

    return-void
.end method

.method public call(Lrx/Subscriber;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 483
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 484
    invoke-virtual {p1, p0}, Lrx/Subscriber;->add(Lrx/Subscription;)V

    .line 485
    invoke-virtual {p1, p0}, Lrx/Subscriber;->setProducer(Lrx/Producer;)V

    .line 486
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->actual:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->lazySet(Ljava/lang/Object;)V

    .line 487
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->drain()V

    goto :goto_0

    .line 489
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Only one Subscriber allowed!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    :goto_0
    return-void
.end method

.method checkTerminated(ZZLrx/Subscriber;Z)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZ",
            "Lrx/Subscriber<",
            "-TT;>;Z)Z"
        }
    .end annotation

    .line 571
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 572
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->queue:Ljava/util/Queue;

    invoke-interface {p1}, Ljava/util/Queue;->clear()V

    .line 573
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    iget-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->key:Ljava/lang/Object;

    invoke-virtual {p1, p2}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancel(Ljava/lang/Object;)V

    return v1

    :cond_0
    if-eqz p1, :cond_4

    if-eqz p4, :cond_2

    if-eqz p2, :cond_4

    .line 580
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->error:Ljava/lang/Throwable;

    if-eqz p1, :cond_1

    .line 582
    invoke-virtual {p3, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 584
    :cond_1
    invoke-virtual {p3}, Lrx/Subscriber;->onCompleted()V

    :goto_0
    return v1

    .line 589
    :cond_2
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->error:Ljava/lang/Throwable;

    if-eqz p1, :cond_3

    .line 591
    iget-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->queue:Ljava/util/Queue;

    invoke-interface {p2}, Ljava/util/Queue;->clear()V

    .line 592
    invoke-virtual {p3, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return v1

    :cond_3
    if-eqz p2, :cond_4

    .line 596
    invoke-virtual {p3}, Lrx/Subscriber;->onCompleted()V

    return v1

    :cond_4
    const/4 p1, 0x0

    return p1
.end method

.method drain()V
    .locals 16

    move-object/from16 v0, p0

    .line 515
    invoke-virtual/range {p0 .. p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->getAndIncrement()I

    move-result v1

    if-eqz v1, :cond_0

    return-void

    .line 520
    :cond_0
    iget-object v1, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->queue:Ljava/util/Queue;

    .line 521
    iget-boolean v2, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->delayError:Z

    .line 522
    iget-object v3, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->actual:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lrx/Subscriber;

    const/4 v5, 0x1

    :cond_1
    :goto_0
    if-eqz v3, :cond_9

    .line 525
    iget-boolean v6, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->done:Z

    invoke-interface {v1}, Ljava/util/Queue;->isEmpty()Z

    move-result v7

    invoke-virtual {v0, v6, v7, v3, v2}, Lrx/internal/operators/OperatorGroupByEvicting$State;->checkTerminated(ZZLrx/Subscriber;Z)Z

    move-result v6

    if-eqz v6, :cond_2

    return-void

    .line 529
    :cond_2
    iget-object v6, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v6}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v6

    const-wide v8, 0x7fffffffffffffffL

    cmp-long v8, v6, v8

    const/4 v9, 0x0

    if-nez v8, :cond_3

    const/4 v8, 0x1

    goto :goto_1

    :cond_3
    move v8, v9

    :goto_1
    const-wide/16 v10, 0x0

    move-wide v12, v10

    :goto_2
    cmp-long v14, v6, v10

    if-eqz v14, :cond_7

    .line 534
    iget-boolean v14, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->done:Z

    .line 535
    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v15

    if-nez v15, :cond_4

    const/4 v4, 0x1

    goto :goto_3

    :cond_4
    move v4, v9

    .line 538
    :goto_3
    invoke-virtual {v0, v14, v4, v3, v2}, Lrx/internal/operators/OperatorGroupByEvicting$State;->checkTerminated(ZZLrx/Subscriber;Z)Z

    move-result v14

    if-eqz v14, :cond_5

    return-void

    :cond_5
    if-eqz v4, :cond_6

    goto :goto_4

    .line 546
    :cond_6
    invoke-static {v15}, Lrx/internal/operators/NotificationLite;->getValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v14, 0x1

    sub-long/2addr v6, v14

    sub-long/2addr v12, v14

    goto :goto_2

    :cond_7
    :goto_4
    cmp-long v4, v12, v10

    if-eqz v4, :cond_9

    if-nez v8, :cond_8

    .line 554
    iget-object v4, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v4, v12, v13}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 556
    :cond_8
    iget-object v4, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    iget-object v4, v4, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->s:Lrx/internal/producers/ProducerArbiter;

    neg-long v6, v12

    invoke-virtual {v4, v6, v7}, Lrx/internal/producers/ProducerArbiter;->request(J)V

    :cond_9
    neg-int v4, v5

    .line 560
    invoke-virtual {v0, v4}, Lrx/internal/operators/OperatorGroupByEvicting$State;->addAndGet(I)I

    move-result v5

    if-nez v5, :cond_a

    return-void

    :cond_a
    if-nez v3, :cond_1

    .line 565
    iget-object v3, v0, Lrx/internal/operators/OperatorGroupByEvicting$State;->actual:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lrx/Subscriber;

    goto :goto_0
.end method

.method public isUnsubscribed()Z
    .locals 1

    .line 469
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .locals 1

    const/4 v0, 0x1

    .line 510
    iput-boolean v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->done:Z

    .line 511
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 0

    .line 504
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 505
    iput-boolean p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->done:Z

    .line 506
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    if-nez p1, :cond_0

    .line 495
    new-instance p1, Ljava/lang/NullPointerException;

    invoke-direct {p1}, Ljava/lang/NullPointerException;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 496
    iput-boolean p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->done:Z

    goto :goto_0

    .line 498
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->queue:Ljava/util/Queue;

    invoke-static {p1}, Lrx/internal/operators/NotificationLite;->next(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 500
    :goto_0
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->drain()V

    return-void
.end method

.method public request(J)V
    .locals 3

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    if-eqz v0, :cond_0

    .line 462
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lrx/internal/operators/BackpressureUtils;->getAndAddRequest(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 463
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->drain()V

    :cond_0
    return-void

    .line 459
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "n >= required but it was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public unsubscribe()V
    .locals 3

    .line 474
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 475
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_0

    .line 476
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    iget-object v1, p0, Lrx/internal/operators/OperatorGroupByEvicting$State;->key:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancel(Ljava/lang/Object;)V

    :cond_0
    return-void
.end method
