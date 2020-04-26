.class public final Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;
.super Ljava/lang/Object;
.source "VerifyUploadPinPresenter.kt"

# interfaces
.implements Landroidx/lifecycle/LifecycleObserver;


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nVerifyUploadPinPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyUploadPinPresenter.kt\nau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter\n*L\n1#1,74:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0008\u0010\u000f\u001a\u00020\u0010H\u0003J\u0015\u0010\r\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\u0008\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;",
        "Landroidx/lifecycle/LifecycleObserver;",
        "fragment",
        "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;",
        "(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V",
        "TAG",
        "",
        "awsClient",
        "Lau/gov/health/covidsafe/networking/service/AwsClient;",
        "getUploadOtp",
        "Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;",
        "recordStorage",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;",
        "uploadData",
        "Lau/gov/health/covidsafe/interactor/usecase/UploadData;",
        "onCreate",
        "",
        "otp",
        "uploadData$app_release",
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
.field private final TAG:Ljava/lang/String;

.field private awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

.field private final fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

.field private getUploadOtp:Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;

.field private recordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

.field private uploadData:Lau/gov/health/covidsafe/interactor/usecase/UploadData;


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;)V
    .locals 2

    const-string v0, "fragment"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    .line 19
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p1

    const-string v0, "this.javaClass.simpleName"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->TAG:Ljava/lang/String;

    .line 21
    sget-object p1, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getAwsClient()Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object p1

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    .line 28
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p1

    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p1, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    .line 29
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getContext()Landroid/content/Context;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 30
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    const-string v1, "context"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, p1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->recordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    :cond_0
    return-void
.end method

.method public static final synthetic access$getFragment$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;
    .locals 0

    .line 17
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    return-object p0
.end method

.method public static final synthetic access$getRecordStorage$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;
    .locals 1

    .line 17
    iget-object p0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->recordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    if-nez p0, :cond_0

    const-string v0, "recordStorage"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$setRecordStorage$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;)V
    .locals 0

    .line 17
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->recordStorage:Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    return-void
.end method

.method private final onCreate()V
    .locals 6
    .annotation runtime Landroidx/lifecycle/OnLifecycleEvent;
        value = .enum Landroidx/lifecycle/Lifecycle$Event;->ON_CREATE:Landroidx/lifecycle/Lifecycle$Event;
    .end annotation

    .line 36
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    sget-object v2, Lau/gov/health/covidsafe/factory/NetworkFactory;->Companion:Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;->getOkHttpClient()Lokhttp3/OkHttpClient;

    move-result-object v2

    iget-object v3, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v3}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getContext()Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v4}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v4

    const-string v5, "fragment.lifecycle"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2, v3, v4}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Lokhttp3/OkHttpClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->uploadData:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    .line 38
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->awsClient:Lau/gov/health/covidsafe/networking/service/AwsClient;

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v2}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object v2

    invoke-static {v2, v5}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v0, v1, v2}, Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;-><init>(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroidx/lifecycle/Lifecycle;)V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->getUploadOtp:Lau/gov/health/covidsafe/interactor/usecase/GetUploadOtp;

    return-void
.end method


# virtual methods
.method public final uploadData$app_release(Ljava/lang/String;)V
    .locals 3

    const-string v0, "otp"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 42
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->disableContinueButton()V

    .line 43
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->fragment:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->showDialogLoading()V

    .line 44
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->uploadData:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    if-nez v0, :cond_0

    const-string v1, "uploadData"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    .line 45
    :cond_0
    new-instance v1, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)V

    check-cast v1, Lkotlin/jvm/functions/Function1;

    .line 54
    new-instance v2, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$2;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$2;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    .line 44
    invoke-virtual {v0, p1, v1, v2}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->invoke(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V

    return-void
.end method
