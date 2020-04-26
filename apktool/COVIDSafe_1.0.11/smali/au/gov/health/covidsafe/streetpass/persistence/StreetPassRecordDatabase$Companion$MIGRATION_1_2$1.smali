.class public final Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;
.super Landroidx/room/migration/Migration;
.source "StreetPassRecordDatabase.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"
    }
    d2 = {
        "au/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1",
        "Landroidx/room/migration/Migration;",
        "migrate",
        "",
        "database",
        "Landroidx/sqlite/db/SupportSQLiteDatabase;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# direct methods
.method constructor <init>(II)V
    .locals 0

    .line 47
    invoke-direct {p0, p1, p2}, Landroidx/room/migration/Migration;-><init>(II)V

    return-void
.end method


# virtual methods
.method public migrate(Landroidx/sqlite/db/SupportSQLiteDatabase;)V
    .locals 3

    const-string v0, "database"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "CREATE TABLE IF NOT EXISTS `status_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `msg` TEXT NOT NULL)"

    .line 50
    invoke-interface {p1, v0}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 52
    sget-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    const-string v1, "record_table"

    const-string v2, "v"

    invoke-virtual {v0, p1, v1, v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;->isFieldExist(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "ALTER TABLE `record_table` ADD COLUMN `v` INTEGER NOT NULL DEFAULT 1"

    .line 53
    invoke-interface {p1, v0}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 56
    :cond_0
    sget-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    const-string v2, "org"

    invoke-virtual {v0, p1, v1, v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;->isFieldExist(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "ALTER TABLE `record_table` ADD COLUMN `org` TEXT NOT NULL DEFAULT \'AU_DTA\'"

    .line 57
    invoke-interface {p1, v0}, Landroidx/sqlite/db/SupportSQLiteDatabase;->execSQL(Ljava/lang/String;)V

    :cond_1
    return-void
.end method
