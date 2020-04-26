.class public final Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "EciesAeadHkdfParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EciesAeadHkdfParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;",
        "Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EciesAeadHkdfParamsOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 356
    invoke-static {}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$000()Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$1;)V
    .locals 0

    .line 349
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearDemParams()Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1

    .line 505
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 506
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$800(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;)V

    return-object p0
.end method

.method public clearEcPointFormat()Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1

    .line 567
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 568
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$1100(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;)V

    return-object p0
.end method

.method public clearKemParams()Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1

    .line 430
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 431
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$400(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;)V

    return-object p0
.end method

.method public getDemParams()Lcom/google/crypto/tink/proto/EciesAeadDemParams;
    .locals 1

    .line 455
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->getDemParams()Lcom/google/crypto/tink/proto/EciesAeadDemParams;

    move-result-object v0

    return-object v0
.end method

.method public getEcPointFormat()Lcom/google/crypto/tink/proto/EcPointFormat;
    .locals 1

    .line 543
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->getEcPointFormat()Lcom/google/crypto/tink/proto/EcPointFormat;

    move-result-object v0

    return-object v0
.end method

.method public getEcPointFormatValue()I
    .locals 1

    .line 519
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->getEcPointFormatValue()I

    move-result v0

    return v0
.end method

.method public getKemParams()Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1

    .line 380
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->getKemParams()Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    move-result-object v0

    return-object v0
.end method

.method public hasDemParams()Z
    .locals 1

    .line 444
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->hasDemParams()Z

    move-result v0

    return v0
.end method

.method public hasKemParams()Z
    .locals 1

    .line 369
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->hasKemParams()Z

    move-result v0

    return v0
.end method

.method public mergeDemParams(Lcom/google/crypto/tink/proto/EciesAeadDemParams;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 493
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 494
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$700(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesAeadDemParams;)V

    return-object p0
.end method

.method public mergeKemParams(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 418
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 419
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$300(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)V

    return-object p0
.end method

.method public setDemParams(Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 480
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 481
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$600(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesAeadDemParams$Builder;)V

    return-object p0
.end method

.method public setDemParams(Lcom/google/crypto/tink/proto/EciesAeadDemParams;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 466
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 467
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$500(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesAeadDemParams;)V

    return-object p0
.end method

.method public setEcPointFormat(Lcom/google/crypto/tink/proto/EcPointFormat;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 554
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 555
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$1000(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EcPointFormat;)V

    return-object p0
.end method

.method public setEcPointFormatValue(I)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 530
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 531
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$900(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;I)V

    return-object p0
.end method

.method public setKemParams(Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 405
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 406
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$200(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;)V

    return-object p0
.end method

.method public setKemParams(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 391
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->copyOnWrite()V

    .line 392
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;->access$100(Lcom/google/crypto/tink/proto/EciesAeadHkdfParams;Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)V

    return-object p0
.end method
