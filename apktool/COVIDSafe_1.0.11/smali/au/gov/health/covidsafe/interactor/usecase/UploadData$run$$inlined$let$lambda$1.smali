.class final Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;
.super Lkotlin/jvm/internal/Lambda;
.source "UploadData.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/interactor/usecase/UploadData;->run(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lretrofit2/Response<",
        "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
        ">;>;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0003\u0010\u0000\u001a&\u0012\u000c\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\u000c\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\u0008\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "<anonymous>",
        "Lretrofit2/Response;",
        "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
        "kotlin.jvm.PlatformType",
        "invoke",
        "au/gov/health/covidsafe/interactor/usecase/UploadData$run$2$initialUploadResponse$1"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $continuation$inlined:Lkotlin/coroutines/Continuation;

.field final synthetic $jwtToken:Ljava/lang/String;

.field final synthetic $params$inlined:Ljava/lang/String;

.field final synthetic this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;


# direct methods
.method constructor <init>(Ljava/lang/String;Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->$jwtToken:Ljava/lang/String;

    iput-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    iput-object p3, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->$continuation$inlined:Lkotlin/coroutines/Continuation;

    iput-object p4, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->$params$inlined:Ljava/lang/String;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 20
    invoke-virtual {p0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->invoke()Lretrofit2/Response;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Lretrofit2/Response;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lretrofit2/Response<",
            "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;",
            ">;"
        }
    .end annotation

    .line 34
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    invoke-static {v0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->access$getAwsClient$p(Lau/gov/health/covidsafe/interactor/usecase/UploadData;)Lau/gov/health/covidsafe/networking/service/AwsClient;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Bearer "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->$jwtToken:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$run$$inlined$let$lambda$1;->$params$inlined:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lau/gov/health/covidsafe/networking/service/AwsClient;->initiateUpload(Ljava/lang/String;Ljava/lang/String;)Lretrofit2/Call;

    move-result-object v0

    invoke-interface {v0}, Lretrofit2/Call;->execute()Lretrofit2/Response;

    move-result-object v0

    return-object v0
.end method
