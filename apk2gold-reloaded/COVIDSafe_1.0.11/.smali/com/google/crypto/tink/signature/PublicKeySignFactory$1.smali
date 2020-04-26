.class Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;
.super Ljava/lang/Object;
.source "PublicKeySignFactory.java"

# interfaces
.implements Lcom/google/crypto/tink/PublicKeySign;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/crypto/tink/signature/PublicKeySignFactory;->getPrimitive(Lcom/google/crypto/tink/KeysetHandle;Lcom/google/crypto/tink/KeyManager;)Lcom/google/crypto/tink/PublicKeySign;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$primitives:Lcom/google/crypto/tink/PrimitiveSet;


# direct methods
.method constructor <init>(Lcom/google/crypto/tink/PrimitiveSet;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1010
        }
        names = {
            "val$primitives"
        }
    .end annotation

    .line 67
    iput-object p1, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public sign([B)[B
    .locals 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "data"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 70
    iget-object v0, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    invoke-virtual {v0}, Lcom/google/crypto/tink/PrimitiveSet;->getPrimary()Lcom/google/crypto/tink/PrimitiveSet$Entry;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/PrimitiveSet$Entry;->getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;

    move-result-object v0

    sget-object v1, Lcom/google/crypto/tink/proto/OutputPrefixType;->LEGACY:Lcom/google/crypto/tink/proto/OutputPrefixType;

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/OutputPrefixType;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eqz v0, :cond_0

    new-array v0, v2, [B

    aput-byte v3, v0, v3

    new-array v4, v1, [[B

    .line 72
    iget-object v5, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    .line 73
    invoke-virtual {v5}, Lcom/google/crypto/tink/PrimitiveSet;->getPrimary()Lcom/google/crypto/tink/PrimitiveSet$Entry;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/crypto/tink/PrimitiveSet$Entry;->getIdentifier()[B

    move-result-object v5

    aput-object v5, v4, v3

    iget-object v5, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    .line 74
    invoke-virtual {v5}, Lcom/google/crypto/tink/PrimitiveSet;->getPrimary()Lcom/google/crypto/tink/PrimitiveSet$Entry;

    move-result-object v5

    invoke-virtual {v5}, Lcom/google/crypto/tink/PrimitiveSet$Entry;->getPrimitive()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/crypto/tink/PublicKeySign;

    new-array v1, v1, [[B

    aput-object p1, v1, v3

    aput-object v0, v1, v2

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Bytes;->concat([[B)[B

    move-result-object p1

    invoke-interface {v5, p1}, Lcom/google/crypto/tink/PublicKeySign;->sign([B)[B

    move-result-object p1

    aput-object p1, v4, v2

    .line 72
    invoke-static {v4}, Lcom/google/crypto/tink/subtle/Bytes;->concat([[B)[B

    move-result-object p1

    return-object p1

    :cond_0
    new-array v0, v1, [[B

    .line 76
    iget-object v1, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    .line 77
    invoke-virtual {v1}, Lcom/google/crypto/tink/PrimitiveSet;->getPrimary()Lcom/google/crypto/tink/PrimitiveSet$Entry;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/crypto/tink/PrimitiveSet$Entry;->getIdentifier()[B

    move-result-object v1

    aput-object v1, v0, v3

    iget-object v1, p0, Lcom/google/crypto/tink/signature/PublicKeySignFactory$1;->val$primitives:Lcom/google/crypto/tink/PrimitiveSet;

    .line 78
    invoke-virtual {v1}, Lcom/google/crypto/tink/PrimitiveSet;->getPrimary()Lcom/google/crypto/tink/PrimitiveSet$Entry;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/crypto/tink/PrimitiveSet$Entry;->getPrimitive()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/crypto/tink/PublicKeySign;

    invoke-interface {v1, p1}, Lcom/google/crypto/tink/PublicKeySign;->sign([B)[B

    move-result-object p1

    aput-object p1, v0, v2

    .line 76
    invoke-static {v0}, Lcom/google/crypto/tink/subtle/Bytes;->concat([[B)[B

    move-result-object p1

    return-object p1
.end method
