.class public final Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;
.super Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;
.source "SendFeedbackCommand.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand<",
        "Lcom/atlassian/mobilekit/module/feedback/commands/Result;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

.field private final queryMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final requestBuilder:Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

.field private final restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 30
    const-class v0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/util/Map;Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;",
            "Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;",
            "Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;",
            "Lcom/atlassian/mobilekit/module/core/Receiver<",
            "Lcom/atlassian/mobilekit/module/feedback/commands/Result;",
            ">;",
            "Lcom/atlassian/mobilekit/module/core/UiNotifier;",
            ")V"
        }
    .end annotation

    .line 45
    invoke-direct {p0, p5, p6}, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;-><init>(Lcom/atlassian/mobilekit/module/core/Receiver;Lcom/atlassian/mobilekit/module/core/UiNotifier;)V

    .line 46
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->queryMap:Ljava/util/Map;

    .line 47
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->requestBuilder:Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    .line 48
    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    .line 49
    iput-object p4, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .line 55
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->TASK:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 57
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 58
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    if-eqz v2, :cond_2

    .line 59
    invoke-interface {v2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;->getAdditionalDescription()Ljava/lang/String;

    move-result-object v2

    .line 60
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 61
    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->requestBuilder:Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    invoke-virtual {v3, v2}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appendToDescription(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    .line 64
    :cond_0
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    invoke-interface {v2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;->getIssueType()Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    move-result-object v2

    if-eqz v2, :cond_1

    move-object v0, v2

    .line 69
    :cond_1
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->feedbackDataProvider:Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;

    invoke-interface {v2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;->getCustomFieldsData()Ljava/util/Map;

    move-result-object v2

    if-eqz v2, :cond_2

    const-string v3, "application/json"

    .line 72
    invoke-static {v3}, Lokhttp3/MediaType;->parse(Ljava/lang/String;)Lokhttp3/MediaType;

    move-result-object v3

    new-instance v4, Lcom/google/gson/Gson;

    invoke-direct {v4}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v4, v2}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lokhttp3/RequestBody;->create(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;

    move-result-object v2

    const-string v3, "customfields"

    const-string v4, "customfields.json"

    .line 75
    invoke-static {v3, v4, v2}, Lokhttp3/MultipartBody$Part;->createFormData(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Part;

    move-result-object v2

    .line 76
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 80
    :cond_2
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->requestBuilder:Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->issueType(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    .line 82
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->requestBuilder:Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->build()Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;

    move-result-object v0

    .line 84
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->restClient:Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;

    invoke-virtual {v2}, Lcom/atlassian/mobilekit/module/feedback/network/JmcRestClient;->getJmcApi()Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;

    move-result-object v2

    iget-object v3, p0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->queryMap:Ljava/util/Map;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v4

    invoke-interface {v2, v3, v0, v4, v1}, Lcom/atlassian/mobilekit/module/feedback/network/JmcApi;->createIssue(Ljava/util/Map;Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;Ljava/util/List;Ljava/util/List;)Lretrofit2/Call;

    move-result-object v0

    .line 86
    :try_start_0
    invoke-interface {v0}, Lretrofit2/Call;->execute()Lretrofit2/Response;

    move-result-object v0

    .line 87
    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Response code %1$d\nmessage %2$s\nbody %3$s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    .line 88
    invoke-virtual {v0}, Lretrofit2/Response;->code()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-virtual {v0}, Lretrofit2/Response;->message()Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x1

    aput-object v4, v3, v6

    const/4 v4, 0x2

    invoke-virtual {v0}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v3, v4

    .line 87
    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    invoke-virtual {v0}, Lretrofit2/Response;->isSuccessful()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 91
    invoke-virtual {v0}, Lretrofit2/Response;->body()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;

    if-nez v0, :cond_3

    .line 93
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Bad api response. Empty body."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 94
    :cond_3
    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->getKey()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 95
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Bad api response. Missing Issue Key."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 97
    :cond_4
    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    const-string v2, "New Issue Created %s"

    new-array v3, v6, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->getKey()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 98
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->updateReceiver(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 103
    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Failed to create new issue."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 106
    :cond_5
    :goto_0
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->FAIL:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/commands/SendFeedbackCommand;->updateReceiver(Ljava/lang/Object;)V

    return-void
.end method
