.class public final Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;
.super Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;
.source "StreetPassRecordDatabase_Impl.java"


# instance fields
.field private volatile _statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

.field private volatile _streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27
    invoke-direct {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$100(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$1000(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$200(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$300(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$400(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$500(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$602(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;Landroidx/sqlite/db/SupportSQLiteDatabase;)Landroidx/sqlite/db/SupportSQLiteDatabase;
    .locals 0

    .line 27
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mDatabase:Landroidx/sqlite/db/SupportSQLiteDatabase;

    return-object p1
.end method

.method static synthetic access$700(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;Landroidx/sqlite/db/SupportSQLiteDatabase;)V
    .locals 0

    .line 27
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->internalInitInvalidationTracker(Landroidx/sqlite/db/SupportSQLiteDatabase;)V

    return-void
.end method

.method static synthetic access$800(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$900(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;)Ljava/util/List;
    .locals 0

    .line 27
    iget-object p0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->mCallbacks:Ljava/util/List;

    return-object p0
.end method


# virtual methods
.method public clearAllTables()V
    .locals 4

    const-string v0, "VACUUM"

    const-string v1, "PRAGMA wal_checkpoint(FULL)"

    .line 137
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->assertNotMainThread()V

    .line 138
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->getOpenHelper()Landroidx/sqlite/db/SupportSQLiteOpenHelper;

    move-result-object v2

    invoke-interface {v2}, Landroidx/sqlite/db/SupportSQLiteOpenHelper;->getWritableDatabase()Landroidx/sqlite/db/SupportSQLiteDatabase;

    move-result-object v2

    .line 140
    :try_start_0
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->beginTransaction()V

    const-string v3, "DELETE FROM `record_table`"

    .line 141
    invoke-interface {v2, v3}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    const-string v3, "DELETE FROM `status_table`"

    .line 142
    invoke-interface {v2, v3}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 143
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 145
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->endTransaction()V

    .line 146
    invoke-interface {v2, v1}, Landroidx/sqlite/db/SupportSQLiteDatabase;->query(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 147
    invoke-interface {v2}, Landroidx/sqlite/db/SupportSQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_0

    .line 148
    invoke-interface {v2, v0}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    :cond_0
    return-void

    :catchall_0
    move-exception v3

    .line 145
    invoke-super {p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->endTransaction()V

    .line 146
    invoke-interface {v2, v1}, Landroidx/sqlite/db/SupportSQLiteDatabase;->query(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 147
    invoke-interface {v2}, Landroidx/sqlite/db/SupportSQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_1

    .line 148
    invoke-interface {v2, v0}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 150
    :cond_1
    throw v3
.end method

.method protected createInvalidationTracker()Landroidx/room/InvalidationTracker;
    .locals 5

    .line 130
    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 131
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2, v1}, Ljava/util/HashMap;-><init>(I)V

    .line 132
    new-instance v1, Landroidx/room/InvalidationTracker;

    const-string v3, "record_table"

    const-string v4, "status_table"

    filled-new-array {v3, v4}, [Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, p0, v0, v2, v3}, Landroidx/room/InvalidationTracker;-><init>(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V

    return-object v1
.end method

.method protected createOpenHelper(Landroidx/room/DatabaseConfiguration;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;
    .locals 4

    .line 34
    new-instance v0, Landroidx/room/RoomOpenHelper;

    new-instance v1, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl$1;

    const/4 v2, 0x2

    invoke-direct {v1, p0, v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl$1;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;I)V

    const-string v2, "9a95fc8ad88c160bf76c0ba4747db316"

    const-string v3, "336ef522c4c1738f91b0cd0ef01687c8"

    invoke-direct {v0, p1, v1, v2, v3}, Landroidx/room/RoomOpenHelper;-><init>(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    iget-object v1, p1, Landroidx/room/DatabaseConfiguration;->context:Landroid/content/Context;

    invoke-static {v1}, Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;->builder(Landroid/content/Context;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;

    move-result-object v1

    iget-object v2, p1, Landroidx/room/DatabaseConfiguration;->name:Ljava/lang/String;

    .line 121
    invoke-virtual {v1, v2}, Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;->name(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;

    move-result-object v1

    .line 122
    invoke-virtual {v1, v0}, Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;->callback(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;

    move-result-object v0

    .line 123
    invoke-virtual {v0}, Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;->build()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;

    move-result-object v0

    .line 124
    iget-object p1, p1, Landroidx/room/DatabaseConfiguration;->sqliteOpenHelperFactory:Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;

    invoke-interface {p1, v0}, Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;->create(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;

    move-result-object p1

    return-object p1
.end method

.method public recordDao()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;
    .locals 1

    .line 155
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    return-object v0

    .line 158
    :cond_0
    monitor-enter p0

    .line 159
    :try_start_0
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    if-nez v0, :cond_1

    .line 160
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;-><init>(Landroidx/room/RoomDatabase;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    .line 162
    :cond_1
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_streetPassRecordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    .line 163
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public statusDao()Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;
    .locals 1

    .line 169
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

    return-object v0

    .line 172
    :cond_0
    monitor-enter p0

    .line 173
    :try_start_0
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

    if-nez v0, :cond_1

    .line 174
    new-instance v0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-direct {v0, p0}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;-><init>(Landroidx/room/RoomDatabase;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

    .line 176
    :cond_1
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase_Impl;->_statusRecordDao:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    .line 177
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
