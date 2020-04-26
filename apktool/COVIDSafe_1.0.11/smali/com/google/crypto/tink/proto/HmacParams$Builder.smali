.class public final Lcom/google/crypto/tink/proto/HmacParams$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "HmacParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/HmacParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/HmacParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/HmacParams;",
        "Lcom/google/crypto/tink/proto/HmacParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/HmacParamsOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 203
    invoke-static {}, Lcom/google/crypto/tink/proto/HmacParams;->access$000()Lcom/google/crypto/tink/proto/HmacParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/HmacParams$1;)V
    .locals 0

    .line 196
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearHash()Lcom/google/crypto/tink/proto/HmacParams$Builder;
    .locals 1

    .line 259
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;->copyOnWrite()V

    .line 260
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacParams;->access$300(Lcom/google/crypto/tink/proto/HmacParams;)V

    return-object p0
.end method

.method public clearTagSize()Lcom/google/crypto/tink/proto/HmacParams$Builder;
    .locals 1

    .line 282
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;->copyOnWrite()V

    .line 283
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacParams;->access$500(Lcom/google/crypto/tink/proto/HmacParams;)V

    return-object p0
.end method

.method public getHash()Lcom/google/crypto/tink/proto/HashType;
    .locals 1

    .line 237
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacParams;->getHash()Lcom/google/crypto/tink/proto/HashType;

    move-result-object v0

    return-object v0
.end method

.method public getHashValue()I
    .locals 1

    .line 215
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacParams;->getHashValue()I

    move-result v0

    return v0
.end method

.method public getTagSize()I
    .locals 1

    .line 268
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/HmacParams;->getTagSize()I

    move-result v0

    return v0
.end method

.method public setHash(Lcom/google/crypto/tink/proto/HashType;)Lcom/google/crypto/tink/proto/HmacParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 247
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;->copyOnWrite()V

    .line 248
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacParams;->access$200(Lcom/google/crypto/tink/proto/HmacParams;Lcom/google/crypto/tink/proto/HashType;)V

    return-object p0
.end method

.method public setHashValue(I)Lcom/google/crypto/tink/proto/HmacParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 225
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;->copyOnWrite()V

    .line 226
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacParams;->access$100(Lcom/google/crypto/tink/proto/HmacParams;I)V

    return-object p0
.end method

.method public setTagSize(I)Lcom/google/crypto/tink/proto/HmacParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 274
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/HmacParams$Builder;->copyOnWrite()V

    .line 275
    iget-object v0, p0, Lcom/google/crypto/tink/proto/HmacParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/HmacParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/HmacParams;->access$400(Lcom/google/crypto/tink/proto/HmacParams;I)V

    return-object p0
.end method
