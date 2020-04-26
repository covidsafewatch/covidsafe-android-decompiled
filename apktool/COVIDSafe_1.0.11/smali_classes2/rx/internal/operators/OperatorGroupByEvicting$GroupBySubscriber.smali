.class public final Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;
.super Lrx/Subscriber;
.source "OperatorGroupByEvicting.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorGroupByEvicting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GroupBySubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# static fields
.field static final NULL_KEY:Ljava/lang/Object;


# instance fields
.field final actual:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-",
            "Lrx/observables/GroupedObservable<",
            "TK;TV;>;>;"
        }
    .end annotation
.end field

.field final bufferSize:I

.field final cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final delayError:Z

.field volatile done:Z

.field error:Ljava/lang/Throwable;

.field final evictedGroups:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue<",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TV;>;>;"
        }
    .end annotation
.end field

.field final groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

.field final groups:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "TK;",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TV;>;>;"
        }
    .end annotation
.end field

.field final keySelector:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "-TT;+TK;>;"
        }
    .end annotation
.end field

.field final producer:Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;

.field final queue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue<",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TV;>;>;"
        }
    .end annotation
.end field

.field final requested:Ljava/util/concurrent/atomic/AtomicLong;

.field final s:Lrx/internal/producers/ProducerArbiter;

.field final valueSelector:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "-TT;+TV;>;"
        }
    .end annotation
.end field

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 134
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->NULL_KEY:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lrx/Subscriber;Lrx/functions/Func1;Lrx/functions/Func1;IZLjava/util/Map;Ljava/util/Queue;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-",
            "Lrx/observables/GroupedObservable<",
            "TK;TV;>;>;",
            "Lrx/functions/Func1<",
            "-TT;+TK;>;",
            "Lrx/functions/Func1<",
            "-TT;+TV;>;IZ",
            "Ljava/util/Map<",
            "TK;",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TV;>;>;",
            "Ljava/util/Queue<",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TV;>;>;)V"
        }
    .end annotation

    .line 151
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 152
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->actual:Lrx/Subscriber;

    .line 153
    iput-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->keySelector:Lrx/functions/Func1;

    .line 154
    iput-object p3, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->valueSelector:Lrx/functions/Func1;

    .line 155
    iput p4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->bufferSize:I

    .line 156
    iput-boolean p5, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->delayError:Z

    .line 157
    new-instance p1, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {p1}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->queue:Ljava/util/Queue;

    .line 158
    new-instance p1, Lrx/internal/producers/ProducerArbiter;

    invoke-direct {p1}, Lrx/internal/producers/ProducerArbiter;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->s:Lrx/internal/producers/ProducerArbiter;

    int-to-long p2, p4

    .line 159
    invoke-virtual {p1, p2, p3}, Lrx/internal/producers/ProducerArbiter;->request(J)V

    .line 160
    new-instance p1, Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;

    invoke-direct {p1, p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;-><init>(Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;)V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->producer:Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;

    .line 161
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 162
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    .line 163
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 p2, 0x1

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 164
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 165
    iput-object p6, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    .line 166
    iput-object p7, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->evictedGroups:Ljava/util/Queue;

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 3

    .line 280
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 281
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v0

    if-nez v0, :cond_0

    .line 282
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->unsubscribe()V

    :cond_0
    return-void
.end method

.method public cancel(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)V"
        }
    .end annotation

    if-eqz p1, :cond_0

    goto :goto_0

    .line 288
    :cond_0
    sget-object p1, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->NULL_KEY:Ljava/lang/Object;

    .line 289
    :goto_0
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_1

    .line 290
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result p1

    if-nez p1, :cond_1

    .line 291
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->unsubscribe()V

    :cond_1
    return-void
.end method

