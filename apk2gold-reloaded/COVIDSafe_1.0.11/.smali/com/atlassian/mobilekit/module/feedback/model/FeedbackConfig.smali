.class public final Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;
.super Ljava/lang/Object;
.source "FeedbackConfig.java"


# instance fields
.field private final apiKey:Ljava/lang/String;

.field private final components:[Ljava/lang/String;

.field private final host:Ljava/lang/String;

.field private final projectKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->host:Ljava/lang/String;

    .line 13
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->apiKey:Ljava/lang/String;

    .line 14
    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->projectKey:Ljava/lang/String;

    .line 15
    iput-object p4, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->components:[Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getApiKey()Ljava/lang/String;
    .locals 1

    .line 23
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->apiKey:Ljava/lang/String;

    return-object v0
.end method

.method public getComponents()[Ljava/lang/String;
    .locals 1

    .line 31
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->components:[Ljava/lang/String;

    return-object v0
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .line 19
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->host:Ljava/lang/String;

    return-object v0
.end method

.method public getProjectKey()Ljava/lang/String;
    .locals 1

    .line 27
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/model/FeedbackConfig;->projectKey:Ljava/lang/String;

    return-object v0
.end method
