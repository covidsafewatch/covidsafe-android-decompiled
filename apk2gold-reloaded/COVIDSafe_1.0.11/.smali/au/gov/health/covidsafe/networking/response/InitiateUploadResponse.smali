.class public final Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;
.super Ljava/lang/Object;
.source "InitiateUploadResponse.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008\u00a8\u0006\u0015"
    }
    d2 = {
        "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
        "",
        "uploadLink",
        "",
        "expiresIn",
        "uploadPrefix",
        "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
        "getExpiresIn",
        "()Ljava/lang/String;",
        "getUploadLink",
        "getUploadPrefix",
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
.field private final expiresIn:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "ExpiresIn"
    .end annotation
.end field

.field private final uploadLink:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "UploadLink"
    .end annotation
.end field

.field private final uploadPrefix:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "UploadPrefix"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    const-string v0, "uploadLink"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "expiresIn"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "uploadPrefix"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    iput-object p2, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    return-void
.end method

.method public static synthetic copy$default(Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;
    .locals 0

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_0

    iget-object p1, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    :cond_0
    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_1

    iget-object p2, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    :cond_1
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_2

    iget-object p3, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    :cond_2
    invoke-virtual {p0, p1, p2, p3}, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    return-object v0
.end method

.method public final component2()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    return-object v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public final copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;
    .locals 1

    const-string v0, "uploadLink"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "expiresIn"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "uploadPrefix"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;

    invoke-direct {v0, p1, p2, p3}, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p0, p1, :cond_1

    instance-of v0, p1, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;

    if-eqz v0, :cond_0

    check-cast p1, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    iget-object p1, p1, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

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

.method public final getExpiresIn()Ljava/lang/String;
    .locals 1

    .line 8
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    return-object v0
.end method

.method public final getUploadLink()Ljava/lang/String;
    .locals 1

    .line 7
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    return-object v0
.end method

.method public final getUploadPrefix()Ljava/lang/String;
    .locals 1

    .line 9
    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_1

    :cond_1
    move v2, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

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

    const-string v1, "InitiateUploadResponse(uploadLink="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadLink:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", expiresIn="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->expiresIn:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", uploadPrefix="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;->uploadPrefix:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
