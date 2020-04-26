.class public final Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;
.super Ljava/lang/Object;
.source "GATT.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nGATT.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GATT.kt\nau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload\n*L\n1#1,67:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0012\n\u0002\u0008\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\u00a8\u0006\u0014"
    }
    d2 = {
        "Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;",
        "",
        "v",
        "",
        "msg",
        "",
        "org",
        "peripheral",
        "Lau/gov/health/covidsafe/streetpass/PeripheralDevice;",
        "(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;)V",
        "modelP",
        "getModelP",
        "()Ljava/lang/String;",
        "getMsg",
        "getOrg",
        "getV",
        "()I",
        "getPayload",
        "",
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
.field public static final Companion:Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;

.field private static final gson:Lcom/google/gson/Gson;


# instance fields
.field private final modelP:Ljava/lang/String;

.field private final msg:Ljava/lang/String;

.field private final org:Ljava/lang/String;

.field private final v:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->Companion:Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload$Companion;

    .line 36
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->disableHtmlEscaping()Lcom/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v0

    const-string v1, "GsonBuilder().disableHtmlEscaping().create()"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sput-object v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->gson:Lcom/google/gson/Gson;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Lau/gov/health/covidsafe/streetpass/PeripheralDevice;)V
    .locals 1

    const-string v0, "msg"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "org"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "peripheral"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->v:I

    iput-object p2, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->msg:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->org:Ljava/lang/String;

    .line 29
    invoke-virtual {p4}, Lau/gov/health/covidsafe/streetpass/PeripheralDevice;->getModelP()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->modelP:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$getGson$cp()Lcom/google/gson/Gson;
    .locals 1

    .line 23
    sget-object v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->gson:Lcom/google/gson/Gson;

    return-object v0
.end method


# virtual methods
.method public final getModelP()Ljava/lang/String;
    .locals 1

    .line 29
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->modelP:Ljava/lang/String;

    return-object v0
.end method

.method public final getMsg()Ljava/lang/String;
    .locals 1

    .line 25
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->msg:Ljava/lang/String;

    return-object v0
.end method

.method public final getOrg()Ljava/lang/String;
    .locals 1

    .line 26
    iget-object v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->org:Ljava/lang/String;

    return-object v0
.end method

.method public final getPayload()[B
    .locals 2

    .line 32
    sget-object v0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->gson:Lcom/google/gson/Gson;

    invoke-virtual {v0, p0}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "gson.toJson(this)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v1, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    const-string v1, "(this as java.lang.String).getBytes(charset)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0

    :cond_0
    new-instance v0, Lkotlin/TypeCastException;

    const-string v1, "null cannot be cast to non-null type java.lang.String"

    invoke-direct {v0, v1}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final getV()I
    .locals 1

    .line 24
    iget v0, p0, Lau/gov/health/covidsafe/bluetooth/gatt/ReadRequestPayload;->v:I

    return v0
.end method
