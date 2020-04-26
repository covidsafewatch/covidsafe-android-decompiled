.class public final enum Lcom/google/crypto/tink/proto/EcPointFormat;
.super Ljava/lang/Enum;
.source "EcPointFormat.java"

# interfaces
.implements Lcom/google/protobuf/Internal$EnumLite;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lcom/google/crypto/tink/proto/EcPointFormat;",
        ">;",
        "Lcom/google/protobuf/Internal$EnumLite;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/crypto/tink/proto/EcPointFormat;

.field public static final enum COMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

.field public static final COMPRESSED_VALUE:I = 0x2

.field public static final enum DO_NOT_USE_CRUNCHY_UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

.field public static final DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE:I = 0x3

.field public static final enum UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

.field public static final UNCOMPRESSED_VALUE:I = 0x1

.field public static final enum UNKNOWN_FORMAT:Lcom/google/crypto/tink/proto/EcPointFormat;

.field public static final UNKNOWN_FORMAT_VALUE:I

.field public static final enum UNRECOGNIZED:Lcom/google/crypto/tink/proto/EcPointFormat;

.field private static final internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/Internal$EnumLiteMap<",
            "Lcom/google/crypto/tink/proto/EcPointFormat;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .line 14
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v1, 0x0

    const-string v2, "UNKNOWN_FORMAT"

    invoke-direct {v0, v2, v1, v1}, Lcom/google/crypto/tink/proto/EcPointFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->UNKNOWN_FORMAT:Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 18
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v2, 0x1

    const-string v3, "UNCOMPRESSED"

    invoke-direct {v0, v3, v2, v2}, Lcom/google/crypto/tink/proto/EcPointFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 22
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v3, 0x2

    const-string v4, "COMPRESSED"

    invoke-direct {v0, v4, v3, v3}, Lcom/google/crypto/tink/proto/EcPointFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->COMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 31
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v4, 0x3

    const-string v5, "DO_NOT_USE_CRUNCHY_UNCOMPRESSED"

    invoke-direct {v0, v5, v4, v4}, Lcom/google/crypto/tink/proto/EcPointFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->DO_NOT_USE_CRUNCHY_UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 32
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v5, 0x4

    const-string v6, "UNRECOGNIZED"

    const/4 v7, -0x1

    invoke-direct {v0, v6, v5, v7}, Lcom/google/crypto/tink/proto/EcPointFormat;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->UNRECOGNIZED:Lcom/google/crypto/tink/proto/EcPointFormat;

    const/4 v6, 0x5

    new-array v6, v6, [Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 9
    sget-object v7, Lcom/google/crypto/tink/proto/EcPointFormat;->UNKNOWN_FORMAT:Lcom/google/crypto/tink/proto/EcPointFormat;

    aput-object v7, v6, v1

    sget-object v1, Lcom/google/crypto/tink/proto/EcPointFormat;->UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    aput-object v1, v6, v2

    sget-object v1, Lcom/google/crypto/tink/proto/EcPointFormat;->COMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    aput-object v1, v6, v3

    sget-object v1, Lcom/google/crypto/tink/proto/EcPointFormat;->DO_NOT_USE_CRUNCHY_UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    aput-object v1, v6, v4

    aput-object v0, v6, v5

    sput-object v6, Lcom/google/crypto/tink/proto/EcPointFormat;->$VALUES:[Lcom/google/crypto/tink/proto/EcPointFormat;

    .line 85
    new-instance v0, Lcom/google/crypto/tink/proto/EcPointFormat$1;

    invoke-direct {v0}, Lcom/google/crypto/tink/proto/EcPointFormat$1;-><init>()V

    sput-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x1000,
            0x1000,
            0x0
        }
        names = {
            "$enum$name",
            "$enum$ordinal",
            "value"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .line 94
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 95
    iput p3, p0, Lcom/google/crypto/tink/proto/EcPointFormat;->value:I

    return-void
.end method

.method public static forNumber(I)Lcom/google/crypto/tink/proto/EcPointFormat;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    if-eqz p0, :cond_3

    const/4 v0, 0x1

    if-eq p0, v0, :cond_2

    const/4 v0, 0x2

    if-eq p0, v0, :cond_1

    const/4 v0, 0x3

    if-eq p0, v0, :cond_0

    const/4 p0, 0x0

    return-object p0

    .line 75
    :cond_0
    sget-object p0, Lcom/google/crypto/tink/proto/EcPointFormat;->DO_NOT_USE_CRUNCHY_UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object p0

    .line 74
    :cond_1
    sget-object p0, Lcom/google/crypto/tink/proto/EcPointFormat;->COMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object p0

    .line 73
    :cond_2
    sget-object p0, Lcom/google/crypto/tink/proto/EcPointFormat;->UNCOMPRESSED:Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object p0

    .line 72
    :cond_3
    sget-object p0, Lcom/google/crypto/tink/proto/EcPointFormat;->UNKNOWN_FORMAT:Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object p0
.end method

.method public static internalGetValueMap()Lcom/google/protobuf/Internal$EnumLiteMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/Internal$EnumLiteMap<",
            "Lcom/google/crypto/tink/proto/EcPointFormat;",
            ">;"
        }
    .end annotation

    .line 82
    sget-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->internalValueMap:Lcom/google/protobuf/Internal$EnumLiteMap;

    return-object v0
.end method

.method public static valueOf(I)Lcom/google/crypto/tink/proto/EcPointFormat;
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "value"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 67
    invoke-static {p0}, Lcom/google/crypto/tink/proto/EcPointFormat;->forNumber(I)Lcom/google/crypto/tink/proto/EcPointFormat;

    move-result-object p0

    return-object p0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/crypto/tink/proto/EcPointFormat;
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x8000
        }
        names = {
            "name"
        }
    .end annotation

    .line 9
    const-class v0, Lcom/google/crypto/tink/proto/EcPointFormat;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object p0
.end method

.method public static values()[Lcom/google/crypto/tink/proto/EcPointFormat;
    .locals 1

    .line 9
    sget-object v0, Lcom/google/crypto/tink/proto/EcPointFormat;->$VALUES:[Lcom/google/crypto/tink/proto/EcPointFormat;

    invoke-virtual {v0}, [Lcom/google/crypto/tink/proto/EcPointFormat;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/crypto/tink/proto/EcPointFormat;

    return-object v0
.end method


# virtual methods
.method public final getNumber()I
    .locals 1

    .line 59
    iget v0, p0, Lcom/google/crypto/tink/proto/EcPointFormat;->value:I

    return v0
.end method
