.class public Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;
.super Lcom/google/android/material/snackbar/Snackbar$Callback;
.source "SnackbarCallback.java"


# instance fields
.field private isDismissed:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 6
    invoke-direct {p0}, Lcom/google/android/material/snackbar/Snackbar$Callback;-><init>()V

    const/4 v0, 0x0

    .line 10
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;->isDismissed:Z

    return-void
.end method


# virtual methods
.method public onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V
    .locals 0

    .line 14
    invoke-super {p0, p1, p2}, Lcom/google/android/material/snackbar/Snackbar$Callback;->onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V

    .line 15
    iget-boolean p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;->isDismissed:Z

    if-eqz p1, :cond_0

    return-void

    :cond_0
    const/4 p1, 0x1

    .line 18
    iput-boolean p1, p0, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;->isDismissed:Z

    .line 19
    invoke-static {}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->notificationDismissed()V

    return-void
.end method

.method public bridge synthetic onDismissed(Ljava/lang/Object;I)V
    .locals 0

    .line 6
    check-cast p1, Lcom/google/android/material/snackbar/Snackbar;

    invoke-virtual {p0, p1, p2}, Lcom/atlassian/mobilekit/module/feedback/SnackbarCallback;->onDismissed(Lcom/google/android/material/snackbar/Snackbar;I)V

    return-void
.end method
