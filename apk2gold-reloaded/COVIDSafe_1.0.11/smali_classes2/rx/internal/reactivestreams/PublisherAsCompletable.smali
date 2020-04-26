.class public final Lrx/internal/reactivestreams/PublisherAsCompletable;
.super Ljava/lang/Object;
.source "PublisherAsCompletable.java"

# interfaces
.implements Lrx/Completable$OnSubscribe;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;
    }
.end annotation


# instance fields
.field final publisher:Lorg/reactivestreams/Publisher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/reactivestreams/Publisher<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Publisher;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Publisher<",
            "*>;)V"
        }
    .end annotation

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAsCompletable;->publisher:Lorg/reactivestreams/Publisher;

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .line 26
    check-cast p1, Lrx/CompletableSubscriber;

    invoke-virtual {p0, p1}, Lrx/internal/reactivestreams/PublisherAsCompletable;->call(Lrx/CompletableSubscriber;)V

    return-void
.end method

.method public call(Lrx/CompletableSubscriber;)V
    .locals 2

    .line 36
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAsCompletable;->publisher:Lorg/reactivestreams/Publisher;

    new-instance v1, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;

    invoke-direct {v1, p1}, Lrx/internal/reactivestreams/PublisherAsCompletable$PublisherAsCompletableSubscriber;-><init>(Lrx/CompletableSubscriber;)V

    invoke-interface {v0, v1}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    return-void
.end method
