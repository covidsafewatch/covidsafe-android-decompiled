.class public interface abstract Lcom/google/crypto/tink/HybridEncrypt;
.super Ljava/lang/Object;
.source "HybridEncrypt.java"


# virtual methods
.method public abstract encrypt([B[B)[B
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10
        }
        names = {
            "plaintext",
            "contextInfo"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation
.end method
