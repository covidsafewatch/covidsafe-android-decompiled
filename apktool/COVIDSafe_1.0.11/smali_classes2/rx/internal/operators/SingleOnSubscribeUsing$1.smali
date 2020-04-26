.class Lrx/internal/operators/SingleOnSubscribeUsing$1;
.super Lrx/SingleSubscriber;
.source "SingleOnSubscribeUsing.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/internal/operators/SingleOnSubscribeUsing;->call(Lrx/SingleSubscriber;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lrx/SingleSubscriber<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

.field final synthetic val$child:Lrx/SingleSubscriber;

.field final synthetic val$resource:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lrx/internal/operators/SingleOnSubscribeUsing;Ljava/lang/Object;Lrx/SingleSubscriber;)V
    .locals 0

    .line 73
    iput-object p1, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iput-object p2, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$resource:Ljava/lang/Object;

    iput-object p3, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$child:Lrx/SingleSubscriber;

    invoke-direct {p0}, Lrx/SingleSubscriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Throwable;)V
    .locals 3

    .line 101
    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iget-object v1, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$child:Lrx/SingleSubscriber;

    iget-object v2, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$resource:Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, p1}, Lrx/internal/operators/SingleOnSubscribeUsing;->handleSubscriptionTimeError(Lrx/SingleSubscriber;Ljava/lang/Object;Ljava/lang/Throwable;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 76
    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iget-boolean v0, v0, Lrx/internal/operators/SingleOnSubscribeUsing;->disposeEagerly:Z

    if-eqz v0, :cond_0

    .line 78
    :try_start_0
    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iget-object v0, v0, Lrx/internal/operators/SingleOnSubscribeUsing;->disposeAction:Lrx/functions/Action1;

    iget-object v1, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$resource:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lrx/functions/Action1;->call(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    .line 80
    invoke-static {p1}, Lrx/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 82
    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$child:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onError(Ljava/lang/Throwable;)V

    return-void

    .line 87
    :cond_0
    :goto_0
    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$child:Lrx/SingleSubscriber;

    invoke-virtual {v0, p1}, Lrx/SingleSubscriber;->onSuccess(Ljava/lang/Object;)V

    .line 89
    iget-object p1, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iget-boolean p1, p1, Lrx/internal/operators/SingleOnSubscribeUsing;->disposeEagerly:Z

    if-nez p1, :cond_1

    .line 91
    :try_start_1
    iget-object p1, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->this$0:Lrx/internal/operators/SingleOnSubscribeUsing;

    iget-object p1, p1, Lrx/internal/operators/SingleOnSubscribeUsing;->disposeAction:Lrx/functions/Action1;

    iget-object v0, p0, Lrx/internal/operators/SingleOnSubscribeUsing$1;->val$resource:Ljava/lang/Object;

    invoke-interface {p1, v0}, Lrx/functions/Action1;->call(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception p1

    .line 93
    invoke-static {p1}, Lrx/exceptions/Exceptions;->throwIfFatal(Ljava/lang/Throwable;)V

    .line 94
    invoke-static {p1}, Lrx/plugins/RxJavaHooks;->onError(Ljava/lang/Throwable;)V

    :cond_1
    :goto_1
    return-void
.end method
