.class final Lrx/observables/AsyncOnSubscribe$UnicastSubject;
.super Lrx/Observable;
.source "AsyncOnSubscribe.java"

# interfaces
.implements Lrx/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/observables/AsyncOnSubscribe;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "UnicastSubject"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Observable<",
        "TT;>;",
        "Lrx/Observer<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final state:Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lrx/observables/AsyncOnSubscribe$UnicastSubject$State<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lrx/observables/AsyncOnSubscribe$UnicastSubject$State<",
            "TT;>;)V"
        }
    .end annotation

    .line 641
    invoke-direct {p0, p1}, Lrx/Observable;-><init>(Lrx/Observable$OnSubscribe;)V

    .line 642
    iput-object p1, p0, Lrx/observables/AsyncOnSubscribe$UnicastSubject;->state:Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;

    return-void
.end method

.method public static create()Lrx/observables/AsyncOnSubscribe$UnicastSubject;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">()",
            "Lrx/observables/AsyncOnSubscribe$UnicastSubject<",
            "TT;>;"
        }
    .end annotation

    .line 637
    new-instance v0, Lrx/observables/AsyncOnSubscribe$UnicastSubject;

    new-instance v1, Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;

    invoke-direct {v1}, Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;-><init>()V

    invoke-direct {v0, v1}, Lrx/observables/AsyncOnSubscribe$UnicastSubject;-><init>(Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;)V

    return-object v0
.end method


# virtual methods
.method public onCompleted()V
    .locals 1

    .line 647
    iget-object v0, p0, Lrx/observables/AsyncOnSubscribe$UnicastSubject;->state:Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;

    iget-object v0, v0, Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;->subscriber:Lrx/Subscriber;

    invoke-virtual {v0}, Lrx/Subscriber;->onCompleted()V

    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 652
    iget-object v0, p0, Lrx/observables/AsyncOnSubscribe$UnicastSubject;->state:Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;

    iget-object v0, v0, Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;->subscriber:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onError(Ljava/lang/Throwable;)V

    return-void
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 657
    iget-object v0, p0, Lrx/observables/AsyncOnSubscribe$UnicastSubject;->state:Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;

    iget-object v0, v0, Lrx/observables/AsyncOnSubscribe$UnicastSubject$State;->subscriber:Lrx/Subscriber;

    invoke-virtual {v0, p1}, Lrx/Subscriber;->onNext(Ljava/lang/Object;)V

    return-void
.end method
