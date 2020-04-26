.class final Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;
.super Lrx/observables/GroupedObservable;
.source "OperatorGroupByEvicting.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorGroupByEvicting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "GroupedUnicast"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/observables/GroupedObservable<",
        "TK;TT;>;"
    }
.end annotation


# instance fields
.field final state:Lrx/internal/operators/OperatorGroupByEvicting$State;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorGroupByEvicting$State<",
            "TT;TK;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Ljava/lang/Object;Lrx/internal/operators/OperatorGroupByEvicting$State;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Lrx/internal/operators/OperatorGroupByEvicting$State<",
            "TT;TK;>;)V"
        }
    .end annotation

    .line 407
    invoke-direct {p0, p1, p2}, Lrx/observables/GroupedObservable;-><init>(Ljava/lang/Object;Lrx/Observable$OnSubscribe;)V

    .line 408
    iput-object p2, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->state:Lrx/internal/operators/OperatorGroupByEvicting$State;

    return-void
.end method

.method public static createWith(Ljava/lang/Object;ILrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;Z)Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "K:",
            "Ljava/lang/Object;",
            ">(TK;I",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber<",
            "*TK;TT;>;Z)",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast<",
            "TK;TT;>;"
        }
    .end annotation

    .line 400
    new-instance v0, Lrx/internal/operators/OperatorGroupByEvicting$State;

    invoke-direct {v0, p1, p2, p0, p3}, Lrx/internal/operators/OperatorGroupByEvicting$State;-><init>(ILrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;Ljava/lang/Object;Z)V

    .line 401
    new-instance p1, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;

    invoke-direct {p1, p0, v0}, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;-><init>(Ljava/lang/Object;Lrx/internal/operators/OperatorGroupByEvicting$State;)V

    return-object p1
.end method


# virtual methods
.method public onComplete()V
    .locals 1

    .line 420
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->state:Lrx/internal/operators/OperatorGroupByEvicting$State;

    invoke-virtual {v0}, Lrx/internal/operators/OperatorGroupByEvicting$State;->onComplete()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 416
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->state:Lrx/internal/operators/OperatorGroupByEvicting$State;

    invoke-virtual {v0, p1}, Lrx/internal/operators/OperatorGroupByEvicting$State;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 412
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupedUnicast;->state:Lrx/internal/operators/OperatorGroupByEvicting$State;

    invoke-virtual {v0, p1}, Lrx/internal/operators/OperatorGroupByEvicting$State;->onNext(Ljava/lang/Object;)V

    return-void
.end method
