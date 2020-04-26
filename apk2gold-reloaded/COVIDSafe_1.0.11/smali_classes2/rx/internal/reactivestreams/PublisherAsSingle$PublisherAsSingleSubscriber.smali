.class final Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;
.super Ljava/lang/Object;
.source "PublisherAsSingle.java"

# interfaces
.implements Lorg/reactivestreams/Subscriber;
.implements Lrx/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/reactivestreams/PublisherAsSingle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "PublisherAsSingleSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/reactivestreams/Subscriber<",
        "TT;>;",
        "Lrx/Subscription;"
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

.field done:Z

.field hasValue:Z

.field s:Lorg/reactivestreams/Subscription;

.field value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/SingleSubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/SingleSubscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    return-void
.end method


# virtual methods
.method public isUnsubscribed()Z
    .locals 1

    .line 111
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v0}, Lrx/SingleSubscriber;->isUnsubscribed()Z

    move-result v0

    return v0
.end method

.method public onComplete()V
    .locals 3

    .line 97
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 100
    :cond_0
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->hasValue:Z

    if-eqz v0, :cond_1

    .line 101
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->value:Ljava/lang/Object;

    const/4 v1, 0x0

    .line 102
    iput-object v1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->value:Ljava/lang/Object;

    .line 103
    iget-object v1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v1, v0}, Lrx/SingleSubscriber;->onSuccess(Ljava/lang/Object;)V

    goto :goto_0

    .line 105
    :cond_1
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    new-instance v1, Ljava/util/NoSuchElementException;

    const-string v2, "The source Publisher was empty"

    invoke-direct {v1, v2}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V

    :goto_0
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 89
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 92
    :cond_0
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 74
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 77
    :cond_0
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->hasValue:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    .line 78
    iput-boolean v1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->done:Z

    .line 79
    iget-object p1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->s:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    .line 80
    iget-object p1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    const-string v1, "The source Publisher emitted multiple values"

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 82
    :cond_1
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->value:Ljava/lang/Object;

    .line 83
    iput-boolean v1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->hasValue:Z

    :goto_0
    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .locals 2

    .line 65
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->s:Lorg/reactivestreams/Subscription;

    .line 67
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->actual:Lrx/SingleSubscriber;

    invoke-virtual {v0, p0}, Lrx/SingleSubscriber;->add(Lrx/Subscription;)V

    const-wide v0, 0x7fffffffffffffffL

    .line 69
    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void
.end method

.method public unsubscribe()V
    .locals 1

    .line 116
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsSingle$PublisherAsSingleSubscriber;->s:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    return-void
.end method
