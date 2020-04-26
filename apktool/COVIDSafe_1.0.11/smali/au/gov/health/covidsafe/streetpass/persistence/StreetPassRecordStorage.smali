.class public final Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;
.super Ljava/lang/Object;
.source "StreetPassRecordStorage.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cJ\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0011\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019\u00a8\u0006\u0017"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;",
        "",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)V",
        "getContext",
        "()Landroid/content/Context;",
        "recordDao",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;",
        "deleteDataOlderThan",
        "",
        "timeInMs",
        "",
        "getAllRecords",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "nukeDb",
        "",
        "nukeDbAsync",
        "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
        "saveRecord",
        "record",
        "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
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
.field private final context:Landroid/content/Context;

.field private final recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->context:Landroid/content/Context;

    .line 7
    sget-object p1, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->Companion:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->context:Landroid/content/Context;

    invoke-virtual {p1, v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase$Companion;->getDatabase(Landroid/content/Context;)Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDatabase;->recordDao()Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    return-void
.end method


# virtual methods
.method public final deleteDataOlderThan(J)I
    .locals 1

    .line 14
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    invoke-interface {v0, p1, p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->deleteDataOlder(J)I

    move-result p1

    return p1
.end method

.method public final getAllRecords()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;"
        }
    .end annotation

    .line 26
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    invoke-interface {v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->getCurrentRecords()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public final getContext()Landroid/content/Context;
    .locals 1

    .line 5
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->context:Landroid/content/Context;

    return-object v0
.end method

.method public final nukeDb()V
    .locals 1

    .line 18
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    invoke-interface {v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->nukeDb()V

    return-void
.end method

.method public final nukeDbAsync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 22
    iget-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    invoke-interface {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->nukeDb()V

    .line 23
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final saveRecord(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            "Lkotlin/coroutines/Continuation<",
            "-",
            "Lkotlin/Unit;",
            ">;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .line 10
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->recordDao:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;

    invoke-interface {v0, p1, p2}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordDao;->insert(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;

    move-result-object p1

    invoke-static {}, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;

    move-result-object p2

    if-ne p1, p2, :cond_0

    return-object p1

    .line 11
    :cond_0
    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method
