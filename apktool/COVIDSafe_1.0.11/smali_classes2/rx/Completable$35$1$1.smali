.class Lrx/Completable$35$1$1;
.super Ljava/lang/Object;
.source "Completable.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/Completable$35$1;->onSubscribe(Lrx/Subscription;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lrx/Completable$35$1;

.field final synthetic val$d:Lrx/Subscription;


# direct methods
.method constructor <init>(Lrx/Completable$35$1;Lrx/Subscription;)V
    .locals 0

    .line 2350
    iput-object p1, p0, Lrx/Completable$35$1$1;->this$2:Lrx/Completable$35$1;

    iput-object p2, p0, Lrx/Completable$35$1$1;->val$d:Lrx/Subscription;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 2

    .line 2353
    iget-object v0, p0, Lrx/Completable$35$1$1;->this$2:Lrx/Completable$35$1;

    iget-object v0, v0, Lrx/Completable$35$1;->this$1:Lrx/Completable$35;

    iget-object v0, v0, Lrx/Completable$35;->val$scheduler:Lrx/Scheduler;

    invoke-virtual {v0}, Lrx/Scheduler;->createWorker()Lrx/Scheduler$Worker;

    move-result-object v0

    .line 2354
    new-instance v1, Lrx/Completable$35$1$1$1;

    invoke-direct {v1, p0, v0}, Lrx/Completable$35$1$1$1;-><init>(Lrx/Completable$35$1$1;Lrx/Scheduler$Worker;)V

    invoke-virtual {v0, v1}, Lrx/Scheduler$Worker;->schedule(Lrx/functions/Action0;)Lrx/Subscription;

    return-void
.end method
