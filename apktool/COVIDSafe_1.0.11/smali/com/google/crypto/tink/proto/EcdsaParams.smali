.class public final Lcom/google/crypto/tink/proto/EcdsaParams;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "EcdsaParams.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EcdsaParamsOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/EcdsaParams$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/EcdsaParams;",
        "Lcom/google/crypto/tink/proto/EcdsaParams$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EcdsaParamsOrBuilder;"
    }
.end annotation


# static fields
.field public static final CURVE_FIELD_NUMBER:I = 0x2

.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

.field public static final ENCODING_FIELD_NUMBER:I = 0x3

.field public static final HASH_TYPE_FIELD_NUMBER:I = 0x1

.field private static volatile PARSER:Lcom/google/protobuf/Parser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EcdsaParams;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private curve_:I

.field private encoding_:I

.field private hashType_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 587
    new-instance v0, Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    .line 588
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/EcdsaParams;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/EcdsaParams;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setHashTypeValue(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/EcdsaParams;Lcom/google/crypto/tink/proto/HashType;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setHashType(Lcom/google/crypto/tink/proto/HashType;)V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaParams;->clearHashType()V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/EcdsaParams;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setCurveValue(I)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/EcdsaParams;Lcom/google/crypto/tink/proto/EllipticCurveType;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setCurve(Lcom/google/crypto/tink/proto/EllipticCurveType;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaParams;->clearCurve()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/crypto/tink/proto/EcdsaParams;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setEncodingValue(I)V

    return-void
.end method

.method static synthetic access$800(Lcom/google/crypto/tink/proto/EcdsaParams;Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->setEncoding(Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;)V

    return-void
.end method

.method static synthetic access$900(Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaParams;->clearEncoding()V

    return-void
.end method

.method private clearCurve()V
    .locals 1

    const/4 v0, 0x0

    .line 135
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    return-void
.end method

.method private clearEncoding()V
    .locals 1

    const/4 v0, 0x0

    .line 194
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    return-void
.end method

.method private clearHashType()V
    .locals 1

    const/4 v0, 0x0

    .line 76
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaParams;
    .locals 1

    .line 592
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object v0
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/EcdsaParams$Builder;
    .locals 1

    .line 293
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/EcdsaParams;)Lcom/google/crypto/tink/proto/EcdsaParams$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 296
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 270
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/EcdsaParams;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 276
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 234
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 241
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 281
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 288
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 258
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 265
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 246
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaParams;
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

    .line 253
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EcdsaParams;",
            ">;"
        }
    .end annotation

    .line 598
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setCurve(Lcom/google/crypto/tink/proto/EllipticCurveType;)V
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

    .line 124
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 121
    throw p1
.end method

.method private setCurveValue(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 110
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    return-void
.end method

.method private setEncoding(Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;)V
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

    .line 183
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->getNumber()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 180
    throw p1
.end method

.method private setEncodingValue(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 169
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    return-void
.end method

.method private setHashType(Lcom/google/crypto/tink/proto/HashType;)V
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

    .line 65
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 62
    throw p1
.end method

.method private setHashTypeValue(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 51
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    return-void
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

    .line 494
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaParams$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 580
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 571
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaParams;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    monitor-enter p1

    .line 572
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/EcdsaParams;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 573
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/EcdsaParams;->PARSER:Lcom/google/protobuf/Parser;

    .line 575
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 577
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaParams;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 519
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 521
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v1, :cond_7

    .line 526
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_6

    const/16 p3, 0x8

    if-eq p1, p3, :cond_5

    const/16 p3, 0x10

    if-eq p1, p3, :cond_4

    const/16 p3, 0x18

    if-eq p1, p3, :cond_3

    .line 532
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_2

    .line 550
    :cond_3
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result p1

    .line 552
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    goto :goto_1

    .line 544
    :cond_4
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result p1

    .line 546
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    goto :goto_1

    .line 538
    :cond_5
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readEnum()I

    move-result p1

    .line 540
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I
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

    .line 560
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 562
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 558
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 563
    :goto_3
    throw p1

    .line 568
    :cond_7
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p1

    .line 508
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 509
    check-cast p3, Lcom/google/crypto/tink/proto/EcdsaParams;

    .line 510
    iget p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    if-eqz p1, :cond_8

    move p1, v2

    goto :goto_4

    :cond_8
    move p1, v1

    :goto_4
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    if-eqz v3, :cond_9

    move v3, v2

    goto :goto_5

    :cond_9
    move v3, v1

    :goto_5
    iget v4, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    .line 511
    iget p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    if-eqz p1, :cond_a

    move p1, v2

    goto :goto_6

    :cond_a
    move p1, v1

    :goto_6
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    if-eqz v3, :cond_b

    move v3, v2

    goto :goto_7

    :cond_b
    move v3, v1

    :goto_7
    iget v4, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    .line 512
    iget p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    if-eqz p1, :cond_c

    move p1, v2

    goto :goto_8

    :cond_c
    move p1, v1

    :goto_8
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    if-eqz v3, :cond_d

    move v1, v2

    :cond_d
    iget p3, p3, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    invoke-interface {p2, p1, v0, v1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    .line 513
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 505
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    invoke-direct {p1, v0}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;-><init>(Lcom/google/crypto/tink/proto/EcdsaParams$1;)V

    return-object p1

    :pswitch_5
    return-object v0

    .line 499
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaParams;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-object p1

    .line 496
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/EcdsaParams;-><init>()V

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

.method public getCurve()Lcom/google/crypto/tink/proto/EllipticCurveType;
    .locals 1

    .line 99
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EllipticCurveType;->forNumber(I)Lcom/google/crypto/tink/proto/EllipticCurveType;

    move-result-object v0

    if-nez v0, :cond_0

    .line 100
    sget-object v0, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/EllipticCurveType;

    :cond_0
    return-object v0
.end method

.method public getCurveValue()I
    .locals 1

    .line 89
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    return v0
.end method

.method public getEncoding()Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;
    .locals 1

    .line 158
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->forNumber(I)Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    move-result-object v0

    if-nez v0, :cond_0

    .line 159
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    :cond_0
    return-object v0
.end method

.method public getEncodingValue()I
    .locals 1

    .line 148
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    return v0
.end method

.method public getHashType()Lcom/google/crypto/tink/proto/HashType;
    .locals 1

    .line 40
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    invoke-static {v0}, Lcom/google/crypto/tink/proto/HashType;->forNumber(I)Lcom/google/crypto/tink/proto/HashType;

    move-result-object v0

    if-nez v0, :cond_0

    .line 41
    sget-object v0, Lcom/google/crypto/tink/proto/HashType;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/HashType;

    :cond_0
    return-object v0
.end method

.method public getHashTypeValue()I
    .locals 1

    .line 30
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    return v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 211
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 215
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    sget-object v2, Lcom/google/crypto/tink/proto/HashType;->UNKNOWN_HASH:Lcom/google/crypto/tink/proto/HashType;

    invoke-virtual {v2}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result v2

    if-eq v1, v2, :cond_1

    const/4 v1, 0x1

    .line 216
    iget v2, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    .line 217
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeEnumSize(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 219
    :cond_1
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    sget-object v2, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNKNOWN_CURVE:Lcom/google/crypto/tink/proto/EllipticCurveType;

    invoke-virtual {v2}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result v2

    if-eq v1, v2, :cond_2

    const/4 v1, 0x2

    .line 220
    iget v2, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    .line 221
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeEnumSize(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 223
    :cond_2
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    sget-object v2, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->UNKNOWN_ENCODING:Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    invoke-virtual {v2}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->getNumber()I

    move-result v2

    if-eq v1, v2, :cond_3

    const/4 v1, 0x3

    .line 224
    iget v2, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    .line 225
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeEnumSize(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 227
    :cond_3
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->memoizedSerializedSize:I

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

    .line 199
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    sget-object v1, Lcom/google/crypto/tink/proto/HashType;->UNKNOWN_HASH:Lcom/google/crypto/tink/proto/HashType;

    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/HashType;->getNumber()I

    move-result v1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    .line 200
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->hashType_:I

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeEnum(II)V

    .line 202
    :cond_0
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    sget-object v1, Lcom/google/crypto/tink/proto/EllipticCurveType;->UNKNOWN_CURVE:Lcom/google/crypto/tink/proto/EllipticCurveType;

    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/EllipticCurveType;->getNumber()I

    move-result v1

    if-eq v0, v1, :cond_1

    const/4 v0, 0x2

    .line 203
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->curve_:I

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeEnum(II)V

    .line 205
    :cond_1
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    sget-object v1, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->UNKNOWN_ENCODING:Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;

    invoke-virtual {v1}, Lcom/google/crypto/tink/proto/EcdsaSignatureEncoding;->getNumber()I

    move-result v1

    if-eq v0, v1, :cond_2

    const/4 v0, 0x3

    .line 206
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaParams;->encoding_:I

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeEnum(II)V

    :cond_2
    return-void
.end method
