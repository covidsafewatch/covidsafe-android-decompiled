.class final Lrx/plugins/RxJavaHooks$4;
.super Ljava/lang/Object;
.source "RxJavaHooks.java"

# interfaces
.implements Lrx/functions/Func2;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/plugins/RxJavaHooks;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lrx/functions/Func2<",
        "Lrx/Single;",
        "Lrx/Single$OnSubscribe;",
        "Lrx/Single$OnSubscribe;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 122
    check-cast p1, Lrx/Single;

    check-cast p2, Lrx/Single$OnSubscribe;

    invoke-virtual {p0, p1, p2}, Lrx/plugins/RxJavaHooks$4;->call(Lrx/Single;Lrx/Single$OnSubscribe;)Lrx/Single$OnSubscribe;

    move-result-object p1

    return-object p1
.end method

.method public call(Lrx/Single;Lrx/Single$OnSubscribe;)Lrx/Single$OnSubscribe;
    .locals 3

    .line 126
    invoke-static {}, Lrx/plugins/RxJavaPlugins;->getInstance()Lrx/plugins/RxJavaPlugins;

    move-result-object v0

    invoke-virtual {v0}, Lrx/plugins/RxJavaPlugins;->getSingleExecutionHook()Lrx/plugins/RxJavaSingleExecutionHook;

    move-result-object v0

    .line 128
    invoke-static {}, Lrx/plugins/RxJavaSingleExecutionHookDefault;->getInstance()Lrx/plugins/RxJavaSingleExecutionHook;

    move-result-object v1

    if-ne v0, v1, :cond_0

    return-object p2

    .line 132
    :cond_0
    new-instance v1, Lrx/internal/operators/SingleFromObservable;

    new-instance v2, Lrx/internal/operators/SingleToObservable;

    invoke-direct {v2, p2}, Lrx/internal/operators/SingleToObservable;-><init>(Lrx/Single$OnSubscribe;)V

    invoke-virtual {v0, p1, v2}, Lrx/plugins/RxJavaSingleExecutionHook;->onSubscribeStart(Lrx/Single;Lrx/Observable$OnSubscribe;)Lrx/Observable$OnSubscribe;

    move-result-object p1

    invoke-direct {v1, p1}, Lrx/internal/operators/SingleFromObservable;-><init>(Lrx/Observable$OnSubscribe;)V

    return-object v1
.end method
