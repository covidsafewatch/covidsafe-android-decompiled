.class public final Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;
.super Ljava/lang/Object;
.source "ConnectablePeripheral.kt"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral$Creator;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r\u00a8\u0006\u0015"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;",
        "Landroid/os/Parcelable;",
        "transmissionPower",
        "",
        "rssi",
        "(Ljava/lang/Integer;I)V",
        "getRssi",
        "()I",
        "setRssi",
        "(I)V",
        "getTransmissionPower",
        "()Ljava/lang/Integer;",
        "setTransmissionPower",
        "(Ljava/lang/Integer;)V",
        "Ljava/lang/Integer;",
        "describeContents",
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
.field private rssi:I

.field private transmissionPower:Ljava/lang/Integer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral$Creator;

    invoke-direct {v0}, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral$Creator;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Ljava/lang/Integer;I)V
    .locals 0

    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->transmissionPower:Ljava/lang/Integer;

    iput p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->rssi:I

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final getRssi()I
    .locals 1

    .line 9
    iget v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->rssi:I

    return v0
.end method

.method public final getTransmissionPower()Ljava/lang/Integer;
    .locals 1

    .line 8
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->transmissionPower:Ljava/lang/Integer;

    return-object v0
.end method

.method public final setRssi(I)V
    .locals 0

    .line 9
    iput p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->rssi:I

    return-void
.end method

.method public final setTransmissionPower(Ljava/lang/Integer;)V
    .locals 0

    .line 8
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->transmissionPower:Ljava/lang/Integer;

    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    const-string p2, "parcel"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iget-object p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->transmissionPower:Ljava/lang/Integer;

    if-eqz p2, :cond_0

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    goto :goto_0

    :cond_0
    const/4 p2, 0x0

    :goto_0
    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    iget p2, p0, Lau/gov/health/covidsafe/streetpass/ConnectablePeripheral;->rssi:I

    invoke-virtual {p1, p2}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
