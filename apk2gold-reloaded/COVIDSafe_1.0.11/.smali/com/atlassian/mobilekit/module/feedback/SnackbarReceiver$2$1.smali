.class Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2$1;
.super Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;
.source "SnackbarReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;

.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;Landroid/app/Activity;)V
    .locals 0

    .line 134
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2$1;->this$1:Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2;

    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2$1;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V
    .locals 0

    .line 137
    invoke-super {p0, p1, p2}, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;->onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V

    .line 138
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2$1;->val$activity:Landroid/app/Activity;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;->access$600(Landroid/app/Activity;)V

    return-void
.end method

.method public bridge synthetic onDismissed(Ljava/lang/Object;I)V
    .locals 0

    .line 134
    check-cast p1, Lcom/google/android/material/snackbar/Snackbar;

    invoke-virtual {p0, p1, p2}, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$2$1;->onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V

    return-void
.end method
