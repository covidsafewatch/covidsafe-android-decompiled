.class public interface abstract Lcom/google/crypto/tink/PublicKeyVerify;
.super Ljava/lang/Object;
.source "PublicKeyVerify.java"


# virtual methods
.method public abstract verify([B[B)V
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10
        }
        names = {
            "signature",
            "data"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation
.end method
