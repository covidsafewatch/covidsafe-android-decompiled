.class final Lrx/internal/operators/OperatorSwitch$InnerSubscriber;
.super Lrx/Subscriber;
.source "OperatorSwitch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorSwitch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "InnerSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final id:J

.field private final parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorSwitch$SwitchSubscriber<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(JLrx/internal/operators/OperatorSwitch$SwitchSubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lrx/internal/operators/OperatorSwitch$SwitchSubscriber<",
            "TT;>;)V"
        }
    .end annotation

    .line 387
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 388
    iput-wide p1, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->id:J

    .line 389
    iput-object p3, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;

    return-void
.end method

.method static synthetic access$000(Lrx/internal/operators/OperatorSwitch$InnerSubscriber;)J
    .locals 2

    .line 381
    iget-wide v0, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->id:J

    return-wide v0
.end method


# virtual methods
.method public onCompleted()V
    .locals 3

    .line 409
    iget-object v0, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;

    iget-wide v1, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->id:J

    invoke-virtual {v0, v1, v2}, Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;->complete(J)V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 3

    .line 404
    iget-object v0, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;

    iget-wide v1, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->id:J

    invoke-virtual {v0, p1, v1, v2}, Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;->error(Ljava/lang/Throwable;J)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 399
    iget-object v0, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;

    invoke-virtual {v0, p1, p0}, Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;->emit(Ljava/lang/Object;Lrx/internal/operators/OperatorSwitch$InnerSubscriber;)V

    return-void
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 3

    .line 394
    iget-object v0, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->parent:Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;

    iget-wide v1, p0, Lrx/internal/operators/OperatorSwitch$InnerSubscriber;->id:J

    invoke-virtual {v0, p1, v1, v2}, Lrx/internal/operators/OperatorSwitch$SwitchSubscriber;->innerProducer(Lrx/Producer;J)V

    return-void
.end method
