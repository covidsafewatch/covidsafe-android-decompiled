.class Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;
.super Ljava/lang/Object;
.source "SnackbarReceiver.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$callback:Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;

.field final synthetic val$snackbar:Lcom/google/android/material/snackbar/Snackbar;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;Lcom/google/android/material/snackbar/Snackbar;Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;Landroid/app/Activity;)V
    .locals 0

    .line 87
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;

    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$snackbar:Lcom/google/android/material/snackbar/Snackbar;

    iput-object p3, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$callback:Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;

    iput-object p4, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .line 90
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;

    iget-object p1, p1, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->access$200(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Ljava/lang/String;

    move-result-object p1

    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;

    iget-object v0, v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;

    invoke-static {v0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->access$300(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->sendFeedback(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$snackbar:Lcom/google/android/material/snackbar/Snackbar;

    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$callback:Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;

    invoke-virtual {p1, v0}, Lcom/google/android/material/snackbar/Snackbar;->removeCallback(Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;)Lcom/google/android/material/snackbar/BaseTransientBottomBar;

    .line 94
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$1$1;->val$activity:Landroid/app/Activity;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->access$400(Landroid/app/Activity;)V

    .line 97
    invoke-static {}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->notificationDismissed()V

    return-void
.end method
