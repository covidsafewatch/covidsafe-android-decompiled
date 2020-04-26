.class public final Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;
.super Ljava/lang/Object;
.source "GATT.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGATT.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GATT.kt\nau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion\n*L\n1#1,67:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u00a8\u0006\u000b"
    }
    d2 = {
        "Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;",
        "",
        "()V",
        "gson",
        "Lcom/google/gson/Gson;",
        "getGson",
        "()Lcom/google/gson/Gson;",
        "createReadRequestPayload",
        "Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;",
        "dataBytes",
        "",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    .line 35
    invoke-direct {p0}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final createReadRequestPayload([B)Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;
    .locals 2

    const-string v0, "dataBytes"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    sget-object v0, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p1, v0}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    .line 40
    move-object p1, p0

    check-cast p1, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;->getGson()Lcom/google/gson/Gson;

    move-result-object p1

    const-class v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;

    invoke-virtual {p1, v1, v0}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p1

    const-string v0, "gson.fromJson(dataString\u2026questPayload::class.java)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;

    return-object p1
.end method

.method public final getGson()Lcom/google/gson/Gson;
    .locals 1

    .line 36
    invoke-static {}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->access$getGson$cp()Lcom/google/gson/Gson;

    move-result-object v0

    return-object v0
.end method
