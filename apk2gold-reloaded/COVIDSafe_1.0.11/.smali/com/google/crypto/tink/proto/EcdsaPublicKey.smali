.class public final Lcom/google/crypto/tink/proto/EcdsaPublicKey;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "EcdsaPublicKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/EcdsaPublicKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKey;",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/EcdsaPublicKeyOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

.field public static final PARAMS_FIELD_NUMBER:I = 0x2

.field private static volatile PARSER:Lcom/google/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EcdsaPublicKey;",
            ">;"
        }
    .end annotation
.end field

.field public static final VERSION_FIELD_NUMBER:I = 0x1

.field public static final X_FIELD_NUMBER:I = 0x3

.field public static final Y_FIELD_NUMBER:I = 0x4


# instance fields
.field private params_:Lcom/google/crypto/tink/proto/EcdsaParams;

.field private version_:I

.field private x_:Lcom/google/protobuf/ByteString;

.field private y_:Lcom/google/protobuf/ByteString;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 647
    new-instance v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    .line 648
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    .line 19
    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    .line 20
    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/EcdsaPublicKey;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/EcdsaPublicKey;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->setVersion(I)V

    return-void
.end method

.method static synthetic access$1000(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->clearY()V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->clearVersion()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->setParams(Lcom/google/crypto/tink/proto/EcdsaParams;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->setParams(Lcom/google/crypto/tink/proto/EcdsaParams$Builder;)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->mergeParams(Lcom/google/crypto/tink/proto/EcdsaParams;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->clearParams()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/protobuf/ByteString;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->setX(Lcom/google/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$800(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->clearX()V

    return-void
.end method

.method static synthetic access$900(Lcom/google/crypto/tink/proto/EcdsaPublicKey;Lcom/google/protobuf/ByteString;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->setY(Lcom/google/protobuf/ByteString;)V

    return-void
.end method

.method private clearParams()V
    .locals 1

    const/4 v0, 0x0

    .line 129
    iput-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-void
.end method

.method private clearVersion()V
    .locals 1

    const/4 v0, 0x0

    .line 54
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    return-void
.end method

.method private clearX()V
    .locals 1

    .line 180
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getX()Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method private clearY()V
    .locals 1

    .line 218
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getY()Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaPublicKey;
    .locals 1

    .line 652
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object v0
.end method

.method private mergeParams(Lcom/google/crypto/tink/proto/EcdsaParams;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 113
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-eqz v0, :cond_0

    .line 114
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaParams;->getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaParams;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 115
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    .line 116
    invoke-static {v0}, Lcom/google/crypto/tink/proto/EcdsaParams;->newBuilder(Lcom/google/crypto/tink/proto/EcdsaParams;)Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    goto :goto_0

    .line 118
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    :goto_0
    return-void
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1

    .line 324
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/EcdsaPublicKey;)Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 327
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 301
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 307
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 265
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 272
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 312
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 319
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 289
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 296
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 277
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/EcdsaPublicKey;
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

    .line 284
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/EcdsaPublicKey;",
            ">;"
        }
    .end annotation

    .line 658
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setParams(Lcom/google/crypto/tink/proto/EcdsaParams$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 102
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-void
.end method

.method private setParams(Lcom/google/crypto/tink/proto/EcdsaParams;)V
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

    .line 90
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 88
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

    .line 43
    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    return-void
.end method

.method private setX(Lcom/google/protobuf/ByteString;)V
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

    .line 165
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 162
    throw p1
.end method

.method private setY(Lcom/google/protobuf/ByteString;)V
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

    .line 207
    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 204
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

    .line 540
    sget-object v0, Lcom/google/crypto/tink/proto/EcdsaPublicKey$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    packed-switch p1, :pswitch_data_0

    .line 640
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 631
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    monitor-enter p1

    .line 632
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 633
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->PARSER:Lcom/google/protobuf/Parser;

    .line 635
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 637
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 569
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 571
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v1, :cond_9

    .line 576
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_8

    const/16 v3, 0x8

    if-eq p1, v3, :cond_7

    const/16 v3, 0x12

    if-eq p1, v3, :cond_5

    const/16 v3, 0x1a

    if-eq p1, v3, :cond_4

    const/16 v3, 0x22

    if-eq p1, v3, :cond_3

    .line 582
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_3

    .line 612
    :cond_3
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    goto :goto_1

    .line 607
    :cond_4
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    goto :goto_1

    .line 594
    :cond_5
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-eqz p1, :cond_6

    .line 595
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EcdsaParams;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;

    goto :goto_2

    :cond_6
    move-object p1, v0

    .line 597
    :goto_2
    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaParams;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/EcdsaParams;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-eqz p1, :cond_2

    .line 599
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 600
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/EcdsaParams$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    goto :goto_1

    .line 589
    :cond_7
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readUInt32()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I
    :try_end_1
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :cond_8
    :goto_3
    move v1, v2

    goto :goto_1

    :catchall_1
    move-exception p1

    goto :goto_4

    :catch_0
    move-exception p1

    .line 620
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 622
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 618
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 623
    :goto_4
    throw p1

    .line 628
    :cond_9
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p1

    .line 554
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 555
    check-cast p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    .line 556
    iget p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    if-eqz p1, :cond_a

    move p1, v2

    goto :goto_5

    :cond_a
    move p1, v1

    :goto_5
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    if-eqz v3, :cond_b

    move v3, v2

    goto :goto_6

    :cond_b
    move v3, v1

    :goto_6
    iget v4, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    .line 558
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    iget-object v0, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    invoke-interface {p2, p1, v0}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/EcdsaParams;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    .line 559
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq p1, v0, :cond_c

    move p1, v2

    goto :goto_7

    :cond_c
    move p1, v1

    :goto_7
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    iget-object v3, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    sget-object v4, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq v3, v4, :cond_d

    move v3, v2

    goto :goto_8

    :cond_d
    move v3, v1

    :goto_8
    iget-object v4, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    invoke-interface {p2, p1, v0, v3, v4}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitByteString(ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    .line 561
    iget-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    sget-object v0, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq p1, v0, :cond_e

    move p1, v2

    goto :goto_9

    :cond_e
    move p1, v1

    :goto_9
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    iget-object v3, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    sget-object v4, Lcom/google/protobuf/ByteString;->EMPTY:Lcom/google/protobuf/ByteString;

    if-eq v3, v4, :cond_f

    move v1, v2

    :cond_f
    iget-object p3, p3, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    invoke-interface {p2, p1, v0, v1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitByteString(ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;

    move-result-object p1

    iput-object p1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    .line 563
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 551
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;

    invoke-direct {p1, v0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey$Builder;-><init>(Lcom/google/crypto/tink/proto/EcdsaPublicKey$1;)V

    return-object p1

    :pswitch_5
    return-object v0

    .line 545
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    return-object p1

    .line 542
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/EcdsaPublicKey;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;-><init>()V

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

.method public getParams()Lcom/google/crypto/tink/proto/EcdsaParams;
    .locals 1

    .line 77
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/EcdsaParams;->getDefaultInstance()Lcom/google/crypto/tink/proto/EcdsaParams;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 238
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 242
    iget v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    .line 244
    invoke-static {v2, v1}, Lcom/google/protobuf/CodedOutputStream;->computeUInt32Size(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 246
    :cond_1
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-eqz v1, :cond_2

    const/4 v1, 0x2

    .line 248
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getParams()Lcom/google/crypto/tink/proto/EcdsaParams;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 250
    :cond_2
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v1}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    const/4 v1, 0x3

    .line 251
    iget-object v2, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    .line 252
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 254
    :cond_3
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v1}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    const/4 v1, 0x4

    .line 255
    iget-object v2, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    .line 256
    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v1

    add-int/2addr v0, v1

    .line 258
    :cond_4
    iput v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->memoizedSerializedSize:I

    return v0
.end method

.method public getVersion()I
    .locals 1

    .line 32
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    return v0
.end method

.method public getX()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 147
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    return-object v0
.end method

.method public getY()Lcom/google/protobuf/ByteString;
    .locals 1

    .line 193
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    return-object v0
.end method

.method public hasParams()Z
    .locals 1

    .line 67
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

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

    .line 223
    iget v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->version_:I

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 224
    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeUInt32(II)V

    .line 226
    :cond_0
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->params_:Lcom/google/crypto/tink/proto/EcdsaParams;

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    .line 227
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->getParams()Lcom/google/crypto/tink/proto/EcdsaParams;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    .line 229
    :cond_1
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x3

    .line 230
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->x_:Lcom/google/protobuf/ByteString;

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    .line 232
    :cond_2
    iget-object v0, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    const/4 v0, 0x4

    .line 233
    iget-object v1, p0, Lcom/google/crypto/tink/proto/EcdsaPublicKey;->y_:Lcom/google/protobuf/ByteString;

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_3
    return-void
.end method
