.class public final Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;
.super Ljava/lang/Object;
.source "RxJavaSynchronizedProducer.java"

# interfaces
.implements Lrx/Producer;
.implements Lrx/Subscription;


# instance fields
.field private emitting:Z

.field private requests:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final subscription:Lorg/reactivestreams/Subscription;

.field private volatile unsubscribed:Z


# direct methods
.method public constructor <init>(Lorg/reactivestreams/Subscription;)V
    .locals 1

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_0

    .line 34
    iput-object p1, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->subscription:Lorg/reactivestreams/Subscription;

    return-void

    .line 32
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "subscription"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method


# virtual methods
.method public isUnsubscribed()Z
    .locals 1

    .line 38
    iget-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    return v0
.end method

.method public request(J)V
    .locals 7

    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-lez v2, :cond_7

    .line 42
    iget-boolean v2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    if-nez v2, :cond_7

    .line 43
    monitor-enter p0

    .line 44
    :try_start_0
    iget-boolean v2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    if-eqz v2, :cond_0

    .line 45
    monitor-exit p0

    return-void

    .line 47
    :cond_0
    iget-boolean v2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z

    if-eqz v2, :cond_2

    .line 48
    iget-object v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    if-nez v0, :cond_1

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    .line 51
    :cond_1
    iget-object v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 52
    monitor-exit p0

    return-void

    :cond_2
    const/4 v2, 0x1

    .line 54
    iput-boolean v2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z

    .line 55
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    const/4 v3, 0x0

    .line 58
    :try_start_1
    iget-object v4, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->subscription:Lorg/reactivestreams/Subscription;

    invoke-interface {v4, p1, p2}, Lorg/reactivestreams/Subscription;->request(J)V

    .line 61
    :cond_3
    monitor-enter p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    .line 62
    :try_start_2
    iget-object p1, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    const/4 p2, 0x0

    .line 63
    iput-object p2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    if-nez p1, :cond_4

    .line 65
    iput-boolean v3, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 67
    :try_start_3
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    return-void

    .line 69
    :cond_4
    :try_start_4
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 70
    :try_start_5
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_3

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/Long;

    .line 71
    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    cmp-long v4, v4, v0

    if-nez v4, :cond_5

    .line 72
    iput-boolean v2, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    .line 73
    iget-object p1, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->subscription:Lorg/reactivestreams/Subscription;

    invoke-interface {p1}, Lorg/reactivestreams/Subscription;->cancel()V

    return-void

    .line 77
    :cond_5
    iget-object v4, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->subscription:Lorg/reactivestreams/Subscription;

    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    invoke-interface {v4, v5, v6}, Lorg/reactivestreams/Subscription;->request(J)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    goto :goto_0

    :catchall_0
    move-exception p1

    move v2, v3

    .line 69
    :goto_1
    :try_start_6
    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    :try_start_7
    throw p1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    :catchall_1
    move-exception p1

    goto :goto_2

    :catchall_2
    move-exception p1

    goto :goto_1

    :catchall_3
    move-exception p1

    move v2, v3

    :goto_2
    if-nez v2, :cond_6

    .line 83
    monitor-enter p0

    .line 84
    :try_start_8
    iput-boolean v3, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z

    .line 85
    monitor-exit p0

    goto :goto_3

    :catchall_4
    move-exception p1

    monitor-exit p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    throw p1

    :cond_6
    :goto_3
    throw p1

    :catchall_5
    move-exception p1

    .line 55
    :try_start_9
    monitor-exit p0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_5

    throw p1

    :cond_7
    return-void
.end method

.method public unsubscribe()V
    .locals 3

    .line 92
    iget-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    if-nez v0, :cond_2

    .line 93
    monitor-enter p0

    .line 94
    :try_start_0
    iget-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    if-eqz v0, :cond_0

    .line 95
    monitor-exit p0

    return-void

    .line 97
    :cond_0
    iget-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z

    if-eqz v0, :cond_1

    .line 99
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->requests:Ljava/util/List;

    const-wide/16 v1, 0x0

    .line 100
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 101
    monitor-exit p0

    return-void

    :cond_1
    const/4 v0, 0x1

    .line 103
    iput-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->emitting:Z

    .line 104
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 105
    iput-boolean v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->unsubscribed:Z

    .line 106
    iget-object v0, p0, Lrx/internal/reactivestreams/RxJavaSynchronizedProducer;->subscription:Lorg/reactivestreams/Subscription;

    invoke-interface {v0}, Lorg/reactivestreams/Subscription;->cancel()V

    goto :goto_0

    :catchall_0
    move-exception v0

    .line 104
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_2
    :goto_0
    return-void
.end method
