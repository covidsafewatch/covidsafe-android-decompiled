.class public final Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KmsEnvelopeAeadKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;",
        "Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 228
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$000()Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$1;)V
    .locals 0

    .line 221
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearParams()Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
    .locals 1

    .line 319
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 320
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$600(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;)V

    return-object p0
.end method

.method public clearVersion()Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
    .locals 1

    .line 250
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 251
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$200(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;)V

    return-object p0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;
    .locals 1

    .line 273
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->getParams()Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;

    move-result-object v0

    return-object v0
.end method

.method public getVersion()I
    .locals 1

    .line 236
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->getVersion()I

    move-result v0

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 263
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->hasParams()Z

    move-result v0

    return v0
.end method

.method public mergeParams(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 309
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$500(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat$Builder;)Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 297
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$400(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat$Builder;)V

    return-object p0
.end method

.method public setParams(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 284
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$300(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat;)V

    return-object p0
.end method

.method public setVersion(I)Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->copyOnWrite()V

    .line 243
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;->access$100(Lcom/google/crypto/tink/proto/KmsEnvelopeAeadKey;I)V

    return-object p0
.end method
