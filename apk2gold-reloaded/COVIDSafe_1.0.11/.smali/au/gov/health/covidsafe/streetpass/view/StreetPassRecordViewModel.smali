.class public final Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;
.super Ljava/lang/Object;
.source "StreetPassRecordViewModel.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\t\n\u0002\u0008\t\u0018\u00002\u00020\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0011\u00a8\u0006 "
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;",
        "",
        "record",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V",
        "number",
        "",
        "(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V",
        "modelC",
        "",
        "getModelC",
        "()Ljava/lang/String;",
        "modelP",
        "getModelP",
        "msg",
        "getMsg",
        "getNumber",
        "()I",
        "org",
        "getOrg",
        "rssi",
        "getRssi",
        "timeStamp",
        "",
        "getTimeStamp",
        "()J",
        "transmissionPower",
        "getTransmissionPower",
        "()Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "version",
        "getVersion",
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
.field private final modelC:Ljava/lang/String;

.field private final modelP:Ljava/lang/String;

.field private final msg:Ljava/lang/String;

.field private final number:I

.field private final org:Ljava/lang/String;

.field private final rssi:I

.field private final timeStamp:J

.field private final transmissionPower:Ljava/lang/Integer;

.field private final version:I


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;)V
    .locals 1

    const-string v0, "record"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x1

    .line 15
    invoke-direct {p0, p1, v0}, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;-><init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V

    return-void
.end method

.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;I)V
    .locals 2

    const-string v0, "record"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->number:I

    .line 6
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getV()I

    move-result p2

    iput p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->version:I

    .line 7
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelC()Ljava/lang/String;

    move-result-object p2

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->modelC:Ljava/lang/String;

    .line 8
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getModelP()Ljava/lang/String;

    move-result-object p2

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->modelP:Ljava/lang/String;

    .line 9
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getMsg()Ljava/lang/String;

    move-result-object p2

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->msg:Ljava/lang/String;

    .line 10
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTimestamp()J

    move-result-wide v0

    iput-wide v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->timeStamp:J

    .line 11
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getRssi()I

    move-result p2

    iput p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->rssi:I

    .line 12
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getTxPower()Ljava/lang/Integer;

    move-result-object p2

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->transmissionPower:Ljava/lang/Integer;

    .line 13
    invoke-virtual {p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->getOrg()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->org:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final getModelC()Ljava/lang/String;
    .locals 1

    .line 7
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->modelC:Ljava/lang/String;

    return-object v0
.end method

.method public final getModelP()Ljava/lang/String;
    .locals 1

    .line 8
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->modelP:Ljava/lang/String;

    return-object v0
.end method

.method public final getMsg()Ljava/lang/String;
    .locals 1

    .line 9
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public final getNumber()I
    .locals 1

    .line 5
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->number:I

    return v0
.end method

.method public final getOrg()Ljava/lang/String;
    .locals 1

    .line 13
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->org:Ljava/lang/String;

    return-object v0
.end method

.method public final getRssi()I
    .locals 1

    .line 11
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->rssi:I

    return v0
.end method

.method public final getTimeStamp()J
    .locals 2

    .line 10
    iget-wide v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->timeStamp:J

    return-wide v0
.end method

.method public final getTransmissionPower()Ljava/lang/Integer;
    .locals 1

    .line 12
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->transmissionPower:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getVersion()I
    .locals 1

    .line 6
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;->version:I

    return v0
.end method
