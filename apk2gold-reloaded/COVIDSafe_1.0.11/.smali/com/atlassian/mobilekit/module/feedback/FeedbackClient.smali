.class Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;
.super Ljava/lang/Object;
.source "FeedbackClient.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/core/Receiver;
.implements Lcom/atlassian/mobilekit/module/core/UiInfoListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/atlassian/mobilekit/module/core/Receiver<",
        "Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;",
        ">;",
        "Lcom/atlassian/mobilekit/module/core/UiInfoListener;"
    }
.end annotation


# static fields
.field private static final IGNORE_ACTIVITIES:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/Class<",
            "*>;>;"
        }
    .end annotation
.end field

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final PROTOCOL_HTTPS:Ljava/lang/String; = "https://"


# instance fields
.field private final baseQueryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

.field private feedbackConfig:Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;

.field private feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

.field private final jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

.field private final notificationListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Lcom/atlassian/mobilekit/module/feedback/FeedbackNotificationListener;",
            ">;"
        }
    .end annotation
.end field

.field private final notificationViewId:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

.field private final sendFeedbackListeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;",
            ">;"
        }
    .end annotation
.end field

.field private final settings:Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;

.field private final uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

.field private final uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 39
    const-class v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->LOG_TAG:Ljava/lang/String;

    .line 42
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->IGNORE_ACTIVITIES:Ljava/util/Set;

    .line 45
    const-class v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;Lcom/atlassian/mobilekit/module/core/DeviceInfo;Lcom/atlassian/mobilekit/module/core/JobQueue;Lcom/atlassian/mobilekit/module/core/UiNotifier;Lcom/atlassian/mobilekit/module/core/UiInfo;Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;)V
    .locals 2

    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->baseQueryMap:Ljava/util/Map;

    .line 55
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationViewId:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 56
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 57
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedbackListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 69
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    .line 70
    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

    .line 71
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 72
    iput-object p4, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    .line 73
    iput-object p5, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    .line 74
    iput-object p6, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->settings:Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;

    .line 76
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->init()V

    return-void
.end method

.method static synthetic access$000(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;)Lcom/atlassian/mobilekit/module/core/DeviceInfo;
    .locals 0

    .line 37
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    return-object p0
.end method

