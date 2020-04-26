.class final Lrx/internal/operators/OperatorSwitch$HolderDelayError;
.super Ljava/lang/Object;
.source "OperatorSwitch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorSwitch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "HolderDelayError"
.end annotation


# static fields
.field static final INSTANCE:Lrx/internal/operators/OperatorSwitch;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorSwitch<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 49
    new-instance v0, Lrx/internal/operators/OperatorSwitch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lrx/internal/operators/OperatorSwitch;-><init>(Z)V

    sput-object v0, Lrx/internal/operators/OperatorSwitch$HolderDelayError;->INSTANCE:Lrx/internal/operators/OperatorSwitch;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
