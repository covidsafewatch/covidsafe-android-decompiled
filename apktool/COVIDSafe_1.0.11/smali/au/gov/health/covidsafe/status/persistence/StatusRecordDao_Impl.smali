.class public final Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;
.super Ljava/lang/Object;
.source "StatusRecordDao_Impl.java"

# interfaces
.implements Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;


# instance fields
.field private final __db:Landroidx/room/RoomDatabase;

.field private final __insertionAdapterOfStatusRecord:Landroidx/room/EntityInsertionAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/room/EntityInsertionAdapter<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;"
        }
    .end annotation
.end field

.field private final __preparedStmtOfDeleteDataOlder:Landroidx/room/SharedSQLiteStatement;

.field private final __preparedStmtOfNukeDb:Landroidx/room/SharedSQLiteStatement;


# direct methods
.method public constructor <init>(Landroidx/room/RoomDatabase;)V
    .locals 1

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    .line 37
    new-instance v0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$1;

    invoke-direct {v0, p0, p1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$1;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Landroidx/room/RoomDatabase;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__insertionAdapterOfStatusRecord:Landroidx/room/EntityInsertionAdapter;

    .line 54
    new-instance v0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$2;

    invoke-direct {v0, p0, p1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$2;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Landroidx/room/RoomDatabase;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfDeleteDataOlder:Landroidx/room/SharedSQLiteStatement;

    .line 61
    new-instance v0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$3;

    invoke-direct {v0, p0, p1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$3;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Landroidx/room/RoomDatabase;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfNukeDb:Landroidx/room/SharedSQLiteStatement;

    return-void
.end method

.method private __entityCursorConverter_auGovHealthCovidsafeStatusPersistenceStatusRecord(Landroid/database/Cursor;)Lau/gov/health/covidsafe/status/persistence/StatusRecord;
    .locals 5

    const-string v0, "id"

    .line 253
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    const-string v1, "timestamp"

    .line 254
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    const-string v2, "msg"

    .line 255
    invoke-interface {p1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    .line 260
    :cond_0
    invoke-interface {p1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 262
    :goto_0
    new-instance v4, Lau/gov/health/covidsafe/status/persistence/StatusRecord;

    invoke-direct {v4, v2}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;-><init>(Ljava/lang/String;)V

    if-eq v0, v3, :cond_1

    .line 265
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 266
    invoke-virtual {v4, v0}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;->setId(I)V

    :cond_1
    if-eq v1, v3, :cond_2

    .line 270
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 271
    invoke-virtual {v4, v0, v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;->setTimestamp(J)V

    :cond_2
    return-object v4
.end method

.method static synthetic access$000(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/RoomDatabase;
    .locals 0

    .line 26
    iget-object p0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    return-object p0
.end method

.method static synthetic access$100(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/EntityInsertionAdapter;
    .locals 0

    .line 26
    iget-object p0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__insertionAdapterOfStatusRecord:Landroidx/room/EntityInsertionAdapter;

    return-object p0
.end method


# virtual methods
.method public deleteDataOlder(J)I
    .locals 2

    .line 89
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v0}, Landroidx/room/RoomDatabase;->assertNotSuspendingTransaction()V

    .line 90
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfDeleteDataOlder:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {v0}, Landroidx/room/SharedSQLiteStatement;->acquire()Landroidx/sqlite/db/SupportSQLiteStatement;

    move-result-object v0

    const/4 v1, 0x1

    .line 92
    invoke-interface {v0, v1, p1, p2}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    .line 93
    iget-object p1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {p1}, Landroidx/room/RoomDatabase;->beginTransaction()V

    .line 95
    :try_start_0
    invoke-interface {v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->executeUpdateDelete()I

    move-result p1

    .line 96
    iget-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {p2}, Landroidx/room/RoomDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 99
    iget-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {p2}, Landroidx/room/RoomDatabase;->endTransaction()V

    .line 100
    iget-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfDeleteDataOlder:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {p2, v0}, Landroidx/room/SharedSQLiteStatement;->release(Landroidx/sqlite/db/SupportSQLiteStatement;)V

    return p1

    :catchall_0
    move-exception p1

    .line 99
    iget-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {p2}, Landroidx/room/RoomDatabase;->endTransaction()V

    .line 100
    iget-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfDeleteDataOlder:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {p2, v0}, Landroidx/room/SharedSQLiteStatement;->release(Landroidx/sqlite/db/SupportSQLiteStatement;)V

    .line 101
    throw p1
.end method

.method public getCurrentRecords()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    const-string v1, "SELECT * from status_table ORDER BY timestamp ASC"

    .line 160
    invoke-static {v1, v0}, Landroidx/room/RoomSQLiteQuery;->acquire(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;

    move-result-object v1

    .line 161
    iget-object v2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v2}, Landroidx/room/RoomDatabase;->assertNotSuspendingTransaction()V

    .line 162
    iget-object v2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    const/4 v3, 0x0

    invoke-static {v2, v1, v0, v3}, Landroidx/room/util/DBUtil;->query(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;

    move-result-object v0

    :try_start_0
    const-string v2, "id"

    .line 164
    invoke-static {v0, v2}, Landroidx/room/util/CursorUtil;->getColumnIndexOrThrow(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v2

    const-string v3, "timestamp"

    .line 165
    invoke-static {v0, v3}, Landroidx/room/util/CursorUtil;->getColumnIndexOrThrow(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v3

    const-string v4, "msg"

    .line 166
    invoke-static {v0, v4}, Landroidx/room/util/CursorUtil;->getColumnIndexOrThrow(Landroid/database/Cursor;Ljava/lang/String;)I

    move-result v4

    .line 167
    new-instance v5, Ljava/util/ArrayList;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v6

    invoke-direct {v5, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 168
    :goto_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v6

    if-eqz v6, :cond_0

    .line 171
    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 172
    new-instance v7, Lau/gov/health/covidsafe/status/persistence/StatusRecord;

    invoke-direct {v7, v6}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;-><init>(Ljava/lang/String;)V

    .line 174
    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    .line 175
    invoke-virtual {v7, v6}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;->setId(I)V

    .line 177
    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    .line 178
    invoke-virtual {v7, v8, v9}, Lau/gov/health/covidsafe/status/persistence/StatusRecord;->setTimestamp(J)V

    .line 179
    invoke-interface {v5, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 183
    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 184
    invoke-virtual {v1}, Landroidx/room/RoomSQLiteQuery;->release()V

    return-object v5

    :catchall_0
    move-exception v2

    .line 183
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 184
    invoke-virtual {v1}, Landroidx/room/RoomSQLiteQuery;->release()V

    .line 185
    throw v2
.end method

.method public getMostRecentRecord(Ljava/lang/String;)Landroidx/lifecycle/LiveData;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Landroidx/lifecycle/LiveData<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x1

    const-string v1, "SELECT * from status_table where msg = ? ORDER BY timestamp DESC LIMIT 1"

    .line 191
    invoke-static {v1, v0}, Landroidx/room/RoomSQLiteQuery;->acquire(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;

    move-result-object v1

    if-nez p1, :cond_0

    .line 194
    invoke-virtual {v1, v0}, Landroidx/room/RoomSQLiteQuery;->bindNull(I)V

    goto :goto_0

    .line 196
    :cond_0
    invoke-virtual {v1, v0, p1}, Landroidx/room/RoomSQLiteQuery;->bindString(ILjava/lang/String;)V

    .line 198
    :goto_0
    iget-object p1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {p1}, Landroidx/room/RoomDatabase;->getInvalidationTracker()Landroidx/room/InvalidationTracker;

    move-result-object p1

    const-string v0, "status_table"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    new-instance v3, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$6;

    invoke-direct {v3, p0, v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$6;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Landroidx/room/RoomSQLiteQuery;)V

    invoke-virtual {p1, v0, v2, v3}, Landroidx/room/InvalidationTracker;->createLiveData([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;

    move-result-object p1

    return-object p1
.end method

.method public getRecords()Landroidx/lifecycle/LiveData;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;>;"
        }
    .end annotation

    const/4 v0, 0x0

    const-string v1, "SELECT * from status_table ORDER BY timestamp ASC"

    .line 121
    invoke-static {v1, v0}, Landroidx/room/RoomSQLiteQuery;->acquire(Ljava/lang/String;I)Landroidx/room/RoomSQLiteQuery;

    move-result-object v1

    .line 122
    iget-object v2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v2}, Landroidx/room/RoomDatabase;->getInvalidationTracker()Landroidx/room/InvalidationTracker;

    move-result-object v2

    const-string v3, "status_table"

    filled-new-array {v3}, [Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$5;

    invoke-direct {v4, p0, v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$5;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Landroidx/room/RoomSQLiteQuery;)V

    invoke-virtual {v2, v3, v0, v4}, Landroidx/room/InvalidationTracker;->createLiveData([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;

    move-result-object v0

    return-object v0
.end method

.method public getRecordsViaQuery(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/sqlite/db/SupportSQLiteQuery;",
            ")",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            ">;"
        }
    .end annotation

    .line 236
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v0}, Landroidx/room/RoomDatabase;->assertNotSuspendingTransaction()V

    .line 237
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v0, p1, v1, v2}, Landroidx/room/util/DBUtil;->query(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;

    move-result-object p1

    .line 239
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 240
    :goto_0
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 242
    invoke-direct {p0, p1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__entityCursorConverter_auGovHealthCovidsafeStatusPersistenceStatusRecord(Landroid/database/Cursor;)Lau/gov/health/covidsafe/status/persistence/StatusRecord;

    move-result-object v1

    .line 243
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 247
    :cond_0
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    return-object v0

    :catchall_0
    move-exception v0

    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 248
    throw v0
.end method

.method public insert(Lau/gov/health/covidsafe/status/persistence/StatusRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/status/persistence/StatusRecord;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 72
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    new-instance v1, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;

    invoke-direct {v1, p0, p1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;-><init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Lau/gov/health/covidsafe/status/persistence/StatusRecord;)V

    const/4 p1, 0x1

    invoke-static {v0, p1, v1, p2}, Landroidx/room/CoroutinesRoom;->execute(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public nukeDb()V
    .locals 3

    .line 106
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v0}, Landroidx/room/RoomDatabase;->assertNotSuspendingTransaction()V

    .line 107
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfNukeDb:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {v0}, Landroidx/room/SharedSQLiteStatement;->acquire()Landroidx/sqlite/db/SupportSQLiteStatement;

    move-result-object v0

    .line 108
    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v1}, Landroidx/room/RoomDatabase;->beginTransaction()V

    .line 110
    :try_start_0
    invoke-interface {v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->executeUpdateDelete()I

    .line 111
    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v1}, Landroidx/room/RoomDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v1}, Landroidx/room/RoomDatabase;->endTransaction()V

    .line 114
    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfNukeDb:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {v1, v0}, Landroidx/room/SharedSQLiteStatement;->release(Landroidx/sqlite/db/SupportSQLiteStatement;)V

    return-void

    :catchall_0
    move-exception v1

    .line 113
    iget-object v2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__db:Landroidx/room/RoomDatabase;

    invoke-virtual {v2}, Landroidx/room/RoomDatabase;->endTransaction()V

    .line 114
    iget-object v2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->__preparedStmtOfNukeDb:Landroidx/room/SharedSQLiteStatement;

    invoke-virtual {v2, v0}, Landroidx/room/SharedSQLiteStatement;->release(Landroidx/sqlite/db/SupportSQLiteStatement;)V

    .line 115
    throw v1
.end method