.method static synthetic access$100(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Landroid/app/Activity;Landroid/content/Context;)V
    .locals 0

    .line 37
    invoke-direct {p0, p1, p2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->launchFeedbackScreen(Landroid/app/Activity;Landroid/content/Context;)V

    return-void
.end method

.method private init()V
    .locals 1

    .line 80
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    invoke-interface {v0, p0}, Lcom/atlassian/mobilekit/module/core/UiInfo;->registerListener(Lcom/atlassian/mobilekit/module/core/UiInfoListener;)V

    return-void
.end method

.method private launchFeedbackScreen(Landroid/app/Activity;Landroid/content/Context;)V
    .locals 1

    .line 170
    invoke-virtual {p1}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Landroid/app/Activity;->isChangingConfigurations()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move-object p1, p2

    .line 173
    :cond_1
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object p2

    .line 174
    invoke-virtual {p1, p2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private setFeedbackDataProvider(Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;)V
    .locals 0

    .line 178
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    return-void
.end method


# virtual methods
.method final getNotificationViewId()I
    .locals 1

    .line 182
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationViewId:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    return v0
.end method

.method final notificationDismissed()V
    .locals 2

    .line 206
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackNotificationListener;

    .line 207
    invoke-interface {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackNotificationListener;->onNotificationDismissed()V

    goto :goto_0

    :cond_0
    return-void
.end method

.method final notificationStarted()V
    .locals 2

    .line 200
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackNotificationListener;

    .line 201
    invoke-interface {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackNotificationListener;->onNotificationStarted()V

    goto :goto_0

    :cond_0
    return-void
.end method

.method final notifySendCompleted(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V
    .locals 2

    .line 194
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedbackListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;

    .line 195
    invoke-interface {v1, p1}, Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;->onSendCompleted(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method public onAppNotVisible()V
    .locals 0

    return-void
.end method

.method public onAppVisible()V
    .locals 0

    return-void
.end method

.method public receive(Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;)V
    .locals 3

    .line 85
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->feedbackConfig:Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;

    .line 86
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getHost()Ljava/lang/String;

    move-result-object v1

    const-string v2, "https://"

    invoke-virtual {v0, v2, v1}, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;->init(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->baseQueryMap:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getApiKey()Ljava/lang/String;

    move-result-object v1

    const-string v2, "apikey"

    invoke-interface {v0, v2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->baseQueryMap:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getProjectKey()Ljava/lang/String;

    move-result-object p1

    const-string v1, "project"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public bridge synthetic receive(Ljava/lang/Object;)V
    .locals 0

    .line 37
    check-cast p1, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;

    invoke-virtual {p0, p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->receive(Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;)V

    return-void
.end method

.method final registerSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V
    .locals 1

    .line 186
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedbackListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method final sendFeedback(Ljava/lang/String;Ljava/lang/String;)V
    .locals 9

    .line 94
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    invoke-direct {v0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;-><init>()V

    .line 96
    invoke-virtual {v0, p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->summary(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    .line 97
    invoke-virtual {v0, p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    const/4 v1, 0x0

    .line 98
    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->isCrash(Z)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 99
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getUdid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->udid(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 100
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->uuid(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 101
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getAppName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 102
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getAppPkgName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appId(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 103
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getSystemName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->systemName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 104
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getDeviceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->deviceName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 105
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->language(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->feedbackConfig:Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;

    .line 106
    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getComponents()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->components(Ljava/util/List;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    move-result-object v4

    .line 108
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;

    invoke-direct {v0, p0, p2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->setFeedbackDataProvider(Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;)V

    .line 130
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;

    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->baseQueryMap:Ljava/util/Map;

    iget-object v5, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    iget-object v6, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    new-instance v7, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    invoke-direct {v7, v1, v2, p1, p2}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;-><init>(Lcom/atlassian/mobilekit/module/core/UiInfo;Lcom/atlassian/mobilekit/module/core/UiNotifier;Ljava/lang/String;Ljava/lang/String;)V

    iget-object v8, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    move-object v2, v0

    invoke-direct/range {v2 .. v8}, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;-><init>(Ljava/util/Map;Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V

    .line 136
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

    invoke-virtual {p1, v0}, Lcom/atlassian/mobilekit/module/core/JobQueue;->enqueue(Ljava/lang/Runnable;)V

    return-void
.end method

.method final setEnableDialogDisplayed()V
    .locals 1

    .line 212
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->settings:Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;->setEnableDialogDisplayed()V

    return-void
.end method

.method final showFeedback()V
    .locals 4

    .line 150
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiInfo:Lcom/atlassian/mobilekit/module/core/UiInfo;

    invoke-interface {v0}, Lcom/atlassian/mobilekit/module/core/UiInfo;->getCurrentActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 152
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->LOG_TAG:Ljava/lang/String;

    const-string v1, "No usable current activity. Abort Feedback."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 154
    :cond_0
    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->IGNORE_ACTIVITIES:Ljava/util/Set;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 155
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->LOG_TAG:Ljava/lang/String;

    const-string v1, "User is already in Feedback flow. Abort."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 159
    :cond_1
    invoke-virtual {v0}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 161
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->uiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    new-instance v3, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;

    invoke-direct {v3, p0, v0, v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Landroid/app/Activity;Landroid/content/Context;)V

    invoke-interface {v2, v3}, Lcom/atlassian/mobilekit/module/core/UiNotifier;->post(Ljava/lang/Runnable;)V

    return-void
.end method

.method final unregisterSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V
    .locals 1

    .line 190
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedbackListeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    return-void
.end method
