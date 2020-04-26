.class final Lrx/internal/operators/CompletableFromEmitter$FromEmitter;
.super Ljava/util/concurrent/atomic/AtomicBoolean;
.source "CompletableFromEmitter.java"

# interfaces
.implements Lrx/CompletableEmitter;
.implements Lrx/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/CompletableFromEmitter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "FromEmitter"
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x4cdf8d3365236ed1L


# instance fields
.field final actual:Lrx/CompletableSubscriber;

.field final resource:Lrx/internal/subscriptions/SequentialSubscription;


# direct methods
.method public constructor <init>(Lrx/CompletableSubscriber;)V
    .locals 0

    .line 62
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    .line 63
    iput-object p1, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->actual:Lrx/CompletableSubscriber;

    .line 64
    new-instance p1, Lrx/internal/subscriptions/SequentialSubscription;

    invoke-direct {p1}, Lrx/internal/subscriptions/SequentialSubscription;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    return-void
.end method


# virtual methods
.method public isUnsubscribed()Z
    .locals 1

    .line 110
    invoke-virtual {p0}, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->get()Z

    move-result v0

    return v0
.end method

.method public onCompleted()V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 69
    invoke-virtual {p0, v0, v1}, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 71
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0}, Lrx/CompletableSubscriber;->onCompleted()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 73
    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {v0}, Lrx/internal/subscriptions/SequentialSubscription;->unsubscribe()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {v1}, Lrx/internal/subscriptions/SequentialSubscription;->unsubscribe()V

    throw v0

    :cond_0
    :goto_0
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 80
    invoke-virtual {p0, v0, v1}, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0, p1}, Lrx/CompletableSubscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 84
    iget-object p1, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {p1}, Lrx/internal/subscriptions/SequentialSubscription;->unsubscribe()V

    goto :goto_0

    :catchall_0
    move-exception p1

    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {v0}, Lrx/internal/subscriptions/SequentialSubscription;->unsubscribe()V

    throw p1

    .line 87
    :cond_0
    invoke-static {p1}, Lrx/plugins/RxJavaHooks;->onError(Ljava/lang/Throwable;)V

    :goto_0
    return-void
.end method

.method public setCancellation(Lrx/functions/Cancellable;)V
    .locals 1

    .line 98
    new-instance v0, Lrx/internal/subscriptions/CancellableSubscription;

    invoke-direct {v0, p1}, Lrx/internal/subscriptions/CancellableSubscription;-><init>(Lrx/functions/Cancellable;)V

    invoke-virtual {p0, v0}, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->setSubscription(Lrx/Subscription;)V

    return-void
.end method

.method public setSubscription(Lrx/Subscription;)V
    .locals 1

    .line 93
    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {v0, p1}, Lrx/internal/subscriptions/SequentialSubscription;->update(Lrx/Subscription;)Z

    return-void
.end method

.method public unsubscribe()V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 103
    invoke-virtual {p0, v0, v1}, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 104
    iget-object v0, p0, Lrx/internal/operators/CompletableFromEmitter$FromEmitter;->resource:Lrx/internal/subscriptions/SequentialSubscription;

    invoke-virtual {v0}, Lrx/internal/subscriptions/SequentialSubscription;->unsubscribe()V

    :cond_0
    return-void
.end method
