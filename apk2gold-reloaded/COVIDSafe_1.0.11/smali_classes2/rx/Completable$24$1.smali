.class Lrx/Completable$24$1;
.super Ljava/lang/Object;
.source "Completable.java"

# interfaces
.implements Lrx/CompletableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/Completable$24;->call(Lrx/CompletableSubscriber;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lrx/Completable$24;

.field final synthetic val$ad:Lrx/internal/util/SubscriptionList;

.field final synthetic val$s:Lrx/CompletableSubscriber;

.field final synthetic val$w:Lrx/Scheduler$Worker;


# direct methods
.method constructor <init>(Lrx/Completable$24;Lrx/Scheduler$Worker;Lrx/CompletableSubscriber;Lrx/internal/util/SubscriptionList;)V
    .locals 0

    .line 1617
    iput-object p1, p0, Lrx/Completable$24$1;->this$1:Lrx/Completable$24;

    iput-object p2, p0, Lrx/Completable$24$1;->val$w:Lrx/Scheduler$Worker;

    iput-object p3, p0, Lrx/Completable$24$1;->val$s:Lrx/CompletableSubscriber;

    iput-object p4, p0, Lrx/Completable$24$1;->val$ad:Lrx/internal/util/SubscriptionList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 2

    .line 1621
    iget-object v0, p0, Lrx/Completable$24$1;->val$w:Lrx/Scheduler$Worker;

    new-instance v1, Lrx/Completable$24$1$1;

    invoke-direct {v1, p0}, Lrx/Completable$24$1$1;-><init>(Lrx/Completable$24$1;)V

    invoke-virtual {v0, v1}, Lrx/Scheduler$Worker;->schedule(Lrx/functions/Action0;)Lrx/Subscription;

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 2

    .line 1635
    iget-object v0, p0, Lrx/Completable$24$1;->val$w:Lrx/Scheduler$Worker;

    new-instance v1, Lrx/Completable$24$1$2;

    invoke-direct {v1, p0, p1}, Lrx/Completable$24$1$2;-><init>(Lrx/Completable$24$1;Ljava/lang/Throwable;)V

    invoke-virtual {v0, v1}, Lrx/Scheduler$Worker;->schedule(Lrx/functions/Action0;)Lrx/Subscription;

    return-void
.end method

.method public onSubscribe(Lrx/Subscription;)V
    .locals 1

    .line 1649
    iget-object v0, p0, Lrx/Completable$24$1;->val$ad:Lrx/internal/util/SubscriptionList;

    invoke-virtual {v0, p1}, Lrx/internal/util/SubscriptionList;->add(Lrx/Subscription;)V

    return-void
.end method
