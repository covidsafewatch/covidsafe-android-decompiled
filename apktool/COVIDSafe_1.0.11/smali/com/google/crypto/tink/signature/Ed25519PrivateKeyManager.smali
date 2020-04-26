.class Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;
.super Ljava/lang/Object;
.source "Ed25519PrivateKeyManager.java"

# interfaces
.implements Lcom/google/crypto/tink/PrivateKeyManager;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/crypto/tink/PrivateKeyManager<",
        "Lcom/google/crypto/tink/PublicKeySign;",
        ">;"
    }
.end annotation


# static fields
.field public static final TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey"

.field private static final VERSION:I


# direct methods
.method constructor <init>()V
    .locals 0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private newKey()Lcom/google/crypto/tink/proto/Ed25519PrivateKey;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 112
    invoke-static {}, Lcom/google/crypto/tink/subtle/Ed25519Sign$KeyPair;->newKeyPair()Lcom/google/crypto/tink/subtle/Ed25519Sign$KeyPair;

    move-result-object v0

    .line 114
    invoke-static {}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->newBuilder()Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;

    move-result-object v1

    const/4 v2, 0x0

    .line 115
    invoke-virtual {v1, v2}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->setVersion(I)Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;

    move-result-object v1

    .line 116
    invoke-virtual {v0}, Lcom/google/crypto/tink/subtle/Ed25519Sign$KeyPair;->getPublicKey()[B

    move-result-object v3

    invoke-static {v3}, Lcom/google/protobuf/ByteString;->copyFrom([B)Lcom/google/protobuf/ByteString;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;

    move-result-object v1

    .line 117
    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v1

    check-cast v1, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    .line 118
    invoke-static {}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->newBuilder()Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;

    move-result-object v3

    .line 119
    invoke-virtual {v3, v2}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->setVersion(I)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;

    move-result-object v2

    .line 120
    invoke-virtual {v0}, Lcom/google/crypto/tink/subtle/Ed25519Sign$KeyPair;->getPrivateKey()[B

    move-result-object v0

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFrom([B)Lcom/google/protobuf/ByteString;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;

    move-result-object v0

    .line 121
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->setPublicKey(Lcom/google/crypto/tink/proto/Ed25519PublicKey;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;

    move-result-object v0

    .line 122
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    return-object v0
.end method

.method private validate(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "keyProto"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 126
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getVersion()I

    move-result v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/Validators;->validateVersion(II)V

    .line 127
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/protobuf/ByteString;->size()I

    move-result p1

    const/16 v0, 0x20

    if-ne p1, v0, :cond_0

    return-void

    .line 128
    :cond_0
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string v0, "invalid Ed25519 private key: incorrect key length"

    invoke-direct {p1, v0}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
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

    const-string v0, "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey"

    .line 98
    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method public getKeyType()Ljava/lang/String;
    .locals 1

    const-string v0, "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey"

    return-object v0
.end method

.method public getPrimitive(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/PublicKeySign;
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "serialized"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 45
    :try_start_0
    invoke-static {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object p1

    .line 46
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/PublicKeySign;

    move-result-object p1
    :try_end_0
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    .line 48
    new-instance v0, Ljava/security/GeneralSecurityException;

    const-string v1, "invalid Ed25519 private key"

    invoke-direct {v0, v1, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/PublicKeySign;
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

    .line 54
    instance-of v0, p1, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    if-eqz v0, :cond_0

    .line 57
    check-cast p1, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    .line 58
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->validate(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;)V

    .line 59
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519Sign;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/protobuf/ByteString;->toByteArray()[B

    move-result-object p1

    invoke-direct {v0, p1}, Lcom/google/crypto/tink/subtle/Ed25519Sign;-><init>([B)V

    return-object v0

    .line 55
    :cond_0
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string v0, "expected Ed25519PrivateKey proto"

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
            "serialized"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 35
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->getPrimitive(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/PublicKeySign;

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

    .line 35
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->getPrimitive(Lcom/google/protobuf/MessageLite;)Lcom/google/crypto/tink/PublicKeySign;

    move-result-object p1

    return-object p1
.end method

.method public getPublicKeyData(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData;
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

    .line 85
    :try_start_0
    invoke-static {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object p1

    .line 86
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyData;->newBuilder()Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    const-string v1, "type.googleapis.com/google.crypto.tink.Ed25519PublicKey"

    .line 87
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    .line 88
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getPublicKey()Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    move-result-object p1

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->toByteString()Lcom/google/protobuf/ByteString;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    sget-object v0, Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;->ASYMMETRIC_PUBLIC:Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;

    .line 89
    invoke-virtual {p1, v0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setKeyMaterialType(Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    .line 90
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeyData;
    :try_end_0
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p1

    .line 92
    new-instance v0, Ljava/security/GeneralSecurityException;

    const-string v1, "expected serialized Ed25519PrivateKey proto"

    invoke-direct {v0, v1, p1}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public getVersion()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public newKey(Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/MessageLite;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "unused"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 64
    invoke-direct {p0}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->newKey()Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object p1

    return-object p1
.end method

.method public newKey(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "unused"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 69
    invoke-direct {p0}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->newKey()Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object p1

    return-object p1
.end method

.method public newKeyData(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData;
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "unused"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 74
    invoke-direct {p0}, Lcom/google/crypto/tink/signature/Ed25519PrivateKeyManager;->newKey()Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object p1

    .line 75
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyData;->newBuilder()Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    const-string v1, "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey"

    .line 76
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object v0

    .line 77
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->toByteString()Lcom/google/protobuf/ByteString;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    sget-object v0, Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;->ASYMMETRIC_PRIVATE:Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;

    .line 78
    invoke-virtual {p1, v0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->setKeyMaterialType(Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;)Lcom/google/crypto/tink/proto/KeyData$Builder;

    move-result-object p1

    .line 79
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeyData$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeyData;

    return-object p1
.end method
