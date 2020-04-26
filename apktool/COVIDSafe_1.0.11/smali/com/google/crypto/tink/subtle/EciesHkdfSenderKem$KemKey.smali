.class public final Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem$KemKey;
.super Ljava/lang/Object;
.source "EciesHkdfSenderKem.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "KemKey"
.end annotation


# instance fields
.field private final kemBytes:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

.field private final symmetricKey:Lcom/google/crypto/tink/subtle/ImmutableByteArray;


# direct methods
.method public constructor <init>([B[B)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10
        }
        names = {
            "kemBytes",
            "symmetricKey"
        }
    .end annotation

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-static {p1}, Lcom/google/crypto/tink/subtle/ImmutableByteArray;->of([B)Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem$KemKey;->kemBytes:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    .line 39
    invoke-static {p2}, Lcom/google/crypto/tink/subtle/ImmutableByteArray;->of([B)Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem$KemKey;->symmetricKey:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    return-void
.end method


# virtual methods
.method public getKemBytes()[B
    .locals 1

    .line 43
    iget-object v0, p0, Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem$KemKey;->kemBytes:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    .line 46
    :cond_0
    invoke-virtual {v0}, Lcom/google/crypto/tink/subtle/ImmutableByteArray;->getBytes()[B

    move-result-object v0

    return-object v0
.end method

.method public getSymmetricKey()[B
    .locals 1

    .line 51
    iget-object v0, p0, Lcom/google/crypto/tink/subtle/EciesHkdfSenderKem$KemKey;->symmetricKey:Lcom/google/crypto/tink/subtle/ImmutableByteArray;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    .line 54
    :cond_0
    invoke-virtual {v0}, Lcom/google/crypto/tink/subtle/ImmutableByteArray;->getBytes()[B

    move-result-object v0

    return-object v0
.end method
