.class public final Lcom/atlassian/mobilekit/module/core/JobQueue;
.super Ljava/lang/Object;
.source "JobQueue.java"


# instance fields
.field private final executor:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x5

    .line 16
    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/JobQueue;->executor:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public final enqueue(Ljava/lang/Runnable;)V
    .locals 1

    .line 20
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/JobQueue;->executor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0, p1}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public getExecutor()Ljava/util/concurrent/Executor;
    .locals 1

    .line 25
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/JobQueue;->executor:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method
