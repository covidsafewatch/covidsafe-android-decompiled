.class Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl$1;
.super Landroidx/room/EntityInsertionAdapter;
.source "StreetPassRecordDao_Impl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;-><init>(Landroidx/room/RoomDatabase;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/room/EntityInsertionAdapter<",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;Landroidx/room/RoomDatabase;)V
    .locals 0

    .line 38
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl$1;->this$0:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl;

    invoke-direct {p0, p2}, Landroidx/room/EntityInsertionAdapter;-><init>(Landroidx/room/RoomDatabase;)V

    return-void
.end method


# virtual methods
.method public bind(Landroidx/sqlite/db/SupportSQLiteStatement;Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V
    .locals 4

    .line 46
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getId()I

    move-result v0

    int-to-long v0, v0

    const/4 v2, 0x1

    invoke-interface {p1, v2, v0, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    .line 47
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v0

    const/4 v2, 0x2

    invoke-interface {p1, v2, v0, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    .line 48
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getV()I

    move-result v0

    int-to-long v0, v0

    const/4 v2, 0x3

    invoke-interface {p1, v2, v0, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    .line 49
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getMsg()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x4

    if-nez v0, :cond_0

    .line 50
    invoke-interface {p1, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindNull(I)V

    goto :goto_0

    .line 52
    :cond_0
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getMsg()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 54
    :goto_0
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getOrg()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x5

    if-nez v0, :cond_1

    .line 55
    invoke-interface {p1, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindNull(I)V

    goto :goto_1

    .line 57
    :cond_1
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getOrg()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 59
    :goto_1
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelP()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x6

    if-nez v0, :cond_2

    .line 60
    invoke-interface {p1, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindNull(I)V

    goto :goto_2

    .line 62
    :cond_2
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelP()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 64
    :goto_2
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x7

    if-nez v0, :cond_3

    .line 65
    invoke-interface {p1, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindNull(I)V

    goto :goto_3

    .line 67
    :cond_3
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v1, v0}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindString(ILjava/lang/String;)V

    :goto_3
    const/16 v0, 0x8

    .line 69
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getRssi()I

    move-result v1

    int-to-long v1, v1

    invoke-interface {p1, v0, v1, v2}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    .line 70
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTxPower()Ljava/lang/Integer;

    move-result-object v0

    const/16 v1, 0x9

    if-nez v0, :cond_4

    .line 71
    invoke-interface {p1, v1}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindNull(I)V

    goto :goto_4

    .line 73
    :cond_4
    invoke-virtual {p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTxPower()Ljava/lang/Integer;

    move-result-object p2

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    int-to-long v2, p2

    invoke-interface {p1, v1, v2, v3}, Landroidx/sqlite/db/SupportSQLiteStatement;->bindLong(IJ)V

    :goto_4
    return-void
.end method

.method public bridge synthetic bind(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V
    .locals 0

    .line 38
    check-cast p2, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;

    invoke-virtual {p0, p1, p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao_Impl$1;->bind(Landroidx/sqlite/db/SupportSQLiteStatement;Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V

    return-void
.end method

.method public createQuery()Ljava/lang/String;
    .locals 1

    const-string v0, "INSERT OR IGNORE INTO `record_table` (`id`,`timestamp`,`v`,`msg`,`org`,`modelP`,`modelC`,`rssi`,`txPower`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)"

    return-object v0
.end method
