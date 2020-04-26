.class final Lrx/RxReactiveStreams$1;
.super Ljava/lang/Object;
.source "RxReactiveStreams.java"

# interfaces
.implements Lrx/Observable$OnSubscribe;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrx/RxReactiveStreams;->toObservable(Lorg/reactivestreams/Publisher;)Lrx/Observable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lrx/Observable$OnSubscribe<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic val$publisher:Lorg/reactivestreams/Publisher;


# direct methods
.method constructor <init>(Lorg/reactivestreams/Publisher;)V
    .locals 0

    .line 57
    iput-object p1, p0, Lrx/RxReactiveStreams$1;->val$publisher:Lorg/reactivestreams/Publisher;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .line 57
    check-cast p1, Lrx/Subscriber;

    invoke-virtual {p0, p1}, Lrx/RxReactiveStreams$1;->call(Lrx/Subscriber;)V

    return-void
.end method

.method public call(Lrx/Subscriber;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 60
    iget-object v0, p0, Lrx/RxReactiveStreams$1;->val$publisher:Lorg/reactivestreams/Publisher;

    invoke-static {p1}, Lrx/RxReactiveStreams;->toSubscriber(Lrx/Subscriber;)Lorg/reactivestreams/Subscriber;

    move-result-object p1

    invoke-interface {v0, p1}, Lorg/reactivestreams/Publisher;->subscribe(Lorg/reactivestreams/Subscriber;)V

    return-void
.end method
