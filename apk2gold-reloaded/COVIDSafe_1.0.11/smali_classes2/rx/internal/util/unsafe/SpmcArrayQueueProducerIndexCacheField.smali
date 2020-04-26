.class abstract Lrx/internal/util/unsafe/SpmcArrayQueueProducerIndexCacheField;
.super Lrx/internal/util/unsafe/SpmcArrayQueueMidPad;
.source "SpmcArrayQueue.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/internal/util/unsafe/SpmcArrayQueueMidPad<",
        "TE;>;"
    }
.end annotation


# instance fields
.field private volatile producerIndexCache:J


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .line 93
    invoke-direct {p0, p1}, Lrx/internal/util/unsafe/SpmcArrayQueueMidPad;-><init>(I)V

    return-void
.end method


# virtual methods
.method protected final lvProducerIndexCache()J
    .locals 2

    .line 97
    iget-wide v0, p0, Lrx/internal/util/unsafe/SpmcArrayQueueProducerIndexCacheField;->producerIndexCache:J

    return-wide v0
.end method

.method protected final svProducerIndexCache(J)V
    .locals 0

    .line 101
    iput-wide p1, p0, Lrx/internal/util/unsafe/SpmcArrayQueueProducerIndexCacheField;->producerIndexCache:J

    return-void
.end method
