.class public final enum Lrx/internal/util/InternalObservableUtils;
.super Ljava/lang/Enum;
.source "InternalObservableUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/internal/util/InternalObservableUtils$ErrorNotImplementedAction;,
        Lrx/internal/util/InternalObservableUtils$CollectorCaller;,
        Lrx/internal/util/InternalObservableUtils$ReplaySupplierTime;,
        Lrx/internal/util/InternalObservableUtils$ReplaySupplierBufferTime;,
        Lrx/internal/util/InternalObservableUtils$ReplaySupplierBuffer;,
        Lrx/internal/util/InternalObservableUtils$ReplaySupplierNoParams;,
        Lrx/internal/util/InternalObservableUtils$NotificationErrorExtractor;,
        Lrx/internal/util/InternalObservableUtils$RetryNotificationDematerializer;,
        Lrx/internal/util/InternalObservableUtils$SelectorAndObserveOn;,
        Lrx/internal/util/InternalObservableUtils$ReturnsVoidFunc1;,
        Lrx/internal/util/InternalObservableUtils$RepeatNotificationDematerializer;,
        Lrx/internal/util/InternalObservableUtils$IsInstanceOfFunc1;,
        Lrx/internal/util/InternalObservableUtils$EqualsWithFunc1;,
        Lrx/internal/util/InternalObservableUtils$ToArrayFunc1;,
        Lrx/internal/util/InternalObservableUtils$ObjectEqualsFunc2;,
        Lrx/internal/util/InternalObservableUtils$PlusOneLongFunc2;,
        Lrx/internal/util/InternalObservableUtils$PlusOneFunc2;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lrx/internal/util/InternalObservableUtils;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lrx/internal/util/InternalObservableUtils;

.field public static final COUNTER:Lrx/internal/util/InternalObservableUtils$PlusOneFunc2;

.field static final ERROR_EXTRACTOR:Lrx/internal/util/InternalObservableUtils$NotificationErrorExtractor;

.field public static final ERROR_NOT_IMPLEMENTED:Lrx/functions/Action1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/functions/Action1<",
            "Ljava/lang/Throwable;",
            ">;"
        }
    .end annotation
.end field

.field public static final IS_EMPTY:Lrx/Observable$Operator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Observable$Operator<",
            "Ljava/lang/Boolean;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field public static final LONG_COUNTER:Lrx/internal/util/InternalObservableUtils$PlusOneLongFunc2;

.field public static final OBJECT_EQUALS:Lrx/internal/util/InternalObservableUtils$ObjectEqualsFunc2;

.field static final RETURNS_VOID:Lrx/internal/util/InternalObservableUtils$ReturnsVoidFunc1;

