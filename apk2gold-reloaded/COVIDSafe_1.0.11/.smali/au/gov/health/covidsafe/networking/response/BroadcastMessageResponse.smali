.class public final Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;
.super Ljava/lang/Object;
.source "BroadcastMessageResponse.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008\u00a8\u0006\u0015"
    }
    d2 = {
        "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;",
        "",
        "tempId",
        "",
        "expiryTime",
        "refreshTime",
        "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
        "getExpiryTime",
        "()Ljava/lang/String;",
        "getRefreshTime",
        "getTempId",
        "component1",
        "component2",
        "component3",
        "copy",
        "equals",
        "",
        "other",
        "hashCode",
        "",
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
.field private final expiryTime:Ljava/lang/String;

.field private final refreshTime:Ljava/lang/String;

.field private final tempId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    iput-object p2, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    return-void
.end method

.method public static synthetic copy$default(Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;
    .locals 0

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_0

    iget-object p1, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    :cond_0
    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_1

    iget-object p2, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    :cond_1
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_2

    iget-object p3, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    :cond_2
    invoke-virtual {p0, p1, p2, p3}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    return-object v0
.end method

.method public final component2()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    return-object v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    return-object v0
.end method

.method public final copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    invoke-direct {v0, p1, p2, p3}, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p0, p1, :cond_1

    instance-of v0, p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    if-eqz v0, :cond_0

    check-cast p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    iget-object p1, p1, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    return p1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    return p1
.end method

.method public final getExpiryTime()Ljava/lang/String;
    .locals 1

    .line 6
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    return-object v0
.end method

.method public final getRefreshTime()Ljava/lang/String;
    .locals 1

    .line 6
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    return-object v0
.end method

.method public final getTempId()Ljava/lang/String;
    .locals 1

    .line 6
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_1

    :cond_1
    move v2, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_2
    add-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "BroadcastMessageResponse(tempId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->tempId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", expiryTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->expiryTime:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", refreshTime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;->refreshTime:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
