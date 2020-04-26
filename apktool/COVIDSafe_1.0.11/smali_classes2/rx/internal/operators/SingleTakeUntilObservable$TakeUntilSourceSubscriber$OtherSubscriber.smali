.class final Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber$OtherSubscriber;
.super Lrx/Subscriber;
.source "SingleTakeUntilObservable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "OtherSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrx/Subscriber<",
        "TU;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;


# direct methods
.method constructor <init>(Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;)V
    .locals 0

    .line 86
    iput-object p1, p0, Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber$OtherSubscriber;->this$0:Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;

    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 2

    .line 99
    new-instance v0, Ljava/util/concurrent/CancellationException;

    const-string v1, "Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."

    invoke-direct {v0, v1}, Ljava/util/concurrent/CancellationException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber$OtherSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 94
    iget-object v0, p0, Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber$OtherSubscriber;->this$0:Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;

    invoke-virtual {v0, p1}, Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TU;)V"
        }
    .end annotation

    .line 89
    invoke-virtual {p0}, Lrx/internal/operators/SingleTakeUntilObservable$TakeUntilSourceSubscriber$OtherSubscriber;->onCompleted()V

    return-void
.end method