.field public static final TO_ARRAY:Lrx/internal/util/InternalObservableUtils$ToArrayFunc1;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x0

    new-array v0, v0, [Lrx/internal/util/InternalObservableUtils;

    .line 33
    sput-object v0, Lrx/internal/util/InternalObservableUtils;->$VALUES:[Lrx/internal/util/InternalObservableUtils;

    .line 38
    new-instance v0, Lrx/internal/util/InternalObservableUtils$PlusOneLongFunc2;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$PlusOneLongFunc2;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->LONG_COUNTER:Lrx/internal/util/InternalObservableUtils$PlusOneLongFunc2;

    .line 43
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ObjectEqualsFunc2;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$ObjectEqualsFunc2;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->OBJECT_EQUALS:Lrx/internal/util/InternalObservableUtils$ObjectEqualsFunc2;

    .line 47
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ToArrayFunc1;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$ToArrayFunc1;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->TO_ARRAY:Lrx/internal/util/InternalObservableUtils$ToArrayFunc1;

    .line 49
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ReturnsVoidFunc1;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$ReturnsVoidFunc1;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->RETURNS_VOID:Lrx/internal/util/InternalObservableUtils$ReturnsVoidFunc1;

    .line 54
    new-instance v0, Lrx/internal/util/InternalObservableUtils$PlusOneFunc2;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$PlusOneFunc2;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->COUNTER:Lrx/internal/util/InternalObservableUtils$PlusOneFunc2;

    .line 56
    new-instance v0, Lrx/internal/util/InternalObservableUtils$NotificationErrorExtractor;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$NotificationErrorExtractor;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->ERROR_EXTRACTOR:Lrx/internal/util/InternalObservableUtils$NotificationErrorExtractor;

    .line 61
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ErrorNotImplementedAction;

    invoke-direct {v0}, Lrx/internal/util/InternalObservableUtils$ErrorNotImplementedAction;-><init>()V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->ERROR_NOT_IMPLEMENTED:Lrx/functions/Action1;

    .line 63
    new-instance v0, Lrx/internal/operators/OperatorAny;

    invoke-static {}, Lrx/internal/util/UtilityFunctions;->alwaysTrue()Lrx/functions/Func1;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lrx/internal/operators/OperatorAny;-><init>(Lrx/functions/Func1;Z)V

    sput-object v0, Lrx/internal/util/InternalObservableUtils;->IS_EMPTY:Lrx/Observable$Operator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static createCollectorCaller(Lrx/functions/Action2;)Lrx/functions/Func2;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/functions/Action2<",
            "TR;-TT;>;)",
            "Lrx/functions/Func2<",
            "TR;TT;TR;>;"
        }
    .end annotation

    .line 366
    new-instance v0, Lrx/internal/util/InternalObservableUtils$CollectorCaller;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$CollectorCaller;-><init>(Lrx/functions/Action2;)V

    return-object v0
.end method

.method public static createRepeatDematerializer(Lrx/functions/Func1;)Lrx/functions/Func1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Func1<",
            "-",
            "Lrx/Observable<",
            "+",
            "Ljava/lang/Void;",
            ">;+",
            "Lrx/Observable<",
            "*>;>;)",
            "Lrx/functions/Func1<",
            "Lrx/Observable<",
            "+",
            "Lrx/Notification<",
            "*>;>;",
            "Lrx/Observable<",
            "*>;>;"
        }
    .end annotation

    .line 146
    new-instance v0, Lrx/internal/util/InternalObservableUtils$RepeatNotificationDematerializer;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$RepeatNotificationDematerializer;-><init>(Lrx/functions/Func1;)V

    return-object v0
.end method

.method public static createReplaySelectorAndObserveOn(Lrx/functions/Func1;Lrx/Scheduler;)Lrx/functions/Func1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "R:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/functions/Func1<",
            "-",
            "Lrx/Observable<",
            "TT;>;+",
            "Lrx/Observable<",
            "TR;>;>;",
            "Lrx/Scheduler;",
            ")",
            "Lrx/functions/Func1<",
            "Lrx/Observable<",
            "TT;>;",
            "Lrx/Observable<",
            "TR;>;>;"
        }
    .end annotation

    .line 182
    new-instance v0, Lrx/internal/util/InternalObservableUtils$SelectorAndObserveOn;

    invoke-direct {v0, p0, p1}, Lrx/internal/util/InternalObservableUtils$SelectorAndObserveOn;-><init>(Lrx/functions/Func1;Lrx/Scheduler;)V

    return-object v0
.end method

.method public static createReplaySupplier(Lrx/Observable;)Lrx/functions/Func0;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Observable<",
            "TT;>;)",
            "Lrx/functions/Func0<",
            "Lrx/observables/ConnectableObservable<",
            "TT;>;>;"
        }
    .end annotation

    .line 241
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ReplaySupplierNoParams;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$ReplaySupplierNoParams;-><init>(Lrx/Observable;)V

    return-object v0
.end method

.method public static createReplaySupplier(Lrx/Observable;I)Lrx/functions/Func0;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Observable<",
            "TT;>;I)",
            "Lrx/functions/Func0<",
            "Lrx/observables/ConnectableObservable<",
            "TT;>;>;"
        }
    .end annotation

    .line 265
    new-instance v0, Lrx/internal/util/InternalObservableUtils$ReplaySupplierBuffer;

    invoke-direct {v0, p0, p1}, Lrx/internal/util/InternalObservableUtils$ReplaySupplierBuffer;-><init>(Lrx/Observable;I)V

    return-object v0
