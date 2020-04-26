.class final Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;
.super Lrx/Subscriber;
.source "OperatorWindowWithObservableFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorWindowWithObservableFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BoundarySubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "U:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TU;>;"
    }
.end annotation


# instance fields
.field done:Z

.field final sub:Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber<",
            "TT;TU;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber<",
            "TT;TU;>;)V"
        }
    .end annotation

    .line 290
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 291
    iput-object p1, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->sub:Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 314
    iget-boolean v0, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->done:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    .line 315
    iput-boolean v0, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->done:Z

    .line 316
    iget-object v0, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->sub:Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;

    invoke-virtual {v0}, Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;->onCompleted()V

    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 309
    iget-object v0, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->sub:Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;

    invoke-virtual {v0, p1}, Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TU;)V"
        }
    .end annotation

    .line 301
    iget-boolean p1, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->done:Z

    if-nez p1, :cond_0

    const/4 p1, 0x1

    .line 302
    iput-boolean p1, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->done:Z

    .line 303
    iget-object p1, p0, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->sub:Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;

    invoke-virtual {p1}, Lrx/internal/operators/OperatorWindowWithObservableFactory$SourceSubscriber;->replaceWindow()V

    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 2

    const-wide v0, 0x7fffffffffffffffL

    .line 296
    invoke-virtual {p0, v0, v1}, Lrx/internal/operators/OperatorWindowWithObservableFactory$BoundarySubscriber;->request(J)V

    return-void
.end method
