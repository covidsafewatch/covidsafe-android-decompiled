.class Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber$2;
.super Ljava/lang/Object;
.source "OperatorWindowWithTime.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;->startNewChunk()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;

.field final synthetic val$chunk:Lrx/internal/operators/OperatorWindowWithTime$CountedSerializedSubject;


# direct methods
.method constructor <init>(Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;Lrx/internal/operators/OperatorWindowWithTime$CountedSerializedSubject;)V
    .locals 0

    .line 464
    iput-object p1, p0, Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber$2;->this$1:Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;

    iput-object p2, p0, Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber$2;->val$chunk:Lrx/internal/operators/OperatorWindowWithTime$CountedSerializedSubject;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 2

    .line 468
    iget-object v0, p0, Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber$2;->this$1:Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;

    iget-object v1, p0, Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber$2;->val$chunk:Lrx/internal/operators/OperatorWindowWithTime$CountedSerializedSubject;

    invoke-virtual {v0, v1}, Lrx/internal/operators/OperatorWindowWithTime$InexactSubscriber;->terminateChunk(Lrx/internal/operators/OperatorWindowWithTime$CountedSerializedSubject;)V

    return-void
.end method
