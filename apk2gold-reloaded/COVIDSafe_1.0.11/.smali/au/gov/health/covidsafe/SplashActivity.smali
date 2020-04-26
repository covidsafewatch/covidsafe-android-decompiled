.class public final Lau/gov/health/covidsafe/SplashActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "SplashActivity.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nSplashActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SplashActivity.kt\nau/gov/health/covidsafe/SplashActivity\n*L\n1#1,99:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\r2\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0008\u0010\u0017\u001a\u00020\rH\u0014J\u0008\u0010\u0018\u001a\u00020\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"
    }
    d2 = {
        "Lau/gov/health/covidsafe/SplashActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "ERROR_DIALOG_REQUEST_CODE",
        "",
        "SPLASH_TIME",
        "",
        "mHandler",
        "Landroid/os/Handler;",
        "retryProviderInstall",
        "",
        "updateFlag",
        "goToNextScreen",
        "",
        "hideSystemUI",
        "onActivityResult",
        "requestCode",
        "resultCode",
        "data",
        "Landroid/content/Intent;",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onPause",
        "onResume",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private final ERROR_DIALOG_REQUEST_CODE:I

.field private final SPLASH_TIME:J

.field private _$_findViewCache:Ljava/util/HashMap;

.field private mHandler:Landroid/os/Handler;

.field private retryProviderInstall:Z

.field private updateFlag:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 13
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    const-wide/16 v0, 0x7d0

    .line 15
    iput-wide v0, p0, Lau/gov/health/covidsafe/SplashActivity;->SPLASH_TIME:J

    const/4 v0, 0x1

    .line 18
    iput v0, p0, Lau/gov/health/covidsafe/SplashActivity;->ERROR_DIALOG_REQUEST_CODE:I

    return-void
.end method

.method public static final synthetic access$goToNextScreen(Lau/gov/health/covidsafe/SplashActivity;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lau/gov/health/covidsafe/SplashActivity;->goToNextScreen()V

    return-void
.end method

.method private final goToNextScreen()V
    .locals 5

    .line 68
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    const-string v1, "it"

    .line 69
    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    invoke-virtual {v1, v2}, Lau/gov/health/covidsafe/Preference;->getDataUploadedDateMs(Landroid/content/Context;)J

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 71
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    const/4 v3, 0x5

    const/16 v4, -0xe

    .line 72
    invoke-virtual {v1, v3, v4}, Ljava/util/Calendar;->add(II)V

    .line 74
    new-instance v3, Landroid/content/Intent;

    sget-object v4, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    invoke-virtual {v4, v2}, Lau/gov/health/covidsafe/Preference;->isOnBoarded(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 75
    const-class v0, Lau/gov/health/covidsafe/ui/onboarding/OnboardingActivity;

    goto :goto_0

    .line 76
    :cond_0
    invoke-virtual {v0, v1}, Ljava/util/Calendar;->before(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 77
    const-class v0, Lau/gov/health/covidsafe/SelfIsolationDoneActivity;

    goto :goto_0

    .line 79
    :cond_1
    const-class v0, Lau/gov/health/covidsafe/HomeActivity;

    .line 74
    :goto_0
    invoke-direct {v3, v2, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v3}, Lau/gov/health/covidsafe/SplashActivity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final hideSystemUI()V
    .locals 2

    .line 93
    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const-string v1, "window"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const-string v1, "window.decorView"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v1, 0x706

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_1

    invoke-virtual {p0, p1}, Landroidx/fragment/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/SplashActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 0

    .line 84
    invoke-super {p0, p1, p2, p3}, Landroidx/appcompat/app/AppCompatActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 85
    iget p2, p0, Lau/gov/health/covidsafe/SplashActivity;->ERROR_DIALOG_REQUEST_CODE:I

    if-ne p1, p2, :cond_0

    const/4 p1, 0x1

    .line 86
    iput-boolean p1, p0, Lau/gov/health/covidsafe/SplashActivity;->retryProviderInstall:Z

    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .line 25
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    const p1, 0x7f0d0021

    .line 26
    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/SplashActivity;->setContentView(I)V

    .line 27
    invoke-direct {p0}, Lau/gov/health/covidsafe/SplashActivity;->hideSystemUI()V

    .line 28
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/SplashActivity;->mHandler:Landroid/os/Handler;

    .line 30
    sget-object p1, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "android_id"

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "Settings.Secure.getStrin\u2026ttings.Secure.ANDROID_ID)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1, v0, v1}, Lau/gov/health/covidsafe/Preference;->putDeviceID(Landroid/content/Context;Ljava/lang/String;)V

    .line 35
    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    const-string v0, "intent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object p1

    if-eqz p1, :cond_0

    const/4 v1, 0x0

    const-string v2, "event"

    .line 36
    invoke-virtual {p1, v2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_0

    const-string v1, "update"

    .line 39
    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    .line 40
    iput-boolean p1, p0, Lau/gov/health/covidsafe/SplashActivity;->updateFlag:Z

    .line 41
    new-instance p1, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {p1, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/SplashActivity;->setIntent(Landroid/content/Intent;)V

    .line 43
    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "https://play.google.com/store/apps/details?id=sg.gov.tech.covidafe"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 45
    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/SplashActivity;->startActivity(Landroid/content/Intent;)V

    .line 46
    invoke-virtual {p0}, Lau/gov/health/covidsafe/SplashActivity;->finish()V

    :cond_0
    return-void
.end method

.method protected onPause()V
    .locals 2

    .line 53
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onPause()V

    .line 54
    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->mHandler:Landroid/os/Handler;

    if-nez v0, :cond_0

    const-string v1, "mHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    return-void
.end method

.method protected onResume()V
    .locals 4

    .line 58
    invoke-super {p0}, Landroidx/appcompat/app/AppCompatActivity;->onResume()V

    .line 59
    iget-boolean v0, p0, Lau/gov/health/covidsafe/SplashActivity;->updateFlag:Z

    if-nez v0, :cond_1

    .line 60
    iget-object v0, p0, Lau/gov/health/covidsafe/SplashActivity;->mHandler:Landroid/os/Handler;

    if-nez v0, :cond_0

    const-string v1, "mHandler"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    new-instance v1, Lau/gov/health/covidsafe/SplashActivity$onResume$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/SplashActivity$onResume$1;-><init>(Lau/gov/health/covidsafe/SplashActivity;)V

    check-cast v1, Ljava/lang/Runnable;

    .line 63
    iget-wide v2, p0, Lau/gov/health/covidsafe/SplashActivity;->SPLASH_TIME:J

    .line 60
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_1
    return-void
.end method
