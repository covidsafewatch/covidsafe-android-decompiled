.class final enum Lrx/functions/Actions$NotImplemented;
.super Ljava/lang/Enum;
.source "Actions.java"

# interfaces
.implements Lrx/functions/Action1;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/functions/Actions;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "NotImplemented"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lrx/functions/Actions$NotImplemented;",
        ">;",
        "Lrx/functions/Action1<",
        "Ljava/lang/Throwable;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lrx/functions/Actions$NotImplemented;

.field public static final enum INSTANCE:Lrx/functions/Actions$NotImplemented;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 573
    new-instance v0, Lrx/functions/Actions$NotImplemented;

    const/4 v1, 0x0

    const-string v2, "INSTANCE"

    invoke-direct {v0, v2, v1}, Lrx/functions/Actions$NotImplemented;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lrx/functions/Actions$NotImplemented;->INSTANCE:Lrx/functions/Actions$NotImplemented;

    const/4 v2, 0x1

    new-array v2, v2, [Lrx/functions/Actions$NotImplemented;

    aput-object v0, v2, v1

    .line 572
    sput-object v2, Lrx/functions/Actions$NotImplemented;->$VALUES:[Lrx/functions/Actions$NotImplemented;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 572
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lrx/functions/Actions$NotImplemented;
    .locals 1

    .line 572
    const-class v0, Lrx/functions/Actions$NotImplemented;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lrx/functions/Actions$NotImplemented;

    return-object p0
.end method

.method public static values()[Lrx/functions/Actions$NotImplemented;
    .locals 1

    .line 572
    sget-object v0, Lrx/functions/Actions$NotImplemented;->$VALUES:[Lrx/functions/Actions$NotImplemented;

    invoke-virtual {v0}, [Lrx/functions/Actions$NotImplemented;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lrx/functions/Actions$NotImplemented;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .line 572
    check-cast p1, Ljava/lang/Throwable;

    invoke-virtual {p0, p1}, Lrx/functions/Actions$NotImplemented;->call(Ljava/lang/Throwable;)V

    return-void
.end method

.method public call(Ljava/lang/Throwable;)V
    .locals 1

    .line 576
    new-instance v0, Lrx/exceptions/OnErrorNotImplementedException;

    invoke-direct {v0, p1}, Lrx/exceptions/OnErrorNotImplementedException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method
