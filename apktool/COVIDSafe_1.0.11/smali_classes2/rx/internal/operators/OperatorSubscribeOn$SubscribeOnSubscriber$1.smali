.class Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;
.super Ljava/lang/Object;
.source "OperatorSubscribeOn.java"

# interfaces
.implements Lrx/Producer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;->setProducer(Lrx/Producer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;

.field final synthetic val$p:Lrx/Producer;


# direct methods
.method constructor <init>(Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;Lrx/Producer;)V
    .locals 0

    .line 105
    iput-object p1, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->this$0:Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;

    iput-object p2, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->val$p:Lrx/Producer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public request(J)V
    .locals 2

    .line 108
    iget-object v0, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->this$0:Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;

    iget-object v0, v0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;->t:Ljava/lang/Thread;

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->this$0:Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;

    iget-boolean v0, v0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;->requestOn:Z

    if-nez v0, :cond_0

    goto :goto_0

    .line 111
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->this$0:Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;

    iget-object v0, v0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber;->worker:Lrx/Scheduler$Worker;

    new-instance v1, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1$1;

    invoke-direct {v1, p0, p1, p2}, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1$1;-><init>(Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;J)V

    invoke-virtual {v0, v1}, Lrx/Scheduler$Worker;->schedule(Lrx/functions/Action0;)Lrx/Subscription;

    goto :goto_1

    .line 109
    :cond_1
    :goto_0
    iget-object v0, p0, Lrx/internal/operators/OperatorSubscribeOn$SubscribeOnSubscriber$1;->val$p:Lrx/Producer;

    invoke-interface {v0, p1, p2}, Lrx/Producer;->request(J)V

    :goto_1
    return-void
.end method
