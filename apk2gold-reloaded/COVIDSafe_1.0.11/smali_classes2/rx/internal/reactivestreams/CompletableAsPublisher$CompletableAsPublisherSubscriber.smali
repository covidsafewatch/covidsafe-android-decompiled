.class final Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;
.super Ljava/lang/Object;
.source "CompletableAsPublisher.java"

# interfaces
.implements Lrx/CompletableSubscriber;
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/reactivestreams/CompletableAsPublisher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "CompletableAsPublisherSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lrx/CompletableSubscriber;",
        "Lorg/reactivestreams/Subscription;"
    }
.end annotation


# instance fields
.field final actual:Lorg/reactivestreams/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field d:Lrx/Subscription;


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

    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .line 80
    iget-object v0, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->d:Lrx/Subscription;

    invoke-interface {v0}, Lrx/Subscription;->unsubscribe()V

    return-void
.end method

.method public onCompleted()V
    .locals 1

    .line 70
    iget-object v0, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 65
    iget-object v0, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lrx/Subscription;)V
    .locals 0

    .line 59
    iput-object p1, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->d:Lrx/Subscription;

    .line 60
    iget-object p1, p0, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;->actual:Lorg/reactivestreams/Subscriber;

    invoke-interface {p1, p0}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    return-void
.end method

.method public request(J)V
    .locals 0

    return-void
.end method
