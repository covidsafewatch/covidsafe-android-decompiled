.class public interface abstract Lcom/google/crypto/tink/KeysetReader;
.super Ljava/lang/Object;
.source "KeysetReader.java"


# virtual methods
.method public abstract read()Lcom/google/crypto/tink/proto/Keyset;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract readEncrypted()Lcom/google/crypto/tink/proto/EncryptedKeyset;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
