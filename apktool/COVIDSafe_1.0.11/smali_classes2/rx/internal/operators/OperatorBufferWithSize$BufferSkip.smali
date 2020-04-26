.class final Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;
.super Lrx/Subscriber;
.source "OperatorBufferWithSize.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorBufferWithSize;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BufferSkip"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/operators/OperatorBufferWithSize$BufferSkip$BufferSkipProducer;
    }
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
.field final actual:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-",
            "Ljava/util/List<",
            "TT;>;>;"
        }
    .end annotation
.end field

.field buffer:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "TT;>;"
        }
    .end annotation
.end field

.field final count:I

.field index:J

.field final skip:I


# direct methods
.method public constructor <init>(Lrx/Subscriber;II)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-",
            "Ljava/util/List<",
            "TT;>;>;II)V"
        }
    .end annotation

    .line 158
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 159
    iput-object p1, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->actual:Lrx/Subscriber;

    .line 160
    iput p2, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->count:I

    .line 161
    iput p3, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->skip:I

    const-wide/16 p1, 0x0

    .line 162
    invoke-virtual {p0, p1, p2}, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->request(J)V

    return-void
.end method

.method static synthetic access$100(Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;J)V
    .locals 0

    .line 149
    invoke-virtual {p0, p1, p2}, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->request(J)V

    return-void
.end method

.method static synthetic access$200(Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;J)V
    .locals 0

    .line 149
    invoke-virtual {p0, p1, p2}, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->request(J)V

    return-void
.end method


# virtual methods
.method createProducer()Lrx/Producer;
    .locals 1

    .line 207
    new-instance v0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip$BufferSkipProducer;

    invoke-direct {v0, p0}, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip$BufferSkipProducer;-><init>(Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;)V

    return-object v0
.end method

.method public onCompleted()V
    .locals 2

    .line 198
    iget-object v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 200
    iput-object v1, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    .line 201
    iget-object v1, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->actual:Lrx/Subscriber;

    invoke-virtual {v1, v0}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    .line 203
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->actual:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    const/4 v0, 0x0

    .line 192
    iput-object v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    .line 193
    iget-object v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 167
    iget-wide v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->index:J

    .line 168
    iget-object v2, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    const-wide/16 v3, 0x0

    cmp-long v5, v0, v3

    if-nez v5, :cond_0

    .line 170
    new-instance v2, Ljava/util/ArrayList;

    iget v5, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->count:I

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 171
    iput-object v2, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    :cond_0
    const-wide/16 v5, 0x1

    add-long/2addr v0, v5

    .line 174
    iget v5, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->skip:I

    int-to-long v5, v5

    cmp-long v5, v0, v5

    if-nez v5, :cond_1

    .line 175
    iput-wide v3, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->index:J

    goto :goto_0

    .line 177
    :cond_1
    iput-wide v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->index:J

    :goto_0
    if-eqz v2, :cond_2

    .line 181
    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result p1

    iget v0, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->count:I

    if-ne p1, v0, :cond_2

    const/4 p1, 0x0

    .line 184
    iput-object p1, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->buffer:Ljava/util/List;

    .line 185
    iget-object p1, p0, Lrx/internal/operators/OperatorBufferWithSize$BufferSkip;->actual:Lrx/Subscriber;

    invoke-virtual {p1, v2}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    :cond_2
    return-void
.end method
