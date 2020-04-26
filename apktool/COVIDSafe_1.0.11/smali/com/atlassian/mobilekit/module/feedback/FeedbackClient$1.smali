.class Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;
.super Ljava/lang/Object;
.source "FeedbackClient.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->sendFeedback(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

.field final synthetic val$email:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Ljava/lang/String;)V
    .locals 0

    .line 108
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->val$email:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAdditionalDescription()Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public getCustomFieldsData()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 121
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 122
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->val$email:Ljava/lang/String;

    const-string v2, "E-mail"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-static {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->access$000(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;)Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getSystemVersion()Ljava/lang/String;

    move-result-object v1

    const-string v2, "OS version"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-static {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->access$000(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;)Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getAppVersionName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "App version"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 125
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    invoke-static {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->access$000(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;)Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->getModel()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Phone model"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-object v0
.end method

.method public getIssueType()Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;
    .locals 1

    .line 116
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->SUPPORT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    return-object v0
.end method
