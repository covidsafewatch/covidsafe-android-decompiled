.class public Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
.super Ljava/lang/Object;
.source "CreateIssueRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private appId:Ljava/lang/String;

.field private appName:Ljava/lang/String;

.field private appVersion:Ljava/lang/String;

.field private components:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private description:Ljava/lang/String;

.field private deviceName:Ljava/lang/String;

.field private isCrash:Z

.field private language:Ljava/lang/String;

.field private model:Ljava/lang/String;

.field private summary:Ljava/lang/String;

.field private systemName:Ljava/lang/String;

.field private systemVersion:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private udid:Ljava/lang/String;

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->type:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$100(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->summary:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$1000(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->systemName:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$1100(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->deviceName:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$1200(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->model:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$1300(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->language:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$1400(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/util/List;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->components:Ljava/util/List;

    return-object p0
.end method

.method static synthetic access$200(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$300(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Z
    .locals 0

    .line 16
    iget-boolean p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->isCrash:Z

    return p0
.end method

.method static synthetic access$400(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->udid:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$500(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->uuid:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$600(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appName:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$700(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appId:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$800(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appVersion:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic access$900(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)Ljava/lang/String;
    .locals 0

    .line 16
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->systemVersion:Ljava/lang/String;

    return-object p0
.end method


# virtual methods
.method public appId(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 86
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appId:Ljava/lang/String;

    return-object p0
.end method

.method public appName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 81
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appName:Ljava/lang/String;

    return-object p0
.end method

.method public appVersion(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 91
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->appVersion:Ljava/lang/String;

    return-object p0
.end method

.method public appendToDescription(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 2

    .line 57
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 58
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\n"

    .line 59
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 60
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description:Ljava/lang/String;

    :cond_0
    return-object p0
.end method

.method public build()Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;
    .locals 1

    .line 126
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;

    invoke-direct {v0, p0}, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest;-><init>(Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;)V

    return-object v0
.end method

.method public components(Ljava/util/List;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;"
        }
    .end annotation

    .line 121
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->components:Ljava/util/List;

    return-object p0
.end method

.method public description(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 52
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->description:Ljava/lang/String;

    return-object p0
.end method

.method public deviceName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 106
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->deviceName:Ljava/lang/String;

    return-object p0
.end method

.method public isCrash(Z)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 66
    iput-boolean p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->isCrash:Z

    return-object p0
.end method

.method public issueType(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 42
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->type:Ljava/lang/String;

    return-object p0
.end method

.method public language(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 116
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->language:Ljava/lang/String;

    return-object p0
.end method

.method public model(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 111
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->model:Ljava/lang/String;

    return-object p0
.end method

.method public summary(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 47
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->summary:Ljava/lang/String;

    return-object p0
.end method

.method public systemName(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 101
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->systemName:Ljava/lang/String;

    return-object p0
.end method

.method public systemVersion(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 96
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->systemVersion:Ljava/lang/String;

    return-object p0
.end method

.method public udid(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 71
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->udid:Ljava/lang/String;

    return-object p0
.end method

.method public uuid(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;
    .locals 0

    .line 76
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueRequest$Builder;->uuid:Ljava/lang/String;

    return-object p0
.end method
