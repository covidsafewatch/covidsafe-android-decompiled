.class final Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$1;
.super Ljava/lang/Object;
.source "PeekActivity.kt"

# interfaces
.implements Lio/reactivex/ObservableOnSubscribe;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lio/reactivex/ObservableOnSubscribe<",
        "TT;>;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u000c\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n\u00a2\u0006\u0002\u0008\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lio/reactivex/ObservableEmitter;",
        "",
        "kotlin.jvm.PlatformType",
        "subscribe"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$1;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final subscribe(Lio/reactivex/ObservableEmitter;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/reactivex/ObservableEmitter<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 86
    new-instance v0, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;

    iget-object v1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1$1;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;

    iget-object v1, v1, Lau/gov/health/covidsafe/PeekActivity$newPeek$6$1;->this$0:Lau/gov/health/covidsafe/PeekActivity$newPeek$6;

    iget-object v1, v1, Lau/gov/health/covidsafe/PeekActivity$newPeek$6;->this$0:Lau/gov/health/covidsafe/PeekActivity;

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;->nukeDb()V

    const/4 v0, 0x1

    .line 87
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-interface {p1, v0}, Lio/reactivex/ObservableEmitter;->onNext(Ljava/lang/Object;)V

    return-void
.end method
