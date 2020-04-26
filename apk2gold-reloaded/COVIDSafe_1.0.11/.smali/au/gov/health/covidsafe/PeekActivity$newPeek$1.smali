.class final Lau/gov/health/covidsafe/PeekActivity$newPeek$1;
.super Ljava/lang/Object;
.source "PeekActivity.kt"

# interfaces
.implements Landroidx/lifecycle/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/PeekActivity;->newPeek()V
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
        "Landroidx/lifecycle/Observer<",
        "Ljava/util/List<",
        "+",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
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
        "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\u0008\u0006"
    }
    d2 = {
        "<anonymous>",
        "",
        "records",
        "",
        "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
        "kotlin.jvm.PlatformType",
        "onChanged"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $adapter:Lau/gov/health/covidsafe/RecordListAdapter;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/RecordListAdapter;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$1;->$adapter:Lau/gov/health/covidsafe/RecordListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onChanged(Ljava/lang/Object;)V
    .locals 0

    .line 22
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/PeekActivity$newPeek$1;->onChanged(Ljava/util/List;)V

    return-void
.end method

.method public final onChanged(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;",
            ">;)V"
        }
    .end annotation

    .line 47
    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity$newPeek$1;->$adapter:Lau/gov/health/covidsafe/RecordListAdapter;

    const-string v1, "records"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Lau/gov/health/covidsafe/RecordListAdapter;->setSourceData$app_release(Ljava/util/List;)V

    return-void
.end method
