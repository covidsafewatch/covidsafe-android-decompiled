.class public final Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "KeyTemplate.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KeyTemplateOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/KeyTemplate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/KeyTemplate;",
        "Lcom/google/crypto/tink/proto/KeyTemplate$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KeyTemplateOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 301
    invoke-static {}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$000()Lcom/google/crypto/tink/proto/KeyTemplate;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/KeyTemplate$1;)V
    .locals 0

    .line 294
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearOutputPrefixType()Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1

    .line 460
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 461
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$800(Lcom/google/crypto/tink/proto/KeyTemplate;)V

    return-object p0
.end method

.method public clearTypeUrl()Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1

    .line 347
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 348
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$200(Lcom/google/crypto/tink/proto/KeyTemplate;)V

    return-object p0
.end method

.method public clearValue()Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1

    .line 398
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 399
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$500(Lcom/google/crypto/tink/proto/KeyTemplate;)V

    return-object p0
.end method

.method public getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;
    .locals 1

    .line 436
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->getOutputPrefixType()Lcom/google/crypto/tink/proto/OutputPrefixType;

    move-result-object v0

    return-object v0
.end method

.method public getOutputPrefixTypeValue()I
    .locals 1

    .line 412
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->getOutputPrefixTypeValue()I

    move-result v0

    return v0
.end method

.method public getTypeUrl()Ljava/lang/String;
    .locals 1

    .line 313
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->getTypeUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTypeUrlBytes()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 324
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->getTypeUrlBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 374
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KeyTemplate;->getValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public setOutputPrefixType(Lcom/google/crypto/tink/proto/OutputPrefixType;)Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 447
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 448
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$700(Lcom/google/crypto/tink/proto/KeyTemplate;Lcom/google/crypto/tink/proto/OutputPrefixType;)V

    return-object p0
.end method

.method public setOutputPrefixTypeValue(I)Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 423
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 424
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$600(Lcom/google/crypto/tink/proto/KeyTemplate;I)V

    return-object p0
.end method

.method public setTypeUrl(Ljava/lang/String;)Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 335
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 336
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$100(Lcom/google/crypto/tink/proto/KeyTemplate;Ljava/lang/String;)V

    return-object p0
.end method

.method public setTypeUrlBytes(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 360
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 361
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$300(Lcom/google/crypto/tink/proto/KeyTemplate;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method

.method public setValue(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KeyTemplate$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 385
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->copyOnWrite()V

    .line 386
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KeyTemplate$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/KeyTemplate;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/KeyTemplate;->access$400(Lcom/google/crypto/tink/proto/KeyTemplate;Lcom/google/protobuf/ByteString;)V

    return-object p0
.end method
