.class public final Lcom/google/crypto/tink/daead/DeterministicAeadConfig;
.super Ljava/lang/Object;
.source "DeterministicAeadConfig.java"


# static fields
.field public static final AES_SIV_TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.AesSivKey"

.field private static final CATALOGUE_NAME:Ljava/lang/String; = "TinkDeterministicAead"

.field public static final LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

.field private static final PRIMITIVE_NAME:Ljava/lang/String; = "DeterministicAead"

.field public static final TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 48
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    const-string v3, "AesSivKey"

    const-string v4, "DeterministicAead"

    const-string v5, "TinkDeterministicAead"

    .line 50
    invoke-static {v5, v4, v3, v2, v1}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v6

    .line 49
    invoke-virtual {v0, v6}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v6, "TINK_DETERMINISTIC_AEAD_1_1_0"

    .line 51
    invoke-virtual {v0, v6}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 52
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/daead/DeterministicAeadConfig;->TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 56
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 58
    invoke-static {v5, v4, v3, v2, v1}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v1

    .line 57
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v1, "TINK_DETERMINISTIC_AEAD"

    .line 59
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 60
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/daead/DeterministicAeadConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 64
    :try_start_0
    invoke-static {}, Lcom/google/crypto/tink/daead/DeterministicAeadConfig;->init()V
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 66
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

    .line 82
    invoke-static {}, Lcom/google/crypto/tink/daead/DeterministicAeadConfig;->register()V

    return-void
.end method

.method public static register()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 93
    new-instance v0, Lcom/google/crypto/tink/daead/DeterministicAeadCatalogue;

    invoke-direct {v0}, Lcom/google/crypto/tink/daead/DeterministicAeadCatalogue;-><init>()V

    const-string v1, "TinkDeterministicAead"

    invoke-static {v1, v0}, Lcom/google/crypto/tink/Registry;->addCatalogue(Ljava/lang/String;Lcom/google/crypto/tink/Catalogue;)V

    .line 94
    sget-object v0, Lcom/google/crypto/tink/daead/DeterministicAeadConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    invoke-static {v0}, Lcom/google/crypto/tink/Config;->register(Lcom/google/crypto/tink/proto/RegistryConfig;)V

    return-void
.end method
