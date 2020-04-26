.class Lrx/internal/schedulers/SchedulerWhen$1;
.super Ljava/lang/Object;
.source "SchedulerWhen.java"

# interfaces
.implements Lrx/functions/Func1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/schedulers/SchedulerWhen;->createWorker()Lrx/Scheduler$Worker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lrx/functions/Func1<",
        "Lrx/internal/schedulers/SchedulerWhen$ScheduledAction;",
        "Lrx/Completable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/schedulers/SchedulerWhen;

.field final synthetic val$actualWorker:Lrx/Scheduler$Worker;


# direct methods
.method constructor <init>(Lrx/internal/schedulers/SchedulerWhen;Lrx/Scheduler$Worker;)V
    .locals 0

    .line 138
    iput-object p1, p0, Lrx/internal/schedulers/SchedulerWhen$1;->this$0:Lrx/internal/schedulers/SchedulerWhen;

    iput-object p2, p0, Lrx/internal/schedulers/SchedulerWhen$1;->val$actualWorker:Lrx/Scheduler$Worker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 138
    check-cast p1, Lrx/internal/schedulers/SchedulerWhen$ScheduledAction;

    invoke-virtual {p0, p1}, Lrx/internal/schedulers/SchedulerWhen$1;->call(Lrx/internal/schedulers/SchedulerWhen$ScheduledAction;)Lrx/Completable;

    move-result-object p1

    return-object p1
.end method

.method public call(Lrx/internal/schedulers/SchedulerWhen$ScheduledAction;)Lrx/Completable;
    .locals 1

    .line 141
    new-instance v0, Lrx/internal/schedulers/SchedulerWhen$1$1;

    invoke-direct {v0, p0, p1}, Lrx/internal/schedulers/SchedulerWhen$1$1;-><init>(Lrx/internal/schedulers/SchedulerWhen$1;Lrx/internal/schedulers/SchedulerWhen$ScheduledAction;)V

    invoke-static {v0}, Lrx/Completable;->create(Lrx/Completable$OnSubscribe;)Lrx/Completable;

    move-result-object p1

    return-object p1
.end method
