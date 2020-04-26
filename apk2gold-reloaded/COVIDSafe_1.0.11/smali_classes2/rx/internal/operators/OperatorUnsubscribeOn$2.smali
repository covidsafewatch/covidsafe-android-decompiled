.class Lrx/internal/operators/OperatorUnsubscribeOn$2;
.super Ljava/lang/Object;
.source "OperatorUnsubscribeOn.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OperatorUnsubscribeOn;->call(Lrx/Subscriber;)Lrx/Subscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/OperatorUnsubscribeOn;

.field final synthetic val$parent:Lrx/Subscriber;


# direct methods
.method constructor <init>(Lrx/internal/operators/OperatorUnsubscribeOn;Lrx/Subscriber;)V
    .locals 0

    .line 61
    iput-object p1, p0, Lrx/internal/operators/OperatorUnsubscribeOn$2;->this$0:Lrx/internal/operators/OperatorUnsubscribeOn;

    iput-object p2, p0, Lrx/internal/operators/OperatorUnsubscribeOn$2;->val$parent:Lrx/Subscriber;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 2

    .line 65
    iget-object v0, p0, Lrx/internal/operators/OperatorUnsubscribeOn$2;->this$0:Lrx/internal/operators/OperatorUnsubscribeOn;

    iget-object v0, v0, Lrx/internal/operators/OperatorUnsubscribeOn;->scheduler:Lrx/Scheduler;

    invoke-virtual {v0}, Lrx/Scheduler;->createWorker()Lrx/Scheduler$Worker;

    move-result-object v0

    .line 66
    new-instance v1, Lrx/internal/operators/OperatorUnsubscribeOn$2$1;

    invoke-direct {v1, p0, v0}, Lrx/internal/operators/OperatorUnsubscribeOn$2$1;-><init>(Lrx/internal/operators/OperatorUnsubscribeOn$2;Lrx/Scheduler$Worker;)V

    invoke-virtual {v0, v1}, Lrx/Scheduler$Worker;->schedule(Lrx/functions/Action0;)Lrx/Subscription;

    return-void
.end method
