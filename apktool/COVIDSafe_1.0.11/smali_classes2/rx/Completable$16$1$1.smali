.class Lrx/Completable$16$1$1;
.super Ljava/lang/Object;
.source "Completable.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/Completable$16$1;->onCompleted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lrx/Completable$16$1;


# direct methods
.method constructor <init>(Lrx/Completable$16$1;)V
    .locals 0

    .line 1245
    iput-object p1, p0, Lrx/Completable$16$1$1;->this$2:Lrx/Completable$16$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 2

    .line 1249
    :try_start_0
    iget-object v0, p0, Lrx/Completable$16$1$1;->this$2:Lrx/Completable$16$1;

    iget-object v0, v0, Lrx/Completable$16$1;->val$s:Lrx/CompletableSubscriber;

    invoke-interface {v0}, Lrx/CompletableSubscriber;->onCompleted()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1251
    iget-object v0, p0, Lrx/Completable$16$1$1;->this$2:Lrx/Completable$16$1;

    iget-object v0, v0, Lrx/Completable$16$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {v0}, Lrx/Scheduler$Worker;->unsubscribe()V

    return-void

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lrx/Completable$16$1$1;->this$2:Lrx/Completable$16$1;

    iget-object v1, v1, Lrx/Completable$16$1;->val$w:Lrx/Scheduler$Worker;

    invoke-virtual {v1}, Lrx/Scheduler$Worker;->unsubscribe()V

    throw v0
.end method
