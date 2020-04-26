.class public abstract Lrx/RxReactiveStreams;
.super Ljava/lang/Object;
.source "RxReactiveStreams.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toCompletable(Lorg/reactivestreams/Publisher;)Lrx/Completable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Publisher<",
            "*>;)",
            "Lrx/Completable;"
        }
    .end annotation

    if-eqz p0, :cond_0

    .line 103
    new-instance v0, Lrx/internal/reactivestreams/PublisherAsCompletable;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/PublisherAsCompletable;-><init>(Lorg/reactivestreams/Publisher;)V

    invoke-static {v0}, Lrx/Completable;->create(Lrx/Completable$OnSubscribe;)Lrx/Completable;

    move-result-object p0

    return-object p0

    .line 101
    :cond_0
    new-instance p0, Ljava/lang/NullPointerException;

    const-string v0, "publisher"

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static toObservable(Lorg/reactivestreams/Publisher;)Lrx/Observable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;)",
            "Lrx/Observable<",
            "TT;>;"
        }
    .end annotation

    .line 57
    new-instance v0, Lrx/RxReactiveStreams$1;

    invoke-direct {v0, p0}, Lrx/RxReactiveStreams$1;-><init>(Lorg/reactivestreams/Publisher;)V

    invoke-static {v0}, Lrx/Observable;->create(Lrx/Observable$OnSubscribe;)Lrx/Observable;

    move-result-object p0

    return-object p0
.end method

.method public static toPublisher(Lrx/Completable;)Lorg/reactivestreams/Publisher;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Completable;",
            ")",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation

    if-eqz p0, :cond_0

    .line 88
    new-instance v0, Lrx/internal/reactivestreams/CompletableAsPublisher;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/CompletableAsPublisher;-><init>(Lrx/Completable;)V

    return-object v0

    .line 86
    :cond_0
    new-instance p0, Ljava/lang/NullPointerException;

    const-string v0, "completable"

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static toPublisher(Lrx/Observable;)Lorg/reactivestreams/Publisher;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Observable<",
            "TT;>;)",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation

    .line 44
    new-instance v0, Lrx/internal/reactivestreams/PublisherAdapter;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/PublisherAdapter;-><init>(Lrx/Observable;)V

    return-object v0
.end method

.method public static toPublisher(Lrx/Single;)Lorg/reactivestreams/Publisher;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Single<",
            "TT;>;)",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;"
        }
    .end annotation

    if-eqz p0, :cond_0

    .line 120
    new-instance v0, Lrx/internal/reactivestreams/SingleAsPublisher;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/SingleAsPublisher;-><init>(Lrx/Single;)V

    return-object v0

    .line 118
    :cond_0
    new-instance p0, Ljava/lang/NullPointerException;

    const-string v0, "single"

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static toSingle(Lorg/reactivestreams/Publisher;)Lrx/Single;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/reactivestreams/Publisher<",
            "TT;>;)",
            "Lrx/Single<",
            "TT;>;"
        }
    .end annotation

    if-eqz p0, :cond_0

    .line 138
    new-instance v0, Lrx/internal/reactivestreams/PublisherAsSingle;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/PublisherAsSingle;-><init>(Lorg/reactivestreams/Publisher;)V

    invoke-static {v0}, Lrx/Single;->create(Lrx/Single$OnSubscribe;)Lrx/Single;

    move-result-object p0

    return-object p0

    .line 136
    :cond_0
    new-instance p0, Ljava/lang/NullPointerException;

    const-string v0, "publisher"

    invoke-direct {p0, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static toSubscriber(Lrx/Subscriber;)Lorg/reactivestreams/Subscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Subscriber<",
            "TT;>;)",
            "Lorg/reactivestreams/Subscriber<",
            "TT;>;"
        }
    .end annotation

    .line 73
    new-instance v0, Lrx/internal/reactivestreams/SubscriberAdapter;

    invoke-direct {v0, p0}, Lrx/internal/reactivestreams/SubscriberAdapter;-><init>(Lrx/Subscriber;)V

    return-object v0
.end method
