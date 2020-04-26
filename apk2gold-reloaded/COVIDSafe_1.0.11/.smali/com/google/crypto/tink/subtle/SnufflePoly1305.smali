.class abstract Lcom/google/crypto/tink/subtle/SnufflePoly1305;
.super Ljava/lang/Object;
.source "SnufflePoly1305.java"

# interfaces
.implements Lcom/google/crypto/tink/Aead;


# instance fields
.field private final key:[B

.field private final macKeysnuffle:Lcom/google/crypto/tink/subtle/Snuffle;

.field private final snuffle:Lcom/google/crypto/tink/subtle/Snuffle;


# direct methods
.method constructor <init>([B)V
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "key"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;
        }
    .end annotation

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-virtual {p1}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    iput-object v0, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->key:[B

    const/4 v0, 0x1

    .line 43
    invoke-virtual {p0, p1, v0}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->createSnuffleInstance([BI)Lcom/google/crypto/tink/subtle/Snuffle;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    const/4 v0, 0x0

    .line 44
    invoke-virtual {p0, p1, v0}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->createSnuffleInstance([BI)Lcom/google/crypto/tink/subtle/Snuffle;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->macKeysnuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    return-void
.end method

.method private decrypt(Ljava/nio/ByteBuffer;[B)[B
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x10
        }
        names = {
            "ciphertext",
            "associatedData"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 127
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {v1}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result v1

    const/16 v2, 0x10

    add-int/2addr v1, v2

    if-lt v0, v1, :cond_1

    .line 130
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    new-array v1, v2, [B

    .line 132
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v3

    sub-int/2addr v3, v2

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 133
    invoke-virtual {p1, v1}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 135
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 136
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v3

    sub-int/2addr v3, v2

    invoke-virtual {p1, v3}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 137
    iget-object v2, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {v2}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result v2

    new-array v2, v2, [B

    .line 138
    invoke-virtual {p1, v2}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    if-nez p2, :cond_0

    const/4 p2, 0x0

    new-array p2, p2, [B

    .line 144
    :cond_0
    :try_start_0
    invoke-direct {p0, v2}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->getMacKey([B)[B

    move-result-object v2

    invoke-static {p2, p1}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->macDataRfc7539([BLjava/nio/ByteBuffer;)[B

    move-result-object p2

    invoke-static {v2, p2, v1}, Lcom/google/crypto/tink/subtle/Poly1305;->verifyMac([B[B[B)V
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 151
    iget-object p2, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {p2, p1}, Lcom/google/crypto/tink/subtle/Snuffle;->decrypt(Ljava/nio/ByteBuffer;)[B

    move-result-object p1

    return-object p1

    :catch_0
    move-exception p1

    .line 146
    new-instance p2, Ljavax/crypto/AEADBadTagException;

    invoke-virtual {p1}, Ljava/security/GeneralSecurityException;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljavax/crypto/AEADBadTagException;-><init>(Ljava/lang/String;)V

    throw p2

    .line 128
    :cond_1
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string p2, "ciphertext too short"

    invoke-direct {p1, p2}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private encrypt(Ljava/nio/ByteBuffer;[B[B)V
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x10,
            0x10
        }
        names = {
            "output",
            "plaintext",
            "associatedData"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 79
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    array-length v1, p2

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    .line 80
    invoke-virtual {v2}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result v2

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x10

    if-lt v0, v1, :cond_1

    .line 83
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .line 84
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {v1, p1, p2}, Lcom/google/crypto/tink/subtle/Snuffle;->encrypt(Ljava/nio/ByteBuffer;[B)V

    .line 85
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 86
    iget-object p2, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {p2}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result p2

    new-array p2, p2, [B

    .line 87
    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 88
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    add-int/lit8 v0, v0, -0x10

    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    if-nez p3, :cond_0

    const/4 p3, 0x0

    new-array p3, p3, [B

    .line 93
    :cond_0
    invoke-direct {p0, p2}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->getMacKey([B)[B

    move-result-object p2

    invoke-static {p3, p1}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->macDataRfc7539([BLjava/nio/ByteBuffer;)[B

    move-result-object p3

    invoke-static {p2, p3}, Lcom/google/crypto/tink/subtle/Poly1305;->computeMac([B[B)[B

    move-result-object p2

    .line 94
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result p3

    add-int/lit8 p3, p3, 0x10

    invoke-virtual {p1, p3}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 95
    invoke-virtual {p1, p2}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    return-void

    .line 81
    :cond_1
    new-instance p1, Ljava/lang/IllegalArgumentException;

    const-string p2, "Given ByteBuffer output is too small"

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private getMacKey([B)[B
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "nonce"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;
        }
    .end annotation

    .line 173
    iget-object v0, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->macKeysnuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/google/crypto/tink/subtle/Snuffle;->getKeyStreamBlock([BI)Ljava/nio/ByteBuffer;

    move-result-object p1

    const/16 v0, 0x20

    new-array v0, v0, [B

    .line 175
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    return-object v0
.end method

.method static macDataRfc7539([BLjava/nio/ByteBuffer;)[B
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x0
        }
        names = {
            "aad",
            "ciphertext"
        }
    .end annotation

    .line 156
    array-length v0, p0

    rem-int/lit8 v0, v0, 0x10

    if-nez v0, :cond_0

    array-length v0, p0

    goto :goto_0

    :cond_0
    array-length v0, p0

    add-int/lit8 v0, v0, 0x10

    array-length v1, p0

    rem-int/lit8 v1, v1, 0x10

    sub-int/2addr v0, v1

    .line 157
    :goto_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v1

    .line 159
    rem-int/lit8 v2, v1, 0x10

    if-nez v2, :cond_1

    move v3, v1

    goto :goto_1

    :cond_1
    add-int/lit8 v3, v1, 0x10

    sub-int/2addr v3, v2

    :goto_1
    add-int/2addr v3, v0

    add-int/lit8 v2, v3, 0x10

    .line 161
    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v2

    sget-object v4, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v4}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-result-object v2

    .line 162
    invoke-virtual {v2, p0}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 163
    invoke-virtual {v2, v0}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 164
    invoke-virtual {v2, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 165
    invoke-virtual {v2, v3}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 166
    array-length p0, p0

    int-to-long p0, p0

    invoke-virtual {v2, p0, p1}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    int-to-long p0, v1

    .line 167
    invoke-virtual {v2, p0, p1}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    .line 168
    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method abstract createSnuffleInstance([BI)Lcom/google/crypto/tink/subtle/Snuffle;
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x0
        }
        names = {
            "key",
            "initialCounter"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidKeyException;
        }
    .end annotation
.end method

.method public decrypt([B[B)[B
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10
        }
        names = {
            "ciphertext",
            "associatedData"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 112
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p1

    invoke-direct {p0, p1, p2}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->decrypt(Ljava/nio/ByteBuffer;[B)[B

    move-result-object p1

    return-object p1
.end method

.method public encrypt([B[B)[B
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10
        }
        names = {
            "plaintext",
            "associatedData"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 67
    array-length v0, p1

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    invoke-virtual {v1}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result v1

    const v2, 0x7fffffff

    sub-int/2addr v2, v1

    add-int/lit8 v2, v2, -0x10

    if-gt v0, v2, :cond_0

    .line 70
    array-length v0, p1

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->snuffle:Lcom/google/crypto/tink/subtle/Snuffle;

    .line 71
    invoke-virtual {v1}, Lcom/google/crypto/tink/subtle/Snuffle;->nonceSizeInBytes()I

    move-result v1

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x10

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 73
    invoke-direct {p0, v0, p1, p2}, Lcom/google/crypto/tink/subtle/SnufflePoly1305;->encrypt(Ljava/nio/ByteBuffer;[B[B)V

    .line 74
    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object p1

    return-object p1

    .line 68
    :cond_0
    new-instance p1, Ljava/security/GeneralSecurityException;

    const-string p2, "plaintext too long"

    invoke-direct {p1, p2}, Ljava/security/GeneralSecurityException;-><init>(Ljava/lang/String;)V

    throw p1
.end method
