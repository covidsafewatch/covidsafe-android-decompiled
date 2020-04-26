.class Lcom/google/crypto/tink/aead/KmsAeadKeyManager;
.super Ljava/lang/Object;
.source "KmsAeadKeyManager.java"

# interfaces
.implements Lcom/google/crypto/tink/KeyManager;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/crypto/tink/KeyManager<",
        "Lcom/google/crypto/tink/Aead;",
        ">;"
    }
.end annotation


# static fields
.field public static final TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.KmsAeadKey"

.field private static final VERSION:I


# direct methods
.method constructor <init>()V
    .locals 0

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static validate(Lcom/google/crypto/tink/proto/KmsAeadKey;)V
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "key"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 131
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getVersion()I

    move-result p0

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/google/crypto/tink/subtle/Validators;->validateVersion(II)V

    return-void
.end method


# virtual methods
.method public doesSupport(Ljava/lang/String;)Z
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "typeUrl"
        }
    .end annotation

    const-string v0, "type.googleapis.com/google.crypto.tink.KmsAeadKey"

    .line 117
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public getKeyType()Ljava/lang/String;
    .locals 1

    const-string v0, "type.googleapis.com/google.crypto.tink.KmsAeadKey"

    return-object v0
.end method

.method public getPrimitive(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/Aead;
    .locals 2
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

    .line 48
    :try_start_0
    invoke-static {p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KmsAeadKey;

    move-result-object p1

    .line 49
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/Aead;

    move-result-object p1
    :try_end_0
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    .line 51
    new-instance v0, Ljava/security/GeneralSecurityException;

    const-string v1, "expected KmsAeadKey proto"

    invoke-direct {v0, v1, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/Aead;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "key"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 60
    instance-of v0, p1, Lcom/google/crypto/tink/proto/KmsAeadKey;

    if-eqz v0, :cond_0

    .line 63
    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKey;

    .line 64
    invoke-static {p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->validate(Lcom/google/crypto/tink/proto/KmsAeadKey;)V

    .line 65
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->getKeyUri()Ljava/lang/String;

    move-result-object p1

    .line 66
    invoke-static {p1}, Lcom/google/crypto/tink/KmsClients;->get(Ljava/lang/String;)Lcom/google/crypto/tink/KmsClient;

    move-result-object v0

    .line 67
    invoke-interface {v0, p1}, Lcom/google/crypto/tink/KmsClient;->getAead(Ljava/lang/String;)Lcom/google/crypto/tink/Aead;

    move-result-object p1

    return-object p1

    .line 61
    :cond_0
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string v0, "expected KmsAeadKey proto"

    invoke-direct {p1, v0}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public bridge synthetic getPrimitive(Lcom/google/protobuf/ByteString;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000
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

    .line 36
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->getPrimitive(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/Aead;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic getPrimitive(Lcom/google/protobuf/MessageLite;)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000
        }
        names = {
            "key"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 36
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/Aead;

    move-result-object p1

    return-object p1
.end method

.method public getVersion()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public newKey(Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/MessageLite;
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "serializedKeyFormat"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 77
    :try_start_0
    invoke-static {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object p1

    .line 78
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->newKey(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1
    :try_end_0
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    .line 80
    new-instance v0, Ljava/security/GeneralSecurityException;

    const-string v1, "expected serialized KmsAeadKeyFormat proto"

    invoke-direct {v0, v1, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public newKey(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "keyFormat"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 91
    instance-of v0, p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz v0, :cond_0

    .line 94
    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    .line 95
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKey;->newBuilder()Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    move-result-object v0

    .line 96
    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    move-result-object p1

    const/4 v0, 0x0

    .line 97
    invoke-virtual {p1, v0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->setVersion(I)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    move-result-object p1

    .line 98
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    return-object p1

    .line 92
    :cond_0
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string v0, "expected KmsAeadKeyFormat proto"

    invoke-direct {p1, v0}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public newKeyData(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData;
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "serializedKeyFormat"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 107
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/aead/KmsAeadKeyManager;->newKey(Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKey;

    .line 108
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyData;->newBuilder()Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    const-string v1, "type.googleapis.com/google.crypto.tink.KmsAeadKey"

    .line 109
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    .line 110
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->toByteString()Lcom/google/protobuf/ByteString;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    sget-object v0, Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;->REMOTE:Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;

    .line 111
    invoke-virtual {p1, v0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setKeyMaterialType(Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    .line 112
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeyData;

    return-object p1
.end method
