.class public final Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;
.super Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;
.source "LoadFeedbackConfigCommand.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand<",
        "Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 17
    const-class v0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/atlassian/mobilekit/module/core/Receiver<",
            "Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;",
            ">;",
            "Lcom/atlassian/mobilekit/module/core/UiNotifier;",
            ")V"
        }
    .end annotation

    .line 23
    invoke-direct {p0, p2, p3}, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;-><init>(Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V

    .line 24
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    return-void
.end method

.method private errorCheck(Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;)Ljava/lang/String;
    .locals 2

    .line 49
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 51
    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 52
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_host:I

    invoke-direct {p0, v1}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->getConfigEmptyErrMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 53
    :cond_0
    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->isValidHost(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 54
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_host:I

    invoke-direct {p0, v1}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->getConfigInvalidErrMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 57
    :cond_1
    :goto_0
    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getApiKey()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 58
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_apikey:I

    invoke-direct {p0, v1}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->getConfigEmptyErrMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    :cond_2
    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->getProjectKey()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-eqz p1, :cond_3

    .line 62
    sget p1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_projectkey:I

    invoke-direct {p0, p1}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->getConfigEmptyErrMsg(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 65
    :cond_3
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result p1

    if-lez p1, :cond_4

    .line 66
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_config_err_help:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_4
    const/4 p1, 0x0

    return-object p1
.end method

.method private getConfigEmptyErrMsg(I)Ljava/lang/String;
    .locals 4

    .line 74
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_no_config_property:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    .line 75
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object p1

    const/4 v3, 0x0

    aput-object p1, v2, v3

    .line 74
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private getConfigInvalidErrMsg(I)Ljava/lang/String;
    .locals 4

    .line 79
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_invalid_config_property:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    .line 80
    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, p1}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object p1

    const/4 v3, 0x0

    aput-object p1, v2, v3

    .line 79
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method private isValidHost(Ljava/lang/String;)Z
    .locals 4

    .line 85
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    return v1

    :cond_0
    const-string v0, "/"

    .line 89
    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_1

    return v1

    .line 94
    :cond_1
    :try_start_0
    new-instance v0, Ljava/net/URI;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "scheme://"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 95
    invoke-virtual {v0}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v2

    .line 96
    invoke-virtual {v0}, Ljava/net/URI;->getPort()I

    move-result v0

    .line 98
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    return v1

    .line 102
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 103
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v2, -0x1

    if-eq v0, v2, :cond_3

    const-string v2, ":"

    .line 106
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 109
    :cond_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    return p1

    :catch_0
    move-exception p1

    .line 112
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->LOG_TAG:Ljava/lang/String;

    const-string v2, "URI Validation Failed."

    invoke-static {v0, v2, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return v1
.end method


# virtual methods
.method public run()V
    .locals 6

    .line 31
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v2, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_host:I

    .line 32
    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v3, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_apikey:I

    .line 33
    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    sget v4, Lcom/atlassian/mobilekit/module/feedback/R$string;->mp_feedback_projectkey:I

    .line 34
    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->context:Landroid/content/Context;

    .line 35
    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/atlassian/mobilekit/module/feedback/R$array;->mp_feedback_components:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V

    .line 38
    invoke-direct {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->errorCheck(Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    .line 44
    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/commands/LoadFeedbackConfigCommand;->updateReceiver(Ljava/lang/Object;)V

    return-void

    .line 41
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
