.class public final Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;
.super Ljava/lang/Object;
.source "StreetPassRecord.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\t\n\u0002\u0008\u000b\u0008\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0008\u0010%\u001a\u00020\u0005H\u0016R\u001e\u0010\u000c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0008\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0012\"\u0004\u0008\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012\"\u0004\u0008\u0018\u0010\u0016R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u000eR\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008 \u0010!R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u000e\"\u0004\u0008$\u0010\u0010\u00a8\u0006&"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "",
        "v",
        "",
        "msg",
        "",
        "org",
        "modelP",
        "modelC",
        "rssi",
        "txPower",
        "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V",
        "id",
        "getId",
        "()I",
        "setId",
        "(I)V",
        "getModelC",
        "()Ljava/lang/String;",
        "getModelP",
        "getMsg",
        "setMsg",
        "(Ljava/lang/String;)V",
        "getOrg",
        "setOrg",
        "getRssi",
        "timestamp",
        "",
        "getTimestamp",
        "()J",
        "setTimestamp",
        "(J)V",
        "getTxPower",
        "()Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        "getV",
        "setV",
        "toString",
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
.field private id:I

.field private final modelC:Ljava/lang/String;

.field private final modelP:Ljava/lang/String;

.field private msg:Ljava/lang/String;

.field private org:Ljava/lang/String;

.field private final rssi:I

.field private timestamp:J

.field private final txPower:Ljava/lang/Integer;

.field private v:I


# direct methods
.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V
    .locals 1

    const-string v0, "msg"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "org"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "modelP"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "modelC"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->v:I

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->msg:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->org:Ljava/lang/String;

    iput-object p4, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelP:Ljava/lang/String;

    iput-object p5, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelC:Ljava/lang/String;

    iput p6, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->rssi:I

    iput-object p7, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->txPower:Ljava/lang/Integer;

    .line 39
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide p1

    iput-wide p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->timestamp:J

    return-void
.end method


# virtual methods
.method public final getId()I
    .locals 1

    .line 36
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->id:I

    return v0
.end method

.method public final getModelC()Ljava/lang/String;
    .locals 1

    .line 24
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelC:Ljava/lang/String;

    return-object v0
.end method

.method public final getModelP()Ljava/lang/String;
    .locals 1

    .line 21
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelP:Ljava/lang/String;

    return-object v0
.end method

.method public final getMsg()Ljava/lang/String;
    .locals 1

    .line 15
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public final getOrg()Ljava/lang/String;
    .locals 1

    .line 18
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->org:Ljava/lang/String;

    return-object v0
.end method

.method public final getRssi()I
    .locals 1

    .line 27
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->rssi:I

    return v0
.end method

.method public final getTimestamp()J
    .locals 2

    .line 39
    iget-wide v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->timestamp:J

    return-wide v0
.end method

.method public final getTxPower()Ljava/lang/Integer;
    .locals 1

    .line 30
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->txPower:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getV()I
    .locals 1

    .line 12
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->v:I

    return v0
.end method

.method public final setId(I)V
    .locals 0

    .line 36
    iput p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->id:I

    return-void
.end method

.method public final setMsg(Ljava/lang/String;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->msg:Ljava/lang/String;

    return-void
.end method

.method public final setOrg(Ljava/lang/String;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 18
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->org:Ljava/lang/String;

    return-void
.end method

.method public final setTimestamp(J)V
    .locals 0

    .line 39
    iput-wide p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->timestamp:J

    return-void
.end method

.method public final setV(I)V
    .locals 0

    .line 12
    iput p1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->v:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 42
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "StreetPassRecord(v="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->v:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", msg=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->msg:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\', org=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->org:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\', modelP=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelP:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\', modelC=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->modelC:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\', rssi="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->rssi:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", txPower="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->txPower:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->id:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", timestamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;->timestamp:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
