.class public final Lcom/google/crypto/tink/proto/KeyData$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KeyData.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeyDataOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeyData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KeyData;",
        "Lcom/google/crypto/tink/proto/KeyData$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeyDataOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 409
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyData;->access$000()Lcom/google/crypto/tink/proto/KeyData;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KeyData$1;)V
    .locals 0

    .line 402
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearKeyMaterialType()Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1

    .line 560
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 561
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyData;->access$800(Lcom/google/crypto/tink/proto/KeyData;)V

    return-object p0
.end method

.method public clearTypeUrl()Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1

    .line 455
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 456
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyData;->access$200(Lcom/google/crypto/tink/proto/KeyData;)V

    return-object p0
.end method

.method public clearValue()Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1

    .line 503
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 504
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyData;->access$500(Lcom/google/crypto/tink/proto/KeyData;)V

    return-object p0
.end method

.method public getKeyMaterialType()Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;
    .locals 1

    .line 538
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyData;->getKeyMaterialType()Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;

    move-result-object v0

    return-object v0
.end method

.method public getKeyMaterialTypeValue()I
    .locals 1

    .line 516
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyData;->getKeyMaterialTypeValue()I

    move-result v0

    return v0
.end method

.method public getTypeUrl()Ljava/lang/String;
    .locals 1

    .line 421
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyData;->getTypeUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTypeUrlBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 432
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyData;->getTypeUrlBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 481
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyData;->getValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public setKeyMaterialType(Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;)Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 548
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 549
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyData;->access$700(Lcom/google/crypto/tink/proto/KeyData;Lcom/google/crypto/tink/proto/KeyData$KeyMaterialType;)V

    return-object p0
.end method

.method public setKeyMaterialTypeValue(I)Lcom/google/crypto/tink/proto/KeyData$Builder;
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
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 527
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyData;->access$600(Lcom/google/crypto/tink/proto/KeyData;I)V

    return-object p0
.end method

.method public setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 443
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 444
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyData;->access$100(Lcom/google/crypto/tink/proto/KeyData;Ljava/lang/String;)V

    return-object p0
.end method

.method public setTypeUrlBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 468
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 469
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyData;->access$300(Lcom/google/crypto/tink/proto/KeyData;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyData$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 491
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyData$Builder;->copyOnWrite()V

    .line 492
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyData$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyData;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyData;->access$400(Lcom/google/crypto/tink/proto/KeyData;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
