.class final Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;
.super Lrx/Subscriber;
.source "OnSubscribeSkipTimed.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OnSubscribeSkipTimed;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SkipTimedSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;",
        "Lrx/functions/Action0;"
    }
.end annotation


# instance fields
.field final child:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-TT;>;"
        }
    .end annotation
.end field

.field volatile gate:Z


# direct methods
.method constructor <init>(Lrx/Subscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 59
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 60
    iput-object p1, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->child:Lrx/Subscriber;

    return-void
.end method


# virtual methods
.method public call()V
    .locals 1

    const/4 v0, 0x1

    .line 65
    iput-boolean v0, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->gate:Z

    return-void
.end method

.method public onCompleted()V
    .locals 1

    .line 87
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 89
    invoke-virtual {p0}, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->unsubscribe()V

    return-void

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->unsubscribe()V

    throw v0
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 78
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 80
    invoke-virtual {p0}, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->unsubscribe()V

    return-void

    :catchall_0
    move-exception p1

    invoke-virtual {p0}, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->unsubscribe()V

    throw p1
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 70
    iget-boolean v0, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->gate:Z

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lrx/internal/operators/OnSubscribeSkipTimed$SkipTimedSubscriber;->child:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    :cond_0
    return-void
.end method
