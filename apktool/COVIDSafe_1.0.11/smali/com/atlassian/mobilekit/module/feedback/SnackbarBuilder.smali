.class public Lcom/atlassian/mobilekit/module/feedback/SnackbarBuilder;
.super Ljava/lang/Object;
.source "SnackbarBuilder.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static applyColorSpan(Ljava/lang/String;)Landroid/text/SpannableStringBuilder;
    .locals 4

    .line 27
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    .line 28
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, p0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 29
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result p0

    const/4 v2, 0x0

    const/16 v3, 0x12

    invoke-virtual {v1, v0, v2, p0, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    return-object v1
.end method

.method public static build(Landroid/app/Activity;I)Lcom/google/android/material/snackbar/Snackbar;
    .locals 1

    .line 20
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarBuilder;->getNotificationView(Landroid/app/Activity;)Landroid/view/View;

    move-result-object v0

    .line 21
    invoke-virtual {p0, p1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/SnackbarBuilder;->applyColorSpan(Ljava/lang/String;)Landroid/text/SpannableStringBuilder;

    move-result-object p0

    const/4 p1, 0x0

    .line 20
    invoke-static {v0, p0, p1}, Lcom/google/android/material/snackbar/Snackbar;->make(Landroid/view/View;Ljava/lang/CharSequence;I)Lcom/google/android/material/snackbar/Snackbar;

    move-result-object p0

    return-object p0
.end method

.method private static getNotificationView(Landroid/app/Activity;)Landroid/view/View;
    .locals 2

    .line 34
    invoke-static {}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->getNotificationViewId()I

    move-result v0

    const v1, 0x1020002

    if-nez v0, :cond_0

    move v0, v1

    .line 39
    :cond_0
    invoke-virtual {p0, v0}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1

    .line 41
    invoke-virtual {p0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    :cond_1
    return-object v0
.end method
