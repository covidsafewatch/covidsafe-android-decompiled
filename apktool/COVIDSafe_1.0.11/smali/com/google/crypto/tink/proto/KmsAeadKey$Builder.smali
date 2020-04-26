.class public final Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KmsAeadKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KmsAeadKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KmsAeadKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KmsAeadKey;",
        "Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KmsAeadKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 228
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$000()Lcom/google/crypto/tink/proto/KmsAeadKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KmsAeadKey$1;)V
    .locals 0

    .line 221
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearParams()Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1

    .line 319
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 320
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$600(Lcom/google/crypto/tink/proto/KmsAeadKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1

    .line 250
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 251
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$200(Lcom/google/crypto/tink/proto/KmsAeadKey;)V

    return-object p0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;
    .locals 1

    .line 273
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 236
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 263
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->hasParams()Z

    move-result v0

    return v0
.end method

.method public mergeParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 308
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 309
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$500(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 296
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 297
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$400(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 283
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 284
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$300(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 242
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->copyOnWrite()V

    .line 243
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->access$100(Lcom/google/crypto/tink/proto/KmsAeadKey;I)V

    return-object p0
.end method
