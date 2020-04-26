.class public final Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;
.super Ljava/lang/Object;
.source "StreetPassRecordRepository.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\u00a8\u0006\u000b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;",
        "",
        "recordDao",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;",
        "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;)V",
        "allRecords",
        "Landroidx/lifecycle/LiveData;",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "getAllRecords",
        "()Landroidx/lifecycle/LiveData;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private final allRecords:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;)V
    .locals 1

    const-string v0, "recordDao"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    invoke-interface {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->getRecords()Landroidx/lifecycle/LiveData;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;->allRecords:Landroidx/lifecycle/LiveData;

    return-void
.end method


# virtual methods
.method public final getAllRecords()Landroidx/lifecycle/LiveData;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;>;"
        }
    .end annotation

    .line 8
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;->allRecords:Landroidx/lifecycle/LiveData;

    return-object v0
.end method
