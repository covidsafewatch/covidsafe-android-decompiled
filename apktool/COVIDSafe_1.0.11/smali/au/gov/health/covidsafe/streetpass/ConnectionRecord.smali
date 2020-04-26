.class public final Lau/gov/health/covidsafe/streetpass/ConnectionRecord;
.super Ljava/lang/Object;
.source "ConnectablePeripheral.kt"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/streetpass/ConnectionRecord$Creator;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0008H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJV\u0010&\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\'J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010)\u001a\u00020*2\u0008\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\u0008\u0010.\u001a\u00020\u0005H\u0016J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0008\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u001e\u0010\u000c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016\u00a8\u00064"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/ConnectionRecord;",
        "Landroid/os/Parcelable;",
        "version",
        "",
        "msg",
        "",
        "org",
        "peripheral",
        "Lau/gov/health/covidsafe/streetpass/PeripheralDevice;",
        "central",
        "Lau/gov/health/covidsafe/streetpass/CentralDevice;",
        "rssi",
        "txPower",
        "(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V",
        "getCentral",
        "()Lau/gov/health/covidsafe/streetpass/CentralDevice;",
        "getMsg",
        "()Ljava/lang/String;",
        "getOrg",
        "getPeripheral",
        "()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;",
        "getRssi",
        "()I",
        "setRssi",
        "(I)V",
        "getTxPower",
        "()Ljava/lang/Integer;",
        "setTxPower",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "getVersion",
        "component1",
        "component2",
        "component3",
        "component4",
        "component5",
        "component6",
        "component7",
        "copy",
        "(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)Lau/gov/health/covidsafe/streetpass/ConnectionRecord;",
        "describeContents",
        "equals",
        "",
        "other",
        "",
        "hashCode",
        "toString",
        "writeToParcel",
        "",
        "parcel",
        "Landroid/os/Parcel;",
        "flags",
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
.field public static final CREATOR:Landroid/os/Parcelable$Creator;


# instance fields
.field private final central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

.field private final msg:Ljava/lang/String;

.field private final org:Ljava/lang/String;

.field private final peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

.field private rssi:I

.field private txPower:Ljava/lang/Integer;

.field private final version:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord$Creator;

    invoke-direct {v0}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord$Creator;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V
    .locals 1

    const-string v0, "msg"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "org"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "peripheral"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "central"

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    iput-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    iput-object p4, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    iput-object p5, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    iput p6, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    iput-object p7, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    return-void
.end method

.method public static synthetic copy$default(Lau/gov/health/covidsafe/streetpass/ConnectionRecord;ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;ILjava/lang/Object;)Lau/gov/health/covidsafe/streetpass/ConnectionRecord;
    .locals 5

    and-int/lit8 p9, p8, 0x1

    if-eqz p9, :cond_0

    iget p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    :cond_0
    and-int/lit8 p9, p8, 0x2

    if-eqz p9, :cond_1

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    :cond_1
    move-object p9, p2

    and-int/lit8 p2, p8, 0x4

    if-eqz p2, :cond_2

    iget-object p3, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    :cond_2
    move-object v0, p3

    and-int/lit8 p2, p8, 0x8

    if-eqz p2, :cond_3

    iget-object p4, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    :cond_3
    move-object v1, p4

    and-int/lit8 p2, p8, 0x10

    if-eqz p2, :cond_4

    iget-object p5, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    :cond_4
    move-object v2, p5

    and-int/lit8 p2, p8, 0x20

    if-eqz p2, :cond_5

    iget p6, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    :cond_5
    move v3, p6

    and-int/lit8 p2, p8, 0x40

    if-eqz p2, :cond_6

    iget-object p7, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    :cond_6
    move-object v4, p7

    move-object p2, p0

    move p3, p1

    move-object p4, p9

    move-object p5, v0

    move-object p6, v1

    move-object p7, v2

    move p8, v3

    move-object p9, v4

    invoke-virtual/range {p2 .. p9}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->copy(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()I
    .locals 1

    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    return v0
.end method

.method public final component2()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    return-object v0
.end method

.method public final component4()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    return-object v0
.end method

.method public final component5()Lau/gov/health/covidsafe/streetpass/CentralDevice;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    return-object v0
.end method

.method public final component6()I
    .locals 1

    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    return v0
.end method

.method public final component7()Ljava/lang/Integer;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    return-object v0
.end method

.method public final copy(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)Lau/gov/health/covidsafe/streetpass/ConnectionRecord;
    .locals 9

    const-string v0, "msg"

    move-object v3, p2

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "org"

    move-object v4, p3

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "peripheral"

    move-object v5, p4

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "central"

    move-object v6, p5

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    move-object v1, v0

    move v2, p1

    move v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v1 .. v8}, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;-><init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;Lau/gov/health/covidsafe/streetpass/CentralDevice;ILjava/lang/Integer;)V

    return-object v0
.end method

.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p0, p1, :cond_1

    instance-of v0, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    if-eqz v0, :cond_0

    check-cast p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;

    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    iget v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    iget-object v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    iget-object v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    iget v1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    iget-object p1, p1, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

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

.method public final getCentral()Lau/gov/health/covidsafe/streetpass/CentralDevice;
    .locals 1

    .line 32
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    return-object v0
.end method

.method public final getMsg()Ljava/lang/String;
    .locals 1

    .line 28
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public final getOrg()Ljava/lang/String;
    .locals 1

    .line 29
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    return-object v0
.end method

.method public final getPeripheral()Lau/gov/health/covidsafe/streetpass/PeripheralDevice;
    .locals 1

    .line 31
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    return-object v0
.end method

.method public final getRssi()I
    .locals 1

    .line 34
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    return v0
.end method

.method public final getTxPower()Ljava/lang/Integer;
    .locals 1

    .line 35
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    return-object v0
.end method

.method public final getVersion()I
    .locals 1

    .line 26
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    return v0
.end method

.method public hashCode()I
    .locals 3

    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_0

    :cond_0
    move v1, v2

    :goto_0
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_1

    :cond_1
    move v1, v2

    :goto_1
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_2

    :cond_2
    move v1, v2

    :goto_2
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_3

    :cond_3
    move v1, v2

    :goto_3
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :cond_4
    add-int/2addr v0, v2

    return v0
.end method

.method public final setRssi(I)V
    .locals 0

    .line 34
    iput p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    return-void
.end method

.method public final setTxPower(Ljava/lang/Integer;)V
    .locals 0

    .line 35
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Central "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/CentralDevice;->getModelC()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/CentralDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " ---> Peripheral "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;->getModelP()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    invoke-virtual {v1}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    const-string p2, "parcel"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iget p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->version:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->msg:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->org:Ljava/lang/String;

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->peripheral:Lau/gov/health/covidsafe/streetpass/PeripheralDevice;

    const/4 v0, 0x0

    invoke-interface {p2, p1, v0}, Landroid/os/Parcelable;->writeToParcel(Landroid/os/Parcel;I)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->central:Lau/gov/health/covidsafe/streetpass/CentralDevice;

    invoke-interface {p2, p1, v0}, Landroid/os/Parcelable;->writeToParcel(Landroid/os/Parcel;I)V

    iget p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->rssi:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectionRecord;->txPower:Ljava/lang/Integer;

    if-eqz p2, :cond_0

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    goto :goto_0

    :cond_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    :goto_0
    return-void
.end method
