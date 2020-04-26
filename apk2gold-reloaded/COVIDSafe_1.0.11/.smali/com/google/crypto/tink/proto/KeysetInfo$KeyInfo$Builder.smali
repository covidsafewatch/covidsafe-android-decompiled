.class public final Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KeysetInfo.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfoOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;",
        "Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfoOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 444
    invoke-static {}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$000()Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KeysetInfo$1;)V
    .locals 0

    .line 437
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyId()Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1

    .line 600
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 601
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$800(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public clearOutputPrefixType()Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1

    .line 657
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 658
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$1100(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public clearStatus()Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1

    .line 565
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 566
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$600(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public clearTypeUrl()Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1

    .line 494
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 495
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$200(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;)V

    return-object p0
.end method

.method public getKeyId()I
    .locals 1

    .line 578
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getKeyId()I

    move-result v0

    return v0
.end method

.method public getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;
    .locals 1

    .line 635
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;

    move-result-object v0

    return-object v0
.end method

.method public getOutputPrefixTypeValue()I
    .locals 1

    .line 613
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getOutputPrefixTypeValue()I

    move-result v0

    return v0
.end method

.method public getStatus()Lcom/google/crypto/tink/proto/KeyStatusType;
    .locals 1

    .line 543
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getStatus()Lcom/google/crypto/tink/proto/KeyStatusType;

    move-result-object v0

    return-object v0
.end method

.method public getStatusValue()I
    .locals 1

    .line 521
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getStatusValue()I

    move-result v0

    return v0
.end method

.method public getTypeUrl()Ljava/lang/String;
    .locals 1

    .line 457
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getTypeUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTypeUrlBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 469
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->getTypeUrlBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public setKeyId(I)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 588
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 589
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$700(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;I)V

    return-object p0
.end method

.method public setOutputPrefixType(Lcom/google/crypto/tink/proto/OutputPrefixType;)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 645
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 646
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$1000(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;Lcom/google/crypto/tink/proto/OutputPrefixType;)V

    return-object p0
.end method

.method public setOutputPrefixTypeValue(I)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 623
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 624
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$900(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;I)V

    return-object p0
.end method

.method public setStatus(Lcom/google/crypto/tink/proto/KeyStatusType;)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 553
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 554
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$500(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;Lcom/google/crypto/tink/proto/KeyStatusType;)V

    return-object p0
.end method

.method public setStatusValue(I)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 531
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 532
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$400(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;I)V

    return-object p0
.end method

.method public setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 481
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 482
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$100(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;Ljava/lang/String;)V

    return-object p0
.end method

.method public setTypeUrlBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 508
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->copyOnWrite()V

    .line 509
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;->access$300(Lcom/google/crypto/tink/proto/KeysetInfo$KeyInfo;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
