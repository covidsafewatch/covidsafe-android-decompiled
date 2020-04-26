.class Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;
.super Ljava/lang/Object;
.source "FeedbackActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->showKeyboard()V
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

    .line 212
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 215
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    if-eqz v0, :cond_0

    .line 217
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-static {v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->access$200(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    :cond_0
    return-void
.end method
