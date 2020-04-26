.class public final Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
.super Lcom/google/protobuf/GeneratedMessageLite;
.source "AesCtrHmacAeadKey.java"

# interfaces
.implements Lcom/google/crypto/tink/proto/AesCtrHmacAeadKeyOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessageLite<",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;",
        ">;",
        "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKeyOrBuilder;"
    }
.end annotation


# static fields
.field public static final AES_CTR_KEY_FIELD_NUMBER:I = 0x2

.field private static final DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

.field public static final HMAC_KEY_FIELD_NUMBER:I = 0x3

.field private static volatile PARSER:Lcom/google/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;",
            ">;"
        }
    .end annotation
.end field

.field public static final VERSION_FIELD_NUMBER:I = 0x1


# instance fields
.field private aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

.field private hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

.field private version_:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 493
    new-instance v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    .line 494
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->makeImmutable()V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessageLite;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
    .locals 1

    .line 13
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;I)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->setVersion(I)V

    return-void
.end method

.method static synthetic access$1000(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->clearHmacKey()V

    return-void
.end method

.method static synthetic access$200(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->clearVersion()V

    return-void
.end method

.method static synthetic access$300(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)V

    return-void
.end method

.method static synthetic access$400(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey$Builder;)V

    return-void
.end method

.method static synthetic access$500(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/AesCtrKey;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->mergeAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)V

    return-void
.end method

.method static synthetic access$600(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)V
    .locals 0

    .line 13
    invoke-direct {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->clearAesCtrKey()V

    return-void
.end method

.method static synthetic access$700(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->setHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)V

    return-void
.end method

.method static synthetic access$800(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey$Builder;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->setHmacKey(Lcom/google/crypto/tink/proto/HmacKey$Builder;)V

    return-void
.end method

.method static synthetic access$900(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;Lcom/google/crypto/tink/proto/HmacKey;)V
    .locals 0

    .line 13
    invoke-direct {p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->mergeHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)V

    return-void
.end method

.method private clearAesCtrKey()V
    .locals 1

    const/4 v0, 0x0

    .line 91
    iput-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    return-void
.end method

.method private clearHmacKey()V
    .locals 1

    const/4 v0, 0x0

    .line 143
    iput-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    return-void
.end method

.method private clearVersion()V
    .locals 1

    const/4 v0, 0x0

    .line 40
    iput v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    return-void
.end method

.method public static getDefaultInstance()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
    .locals 1

    .line 498
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object v0
.end method

.method private mergeAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 79
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz v0, :cond_0

    .line 80
    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/AesCtrKey;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 81
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    .line 82
    invoke-static {v0}, Lcom/google/crypto/tink/proto/AesCtrKey;->newBuilder(Lcom/google/crypto/tink/proto/AesCtrKey;)Lcom/google/crypto/tink/proto/AesCtrKey$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    goto :goto_0

    .line 84
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    :goto_0
    return-void
.end method

.method private mergeHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)V
    .locals 2
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .line 131
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-eqz v0, :cond_0

    .line 132
    invoke-static {}, Lcom/google/crypto/tink/proto/HmacKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 133
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    .line 134
    invoke-static {v0}, Lcom/google/crypto/tink/proto/HmacKey;->newBuilder(Lcom/google/crypto/tink/proto/HmacKey;)Lcom/google/crypto/tink/proto/HmacKey$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey$Builder;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    goto :goto_0

    .line 136
    :cond_0
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    :goto_0
    return-void
.end method

.method public static newBuilder()Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1

    .line 243
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;

    return-object v0
.end method

.method public static newBuilder(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "prototype"
        }
    .end annotation

    .line 246
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;

    invoke-virtual {v0, p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 220
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 226
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->parseDelimitedFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 184
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 191
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 231
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 238
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 208
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 215
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom([B)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 196
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[B)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;
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

    .line 203
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-static {v0, p0, p1}, Lcom/google/protobuf/GeneratedMessageLite;->parseFrom(Lcom/google/protobuf/GeneratedMessageLite;[BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p0
.end method

.method public static parser()Lcom/google/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Parser<",
            "Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;",
            ">;"
        }
    .end annotation

    .line 504
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getParserForType()Lcom/google/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 72
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    return-void
.end method

.method private setAesCtrKey(Lcom/google/crypto/tink/proto/AesCtrKey;)V
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

    .line 64
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 62
    throw p1
.end method

.method private setHmacKey(Lcom/google/crypto/tink/proto/HmacKey$Builder;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "builderForValue"
        }
    .end annotation

    .line 124
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    return-void
.end method

.method private setHmacKey(Lcom/google/crypto/tink/proto/HmacKey;)V
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

    .line 116
    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    return-void

    :cond_0
    const/4 p1, 0x0

    .line 114
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
    iput p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

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

    .line 386
    sget-object v0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Lcom/google/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result p1

    aget p1, v0, p1

    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    packed-switch p1, :pswitch_data_0

    .line 486
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1

    .line 477
    :pswitch_0
    sget-object p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p1, :cond_1

    const-class p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    monitor-enter p1

    .line 478
    :try_start_0
    sget-object p2, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    if-nez p2, :cond_0

    .line 479
    new-instance p2, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-direct {p2, p3}, Lcom/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Lcom/google/protobuf/GeneratedMessageLite;)V

    sput-object p2, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    .line 481
    :cond_0
    monitor-exit p1

    goto :goto_0

    :catchall_0
    move-exception p2

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p2

    .line 483
    :cond_1
    :goto_0
    sget-object p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->PARSER:Lcom/google/protobuf/Parser;

    return-object p1

    .line 412
    :pswitch_1
    check-cast p2, Lcom/google/protobuf/CodedInputStream;

    .line 414
    check-cast p3, Lcom/google/protobuf/ExtensionRegistryLite;

    :cond_2
    :goto_1
    if-nez v0, :cond_9

    .line 419
    :try_start_1
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result p1

    if-eqz p1, :cond_8

    const/16 v3, 0x8

    if-eq p1, v3, :cond_7

    const/16 v3, 0x12

    if-eq p1, v3, :cond_5

    const/16 v3, 0x1a

    if-eq p1, v3, :cond_3

    .line 425
    invoke-virtual {p2, p1}, Lcom/google/protobuf/CodedInputStream;->skipField(I)Z

    move-result p1

    if-nez p1, :cond_2

    goto :goto_4

    .line 450
    :cond_3
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-eqz p1, :cond_4

    .line 451
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HmacKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey$Builder;

    goto :goto_2

    :cond_4
    move-object p1, v2

    .line 453
    :goto_2
    invoke-static {}, Lcom/google/crypto/tink/proto/HmacKey;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/HmacKey;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-eqz p1, :cond_2

    .line 455
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 456
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/HmacKey$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    goto :goto_1

    .line 437
    :cond_5
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz p1, :cond_6

    .line 438
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesCtrKey;->toBuilder()Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;

    goto :goto_3

    :cond_6
    move-object p1, v2

    .line 440
    :goto_3
    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrKey;->parser()Lcom/google/protobuf/Parser;

    move-result-object v3

    invoke-virtual {p2, v3, p3}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;

    move-result-object v3

    check-cast v3, Lcom/google/crypto/tink/proto/AesCtrKey;

    iput-object v3, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz p1, :cond_2

    .line 442
    invoke-virtual {p1, v3}, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    .line 443
    invoke-virtual {p1}, Lcom/google/crypto/tink/proto/AesCtrKey$Builder;->buildPartial()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    goto :goto_1

    .line 432
    :cond_7
    invoke-virtual {p2}, Lcom/google/protobuf/CodedInputStream;->readUInt32()I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I
    :try_end_1
    .catch Lcom/google/protobuf/InvalidProtocolBufferException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :cond_8
    :goto_4
    move v0, v1

    goto :goto_1

    :catchall_1
    move-exception p1

    goto :goto_5

    :catch_0
    move-exception p1

    .line 466
    :try_start_2
    new-instance p2, Ljava/lang/RuntimeException;

    new-instance p3, Lcom/google/protobuf/InvalidProtocolBufferException;

    .line 468
    invoke-virtual {p1}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p3, p1}, Lcom/google/protobuf/InvalidProtocolBufferException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2

    :catch_1
    move-exception p1

    .line 464
    new-instance p2, Ljava/lang/RuntimeException;

    invoke-virtual {p1, p0}, Lcom/google/protobuf/InvalidProtocolBufferException;->setUnfinishedMessage(Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 469
    :goto_5
    throw p1

    .line 474
    :cond_9
    :pswitch_2
    sget-object p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p1

    .line 400
    :pswitch_3
    check-cast p2, Lcom/google/protobuf/GeneratedMessageLite$Visitor;

    .line 401
    check-cast p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    .line 402
    iget p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    if-eqz p1, :cond_a

    move p1, v1

    goto :goto_6

    :cond_a
    move p1, v0

    :goto_6
    iget v2, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    iget v3, p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    if-eqz v3, :cond_b

    move v0, v1

    :cond_b
    iget v1, p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    invoke-interface {p2, p1, v2, v0, v1}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitInt(ZIZI)I

    move-result p1

    iput p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    .line 404
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    iget-object v0, p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    invoke-interface {p2, p1, v0}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/AesCtrKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    .line 405
    iget-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    iget-object p3, p3, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    invoke-interface {p2, p1, p3}, Lcom/google/protobuf/GeneratedMessageLite$Visitor;->visitMessage(Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;

    move-result-object p1

    check-cast p1, Lcom/google/crypto/tink/proto/HmacKey;

    iput-object p1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    .line 406
    sget-object p1, Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;->INSTANCE:Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;

    return-object p0

    .line 397
    :pswitch_4
    new-instance p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;

    invoke-direct {p1, v2}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$Builder;-><init>(Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey$1;)V

    return-object p1

    :pswitch_5
    return-object v2

    .line 391
    :pswitch_6
    sget-object p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->DEFAULT_INSTANCE:Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    return-object p1

    .line 388
    :pswitch_7
    new-instance p1, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;

    invoke-direct {p1}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;-><init>()V

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

.method public getAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrKey;
    .locals 1

    .line 55
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/AesCtrKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/AesCtrKey;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getHmacKey()Lcom/google/crypto/tink/proto/HmacKey;
    .locals 1

    .line 107
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-nez v0, :cond_0

    invoke-static {}, Lcom/google/crypto/tink/proto/HmacKey;->getDefaultInstance()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSerializedSize()I
    .locals 3

    .line 161
    iget v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->memoizedSerializedSize:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    return v0

    :cond_0
    const/4 v0, 0x0

    .line 165
    iget v1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    .line 167
    invoke-static {v2, v1}, Lcom/google/protobuf/CodedOutputStream;->computeUInt32Size(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 169
    :cond_1
    iget-object v1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz v1, :cond_2

    const/4 v1, 0x2

    .line 171
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrKey;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 173
    :cond_2
    iget-object v1, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-eqz v1, :cond_3

    const/4 v1, 0x3

    .line 175
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getHmacKey()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v1

    add-int/2addr v0, v1

    .line 177
    :cond_3
    iput v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->memoizedSerializedSize:I

    return v0
.end method

.method public getVersion()I
    .locals 1

    .line 26
    iget v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    return v0
.end method

.method public hasAesCtrKey()Z
    .locals 1

    .line 49
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public hasHmacKey()Z
    .locals 1

    .line 101
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

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

    .line 149
    iget v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->version_:I

    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 150
    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeUInt32(II)V

    .line 152
    :cond_0
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->aesCtrKey_:Lcom/google/crypto/tink/proto/AesCtrKey;

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    .line 153
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getAesCtrKey()Lcom/google/crypto/tink/proto/AesCtrKey;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    .line 155
    :cond_1
    iget-object v0, p0, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->hmacKey_:Lcom/google/crypto/tink/proto/HmacKey;

    if-eqz v0, :cond_2

    const/4 v0, 0x3

    .line 156
    invoke-virtual {p0}, Lcom/google/crypto/tink/proto/AesCtrHmacAeadKey;->getHmacKey()Lcom/google/crypto/tink/proto/HmacKey;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    :cond_2
    return-void
.end method
