.class public final Lrx/internal/util/BackpressureDrainManager;
.super Ljava/util/concurrent/atomic/AtomicLong;
.source "BackpressureDrainManager.java"

# interfaces
.implements Lrx/Producer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;
    }
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x2738d34f11cd4869L


# instance fields
.field final actual:Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;

.field emitting:Z

.field exception:Ljava/lang/Throwable;

.field volatile terminated:Z


# direct methods
.method public constructor <init>(Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;)V
    .locals 0

    .line 80
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    .line 81
    iput-object p1, p0, Lrx/internal/util/BackpressureDrainManager;->actual:Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;

    return-void
.end method


# virtual methods
.method public drain()V
    .locals 13

    .line 167
    monitor-enter p0

    .line 168
    :try_start_0
    iget-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->emitting:Z

    if-eqz v0, :cond_0

    .line 169
    monitor-exit p0

    return-void

    :cond_0
    const/4 v0, 0x1

    .line 171
    iput-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->emitting:Z

    .line 172
    iget-boolean v1, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    .line 173
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_5

    .line 174
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->get()J

    move-result-wide v2

    const/4 v4, 0x0

    .line 177
    :try_start_1
    iget-object v5, p0, Lrx/internal/util/BackpressureDrainManager;->actual:Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;

    :goto_0
    move v6, v4

    :goto_1
    const-wide/16 v7, 0x0

    cmp-long v9, v2, v7

    if-gtz v9, :cond_1

    if-eqz v1, :cond_4

    :cond_1
    if-eqz v1, :cond_3

    .line 183
    invoke-interface {v5}, Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;->peek()Ljava/lang/Object;

    move-result-object v10
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    if-nez v10, :cond_2

    .line 186
    :try_start_2
    iget-object v1, p0, Lrx/internal/util/BackpressureDrainManager;->exception:Ljava/lang/Throwable;

    .line 187
    invoke-interface {v5, v1}, Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;->complete(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    return-void

    :catchall_0
    move-exception v1

    goto/16 :goto_7

    :cond_2
    if-nez v9, :cond_3

    goto :goto_2

    .line 194
    :cond_3
    :try_start_3
    invoke-interface {v5}, Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;->poll()Ljava/lang/Object;

    move-result-object v9

    if-nez v9, :cond_b

    .line 206
    :cond_4
    :goto_2
    monitor-enter p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_3

    .line 207
    :try_start_4
    iget-boolean v1, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    .line 208
    invoke-interface {v5}, Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;->peek()Ljava/lang/Object;

    move-result-object v2

    if-eqz v2, :cond_5

    move v2, v0

    goto :goto_3

    :cond_5
    move v2, v4

    .line 210
    :goto_3
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->get()J

    move-result-wide v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    const-wide v11, 0x7fffffffffffffffL

    cmp-long v3, v9, v11

    if-nez v3, :cond_7

    if-nez v2, :cond_6

    if-nez v1, :cond_6

    .line 214
    :try_start_5
    iput-boolean v4, p0, Lrx/internal/util/BackpressureDrainManager;->emitting:Z

    .line 215
    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    return-void

    :cond_6
    move-wide v2, v11

    goto :goto_4

    :cond_7
    neg-int v3, v6

    int-to-long v9, v3

    .line 219
    :try_start_6
    invoke-virtual {p0, v9, v10}, Lrx/internal/util/BackpressureDrainManager;->addAndGet(J)J

    move-result-wide v9

    cmp-long v3, v9, v7

    if-eqz v3, :cond_8

    if-nez v2, :cond_9

    :cond_8
    if-eqz v1, :cond_a

    if-eqz v2, :cond_9

    goto :goto_5

    :cond_9
    move-wide v2, v9

    .line 226
    :goto_4
    monitor-exit p0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    goto :goto_0

    .line 222
    :cond_a
    :goto_5
    :try_start_7
    iput-boolean v4, p0, Lrx/internal/util/BackpressureDrainManager;->emitting:Z

    .line 223
    monitor-exit p0

    return-void

    :catchall_1
    move-exception v1

    move v0, v4

    .line 226
    :goto_6
    monitor-exit p0
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    :try_start_8
    throw v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    :catchall_2
    move-exception v1

    goto :goto_6

    .line 198
    :cond_b
    :try_start_9
    invoke-interface {v5, v9}, Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;->accept(Ljava/lang/Object;)Z

    move-result v7
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    if-eqz v7, :cond_c

    return-void

    :cond_c
    const-wide/16 v7, 0x1

    sub-long/2addr v2, v7

    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    :catchall_3
    move-exception v1

    move v0, v4

    :goto_7
    if-nez v0, :cond_d

    .line 230
    monitor-enter p0

    .line 231
    :try_start_a
    iput-boolean v4, p0, Lrx/internal/util/BackpressureDrainManager;->emitting:Z

    .line 232
    monitor-exit p0

    goto :goto_8

    :catchall_4
    move-exception v0

    monitor-exit p0
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_4

    throw v0

    :cond_d
    :goto_8
    throw v1

    :catchall_5
    move-exception v0

    .line 173
    :try_start_b
    monitor-exit p0
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_5

    throw v0
.end method

.method public isTerminated()Z
    .locals 1

    .line 88
    iget-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    return v0
.end method

.method public request(J)V
    .locals 10

    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-nez v2, :cond_0

    return-void

    .line 139
    :cond_0
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->get()J

    move-result-wide v2

    cmp-long v4, v2, v0

    const/4 v5, 0x1

    if-nez v4, :cond_1

    move v4, v5

    goto :goto_0

    :cond_1
    const/4 v4, 0x0

    :goto_0
    const-wide v6, 0x7fffffffffffffffL

    cmp-long v8, v2, v6

    if-nez v8, :cond_2

    goto :goto_3

    :cond_2
    cmp-long v8, p1, v6

    if-nez v8, :cond_3

    move-wide v6, p1

    goto :goto_2

    :cond_3
    sub-long v8, v6, p1

    cmp-long v5, v2, v8

    if-lez v5, :cond_4

    goto :goto_1

    :cond_4
    add-long v6, v2, p1

    :goto_1
    move v5, v4

    .line 154
    :goto_2
    invoke-virtual {p0, v2, v3, v6, v7}, Lrx/internal/util/BackpressureDrainManager;->compareAndSet(JJ)Z

    move-result v2

    if-eqz v2, :cond_0

    move v4, v5

    :goto_3
    if-eqz v4, :cond_5

    .line 158
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->drain()V

    :cond_5
    return-void
.end method

.method public terminate()V
    .locals 1

    const/4 v0, 0x1

    .line 95
    iput-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    return-void
.end method

.method public terminate(Ljava/lang/Throwable;)V
    .locals 1

    .line 105
    iget-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    if-nez v0, :cond_0

    .line 106
    iput-object p1, p0, Lrx/internal/util/BackpressureDrainManager;->exception:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 107
    iput-boolean p1, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    :cond_0
    return-void
.end method

.method public terminateAndDrain()V
    .locals 1

    const/4 v0, 0x1

    .line 114
    iput-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    .line 115
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->drain()V

    return-void
.end method

.method public terminateAndDrain(Ljava/lang/Throwable;)V
    .locals 1

    .line 124
    iget-boolean v0, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    if-nez v0, :cond_0

    .line 125
    iput-object p1, p0, Lrx/internal/util/BackpressureDrainManager;->exception:Ljava/lang/Throwable;

    const/4 p1, 0x1

    .line 126
    iput-boolean p1, p0, Lrx/internal/util/BackpressureDrainManager;->terminated:Z

    .line 127
    invoke-virtual {p0}, Lrx/internal/util/BackpressureDrainManager;->drain()V

    :cond_0
    return-void
.end method
