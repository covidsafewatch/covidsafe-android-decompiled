.class public Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "FeedbackActivity.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/feedback/ProgressDialogActions;
.implements Lcom/atlassian/mobilekit/module/feedback/FinishAction;
.implements Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$TextWatcherAdapter;
    }
.end annotation


# instance fields
.field private deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

.field private feedbackEmailEt:Landroid/widget/EditText;

.field private feedbackEt:Landroid/widget/EditText;

.field private sendMenuItem:Landroid/view/MenuItem;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 29
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    const/4 v0, 0x0

    .line 34
    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    .line 35
    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    return-void
.end method

.method static synthetic access$100(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V
    .locals 0

    .line 29
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->updateSendButtonState()V

    return-void
.end method

.method static synthetic access$200(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)Landroid/widget/EditText;
    .locals 0

    .line 29
    iget-object p0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    return-object p0
.end method

.method private focusOnFeedbackEditText()V
    .locals 1

    .line 184
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 185
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->showKeyboard()V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2

    .line 38
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 39
    instance-of p0, p0, Landroid/app/Activity;

    if-nez p0, :cond_0

    const/high16 p0, 0x10000000

    .line 40
    invoke-virtual {v0, p0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    :cond_0
    return-object v0
.end method

.method private sendFeedback(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .line 189
    invoke-static {p1, p2}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->sendFeedback(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->showProgressDialog()V

    return-void
.end method

.method private showKeyboard()V
    .locals 4

    .line 212
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$4;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/EditText;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method

.method private updateSendButtonState()V
    .locals 2

    .line 156
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 157
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEmailEt:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 158
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/util/Patterns;->EMAIL_ADDRESS:Ljava/util/regex/Pattern;

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    goto :goto_0

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    :goto_0
    return-void
.end method


# virtual methods
.method public dismissProgressDialog()V
    .locals 2

    .line 171
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v0

    const-class v1, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 172
    instance-of v1, v0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;

    if-eqz v1, :cond_0

    .line 174
    check-cast v0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;

    invoke-virtual {v0}, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;->dismiss()V

    :cond_0
    return-void
.end method

.method public doFinish()V
    .locals 0

    .line 180
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->finish()V

    return-void
.end method

.method public synthetic lambda$onCreate$0$FeedbackActivity(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 0

    .line 80
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    invoke-virtual {p0, p1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    const/4 p1, 0x1

    return p1
.end method

.method public synthetic lambda$onCreate$1$FeedbackActivity(Landroid/view/View;)V
    .locals 0

    .line 89
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->focusOnFeedbackEditText()V

    return-void
.end method

.method public synthetic lambda$onCreate$2$FeedbackActivity(Landroid/view/View;)V
    .locals 0

    .line 98
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->focusOnFeedbackEditText()V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .line 47
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 49
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/view/Window;->clearFlags(I)V

    .line 50
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$layout;->activity_feedback:I

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->setContentView(I)V

    .line 51
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$id;->toolbar:I

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/Toolbar;

    .line 52
    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->setSupportActionBar(Landroidx/appcompat/widget/Toolbar;)V

    .line 53
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getSupportActionBar()Landroidx/appcompat/app/ActionBar;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v2, 0x1

    .line 55
    invoke-virtual {v1, v2}, Landroidx/appcompat/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 58
    :cond_0
    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$1;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/Toolbar;->setNavigationOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$id;->feedbackIssueDescriptionEditText:I

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    .line 66
    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$2;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$2;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 72
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$id;->feedbackIssueEmailEditText:I

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEmailEt:Landroid/widget/EditText;

    .line 73
    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$3;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity$3;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 79
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEmailEt:Landroid/widget/EditText;

    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$n9BRQ7VP1EZGezgk5-eI4paBm3U;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$n9BRQ7VP1EZGezgk5-eI4paBm3U;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 84
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$id;->feedback_content_parent:I

    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 86
    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$SSOzVdRe5qI6vYfGoQT_d6B3XtU;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$SSOzVdRe5qI6vYfGoQT_d6B3XtU;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_1
    const v0, 0x1020002

    .line 93
    invoke-virtual {p0, v0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 95
    new-instance v1, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$kpy8IgwOGLjqU4WUT0w120KImOk;

    invoke-direct {v1, p0}, Lcom/atlassian/mobilekit/module/feedback/-$$Lambda$FeedbackActivity$kpy8IgwOGLjqU4WUT0w120KImOk;-><init>(Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_2
    if-nez p1, :cond_3

    .line 103
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->focusOnFeedbackEditText()V

    .line 106
    :cond_3
    new-instance p1, Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p1, v0}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;-><init>(Landroid/content/Context;)V

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    .line 108
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->registerSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V

    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2

    .line 119
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$menu;->menu_feedback:I

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 120
    sget v0, Lcom/atlassian/mobilekit/module/feedback/R$id;->action_send:I

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object p1

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    const/4 v0, 0x0

    .line 121
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    const/4 p1, 0x1

    return p1
.end method

.method protected onDestroy()V
    .locals 0

    .line 113
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onDestroy()V

    .line 114
    invoke-static {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackModule;->unregisterSendFeedbackListener(Lcom/atlassian/mobilekit/module/feedback/SendFeedbackListener;)V

    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5

    .line 127
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 128
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->action_send:I

    if-ne v0, v1, :cond_4

    .line 129
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 130
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-eqz v1, :cond_0

    .line 131
    sget p1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_feedback_empty:I

    invoke-static {p0, p1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    return v3

    .line 135
    :cond_0
    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEmailEt:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 136
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    sget-object v4, Landroid/util/Patterns;->EMAIL_ADDRESS:Ljava/util/regex/Pattern;

    invoke-virtual {v4, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    if-nez v4, :cond_1

    goto :goto_0

    .line 141
    :cond_1
    iget-object v4, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->deviceInfo:Lcom/atlassian/mobilekit/module/core/DeviceInfo;

    invoke-virtual {v4}, Lcom/atlassian/mobilekit/module/core/DeviceInfo;->hasConnectivity()Z

    move-result v4

    if-nez v4, :cond_2

    .line 142
    sget p1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_device_offline:I

    invoke-static {p0, p1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    return v3

    .line 146
    :cond_2
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    .line 147
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/core/utils/SystemUtils;->hideSoftKeyboard(Landroid/view/View;)V

    .line 148
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEmailEt:Landroid/widget/EditText;

    invoke-static {p1}, Lcom/atlassian/mobilekit/module/core/utils/SystemUtils;->hideSoftKeyboard(Landroid/view/View;)V

    .line 149
    invoke-direct {p0, v0, v1}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendFeedback(Ljava/lang/String;Ljava/lang/String;)V

    return v3

    .line 137
    :cond_3
    :goto_0
    sget p1, Lcom/atlassian/mobilekit/module/feedback/R$string;->mk_fb_invalid_email_address:I

    invoke-static {p0, p1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object p1

    invoke-virtual {p1}, Landroid/widget/Toast;->show()V

    return v3

    .line 152
    :cond_4
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result p1

    return p1
.end method

.method public onSendCompleted(Lcom/atlassian/mobilekit/module/feedback/commands/Result;)V
    .locals 1

    .line 195
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    if-ne v0, p1, :cond_1

    .line 198
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->sendMenuItem:Landroid/view/MenuItem;

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    .line 199
    invoke-interface {p1, v0}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 201
    :cond_0
    iget-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->feedbackEt:Landroid/widget/EditText;

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setEnabled(Z)V

    .line 204
    :cond_1
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/lifecycle/Lifecycle;->getCurrentState()Landroidx/lifecycle/Lifecycle$State;

    move-result-object p1

    sget-object v0, Landroidx/lifecycle/Lifecycle$State;->RESUMED:Landroidx/lifecycle/Lifecycle$State;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle$State;->isAtLeast(Landroidx/lifecycle/Lifecycle$State;)Z

    move-result p1

    xor-int/lit8 p1, p1, 0x1

    if-eqz p1, :cond_2

    .line 207
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->finish()V

    :cond_2
    return-void
.end method

.method public showProgressDialog()V
    .locals 3

    .line 166
    new-instance v0, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;

    invoke-direct {v0}, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;-><init>()V

    .line 167
    invoke-virtual {p0}, Lcom/atlassian/mobilekit/module/feedback/FeedbackActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/atlassian/mobilekit/module/feedback/ProgressDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method
