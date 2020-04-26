.class public final Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;
.super Ljava/lang/Object;
.source "CreateIssueRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    }
.end annotation


# static fields
.field private static final MAX_SUMMARY_LENGTH:I = 0xf0


# instance fields
.field private final appId:Ljava/lang/String;

.field private final appName:Ljava/lang/String;

.field private final appVersion:Ljava/lang/String;

.field private final components:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final description:Ljava/lang/String;

.field private final devName:Ljava/lang/String;

.field private final isCrash:Z

.field private final language:Ljava/lang/String;

.field private final model:Ljava/lang/String;

.field private final summary:Ljava/lang/String;

.field private final systemName:Ljava/lang/String;

.field private final systemVersion:Ljava/lang/String;

.field private final type:Ljava/lang/String;

.field private final udid:Ljava/lang/String;

.field private final uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)V
    .locals 2

    .line 156
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 157
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$000(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->type:Ljava/lang/String;

    .line 158
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$100(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0xf0

    invoke-static {v0, v1}, Lcom/atlassian/mobilekit/module/core/utils/StringUtils;->ellipsize(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->summary:Ljava/lang/String;

    .line 159
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$200(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->description:Ljava/lang/String;

    .line 160
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$300(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->isCrash:Z

    .line 161
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$400(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->udid:Ljava/lang/String;

    .line 162
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$500(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->uuid:Ljava/lang/String;

    .line 163
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$600(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appName:Ljava/lang/String;

    .line 164
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$700(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appId:Ljava/lang/String;

    .line 165
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$800(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appVersion:Ljava/lang/String;

    .line 166
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$900(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->systemVersion:Ljava/lang/String;

    .line 167
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$1000(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->systemName:Ljava/lang/String;

    .line 168
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$1100(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->devName:Ljava/lang/String;

    .line 169
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$1200(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->model:Ljava/lang/String;

    .line 170
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$1300(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->language:Ljava/lang/String;

    .line 171
    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->access$1400(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->components:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getAppId()Ljava/lang/String;
    .locals 1

    .line 203
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getAppName()Ljava/lang/String;
    .locals 1

    .line 199
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appName:Ljava/lang/String;

    return-object v0
.end method

.method public getAppVersion()Ljava/lang/String;
    .locals 1

    .line 207
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->appVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getComponents()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 231
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->components:Ljava/util/List;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .line 183
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .line 219
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->devName:Ljava/lang/String;

    return-object v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .line 227
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->language:Ljava/lang/String;

    return-object v0
.end method

.method public getModel()Ljava/lang/String;
    .locals 1

    .line 223
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->model:Ljava/lang/String;

    return-object v0
.end method

.method public getSummary()Ljava/lang/String;
    .locals 1

    .line 179
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->summary:Ljava/lang/String;

    return-object v0
.end method

.method public getSystemName()Ljava/lang/String;
    .locals 1

    .line 215
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->systemName:Ljava/lang/String;

    return-object v0
.end method

.method public getSystemVersion()Ljava/lang/String;
    .locals 1

    .line 211
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->systemVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 175
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUdid()Ljava/lang/String;
    .locals 1

    .line 191
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->udid:Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .line 195
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public isCrash()Z
    .locals 1

    .line 187
    iget-boolean v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;->isCrash:Z

    return v0
.end method
