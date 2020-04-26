.class final enum Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;
.super Ljava/lang/Enum;
.source "ExecutionSequencer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/common/util/concurrent/ExecutionSequencer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "RunningState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

.field public static final enum CANCELLED:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

.field public static final enum NOT_RUN:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

.field public static final enum STARTED:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 52
    new-instance v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    const/4 v1, 0x0

    const-string v2, "NOT_RUN"

    invoke-direct {v0, v2, v1}, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->NOT_RUN:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    .line 53
    new-instance v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    const/4 v2, 0x1

    const-string v3, "CANCELLED"

    invoke-direct {v0, v3, v2}, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->CANCELLED:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    .line 54
    new-instance v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    const/4 v3, 0x2

    const-string v4, "STARTED"

    invoke-direct {v0, v4, v3}, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->STARTED:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    const/4 v4, 0x3

    new-array v4, v4, [Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    .line 51
    sget-object v5, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->NOT_RUN:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    aput-object v5, v4, v1

    sget-object v1, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->CANCELLED:Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    aput-object v1, v4, v2

    aput-object v0, v4, v3

    sput-object v4, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->$VALUES:[Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 51
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;
    .locals 1

    .line 51
    const-class v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    return-object p0
.end method

.method public static values()[Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;
    .locals 1

    .line 51
    sget-object v0, Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->$VALUES:[Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    invoke-virtual {v0}, [Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/common/util/concurrent/ExecutionSequencer$RunningState;

    return-object v0
.end method
