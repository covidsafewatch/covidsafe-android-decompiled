.class public final Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "EncryptedKeyset.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EncryptedKeysetOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EncryptedKeyset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/EncryptedKeyset;",
        "Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EncryptedKeysetOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 244
    invoke-static {}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$000()Lcom/google/crypto/tink/proto/EncryptedKeyset;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/EncryptedKeyset$1;)V
    .locals 0

    .line 237
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearEncryptedKeyset()Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1

    .line 278
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 279
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$200(Lcom/google/crypto/tink/proto/EncryptedKeyset;)V

    return-object p0
.end method

.method public clearKeysetInfo()Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1

    .line 347
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 348
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$600(Lcom/google/crypto/tink/proto/EncryptedKeyset;)V

    return-object p0
.end method

.method public getEncryptedKeyset()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 256
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getEncryptedKeyset()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getKeysetInfo()Lcom/google/crypto/tink/proto/KeysetInfo;
    .locals 1

    .line 301
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getKeysetInfo()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v0

    return-object v0
.end method

.method public hasKeysetInfo()Z
    .locals 1

    .line 291
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->hasKeysetInfo()Z

    move-result v0

    return v0
.end method

.method public mergeKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 336
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 337
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$500(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-object p0
.end method

.method public setEncryptedKeyset(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 266
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 267
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$100(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo$Builder;)Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 324
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 325
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$400(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo$Builder;)V

    return-object p0
.end method

.method public setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->copyOnWrite()V

    .line 312
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->access$300(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-object p0
.end method
