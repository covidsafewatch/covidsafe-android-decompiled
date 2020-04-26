.class public interface abstract Lcom/google/crypto/tink/subtle/EciesAeadHkdfDemHelper;
.super Ljava/lang/Object;
.source "EciesAeadHkdfDemHelper.java"


# virtual methods
.method public abstract getAead([B)Lcom/google/crypto/tink/Aead;
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "symmetricKeyValue"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation
.end method

.method public abstract getSymmetricKeySizeInBytes()I
.end method
