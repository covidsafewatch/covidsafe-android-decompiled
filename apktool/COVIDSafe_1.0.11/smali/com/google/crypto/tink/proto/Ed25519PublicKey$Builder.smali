.class public final Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "Ed25519PublicKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/Ed25519PublicKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/Ed25519PublicKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/Ed25519PublicKey;",
        "Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/Ed25519PublicKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 209
    invoke-static {}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->access$000()Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/Ed25519PublicKey$1;)V
    .locals 0

    .line 202
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;
    .locals 1

    .line 284
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->copyOnWrite()V

    .line 285
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->access$400(Lcom/google/crypto/tink/proto/Ed25519PublicKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;
    .locals 1

    .line 243
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->copyOnWrite()V

    .line 244
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->access$200(Lcom/google/crypto/tink/proto/Ed25519PublicKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 258
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 221
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 270
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->copyOnWrite()V

    .line 271
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->access$300(Lcom/google/crypto/tink/proto/Ed25519PublicKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 231
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->copyOnWrite()V

    .line 232
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PublicKey;->access$100(Lcom/google/crypto/tink/proto/Ed25519PublicKey;I)V

    return-object p0
.end method
