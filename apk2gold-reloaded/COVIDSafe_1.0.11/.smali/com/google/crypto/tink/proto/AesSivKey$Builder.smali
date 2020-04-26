.class public final Lcom/google/crypto/tink/proto/AesSivKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "AesSivKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesSivKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/AesSivKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/AesSivKey;",
        "Lcom/google/crypto/tink/proto/AesSivKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesSivKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 191
    invoke-static {}, Lcom/google/crypto/tink/proto/AesSivKey;->access$000()Lcom/google/crypto/tink/proto/AesSivKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/AesSivKey$1;)V
    .locals 0

    .line 184
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesSivKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/AesSivKey$Builder;
    .locals 1

    .line 248
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->copyOnWrite()V

    .line 249
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesSivKey;->access$400(Lcom/google/crypto/tink/proto/AesSivKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/AesSivKey$Builder;
    .locals 1

    .line 213
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->copyOnWrite()V

    .line 214
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesSivKey;->access$200(Lcom/google/crypto/tink/proto/AesSivKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 226
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesSivKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 199
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesSivKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/AesSivKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 236
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->copyOnWrite()V

    .line 237
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesSivKey;->access$300(Lcom/google/crypto/tink/proto/AesSivKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/AesSivKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 205
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->copyOnWrite()V

    .line 206
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesSivKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesSivKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesSivKey;->access$100(Lcom/google/crypto/tink/proto/AesSivKey;I)V

    return-object p0
.end method
