.class public Lrx/internal/reactivestreams/PublisherAdapter;
.super Ljava/lang/Object;
.source "PublisherAdapter.java"

# interfaces
.implements Lorg/reactivestreams/Publisher;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/reactivestreams/Publisher<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final observable:Lrx/Observable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/Observable<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lrx/Observable;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/Observable<",
            "TT;>;)V"
        }
    .end annotation

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    invoke-virtual {p1}, Lrx/Observable;->serialize()Lrx/Observable;

    move-result-object p1

    iput-object p1, p0, Lrx/internal/reactivestreams/PublisherAdapter;->observable:Lrx/Observable;

    return-void
.end method


# virtual methods
.method public subscribe(Lorg/reactivestreams/Subscriber;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/reactivestreams/Subscriber<",
            "-TT;>;)V"
        }
    .end annotation

    .line 35
    iget-object v0, p0, Lrx/internal/reactivestreams/PublisherAdapter;->observable:Lrx/Observable;

    new-instance v1, Lrx/internal/reactivestreams/PublisherAdapter$1;

    invoke-direct {v1, p0, p1}, Lrx/internal/reactivestreams/PublisherAdapter$1;-><init>(Lrx/internal/reactivestreams/PublisherAdapter;Lorg/reactivestreams/Subscriber;)V

    invoke-virtual {v0, v1}, Lrx/Observable;->subscribe(Lrx/Subscriber;)Lrx/Subscription;

    return-void
.end method
