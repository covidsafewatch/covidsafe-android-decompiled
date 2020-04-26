.class final Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;
.super Lrx/Subscriber;
.source "OperatorWithLatestFromMany.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorWithLatestFromMany;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "WithLatestMainSubscriber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# static fields
.field static final EMPTY:Ljava/lang/Object;


# instance fields
.field final actual:Lrx/Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Subscriber<",
            "-TR;>;"
        }
    .end annotation
.end field

.field final combiner:Lrx/functions/FuncN;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/FuncN<",
            "TR;>;"
        }
    .end annotation
.end field

.field final current:Ljava/util/concurrent/atomic/AtomicReferenceArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReferenceArray<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field done:Z

.field final ready:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 92
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->EMPTY:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Lrx/Subscriber;Lrx/functions/FuncN;I)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TR;>;",
            "Lrx/functions/FuncN<",
            "TR;>;I)V"
        }
    .end annotation

    .line 98
    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    .line 99
    iput-object p1, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->actual:Lrx/Subscriber;

    .line 100
    iput-object p2, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->combiner:Lrx/functions/FuncN;

    .line 102
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReferenceArray;

    add-int/lit8 p2, p3, 0x1

    invoke-direct {p1, p2}, Ljava/util/concurrent/atomic/AtomicReferenceArray;-><init>(I)V

    const/4 p2, 0x0

    :goto_0
    if-gt p2, p3, :cond_0

    .line 104
    sget-object v0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->EMPTY:Ljava/lang/Object;

    invoke-virtual {p1, p2, v0}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->lazySet(ILjava/lang/Object;)V

    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    .line 106
    :cond_0
    iput-object p1, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->current:Ljava/util/concurrent/atomic/AtomicReferenceArray;

    .line 108
    new-instance p1, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {p1, p3}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object p1, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->ready:Ljava/util/concurrent/atomic/AtomicInteger;

    const-wide/16 p1, 0x0

    .line 109
    invoke-virtual {p0, p1, p2}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->request(J)V

    return-void
.end method


# virtual methods
.method innerComplete(I)V
    .locals 1

    .line 183
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->current:Ljava/util/concurrent/atomic/AtomicReferenceArray;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->get(I)Ljava/lang/Object;

    move-result-object p1

    sget-object v0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->EMPTY:Ljava/lang/Object;

    if-ne p1, v0, :cond_0

    .line 184
    invoke-virtual {p0}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->onCompleted()V

    :cond_0
    return-void
.end method

.method innerError(ILjava/lang/Throwable;)V
    .locals 0

    .line 179
    invoke-virtual {p0, p2}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method innerNext(ILjava/lang/Object;)V
    .locals 1

    .line 172
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->current:Ljava/util/concurrent/atomic/AtomicReferenceArray;

    invoke-virtual {v0, p1, p2}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->getAndSet(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    .line 173
    sget-object p2, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->EMPTY:Ljava/lang/Object;

    if-ne p1, p2, :cond_0

    .line 174
    iget-object p1, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->ready:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    :cond_0
    return-void
.end method

.method public onCompleted()V
    .locals 1

    .line 157
    iget-boolean v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x1

    .line 160
    iput-boolean v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->done:Z

    .line 161
    invoke-virtual {p0}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->unsubscribe()V

    .line 162
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 146
    iget-boolean v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->done:Z

    if-eqz v0, :cond_0

    .line 147
    invoke-static {p1}, Lrx/plugins/RxJavaHooks;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_0
    const/4 v0, 0x1

    .line 150
    iput-boolean v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->done:Z

    .line 151
    invoke-virtual {p0}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->unsubscribe()V

    .line 152
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 114
    iget-boolean v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->done:Z

    if-eqz v0, :cond_0

    return-void

    .line 117
    :cond_0
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->ready:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    if-nez v0, :cond_2

    .line 119
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->current:Ljava/util/concurrent/atomic/AtomicReferenceArray;

    .line 120
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->length()I

    move-result v1

    const/4 v2, 0x0

    .line 121
    invoke-virtual {v0, v2, p1}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->lazySet(ILjava/lang/Object;)V

    .line 123
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->length()I

    move-result p1

    new-array p1, p1, [Ljava/lang/Object;

    :goto_0
    if-ge v2, v1, :cond_1

    .line 125
    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicReferenceArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, p1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 131
    :cond_1
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->combiner:Lrx/functions/FuncN;

    invoke-interface {v0, p1}, Lrx/functions/FuncN;->call([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 138
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    goto :goto_1

    :catchall_0
    move-exception p1

    .line 133
    invoke-static {p1}, Lrx/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 134
    invoke-virtual {p0, p1}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    :cond_2
    const-wide/16 v0, 0x1

    .line 140
    invoke-virtual {p0, v0, v1}, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->request(J)V

    :goto_1
    return-void
.end method

.method public setProducer(Lrx/Producer;)V
    .locals 1

    .line 167
    invoke-super {p0, p1}, Lrx/Subscriber;->setProducer(Lrx/Producer;)V

    .line 168
    iget-object v0, p0, Lrx/internal/operators/OperatorWithLatestFromMany$WithLatestMainSubscriber;->actual:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->setProducer(Lrx/Producer;)V

    return-void
.end method
