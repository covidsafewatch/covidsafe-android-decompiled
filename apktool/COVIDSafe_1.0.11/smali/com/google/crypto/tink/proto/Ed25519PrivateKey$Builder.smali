.class public final Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "Ed25519PrivateKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/Ed25519PrivateKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/Ed25519PrivateKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/Ed25519PrivateKey;",
        "Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/Ed25519PrivateKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 292
    invoke-static {}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$000()Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/Ed25519PrivateKey$1;)V
    .locals 0

    .line 285
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1

    .line 367
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 368
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$400(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;)V

    return-object p0
.end method

.method public clearPublicKey()Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1

    .line 436
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 437
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$800(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1

    .line 326
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 327
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$200(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 341
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getPublicKey()Lcom/google/crypto/tink/proto/Ed25519PublicKey;
    .locals 1

    .line 390
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getPublicKey()Lcom/google/crypto/tink/proto/Ed25519PublicKey;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 304
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasPublicKey()Z
    .locals 1

    .line 380
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->hasPublicKey()Z

    move-result v0

    return v0
.end method

.method public mergePublicKey(Lcom/google/crypto/tink/proto/Ed25519PublicKey;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 425
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 426
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$700(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;Lcom/google/crypto/tink/proto/Ed25519PublicKey;)V

    return-object p0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 353
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 354
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$300(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setPublicKey(Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 413
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 414
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$600(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;Lcom/google/crypto/tink/proto/Ed25519PublicKey$Builder;)V

    return-object p0
.end method

.method public setPublicKey(Lcom/google/crypto/tink/proto/Ed25519PublicKey;)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 400
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 401
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$500(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;Lcom/google/crypto/tink/proto/Ed25519PublicKey;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 314
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->copyOnWrite()V

    .line 315
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Ed25519PrivateKey;->access$100(Lcom/google/crypto/tink/proto/Ed25519PrivateKey;I)V

    return-object p0
.end method
