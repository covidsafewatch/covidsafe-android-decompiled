.class public final Lcom/google/crypto/tink/proto/HmacKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "HmacKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/HmacKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/HmacKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/HmacKey;",
        "Lcom/google/crypto/tink/proto/HmacKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/HmacKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 238
    invoke-static {}, Lcom/google/crypto/tink/proto/HmacKey;->access$000()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/HmacKey$1;)V
    .locals 0

    .line 231
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1

    .line 328
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 329
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacKey;->access$800(Lcom/google/crypto/tink/proto/HmacKey;)V

    return-object p0
.end method

.method public clearParams()Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1

    .line 305
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 306
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacKey;->access$600(Lcom/google/crypto/tink/proto/HmacKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1

    .line 260
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 261
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacKey;->access$200(Lcom/google/crypto/tink/proto/HmacKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 314
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/HmacParams;
    .locals 1

    .line 275
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacKey;->getParams()Lcom/google/crypto/tink/proto/HmacParams;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 246
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 269
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacKey;->hasParams()Z

    move-result v0

    return v0
.end method

.method public mergeParams(Lcom/google/crypto/tink/proto/HmacParams;)Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 298
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 299
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey;->access$500(Lcom/google/crypto/tink/proto/HmacKey;Lcom/google/crypto/tink/proto/HmacParams;)V

    return-object p0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 320
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 321
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey;->access$700(Lcom/google/crypto/tink/proto/HmacKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/HmacParams$Builder;)Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 290
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 291
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey;->access$400(Lcom/google/crypto/tink/proto/HmacKey;Lcom/google/crypto/tink/proto/HmacParams$Builder;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/HmacParams;)Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 281
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 282
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey;->access$300(Lcom/google/crypto/tink/proto/HmacKey;Lcom/google/crypto/tink/proto/HmacParams;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/HmacKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 252
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->copyOnWrite()V

    .line 253
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey;->access$100(Lcom/google/crypto/tink/proto/HmacKey;I)V

    return-object p0
.end method
