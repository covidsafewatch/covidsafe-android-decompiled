.class public final Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KeyTypeEntry.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeyTypeEntryOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeyTypeEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KeyTypeEntry;",
        "Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeyTypeEntryOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 425
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$000()Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KeyTypeEntry$1;)V
    .locals 0

    .line 418
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearCatalogueName()Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1

    .line 661
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 662
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$1200(Lcom/google/crypto/tink/proto/KeyTypeEntry;)V

    return-object p0
.end method

.method public clearKeyManagerVersion()Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1

    .line 579
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 580
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$800(Lcom/google/crypto/tink/proto/KeyTypeEntry;)V

    return-object p0
.end method

.method public clearNewKeyAllowed()Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1

    .line 614
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 615
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$1000(Lcom/google/crypto/tink/proto/KeyTypeEntry;)V

    return-object p0
.end method

.method public clearPrimitiveName()Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1

    .line 471
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 472
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$200(Lcom/google/crypto/tink/proto/KeyTypeEntry;)V

    return-object p0
.end method

.method public clearTypeUrl()Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1

    .line 531
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 532
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$500(Lcom/google/crypto/tink/proto/KeyTypeEntry;)V

    return-object p0
.end method

.method public getCatalogueName()Ljava/lang/String;
    .locals 1

    .line 627
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getCatalogueName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCatalogueNameBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 638
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getCatalogueNameBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getKeyManagerVersion()I
    .locals 1

    .line 557
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getKeyManagerVersion()I

    move-result v0

    return v0
.end method

.method public getNewKeyAllowed()Z
    .locals 1

    .line 592
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getNewKeyAllowed()Z

    move-result v0

    return v0
.end method

.method public getPrimitiveName()Ljava/lang/String;
    .locals 1

    .line 437
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getPrimitiveName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPrimitiveNameBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 448
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getPrimitiveNameBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getTypeUrl()Ljava/lang/String;
    .locals 1

    .line 497
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getTypeUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTypeUrlBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 508
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->getTypeUrlBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public setCatalogueName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 649
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 650
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$1100(Lcom/google/crypto/tink/proto/KeyTypeEntry;Ljava/lang/String;)V

    return-object p0
.end method

.method public setCatalogueNameBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 674
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 675
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$1300(Lcom/google/crypto/tink/proto/KeyTypeEntry;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setKeyManagerVersion(I)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 567
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 568
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$700(Lcom/google/crypto/tink/proto/KeyTypeEntry;I)V

    return-object p0
.end method

.method public setNewKeyAllowed(Z)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 602
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 603
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$900(Lcom/google/crypto/tink/proto/KeyTypeEntry;Z)V

    return-object p0
.end method

.method public setPrimitiveName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 459
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 460
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$100(Lcom/google/crypto/tink/proto/KeyTypeEntry;Ljava/lang/String;)V

    return-object p0
.end method

.method public setPrimitiveNameBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 484
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 485
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$300(Lcom/google/crypto/tink/proto/KeyTypeEntry;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 519
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 520
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$400(Lcom/google/crypto/tink/proto/KeyTypeEntry;Ljava/lang/String;)V

    return-object p0
.end method

.method public setTypeUrlBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 544
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->copyOnWrite()V

    .line 545
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTypeEntry$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTypeEntry;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTypeEntry;->access$600(Lcom/google/crypto/tink/proto/KeyTypeEntry;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
