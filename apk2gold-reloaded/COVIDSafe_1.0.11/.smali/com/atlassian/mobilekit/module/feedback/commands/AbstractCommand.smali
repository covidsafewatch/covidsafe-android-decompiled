.class abstract Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;
.super Ljava/lang/Object;
.source "AbstractCommand.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/core/Command;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/atlassian/mobilekit/module/core/Command;"
    }
.end annotation


# instance fields
.field private final receiver:Lcom/atlassian/mobilekit/module/core/Receiver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/atlassian/mobilekit/module/core/Receiver<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/atlassian/mobilekit/module/core/Receiver<",
            "TT;>;",
            "Lcom/atlassian/mobilekit/module/core/UiNotifier;",
            ")V"
        }
    .end annotation

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->receiver:Lcom/atlassian/mobilekit/module/core/Receiver;

    .line 18
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    return-void
.end method

.method static synthetic access$000(Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;)Lcom/atlassian/mobilekit/module/core/Receiver;
    .locals 0

    .line 11
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->receiver:Lcom/atlassian/mobilekit/module/core/Receiver;

    return-object p0
.end method

.method private isMainThread()Z
    .locals 2

    .line 41
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method


# virtual methods
.method updateReceiver(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 23
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->receiver:Lcom/atlassian/mobilekit/module/core/Receiver;

    if-nez v0, :cond_0

    return-void

    .line 27
    :cond_0
    instance-of v0, v0, Lcom/atlassian/mobilekit/module/core/UiReceiver;

    if-eqz v0, :cond_2

    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->isMainThread()Z

    move-result v0

    if-eqz v0, :cond_1

    goto :goto_0

    .line 31
    :cond_1
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;

    invoke-direct {v1, p0, p1}, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;-><init>(Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Lcom/atlassian/mobilekit/module/core/UiNotifier;->post(Ljava/lang/Runnable;)V

    goto :goto_1

    .line 28
    :cond_2
    :goto_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->receiver:Lcom/atlassian/mobilekit/module/core/Receiver;

    invoke-interface {v0, p1}, Lcom/atlassian/mobilekit/module/core/Receiver;->receive(Ljava/lang/Object;)V

    :goto_1
    return-void
.end method
