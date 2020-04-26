.class public final Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "EcdsaPrivateKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EcdsaPrivateKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EcdsaPrivateKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/EcdsaPrivateKey;",
        "Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EcdsaPrivateKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 289
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$000()Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/EcdsaPrivateKey$1;)V
    .locals 0

    .line 282
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1

    .line 430
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 431
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$800(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;)V

    return-object p0
.end method

.method public clearPublicKey()Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1

    .line 392
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 393
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$600(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1

    .line 323
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 324
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$200(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 406
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getPublicKey()Lcom/google/crypto/tink/proto/EcdsaPublicKey;
    .locals 1

    .line 346
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->getPublicKey()Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 301
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasPublicKey()Z
    .locals 1

    .line 336
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->hasPublicKey()Z

    move-result v0

    return v0
.end method

.method public mergePublicKey(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 381
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 382
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$500(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 417
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 418
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$700(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setPublicKey(Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;)Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 369
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 370
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$400(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;)V

    return-object p0
.end method

.method public setPublicKey(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 356
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 357
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$300(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 311
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->copyOnWrite()V

    .line 312
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPrivateKey;->access$100(Lcom/google/crypto/tink/proto/EcdsaPrivateKey;I)V

    return-object p0
.end method
