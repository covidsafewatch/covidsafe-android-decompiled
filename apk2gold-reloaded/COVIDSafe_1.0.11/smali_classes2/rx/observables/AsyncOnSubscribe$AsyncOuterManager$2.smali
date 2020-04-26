.class Lrx/observables/AsyncOnSubscribe$AsyncOuterManager$2;
.super Ljava/lang/Object;
.source "AsyncOnSubscribe.java"

# interfaces
.implements Lrx/functions/Action0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;->subscribeBufferToObservable(Lrx/Observable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;

.field final synthetic val$s:Lrx/Subscriber;


# direct methods
.method constructor <init>(Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;Lrx/Subscriber;)V
    .locals 0

    .line 621
    iput-object p1, p0, Lrx/observables/AsyncOnSubscribe$AsyncOuterManager$2;->this$0:Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;

    iput-object p2, p0, Lrx/observables/AsyncOnSubscribe$AsyncOuterManager$2;->val$s:Lrx/Subscriber;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()V
    .locals 2

    .line 624
    iget-object v0, p0, Lrx/observables/AsyncOnSubscribe$AsyncOuterManager$2;->this$0:Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;

    iget-object v0, v0, Lrx/observables/AsyncOnSubscribe$AsyncOuterManager;->subscriptions:Lrx/subscriptions/CompositeSubscription;

    iget-object v1, p0, Lrx/observables/AsyncOnSubscribe$AsyncOuterManager$2;->val$s:Lrx/Subscriber;

    invoke-virtual {v0, v1}, Lrx/subscriptions/CompositeSubscription;->remove(Lrx/Subscription;)V

    return-void
.end method
