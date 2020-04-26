.class final Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;
.super Lrx/SingleSubscriber;
.source "SingleTimeout.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/SingleTimeout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "TimeoutSingleSubscriber"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber$OtherSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/SingleSubscriber<",
        "TT;>;",
        "Lrx/functions/Action0;"
    }
.end annotation


# instance fields
.field final actual:Lrx/SingleSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/SingleSubscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field final once:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final other:Lrx/Single$OnSubscribe;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Single$OnSubscribe<",
            "+TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lrx/SingleSubscriber;Lrx/Single$OnSubscribe;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/SingleSubscriber<",
            "-TT;>;",
            "Lrx/Single$OnSubscribe<",
            "+TT;>;)V"
        }
    .end annotation

    .line 69
    invoke-direct {p0}, Lrx/SingleSubscriber;-><init>()V

    .line 70
    iput-object p1, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    .line 71
    iput-object p2, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->other:Lrx/Single$OnSubscribe;

    .line 72
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method


# virtual methods
.method public call()V
    .locals 3

    .line 101
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 103
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->other:Lrx/Single$OnSubscribe;

    if-nez v0, :cond_0

    .line 106
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    new-instance v1, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v1}, Ljava/util/concurrent/TimeoutException;-><init>()V

    invoke-virtual {v0, v1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 108
    :cond_0
    new-instance v1, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber$OtherSubscriber;

    iget-object v2, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-direct {v1, v2}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber$OtherSubscriber;-><init>(Lrx/SingleSubscriber;)V

    .line 109
    iget-object v2, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v2, v1}, Lrx/SingleSubscriber;->add(Lrx/Subscription;)V

    .line 110
    invoke-interface {v0, v1}, Lrx/Single$OnSubscribe;->call(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    :goto_0
    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    goto :goto_1

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    throw v0

    :cond_1
    :goto_1
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 3

    .line 88
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 90
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 92
    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    goto :goto_0

    :catchall_0
    move-exception p1

    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    throw p1

    .line 95
    :cond_0
    invoke-static {p1}, Lrx/plugins/RxJavaHooks;->onError(Ljava/lang/Throwable;)V

    :goto_0
    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 77
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->once:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 79
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onSuccess(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    goto :goto_0

    :catchall_0
    move-exception p1

    invoke-virtual {p0}, Lrx/internal/operators/SingleTimeout$TimeoutSingleSubscriber;->unsubscribe()V

    throw p1

    :cond_0
    :goto_0
    return-void
.end method
