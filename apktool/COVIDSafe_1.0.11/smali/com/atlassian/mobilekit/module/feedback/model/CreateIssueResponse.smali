.class public final Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;
.super Ljava/lang/Object;
.source "CreateIssueResponse.java"


# instance fields
.field private comments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private dateCreated:J

.field private dateUpdated:J

.field private description:Ljava/lang/String;

.field private hasUpdates:Z

.field private key:Ljava/lang/String;

.field private status:Ljava/lang/String;

.field private summary:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getComments()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 50
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->comments:Ljava/util/List;

    return-object v0
.end method

.method public getDateCreated()J
    .locals 2

    .line 42
    iget-wide v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->dateCreated:J

    return-wide v0
.end method

.method public getDateUpdated()J
    .locals 2

    .line 38
    iget-wide v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->dateUpdated:J

    return-wide v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .line 34
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .line 22
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getStatus()Ljava/lang/String;
    .locals 1

    .line 26
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->status:Ljava/lang/String;

    return-object v0
.end method

.method public getSummary()Ljava/lang/String;
    .locals 1

    .line 30
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->summary:Ljava/lang/String;

    return-object v0
.end method

.method public hasUpdates()Z
    .locals 1

    .line 46
    iget-boolean v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/CreateIssueResponse;->hasUpdates:Z

    return v0
.end method
