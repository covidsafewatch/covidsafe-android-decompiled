.class abstract Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;
.super Ljava/lang/Object;
.source "FeedbackActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "TextWatcherAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;


# direct methods
.method private constructor <init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V
    .locals 0

    .line 223
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;->this$0:Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;)V
    .locals 0

    .line 223
    invoke-direct {p0, p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method
