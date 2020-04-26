.class Lrx/internal/operators/CachedObservable$CacheState$1;
.super Lrx/Subscriber;
.source "CachedObservable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/CachedObservable$CacheState;->connect()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrx/Subscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/CachedObservable$CacheState;


# direct methods
.method constructor <init>(Lrx/internal/operators/CachedObservable$CacheState;)V
    .locals 0

    .line 168
    iput-object p1, p0, Lrx/internal/operators/CachedObservable$CacheState$1;->this$0:Lrx/internal/operators/CachedObservable$CacheState;

    invoke-direct {p0}, Lrx/Subscriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 179
    iget-object v0, p0, Lrx/internal/operators/CachedObservable$CacheState$1;->this$0:Lrx/internal/operators/CachedObservable$CacheState;

    invoke-virtual {v0}, Lrx/internal/operators/CachedObservable$CacheState;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 175
    iget-object v0, p0, Lrx/internal/operators/CachedObservable$CacheState$1;->this$0:Lrx/internal/operators/CachedObservable$CacheState;

    invoke-virtual {v0, p1}, Lrx/internal/operators/CachedObservable$CacheState;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 171
    iget-object v0, p0, Lrx/internal/operators/CachedObservable$CacheState$1;->this$0:Lrx/internal/operators/CachedObservable$CacheState;

    invoke-virtual {v0, p1}, Lrx/internal/operators/CachedObservable$CacheState;->onNext(Ljava/lang/Object;)V

    return-void
.end method
