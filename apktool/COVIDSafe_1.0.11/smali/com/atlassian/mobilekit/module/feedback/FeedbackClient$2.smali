.class Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;
.super Ljava/lang/Object;
.source "FeedbackClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->showFeedback()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

.field final synthetic val$appCtx:Landroid/content/Context;

.field final synthetic val$curActivity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Landroid/app/Activity;Landroid/content/Context;)V
    .locals 0

    .line 161
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->val$curActivity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->val$appCtx:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 164
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->val$curActivity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient$2;->val$appCtx:Landroid/content/Context;

    invoke-static {v0, v1, v2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;->access$100(Lcom/atlassian/mobilekit/module/feedback/FeedbackClient;Landroid/app/Activity;Landroid/content/Context;)V

    return-void
.end method
