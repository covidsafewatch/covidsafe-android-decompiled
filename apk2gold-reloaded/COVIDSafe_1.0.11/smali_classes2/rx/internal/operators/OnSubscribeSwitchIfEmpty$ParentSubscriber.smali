.class final Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;
.super Lrx/Subscriber;
.source "OnSubscribeSwitchIfEmpty.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OnSubscribeSwitchIfEmpty;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "ParentSubscriber"
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
.field volatile active:Z

.field private final alternate:Lrx/Observable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Observable<",
            "+TT;>;"
        }
    .end annotation
.end field

.field private final arbiter:Lrx/internal/producers/ProducerArbiter;

.field private final child:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field private empty:Z

.field private final serial:Lrx/subscriptions/SerialSubscription;

.field final wip:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method constructor <init>(Lrx/Subscriber;Lrx/subscriptions/SerialSubscription;Lrx/internal/producers/ProducerArbiter;Lrx/Observable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;",
            "Lrx/subscriptions/SerialSubscription;",
            "Lrx/internal/producers/ProducerArbiter;",
            "Lrx/Observable<",
            "+TT;>;)V"
        }
    .end annotation

    .line 66
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    const/4 v0, 0x1

    .line 57
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->empty:Z

    .line 67
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    .line 68
    iput-object p2, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->serial:Lrx/subscriptions/SerialSubscription;

    .line 69
    iput-object p3, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    .line 70
    iput-object p4, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->alternate:Lrx/Observable;

    .line 71
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 81
    iget-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->empty:Z

    if-nez v0, :cond_0

    .line 82
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V

    goto :goto_0

    .line 83
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->isUnsubscribed()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x0

    .line 84
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->active:Z

    const/4 v0, 0x0

    .line 85
    invoke-virtual {p0, v0}, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->subscribe(Lrx/Observable;)V

    :cond_1
    :goto_0
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 115
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 120
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->empty:Z

    .line 121
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 122
    iget-object p1, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    const-wide/16 v0, 0x1

    invoke-virtual {p1, v0, v1}, Lrx/internal/producers/ProducerArbiter;->produced(J)V

    return-void
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 1

    .line 76
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    invoke-virtual {v0, p1}, Lrx/internal/producers/ProducerArbiter;->setProducer(Lrx/Producer;)V

    return-void
.end method

.method subscribe(Lrx/Observable;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Observable<",
            "+TT;>;)V"
        }
    .end annotation

    .line 90
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v0

    if-nez v0, :cond_4

    .line 92
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->isUnsubscribed()Z

    move-result v0

    if-eqz v0, :cond_1

    goto :goto_1

    .line 96
    :cond_1
    iget-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->active:Z

    if-nez v0, :cond_3

    const/4 v0, 0x1

    if-nez p1, :cond_2

    .line 98
    new-instance v1, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$AlternateSubscriber;

    iget-object v2, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->child:Lrx/Subscriber;

    iget-object v3, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->arbiter:Lrx/internal/producers/ProducerArbiter;

    invoke-direct {v1, v2, v3}, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$AlternateSubscriber;-><init>(Lrx/Subscriber;Lrx/internal/producers/ProducerArbiter;)V

    .line 99
    iget-object v2, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->serial:Lrx/subscriptions/SerialSubscription;

    invoke-virtual {v2, v1}, Lrx/subscriptions/SerialSubscription;->set(Lrx/Subscription;)V

    .line 100
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->active:Z

    .line 101
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->alternate:Lrx/Observable;

    invoke-virtual {v0, v1}, Lrx/Observable;->unsafeSubscribe(Lrx/Subscriber;)Lrx/Subscription;

    goto :goto_0

    .line 103
    :cond_2
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->active:Z

    .line 104
    invoke-virtual {p1, p0}, Lrx/Observable;->unsafeSubscribe(Lrx/Subscriber;)Lrx/Subscription;

    const/4 p1, 0x0

    .line 109
    :cond_3
    :goto_0
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->wip:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    move-result v0

    if-nez v0, :cond_0

    :cond_4
    :goto_1
    return-void
.end method
