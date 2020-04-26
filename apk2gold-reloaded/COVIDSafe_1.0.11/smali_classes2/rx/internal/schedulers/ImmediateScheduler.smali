.class public final Lrx/internal/schedulers/ImmediateScheduler;
.super Lrx/Scheduler;
.source "ImmediateScheduler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/schedulers/ImmediateScheduler$InnerImmediateScheduler;
    }
.end annotation


# static fields
.field public static final INSTANCE:Lrx/internal/schedulers/ImmediateScheduler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 30
    new-instance v0, Lrx/internal/schedulers/ImmediateScheduler;

    invoke-direct {v0}, Lrx/internal/schedulers/ImmediateScheduler;-><init>()V

    sput-object v0, Lrx/internal/schedulers/ImmediateScheduler;->INSTANCE:Lrx/internal/schedulers/ImmediateScheduler;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 32
    invoke-direct {p0}, Lrx/Scheduler;-><init>()V

    return-void
.end method


# virtual methods
.method public createWorker()Lrx/Scheduler$Worker;
    .locals 1

    .line 38
    new-instance v0, Lrx/internal/schedulers/ImmediateScheduler$InnerImmediateScheduler;

    invoke-direct {v0, p0}, Lrx/internal/schedulers/ImmediateScheduler$InnerImmediateScheduler;-><init>(Lrx/internal/schedulers/ImmediateScheduler;)V

    return-object v0
.end method
