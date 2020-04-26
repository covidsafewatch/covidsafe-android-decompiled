.class Lrx/internal/operators/OnSubscribeReduce$1;
.super Ljava/lang/Object;
.source "OnSubscribeReduce.java"

# interfaces
.implements Lrx/Producer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OnSubscribeReduce;->call(Lrx/Subscriber;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/OnSubscribeReduce;

.field final synthetic val$parent:Lrx/internal/operators/OnSubscribeReduce$ReduceSubscriber;


# direct methods
.method constructor <init>(Lrx/internal/operators/OnSubscribeReduce;Lrx/internal/operators/OnSubscribeReduce$ReduceSubscriber;)V
    .locals 0

    .line 42
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeReduce$1;->this$0:Lrx/internal/operators/OnSubscribeReduce;

    iput-object p2, p0, Lrx/internal/operators/OnSubscribeReduce$1;->val$parent:Lrx/internal/operators/OnSubscribeReduce$ReduceSubscriber;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public request(J)V
    .locals 1

    .line 45
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeReduce$1;->val$parent:Lrx/internal/operators/OnSubscribeReduce$ReduceSubscriber;

    invoke-virtual {v0, p1, p2}, Lrx/internal/operators/OnSubscribeReduce$ReduceSubscriber;->downstreamRequest(J)V

    return-void
.end method
