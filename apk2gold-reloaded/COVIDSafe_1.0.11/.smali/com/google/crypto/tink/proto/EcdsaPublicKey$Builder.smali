.class public final Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "EcdsaPublicKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EcdsaPublicKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EcdsaPublicKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKey;",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 344
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$000()Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/EcdsaPublicKey$1;)V
    .locals 0

    .line 337
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearParams()Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1

    .line 447
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 448
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$600(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1

    .line 378
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 379
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$200(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public clearX()Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1

    .line 494
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 495
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$800(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public clearY()Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1

    .line 529
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 530
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$1000(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V

    return-object p0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/EcdsaParams;
    .locals 1

    .line 401
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getParams()Lcom/google/crypto/tink/proto/EcdsaParams;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 356
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public getX()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 464
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getX()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getY()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 507
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getY()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public hasParams()Z
    .locals 1

    .line 391
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->hasParams()Z

    move-result v0

    return v0
.end method

.method public mergeParams(Lcom/google/crypto/tink/proto/EcdsaParams;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 436
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 437
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$500(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/EcdsaParams$Builder;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 424
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 425
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$400(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams$Builder;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/EcdsaParams;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 411
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 412
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$300(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 366
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 367
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$100(Lcom/google/crypto/tink/proto/EcdsaPublicKey;I)V

    return-object p0
.end method

.method public setX(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 478
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 479
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$700(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setY(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 517
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->copyOnWrite()V

    .line 518
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->access$900(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
