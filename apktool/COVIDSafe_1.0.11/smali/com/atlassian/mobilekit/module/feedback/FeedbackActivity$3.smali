.class Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$3;
.super Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;
.source "FeedbackActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V
    .locals 1

    .line 73
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$3;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;)V

    return-void
.end method


# virtual methods
.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .line 76
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$3;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->access$100(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    return-void
.end method