.method checkTerminated(ZZLrx/Subscriber;Ljava/util/Queue;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZ",
            "Lrx/Subscriber<",
            "-",
            "Lrx/observables/GroupedObservable<",
            "TK;TV;>;>;",
            "Ljava/util/Queue<",
            "*>;)Z"
        }
    .end annotation

    if-eqz p1, :cond_1

    .line 369
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->error:Ljava/lang/Throwable;

    const/4 v0, 0x1

    if-eqz p1, :cond_0

    .line 371
    invoke-virtual {p0, p3, p4, p1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->errorAll(Lrx/Subscriber;Ljava/util/Queue;Ljava/lang/Throwable;)V

    return v0

    :cond_0
    if-eqz p2, :cond_1

    .line 375
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {p1}, Lrx/Subscriber;->onCompleted()V

    return v0

    :cond_1
    const/4 p1, 0x0

    return p1
.end method

.method drain()V
    .locals 15

    .line 297
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 303
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->queue:Ljava/util/Queue;

    .line 304
    iget-object v1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->actual:Lrx/Subscriber;

    const/4 v2, 0x1

    move v3, v2

    .line 308
    :cond_1
    iget-boolean v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    invoke-interface {v0}, Ljava/util/Queue;->isEmpty()Z

    move-result v5

    invoke-virtual {p0, v4, v5, v1, v0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->checkTerminated(ZZLrx/Subscriber;Ljava/util/Queue;)Z

    move-result v4

    if-eqz v4, :cond_2

    return-void

    .line 312
    :cond_2
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v4

    const-wide v6, 0x7fffffffffffffffL

    cmp-long v6, v4, v6

    const/4 v7, 0x0

    if-nez v6, :cond_3

    move v6, v2

    goto :goto_0

    :cond_3
    move v6, v7

    :goto_0
    const-wide/16 v8, 0x0

    move-wide v10, v8

    :goto_1
    cmp-long v12, v4, v8

    if-eqz v12, :cond_7

    .line 317
    iget-boolean v12, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    .line 319
    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lrx/observables/GroupedObservable;

    if-nez v13, :cond_4

    move v14, v2

    goto :goto_2

    :cond_4
    move v14, v7

    .line 323
    :goto_2
    invoke-virtual {p0, v12, v14, v1, v0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->checkTerminated(ZZLrx/Subscriber;Ljava/util/Queue;)Z

    move-result v12

    if-eqz v12, :cond_5

    return-void

    :cond_5
    if-eqz v14, :cond_6

    goto :goto_3

    .line 331
    :cond_6
    invoke-virtual {v1, v13}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    const-wide/16 v12, 0x1

    sub-long/2addr v4, v12

    sub-long/2addr v10, v12

    goto :goto_1

    :cond_7
    :goto_3
    cmp-long v4, v10, v8

    if-eqz v4, :cond_9

    if-nez v6, :cond_8

    .line 339
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v4, v10, v11}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 341
    :cond_8
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->s:Lrx/internal/producers/ProducerArbiter;

    neg-long v5, v10

    invoke-virtual {v4, v5, v6}, Lrx/internal/producers/ProducerArbiter;->request(J)V

    .line 344
    :cond_9
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    neg-int v3, v3

    invoke-virtual {v4, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    move-result v3

    if-nez v3, :cond_1

    return-void
.end method

.method errorAll(Lrx/Subscriber;Ljava/util/Queue;Ljava/lang/Throwable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-",
            "Lrx/observables/GroupedObservable<",
            "TK;TV;>;>;",
            "Ljava/util/Queue<",
            "*>;",
            "Ljava/lang/Throwable;",
            ")V"
        }
    .end annotation

    .line 352
    invoke-interface {p2}, Ljava/util/Queue;->clear()V

    .line 353
    new-instance p2, Ljava/util/ArrayList;

    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-direct {p2, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 354
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 355
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->evictedGroups:Ljava/util/Queue;

    if-eqz v0, :cond_0

    .line 356
    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    .line 359
    :cond_0
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p2

    :goto_0
    invoke-interface {p2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    .line 360
    invoke-virtual {v0, p3}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->onError(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 363
    :cond_1
    invoke-virtual {p1, p3}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onCompleted()V
    .locals 2

    .line 251
    iget-boolean v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 255
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    .line 256
    invoke-virtual {v1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->onComplete()V

    goto :goto_0

    .line 258
    :cond_1
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 259
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->evictedGroups:Ljava/util/Queue;

    if-eqz v0, :cond_2

    .line 260
    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    :cond_2
    const/4 v0, 0x1

    .line 263
    iput-boolean v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    .line 264
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 265
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->drain()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 239
    iget-boolean v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    if-eqz v0, :cond_0

    .line 240
    invoke-static {p1}, Lrx/plugins/RxJavaHooks;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 243
    :cond_0
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->error:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 244
    iput-boolean p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    .line 245
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 246
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->drain()V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 176
    iget-boolean v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 180
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->queue:Ljava/util/Queue;

    .line 181
    iget-object v1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->actual:Lrx/Subscriber;

    .line 185
    :try_start_0
    iget-object v2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->keySelector:Lrx/functions/Func1;

    invoke-interface {v2, p1}, Lrx/functions/Func1;->call(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v2, :cond_1

    move-object v3, v2

    goto :goto_0

    .line 194
    :cond_1
    sget-object v3, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->NULL_KEY:Ljava/lang/Object;

    .line 195
    :goto_0
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    if-nez v4, :cond_3

    .line 199
    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancelled:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v4

    if-nez v4, :cond_2

    .line 200
    iget v4, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->bufferSize:I

    iget-boolean v5, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->delayError:Z

    invoke-static {v2, v4, p0, v5}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->createWith(Ljava/lang/Object;ILrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;Z)Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    move-result-object v4

    .line 201
    iget-object v2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groups:Ljava/util/Map;

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    iget-object v2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->groupCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    .line 206
    invoke-interface {v0, v4}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    .line 207
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->drain()V

    goto :goto_1

    :cond_2
    return-void

    .line 215
    :cond_3
    :goto_1
    :try_start_1
    iget-object v2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->valueSelector:Lrx/functions/Func1;

    invoke-interface {v2, p1}, Lrx/functions/Func1;->call(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 222
    invoke-virtual {v4, p1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->onNext(Ljava/lang/Object;)V

    .line 224
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->evictedGroups:Ljava/util/Queue;

    if-eqz p1, :cond_4

    .line 226
    :goto_2
    iget-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->evictedGroups:Ljava/util/Queue;

    invoke-interface {p1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    if-eqz p1, :cond_4

    .line 227
    invoke-virtual {p1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->onComplete()V

    goto :goto_2

    :cond_4
    return-void

    :catchall_0
    move-exception p1

    .line 217
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->unsubscribe()V

    .line 218
    invoke-virtual {p0, v1, v0, p1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->errorAll(Lrx/Subscriber;Ljava/util/Queue;Ljava/lang/Throwable;)V

    return-void

    :catchall_1
    move-exception p1

    .line 187
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->unsubscribe()V

    .line 188
    invoke-virtual {p0, v1, v0, p1}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->errorAll(Lrx/Subscriber;Ljava/util/Queue;Ljava/lang/Throwable;)V

    return-void
.end method

.method public requestMore(J)V
    .locals 3

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 273
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->requested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lrx/internal/operators/BackpressureUtils;->getAndAddRequest(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 274
    invoke-virtual {p0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->drain()V

    return-void

    .line 270
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "n >= 0 required but it was "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 1

    .line 171
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->s:Lrx/internal/producers/ProducerArbiter;

    invoke-virtual {v0, p1}, Lrx/internal/producers/ProducerArbiter;->setProducer(Lrx/Producer;)V

    return-void
.end method
