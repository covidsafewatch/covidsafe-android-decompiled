.class public final Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;
.super Ljava/lang/Object;
.source "OperatorGroupByEvicting.java"

# interfaces
.implements Lrx/Producer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorGroupByEvicting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GroupByProducer"
.end annotation


# instance fields
.field final parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber<",
            "***>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber<",
            "***>;)V"
        }
    .end annotation

    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    return-void
.end method


# virtual methods
.method public request(J)V
    .locals 1

    .line 118
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupByEvicting$GroupByProducer;->parent:Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;

    invoke-virtual {v0, p1, p2}, Lrx/internal/operators/OperatorGroupByEvicting$GroupBySubscriber;->requestMore(J)V

    return-void
.end method
