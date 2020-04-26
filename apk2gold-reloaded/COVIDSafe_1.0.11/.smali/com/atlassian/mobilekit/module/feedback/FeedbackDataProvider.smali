.class public interface abstract Lcom/atlassian/mobilekit/module/feedback/FeedbackDataProvider;
.super Ljava/lang/Object;
.source "FeedbackDataProvider.java"


# virtual methods
.method public abstract getAdditionalDescription()Ljava/lang/String;
.end method

.method public abstract getCustomFieldsData()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getIssueType()Lcom/atlassian/mobilekit/module/feedback/JiraIssueType;
.end method
