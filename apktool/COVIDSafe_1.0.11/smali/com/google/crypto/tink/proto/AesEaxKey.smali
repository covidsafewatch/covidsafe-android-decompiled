.class public final Lcom/google/crypto/tink/proto/AesEaxKey;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "AesEaxKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesEaxKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/AesEaxKey$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/AesEaxKey;",
        "Lcom/google/crypto/tink/proto/AesEaxKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesEaxKeyOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

.field public static final KEY_VALUE_FIELD_NUMBER:I = 0x3

.field public static final PARAMS_FIELD_NUMBER:I = 0x2

.field private static volatile PARSER:Lcom/google/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/AesEaxKey;",
            ">;"
        }
    .end annotation
.end field

.field public static final VERSION_FIELD_NUMBER:I = 0x1


# instance fields
.field private keyValue_:Lcom/google/protobuf/ByteString;

.field private params_:Lcom/google/crypto/tink/proto/AesEaxParams;

.field private version_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 439
    new-instance v0, Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    .line 440
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    .line 19
    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    iput-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/AesEaxKey;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/AesEaxKey;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->setVersion(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/AesEaxKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->clearVersion()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/AesEaxKey;Lcom/google/crypto/tink/proto/AesEaxParams;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->setParams(Lcom/google/crypto/tink/proto/AesEaxParams;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/AesEaxKey;Lcom/google/crypto/tink/proto/AesEaxParams$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->setParams(Lcom/google/crypto/tink/proto/AesEaxParams$Builder;)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/AesEaxKey;Lcom/google/crypto/tink/proto/AesEaxParams;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->mergeParams(Lcom/google/crypto/tink/proto/AesEaxParams;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/AesEaxKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->clearParams()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/crypto/tink/proto/AesEaxKey;Lcom/google/protobuf/ByteString;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->setKeyValue(Lcom/google/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$800(Lcom/google/crypto/tink/proto/AesEaxKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->clearKeyValue()V

    return-void
.end method

.method private clearKeyValue()V
    .locals 1

    .line 119
    invoke-static {}, Lcom/google/crypto/tink/proto/AesEaxKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/AesEaxKey;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;->getKeyValue()Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method private clearParams()V
    .locals 1

    const/4 v0, 0x0

    .line 92
    iput-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    return-void
.end method

.method private clearVersion()V
    .locals 1

    const/4 v0, 0x0

    .line 41
    iput v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/AesEaxKey;
    .locals 1

    .line 444
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object v0
.end method

.method private mergeParams(Lcom/google/crypto/tink/proto/AesEaxParams;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 80
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz v0, :cond_0

    .line 81
    invoke-static {}, Lcom/google/crypto/tink/proto/AesEaxParams;->getDefaultInstance()Lcom/google/crypto/tink/proto/AesEaxParams;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 82
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    .line 83
    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesEaxParams;->newBuilder(Lcom/google/crypto/tink/proto/AesEaxParams;)Lcom/google/crypto/tink/proto/AesEaxParams$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    goto :goto_0

    .line 85
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    :goto_0
    return-void
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/AesEaxKey$Builder;
    .locals 1

    .line 218
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/AesEaxKey;)Lcom/google/crypto/tink/proto/AesEaxKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 221
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 195
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 201
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/AesEaxKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 159
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 166
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 206
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 213
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 183
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 190
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 171
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesEaxKey;
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

    .line 178
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/AesEaxKey;",
            ">;"
        }
    .end annotation

    .line 450
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesEaxKey;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setKeyValue(Lcom/google/protobuf/ByteString;)V
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

    .line 112
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 109
    throw p1
.end method

.method private setParams(Lcom/google/crypto/tink/proto/AesEaxParams$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 73
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    return-void
.end method

.method private setParams(Lcom/google/crypto/tink/proto/AesEaxParams;)V
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
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 63
    throw p1
.end method

.method private setVersion(I)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 34
    iput p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

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

    .line 339
    sget-object v0, Lcom/google/crypto/tink/proto/AesEaxKey$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 432
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 423
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/AesEaxKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/AesEaxKey;

    monitor-enter p1

    .line 424
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/AesEaxKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 425
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/AesEaxKey;->PARSER:Lcom/google/protobuf/Parser;

    .line 427
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 429
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/AesEaxKey;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 366
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 368
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v1, :cond_8

    .line 373
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_7

    const/16 v3, 0x8

    if-eq p1, v3, :cond_6

    const/16 v3, 0x12

    if-eq p1, v3, :cond_4

    const/16 v3, 0x1a

    if-eq p1, v3, :cond_3

    .line 379
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_3

    .line 404
    :cond_3
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    goto :goto_1

    .line 391
    :cond_4
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz p1, :cond_5

    .line 392
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesEaxParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;

    goto :goto_2

    :cond_5
    move-object p1, v0

    .line 394
    :goto_2
    invoke-static {}, Lcom/google/crypto/tink/proto/AesEaxParams;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/AesEaxParams;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz p1, :cond_2

    .line 396
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 397
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesEaxParams$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    goto :goto_1

    .line 386
    :cond_6
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readUInt32()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I
    :try_end_1
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :cond_7
    :goto_3
    move v1, v2

    goto :goto_1

    :catchall_1
    move-exception p1

    goto :goto_4

    :catch_0
    move-exception p1

    .line 412
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 414
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 410
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 415
    :goto_4
    throw p1

    .line 420
    :cond_8
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p1

    .line 353
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 354
    check-cast p3, Lcom/google/crypto/tink/proto/AesEaxKey;

    .line 355
    iget p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    if-eqz p1, :cond_9

    move p1, v2

    goto :goto_5

    :cond_9
    move p1, v1

    :goto_5
    iget v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    if-eqz v3, :cond_a

    move v3, v2

    goto :goto_6

    :cond_a
    move v3, v1

    :goto_6
    iget v4, p3, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    .line 357
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    iget-object v0, p3, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    invoke-interface {p2, p1, v0}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesEaxParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    .line 358
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq p1, v0, :cond_b

    move p1, v2

    goto :goto_7

    :cond_b
    move p1, v1

    :goto_7
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    iget-object v3, p3, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    sget-object v4, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq v3, v4, :cond_c

    move v1, v2

    :cond_c
    iget-object p3, p3, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    invoke-interface {p2, p1, v0, v1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitByteString(ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    .line 360
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 350
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;

    invoke-direct {p1, v0}, Lcom/google/crypto/tink/proto/AesEaxKey$Builder;-><init>(Lcom/google/crypto/tink/proto/AesEaxKey$1;)V

    return-object p1

    :pswitch_5
    return-object v0

    .line 344
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/AesEaxKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesEaxKey;

    return-object p1

    .line 341
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/AesEaxKey;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/AesEaxKey;-><init>()V

    return-object p1

    nop

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

.method public getKeyValue()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 102
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    return-object v0
.end method

.method public getParams()Lcom/google/crypto/tink/proto/AesEaxParams;
    .locals 1

    .line 56
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/AesEaxParams;->getDefaultInstance()Lcom/google/crypto/tink/proto/AesEaxParams;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 136
    iget v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 140
    iget v1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    .line 142
    invoke-static {v2, v1}, Lcom/google/protobuf/CodedOutputStream;->computeUInt32Size(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 144
    :cond_1
    iget-object v1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz v1, :cond_2

    const/4 v1, 0x2

    .line 146
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->getParams()Lcom/google/crypto/tink/proto/AesEaxParams;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 148
    :cond_2
    iget-object v1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v1}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    const/4 v1, 0x3

    .line 149
    iget-object v2, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    .line 150
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 152
    :cond_3
    iput v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->memoizedSerializedSize:I

    return v0
.end method

.method public getVersion()I
    .locals 1

    .line 27
    iget v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 50
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
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

    .line 124
    iget v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->version_:I

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 125
    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeUInt32(II)V

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->params_:Lcom/google/crypto/tink/proto/AesEaxParams;

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    .line 128
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesEaxKey;->getParams()Lcom/google/crypto/tink/proto/AesEaxParams;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    .line 130
    :cond_1
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x3

    .line 131
    iget-object v1, p0, Lcom/google/crypto/tink/proto/AesEaxKey;->keyValue_:Lcom/google/protobuf/ByteString;

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_2
    return-void
.end method
