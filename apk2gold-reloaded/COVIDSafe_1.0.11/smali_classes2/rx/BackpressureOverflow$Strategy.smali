.class public interface abstract Lrx/BackpressureOverflow$Strategy;
.super Ljava/lang/Object;
.source "BackpressureOverflow.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrx/BackpressureOverflow;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Strategy"
.end annotation


# virtual methods
.method public abstract mayAttemptDrop()Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lrx/exceptions/MissingBackpressureException;
        }
    .end annotation
.end method
