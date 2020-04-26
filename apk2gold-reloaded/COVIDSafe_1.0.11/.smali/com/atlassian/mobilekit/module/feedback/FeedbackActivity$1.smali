.class Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;
.super Ljava/lang/Object;
.source "FeedbackActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .locals 0

    .line 58
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0

    .line 61
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-virtual {p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->finish()V

    return-void
.end method
