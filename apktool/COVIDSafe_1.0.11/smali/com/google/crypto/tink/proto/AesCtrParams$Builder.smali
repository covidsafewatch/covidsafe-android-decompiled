.class public final Lcom/google/crypto/tink/proto/AesCtrParams$Builder;
.super Lcom/google/protobuf/GeneratedMessageLite$Builder;
.source "AesCtrParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesCtrParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/AesCtrParams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite$Builder<",
        "Lcom/google/crypto/tink/proto/AesCtrParams;",
        "Lcom/google/crypto/tink/proto/AesCtrParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesCtrParamsOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 137
    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrParams;->access$000()Lcom/google/crypto/tink/proto/AesCtrParams;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/protobuf/GeneratedMessageLite$Builder;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/crypto/tink/proto/AesCtrParams$1;)V
    .locals 0

    .line 130
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearIvSize()Lcom/google/crypto/tink/proto/AesCtrParams$Builder;
    .locals 1

    .line 159
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;->copyOnWrite()V

    .line 160
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrParams;

    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrParams;->access$200(Lcom/google/crypto/tink/proto/AesCtrParams;)V

    return-object p0
.end method

.method public getIvSize()I
    .locals 1

    .line 145
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrParams;->getIvSize()I

    move-result v0

    return v0
.end method

.method public setIvSize(I)Lcom/google/crypto/tink/proto/AesCtrParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 151
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;->copyOnWrite()V

    .line 152
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrParams$Builder;->instance:Lcom/google/protobuf/GeneratedMessageLite;

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrParams;

    invoke-static {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrParams;->access$100(Lcom/google/crypto/tink/proto/AesCtrParams;I)V

    return-object p0
.end method
