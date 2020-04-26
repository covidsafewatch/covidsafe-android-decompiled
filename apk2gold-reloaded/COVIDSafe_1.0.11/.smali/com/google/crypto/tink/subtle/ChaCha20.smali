.class Lcom/google/crypto/tink/subtle/ChaCha20;
.super Lcom/google/crypto/tink/subtle/Snuffle;
.source "ChaCha20.java"


# static fields
.field private static final ZERO_16_BYTES:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/16 v0, 0x10

    new-array v0, v0, [B

    .line 30
    sput-object v0, Lcom/google/crypto/tink/subtle/ChaCha20;->ZERO_16_BYTES:[B

    return-void
.end method

.method constructor <init>([BI)V
    .locals 0
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

    .line 33
    invoke-direct {p0, p1, p2}, Lcom/google/crypto/tink/subtle/Snuffle;-><init>([BI)V

    return-void
.end method

.method private createInitialState([BI)[I
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x0
        }
        names = {
            "nonce",
            "counter"
        }
    .end annotation

    const/16 v0, 0x10

    new-array v0, v0, [I

    .line 45
    invoke-static {v0}, Lcom/google/crypto/tink/subtle/ChaCha20;->setSigma([I)V

    .line 46
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/ChaCha20;->key:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    invoke-virtual {v1}, Lcom/google/crypto/tink/subtle/ImmutableByteArray;->getBytes()[B

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/ChaCha20;->setKey([I[B)V

    const/16 v1, 0xc

    aput p2, v0, v1

    .line 48
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p1

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/ChaCha20;->toIntArray(Ljava/nio/ByteBuffer;)[I

    move-result-object p1

    invoke-virtual {p0}, Lcom/google/crypto/tink/subtle/ChaCha20;->nonceSizeInBytes()I

    move-result p2

    div-int/lit8 p2, p2, 0x4

    const/4 v1, 0x0

    const/16 v2, 0xd

    invoke-static {p1, v1, v0, v2, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v0
.end method

.method static quarterRound([IIIII)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "x",
            "a",
            "b",
            "c",
            "d"
        }
    .end annotation

    .line 93
    aget v0, p0, p1

    aget v1, p0, p2

    add-int/2addr v0, v1

    aput v0, p0, p1

    .line 94
    aget v0, p0, p4

    aget v1, p0, p1

    xor-int/2addr v0, v1

    const/16 v1, 0x10

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/ChaCha20;->rotateLeft(II)I

    move-result v0

    aput v0, p0, p4

    .line 95
    aget v0, p0, p3

    aget v1, p0, p4

    add-int/2addr v0, v1

    aput v0, p0, p3

    .line 96
    aget v0, p0, p2

    aget v1, p0, p3

    xor-int/2addr v0, v1

    const/16 v1, 0xc

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/ChaCha20;->rotateLeft(II)I

    move-result v0

    aput v0, p0, p2

    .line 97
    aget v0, p0, p1

    aget v1, p0, p2

    add-int/2addr v0, v1

    aput v0, p0, p1

    .line 98
    aget v0, p0, p4

    aget p1, p0, p1

    xor-int/2addr p1, v0

    const/16 v0, 0x8

    invoke-static {p1, v0}, Lcom/google/crypto/tink/subtle/ChaCha20;->rotateLeft(II)I

    move-result p1

    aput p1, p0, p4

    .line 99
    aget p1, p0, p3

    aget p4, p0, p4

    add-int/2addr p1, p4

    aput p1, p0, p3

    .line 100
    aget p1, p0, p2

    aget p3, p0, p3

    xor-int/2addr p1, p3

    const/4 p3, 0x7

    invoke-static {p1, p3}, Lcom/google/crypto/tink/subtle/ChaCha20;->rotateLeft(II)I

    move-result p1

    aput p1, p0, p2

    return-void
.end method

.method private static setKey([I[B)V
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x10
        }
        names = {
            "state",
            "key"
        }
    .end annotation

    .line 75
    invoke-static {p1}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object p1

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/ChaCha20;->toIntArray(Ljava/nio/ByteBuffer;)[I

    move-result-object p1

    .line 76
    array-length v0, p1

    const/4 v1, 0x0

    const/4 v2, 0x4

    invoke-static {p1, v1, p0, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void
.end method

.method private static setSigma([I)V
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "state"
        }
    .end annotation

    .line 71
    sget-object v0, Lcom/google/crypto/tink/subtle/Snuffle;->SIGMA:[I

    sget-object v1, Lcom/google/crypto/tink/subtle/ChaCha20;->SIGMA:[I

    array-length v1, v1

    const/4 v2, 0x0

    invoke-static {v0, v2, p0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void
.end method

.method private static shuffleState([I)V
    .locals 16
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "state"
        }
    .end annotation

    move-object/from16 v0, p0

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    const/16 v3, 0xa

    if-ge v2, v3, :cond_0

    const/16 v4, 0xc

    const/16 v5, 0x8

    const/4 v6, 0x4

    .line 81
    invoke-static {v0, v1, v6, v5, v4}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    const/16 v7, 0xd

    const/16 v8, 0x9

    const/4 v9, 0x5

    const/4 v10, 0x1

    .line 82
    invoke-static {v0, v10, v9, v8, v7}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    const/16 v11, 0xe

    const/4 v12, 0x6

    const/4 v13, 0x2

    .line 83
    invoke-static {v0, v13, v12, v3, v11}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    const/16 v14, 0xf

    const/16 v15, 0xb

    const/4 v6, 0x7

    const/4 v8, 0x3

    .line 84
    invoke-static {v0, v8, v6, v15, v14}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    .line 85
    invoke-static {v0, v1, v9, v3, v14}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    .line 86
    invoke-static {v0, v10, v12, v15, v4}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    .line 87
    invoke-static {v0, v13, v6, v5, v7}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    const/16 v3, 0x9

    const/4 v4, 0x4

    .line 88
    invoke-static {v0, v8, v4, v3, v11}, Lcom/google/crypto/tink/subtle/ChaCha20;->quarterRound([IIIII)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method getKeyStreamBlock([BI)Ljava/nio/ByteBuffer;
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x0
        }
        names = {
            "nonce",
            "counter"
        }
    .end annotation

    .line 59
    invoke-direct {p0, p1, p2}, Lcom/google/crypto/tink/subtle/ChaCha20;->createInitialState([BI)[I

    move-result-object p1

    .line 60
    invoke-virtual {p1}, [I->clone()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, [I

    .line 61
    invoke-static {p2}, Lcom/google/crypto/tink/subtle/ChaCha20;->shuffleState([I)V

    const/4 v0, 0x0

    move v1, v0

    .line 62
    :goto_0
    array-length v2, p1

    if-ge v1, v2, :cond_0

    .line 63
    aget v2, p1, v1

    aget v3, p2, v1

    add-int/2addr v2, v3

    aput v2, p1, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    const/16 p2, 0x40

    .line 65
    invoke-static {p2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object p2

    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p2, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-result-object p2

    .line 66
    invoke-virtual {p2}, Ljava/nio/ByteBuffer;->asIntBuffer()Ljava/nio/IntBuffer;

    move-result-object v1

    const/16 v2, 0x10

    invoke-virtual {v1, p1, v0, v2}, Ljava/nio/IntBuffer;->put([III)Ljava/nio/IntBuffer;

    return-object p2
.end method

.method nonceSizeInBytes()I
    .locals 1

    const/16 v0, 0xc

    return v0
.end method
