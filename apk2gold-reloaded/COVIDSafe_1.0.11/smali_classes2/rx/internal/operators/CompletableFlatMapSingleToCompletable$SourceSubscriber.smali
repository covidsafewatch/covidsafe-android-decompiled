.class final Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;
.super Lrx/SingleSubscriber;
.source "CompletableFlatMapSingleToCompletable.java"

# interfaces
.implements Lrx/CompletableSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/CompletableFlatMapSingleToCompletable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "SourceSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/SingleSubscriber<",
        "TT;>;",
        "Lrx/CompletableSubscriber;"
    }
.end annotation


# instance fields
.field final actual:Lrx/CompletableSubscriber;

.field final mapper:Lrx/functions/Func1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Func1<",
            "-TT;+",
            "Lrx/Completable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/CompletableSubscriber;Lrx/functions/Func1;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/CompletableSubscriber;",
            "Lrx/functions/Func1<",
            "-TT;+",
            "Lrx/Completable;",
            ">;)V"
        }
    .end annotation

    .line 51
    invoke-direct {p0}, Lrx/SingleSubscriber;-><init>()V

    .line 52
    iput-object p1, p0, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->actual:Lrx/CompletableSubscriber;

    .line 53
    iput-object p2, p0, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->mapper:Lrx/functions/Func1;

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 83
    iget-object v0, p0, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0}, Lrx/CompletableSubscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 78
    iget-object v0, p0, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->actual:Lrx/CompletableSubscriber;

    invoke-interface {v0, p1}, Lrx/CompletableSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSubscribe(Lrx/Subscription;)V
    .locals 0

    .line 88
    invoke-virtual {p0, p1}, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->add(Lrx/Subscription;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 61
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->mapper:Lrx/functions/Func1;

    invoke-interface {v0, p1}, Lrx/functions/Func1;->call(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrx/Completable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez p1, :cond_0

    .line 69
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "The mapper returned a null Completable"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 73
    :cond_0
    invoke-virtual {p1, p0}, Lrx/Completable;->subscribe(Lrx/CompletableSubscriber;)V

    return-void

    :catchall_0
    move-exception p1

    .line 63
    invoke-static {p1}, Lrx/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 64
    invoke-virtual {p0, p1}, Lrx/internal/operators/CompletableFlatMapSingleToCompletable$SourceSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method
