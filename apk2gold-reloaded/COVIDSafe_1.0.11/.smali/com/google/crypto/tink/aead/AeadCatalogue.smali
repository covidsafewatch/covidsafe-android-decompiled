.class Lcom/google/crypto/tink/aead/AeadCatalogue;
.super Ljava/lang/Object;
.source "AeadCatalogue.java"

# interfaces
.implements Lcom/google/crypto/tink/Catalogue;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/crypto/tink/Catalogue<",
        "Lcom/google/crypto/tink/Aead;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private aeadKeyManager(Ljava/lang/String;)Lcom/google/crypto/tink/KeyManager;
    .locals 7
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "typeUrl"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Lcom/google/crypto/tink/KeyManager<",
            "Lcom/google/crypto/tink/Aead;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 53
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x5

    const/4 v3, 0x4

    const/4 v4, 0x3

    const/4 v5, 0x2

    const/4 v6, 0x1

    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    :sswitch_0
    const-string v0, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v2

    goto :goto_1

    :sswitch_1
    const-string v0, "type.googleapis.com/google.crypto.tink.AesGcmKey"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v5

    goto :goto_1

    :sswitch_2
    const-string v0, "type.googleapis.com/google.crypto.tink.AesEaxKey"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v6

    goto :goto_1

    :sswitch_3
    const-string v0, "type.googleapis.com/google.crypto.tink.KmsAeadKey"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v3

    goto :goto_1

    :sswitch_4
    const-string v0, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    goto :goto_1

    :sswitch_5
    const-string v0, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v4

    goto :goto_1

    :cond_0
    :goto_0
    const/4 v0, -0x1

    :goto_1
    if-eqz v0, :cond_6

    if-eq v0, v6, :cond_5

    if-eq v0, v5, :cond_4

    if-eq v0, v4, :cond_3

    if-eq v0, v3, :cond_2

    if-ne v0, v2, :cond_1

    .line 65
    new-instance p1, Lcom/google/crypto/tink/aead/KmsEnvelopeAeadKeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/KmsEnvelopeAeadKeyManager;-><init>()V

    return-object p1

    .line 67
    :cond_1
    new-instance v0, Ljava/security/GeneralSecurityException;

    new-array v2, v6, [Ljava/lang/Object;

    aput-object p1, v2, v1

    const-string p1, "No support for primitive \'Aead\' with key type \'%s\'."

    .line 68
    invoke-static {p1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_2
    new-instance p1, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;-><init>()V

    return-object p1

    .line 61
    :cond_3
    new-instance p1, Lcom/google/crypto/tink/aead/ChaCha20Poly1305KeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/ChaCha20Poly1305KeyManager;-><init>()V

    return-object p1

    .line 59
    :cond_4
    new-instance p1, Lcom/google/crypto/tink/aead/AesGcmKeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/AesGcmKeyManager;-><init>()V

    return-object p1

    .line 57
    :cond_5
    new-instance p1, Lcom/google/crypto/tink/aead/AesEaxKeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/AesEaxKeyManager;-><init>()V

    return-object p1

    .line 55
    :cond_6
    new-instance p1, Lcom/google/crypto/tink/aead/AesCtrHmacAeadKeyManager;

    invoke-direct {p1}, Lcom/google/crypto/tink/aead/AesCtrHmacAeadKeyManager;-><init>()V

    return-object p1

    nop

    :sswitch_data_0
    .sparse-switch
        0x1580a8e0 -> :sswitch_5
        0x4878f271 -> :sswitch_4
        0x579e3055 -> :sswitch_3
        0x6b1dc604 -> :sswitch_2
        0x6e9ea62f -> :sswitch_1
        0x7bee4165 -> :sswitch_0
    .end sparse-switch
.end method


# virtual methods
.method public getKeyManager(Ljava/lang/String;Ljava/lang/String;I)Lcom/google/crypto/tink/KeyManager;
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "typeUrl",
            "primitiveName",
            "minVersion"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I)",
            "Lcom/google/crypto/tink/KeyManager<",
            "Lcom/google/crypto/tink/Aead;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 36
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/4 v2, 0x0

    const v3, 0x2d9f47

    if-eq v1, v3, :cond_0

    goto :goto_0

    :cond_0
    const-string v1, "aead"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v2

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, -0x1

    :goto_1
    const/4 v1, 0x1

    if-nez v0, :cond_3

    .line 38
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/aead/AeadCatalogue;->aeadKeyManager(Ljava/lang/String;)Lcom/google/crypto/tink/KeyManager;

    move-result-object p2

    .line 44
    invoke-interface {p2}, Lcom/google/crypto/tink/KeyManager;->getVersion()I

    move-result v0

    if-lt v0, p3, :cond_2

    return-object p2

    .line 45
    :cond_2
    new-instance p2, Ljava/security/GeneralSecurityException;

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    aput-object p1, v0, v2

    .line 47
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, v0, v1

    const-string p1, "No key manager for key type \'%s\' with version at least %d."

    .line 46
    invoke-static {p1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p2

    .line 41
    :cond_3
    new-instance p1, Ljava/security/GeneralSecurityException;

    new-array p3, v1, [Ljava/lang/Object;

    aput-object p2, p3, v2

    const-string p2, "No support for primitive \'%s\'."

    .line 42
    invoke-static {p2, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
