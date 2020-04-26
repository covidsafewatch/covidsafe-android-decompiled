.class Lrx/internal/reactivestreams/PublisherAdapter$1;
.super Lrx/Subscriber;
.source "PublisherAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/reactivestreams/PublisherAdapter;->subscribe(Lorg/reactivestreams/Subscriber;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final childRequested:Ljava/util/concurrent/atomic/AtomicLong;

.field private final done:Ljava/util/concurrent/atomic/AtomicBoolean;

.field final synthetic this$0:Lrx/internal/reactivestreams/PublisherAdapter;

.field final synthetic val$s:Lorg/reactivestreams/Subscriber;


# direct methods
.method constructor <init>(Lrx/internal/reactivestreams/PublisherAdapter;Lorg/reactivestreams/Subscriber;)V
    .locals 0

    .line 35
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->this$0:Lrx/internal/reactivestreams/PublisherAdapter;

    iput-object p2, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->val$s:Lorg/reactivestreams/Subscriber;

    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 36
    new-instance p1, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->done:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 37
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->childRequested:Ljava/util/concurrent/atomic/AtomicLong;

    return-void
.end method

.method static synthetic access$000(Lrx/internal/reactivestreams/PublisherAdapter$1;J)V
    .locals 0

    .line 35
    invoke-direct {p0, p1, p2}, Lrx/internal/reactivestreams/PublisherAdapter$1;->doRequest(J)V

    return-void
.end method

.method private doRequest(J)V
    .locals 1

    .line 39
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->done:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 40
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->childRequested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {v0, p1, p2}, Lrx/internal/operators/BackpressureUtils;->getAndAddRequest(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 41
    invoke-virtual {p0, p1, p2}, Lrx/internal/reactivestreams/PublisherAdapter$1;->request(J)V

    :cond_0
    return-void
.end method


# virtual methods
.method fireDone()Z
    .locals 3

    .line 74
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->done:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    return v0
.end method

.method public onCompleted()V
    .locals 1

    .line 79
    invoke-virtual {p0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->fireDone()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->val$s:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0}, Lorg/reactivestreams/Subscriber;->onComplete()V

    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 86
    invoke-virtual {p0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->fireDone()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->val$s:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onError(Ljava/lang/Throwable;)V

    :cond_0
    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 93
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->done:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_1

    .line 94
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->childRequested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 95
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->val$s:Lorg/reactivestreams/Subscriber;

    invoke-interface {v0, p1}, Lorg/reactivestreams/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 96
    iget-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->childRequested:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicLong;->decrementAndGet()J

    goto :goto_0

    .line 99
    :cond_0
    :try_start_0
    new-instance p1, Ljava/lang/IllegalStateException;

    const-string v0, "1.1 source doesn\'t respect backpressure"

    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lrx/internal/reactivestreams/PublisherAdapter$1;->onError(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    invoke-virtual {p0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->unsubscribe()V

    goto :goto_0

    :catchall_0
    move-exception p1

    invoke-virtual {p0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->unsubscribe()V

    throw p1

    :cond_1
    :goto_0
    return-void
.end method

.method public onStart()V
    .locals 3

    .line 47
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>()V

    .line 48
    iget-object v1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1;->val$s:Lorg/reactivestreams/Subscriber;

    new-instance v2, Lrx/internal/reactivestreams/PublisherAdapter$1$1;

    invoke-direct {v2, p0, v0}, Lrx/internal/reactivestreams/PublisherAdapter$1$1;-><init>(Lrx/internal/reactivestreams/PublisherAdapter$1;Ljava/util/concurrent/atomic/AtomicBoolean;)V

    invoke-interface {v1, v2}, Lorg/reactivestreams/Subscriber;->onSubscribe(Lorg/reactivestreams/Subscription;)V

    .line 68
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    const-wide/16 v0, 0x0

    .line 69
    invoke-virtual {p0, v0, v1}, Lrx/internal/reactivestreams/PublisherAdapter$1;->request(J)V

    :cond_0
    return-void
.end method
