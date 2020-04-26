.class Lrx/Completable$26$1$1;
.super Ljava/lang/Object;
.source "Completable.java"

# interfaces
.implements Lrx/CompletableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/Completable$26$1;->onError(Ljava/lang/Throwable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lrx/Completable$26$1;


# direct methods
.method constructor <init>(Lrx/Completable$26$1;)V
    .locals 0

    .line 1756
    iput-object p1, p0, Lrx/Completable$26$1$1;->this$2:Lrx/Completable$26$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 1760
    iget-object v0, p0, Lrx/Completable$26$1$1;->this$2:Lrx/Completable$26$1;

    iget-object v0, v0, Lrx/Completable$26$1;->val$s:Lrx/CompletableSubscriber;

    invoke-interface {v0}, Lrx/CompletableSubscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1765
    iget-object v0, p0, Lrx/Completable$26$1$1;->this$2:Lrx/Completable$26$1;

    iget-object v0, v0, Lrx/Completable$26$1;->val$s:Lrx/CompletableSubscriber;

    invoke-interface {v0, p1}, Lrx/CompletableSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lrx/Subscription;)V
    .locals 1

    .line 1770
    iget-object v0, p0, Lrx/Completable$26$1$1;->this$2:Lrx/Completable$26$1;

    iget-object v0, v0, Lrx/Completable$26$1;->val$sd:Lrx/subscriptions/SerialSubscription;

    invoke-virtual {v0, p1}, Lrx/subscriptions/SerialSubscription;->set(Lrx/Subscription;)V

    return-void
.end method
