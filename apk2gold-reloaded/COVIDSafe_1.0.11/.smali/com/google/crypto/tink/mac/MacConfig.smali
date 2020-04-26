.class public final Lcom/google/crypto/tink/mac/MacConfig;
.super Ljava/lang/Object;
.source "MacConfig.java"


# static fields
.field private static final CATALOGUE_NAME:Ljava/lang/String; = "TinkMac"

.field public static final HMAC_TYPE_URL:Ljava/lang/String; = "type.googleapis.com/google.crypto.tink.HmacKey"

.field public static final LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

.field private static final PRIMITIVE_NAME:Ljava/lang/String; = "Mac"

.field public static final TINK_1_0_0:Lcom/google/crypto/tink/proto/RegistryConfig;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 47
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v1, "TINK_MAC_1_0_0"

    .line 48
    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    const-string v1, "TinkMac"

    const-string v2, "Mac"

    const-string v3, "HmacKey"

    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 49
    invoke-static {v1, v2, v3, v4, v5}, Lcom/google/crypto/tink/Config;->getTinkKeyTypeEntry(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/google/crypto/tink/proto/KeyTypeEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->addEntry(Lcom/google/crypto/tink/proto/KeyTypeEntry;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/mac/MacConfig;->TINK_1_0_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 58
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/crypto/tink/mac/MacConfig;->TINK_1_0_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    const-string v1, "TINK_MAC_1_1_0"

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/mac/MacConfig;->TINK_1_1_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 62
    invoke-static {}, Lcom/google/crypto/tink/proto/RegistryConfig;->newBuilder()Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/crypto/tink/mac/MacConfig;->TINK_1_0_0:Lcom/google/crypto/tink/proto/RegistryConfig;

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->mergeFrom(Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    const-string v1, "TINK_MAC"

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->setConfigName(Ljava/lang/String;)Lcom/google/crypto/tink/proto/RegistryConfig$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/crypto/tink/proto/RegistryConfig$Builder;->build()Lcom/google/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Lcom/google/crypto/tink/proto/RegistryConfig;

    sput-object v0, Lcom/google/crypto/tink/mac/MacConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    .line 66
    :try_start_0
    invoke-static {}, Lcom/google/crypto/tink/mac/MacConfig;->init()V
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 68
    new-instance v1, Ljava/lang/ExceptionInInitializerError;

    invoke-direct {v1, v0}, Ljava/lang/ExceptionInInitializerError;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public constructor <init>()V
    .locals 0

    .line 38
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

    .line 81
    invoke-static {}, Lcom/google/crypto/tink/mac/MacConfig;->register()V

    return-void
.end method

.method public static register()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 92
    new-instance v0, Lcom/google/crypto/tink/mac/MacCatalogue;

    invoke-direct {v0}, Lcom/google/crypto/tink/mac/MacCatalogue;-><init>()V

    const-string v1, "TinkMac"

    invoke-static {v1, v0}, Lcom/google/crypto/tink/Registry;->addCatalogue(Ljava/lang/String;Lcom/google/crypto/tink/Catalogue;)V

    .line 93
    sget-object v0, Lcom/google/crypto/tink/mac/MacConfig;->LATEST:Lcom/google/crypto/tink/proto/RegistryConfig;

    invoke-static {v0}, Lcom/google/crypto/tink/Config;->register(Lcom/google/crypto/tink/proto/RegistryConfig;)V

    return-void
.end method

.method public static registerStandardKeyTypes()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 106
    invoke-static {}, Lcom/google/crypto/tink/mac/MacConfig;->register()V

    return-void
.end method
