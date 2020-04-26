.class public final enum Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;
.super Ljava/lang/Enum;
.source "JiraIssueType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum BUG:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum EPIC:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum IMPROVEMENT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum STORY:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum SUPPORT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

.field public static final enum TASK:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;


# instance fields
.field private type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .line 5
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v1, 0x0

    const-string v2, "BUG"

    const-string v3, "Bug"

    invoke-direct {v0, v2, v1, v3}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->BUG:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 6
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v2, 0x1

    const-string v3, "EPIC"

    const-string v4, "Epic"

    invoke-direct {v0, v3, v2, v4}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->EPIC:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 7
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v3, 0x2

    const-string v4, "IMPROVEMENT"

    const-string v5, "Improvement"

    invoke-direct {v0, v4, v3, v5}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->IMPROVEMENT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 8
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v4, 0x3

    const-string v5, "STORY"

    const-string v6, "Story"

    invoke-direct {v0, v5, v4, v6}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->STORY:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 9
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v5, 0x4

    const-string v6, "SUPPORT"

    const-string v7, "Support"

    invoke-direct {v0, v6, v5, v7}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->SUPPORT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 10
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v6, 0x5

    const-string v7, "TASK"

    const-string v8, "Task"

    invoke-direct {v0, v7, v6, v8}, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->TASK:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    const/4 v7, 0x6

    new-array v7, v7, [Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    .line 3
    sget-object v8, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->BUG:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    aput-object v8, v7, v1

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->EPIC:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    aput-object v1, v7, v2

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->IMPROVEMENT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    aput-object v1, v7, v3

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->STORY:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    aput-object v1, v7, v4

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->SUPPORT:Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    aput-object v1, v7, v5

    aput-object v0, v7, v6

    sput-object v7, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->$VALUES:[Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 15
    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->type:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;
    .locals 1

    .line 3
    const-class v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    return-object p0
.end method

.method public static values()[Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;
    .locals 1

    .line 3
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->$VALUES:[Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    invoke-virtual {v0}, [Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .line 20
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;->type:Ljava/lang/String;

    return-object v0
.end method
