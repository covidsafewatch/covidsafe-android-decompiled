.class final Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;
.super Lkotlin/jvm/internal/Lambda;
.source "UploadData.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/interactor/usecase/UploadData;->zipAndUploadData(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lokhttp3/Response;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "Lokhttp3/Response;",
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
.field final synthetic $request:Lokhttp3/Request;

.field final synthetic this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/interactor/usecase/UploadData;Lokhttp3/Request;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;->this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    iput-object p2, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;->$request:Lokhttp3/Request;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 20
    invoke-virtual {p0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;->invoke()Lokhttp3/Response;

    move-result-object v0

    return-object v0
.end method

.method public final invoke()Lokhttp3/Response;
    .locals 2

    .line 71
    iget-object v0, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;->this$0:Lau/gov/health/covidsafe/interactor/usecase/UploadData;

    invoke-static {v0}, Lau/gov/health/covidsafe/interactor/usecase/UploadData;->access$getOkHttpClient$p(Lau/gov/health/covidsafe/interactor/usecase/UploadData;)Lokhttp3/OkHttpClient;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/interactor/usecase/UploadData$zipAndUploadData$response$1;->$request:Lokhttp3/Request;

    invoke-virtual {v0, v1}, Lokhttp3/OkHttpClient;->newCall(Lokhttp3/Request;)Lokhttp3/Call;

    move-result-object v0

    invoke-interface {v0}, Lokhttp3/Call;->execute()Lokhttp3/Response;

    move-result-object v0

    return-object v0
.end method
