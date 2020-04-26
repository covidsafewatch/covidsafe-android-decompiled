.class final Lcom/google/crypto/tink/subtle/Ed25519Constants;
.super Ljava/lang/Object;
.source "Ed25519Constants.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;
    }
.end annotation


# static fields
.field static final B2:[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

.field static final B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

.field static final D:[J

.field static final D2:[J

.field private static final D2_BI:Ljava/math/BigInteger;

.field private static final D_BI:Ljava/math/BigInteger;

.field private static final P_BI:Ljava/math/BigInteger;

.field static final SQRTM1:[J

.field private static final SQRTM1_BI:Ljava/math/BigInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const-wide/16 v0, 0x2

    .line 41
    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    const/16 v3, 0xff

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->pow(I)Ljava/math/BigInteger;

    move-result-object v2

    const-wide/16 v3, 0x13

    invoke-static {v3, v4}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sput-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    const-wide/32 v2, -0x1db41

    .line 43
    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    const-wide/32 v3, 0x1db42

    invoke-static {v3, v4}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v3

    sget-object v4, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v3, v4}, Ljava/math/BigInteger;->modInverse(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sput-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D_BI:Ljava/math/BigInteger;

    .line 44
    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D_BI:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sput-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D2_BI:Ljava/math/BigInteger;

    .line 46
    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    sget-object v2, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    const-wide/16 v2, 0x4

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/math/BigInteger;->divide(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v4, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v0, v1, v4}, Ljava/math/BigInteger;->modPow(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v0

    sput-object v0, Lcom/google/crypto/tink/subtle/Ed25519Constants;->SQRTM1_BI:Ljava/math/BigInteger;

    .line 103
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;-><init>(Lcom/google/crypto/tink/subtle/Ed25519Constants$1;)V

    .line 104
    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v1

    const-wide/16 v2, 0x5

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->modInverse(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$102(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    .line 105
    invoke-static {v0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->recoverX(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$202(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    .line 107
    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D_BI:Ljava/math/BigInteger;

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object v1

    sput-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D:[J

    .line 108
    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D2_BI:Ljava/math/BigInteger;

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object v1

    sput-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D2:[J

    .line 109
    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->SQRTM1_BI:Ljava/math/BigInteger;

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object v1

    sput-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->SQRTM1:[J

    const/4 v1, 0x2

    new-array v1, v1, [I

    .line 112
    fill-array-data v1, :array_0

    const-class v2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    invoke-static {v2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    sput-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    const/4 v1, 0x0

    move-object v3, v0

    move v2, v1

    :goto_0
    const/16 v4, 0x20

    const/16 v5, 0x8

    if-ge v2, v4, :cond_2

    move v4, v1

    move-object v6, v3

    :goto_1
    if-ge v4, v5, :cond_0

    .line 116
    sget-object v7, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v7, v7, v2

    invoke-static {v6}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->getCachedXYT(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    move-result-object v8

    aput-object v8, v7, v4

    .line 117
    invoke-static {v6, v3}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->edwards(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    move-result-object v6

    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    :cond_0
    move v4, v1

    :goto_2
    if-ge v4, v5, :cond_1

    .line 120
    invoke-static {v3, v3}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->edwards(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    move-result-object v3

    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 124
    :cond_2
    invoke-static {v0, v0}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->edwards(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    move-result-object v2

    new-array v3, v5, [Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    .line 125
    sput-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B2:[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    :goto_3
    if-ge v1, v5, :cond_3

    .line 127
    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B2:[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    invoke-static {v0}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->getCachedXYT(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    move-result-object v4

    aput-object v4, v3, v1

    .line 128
    invoke-static {v0, v2}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->edwards(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    move-result-object v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_3
    return-void

    nop

    :array_0
    .array-data 4
        0x20
        0x8
    .end array-data
.end method

.method constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static edwards(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "a",
            "b"
        }
    .end annotation

    .line 70
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;-><init>(Lcom/google/crypto/tink/subtle/Ed25519Constants$1;)V

    .line 71
    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D_BI:Ljava/math/BigInteger;

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    .line 73
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    .line 74
    invoke-virtual {v3, v1}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    sget-object v4, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v3, v4}, Ljava/math/BigInteger;->modInverse(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    .line 75
    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    .line 72
    invoke-static {v0, v2}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$202(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    .line 77
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object p0

    invoke-static {p1}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    invoke-virtual {v2, p0}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object p1, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    .line 78
    invoke-virtual {p1, v1}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p1

    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p1, v1}, Ljava/math/BigInteger;->modInverse(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p1

    invoke-virtual {p0, p1}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object p1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    .line 79
    invoke-virtual {p0, p1}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    .line 76
    invoke-static {v0, p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$102(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    return-object v0
.end method

.method private static getCachedXYT(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "p"
        }
    .end annotation

    .line 96
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    .line 97
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object v1

    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object v1

    .line 98
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {v2, v3}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v2

    invoke-static {v2}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object v2

    invoke-static {v2}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object v2

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D2_BI:Ljava/math/BigInteger;

    .line 99
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$200(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v3

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;->access$100(Lcom/google/crypto/tink/subtle/Ed25519Constants$Point;)Ljava/math/BigInteger;

    move-result-object p0

    invoke-virtual {v3, p0}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v3}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519Constants;->toLittleEndian(Ljava/math/BigInteger;)[B

    move-result-object p0

    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Field25519;->expand([B)[J

    move-result-object p0

    invoke-direct {v0, v1, v2, p0}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;-><init>([J[J[J)V

    return-object v0
.end method

.method private static recoverX(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "y"
        }
    .end annotation

    const/4 v0, 0x2

    .line 56
    invoke-virtual {p0, v0}, Ljava/math/BigInteger;->pow(I)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    .line 57
    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->D_BI:Ljava/math/BigInteger;

    .line 58
    invoke-virtual {p0, v0}, Ljava/math/BigInteger;->pow(I)Ljava/math/BigInteger;

    move-result-object p0

    invoke-virtual {v2, p0}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v2, Ljava/math/BigInteger;->ONE:Ljava/math/BigInteger;

    invoke-virtual {p0, v2}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v2}, Ljava/math/BigInteger;->modInverse(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    invoke-virtual {v1, p0}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    .line 59
    sget-object v1, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    const-wide/16 v2, 0x3

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    const-wide/16 v2, 0x8

    invoke-static {v2, v3}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/math/BigInteger;->divide(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v1, v2}, Ljava/math/BigInteger;->modPow(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    .line 60
    invoke-virtual {v1, v0}, Ljava/math/BigInteger;->pow(I)Ljava/math/BigInteger;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v0, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v0}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v0, Ljava/math/BigInteger;->ZERO:Ljava/math/BigInteger;

    invoke-virtual {p0, v0}, Ljava/math/BigInteger;->equals(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_0

    .line 61
    sget-object p0, Lcom/google/crypto/tink/subtle/Ed25519Constants;->SQRTM1_BI:Ljava/math/BigInteger;

    invoke-virtual {v1, p0}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object p0

    sget-object v0, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v0}, Ljava/math/BigInteger;->mod(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    :cond_0
    const/4 p0, 0x0

    .line 63
    invoke-virtual {v1, p0}, Ljava/math/BigInteger;->testBit(I)Z

    move-result p0

    if-eqz p0, :cond_1

    .line 64
    sget-object p0, Lcom/google/crypto/tink/subtle/Ed25519Constants;->P_BI:Ljava/math/BigInteger;

    invoke-virtual {p0, v1}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v1

    :cond_1
    return-object v1
.end method

.method private static toLittleEndian(Ljava/math/BigInteger;)[B
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "n"
        }
    .end annotation

    const/16 v0, 0x20

    new-array v1, v0, [B

    .line 85
    invoke-virtual {p0}, Ljava/math/BigInteger;->toByteArray()[B

    move-result-object p0

    .line 86
    array-length v2, p0

    rsub-int/lit8 v2, v2, 0x20

    array-length v3, p0

    const/4 v4, 0x0

    invoke-static {p0, v4, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_0
    const/16 p0, 0x10

    if-ge v4, p0, :cond_0

    .line 88
    aget-byte p0, v1, v4

    rsub-int/lit8 v2, v4, 0x20

    add-int/lit8 v2, v2, -0x1

    .line 89
    aget-byte v3, v1, v2

    aput-byte v3, v1, v4

    .line 90
    aput-byte p0, v1, v2

    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method
