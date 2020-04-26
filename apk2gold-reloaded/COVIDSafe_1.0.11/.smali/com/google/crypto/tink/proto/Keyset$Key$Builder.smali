.class public final Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "Keyset.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/Keyset$KeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/Keyset$Key;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/Keyset$Key;",
        "Lcom/google/crypto/tink/proto/Keyset$Key$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/Keyset$KeyOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 437
    invoke-static {}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$000()Lcom/google/crypto/tink/proto/Keyset$Key;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/Keyset$1;)V
    .locals 0

    .line 430
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyData()Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1

    .line 511
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 512
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$400(Lcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public clearKeyId()Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1

    .line 586
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 587
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$900(Lcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public clearOutputPrefixType()Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1

    .line 648
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 649
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$1200(Lcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public clearStatus()Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1

    .line 548
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 549
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$700(Lcom/google/crypto/tink/proto/Keyset$Key;)V

    return-object p0
.end method

.method public getKeyData()Lcom/google/crypto/tink/proto/KeyData;
    .locals 1

    .line 461
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getKeyData()Lcom/google/crypto/tink/proto/KeyData;

    move-result-object v0

    return-object v0
.end method

.method public getKeyId()I
    .locals 1

    .line 562
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getKeyId()I

    move-result v0

    return v0
.end method

.method public getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;
    .locals 1

    .line 624
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;

    move-result-object v0

    return-object v0
.end method

.method public getOutputPrefixTypeValue()I
    .locals 1

    .line 600
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getOutputPrefixTypeValue()I

    move-result v0

    return v0
.end method

.method public getStatus()Lcom/google/crypto/tink/proto/KeyStatusType;
    .locals 1

    .line 534
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getStatus()Lcom/google/crypto/tink/proto/KeyStatusType;

    move-result-object v0

    return-object v0
.end method

.method public getStatusValue()I
    .locals 1

    .line 520
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->getStatusValue()I

    move-result v0

    return v0
.end method

.method public hasKeyData()Z
    .locals 1

    .line 450
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/Keyset$Key;->hasKeyData()Z

    move-result v0

    return v0
.end method

.method public mergeKeyData(Lcom/google/crypto/tink/proto/KeyData;)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 499
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 500
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$300(Lcom/google/crypto/tink/proto/Keyset$Key;Lcom/google/crypto/tink/proto/KeyData;)V

    return-object p0
.end method

.method public setKeyData(Lcom/google/crypto/tink/proto/KeyData$Builder;)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 486
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 487
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$200(Lcom/google/crypto/tink/proto/Keyset$Key;Lcom/google/crypto/tink/proto/KeyData$Builder;)V

    return-object p0
.end method

.method public setKeyData(Lcom/google/crypto/tink/proto/KeyData;)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 472
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 473
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$100(Lcom/google/crypto/tink/proto/Keyset$Key;Lcom/google/crypto/tink/proto/KeyData;)V

    return-object p0
.end method

.method public setKeyId(I)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 573
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 574
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$800(Lcom/google/crypto/tink/proto/Keyset$Key;I)V

    return-object p0
.end method

.method public setOutputPrefixType(Lcom/google/crypto/tink/proto/OutputPrefixType;)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 635
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 636
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$1100(Lcom/google/crypto/tink/proto/Keyset$Key;Lcom/google/crypto/tink/proto/OutputPrefixType;)V

    return-object p0
.end method

.method public setOutputPrefixTypeValue(I)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 611
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 612
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$1000(Lcom/google/crypto/tink/proto/Keyset$Key;I)V

    return-object p0
.end method

.method public setStatus(Lcom/google/crypto/tink/proto/KeyStatusType;)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 540
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 541
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$600(Lcom/google/crypto/tink/proto/Keyset$Key;Lcom/google/crypto/tink/proto/KeyStatusType;)V

    return-object p0
.end method

.method public setStatusValue(I)Lcom/google/crypto/tink/proto/Keyset$Key$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 526
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->copyOnWrite()V

    .line 527
    iget-object v0, p0, Lcom/google/crypto/tink/proto/Keyset$Key$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/Keyset$Key;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/Keyset$Key;->access$500(Lcom/google/crypto/tink/proto/Keyset$Key;I)V

    return-object p0
.end method
