.class public final Lcom/google/crypto/tink/proto/KmsAeadKey;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "KmsAeadKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/KmsAeadKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/KmsAeadKey;",
        "Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/KmsAeadKeyOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

.field public static final PARAMS_FIELD_NUMBER:I = 0x2

.field private static volatile PARSER:Lcom/google/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/KmsAeadKey;",
            ">;"
        }
    .end annotation
.end field

.field public static final VERSION_FIELD_NUMBER:I = 0x1


# instance fields
.field private params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

.field private version_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 423
    new-instance v0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    .line 424
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/KmsAeadKey;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/KmsAeadKey;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->setVersion(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/KmsAeadKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->clearVersion()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/KmsAeadKey;Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->mergeParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/KmsAeadKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->clearParams()V

    return-void
.end method

.method private clearParams()V
    .locals 1

    const/4 v0, 0x0

    .line 115
    iput-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    return-void
.end method

.method private clearVersion()V
    .locals 1

    const/4 v0, 0x0

    .line 40
    iput v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/KmsAeadKey;
    .locals 1

    .line 428
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object v0
.end method

.method private mergeParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 99
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz v0, :cond_0

    .line 100
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->getDefaultInstance()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 101
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    .line 102
    invoke-static {v0}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->newBuilder(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    goto :goto_0

    .line 104
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    :goto_0
    return-void
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1

    .line 208
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/KmsAeadKey;)Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 211
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 185
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 191
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 149
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 156
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 196
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 203
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 173
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 180
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 161
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/KmsAeadKey;
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

    .line 168
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/KmsAeadKey;",
            ">;"
        }
    .end annotation

    .line 434
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 88
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    return-void
.end method

.method private setParams(Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;)V
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

    .line 76
    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 74
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

    .line 33
    iput p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    return-void
.end method


# virtual methods
.method protected final dynamicMethod(Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
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

    .line 330
    sget-object v0, Lcom/google/crypto/tink/proto/KmsAeadKey$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 416
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 407
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/KmsAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/KmsAeadKey;

    monitor-enter p1

    .line 408
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/KmsAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 409
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/KmsAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    .line 411
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 413
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/KmsAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 355
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 357
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v0, :cond_7

    .line 362
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_6

    const/16 v3, 0x8

    if-eq p1, v3, :cond_5

    const/16 v3, 0x12

    if-eq p1, v3, :cond_3

    .line 368
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_3

    .line 380
    :cond_3
    iget-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz p1, :cond_4

    .line 381
    iget-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;

    goto :goto_2

    :cond_4
    move-object p1, v1

    .line 383
    :goto_2
    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz p1, :cond_2

    .line 385
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 386
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    goto :goto_1

    .line 375
    :cond_5
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readUInt32()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I
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

    .line 396
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 398
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 394
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 399
    :goto_4
    throw p1

    .line 404
    :cond_7
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p1

    .line 344
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 345
    check-cast p3, Lcom/google/crypto/tink/proto/KmsAeadKey;

    .line 346
    iget p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    if-eqz p1, :cond_8

    move p1, v2

    goto :goto_5

    :cond_8
    move p1, v0

    :goto_5
    iget v1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    if-eqz v3, :cond_9

    move v0, v2

    :cond_9
    iget v2, p3, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    invoke-interface {p2, p1, v1, v0, v2}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    .line 348
    iget-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iget-object p3, p3, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    invoke-interface {p2, p1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    .line 349
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 341
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;

    invoke-direct {p1, v1}, Lcom/google/crypto/tink/proto/KmsAeadKey$Builder;-><init>(Lcom/google/crypto/tink/proto/KmsAeadKey$1;)V

    return-object p1

    :pswitch_5
    return-object v1

    .line 335
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/KmsAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/KmsAeadKey;

    return-object p1

    .line 332
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/KmsAeadKey;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/KmsAeadKey;-><init>()V

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

.method public getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;
    .locals 1

    .line 63
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;->getDefaultInstance()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 130
    iget v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 134
    iget v1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    .line 136
    invoke-static {v2, v1}, Lcom/google/protobuf/CodedOutputStream;->computeUInt32Size(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 138
    :cond_1
    iget-object v1, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz v1, :cond_2

    const/4 v1, 0x2

    .line 140
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 142
    :cond_2
    iput v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->memoizedSerializedSize:I

    return v0
.end method

.method public getVersion()I
    .locals 1

    .line 26
    iget v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    return v0
.end method

.method public hasParams()Z
    .locals 1

    .line 53
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

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

    .line 121
    iget v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->version_:I

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 122
    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeUInt32(II)V

    .line 124
    :cond_0
    iget-object v0, p0, Lcom/google/crypto/tink/proto/KmsAeadKey;->params_:Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    .line 125
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/KmsAeadKey;->getParams()Lcom/google/crypto/tink/proto/KmsAeadKeyFormat;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    :cond_1
    return-void
.end method
