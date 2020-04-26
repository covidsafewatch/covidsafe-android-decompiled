.class public final Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;
.super Ljava/lang/Object;
.source "StreamingAeadConfig.java"


# static fields
.field public static final AES_CTR_HMAC_STREAMINGAEAD_TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey"

.field public static final AES_GCM_HKDF_STREAMINGAEAD_TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey"

.field private static final CATALOGUE_NAME:Ljava/lang/String; = "TinkStreamingAead"

.field public static final LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

.field private static final PRIMITIVE_NAME:Ljava/lang/String; = "StreamingAead"

.field public static final TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .line 51
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v1, "AesCtrHmacStreamingKey"

    const/4 v2, 0x1

    const/4 v3, 0x0

    const-string v4, "StreamingAead"

    const-string v5, "TinkStreamingAead"

    .line 53
    invoke-static {v5, v4, v1, v3, v2}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v6

    .line 52
    invoke-virtual {v0, v6}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v6, "AesGcmHkdfStreamingKey"

    .line 56
    invoke-static {v5, v4, v6, v3, v2}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v7

    .line 55
    invoke-virtual {v0, v7}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v7, "TINK_STREAMINGAEAD_1_1_0"

    .line 58
    invoke-virtual {v0, v7}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 59
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;->TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 63
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 65
    invoke-static {v5, v4, v1, v3, v2}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v1

    .line 64
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 68
    invoke-static {v5, v4, v6, v3, v2}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v1

    .line 67
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v1, "TINK_STREAMINGAEAD"

    .line 70
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 71
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 75
    :try_start_0
    invoke-static {}, Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;->init()V
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 77
    new-instance v1, Ljava/lang/ExceptionInInitializerError;

    invoke-direct {v1, v0}, Ljava/lang/ExceptionInInitializerError;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public constructor <init>()V
    .locals 0

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static init()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 89
    invoke-static {}, Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;->register()V

    return-void
.end method

.method public static register()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 99
    new-instance v0, Lcom/google/crypto/tink/streamingaead/StreamingAeadCatalogue;

    invoke-direct {v0}, Lcom/google/crypto/tink/streamingaead/StreamingAeadCatalogue;-><init>()V

    const-string v1, "TinkStreamingAead"

    invoke-static {v1, v0}, Lcom/google/crypto/tink/Registry;->addCatalogue(Ljava/lang/String;Lcom/google/crypto/tink/Catalogue;)V

    .line 100
    sget-object v0, Lcom/google/crypto/tink/streamingaead/StreamingAeadConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    invoke-static {v0}, Lcom/google/crypto/tink/Config;->register(Lcom/google/crypto/tink/proto/RegistryConfig;)V

    return-void
.end method
