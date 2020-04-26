.class public final Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;
.super Ljava/lang/Object;
.source "Work.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/streetpass/Work;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "WorkCheckList"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016R\u001e\u0010\u0003\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001e\u0010\n\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u0007\"\u0004\u0008\u000c\u0010\tR\u001e\u0010\r\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u0007\"\u0004\u0008\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0007\"\u0004\u0008\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0007\"\u0004\u0008\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0007\"\u0004\u0008\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00060\u0004R\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u0007\"\u0004\u0008\u001b\u0010\t\u00a8\u0006\u001e"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;",
        "",
        "(Lau/gov/health/covidsafe/streetpass/Work;)V",
        "connected",
        "Lau/gov/health/covidsafe/streetpass/Work$Check;",
        "Lau/gov/health/covidsafe/streetpass/Work;",
        "getConnected",
        "()Lau/gov/health/covidsafe/streetpass/Work$Check;",
        "setConnected",
        "(Lau/gov/health/covidsafe/streetpass/Work$Check;)V",
        "disconnected",
        "getDisconnected",
        "setDisconnected",
        "mtuChanged",
        "getMtuChanged",
        "setMtuChanged",
        "readCharacteristic",
        "getReadCharacteristic",
        "setReadCharacteristic",
        "skipped",
        "getSkipped",
        "setSkipped",
        "started",
        "getStarted",
        "setStarted",
        "writeCharacteristic",
        "getWriteCharacteristic",
        "setWriteCharacteristic",
        "toString",
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


# instance fields
.field private connected:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field private disconnected:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field private mtuChanged:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field private readCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field private skipped:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field private started:Lau/gov/health/covidsafe/streetpass/Work$Check;

.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/Work;

.field private writeCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 49
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->this$0:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->started:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 51
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->connected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 52
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->mtuChanged:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 53
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->readCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 54
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->writeCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 55
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->disconnected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    .line 56
    new-instance v0, Lau/gov/health/covidsafe/streetpass/Work$Check;

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/Work$Check;-><init>(Lau/gov/health/covidsafe/streetpass/Work;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->skipped:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method


# virtual methods
.method public final getConnected()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 51
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->connected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getDisconnected()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 55
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->disconnected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getMtuChanged()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 52
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->mtuChanged:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getReadCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 53
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->readCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getSkipped()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 56
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->skipped:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getStarted()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 50
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->started:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final getWriteCharacteristic()Lau/gov/health/covidsafe/streetpass/Work$Check;
    .locals 1

    .line 54
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->writeCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-object v0
.end method

.method public final setConnected(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 51
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->connected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setDisconnected(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 55
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->disconnected:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setMtuChanged(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 52
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->mtuChanged:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setReadCharacteristic(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 53
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->readCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setSkipped(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 56
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->skipped:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setStarted(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 50
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->started:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public final setWriteCharacteristic(Lau/gov/health/covidsafe/streetpass/Work$Check;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 54
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$WorkCheckList;->writeCharacteristic:Lau/gov/health/covidsafe/streetpass/Work$Check;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 59
    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v0, p0}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Gson().toJson(this)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method
