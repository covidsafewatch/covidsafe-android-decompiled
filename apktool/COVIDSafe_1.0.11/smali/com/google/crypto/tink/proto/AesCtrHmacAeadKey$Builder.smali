.class public final Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "AesCtrHmacAeadKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesCtrHmacAeadKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 263
    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$000()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$1;)V
    .locals 0

    .line 256
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1

    .line 330
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 331
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$600(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V

    return-object p0
.end method

.method public clearHmacKey()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1

    .line 375
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 376
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$1000(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1

    .line 285
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 286
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$200(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V

    return-object p0
.end method

.method public getAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrKey;
    .locals 1

    .line 300
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrKey;

    move-result-object v0

    return-object v0
.end method

.method public getHmacKey()Lcom/google/crypto/tink/proto/HmacKey;
    .locals 1

    .line 345
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getHmacKey()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 271
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasAesCtrKey()Z
    .locals 1

    .line 294
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hasAesCtrKey()Z

    move-result v0

    return v0
.end method

.method public hasHmacKey()Z
    .locals 1

    .line 339
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hasHmacKey()Z

    move-result v0

    return v0
.end method

.method public mergeAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 323
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 324
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$500(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey;)V

    return-object p0
.end method

.method public mergeHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 368
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 369
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$900(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey;)V

    return-object p0
.end method

.method public setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey$Builder;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 315
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 316
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$400(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey$Builder;)V

    return-object p0
.end method

.method public setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 306
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 307
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$300(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey;)V

    return-object p0
.end method

.method public setHmacKey(Lcom/google/crypto/tink/proto/HmacKey$Builder;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 360
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 361
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$800(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey$Builder;)V

    return-object p0
.end method

.method public setHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 351
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 352
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$700(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 277
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->copyOnWrite()V

    .line 278
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->access$100(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;I)V

    return-object p0
.end method
