.class Lrx/internal/operators/OperatorGroupByEvicting$1;
.super Ljava/lang/Object;
.source "OperatorGroupByEvicting.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OperatorGroupByEvicting;->call(Lrx/Subscriber;)Lrx/Subscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/OperatorGroupByEvicting;

.field final synthetic val$parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;


# direct methods
.method constructor <init>(Lrx/internal/operators/OperatorGroupByEvicting;Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;)V
    .locals 0

    .line 98
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$1;->this$0:Lrx/internal/operators/OperatorGroupByEvicting;

    iput-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$1;->val$parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 1

    .line 101
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$1;->val$parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    invoke-virtual {v0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->cancel()V

    return-void
.end method
