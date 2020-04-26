.class Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding$1;
.super Ljava/lang/Object;
.source "EcdsaSignatureEncoding.java"

# interfaces
.implements Lcom/google/protobuf/Internal$EnumLiteMap;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/protobuf/Internal$EnumLiteMap<",
        "Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public findValueByNumber(I)Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "number"
        }
    .end annotation

    .line 99
    invoke-static {p1}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->forNumber(I)Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic findValueByNumber(I)Lcom/google/protobuf/Internal$EnumLite;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000
        }
        names = {
            "number"
        }
    .end annotation

    .line 97
    invoke-virtual {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding$1;->findValueByNumber(I)Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    move-result-object p1

    return-object p1
.end method
