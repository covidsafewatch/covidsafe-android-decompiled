.class public Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;
.super Ljava/lang/Object;
.source "SnackbarReceiver.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/core/UiReceiver;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/atlassian/mobilekit/module/core/UiReceiver<",
        "Lcom/atlassian/mobilekit/module/feedback/commands/Result;",
        ">;"
    }
.end annotation


# instance fields
.field private final email:Ljava/lang/String;

.field private final message:Ljava/lang/String;

.field private final showFailureRunnable:Ljava/lang/Runnable;

.field private final showSuccessRunnable:Ljava/lang/Runnable;

.field private final uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

.field private final uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/core/UiInfo;Lcom/atlassian/mobilekit/module/core/UiNotifier;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;

    invoke-direct {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;-><init>(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->showFailureRunnable:Ljava/lang/Runnable;

    .line 109
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;

    invoke-direct {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;-><init>(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->showSuccessRunnable:Ljava/lang/Runnable;

    .line 23
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    .line 24
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    .line 25
    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->message:Ljava/lang/String;

    .line 26
    iput-object p4, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->email:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Lcom/atlassian/mobilekit/module/core/UiInfo;
    .locals 0

    .line 14
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    return-object p0
.end method

.method static synthetic access$100(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Lcom/atlassian/mobilekit/module/core/UiNotifier;
    .locals 0

    .line 14
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    return-object p0
.end method

.method static synthetic access$200(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Ljava/lang/String;
    .locals 0

    .line 14
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->message:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$300(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Ljava/lang/String;
    .locals 0

    .line 14
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->email:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$400(Landroid/app/Activity;)V
    .locals 0

    .line 14
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->showProgressBar(Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic access$500(Landroid/app/Activity;)V
    .locals 0

    .line 14
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->dismissProgressBar(Landroid/app/Activity;)V

    return-void
.end method

.method static synthetic access$600(Landroid/app/Activity;)V
    .locals 0

    .line 14
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->doFinish(Landroid/app/Activity;)V

    return-void
.end method

.method private static dismissProgressBar(Landroid/app/Activity;)V
    .locals 1

    .line 49
    instance-of v0, p0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;

    if-eqz v0, :cond_0

    .line 50
    check-cast p0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;

    invoke-interface {p0}, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;->dismissProgressDialog()V

    :cond_0
    return-void
.end method

.method private static doFinish(Landroid/app/Activity;)V
    .locals 1

    .line 55
    instance-of v0, p0, Lcom/atlassian/mobilekit/module/feedback/FinishAction;

    if-eqz v0, :cond_0

    .line 56
    check-cast p0, Lcom/atlassian/mobilekit/module/feedback/FinishAction;

    invoke-interface {p0}, Lcom/atlassian/mobilekit/module/feedback/FinishAction;->doFinish()V

    :cond_0
    return-void
.end method

.method private static showProgressBar(Landroid/app/Activity;)V
    .locals 1

    .line 43
    instance-of v0, p0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;

    if-eqz v0, :cond_0

    .line 44
    check-cast p0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;

    invoke-interface {p0}, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;->showProgressDialog()V

    :cond_0
    return-void
.end method


# virtual methods
.method public receive(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V
    .locals 1

    .line 31
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$3;->$SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result:[I

    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    goto :goto_0

    .line 37
    :cond_0
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->showFailureRunnable:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    goto :goto_0

    .line 33
    :cond_1
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->showSuccessRunnable:Ljava/lang/Runnable;

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    :goto_0
    return-void
.end method

.method public bridge synthetic receive(Ljava/lang/Object;)V
    .locals 0

    .line 14
    check-cast p1, Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {p0, p1}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->receive(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V

    return-void
.end method
