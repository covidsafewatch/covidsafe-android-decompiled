.class public final Lrx/internal/operators/OperatorGroupBy$GroupByProducer;
.super Ljava/lang/Object;
.source "OperatorGroupBy.java"

# interfaces
.implements Lrx/Producer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorGroupBy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GroupByProducer"
.end annotation


# instance fields
.field final parent:Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber<",
            "***>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber<",
            "***>;)V"
        }
    .end annotation

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 106
    iput-object p1, p0, Lrx/internal/operators/OperatorGroupBy$GroupByProducer;->parent:Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber;

    return-void
.end method


# virtual methods
.method public request(J)V
    .locals 1

    .line 110
    iget-object v0, p0, Lrx/internal/operators/OperatorGroupBy$GroupByProducer;->parent:Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber;

    invoke-virtual {v0, p1, p2}, Lrx/internal/operators/OperatorGroupBy$GroupBySubscriber;->requestMore(J)V

    return-void
.end method
