.class public final Lrx/internal/reactivestreams/CompletableAsPublisher;
.super Ljava/lang/Object;
.source "CompletableAsPublisher.java"

# interfaces
.implements Lorg/reactivestreams/Publisher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/reactivestreams/Publisher<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final completable:Lrx/Completable;


# direct methods
.method public constructor <init>(Lrx/Completable;)V
    .locals 0

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lrx/internal/reactivestreams/CompletableAsPublisher;->completable:Lrx/Completable;

    return-void
.end method


# virtual methods
.method public subscribe(Lorg/reactivestreams/Subscriber;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    if-eqz p1, :cond_0

    .line 43
    iget-object v0, p0, Lrx/internal/reactivestreams/CompletableAsPublisher;->completable:Lrx/Completable;

    new-instance v1, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;

    invoke-direct {v1, p1}, Lrx/internal/reactivestreams/CompletableAsPublisher$CompletableAsPublisherSubscriber;-><init>(Lorg/reactivestreams/Subscriber;)V

    invoke-virtual {v0, v1}, Lrx/Completable;->subscribe(Lrx/CompletableSubscriber;)V

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 41
    throw p1
.end method
