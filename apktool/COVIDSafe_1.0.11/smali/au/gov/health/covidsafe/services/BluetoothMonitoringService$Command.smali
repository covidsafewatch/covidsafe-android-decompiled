.class public final enum Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;
.super Ljava/lang/Enum;
.source "BluetoothMonitoringService.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/services/BluetoothMonitoringService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Command"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nBluetoothMonitoringService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothMonitoringService.kt\nau/gov/health/covidsafe/services/BluetoothMonitoringService$Command\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,671:1\n7379#2,2:672\n8061#2,4:674\n*E\n*S KotlinDebug\n*F\n+ 1 BluetoothMonitoringService.kt\nau/gov/health/covidsafe/services/BluetoothMonitoringService$Command\n*L\n622#1,2:672\n622#1,4:674\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0086\u0001\u0018\u0000 \u00122\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011\u00a8\u0006\u0013"
    }
    d2 = {
        "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;",
        "",
        "index",
        "",
        "string",
        "",
        "(Ljava/lang/String;IILjava/lang/String;)V",
        "getIndex",
        "()I",
        "getString",
        "()Ljava/lang/String;",
        "INVALID",
        "ACTION_START",
        "ACTION_SCAN",
        "ACTION_STOP",
        "ACTION_ADVERTISE",
        "ACTION_SELF_CHECK",
        "ACTION_UPDATE_BM",
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
.field private static final synthetic $VALUES:[Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_SELF_CHECK:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_START:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_STOP:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final enum ACTION_UPDATE_BM:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field public static final Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;

.field public static final enum INVALID:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

.field private static final types:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final index:I

.field private final string:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v0, 0x7

    new-array v0, v0, [Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const-string v2, "INVALID"

    const/4 v3, 0x0

    const/4 v4, -0x1

    .line 613
    invoke-direct {v1, v2, v3, v4, v2}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->INVALID:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v3

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v2, 0x1

    const-string v4, "ACTION_START"

    const-string v5, "START"

    .line 614
    invoke-direct {v1, v4, v2, v3, v5}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_START:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v4, 0x2

    const-string v5, "ACTION_SCAN"

    const-string v6, "SCAN"

    .line 615
    invoke-direct {v1, v5, v4, v2, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SCAN:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v4

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v2, 0x3

    const-string v5, "ACTION_STOP"

    const-string v6, "STOP"

    .line 616
    invoke-direct {v1, v5, v2, v4, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_STOP:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v4, 0x4

    const-string v5, "ACTION_ADVERTISE"

    const-string v6, "ADVERTISE"

    .line 617
    invoke-direct {v1, v5, v4, v2, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_ADVERTISE:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v4

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v2, 0x5

    const-string v5, "ACTION_SELF_CHECK"

    const-string v6, "SELF_CHECK"

    .line 618
    invoke-direct {v1, v5, v2, v4, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_SELF_CHECK:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    const/4 v4, 0x6

    const-string v5, "ACTION_UPDATE_BM"

    const-string v6, "UPDATE_BM"

    .line 619
    invoke-direct {v1, v5, v4, v2, v6}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;-><init>(Ljava/lang/String;IILjava/lang/String;)V

    sput-object v1, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->ACTION_UPDATE_BM:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    aput-object v1, v0, v4

    sput-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->$VALUES:[Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    new-instance v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->Companion:Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;

    .line 622
    invoke-static {}, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->values()[Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    move-result-object v0

    .line 672
    array-length v1, v0

    invoke-static {v1}, Lkotlin/collections/MapsKt;->mapCapacity(I)I

    move-result v1

    const/16 v2, 0x10

    invoke-static {v1, v2}, Lkotlin/ranges/RangesKt;->coerceAtLeast(II)I

    move-result v1

    .line 673
    new-instance v2, Ljava/util/LinkedHashMap;

    invoke-direct {v2, v1}, Ljava/util/LinkedHashMap;-><init>(I)V

    check-cast v2, Ljava/util/Map;

    .line 674
    array-length v1, v0

    :goto_0
    if-ge v3, v1, :cond_0

    aget-object v4, v0, v3

    .line 622
    iget v5, v4, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->index:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v5, v4}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v4

    invoke-virtual {v4}, Lkotlin/Pair;->getFirst()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4}, Lkotlin/Pair;->getSecond()Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v2, v5, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 677
    :cond_0
    sput-object v2, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->types:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 612
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput p3, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->index:I

    iput-object p4, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->string:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$getTypes$cp()Ljava/util/Map;
    .locals 1

    .line 612
    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->types:Ljava/util/Map;

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;
    .locals 1

    const-class v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    return-object p0
.end method

.method public static values()[Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;
    .locals 1

    sget-object v0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->$VALUES:[Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    invoke-virtual {v0}, [Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;

    return-object v0
.end method


# virtual methods
.method public final getIndex()I
    .locals 1

    .line 612
    iget v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->index:I

    return v0
.end method

.method public final getString()Ljava/lang/String;
    .locals 1

    .line 612
    iget-object v0, p0, Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;->string:Ljava/lang/String;

    return-object v0
.end method
