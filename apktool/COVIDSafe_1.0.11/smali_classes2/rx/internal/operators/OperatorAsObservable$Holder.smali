.class final Lrx/internal/operators/OperatorAsObservable$Holder;
.super Ljava/lang/Object;
.source "OperatorAsObservable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/internal/operators/OperatorAsObservable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Holder"
.end annotation


# static fields
.field static final INSTANCE:Lrx/internal/operators/OperatorAsObservable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/internal/operators/OperatorAsObservable<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 31
    new-instance v0, Lrx/internal/operators/OperatorAsObservable;

    invoke-direct {v0}, Lrx/internal/operators/OperatorAsObservable;-><init>()V

    sput-object v0, Lrx/internal/operators/OperatorAsObservable$Holder;->INSTANCE:Lrx/internal/operators/OperatorAsObservable;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
