.class public final Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "EciesAeadDemParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EciesAeadDemParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EciesAeadDemParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/EciesAeadDemParams;",
        "Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EciesAeadDemParamsOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 198
    invoke-static {}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->access$000()Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/EciesAeadDemParams$1;)V
    .locals 0

    .line 191
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearAeadDem()Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;
    .locals 1

    .line 266
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->copyOnWrite()V

    .line 267
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->access$400(Lcom/google/crypto/tink/proto/EciesAeadDemParams;)V

    return-object p0
.end method

.method public getAeadDem()Lcom/google/crypto/tink/proto/KeyTemplate;
    .locals 1

    .line 220
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->getAeadDem()Lcom/google/crypto/tink/proto/KeyTemplate;

    move-result-object v0

    return-object v0
.end method

.method public hasAeadDem()Z
    .locals 1

    .line 210
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->hasAeadDem()Z

    move-result v0

    return v0
.end method

.method public mergeAeadDem(Lcom/google/crypto/tink/proto/KeyTemplate;)Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->copyOnWrite()V

    .line 256
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->access$300(Lcom/google/crypto/tink/proto/EciesAeadDemParams;Lcom/google/crypto/tink/proto/KeyTemplate;)V

    return-object p0
.end method

.method public setAeadDem(Lcom/google/crypto/tink/proto/KeyTemplate$Builder;)Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 243
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->copyOnWrite()V

    .line 244
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->access$200(Lcom/google/crypto/tink/proto/EciesAeadDemParams;Lcom/google/crypto/tink/proto/KeyTemplate$Builder;)V

    return-object p0
.end method

.method public setAeadDem(Lcom/google/crypto/tink/proto/KeyTemplate;)Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 230
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->copyOnWrite()V

    .line 231
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadDemParams;->access$100(Lcom/google/crypto/tink/proto/EciesAeadDemParams;Lcom/google/crypto/tink/proto/KeyTemplate;)V

    return-object p0
.end method
