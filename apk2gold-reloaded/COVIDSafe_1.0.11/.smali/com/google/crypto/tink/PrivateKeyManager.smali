.class public interface abstract Lcom/google/crypto/tink/PrivateKeyManager;
.super Ljava/lang/Object;
.source "PrivateKeyManager.java"

# interfaces
.implements Lcom/google/crypto/tink/KeyManager;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<P:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/crypto/tink/KeyManager<",
        "TP;>;"
    }
.end annotation


# virtual methods
.method public abstract getPublicKeyData(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData;
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "serializedKey"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation
.end method
