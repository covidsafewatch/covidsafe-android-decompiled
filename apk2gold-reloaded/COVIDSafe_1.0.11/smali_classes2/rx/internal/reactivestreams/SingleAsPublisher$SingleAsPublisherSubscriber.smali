.class final Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;
.super Lrx/SingleSubscriber;
.source "SingleAsPublisher.java"

# interfaces
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/reactivestreams/SingleAsPublisher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SingleAsPublisherSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/SingleSubscriber<",
        "TT;>;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# static fields
.field static final HAS_REQUEST_HAS_VALUE:I = 0x3

.field static final HAS_REQUEST_NO_VALUE:I = 0x2

.field static final NO_REQUEST_HAS_VALUE:I = 0x1

.field static final NO_REQUEST_NO_VALUE:I


# instance fields
.field final actual:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field volatile cancelled:Z

.field final state:Ljava/util/concurrent/atomic/AtomicInteger;

.field value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Subscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 64
    invoke-direct {p0}, Lrx/SingleSubscriber;-><init>()V

    .line 65
    iput-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    .line 66
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 3

    .line 138
    iget-boolean v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-nez v0, :cond_1

    const/4 v0, 0x1

    .line 139
    iput-boolean v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    .line 140
    iget-object v1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndSet(I)I

    move-result v1

    if-ne v1, v0, :cond_0

    const/4 v0, 0x0

    .line 141
    iput-object v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->value:Ljava/lang/Object;

    .line 143
    :cond_0
    invoke-virtual {p0}, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->unsubscribe()V

    :cond_1
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 2

    .line 102
    iget-boolean v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-eqz v0, :cond_0

    return-void

    .line 105
    :cond_0
    iget-object v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->lazySet(I)V

    .line 106
    iget-object v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 71
    iget-boolean v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x3

    if-nez p1, :cond_1

    .line 75
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->lazySet(I)V

    .line 76
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "value"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-interface {p1, v0}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 80
    :cond_1
    iget-object v1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_5

    if-eq v1, v0, :cond_5

    .line 82
    iget-boolean v3, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-eqz v3, :cond_2

    goto :goto_0

    :cond_2
    const/4 v3, 0x2

    if-ne v1, v3, :cond_4

    .line 86
    iget-object v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 87
    iget-boolean p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-nez p1, :cond_3

    .line 88
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_3
    return-void

    .line 92
    :cond_4
    iput-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->value:Ljava/lang/Object;

    .line 93
    iget-object v3, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v3, v1, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_5
    :goto_0
    return-void
.end method

.method public request(J)V
    .locals 2

    const-wide/16 v0, 0x0

    cmp-long p1, p1, v0

    if-lez p1, :cond_3

    .line 113
    :cond_0
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result p1

    const/4 p2, 0x3

    if-eq p1, p2, :cond_3

    const/4 v0, 0x2

    if-eq p1, v0, :cond_3

    .line 114
    iget-boolean v1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-eqz v1, :cond_1

    goto :goto_0

    :cond_1
    const/4 v1, 0x1

    if-ne p1, v1, :cond_2

    .line 118
    iget-object v0, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, p1, p2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result p1

    if-eqz p1, :cond_3

    .line 119
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->value:Ljava/lang/Object;

    const/4 p2, 0x0

    .line 120
    iput-object p2, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->value:Ljava/lang/Object;

    .line 122
    iget-object p2, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {p2, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 123
    iget-boolean p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->cancelled:Z

    if-nez p1, :cond_3

    .line 124
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1}, Lorg/reactivestreams/Subscriber;->onComplete()V

    goto :goto_0

    .line 129
    :cond_2
    iget-object p1, p0, Lrx/internal/reactivestreams/SingleAsPublisher$SingleAsPublisherSubscriber;->state:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 p2, 0x0

    invoke-virtual {p1, p2, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result p1

    if-eqz p1, :cond_0

    :cond_3
    :goto_0
    return-void
.end method
