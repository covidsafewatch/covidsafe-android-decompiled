.class Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker$2;
.super Ljava/lang/Object;
.source "EventLoopsScheduler.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;->schedule(Lrx/functions/Action0;JLjava/util/concurrent/TimeUnit;)Lrx/Subscription;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;

.field final synthetic val$action:Lrx/functions/Action0;


# direct methods
.method constructor <init>(Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;Lrx/functions/Action0;)V
    .locals 0

    .line 183
    iput-object p1, p0, Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker$2;->this$0:Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;

    iput-object p2, p0, Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker$2;->val$action:Lrx/functions/Action0;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 1

    .line 186
    iget-object v0, p0, Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker$2;->this$0:Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;

    invoke-virtual {v0}, Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker;->isUnsubscribed()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 189
    :cond_0
    iget-object v0, p0, Lrx/internal/schedulers/EventLoopsScheduler$EventLoopWorker$2;->val$action:Lrx/functions/Action0;

    invoke-interface {v0}, Lrx/functions/Action0;->call()V

    return-void
.end method
