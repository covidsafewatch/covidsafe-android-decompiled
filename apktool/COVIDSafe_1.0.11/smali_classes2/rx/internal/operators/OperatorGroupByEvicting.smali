.class public final Lrx/internal/operators/OperatorGroupByEvicting;
.super Ljava/lang/Object;
.source "OperatorGroupByEvicting.java"

# interfaces
.implements Lrx/Observable$Operator;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/operators/OperatorGroupByEvicting$State;,
        Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;,
        Lrx/internal/operators/OperatorGroupByEvicting$EvictionAction;,
        Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;,
        Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;
    }
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
        "Ljava/lang/Object;",
        "Lrx/Observable$Operator<",
        "Lrx/observables/GroupedObservable<",
        "TK;TV;>;TT;>;"
    }
.end annotation


# instance fields
.field final bufferSize:I

.field final delayError:Z

.field final keySelector:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "-TT;+TK;>;"
        }
    .end annotation
.end field

.field final mapFactory:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "Lrx/functions/Action1<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map<",
            "TK;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field final valueSelector:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "-TT;+TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/functions/Func1;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Func1<",
            "-TT;+TK;>;)V"
        }
    .end annotation

    .line 56
    invoke-static {}, Lrx/internal/util/UtilityFunctions;->identity()Lrx/functions/Func1;

    move-result-object v2

    sget v3, Lrx/internal/util/RxRingBuffer;->SIZE:I

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lrx/internal/operators/OperatorGroupByEvicting;-><init>(Lrx/functions/Func1;Lrx/functions/Func1;IZLrx/functions/Func1;)V

    return-void
.end method

.method public constructor <init>(Lrx/functions/Func1;Lrx/functions/Func1;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Func1<",
            "-TT;+TK;>;",
            "Lrx/functions/Func1<",
            "-TT;+TV;>;)V"
        }
    .end annotation

    .line 60
    sget v3, Lrx/internal/util/RxRingBuffer;->SIZE:I

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lrx/internal/operators/OperatorGroupByEvicting;-><init>(Lrx/functions/Func1;Lrx/functions/Func1;IZLrx/functions/Func1;)V

    return-void
.end method

.method public constructor <init>(Lrx/functions/Func1;Lrx/functions/Func1;IZLrx/functions/Func1;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Func1<",
            "-TT;+TK;>;",
            "Lrx/functions/Func1<",
            "-TT;+TV;>;IZ",
            "Lrx/functions/Func1<",
            "Lrx/functions/Action1<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/Map<",
            "TK;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting;->keySelector:Lrx/functions/Func1;

    .line 65
    iput-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting;->valueSelector:Lrx/functions/Func1;

    .line 66
    iput p3, p0, Lrx/internal/operators/OperatorGroupByEvicting;->bufferSize:I

    .line 67
    iput-boolean p4, p0, Lrx/internal/operators/OperatorGroupByEvicting;->delayError:Z

    .line 68
    iput-object p5, p0, Lrx/internal/operators/OperatorGroupByEvicting;->mapFactory:Lrx/functions/Func1;

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 46
    check-cast p1, Lrx/Subscriber;

    invoke-virtual {p0, p1}, Lrx/internal/operators/OperatorGroupByEvicting;->call(Lrx/Subscriber;)Lrx/Subscriber;

    move-result-object p1

    return-object p1
.end method

.method public call(Lrx/Subscriber;)Lrx/Subscriber;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-",
            "Lrx/observables/GroupedObservable<",
            "TK;TV;>;>;)",
            "Lrx/Subscriber<",
            "-TT;>;"
        }
    .end annotation

    .line 77
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting;->mapFactory:Lrx/functions/Func1;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    .line 79
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    :goto_0
    move-object v9, v0

    move-object v8, v1

    goto :goto_1

    .line 81
    :cond_0
    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    .line 82
    new-instance v1, Lrx/internal/operators/OperatorGroupByEvicting$EvictionAction;

    invoke-direct {v1, v0}, Lrx/internal/operators/OperatorGroupByEvicting$EvictionAction;-><init>(Ljava/util/Queue;)V

    .line 85
    :try_start_0
    iget-object v2, p0, Lrx/internal/operators/OperatorGroupByEvicting;->mapFactory:Lrx/functions/Func1;

    .line 86
    invoke-interface {v2, v1}, Lrx/functions/Func1;->call(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 95
    :goto_1
    new-instance v0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    iget-object v4, p0, Lrx/internal/operators/OperatorGroupByEvicting;->keySelector:Lrx/functions/Func1;

    iget-object v5, p0, Lrx/internal/operators/OperatorGroupByEvicting;->valueSelector:Lrx/functions/Func1;

    iget v6, p0, Lrx/internal/operators/OperatorGroupByEvicting;->bufferSize:I

    iget-boolean v7, p0, Lrx/internal/operators/OperatorGroupByEvicting;->delayError:Z

    move-object v2, v0

    move-object v3, p1

    invoke-direct/range {v2 .. v9}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;-><init>(Lrx/Subscriber;Lrx/functions/Func1;Lrx/functions/Func1;IZLjava/util/Map;Ljava/util/Queue;)V

    .line 98
    new-instance v1, Lrx/internal/operators/OperatorGroupByEvicting$1;

    invoke-direct {v1, p0, v0}, Lrx/internal/operators/OperatorGroupByEvicting$1;-><init>(Lrx/internal/operators/OperatorGroupByEvicting;Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;)V

    invoke-static {v1}, Lrx/subscriptions/Subscriptions;->create(Lrx/functions/Action0;)Lrx/Subscription;

    move-result-object v1

    invoke-virtual {p1, v1}, Lrx/Subscriber;->add(Lrx/Subscription;)V

    .line 105
    iget-object v1, v0, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->producer:Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;

    invoke-virtual {p1, v1}, Lrx/Subscriber;->setProducer(Lrx/Producer;)V

    return-object v0

    :catchall_0
    move-exception v0

    .line 89
    invoke-static {v0, p1}, Lrx/exceptions/Exceptions;->throwOrReport(Ljava/lang/Throwable;Lrx/Observer;)V

    .line 90
    invoke-static {}, Lrx/observers/Subscribers;->empty()Lrx/Subscriber;

    move-result-object p1

    .line 91
    invoke-virtual {p1}, Lrx/Subscriber;->unsubscribe()V

    return-object p1
.end method
