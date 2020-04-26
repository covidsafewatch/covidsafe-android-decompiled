.class public Lrx/observables/GroupedObservable;
.super Lrx/Observable;
.source "GroupedObservable.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "T:",
        "Ljava/lang/Object;",
        ">",
        "Lrx/Observable<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final key:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TK;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Ljava/lang/Object;Lrx/Observable$OnSubscribe;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Lrx/Observable$OnSubscribe<",
            "TT;>;)V"
        }
    .end annotation

    .line 96
    invoke-direct {p0, p2}, Lrx/Observable;-><init>(Lrx/Observable$OnSubscribe;)V

    .line 97
    iput-object p1, p0, Lrx/observables/GroupedObservable;->key:Ljava/lang/Object;

    return-void
.end method

.method public static create(Ljava/lang/Object;Lrx/Observable$OnSubscribe;)Lrx/observables/GroupedObservable;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(TK;",
            "Lrx/Observable$OnSubscribe<",
            "TT;>;)",
            "Lrx/observables/GroupedObservable<",
            "TK;TT;>;"
        }
    .end annotation

    .line 92
    new-instance v0, Lrx/observables/GroupedObservable;

    invoke-direct {v0, p0, p1}, Lrx/observables/GroupedObservable;-><init>(Ljava/lang/Object;Lrx/Observable$OnSubscribe;)V

    return-object v0
.end method

.method public static from(Ljava/lang/Object;Lrx/Observable;)Lrx/observables/GroupedObservable;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<K:",
            "Ljava/lang/Object;",
            "T:",
            "Ljava/lang/Object;",
            ">(TK;",
            "Lrx/Observable<",
            "TT;>;)",
            "Lrx/observables/GroupedObservable<",
            "TK;TT;>;"
        }
    .end annotation

    .line 53
    new-instance v0, Lrx/observables/GroupedObservable;

    new-instance v1, Lrx/observables/GroupedObservable$1;

    invoke-direct {v1, p1}, Lrx/observables/GroupedObservable$1;-><init>(Lrx/Observable;)V

    invoke-direct {v0, p0, v1}, Lrx/observables/GroupedObservable;-><init>(Ljava/lang/Object;Lrx/Observable$OnSubscribe;)V

    return-object v0
.end method


# virtual methods
.method public getKey()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TK;"
        }
    .end annotation

    .line 106
    iget-object v0, p0, Lrx/observables/GroupedObservable;->key:Ljava/lang/Object;

    return-object v0
.end method
