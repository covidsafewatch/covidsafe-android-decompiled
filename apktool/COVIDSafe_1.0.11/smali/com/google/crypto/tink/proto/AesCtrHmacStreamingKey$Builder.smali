.class public final Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "AesCtrHmacStreamingKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 250
    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$000()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$1;)V
    .locals 0

    .line 243
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1

    .line 352
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 353
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$800(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;)V

    return-object p0
.end method

.method public clearParams()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1

    .line 317
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 318
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$600(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1

    .line 272
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 273
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$200(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 330
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;
    .locals 1

    .line 287
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->getParams()Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 258
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 281
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->hasParams()Z

    move-result v0

    return v0
.end method

.method public mergeParams(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;)Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 310
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 311
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$500(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;)V

    return-object p0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 340
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 341
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$700(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams$Builder;)Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 302
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 303
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$400(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams$Builder;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;)Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 293
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 294
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$300(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;Lcom/google/crypto/tink/proto/AesCtrHmacStreamingParams;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 264
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->copyOnWrite()V

    .line 265
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;->access$100(Lcom/google/crypto/tink/proto/AesCtrHmacStreamingKey;I)V

    return-object p0
.end method
