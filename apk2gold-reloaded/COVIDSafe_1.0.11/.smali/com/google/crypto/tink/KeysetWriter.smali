.class public interface abstract Lcom/google/crypto/tink/KeysetWriter;
.super Ljava/lang/Object;
.source "KeysetWriter.java"


# virtual methods
.method public abstract write(Lcom/google/crypto/tink/proto/EncryptedKeyset;)V
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "keyset"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract write(Lcom/google/crypto/tink/proto/Keyset;)V
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "keyset"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
