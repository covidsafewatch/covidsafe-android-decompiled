.class public final enum Lrx/Emitter$BackpressureMode;
.super Ljava/lang/Enum;
.source "Emitter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/Emitter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BackpressureMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lrx/Emitter$BackpressureMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lrx/Emitter$BackpressureMode;

.field public static final enum BUFFER:Lrx/Emitter$BackpressureMode;

.field public static final enum DROP:Lrx/Emitter$BackpressureMode;

.field public static final enum ERROR:Lrx/Emitter$BackpressureMode;

.field public static final enum LATEST:Lrx/Emitter$BackpressureMode;

.field public static final enum NONE:Lrx/Emitter$BackpressureMode;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .line 64
    new-instance v0, Lrx/Emitter$BackpressureMode;

    const/4 v1, 0x0

    const-string v2, "NONE"

    invoke-direct {v0, v2, v1}, Lrx/Emitter$BackpressureMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/Emitter$BackpressureMode;->NONE:Lrx/Emitter$BackpressureMode;

    .line 68
    new-instance v0, Lrx/Emitter$BackpressureMode;

    const/4 v2, 0x1

    const-string v3, "ERROR"

    invoke-direct {v0, v3, v2}, Lrx/Emitter$BackpressureMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/Emitter$BackpressureMode;->ERROR:Lrx/Emitter$BackpressureMode;

    .line 72
    new-instance v0, Lrx/Emitter$BackpressureMode;

    const/4 v3, 0x2

    const-string v4, "BUFFER"

    invoke-direct {v0, v4, v3}, Lrx/Emitter$BackpressureMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/Emitter$BackpressureMode;->BUFFER:Lrx/Emitter$BackpressureMode;

    .line 76
    new-instance v0, Lrx/Emitter$BackpressureMode;

    const/4 v4, 0x3

    const-string v5, "DROP"

    invoke-direct {v0, v5, v4}, Lrx/Emitter$BackpressureMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/Emitter$BackpressureMode;->DROP:Lrx/Emitter$BackpressureMode;

    .line 81
    new-instance v0, Lrx/Emitter$BackpressureMode;

    const/4 v5, 0x4

    const-string v6, "LATEST"

    invoke-direct {v0, v6, v5}, Lrx/Emitter$BackpressureMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/Emitter$BackpressureMode;->LATEST:Lrx/Emitter$BackpressureMode;

    const/4 v6, 0x5

    new-array v6, v6, [Lrx/Emitter$BackpressureMode;

    .line 58
    sget-object v7, Lrx/Emitter$BackpressureMode;->NONE:Lrx/Emitter$BackpressureMode;

    aput-object v7, v6, v1

    sget-object v1, Lrx/Emitter$BackpressureMode;->ERROR:Lrx/Emitter$BackpressureMode;

    aput-object v1, v6, v2

    sget-object v1, Lrx/Emitter$BackpressureMode;->BUFFER:Lrx/Emitter$BackpressureMode;

    aput-object v1, v6, v3

    sget-object v1, Lrx/Emitter$BackpressureMode;->DROP:Lrx/Emitter$BackpressureMode;

    aput-object v1, v6, v4

    aput-object v0, v6, v5

    sput-object v6, Lrx/Emitter$BackpressureMode;->$VALUES:[Lrx/Emitter$BackpressureMode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 58
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lrx/Emitter$BackpressureMode;
    .locals 1

    .line 58
    const-class v0, Lrx/Emitter$BackpressureMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lrx/Emitter$BackpressureMode;

    return-object p0
.end method

.method public static values()[Lrx/Emitter$BackpressureMode;
    .locals 1

    .line 58
    sget-object v0, Lrx/Emitter$BackpressureMode;->$VALUES:[Lrx/Emitter$BackpressureMode;

    invoke-virtual {v0}, [Lrx/Emitter$BackpressureMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lrx/Emitter$BackpressureMode;

    return-object v0
.end method
