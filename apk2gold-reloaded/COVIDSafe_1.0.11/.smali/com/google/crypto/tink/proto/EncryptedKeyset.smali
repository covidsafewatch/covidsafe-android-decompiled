.class public final Lcom/google/crypto/tink/proto/EncryptedKeyset;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "EncryptedKeyset.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EncryptedKeysetOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/EncryptedKeyset;",
        "Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EncryptedKeysetOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

.field public static final ENCRYPTED_KEYSET_FIELD_NUMBER:I = 0x2

.field public static final KEYSET_INFO_FIELD_NUMBER:I = 0x3

.field private static volatile PARSER:Lcom/google/protobuf/Parser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EncryptedKeyset;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private encryptedKeyset_:Lcom/google/protobuf/ByteString;

.field private keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 451
    new-instance v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    .line 452
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    .line 19
    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/EncryptedKeyset;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/protobuf/ByteString;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->setEncryptedKeyset(Lcom/google/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/EncryptedKeyset;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->clearEncryptedKeyset()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo$Builder;)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/EncryptedKeyset;Lcom/google/crypto/tink/proto/KeysetInfo;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->mergeKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/EncryptedKeyset;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->clearKeysetInfo()V

    return-void
.end method

.method private clearEncryptedKeyset()V
    .locals 1

    .line 56
    invoke-static {}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getDefaultInstance()Lcom/google/crypto/tink/proto/EncryptedKeyset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getEncryptedKeyset()Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method private clearKeysetInfo()V
    .locals 1

    const/4 v0, 0x0

    .line 131
    iput-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/EncryptedKeyset;
    .locals 1

    .line 456
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object v0
.end method

.method private mergeKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 115
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-eqz v0, :cond_0

    .line 116
    invoke-static {}, Lcom/google/crypto/tink/proto/KeysetInfo;->getDefaultInstance()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 117
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    .line 118
    invoke-static {v0}, Lcom/google/crypto/tink/proto/KeysetInfo;->newBuilder(Lcom/google/crypto/tink/proto/KeysetInfo;)Lcom/google/crypto/tink/proto/KeysetInfo$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    goto :goto_0

    .line 120
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    :goto_0
    return-void
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1

    .line 224
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/EncryptedKeyset;)Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 227
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 201
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 207
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 165
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 172
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 212
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 219
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 189
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 196
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 177
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EncryptedKeyset;
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

    .line 184
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EncryptedKeyset;",
            ">;"
        }
    .end annotation

    .line 462
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setEncryptedKeyset(Lcom/google/protobuf/ByteString;)V
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

    .line 45
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 42
    throw p1
.end method

.method private setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 104
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    return-void
.end method

.method private setKeysetInfo(Lcom/google/crypto/tink/proto/KeysetInfo;)V
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

    .line 92
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 90
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

    .line 358
    sget-object v0, Lcom/google/crypto/tink/proto/EncryptedKeyset$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 444
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 435
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    monitor-enter p1

    .line 436
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/EncryptedKeyset;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 437
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/EncryptedKeyset;->PARSER:Lcom/google/protobuf/Parser;

    .line 439
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 441
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 383
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 385
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v0, :cond_7

    .line 390
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_6

    const/16 v3, 0x12

    if-eq p1, v3, :cond_5

    const/16 v3, 0x1a

    if-eq p1, v3, :cond_3

    .line 396
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_3

    .line 408
    :cond_3
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-eqz p1, :cond_4

    .line 409
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeysetInfo;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;

    goto :goto_2

    :cond_4
    move-object p1, v1

    .line 411
    :goto_2
    invoke-static {}, Lcom/google/crypto/tink/proto/KeysetInfo;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/KeysetInfo;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-eqz p1, :cond_2

    .line 413
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 414
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KeysetInfo$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    goto :goto_1

    .line 403
    :cond_5
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;
    :try_end_1
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :cond_6
    :goto_3
    move v0, v2

    goto :goto_1

    :catchall_1
    move-exception p1

    goto :goto_4

    :catch_0
    move-exception p1

    .line 424
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 426
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 422
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 427
    :goto_4
    throw p1

    .line 432
    :cond_7
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p1

    .line 372
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 373
    check-cast p3, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    .line 374
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    sget-object v1, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq p1, v1, :cond_8

    move p1, v2

    goto :goto_5

    :cond_8
    move p1, v0

    :goto_5
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    iget-object v3, p3, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    sget-object v4, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq v3, v4, :cond_9

    move v0, v2

    :cond_9
    iget-object v2, p3, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    invoke-interface {p2, p1, v1, v0, v2}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitByteString(ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    .line 376
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    iget-object p3, p3, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    invoke-interface {p2, p1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KeysetInfo;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    .line 377
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 369
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;

    invoke-direct {p1, v1}, Lcom/google/crypto/tink/proto/EncryptedKeyset$Builder;-><init>(Lcom/google/crypto/tink/proto/EncryptedKeyset$1;)V

    return-object p1

    :pswitch_5
    return-object v1

    .line 363
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EncryptedKeyset;

    return-object p1

    .line 360
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/EncryptedKeyset;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/EncryptedKeyset;-><init>()V

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

.method public getEncryptedKeyset()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 31
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    return-object v0
.end method

.method public getKeysetInfo()Lcom/google/crypto/tink/proto/KeysetInfo;
    .locals 1

    .line 79
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/KeysetInfo;->getDefaultInstance()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 146
    iget v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 150
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v1}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v1, 0x2

    .line 151
    iget-object v2, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    .line 152
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 154
    :cond_1
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-eqz v1, :cond_2

    const/4 v1, 0x3

    .line 156
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getKeysetInfo()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 158
    :cond_2
    iput v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->memoizedSerializedSize:I

    return v0
.end method

.method public hasKeysetInfo()Z
    .locals 1

    .line 69
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

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

    .line 137
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x2

    .line 138
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->encryptedKeyset_:Lcom/google/protobuf/ByteString;

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EncryptedKeyset;->keysetInfo_:Lcom/google/crypto/tink/proto/KeysetInfo;

    if-eqz v0, :cond_1

    const/4 v0, 0x3

    .line 141
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EncryptedKeyset;->getKeysetInfo()Lcom/google/crypto/tink/proto/KeysetInfo;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    :cond_1
    return-void
.end method
