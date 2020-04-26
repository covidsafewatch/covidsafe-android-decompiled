.class public abstract Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;
.super Landroidx/room/RoomDatabase;
.source "StreetPassRecordDatabase.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0008\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0008"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;",
        "Landroidx/room/RoomDatabase;",
        "()V",
        "recordDao",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;",
        "statusDao",
        "Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;",
        "Companion",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

.field private static volatile INSTANCE:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;

.field private static final MIGRATION_1_2:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    .line 47
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;

    const/4 v1, 0x1

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;-><init>(II)V

    sput-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->MIGRATION_1_2:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Landroidx/room/RoomDatabase;-><init>()V

    return-void
.end method

.method public static final synthetic access$getINSTANCE$cp()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;
    .locals 1

    .line 18
    sget-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->INSTANCE:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;

    return-object v0
.end method

.method public static final synthetic access$getMIGRATION_1_2$cp()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;
    .locals 1

    .line 18
    sget-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->MIGRATION_1_2:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion$MIGRATION_1_2$1;

    return-object v0
.end method

.method public static final synthetic access$setINSTANCE$cp(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;)V
    .locals 0

    .line 18
    sput-object p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->INSTANCE:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;

    return-void
.end method


# virtual methods
.method public abstract recordDao()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;
.end method

.method public abstract statusDao()Lau/gov/health/covidsafe/status/persistence/StatusRecordDao;
.end method
