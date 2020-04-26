.class Lrx/internal/reactivestreams/PublisherAdapter$1$1;
.super Ljava/lang/Object;
.source "PublisherAdapter.java"

# interfaces
.implements Lorg/reactivestreams/Subscription;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/reactivestreams/PublisherAdapter$1;->onStart()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

.field final synthetic val$requested:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method constructor <init>(Lrx/internal/reactivestreams/PublisherAdapter$1;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    .locals 0

    .line 48
    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    iput-object p2, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->val$requested:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .line 63
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    invoke-virtual {v0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->unsubscribe()V

    .line 64
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    invoke-virtual {v0}, Lrx/internal/reactivestreams/PublisherAdapter$1;->fireDone()Z

    return-void
.end method

.method public request(J)V
    .locals 2

    const-wide/16 v0, 0x1

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    .line 52
    iget-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    invoke-virtual {p1}, Lrx/internal/reactivestreams/PublisherAdapter$1;->unsubscribe()V

    .line 53
    iget-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    new-instance p2, Ljava/lang/IllegalArgumentException;

    const-string v0, "3.9 While the Subscription is not cancelled, Subscription.request(long n) MUST throw a java.lang.IllegalArgumentException if the argument is <= 0."

    invoke-direct {p2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p2}, Lrx/internal/reactivestreams/PublisherAdapter$1;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 57
    :cond_0
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->val$requested:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 58
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter$1$1;->this$1:Lrx/internal/reactivestreams/PublisherAdapter$1;

    invoke-static {v0, p1, p2}, Lrx/internal/reactivestreams/PublisherAdapter$1;->access$000(Lrx/internal/reactivestreams/PublisherAdapter$1;J)V

    return-void
.end method
