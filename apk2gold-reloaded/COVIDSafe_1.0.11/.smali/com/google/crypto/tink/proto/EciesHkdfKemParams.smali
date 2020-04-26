.class public final Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "EciesHkdfKemParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EciesHkdfKemParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/EciesHkdfKemParams;",
        "Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EciesHkdfKemParamsOrBuilder;"
    }
.end annotation


# static fields
.field public static final CURVE_TYPE_FIELD_NUMBER:I = 0x1

.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

.field public static final HKDF_HASH_TYPE_FIELD_NUMBER:I = 0x2

.field public static final HKDF_SALT_FIELD_NUMBER:I = 0xb

.field private static volatile PARSER:Lcom/google/protobuf/Parser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EciesHkdfKemParams;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private curveType_:I

.field private hkdfHashType_:I

.field private hkdfSalt_:Lcom/google/protobuf/ByteString;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 545
    new-instance v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    .line 546
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    .line 19
    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->setCurveTypeValue(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;Lcom/google/crypto/tink/proto/EllipticCurveType;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->setCurveType(Lcom/google/crypto/tink/proto/EllipticCurveType;)V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->clearCurveType()V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->setHkdfHashTypeValue(I)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;Lcom/google/crypto/tink/proto/HashType;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->setHkdfHashType(Lcom/google/crypto/tink/proto/HashType;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->clearHkdfHashType()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;Lcom/google/protobuf/ByteString;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->setHkdfSalt(Lcom/google/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$800(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->clearHkdfSalt()V

    return-void
.end method

.method private clearCurveType()V
    .locals 1

    const/4 v0, 0x0

    .line 77
    iput v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    return-void
.end method

.method private clearHkdfHashType()V
    .locals 1

    const/4 v0, 0x0

    .line 136
    iput v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    return-void
.end method

.method private clearHkdfSalt()V
    .locals 1

    .line 174
    invoke-static {}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->getDefaultInstance()Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->getHkdfSalt()Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1

    .line 550
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object v0
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;
    .locals 1

    .line 273
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/EciesHkdfKemParams;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 276
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "input"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 250
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "input",
            "extensionRegistry"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 256
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "data"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 214
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "data",
            "extensionRegistry"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 221
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "input"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 261
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "input",
            "extensionRegistry"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 268
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "input"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 238
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "input",
            "extensionRegistry"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 245
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "data"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 226
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EciesHkdfKemParams;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "data",
            "extensionRegistry"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 233
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EciesHkdfKemParams;",
            ">;"
        }
    .end annotation

    .line 556
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setCurveType(Lcom/google/crypto/tink/proto/EllipticCurveType;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    if-eqz p1, :cond_0

    .line 66
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 63
    throw p1
.end method

.method private setCurveTypeValue(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 52
    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    return-void
.end method

.method private setHkdfHashType(Lcom/google/crypto/tink/proto/HashType;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    if-eqz p1, :cond_0

    .line 125
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 122
    throw p1
.end method

.method private setHkdfHashTypeValue(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 111
    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    return-void
.end method

.method private setHkdfSalt(Lcom/google/protobuf/ByteString;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    if-eqz p1, :cond_0

    .line 163
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 160
    throw p1
.end method


# virtual methods
.method protected final dynamicMethod(Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "method",
            "arg0",
            "arg1"
        }
    .end annotation

    .line 452
    sget-object v0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 538
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 529
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    monitor-enter p1

    .line 530
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 531
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->PARSER:Lcom/google/protobuf/Parser;

    .line 533
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 535
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 478
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 480
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v1, :cond_7

    .line 485
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_6

    const/16 p3, 0x8

    if-eq p1, p3, :cond_5

    const/16 p3, 0x10

    if-eq p1, p3, :cond_4

    const/16 p3, 0x5a

    if-eq p1, p3, :cond_3

    .line 491
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_2

    .line 510
    :cond_3
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    goto :goto_1

    .line 503
    :cond_4
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result p1

    .line 505
    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    goto :goto_1

    .line 497
    :cond_5
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result p1

    .line 499
    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I
    :try_end_1
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :cond_6
    :goto_2
    move v1, v2

    goto :goto_1

    :catchall_1
    move-exception p1

    goto :goto_3

    :catch_0
    move-exception p1

    .line 518
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 520
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 516
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 521
    :goto_3
    throw p1

    .line 526
    :cond_7
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p1

    .line 466
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 467
    check-cast p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    .line 468
    iget p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    if-eqz p1, :cond_8

    move p1, v2

    goto :goto_4

    :cond_8
    move p1, v1

    :goto_4
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    if-eqz v3, :cond_9

    move v3, v2

    goto :goto_5

    :cond_9
    move v3, v1

    :goto_5
    iget v4, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    .line 469
    iget p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    if-eqz p1, :cond_a

    move p1, v2

    goto :goto_6

    :cond_a
    move p1, v1

    :goto_6
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    if-eqz v3, :cond_b

    move v3, v2

    goto :goto_7

    :cond_b
    move v3, v1

    :goto_7
    iget v4, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    .line 470
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq p1, v0, :cond_c

    move p1, v2

    goto :goto_8

    :cond_c
    move p1, v1

    :goto_8
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    iget-object v3, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    sget-object v4, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq v3, v4, :cond_d

    move v1, v2

    :cond_d
    iget-object p3, p3, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    invoke-interface {p2, p1, v0, v1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitByteString(ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    .line 472
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 463
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;

    invoke-direct {p1, v0}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams$Builder;-><init>(Lcom/google/crypto/tink/proto/EciesHkdfKemParams$1;)V

    return-object p1

    :pswitch_5
    return-object v0

    .line 457
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    return-object p1

    .line 454
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;-><init>()V

    return-object p1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method public getCurveType()Lcom/google/crypto/tink/proto/EllipticCurveType;
    .locals 1

    .line 41
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EllipticCurveType;->forNumber(I)Lcom/google/crypto/tink/proto/EllipticCurveType;

    move-result-object v0

    if-nez v0, :cond_0

    .line 42
    sget-object v0, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/EllipticCurveType;

    :cond_0
    return-object v0
.end method

.method public getCurveTypeValue()I
    .locals 1

    .line 31
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    return v0
.end method

.method public getHkdfHashType()Lcom/google/crypto/tink/proto/HashType;
    .locals 1

    .line 100
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HashType;->forNumber(I)Lcom/google/crypto/tink/proto/HashType;

    move-result-object v0

    if-nez v0, :cond_0

    .line 101
    sget-object v0, Lcom/google/crypto/tink/proto/HashType;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/HashType;

    :cond_0
    return-object v0
.end method

.method public getHkdfHashTypeValue()I
    .locals 1

    .line 90
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    return v0
.end method

.method public getHkdfSalt()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 149
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 191
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 195
    iget v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    sget-object v2, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNKNOWN_CURVE:Lcom/google/crypto/tink/proto/EllipticCurveType;

    invoke-virtual {v2}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result v2

    if-eq v1, v2, :cond_1

    const/4 v1, 0x1

    .line 196
    iget v2, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    .line 197
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeEnumSize(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 199
    :cond_1
    iget v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    sget-object v2, Lcom/google/crypto/tink/proto/HashType;->UNKNOWN_HASH:Lcom/google/crypto/tink/proto/HashType;

    invoke-virtual {v2}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result v2

    if-eq v1, v2, :cond_2

    const/4 v1, 0x2

    .line 200
    iget v2, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    .line 201
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeEnumSize(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 203
    :cond_2
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v1}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    const/16 v1, 0xb

    .line 204
    iget-object v2, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    .line 205
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 207
    :cond_3
    iput v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->memoizedSerializedSize:I

    return v0
.end method

.method public writeTo(Lcom/google/protobuf/CodedOutputStream;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "output"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 179
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    sget-object v1, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNKNOWN_CURVE:Lcom/google/crypto/tink/proto/EllipticCurveType;

    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result v1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    .line 180
    iget v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->curveType_:I

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeEnum(II)V

    .line 182
    :cond_0
    iget v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    sget-object v1, Lcom/google/crypto/tink/proto/HashType;->UNKNOWN_HASH:Lcom/google/crypto/tink/proto/HashType;

    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result v1

    if-eq v0, v1, :cond_1

    const/4 v0, 0x2

    .line 183
    iget v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfHashType_:I

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeEnum(II)V

    .line 185
    :cond_1
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    const/16 v0, 0xb

    .line 186
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EciesHkdfKemParams;->hkdfSalt_:Lcom/google/protobuf/ByteString;

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_2
    return-void
.end method
