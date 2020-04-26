.class Lrx/Single$13$1$1;
.super Lrx/SingleSubscriber;
.source "Single.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/Single$13$1;->call()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrx/SingleSubscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$2:Lrx/Single$13$1;


# direct methods
.method constructor <init>(Lrx/Single$13$1;)V
    .locals 0

    .line 2029
    iput-object p1, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    invoke-direct {p0}, Lrx/SingleSubscriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 2042
    :try_start_0
    iget-object v0, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object v0, v0, Lrx/Single$13$1;->val$t:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2044
    iget-object p1, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object p1, p1, Lrx/Single$13$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {p1}, Lrx/Scheduler$Worker;->unsubscribe()V

    return-void

    :catchall_0
    move-exception p1

    iget-object v0, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object v0, v0, Lrx/Single$13$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {v0}, Lrx/Scheduler$Worker;->unsubscribe()V

    throw p1
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 2033
    :try_start_0
    iget-object v0, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object v0, v0, Lrx/Single$13$1;->val$t:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onSuccess(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2035
    iget-object p1, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object p1, p1, Lrx/Single$13$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {p1}, Lrx/Scheduler$Worker;->unsubscribe()V

    return-void

    :catchall_0
    move-exception p1

    iget-object v0, p0, Lrx/Single$13$1$1;->this$2:Lrx/Single$13$1;

    iget-object v0, v0, Lrx/Single$13$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {v0}, Lrx/Scheduler$Worker;->unsubscribe()V

    throw p1
.end method
