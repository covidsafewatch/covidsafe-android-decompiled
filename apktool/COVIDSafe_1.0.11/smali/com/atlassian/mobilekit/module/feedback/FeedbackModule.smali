.class public final Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;
.super Ljava/lang/Object;
.source "FeedbackModule.java"


# static fields
.field private static final NAMESPACE:Ljava/lang/String; = "com.atlassian.mobilekit.module.feedback"

.field private static final STORE_NAME:Ljava/lang/String; = "com.atlassian.mobilekit.module.feedback.preferences"

.field private static activityTracker:Lcom/atlassian/mobilekit/module/core/UiInfo;

.field private static androidUiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

.field private static feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

.field private static jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 29
    new-instance v0, Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;

    invoke-direct {v0}, Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;-><init>()V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->androidUiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Ljava/lang/AssertionError;

    const-string v1, "Instances of this class are not allowed."

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(Ljava/lang/Object;)V

    throw v0
.end method

.method static getNotificationViewId()I
    .locals 1

    .line 81
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->getNotificationViewId()I

    move-result v0

    return v0
.end method

.method public static init(Landroid/app/Application;)V
    .locals 9

    .line 43
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    if-nez v0, :cond_0

    .line 44
    new-instance v0, Lcom/atlassian/mobilekit/module/core/JobQueue;

    invoke-direct {v0}, Lcom/atlassian/mobilekit/module/core/JobQueue;-><init>()V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

    .line 45
    new-instance v0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;

    invoke-direct {v0, p0}, Lcom/atlassian/mobilekit/module/core/ActivityTracker;-><init>(Landroid/app/Application;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->activityTracker:Lcom/atlassian/mobilekit/module/core/UiInfo;

    const/4 v0, 0x0

    const-string v1, "com.atlassian.mobilekit.module.feedback.preferences"

    .line 47
    invoke-virtual {p0, v1, v0}, Landroid/app/Application;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 49
    new-instance v8, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    new-instance v2, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    invoke-direct {v2}, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;-><init>()V

    new-instance v3, Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 51
    invoke-virtual {p0}, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v3, v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;-><init>(Landroid/content/Context;)V

    sget-object v4, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

    sget-object v5, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->androidUiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    sget-object v6, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->activityTracker:Lcom/atlassian/mobilekit/module/core/UiInfo;

    new-instance v7, Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;

    invoke-direct {v7, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;-><init>(Landroid/content/SharedPreferences;)V

    move-object v1, v8

    invoke-direct/range {v1 .. v7}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;-><init>(Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;Lcom/atlassian/mobilekit/module/core/DeviceInfo;Lcom/atlassian/mobilekit/module/core/JobQueue;Lcom/atlassian/mobilekit/module/core/UiNotifier;Lcom/atlassian/mobilekit/module/core/UiInfo;Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;)V

    sput-object v8, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    .line 58
    :cond_0
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;

    .line 59
    invoke-virtual {p0}, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;

    move-result-object p0

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    sget-object v2, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->androidUiNotifier:Lcom/atlassian/mobilekit/module/core/UiNotifier;

    invoke-direct {v0, p0, v1, v2}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;-><init>(Landroid/content/Context;Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V

    .line 62
    sget-object p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->jobQueue:Lcom/atlassian/mobilekit/module/core/JobQueue;

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/core/JobQueue;->enqueue(Ljava/lang/Runnable;)V

    return-void
.end method

.method static notificationDismissed()V
    .locals 1

    .line 77
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationDismissed()V

    return-void
.end method

.method static notificationStarted()V
    .locals 1

    .line 73
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notificationStarted()V

    return-void
.end method

.method static notifySendCompleted(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V
    .locals 1

    .line 101
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->notifySendCompleted(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V

    return-void
.end method

.method static registerSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V
    .locals 1

    .line 93
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->registerSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V

    return-void
.end method

.method static sendFeedback(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .line 85
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0, p0, p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedback(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static setEnableDialogDisplayed()V
    .locals 1

    .line 89
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->setEnableDialogDisplayed()V

    return-void
.end method

.method public static showFeedbackScreen()V
    .locals 1

    .line 69
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->showFeedback()V

    return-void
.end method

.method static unregisterSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V
    .locals 1

    .line 97
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->feedbackClient:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-virtual {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->unregisterSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V

    return-void
.end method
