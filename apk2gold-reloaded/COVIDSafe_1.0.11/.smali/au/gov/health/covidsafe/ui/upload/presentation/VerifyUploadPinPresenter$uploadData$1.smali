.class final Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;
.super Lkotlin/jvm/internal/Lambda;
.source "VerifyUploadPinPresenter.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->uploadData$app_release(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Ljava/lang/String;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nVerifyUploadPinPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerifyUploadPinPresenter.kt\nau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1\n*L\n1#1,74:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\u0008\u0004"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 17
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;->invoke(Ljava/lang/String;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Ljava/lang/String;)V
    .locals 6

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 47
    sget-object p1, Lkotlinx/coroutines/GlobalScope;->INSTANCE:Lkotlinx/coroutines/GlobalScope;

    move-object v0, p1

    check-cast v0, Lkotlinx/coroutines/CoroutineScope;

    new-instance p1, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1$1;

    const/4 v1, 0x0

    invoke-direct {p1, p0, v1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1$1;-><init>(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;Lkotlin/coroutines/Continuation;)V

    move-object v3, p1

    check-cast v3, Lkotlin/jvm/functions/Function2;

    const/4 v2, 0x0

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 49
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->access$getFragment$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->getContext()Landroid/content/Context;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 50
    sget-object v0, Lau/gov/health/covidsafe/Preference;->INSTANCE:Lau/gov/health/covidsafe/Preference;

    const-string v1, "context"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lau/gov/health/covidsafe/Preference;->setDataIsUploaded(Landroid/content/Context;Z)V

    .line 52
    :cond_0
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter$uploadData$1;->this$0:Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;

    invoke-static {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;->access$getFragment$p(Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinPresenter;)Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;

    move-result-object p1

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment;->navigateToNextPage()V

    return-void
.end method
