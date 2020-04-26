.class public synthetic L$r8$backportedMethods$utility$Long$1$hashCode;
.super Ljava/lang/Object;


# direct methods
.method public static synthetic hashCode(J)I
    .locals 2

    const/16 v0, 0x20

    ushr-long v0, p0, v0

    xor-long/2addr p0, v0

    long-to-int p0, p0

    return p0
.end method
