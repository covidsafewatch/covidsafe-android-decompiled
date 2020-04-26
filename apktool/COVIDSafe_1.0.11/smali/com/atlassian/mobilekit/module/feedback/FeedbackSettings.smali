.class Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;
.super Ljava/lang/Object;
.source "FeedbackSettings.java"


# static fields
.field private static final KEY_ENABLE_DIALOG_SHOWN:Ljava/lang/String; = "enable_dialog_shown"


# instance fields
.field private final store:Landroid/content/SharedPreferences;


# direct methods
.method constructor <init>(Landroid/content/SharedPreferences;)V
    .locals 0

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;->store:Landroid/content/SharedPreferences;

    return-void
.end method


# virtual methods
.method final setEnableDialogDisplayed()V
    .locals 3

    .line 16
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackSettings;->store:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "enable_dialog_shown"

    const/4 v2, 0x1

    .line 17
    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 18
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method
