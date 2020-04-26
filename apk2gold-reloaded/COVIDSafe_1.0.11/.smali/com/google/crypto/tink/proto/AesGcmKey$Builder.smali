.class public final Lcom/google/crypto/tink/proto/AesGcmKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "AesGcmKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesGcmKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/AesGcmKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/AesGcmKey;",
        "Lcom/google/crypto/tink/proto/AesGcmKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesGcmKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 179
    invoke-static {}, Lcom/google/crypto/tink/proto/AesGcmKey;->access$000()Lcom/google/crypto/tink/proto/AesGcmKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/AesGcmKey$1;)V
    .locals 0

    .line 172
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyValue()Lcom/google/crypto/tink/proto/AesGcmKey$Builder;
    .locals 1

    .line 224
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->copyOnWrite()V

    .line 225
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesGcmKey;->access$400(Lcom/google/crypto/tink/proto/AesGcmKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/AesGcmKey$Builder;
    .locals 1

    .line 201
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->copyOnWrite()V

    .line 202
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesGcmKey;->access$200(Lcom/google/crypto/tink/proto/AesGcmKey;)V

    return-object p0
.end method

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 210
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesGcmKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 187
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesGcmKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public setKeyValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/AesGcmKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 216
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->copyOnWrite()V

    .line 217
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesGcmKey;->access$300(Lcom/google/crypto/tink/proto/AesGcmKey;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/AesGcmKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 193
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->copyOnWrite()V

    .line 194
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesGcmKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesGcmKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesGcmKey;->access$100(Lcom/google/crypto/tink/proto/AesGcmKey;I)V

    return-object p0
.end method
