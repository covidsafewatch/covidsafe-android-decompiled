.class public final Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KmsAeadKeyFormat.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KmsAeadKeyFormatOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;",
        "Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KmsAeadKeyFormatOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 206
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->access$000()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$1;)V
    .locals 0

    .line 199
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyUri()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;
    .locals 1

    .line 272
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->copyOnWrite()V

    .line 273
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->access$200(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V

    return-object p0
.end method

.method public getKeyUri()Ljava/lang/String;
    .locals 1

    .line 223
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->getKeyUri()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getKeyUriBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 239
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->getKeyUriBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public setKeyUri(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 255
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->copyOnWrite()V

    .line 256
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->access$100(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;Ljava/lang/String;)V

    return-object p0
.end method

.method public setKeyUriBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 290
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->copyOnWrite()V

    .line 291
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->access$300(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