.end method

.method public static createReplaySupplier(Lrx/Observable;IJLjava/util/concurrent/TimeUnit;Lrx/Scheduler;)Lrx/functions/Func0;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Observable<",
            "TT;>;IJ",
            "Ljava/util/concurrent/TimeUnit;",
            "Lrx/Scheduler;",
            ")",
            "Lrx/functions/Func0<",
            "Lrx/observables/ConnectableObservable<",
            "TT;>;>;"
        }
    .end annotation

    .line 333
    new-instance v7, Lrx/internal/util/InternalObservableUtils$ReplaySupplierTime;

    move-object v0, v7

    move-object v1, p0

    move v2, p1

    move-wide v3, p2

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lrx/internal/util/InternalObservableUtils$ReplaySupplierTime;-><init>(Lrx/Observable;IJLjava/util/concurrent/TimeUnit;Lrx/Scheduler;)V

    return-object v7
.end method

.method public static createReplaySupplier(Lrx/Observable;JLjava/util/concurrent/TimeUnit;Lrx/Scheduler;)Lrx/functions/Func0;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lrx/Observable<",
            "TT;>;J",
            "Ljava/util/concurrent/TimeUnit;",
            "Lrx/Scheduler;",
            ")",
            "Lrx/functions/Func0<",
            "Lrx/observables/ConnectableObservable<",
            "TT;>;>;"
        }
    .end annotation

    .line 296
    new-instance v6, Lrx/internal/util/InternalObservableUtils$ReplaySupplierBufferTime;

    move-object v0, v6

    move-object v1, p0

    move-wide v2, p1

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lrx/internal/util/InternalObservableUtils$ReplaySupplierBufferTime;-><init>(Lrx/Observable;JLjava/util/concurrent/TimeUnit;Lrx/Scheduler;)V

    return-object v6
.end method

.method public static createRetryDematerializer(Lrx/functions/Func1;)Lrx/functions/Func1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/functions/Func1<",
            "-",
            "Lrx/Observable<",
            "+",
            "Ljava/lang/Throwable;",
            ">;+",
            "Lrx/Observable<",
            "*>;>;)",
            "Lrx/functions/Func1<",
            "Lrx/Observable<",
            "+",
            "Lrx/Notification<",
            "*>;>;",
            "Lrx/Observable<",
            "*>;>;"
        }
    .end annotation

    .line 211
    new-instance v0, Lrx/internal/util/InternalObservableUtils$RetryNotificationDematerializer;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$RetryNotificationDematerializer;-><init>(Lrx/functions/Func1;)V

    return-object v0
.end method

.method public static equalsWith(Ljava/lang/Object;)Lrx/functions/Func1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            ")",
            "Lrx/functions/Func1<",
            "Ljava/lang/Object;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 100
    new-instance v0, Lrx/internal/util/InternalObservableUtils$EqualsWithFunc1;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$EqualsWithFunc1;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method

.method public static isInstanceOf(Ljava/lang/Class;)Lrx/functions/Func1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "*>;)",
            "Lrx/functions/Func1<",
            "Ljava/lang/Object;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 123
    new-instance v0, Lrx/internal/util/InternalObservableUtils$IsInstanceOfFunc1;

    invoke-direct {v0, p0}, Lrx/internal/util/InternalObservableUtils$IsInstanceOfFunc1;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lrx/internal/util/InternalObservableUtils;
    .locals 1

    .line 33
    const-class v0, Lrx/internal/util/InternalObservableUtils;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lrx/internal/util/InternalObservableUtils;

    return-object p0
.end method

.method public static values()[Lrx/internal/util/InternalObservableUtils;
    .locals 1

    .line 33
    sget-object v0, Lrx/internal/util/InternalObservableUtils;->$VALUES:[Lrx/internal/util/InternalObservableUtils;

    invoke-virtual {v0}, [Lrx/internal/util/InternalObservableUtils;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lrx/internal/util/InternalObservableUtils;

    return-object v0
.end method
