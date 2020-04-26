.class public final Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "RecordViewModel.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R&\u0010\u0005\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;",
        "Landroidx/lifecycle/AndroidViewModel;",
        "app",
        "Landroid/app/Application;",
        "(Landroid/app/Application;)V",
        "allRecords",
        "Landroidx/lifecycle/LiveData;",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "getAllRecords",
        "()Landroidx/lifecycle/LiveData;",
        "setAllRecords",
        "(Landroidx/lifecycle/LiveData;)V",
        "repo",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;",
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
.field private allRecords:Landroidx/lifecycle/LiveData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/lifecycle/LiveData<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;>;"
        }
    .end annotation
.end field

.field private repo:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;


# direct methods
.method public constructor <init>(Landroid/app/Application;)V
    .locals 1

    const-string v0, "app"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    invoke-direct {p0, p1}, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V

    .line 17
    sget-object v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    check-cast p1, Landroid/content/Context;

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;->getDatabase(Landroid/content/Context;)Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->recordDao()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    move-result-object p1

    .line 18
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;->repo:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;

    .line 19
    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordRepository;->getAllRecords()Landroidx/lifecycle/LiveData;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;->allRecords:Landroidx/lifecycle/LiveData;

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

    .line 14
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;->allRecords:Landroidx/lifecycle/LiveData;

    return-object v0
.end method

.method public final setAllRecords(Landroidx/lifecycle/LiveData;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/lifecycle/LiveData<",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;>;)V"
        }
    .end annotation

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;->allRecords:Landroidx/lifecycle/LiveData;

    return-void
.end method
