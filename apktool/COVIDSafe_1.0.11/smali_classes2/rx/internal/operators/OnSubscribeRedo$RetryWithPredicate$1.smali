.class Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate$1;
.super Ljava/lang/Object;
.source "OnSubscribeRedo.java"

# interfaces
.implements Lrx/functions/Func2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;->call(Lrx/Observable;)Lrx/Observable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lrx/functions/Func2<",
        "Lrx/Notification<",
        "Ljava/lang/Integer;",
        ">;",
        "Lrx/Notification<",
        "*>;",
        "Lrx/Notification<",
        "Ljava/lang/Integer;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;


# direct methods
.method constructor <init>(Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;)V
    .locals 0

    .line 106
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate$1;->this$0:Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 106
    check-cast p1, Lrx/Notification;

    check-cast p2, Lrx/Notification;

    invoke-virtual {p0, p1, p2}, Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate$1;->call(Lrx/Notification;Lrx/Notification;)Lrx/Notification;

    move-result-object p1

    return-object p1
.end method

.method public call(Lrx/Notification;Lrx/Notification;)Lrx/Notification;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Notification<",
            "Ljava/lang/Integer;",
            ">;",
            "Lrx/Notification<",
            "*>;)",
            "Lrx/Notification<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 110
    invoke-virtual {p1}, Lrx/Notification;->getValue()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    .line 111
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate$1;->this$0:Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;

    iget-object v0, v0, Lrx/internal/operators/OnSubscribeRedo$RetryWithPredicate;->predicate:Lrx/functions/Func2;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p2}, Lrx/Notification;->getThrowable()Ljava/lang/Throwable;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lrx/functions/Func2;->call(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    add-int/lit8 p1, p1, 0x1

    .line 112
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {p1}, Lrx/Notification;->createOnNext(Ljava/lang/Object;)Lrx/Notification;

    move-result-object p1

    return-object p1

    :cond_0
    return-object p2
.end method
