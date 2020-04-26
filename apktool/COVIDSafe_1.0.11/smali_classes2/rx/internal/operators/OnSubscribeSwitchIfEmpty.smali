.class public final Lrx/internal/operators/OnSubscribeSwitchIfEmpty;
.super Ljava/lang/Object;
.source "OnSubscribeSwitchIfEmpty.java"

# interfaces
.implements Lrx/Observable$OnSubscribe;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/operators/OnSubscribeSwitchIfEmpty$AlternateSubscriber;,
        Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lrx/Observable$OnSubscribe<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final alternate:Lrx/Observable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Observable<",
            "+TT;>;"
        }
    .end annotation
.end field

.field final source:Lrx/Observable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Observable<",
            "+TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/Observable;Lrx/Observable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Observable<",
            "+TT;>;",
            "Lrx/Observable<",
            "+TT;>;)V"
        }
    .end annotation

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty;->source:Lrx/Observable;

    .line 39
    iput-object p2, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty;->alternate:Lrx/Observable;

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .line 31
    check-cast p1, Lrx/Subscriber;

    invoke-virtual {p0, p1}, Lrx/internal/operators/OnSubscribeSwitchIfEmpty;->call(Lrx/Subscriber;)V

    return-void
.end method

.method public call(Lrx/Subscriber;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 44
    new-instance v0, Lrx/subscriptions/SerialSubscription;

    invoke-direct {v0}, Lrx/subscriptions/SerialSubscription;-><init>()V

    .line 45
    new-instance v1, Lrx/internal/producers/ProducerArbiter;

    invoke-direct {v1}, Lrx/internal/producers/ProducerArbiter;-><init>()V

    .line 46
    new-instance v2, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;

    iget-object v3, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty;->alternate:Lrx/Observable;

    invoke-direct {v2, p1, v0, v1, v3}, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;-><init>(Lrx/Subscriber;Lrx/subscriptions/SerialSubscription;Lrx/internal/producers/ProducerArbiter;Lrx/Observable;)V

    .line 48
    invoke-virtual {v0, v2}, Lrx/subscriptions/SerialSubscription;->set(Lrx/Subscription;)V

    .line 49
    invoke-virtual {p1, v0}, Lrx/Subscriber;->add(Lrx/Subscription;)V

    .line 50
    invoke-virtual {p1, v1}, Lrx/Subscriber;->setProducer(Lrx/Producer;)V

    .line 52
    iget-object p1, p0, Lrx/internal/operators/OnSubscribeSwitchIfEmpty;->source:Lrx/Observable;

    invoke-virtual {v2, p1}, Lrx/internal/operators/OnSubscribeSwitchIfEmpty$ParentSubscriber;->subscribe(Lrx/Observable;)V

    return-void
.end method
