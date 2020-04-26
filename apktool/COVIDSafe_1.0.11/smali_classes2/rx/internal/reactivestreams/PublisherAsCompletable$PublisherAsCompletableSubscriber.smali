.class final Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;
.super Ljava/lang/Object;
.source "PublisherAsCompletable.java"

# interfaces
.implements Lorg/reactivestreams/Subscriber;
.implements Lrx/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/reactivestreams/PublisherAsCompletable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "PublisherAsCompletableSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/reactivestreams/Subscriber<",
        "Ljava/lang/Object;",
        ">;",
        "Lrx/Subscription;"
    }
.end annotation


# instance fields
.field final actual:Lrx/CompletableSubscriber;

.field s:Lorg/reactivestreams/Subscription;

.field volatile unsubscribed:Z


# direct methods
.method public constructor <init>(Lrx/CompletableSubscriber;)V
    .locals 0

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->actual:Lrx/CompletableSubscriber;

    return-void
.end method


# virtual methods
.method public isUnsubscribed()Z
    .locals 1

    .line 75
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->unsubscribed:Z

    return v0
.end method

.method public onComplete()V
    .locals 1

    .line 70
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0}, Lrx/CompletableSubscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 65
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0, p1}, Lrx/CompletableSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 0

    return-void
.end method

.method public onSubscribe(Lorg/reactivestreams/Subscription;)V
    .locals 2

    .line 53
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->s:Lorg/reactivestreams/Subscription;

    .line 54
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0, p0}, Lrx/CompletableSubscriber;->onSubscribe(Lrx/Subscription;)V

    const-wide v0, 0x7fffffffffffffffL

    .line 55
    invoke-interface {p1, v0, v1}, Lorg/reactivestreams/Subscription;->request(J)V

    return-void
.end method

.method public unsubscribe()V
    .locals 1

    .line 80
    iget-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->unsubscribed:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    .line 81
    iput-boolean v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->unsubscribed:Z

    .line 82
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;->s:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    :cond_0
    return-void
.end method
