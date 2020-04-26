.class final Lcom/google/crypto/tink/subtle/Ed25519;
.super Ljava/lang/Object;
.source "Ed25519.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;,
        Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;,
        Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;,
        Lcom/google/crypto/tink/subtle/Ed25519$XYZT;,
        Lcom/google/crypto/tink/subtle/Ed25519$XYZ;
    }
.end annotation


# static fields
.field private static final CACHED_NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

.field static final GROUP_ORDER:[B

.field private static final NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

.field public static final PUBLIC_KEY_LEN:I = 0x20

.field public static final SECRET_KEY_LEN:I = 0x20

.field public static final SIGNATURE_LEN:I = 0x40


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 52
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    const/16 v1, 0xa

    new-array v2, v1, [J

    fill-array-data v2, :array_0

    new-array v3, v1, [J

    fill-array-data v3, :array_1

    new-array v4, v1, [J

    fill-array-data v4, :array_2

    invoke-direct {v0, v2, v3, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;-><init>([J[J[J)V

    sput-object v0, Lcom/google/crypto/tink/subtle/Ed25519;->CACHED_NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    .line 56
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    new-instance v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    new-array v3, v1, [J

    fill-array-data v3, :array_3

    new-array v4, v1, [J

    fill-array-data v4, :array_4

    new-array v5, v1, [J

    fill-array-data v5, :array_5

    invoke-direct {v2, v3, v4, v5}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;-><init>([J[J[J)V

    new-array v1, v1, [J

    fill-array-data v1, :array_6

    invoke-direct {v0, v2, v1}, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$XYZ;[J)V

    sput-object v0, Lcom/google/crypto/tink/subtle/Ed25519;->NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    const/16 v0, 0x20

    new-array v0, v0, [B

    .line 1554
    fill-array-data v0, :array_7

    sput-object v0, Lcom/google/crypto/tink/subtle/Ed25519;->GROUP_ORDER:[B

    return-void

    :array_0
    .array-data 8
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_1
    .array-data 8
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_2
    .array-data 8
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_3
    .array-data 8
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_4
    .array-data 8
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_5
    .array-data 8
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_6
    .array-data 8
        0x1
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
        0x0
    .end array-data

    :array_7
    .array-data 1
        -0x13t
        -0x2dt
        -0xbt
        0x5ct
        0x1at
        0x63t
        0x12t
        0x58t
        -0x2at
        -0x64t
        -0x9t
        -0x5et
        -0x22t
        -0x7t
        -0x22t
        0x14t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x0t
        0x10t
    .end array-data
.end method

.method constructor <init>()V
    .locals 0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000([J)I
    .locals 0

    .line 45
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->getLsb([J)I

    move-result p0

    return p0
.end method

.method static synthetic access$100([J[J)V
    .locals 0

    .line 45
    invoke-static {p0, p1}, Lcom/google/crypto/tink/subtle/Ed25519;->pow2252m3([J[J)V

    return-void
.end method

.method static synthetic access$200([J)Z
    .locals 0

    .line 45
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->isNonZeroVarTime([J)Z

    move-result p0

    return p0
.end method

.method static synthetic access$300([J[J)V
    .locals 0

    .line 45
    invoke-static {p0, p1}, Lcom/google/crypto/tink/subtle/Ed25519;->neg([J[J)V

    return-void
.end method

.method private static add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "partialXYZT",
            "extended",
            "cached"
        }
    .end annotation

    const/16 v0, 0xa

    new-array v0, v0, [J

    .line 385
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v3, v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 388
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v3, v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 391
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yMinusX:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 394
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yPlusX:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 397
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->t:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->t2d:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 400
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    invoke-virtual {p2, v1, p1}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->multByZ([J[J)V

    .line 403
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 406
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {p1, p2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 409
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {p1, p2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 412
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    invoke-static {p1, v0, p2}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 415
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object p0, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    invoke-static {p1, v0, p0}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    return-void
.end method

.method private static doubleScalarMultVarTime([BLcom/google/crypto/tink/subtle/Ed25519$XYZT;[B)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;
    .locals 6
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "a",
            "pointA",
            "b"
        }
    .end annotation

    const/16 v0, 0x8

    new-array v1, v0, [Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;

    .line 692
    new-instance v2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;

    invoke-direct {v2, p1}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;)V

    const/4 v3, 0x0

    aput-object v2, v1, v3

    .line 693
    new-instance v2, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    invoke-direct {v2}, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;-><init>()V

    .line 694
    invoke-static {v2, p1}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZT(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;)V

    .line 695
    new-instance p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    invoke-direct {p1, v2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    const/4 v3, 0x1

    :goto_0
    if-ge v3, v0, :cond_0

    add-int/lit8 v4, v3, -0x1

    .line 697
    aget-object v4, v1, v4

    invoke-static {v2, p1, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    .line 698
    new-instance v4, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;

    new-instance v5, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    invoke-direct {v5, v2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    invoke-direct {v4, v5}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;)V

    aput-object v4, v1, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 701
    :cond_0
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->slide([B)[B

    move-result-object p0

    .line 702
    invoke-static {p2}, Lcom/google/crypto/tink/subtle/Ed25519;->slide([B)[B

    move-result-object p1

    .line 703
    new-instance p2, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    sget-object v0, Lcom/google/crypto/tink/subtle/Ed25519;->NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    invoke-direct {p2, v0}, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    .line 704
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    invoke-direct {v0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;-><init>()V

    const/16 v2, 0xff

    :goto_1
    if-ltz v2, :cond_2

    .line 707
    aget-byte v3, p0, v2

    if-nez v3, :cond_2

    aget-byte v3, p1, v2

    if-eqz v3, :cond_1

    goto :goto_2

    :cond_1
    add-int/lit8 v2, v2, -0x1

    goto :goto_1

    :cond_2
    :goto_2
    if-ltz v2, :cond_7

    .line 712
    new-instance v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    invoke-direct {v3, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    .line 713
    aget-byte v3, p0, v2

    if-lez v3, :cond_3

    .line 714
    invoke-static {v0, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v3

    aget-byte v4, p0, v2

    div-int/lit8 v4, v4, 0x2

    aget-object v4, v1, v4

    invoke-static {p2, v3, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    goto :goto_3

    .line 715
    :cond_3
    aget-byte v3, p0, v2

    if-gez v3, :cond_4

    .line 716
    invoke-static {v0, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v3

    aget-byte v4, p0, v2

    neg-int v4, v4

    div-int/lit8 v4, v4, 0x2

    aget-object v4, v1, v4

    invoke-static {p2, v3, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->sub(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    .line 718
    :cond_4
    :goto_3
    aget-byte v3, p1, v2

    if-lez v3, :cond_5

    .line 719
    invoke-static {v0, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v3

    sget-object v4, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B2:[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-byte v5, p1, v2

    div-int/lit8 v5, v5, 0x2

    aget-object v4, v4, v5

    invoke-static {p2, v3, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    goto :goto_4

    .line 720
    :cond_5
    aget-byte v3, p1, v2

    if-gez v3, :cond_6

    .line 721
    invoke-static {v0, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v3

    sget-object v4, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B2:[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-byte v5, p1, v2

    neg-int v5, v5

    div-int/lit8 v5, v5, 0x2

    aget-object v4, v4, v5

    invoke-static {p2, v3, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->sub(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    :cond_6
    :goto_4
    add-int/lit8 v2, v2, -0x1

    goto :goto_2

    .line 725
    :cond_7
    new-instance p0, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    invoke-direct {p0, p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    return-object p0
.end method

.method private static doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "partialXYZT",
            "p"
        }
    .end annotation

    const/16 v0, 0xa

    new-array v0, v0, [J

    .line 479
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 482
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 485
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    invoke-static {v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 488
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v3, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 491
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {v1, v2, p1}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 494
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {v0, p1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 497
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {p1, v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 500
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {p1, v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 503
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {p1, v0, v1}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 506
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v0, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object p0, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p0, p0, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    invoke-static {p1, v0, p0}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    return-void
.end method

.method private static doubleXYZT(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;)V
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "partialXYZT",
            "p"
        }
    .end annotation

    .line 513
    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    invoke-static {p0, p1}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    return-void
.end method

.method private static eq(II)I
    .locals 0
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

    xor-int/2addr p0, p1

    not-int p0, p0

    and-int/lit16 p0, p0, 0xff

    shl-int/lit8 p1, p0, 0x4

    and-int/2addr p0, p1

    shl-int/lit8 p1, p0, 0x2

    and-int/2addr p0, p1

    shl-int/lit8 p1, p0, 0x1

    and-int/2addr p0, p1

    shr-int/lit8 p0, p0, 0x7

    and-int/lit8 p0, p0, 0x1

    return p0
.end method

.method static getHashedScalar([B)[B
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10
        }
        names = {
            "privateKey"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 1505
    sget-object v0, Lcom/google/crypto/tink/subtle/EngineFactory;->MESSAGE_DIGEST:Lcom/google/crypto/tink/subtle/EngineFactory;

    const-string v1, "SHA-512"

    invoke-virtual {v0, v1}, Lcom/google/crypto/tink/subtle/EngineFactory;->getInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/security/MessageDigest;

    const/4 v1, 0x0

    const/16 v2, 0x20

    .line 1506
    invoke-virtual {v0, p0, v1, v2}, Ljava/security/MessageDigest;->update([BII)V

    .line 1507
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0

    .line 1510
    aget-byte v0, p0, v1

    and-int/lit16 v0, v0, 0xf8

    int-to-byte v0, v0

    aput-byte v0, p0, v1

    const/16 v0, 0x1f

    .line 1512
    aget-byte v1, p0, v0

    and-int/lit8 v1, v1, 0x7f

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 1514
    aget-byte v1, p0, v0

    or-int/lit8 v1, v1, 0x40

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    return-object p0
.end method

.method private static getLsb([J)I
    .locals 1
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "in"
        }
    .end annotation

    .line 750
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Field25519;->contract([J)[B

    move-result-object p0

    const/4 v0, 0x0

    aget-byte p0, p0, v0

    and-int/lit8 p0, p0, 0x1

    return p0
.end method

.method private static isNonZeroVarTime([J)Z
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "in"
        }
    .end annotation

    .line 734
    array-length v0, p0

    const/4 v1, 0x1

    add-int/2addr v0, v1

    new-array v0, v0, [J

    .line 735
    array-length v2, p0

    const/4 v3, 0x0

    invoke-static {p0, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 736
    invoke-static {v0}, Lcom/google/crypto/tink/subtle/Field25519;->reduceCoefficients([J)V

    .line 737
    invoke-static {v0}, Lcom/google/crypto/tink/subtle/Field25519;->contract([J)[B

    move-result-object p0

    .line 738
    array-length v0, p0

    move v2, v3

    :goto_0
    if-ge v2, v0, :cond_1

    aget-byte v4, p0, v2

    if-eqz v4, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return v3
.end method

.method private static isSmallerThanGroupOrder([B)Z
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "s"
        }
    .end annotation

    const/16 v0, 0x1f

    :goto_0
    const/4 v1, 0x0

    if-ltz v0, :cond_2

    .line 1571
    aget-byte v2, p0, v0

    and-int/lit16 v2, v2, 0xff

    .line 1572
    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519;->GROUP_ORDER:[B

    aget-byte v3, v3, v0

    and-int/lit16 v3, v3, 0xff

    if-eq v2, v3, :cond_1

    if-ge v2, v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1

    :cond_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_2
    return v1
.end method

.method private static load3([BI)J
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "in",
            "idx"
        }
    .end annotation

    .line 869
    aget-byte v0, p0, p1

    int-to-long v0, v0

    const-wide/16 v2, 0xff

    and-long/2addr v0, v2

    add-int/lit8 v2, p1, 0x1

    .line 870
    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xff

    int-to-long v2, v2

    const/16 v4, 0x8

    shl-long/2addr v2, v4

    or-long/2addr v0, v2

    add-int/lit8 p1, p1, 0x2

    .line 871
    aget-byte p0, p0, p1

    and-int/lit16 p0, p0, 0xff

    int-to-long p0, p0

    const/16 v2, 0x10

    shl-long/2addr p0, v2

    or-long/2addr p0, v0

    return-wide p0
.end method

.method private static load4([BI)J
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "in",
            "idx"
        }
    .end annotation

    .line 879
    invoke-static {p0, p1}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v0

    add-int/lit8 p1, p1, 0x3

    .line 880
    aget-byte p0, p0, p1

    and-int/lit16 p0, p0, 0xff

    int-to-long p0, p0

    const/16 v2, 0x18

    shl-long/2addr p0, v2

    or-long/2addr p0, v0

    return-wide p0
.end method

.method private static mulAdd([B[B[B[B)V
    .locals 82
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0,
            0x0
        }
        names = {
            "s",
            "a",
            "b",
            "c"
        }
    .end annotation

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    const/4 v3, 0x0

    .line 1164
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v4

    const-wide/32 v6, 0x1fffff

    and-long/2addr v4, v6

    const/4 v8, 0x2

    .line 1165
    invoke-static {v0, v8}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v9

    const/4 v11, 0x5

    shr-long/2addr v9, v11

    and-long/2addr v9, v6

    .line 1166
    invoke-static {v0, v11}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v12

    shr-long/2addr v12, v8

    and-long/2addr v12, v6

    const/4 v14, 0x7

    .line 1167
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v15

    shr-long/2addr v15, v14

    and-long/2addr v15, v6

    const/16 v3, 0xa

    .line 1168
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v17

    const/16 v19, 0x4

    shr-long v17, v17, v19

    and-long v17, v17, v6

    const/16 v3, 0xd

    .line 1169
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v20

    const/16 v22, 0x1

    shr-long v20, v20, v22

    and-long v20, v20, v6

    const/16 v3, 0xf

    .line 1170
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v23

    const/16 v25, 0x6

    shr-long v23, v23, v25

    and-long v23, v23, v6

    const/16 v3, 0x12

    .line 1171
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v26

    const/16 v28, 0x3

    shr-long v26, v26, v28

    and-long v26, v26, v6

    const/16 v3, 0x15

    .line 1172
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v29

    and-long v29, v29, v6

    const/16 v3, 0x17

    .line 1173
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v32

    shr-long v32, v32, v11

    and-long v32, v32, v6

    const/16 v3, 0x1a

    .line 1174
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v34

    shr-long v34, v34, v8

    and-long v34, v34, v6

    const/16 v3, 0x1c

    .line 1175
    invoke-static {v0, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v36

    shr-long v36, v36, v14

    const/4 v0, 0x0

    .line 1176
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v38

    and-long v38, v38, v6

    .line 1177
    invoke-static {v1, v8}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v40

    shr-long v40, v40, v11

    and-long v40, v40, v6

    .line 1178
    invoke-static {v1, v11}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v42

    shr-long v42, v42, v8

    and-long v42, v42, v6

    .line 1179
    invoke-static {v1, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v44

    shr-long v44, v44, v14

    and-long v44, v44, v6

    const/16 v0, 0xa

    .line 1180
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v46

    shr-long v46, v46, v19

    and-long v46, v46, v6

    const/16 v0, 0xd

    .line 1181
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v48

    shr-long v48, v48, v22

    and-long v48, v48, v6

    const/16 v0, 0xf

    .line 1182
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v50

    shr-long v50, v50, v25

    and-long v50, v50, v6

    const/16 v0, 0x12

    .line 1183
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v52

    shr-long v52, v52, v28

    and-long v52, v52, v6

    const/16 v0, 0x15

    .line 1184
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v54

    and-long v54, v54, v6

    const/16 v0, 0x17

    .line 1185
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v56

    shr-long v56, v56, v11

    and-long v56, v56, v6

    const/16 v0, 0x1a

    .line 1186
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v58

    shr-long v58, v58, v8

    and-long v58, v58, v6

    const/16 v0, 0x1c

    .line 1187
    invoke-static {v1, v0}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v0

    shr-long/2addr v0, v14

    const/4 v3, 0x0

    .line 1188
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v60

    and-long v60, v60, v6

    .line 1189
    invoke-static {v2, v8}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v62

    shr-long v62, v62, v11

    and-long v62, v62, v6

    .line 1190
    invoke-static {v2, v11}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v64

    shr-long v64, v64, v8

    and-long v64, v64, v6

    .line 1191
    invoke-static {v2, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v66

    shr-long v66, v66, v14

    and-long v66, v66, v6

    const/16 v3, 0xa

    .line 1192
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v68

    shr-long v68, v68, v19

    and-long v68, v68, v6

    const/16 v3, 0xd

    .line 1193
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v70

    shr-long v70, v70, v22

    and-long v70, v70, v6

    const/16 v3, 0xf

    .line 1194
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v72

    shr-long v72, v72, v25

    and-long v72, v72, v6

    const/16 v3, 0x12

    .line 1195
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v74

    shr-long v74, v74, v28

    and-long v74, v74, v6

    const/16 v3, 0x15

    .line 1196
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v76

    and-long v76, v76, v6

    const/16 v3, 0x17

    .line 1197
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v78

    shr-long v78, v78, v11

    and-long v78, v78, v6

    const/16 v3, 0x1a

    .line 1198
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v80

    shr-long v80, v80, v8

    and-long v6, v80, v6

    const/16 v3, 0x1c

    .line 1199
    invoke-static {v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v2

    shr-long/2addr v2, v14

    mul-long v80, v4, v38

    add-long v60, v60, v80

    mul-long v80, v4, v40

    add-long v62, v62, v80

    mul-long v80, v9, v38

    add-long v62, v62, v80

    mul-long v80, v4, v42

    add-long v64, v64, v80

    mul-long v80, v9, v40

    add-long v64, v64, v80

    mul-long v80, v12, v38

    add-long v64, v64, v80

    mul-long v80, v4, v44

    add-long v66, v66, v80

    mul-long v80, v9, v42

    add-long v66, v66, v80

    mul-long v80, v12, v40

    add-long v66, v66, v80

    mul-long v80, v15, v38

    add-long v66, v66, v80

    mul-long v80, v4, v46

    add-long v68, v68, v80

    mul-long v80, v9, v44

    add-long v68, v68, v80

    mul-long v80, v12, v42

    add-long v68, v68, v80

    mul-long v80, v15, v40

    add-long v68, v68, v80

    mul-long v80, v17, v38

    add-long v68, v68, v80

    mul-long v80, v4, v48

    add-long v70, v70, v80

    mul-long v80, v9, v46

    add-long v70, v70, v80

    mul-long v80, v12, v44

    add-long v70, v70, v80

    mul-long v80, v15, v42

    add-long v70, v70, v80

    mul-long v80, v17, v40

    add-long v70, v70, v80

    mul-long v80, v20, v38

    add-long v70, v70, v80

    mul-long v80, v4, v50

    add-long v72, v72, v80

    mul-long v80, v9, v48

    add-long v72, v72, v80

    mul-long v80, v12, v46

    add-long v72, v72, v80

    mul-long v80, v15, v44

    add-long v72, v72, v80

    mul-long v80, v17, v42

    add-long v72, v72, v80

    mul-long v80, v20, v40

    add-long v72, v72, v80

    mul-long v80, v23, v38

    add-long v72, v72, v80

    mul-long v80, v4, v52

    add-long v74, v74, v80

    mul-long v80, v9, v50

    add-long v74, v74, v80

    mul-long v80, v12, v48

    add-long v74, v74, v80

    mul-long v80, v15, v46

    add-long v74, v74, v80

    mul-long v80, v17, v44

    add-long v74, v74, v80

    mul-long v80, v20, v42

    add-long v74, v74, v80

    mul-long v80, v23, v40

    add-long v74, v74, v80

    mul-long v80, v26, v38

    add-long v74, v74, v80

    mul-long v80, v4, v54

    add-long v76, v76, v80

    mul-long v80, v9, v52

    add-long v76, v76, v80

    mul-long v80, v12, v50

    add-long v76, v76, v80

    mul-long v80, v15, v48

    add-long v76, v76, v80

    mul-long v80, v17, v46

    add-long v76, v76, v80

    mul-long v80, v20, v44

    add-long v76, v76, v80

    mul-long v80, v23, v42

    add-long v76, v76, v80

    mul-long v80, v26, v40

    add-long v76, v76, v80

    mul-long v80, v29, v38

    add-long v76, v76, v80

    mul-long v80, v4, v56

    add-long v78, v78, v80

    mul-long v80, v9, v54

    add-long v78, v78, v80

    mul-long v80, v12, v52

    add-long v78, v78, v80

    mul-long v80, v15, v50

    add-long v78, v78, v80

    mul-long v80, v17, v48

    add-long v78, v78, v80

    mul-long v80, v20, v46

    add-long v78, v78, v80

    mul-long v80, v23, v44

    add-long v78, v78, v80

    mul-long v80, v26, v42

    add-long v78, v78, v80

    mul-long v80, v29, v40

    add-long v78, v78, v80

    mul-long v80, v32, v38

    add-long v78, v78, v80

    mul-long v80, v4, v58

    add-long v6, v6, v80

    mul-long v80, v9, v56

    add-long v6, v6, v80

    mul-long v80, v12, v54

    add-long v6, v6, v80

    mul-long v80, v15, v52

    add-long v6, v6, v80

    mul-long v80, v17, v50

    add-long v6, v6, v80

    mul-long v80, v20, v48

    add-long v6, v6, v80

    mul-long v80, v23, v46

    add-long v6, v6, v80

    mul-long v80, v26, v44

    add-long v6, v6, v80

    mul-long v80, v29, v42

    add-long v6, v6, v80

    mul-long v80, v32, v40

    add-long v6, v6, v80

    mul-long v80, v34, v38

    add-long v6, v6, v80

    mul-long/2addr v4, v0

    add-long/2addr v2, v4

    mul-long v4, v9, v58

    add-long/2addr v2, v4

    mul-long v4, v12, v56

    add-long/2addr v2, v4

    mul-long v4, v15, v54

    add-long/2addr v2, v4

    mul-long v4, v17, v52

    add-long/2addr v2, v4

    mul-long v4, v20, v50

    add-long/2addr v2, v4

    mul-long v4, v23, v48

    add-long/2addr v2, v4

    mul-long v4, v26, v46

    add-long/2addr v2, v4

    mul-long v4, v29, v44

    add-long/2addr v2, v4

    mul-long v4, v32, v42

    add-long/2addr v2, v4

    mul-long v4, v34, v40

    add-long/2addr v2, v4

    mul-long v38, v38, v36

    add-long v2, v2, v38

    mul-long/2addr v9, v0

    mul-long v4, v12, v58

    add-long/2addr v9, v4

    mul-long v4, v15, v56

    add-long/2addr v9, v4

    mul-long v4, v17, v54

    add-long/2addr v9, v4

    mul-long v4, v20, v52

    add-long/2addr v9, v4

    mul-long v4, v23, v50

    add-long/2addr v9, v4

    mul-long v4, v26, v48

    add-long/2addr v9, v4

    mul-long v4, v29, v46

    add-long/2addr v9, v4

    mul-long v4, v32, v44

    add-long/2addr v9, v4

    mul-long v4, v34, v42

    add-long/2addr v9, v4

    mul-long v40, v40, v36

    add-long v9, v9, v40

    mul-long/2addr v12, v0

    mul-long v4, v15, v58

    add-long/2addr v12, v4

    mul-long v4, v17, v56

    add-long/2addr v12, v4

    mul-long v4, v20, v54

    add-long/2addr v12, v4

    mul-long v4, v23, v52

    add-long/2addr v12, v4

    mul-long v4, v26, v50

    add-long/2addr v12, v4

    mul-long v4, v29, v48

    add-long/2addr v12, v4

    mul-long v4, v32, v46

    add-long/2addr v12, v4

    mul-long v4, v34, v44

    add-long/2addr v12, v4

    mul-long v42, v42, v36

    add-long v12, v12, v42

    mul-long/2addr v15, v0

    mul-long v4, v17, v58

    add-long/2addr v15, v4

    mul-long v4, v20, v56

    add-long/2addr v15, v4

    mul-long v4, v23, v54

    add-long/2addr v15, v4

    mul-long v4, v26, v52

    add-long/2addr v15, v4

    mul-long v4, v29, v50

    add-long/2addr v15, v4

    mul-long v4, v32, v48

    add-long/2addr v15, v4

    mul-long v4, v34, v46

    add-long/2addr v15, v4

    mul-long v44, v44, v36

    add-long v15, v15, v44

    mul-long v17, v17, v0

    mul-long v4, v20, v58

    add-long v17, v17, v4

    mul-long v4, v23, v56

    add-long v17, v17, v4

    mul-long v4, v26, v54

    add-long v17, v17, v4

    mul-long v4, v29, v52

    add-long v17, v17, v4

    mul-long v4, v32, v50

    add-long v17, v17, v4

    mul-long v4, v34, v48

    add-long v17, v17, v4

    mul-long v46, v46, v36

    add-long v17, v17, v46

    mul-long v20, v20, v0

    mul-long v4, v23, v58

    add-long v20, v20, v4

    mul-long v4, v26, v56

    add-long v20, v20, v4

    mul-long v4, v29, v54

    add-long v20, v20, v4

    mul-long v4, v32, v52

    add-long v20, v20, v4

    mul-long v4, v34, v50

    add-long v20, v20, v4

    mul-long v48, v48, v36

    add-long v20, v20, v48

    mul-long v23, v23, v0

    mul-long v4, v26, v58

    add-long v23, v23, v4

    mul-long v4, v29, v56

    add-long v23, v23, v4

    mul-long v4, v32, v54

    add-long v23, v23, v4

    mul-long v4, v34, v52

    add-long v23, v23, v4

    mul-long v50, v50, v36

    add-long v23, v23, v50

    mul-long v26, v26, v0

    mul-long v4, v29, v58

    add-long v26, v26, v4

    mul-long v4, v32, v56

    add-long v26, v26, v4

    mul-long v4, v34, v54

    add-long v26, v26, v4

    mul-long v52, v52, v36

    add-long v26, v26, v52

    mul-long v29, v29, v0

    mul-long v4, v32, v58

    add-long v29, v29, v4

    mul-long v4, v34, v56

    add-long v29, v29, v4

    mul-long v54, v54, v36

    add-long v29, v29, v54

    mul-long v32, v32, v0

    mul-long v4, v34, v58

    add-long v32, v32, v4

    mul-long v56, v56, v36

    add-long v32, v32, v56

    mul-long v34, v34, v0

    mul-long v58, v58, v36

    add-long v34, v34, v58

    mul-long v36, v36, v0

    const-wide/32 v0, 0x100000

    add-long v4, v60, v0

    const/16 v31, 0x15

    shr-long v4, v4, v31

    add-long v62, v62, v4

    shl-long v4, v4, v31

    sub-long v60, v60, v4

    add-long v4, v64, v0

    shr-long v4, v4, v31

    add-long v66, v66, v4

    shl-long v4, v4, v31

    sub-long v64, v64, v4

    add-long v4, v68, v0

    shr-long v4, v4, v31

    add-long v70, v70, v4

    shl-long v4, v4, v31

    sub-long v68, v68, v4

    add-long v4, v72, v0

    shr-long v4, v4, v31

    add-long v74, v74, v4

    shl-long v4, v4, v31

    sub-long v72, v72, v4

    add-long v4, v76, v0

    shr-long v4, v4, v31

    add-long v78, v78, v4

    shl-long v4, v4, v31

    sub-long v76, v76, v4

    add-long v4, v6, v0

    shr-long v4, v4, v31

    add-long/2addr v2, v4

    shl-long v4, v4, v31

    sub-long/2addr v6, v4

    add-long v4, v9, v0

    shr-long v4, v4, v31

    add-long/2addr v12, v4

    shl-long v4, v4, v31

    sub-long/2addr v9, v4

    add-long v4, v15, v0

    shr-long v4, v4, v31

    add-long v17, v17, v4

    shl-long v4, v4, v31

    sub-long/2addr v15, v4

    add-long v4, v20, v0

    shr-long v4, v4, v31

    add-long v23, v23, v4

    shl-long v4, v4, v31

    sub-long v20, v20, v4

    add-long v4, v26, v0

    shr-long v4, v4, v31

    add-long v29, v29, v4

    shl-long v4, v4, v31

    sub-long v26, v26, v4

    add-long v4, v32, v0

    shr-long v4, v4, v31

    add-long v34, v34, v4

    shl-long v4, v4, v31

    sub-long v32, v32, v4

    add-long v4, v36, v0

    shr-long v4, v4, v31

    const-wide/16 v38, 0x0

    add-long v38, v4, v38

    shl-long v4, v4, v31

    sub-long v36, v36, v4

    add-long v4, v62, v0

    shr-long v4, v4, v31

    add-long v64, v64, v4

    shl-long v4, v4, v31

    sub-long v62, v62, v4

    add-long v4, v66, v0

    shr-long v4, v4, v31

    add-long v68, v68, v4

    shl-long v4, v4, v31

    sub-long v66, v66, v4

    add-long v4, v70, v0

    shr-long v4, v4, v31

    add-long v72, v72, v4

    shl-long v4, v4, v31

    sub-long v70, v70, v4

    add-long v4, v74, v0

    shr-long v4, v4, v31

    add-long v76, v76, v4

    shl-long v4, v4, v31

    sub-long v74, v74, v4

    add-long v4, v78, v0

    shr-long v4, v4, v31

    add-long/2addr v6, v4

    shl-long v4, v4, v31

    sub-long v78, v78, v4

    add-long v4, v2, v0

    shr-long v4, v4, v31

    add-long/2addr v9, v4

    shl-long v4, v4, v31

    sub-long/2addr v2, v4

    add-long v4, v12, v0

    shr-long v4, v4, v31

    add-long/2addr v15, v4

    shl-long v4, v4, v31

    sub-long/2addr v12, v4

    add-long v4, v17, v0

    shr-long v4, v4, v31

    add-long v20, v20, v4

    shl-long v4, v4, v31

    sub-long v17, v17, v4

    add-long v4, v23, v0

    shr-long v4, v4, v31

    add-long v26, v26, v4

    shl-long v4, v4, v31

    sub-long v23, v23, v4

    add-long v4, v29, v0

    shr-long v4, v4, v31

    add-long v32, v32, v4

    shl-long v4, v4, v31

    sub-long v29, v29, v4

    add-long v4, v34, v0

    shr-long v4, v4, v31

    add-long v36, v36, v4

    shl-long v4, v4, v31

    sub-long v34, v34, v4

    const-wide/32 v4, 0xa2c13

    mul-long v40, v38, v4

    add-long v2, v2, v40

    const-wide/32 v40, 0x72d18

    mul-long v42, v38, v40

    add-long v9, v9, v42

    const-wide/32 v42, 0x9fb67

    mul-long v44, v38, v42

    add-long v12, v12, v44

    const-wide/32 v44, 0xf39ad

    mul-long v46, v38, v44

    sub-long v15, v15, v46

    const-wide/32 v46, 0x215d1

    mul-long v48, v38, v46

    add-long v17, v17, v48

    const-wide/32 v48, 0xa6f7d

    mul-long v38, v38, v48

    sub-long v20, v20, v38

    mul-long v38, v36, v4

    add-long v6, v6, v38

    mul-long v38, v36, v40

    add-long v2, v2, v38

    mul-long v38, v36, v42

    add-long v9, v9, v38

    mul-long v38, v36, v44

    sub-long v12, v12, v38

    mul-long v38, v36, v46

    add-long v15, v15, v38

    mul-long v36, v36, v48

    sub-long v17, v17, v36

    mul-long v36, v34, v4

    add-long v78, v78, v36

    mul-long v36, v34, v40

    add-long v6, v6, v36

    mul-long v36, v34, v42

    add-long v2, v2, v36

    mul-long v36, v34, v44

    sub-long v9, v9, v36

    mul-long v36, v34, v46

    add-long v12, v12, v36

    mul-long v34, v34, v48

    sub-long v15, v15, v34

    mul-long v34, v32, v4

    add-long v76, v76, v34

    mul-long v34, v32, v40

    add-long v78, v78, v34

    mul-long v34, v32, v42

    add-long v6, v6, v34

    mul-long v34, v32, v44

    sub-long v2, v2, v34

    mul-long v34, v32, v46

    add-long v9, v9, v34

    mul-long v32, v32, v48

    sub-long v12, v12, v32

    mul-long v32, v29, v4

    add-long v74, v74, v32

    mul-long v32, v29, v40

    add-long v76, v76, v32

    mul-long v32, v29, v42

    add-long v78, v78, v32

    mul-long v32, v29, v44

    sub-long v6, v6, v32

    mul-long v32, v29, v46

    add-long v2, v2, v32

    mul-long v29, v29, v48

    sub-long v9, v9, v29

    mul-long v29, v26, v4

    add-long v72, v72, v29

    mul-long v29, v26, v40

    add-long v74, v74, v29

    mul-long v29, v26, v42

    add-long v76, v76, v29

    mul-long v29, v26, v44

    sub-long v78, v78, v29

    mul-long v29, v26, v46

    add-long v6, v6, v29

    mul-long v26, v26, v48

    sub-long v2, v2, v26

    add-long v26, v72, v0

    const/16 v29, 0x15

    shr-long v26, v26, v29

    add-long v74, v74, v26

    shl-long v26, v26, v29

    sub-long v72, v72, v26

    add-long v26, v76, v0

    shr-long v26, v26, v29

    add-long v78, v78, v26

    shl-long v26, v26, v29

    sub-long v76, v76, v26

    add-long v26, v6, v0

    shr-long v26, v26, v29

    add-long v2, v2, v26

    shl-long v26, v26, v29

    sub-long v6, v6, v26

    add-long v26, v9, v0

    shr-long v26, v26, v29

    add-long v12, v12, v26

    shl-long v26, v26, v29

    sub-long v9, v9, v26

    add-long v26, v15, v0

    shr-long v26, v26, v29

    add-long v17, v17, v26

    shl-long v26, v26, v29

    sub-long v15, v15, v26

    add-long v26, v20, v0

    shr-long v26, v26, v29

    add-long v23, v23, v26

    shl-long v26, v26, v29

    sub-long v20, v20, v26

    add-long v26, v74, v0

    shr-long v26, v26, v29

    add-long v76, v76, v26

    shl-long v26, v26, v29

    sub-long v74, v74, v26

    add-long v26, v78, v0

    shr-long v26, v26, v29

    add-long v6, v6, v26

    shl-long v26, v26, v29

    sub-long v78, v78, v26

    add-long v26, v2, v0

    shr-long v26, v26, v29

    add-long v9, v9, v26

    shl-long v26, v26, v29

    sub-long v2, v2, v26

    add-long v26, v12, v0

    shr-long v26, v26, v29

    add-long v15, v15, v26

    shl-long v26, v26, v29

    sub-long v12, v12, v26

    add-long v26, v17, v0

    shr-long v26, v26, v29

    add-long v20, v20, v26

    shl-long v26, v26, v29

    sub-long v17, v17, v26

    mul-long v26, v23, v4

    add-long v70, v70, v26

    mul-long v26, v23, v40

    add-long v72, v72, v26

    mul-long v26, v23, v42

    add-long v74, v74, v26

    mul-long v26, v23, v44

    sub-long v76, v76, v26

    mul-long v26, v23, v46

    add-long v78, v78, v26

    mul-long v23, v23, v48

    sub-long v6, v6, v23

    mul-long v23, v20, v4

    add-long v68, v68, v23

    mul-long v23, v20, v40

    add-long v70, v70, v23

    mul-long v23, v20, v42

    add-long v72, v72, v23

    mul-long v23, v20, v44

    sub-long v74, v74, v23

    mul-long v23, v20, v46

    add-long v76, v76, v23

    mul-long v20, v20, v48

    sub-long v78, v78, v20

    mul-long v20, v17, v4

    add-long v66, v66, v20

    mul-long v20, v17, v40

    add-long v68, v68, v20

    mul-long v20, v17, v42

    add-long v70, v70, v20

    mul-long v20, v17, v44

    sub-long v72, v72, v20

    mul-long v20, v17, v46

    add-long v74, v74, v20

    mul-long v17, v17, v48

    sub-long v76, v76, v17

    mul-long v17, v15, v4

    add-long v64, v64, v17

    mul-long v17, v15, v40

    add-long v66, v66, v17

    mul-long v17, v15, v42

    add-long v68, v68, v17

    mul-long v17, v15, v44

    sub-long v70, v70, v17

    mul-long v17, v15, v46

    add-long v72, v72, v17

    mul-long v15, v15, v48

    sub-long v74, v74, v15

    mul-long v15, v12, v4

    add-long v62, v62, v15

    mul-long v15, v12, v40

    add-long v64, v64, v15

    mul-long v15, v12, v42

    add-long v66, v66, v15

    mul-long v15, v12, v44

    sub-long v68, v68, v15

    mul-long v15, v12, v46

    add-long v70, v70, v15

    mul-long v12, v12, v48

    sub-long v72, v72, v12

    mul-long v12, v9, v4

    add-long v60, v60, v12

    mul-long v12, v9, v40

    add-long v62, v62, v12

    mul-long v12, v9, v42

    add-long v64, v64, v12

    mul-long v12, v9, v44

    sub-long v66, v66, v12

    mul-long v12, v9, v46

    add-long v68, v68, v12

    mul-long v9, v9, v48

    sub-long v70, v70, v9

    add-long v9, v60, v0

    const/16 v12, 0x15

    shr-long/2addr v9, v12

    add-long v62, v62, v9

    shl-long/2addr v9, v12

    sub-long v60, v60, v9

    add-long v9, v64, v0

    shr-long/2addr v9, v12

    add-long v66, v66, v9

    shl-long/2addr v9, v12

    sub-long v64, v64, v9

    add-long v9, v68, v0

    shr-long/2addr v9, v12

    add-long v70, v70, v9

    shl-long/2addr v9, v12

    sub-long v68, v68, v9

    add-long v9, v72, v0

    shr-long/2addr v9, v12

    add-long v74, v74, v9

    shl-long/2addr v9, v12

    sub-long v72, v72, v9

    add-long v9, v76, v0

    shr-long/2addr v9, v12

    add-long v78, v78, v9

    shl-long/2addr v9, v12

    sub-long v76, v76, v9

    add-long v9, v6, v0

    shr-long/2addr v9, v12

    add-long/2addr v2, v9

    shl-long/2addr v9, v12

    sub-long/2addr v6, v9

    add-long v9, v62, v0

    shr-long/2addr v9, v12

    add-long v64, v64, v9

    shl-long/2addr v9, v12

    sub-long v62, v62, v9

    add-long v9, v66, v0

    shr-long/2addr v9, v12

    add-long v68, v68, v9

    shl-long/2addr v9, v12

    sub-long v66, v66, v9

    add-long v9, v70, v0

    shr-long/2addr v9, v12

    add-long v72, v72, v9

    shl-long/2addr v9, v12

    sub-long v70, v70, v9

    add-long v9, v74, v0

    shr-long/2addr v9, v12

    add-long v76, v76, v9

    shl-long/2addr v9, v12

    sub-long v74, v74, v9

    add-long v9, v78, v0

    shr-long/2addr v9, v12

    add-long/2addr v6, v9

    shl-long/2addr v9, v12

    sub-long v78, v78, v9

    add-long/2addr v0, v2

    shr-long/2addr v0, v12

    const-wide/16 v9, 0x0

    add-long/2addr v9, v0

    shl-long/2addr v0, v12

    sub-long/2addr v2, v0

    mul-long v0, v9, v4

    add-long v60, v60, v0

    mul-long v0, v9, v40

    add-long v62, v62, v0

    mul-long v0, v9, v42

    add-long v64, v64, v0

    mul-long v0, v9, v44

    sub-long v66, v66, v0

    mul-long v0, v9, v46

    add-long v68, v68, v0

    mul-long v9, v9, v48

    sub-long v70, v70, v9

    const/16 v0, 0x15

    shr-long v9, v60, v0

    add-long v62, v62, v9

    shl-long/2addr v9, v0

    sub-long v60, v60, v9

    shr-long v9, v62, v0

    add-long v64, v64, v9

    shl-long/2addr v9, v0

    sub-long v62, v62, v9

    shr-long v9, v64, v0

    add-long v66, v66, v9

    shl-long/2addr v9, v0

    sub-long v64, v64, v9

    shr-long v9, v66, v0

    add-long v68, v68, v9

    shl-long/2addr v9, v0

    sub-long v66, v66, v9

    shr-long v9, v68, v0

    add-long v70, v70, v9

    shl-long/2addr v9, v0

    sub-long v68, v68, v9

    shr-long v9, v70, v0

    add-long v72, v72, v9

    shl-long/2addr v9, v0

    sub-long v70, v70, v9

    shr-long v9, v72, v0

    add-long v74, v74, v9

    shl-long/2addr v9, v0

    sub-long v72, v72, v9

    shr-long v9, v74, v0

    add-long v76, v76, v9

    shl-long/2addr v9, v0

    sub-long v74, v74, v9

    shr-long v9, v76, v0

    add-long v78, v78, v9

    shl-long/2addr v9, v0

    sub-long v76, v76, v9

    shr-long v9, v78, v0

    add-long/2addr v6, v9

    shl-long/2addr v9, v0

    sub-long v78, v78, v9

    shr-long v9, v6, v0

    add-long/2addr v2, v9

    shl-long/2addr v9, v0

    sub-long/2addr v6, v9

    shr-long v9, v2, v0

    const-wide/16 v12, 0x0

    add-long/2addr v12, v9

    shl-long/2addr v9, v0

    sub-long/2addr v2, v9

    mul-long/2addr v4, v12

    add-long v60, v60, v4

    mul-long v40, v40, v12

    add-long v62, v62, v40

    mul-long v42, v42, v12

    add-long v64, v64, v42

    mul-long v44, v44, v12

    sub-long v66, v66, v44

    mul-long v46, v46, v12

    add-long v68, v68, v46

    mul-long v12, v12, v48

    sub-long v70, v70, v12

    const/16 v0, 0x15

    shr-long v4, v60, v0

    add-long v62, v62, v4

    shl-long/2addr v4, v0

    sub-long v4, v60, v4

    shr-long v9, v62, v0

    add-long v64, v64, v9

    shl-long/2addr v9, v0

    sub-long v62, v62, v9

    shr-long v9, v64, v0

    add-long v66, v66, v9

    shl-long/2addr v9, v0

    sub-long v64, v64, v9

    shr-long v9, v66, v0

    add-long v68, v68, v9

    shl-long/2addr v9, v0

    sub-long v66, v66, v9

    shr-long v9, v68, v0

    add-long v70, v70, v9

    shl-long/2addr v9, v0

    sub-long v68, v68, v9

    shr-long v9, v70, v0

    add-long v72, v72, v9

    shl-long/2addr v9, v0

    sub-long v70, v70, v9

    shr-long v9, v72, v0

    add-long v74, v74, v9

    shl-long/2addr v9, v0

    sub-long v72, v72, v9

    shr-long v9, v74, v0

    add-long v76, v76, v9

    shl-long/2addr v9, v0

    sub-long v74, v74, v9

    shr-long v9, v76, v0

    add-long v78, v78, v9

    shl-long/2addr v9, v0

    sub-long v9, v76, v9

    shr-long v12, v78, v0

    add-long/2addr v6, v12

    shl-long/2addr v12, v0

    sub-long v78, v78, v12

    shr-long v12, v6, v0

    add-long/2addr v2, v12

    shl-long/2addr v12, v0

    sub-long/2addr v6, v12

    long-to-int v0, v4

    int-to-byte v0, v0

    const/4 v1, 0x0

    .line 1469
    aput-byte v0, p0, v1

    const/16 v0, 0x8

    shr-long v0, v4, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1470
    aput-byte v0, p0, v22

    const/16 v0, 0x10

    shr-long v0, v4, v0

    shl-long v4, v62, v11

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1471
    aput-byte v0, p0, v8

    shr-long v0, v62, v28

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1472
    aput-byte v0, p0, v28

    const/16 v0, 0xb

    shr-long v0, v62, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1473
    aput-byte v0, p0, v19

    const/16 v0, 0x13

    shr-long v0, v62, v0

    shl-long v4, v64, v8

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1474
    aput-byte v0, p0, v11

    shr-long v0, v64, v25

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1475
    aput-byte v0, p0, v25

    const/16 v0, 0xe

    shr-long v0, v64, v0

    shl-long v4, v66, v14

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    .line 1476
    aput-byte v0, p0, v14

    shr-long v0, v66, v22

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x8

    .line 1477
    aput-byte v0, p0, v1

    const/16 v0, 0x9

    shr-long v0, v66, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x9

    .line 1478
    aput-byte v0, p0, v1

    const/16 v0, 0x11

    shr-long v0, v66, v0

    shl-long v4, v68, v19

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0xa

    .line 1479
    aput-byte v0, p0, v1

    shr-long v0, v68, v19

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0xb

    .line 1480
    aput-byte v0, p0, v1

    const/16 v0, 0xc

    shr-long v0, v68, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0xc

    .line 1481
    aput-byte v0, p0, v1

    const/16 v0, 0x14

    shr-long v0, v68, v0

    shl-long v4, v70, v22

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0xd

    .line 1482
    aput-byte v0, p0, v1

    shr-long v0, v70, v14

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0xe

    .line 1483
    aput-byte v0, p0, v1

    const/16 v0, 0xf

    shr-long v4, v70, v0

    shl-long v12, v72, v25

    or-long/2addr v4, v12

    long-to-int v1, v4

    int-to-byte v1, v1

    .line 1484
    aput-byte v1, p0, v0

    shr-long v0, v72, v8

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x10

    .line 1485
    aput-byte v0, p0, v1

    const/16 v0, 0xa

    shr-long v0, v72, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x11

    .line 1486
    aput-byte v0, p0, v1

    const/16 v0, 0x12

    shr-long v4, v72, v0

    shl-long v12, v74, v28

    or-long/2addr v4, v12

    long-to-int v1, v4

    int-to-byte v1, v1

    .line 1487
    aput-byte v1, p0, v0

    shr-long v0, v74, v11

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x13

    .line 1488
    aput-byte v0, p0, v1

    const/16 v0, 0xd

    shr-long v0, v74, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x14

    .line 1489
    aput-byte v0, p0, v1

    long-to-int v0, v9

    int-to-byte v0, v0

    const/16 v1, 0x15

    .line 1490
    aput-byte v0, p0, v1

    const/16 v0, 0x8

    shr-long v0, v9, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x16

    .line 1491
    aput-byte v0, p0, v1

    const/16 v0, 0x10

    shr-long v0, v9, v0

    shl-long v4, v78, v11

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x17

    .line 1492
    aput-byte v0, p0, v1

    shr-long v0, v78, v28

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x18

    .line 1493
    aput-byte v0, p0, v1

    const/16 v0, 0xb

    shr-long v0, v78, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x19

    .line 1494
    aput-byte v0, p0, v1

    const/16 v0, 0x13

    shr-long v0, v78, v0

    shl-long v4, v6, v8

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1a

    .line 1495
    aput-byte v0, p0, v1

    shr-long v0, v6, v25

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1b

    .line 1496
    aput-byte v0, p0, v1

    const/16 v0, 0xe

    shr-long v0, v6, v0

    shl-long v4, v2, v14

    or-long/2addr v0, v4

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1c

    .line 1497
    aput-byte v0, p0, v1

    shr-long v0, v2, v22

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1d

    .line 1498
    aput-byte v0, p0, v1

    const/16 v0, 0x9

    shr-long v0, v2, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1e

    .line 1499
    aput-byte v0, p0, v1

    const/16 v0, 0x11

    shr-long v0, v2, v0

    long-to-int v0, v0

    int-to-byte v0, v0

    const/16 v1, 0x1f

    .line 1500
    aput-byte v0, p0, v1

    return-void
.end method

.method private static neg([J[J)V
    .locals 3
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "out",
            "in"
        }
    .end annotation

    const/4 v0, 0x0

    .line 757
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_0

    .line 758
    aget-wide v1, p1, v0

    neg-long v1, v1

    aput-wide v1, p0, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method private static pow2252m3([J[J)V
    .locals 8
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0
        }
        names = {
            "out",
            "in"
        }
    .end annotation

    const/16 v0, 0xa

    new-array v1, v0, [J

    new-array v2, v0, [J

    new-array v3, v0, [J

    .line 771
    invoke-static {v1, p1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 774
    invoke-static {v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    const/4 v4, 0x1

    move v5, v4

    :goto_0
    const/4 v6, 0x2

    if-ge v5, v6, :cond_0

    .line 776
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 780
    :cond_0
    invoke-static {v2, p1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 783
    invoke-static {v1, v1, v2}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 786
    invoke-static {v1, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    .line 789
    invoke-static {v1, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 792
    invoke-static {v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v5, v4

    :goto_1
    const/4 v7, 0x5

    if-ge v5, v7, :cond_1

    .line 794
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 798
    :cond_1
    invoke-static {v1, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 801
    invoke-static {v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v5, v4

    :goto_2
    if-ge v5, v0, :cond_2

    .line 803
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 807
    :cond_2
    invoke-static {v2, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 810
    invoke-static {v3, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v5, v4

    :goto_3
    const/16 v7, 0x14

    if-ge v5, v7, :cond_3

    .line 812
    invoke-static {v3, v3}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    .line 816
    :cond_3
    invoke-static {v2, v3, v2}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 819
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v5, v4

    :goto_4
    if-ge v5, v0, :cond_4

    .line 821
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v5, v5, 0x1

    goto :goto_4

    .line 825
    :cond_4
    invoke-static {v1, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 828
    invoke-static {v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v0, v4

    :goto_5
    const/16 v5, 0x32

    if-ge v0, v5, :cond_5

    .line 830
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 834
    :cond_5
    invoke-static {v2, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 837
    invoke-static {v3, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v0, v4

    :goto_6
    const/16 v7, 0x64

    if-ge v0, v7, :cond_6

    .line 839
    invoke-static {v3, v3}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 843
    :cond_6
    invoke-static {v2, v3, v2}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 846
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    move v0, v4

    :goto_7
    if-ge v0, v5, :cond_7

    .line 848
    invoke-static {v2, v2}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .line 852
    :cond_7
    invoke-static {v1, v2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 855
    invoke-static {v1, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    :goto_8
    if-ge v4, v6, :cond_8

    .line 857
    invoke-static {v1, v1}, Lcom/google/crypto/tink/subtle/Field25519;->square([J[J)V

    add-int/lit8 v4, v4, 0x1

    goto :goto_8

    .line 861
    :cond_8
    invoke-static {p0, v1, p1}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    return-void
.end method

.method private static reduce([B)V
    .locals 69
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "s"
        }
    .end annotation

    move-object/from16 v0, p0

    const/4 v1, 0x0

    .line 901
    invoke-static {v0, v1}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v1

    const-wide/32 v3, 0x1fffff

    and-long/2addr v1, v3

    const/4 v5, 0x2

    .line 902
    invoke-static {v0, v5}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v6

    const/4 v8, 0x5

    shr-long/2addr v6, v8

    and-long/2addr v6, v3

    .line 903
    invoke-static {v0, v8}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v9

    shr-long/2addr v9, v5

    and-long/2addr v9, v3

    const/4 v11, 0x7

    .line 904
    invoke-static {v0, v11}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v12

    shr-long/2addr v12, v11

    and-long/2addr v12, v3

    const/16 v14, 0xa

    .line 905
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v15

    const/16 v17, 0x4

    shr-long v15, v15, v17

    and-long/2addr v15, v3

    const/16 v14, 0xd

    .line 906
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v18

    const/16 v20, 0x1

    shr-long v18, v18, v20

    and-long v18, v18, v3

    const/16 v14, 0xf

    .line 907
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v21

    const/16 v23, 0x6

    shr-long v21, v21, v23

    and-long v21, v21, v3

    const/16 v14, 0x12

    .line 908
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v24

    const/16 v26, 0x3

    shr-long v24, v24, v26

    and-long v24, v24, v3

    const/16 v14, 0x15

    .line 909
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v27

    and-long v27, v27, v3

    const/16 v14, 0x17

    .line 910
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v29

    shr-long v29, v29, v8

    and-long v29, v29, v3

    const/16 v14, 0x1a

    .line 911
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v31

    shr-long v31, v31, v5

    and-long v31, v31, v3

    const/16 v14, 0x1c

    .line 912
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v33

    shr-long v33, v33, v11

    and-long v33, v33, v3

    const/16 v14, 0x1f

    .line 913
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v35

    shr-long v35, v35, v17

    and-long v35, v35, v3

    const/16 v14, 0x22

    .line 914
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v37

    shr-long v37, v37, v20

    and-long v37, v37, v3

    const/16 v14, 0x24

    .line 915
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v39

    shr-long v39, v39, v23

    and-long v39, v39, v3

    const/16 v14, 0x27

    .line 916
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v41

    shr-long v41, v41, v26

    and-long v41, v41, v3

    const/16 v14, 0x2a

    .line 917
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v43

    and-long v43, v43, v3

    const/16 v14, 0x2c

    .line 918
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v45

    shr-long v45, v45, v8

    and-long v45, v45, v3

    const/16 v14, 0x2f

    .line 919
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v47

    shr-long v47, v47, v5

    and-long v47, v47, v3

    const/16 v14, 0x31

    .line 920
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v49

    shr-long v49, v49, v11

    and-long v49, v49, v3

    const/16 v14, 0x34

    .line 921
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v51

    shr-long v51, v51, v17

    and-long v51, v51, v3

    const/16 v14, 0x37

    .line 922
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load3([BI)J

    move-result-wide v53

    shr-long v53, v53, v20

    and-long v53, v53, v3

    const/16 v14, 0x39

    .line 923
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v55

    shr-long v55, v55, v23

    and-long v3, v55, v3

    const/16 v14, 0x3c

    .line 924
    invoke-static {v0, v14}, Lcom/google/crypto/tink/subtle/Ed25519;->load4([BI)J

    move-result-wide v55

    shr-long v55, v55, v26

    const-wide/32 v57, 0xa2c13

    mul-long v59, v55, v57

    add-long v33, v33, v59

    const-wide/32 v59, 0x72d18

    mul-long v61, v55, v59

    add-long v35, v35, v61

    const-wide/32 v61, 0x9fb67

    mul-long v63, v55, v61

    add-long v37, v37, v63

    const-wide/32 v63, 0xf39ad

    mul-long v65, v55, v63

    sub-long v39, v39, v65

    const-wide/32 v65, 0x215d1

    mul-long v67, v55, v65

    add-long v41, v41, v67

    const-wide/32 v67, 0xa6f7d

    mul-long v55, v55, v67

    sub-long v43, v43, v55

    mul-long v55, v3, v57

    add-long v31, v31, v55

    mul-long v55, v3, v59

    add-long v33, v33, v55

    mul-long v55, v3, v61

    add-long v35, v35, v55

    mul-long v55, v3, v63

    sub-long v37, v37, v55

    mul-long v55, v3, v65

    add-long v39, v39, v55

    mul-long v3, v3, v67

    sub-long v41, v41, v3

    mul-long v3, v53, v57

    add-long v29, v29, v3

    mul-long v3, v53, v59

    add-long v31, v31, v3

    mul-long v3, v53, v61

    add-long v33, v33, v3

    mul-long v3, v53, v63

    sub-long v35, v35, v3

    mul-long v3, v53, v65

    add-long v37, v37, v3

    mul-long v53, v53, v67

    sub-long v39, v39, v53

    mul-long v3, v51, v57

    add-long v27, v27, v3

    mul-long v3, v51, v59

    add-long v29, v29, v3

    mul-long v3, v51, v61

    add-long v31, v31, v3

    mul-long v3, v51, v63

    sub-long v33, v33, v3

    mul-long v3, v51, v65

    add-long v35, v35, v3

    mul-long v51, v51, v67

    sub-long v37, v37, v51

    mul-long v3, v49, v57

    add-long v24, v24, v3

    mul-long v3, v49, v59

    add-long v27, v27, v3

    mul-long v3, v49, v61

    add-long v29, v29, v3

    mul-long v3, v49, v63

    sub-long v31, v31, v3

    mul-long v3, v49, v65

    add-long v33, v33, v3

    mul-long v49, v49, v67

    sub-long v35, v35, v49

    mul-long v3, v47, v57

    add-long v21, v21, v3

    mul-long v3, v47, v59

    add-long v24, v24, v3

    mul-long v3, v47, v61

    add-long v27, v27, v3

    mul-long v3, v47, v63

    sub-long v29, v29, v3

    mul-long v3, v47, v65

    add-long v31, v31, v3

    mul-long v47, v47, v67

    sub-long v33, v33, v47

    const-wide/32 v3, 0x100000

    add-long v47, v21, v3

    const/16 v14, 0x15

    shr-long v47, v47, v14

    add-long v24, v24, v47

    shl-long v47, v47, v14

    sub-long v21, v21, v47

    add-long v47, v27, v3

    shr-long v47, v47, v14

    add-long v29, v29, v47

    shl-long v47, v47, v14

    sub-long v27, v27, v47

    add-long v47, v31, v3

    shr-long v47, v47, v14

    add-long v33, v33, v47

    shl-long v47, v47, v14

    sub-long v31, v31, v47

    add-long v47, v35, v3

    shr-long v47, v47, v14

    add-long v37, v37, v47

    shl-long v47, v47, v14

    sub-long v35, v35, v47

    add-long v47, v39, v3

    shr-long v47, v47, v14

    add-long v41, v41, v47

    shl-long v47, v47, v14

    sub-long v39, v39, v47

    add-long v47, v43, v3

    shr-long v47, v47, v14

    add-long v45, v45, v47

    shl-long v47, v47, v14

    sub-long v43, v43, v47

    add-long v47, v24, v3

    shr-long v47, v47, v14

    add-long v27, v27, v47

    shl-long v47, v47, v14

    sub-long v24, v24, v47

    add-long v47, v29, v3

    shr-long v47, v47, v14

    add-long v31, v31, v47

    shl-long v47, v47, v14

    sub-long v29, v29, v47

    add-long v47, v33, v3

    shr-long v47, v47, v14

    add-long v35, v35, v47

    shl-long v47, v47, v14

    sub-long v33, v33, v47

    add-long v47, v37, v3

    shr-long v47, v47, v14

    add-long v39, v39, v47

    shl-long v47, v47, v14

    sub-long v37, v37, v47

    add-long v47, v41, v3

    shr-long v47, v47, v14

    add-long v43, v43, v47

    shl-long v47, v47, v14

    sub-long v41, v41, v47

    mul-long v47, v45, v57

    add-long v18, v18, v47

    mul-long v47, v45, v59

    add-long v21, v21, v47

    mul-long v47, v45, v61

    add-long v24, v24, v47

    mul-long v47, v45, v63

    sub-long v27, v27, v47

    mul-long v47, v45, v65

    add-long v29, v29, v47

    mul-long v45, v45, v67

    sub-long v31, v31, v45

    mul-long v45, v43, v57

    add-long v15, v15, v45

    mul-long v45, v43, v59

    add-long v18, v18, v45

    mul-long v45, v43, v61

    add-long v21, v21, v45

    mul-long v45, v43, v63

    sub-long v24, v24, v45

    mul-long v45, v43, v65

    add-long v27, v27, v45

    mul-long v43, v43, v67

    sub-long v29, v29, v43

    mul-long v43, v41, v57

    add-long v12, v12, v43

    mul-long v43, v41, v59

    add-long v15, v15, v43

    mul-long v43, v41, v61

    add-long v18, v18, v43

    mul-long v43, v41, v63

    sub-long v21, v21, v43

    mul-long v43, v41, v65

    add-long v24, v24, v43

    mul-long v41, v41, v67

    sub-long v27, v27, v41

    mul-long v41, v39, v57

    add-long v9, v9, v41

    mul-long v41, v39, v59

    add-long v12, v12, v41

    mul-long v41, v39, v61

    add-long v15, v15, v41

    mul-long v41, v39, v63

    sub-long v18, v18, v41

    mul-long v41, v39, v65

    add-long v21, v21, v41

    mul-long v39, v39, v67

    sub-long v24, v24, v39

    mul-long v39, v37, v57

    add-long v6, v6, v39

    mul-long v39, v37, v59

    add-long v9, v9, v39

    mul-long v39, v37, v61

    add-long v12, v12, v39

    mul-long v39, v37, v63

    sub-long v15, v15, v39

    mul-long v39, v37, v65

    add-long v18, v18, v39

    mul-long v37, v37, v67

    sub-long v21, v21, v37

    mul-long v37, v35, v57

    add-long v1, v1, v37

    mul-long v37, v35, v59

    add-long v6, v6, v37

    mul-long v37, v35, v61

    add-long v9, v9, v37

    mul-long v37, v35, v63

    sub-long v12, v12, v37

    mul-long v37, v35, v65

    add-long v15, v15, v37

    mul-long v35, v35, v67

    sub-long v18, v18, v35

    add-long v35, v1, v3

    const/16 v14, 0x15

    shr-long v35, v35, v14

    add-long v6, v6, v35

    shl-long v35, v35, v14

    sub-long v1, v1, v35

    add-long v35, v9, v3

    shr-long v35, v35, v14

    add-long v12, v12, v35

    shl-long v35, v35, v14

    sub-long v9, v9, v35

    add-long v35, v15, v3

    shr-long v35, v35, v14

    add-long v18, v18, v35

    shl-long v35, v35, v14

    sub-long v15, v15, v35

    add-long v35, v21, v3

    shr-long v35, v35, v14

    add-long v24, v24, v35

    shl-long v35, v35, v14

    sub-long v21, v21, v35

    add-long v35, v27, v3

    shr-long v35, v35, v14

    add-long v29, v29, v35

    shl-long v35, v35, v14

    sub-long v27, v27, v35

    add-long v35, v31, v3

    shr-long v35, v35, v14

    add-long v33, v33, v35

    shl-long v35, v35, v14

    sub-long v31, v31, v35

    add-long v35, v6, v3

    shr-long v35, v35, v14

    add-long v9, v9, v35

    shl-long v35, v35, v14

    sub-long v6, v6, v35

    add-long v35, v12, v3

    shr-long v35, v35, v14

    add-long v15, v15, v35

    shl-long v35, v35, v14

    sub-long v12, v12, v35

    add-long v35, v18, v3

    shr-long v35, v35, v14

    add-long v21, v21, v35

    shl-long v35, v35, v14

    sub-long v18, v18, v35

    add-long v35, v24, v3

    shr-long v35, v35, v14

    add-long v27, v27, v35

    shl-long v35, v35, v14

    sub-long v24, v24, v35

    add-long v35, v29, v3

    shr-long v35, v35, v14

    add-long v31, v31, v35

    shl-long v35, v35, v14

    sub-long v29, v29, v35

    add-long v3, v33, v3

    shr-long/2addr v3, v14

    const-wide/16 v35, 0x0

    add-long v35, v3, v35

    shl-long/2addr v3, v14

    sub-long v33, v33, v3

    mul-long v3, v35, v57

    add-long/2addr v1, v3

    mul-long v3, v35, v59

    add-long/2addr v6, v3

    mul-long v3, v35, v61

    add-long/2addr v9, v3

    mul-long v3, v35, v63

    sub-long/2addr v12, v3

    mul-long v3, v35, v65

    add-long/2addr v15, v3

    mul-long v35, v35, v67

    sub-long v18, v18, v35

    const/16 v3, 0x15

    shr-long v35, v1, v3

    add-long v6, v6, v35

    shl-long v35, v35, v3

    sub-long v1, v1, v35

    shr-long v35, v6, v3

    add-long v9, v9, v35

    shl-long v35, v35, v3

    sub-long v6, v6, v35

    shr-long v35, v9, v3

    add-long v12, v12, v35

    shl-long v35, v35, v3

    sub-long v9, v9, v35

    shr-long v35, v12, v3

    add-long v15, v15, v35

    shl-long v35, v35, v3

    sub-long v12, v12, v35

    shr-long v35, v15, v3

    add-long v18, v18, v35

    shl-long v35, v35, v3

    sub-long v15, v15, v35

    shr-long v35, v18, v3

    add-long v21, v21, v35

    shl-long v35, v35, v3

    sub-long v18, v18, v35

    shr-long v35, v21, v3

    add-long v24, v24, v35

    shl-long v35, v35, v3

    sub-long v21, v21, v35

    shr-long v35, v24, v3

    add-long v27, v27, v35

    shl-long v35, v35, v3

    sub-long v24, v24, v35

    shr-long v35, v27, v3

    add-long v29, v29, v35

    shl-long v35, v35, v3

    sub-long v27, v27, v35

    shr-long v35, v29, v3

    add-long v31, v31, v35

    shl-long v35, v35, v3

    sub-long v29, v29, v35

    shr-long v35, v31, v3

    add-long v33, v33, v35

    shl-long v35, v35, v3

    sub-long v31, v31, v35

    shr-long v35, v33, v3

    const-wide/16 v37, 0x0

    add-long v37, v35, v37

    shl-long v35, v35, v3

    sub-long v33, v33, v35

    mul-long v57, v57, v37

    add-long v1, v1, v57

    mul-long v59, v59, v37

    add-long v6, v6, v59

    mul-long v61, v61, v37

    add-long v9, v9, v61

    mul-long v63, v63, v37

    sub-long v12, v12, v63

    mul-long v65, v65, v37

    add-long v15, v15, v65

    mul-long v37, v37, v67

    sub-long v18, v18, v37

    const/16 v3, 0x15

    shr-long v35, v1, v3

    add-long v6, v6, v35

    shl-long v35, v35, v3

    sub-long v1, v1, v35

    shr-long v35, v6, v3

    add-long v9, v9, v35

    shl-long v35, v35, v3

    sub-long v6, v6, v35

    shr-long v35, v9, v3

    add-long v12, v12, v35

    shl-long v35, v35, v3

    sub-long v9, v9, v35

    shr-long v35, v12, v3

    add-long v15, v15, v35

    shl-long v35, v35, v3

    sub-long v12, v12, v35

    shr-long v35, v15, v3

    add-long v18, v18, v35

    shl-long v35, v35, v3

    sub-long v15, v15, v35

    shr-long v35, v18, v3

    add-long v21, v21, v35

    shl-long v35, v35, v3

    sub-long v18, v18, v35

    shr-long v35, v21, v3

    add-long v24, v24, v35

    shl-long v35, v35, v3

    sub-long v21, v21, v35

    shr-long v35, v24, v3

    add-long v27, v27, v35

    shl-long v35, v35, v3

    sub-long v24, v24, v35

    shr-long v35, v27, v3

    add-long v29, v29, v35

    shl-long v35, v35, v3

    move-wide/from16 v37, v12

    sub-long v11, v27, v35

    shr-long v13, v29, v3

    add-long v31, v31, v13

    shl-long/2addr v13, v3

    sub-long v29, v29, v13

    shr-long v13, v31, v3

    add-long v33, v33, v13

    shl-long/2addr v13, v3

    sub-long v31, v31, v13

    long-to-int v3, v1

    int-to-byte v3, v3

    const/4 v13, 0x0

    .line 1117
    aput-byte v3, v0, v13

    const/16 v3, 0x8

    shr-long v13, v1, v3

    long-to-int v13, v13

    int-to-byte v13, v13

    .line 1118
    aput-byte v13, v0, v20

    const/16 v13, 0x10

    shr-long/2addr v1, v13

    shl-long v27, v6, v8

    or-long v1, v1, v27

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1119
    aput-byte v1, v0, v5

    shr-long v1, v6, v26

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1120
    aput-byte v1, v0, v26

    const/16 v1, 0xb

    shr-long v1, v6, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1121
    aput-byte v1, v0, v17

    const/16 v1, 0x13

    shr-long v1, v6, v1

    shl-long v6, v9, v5

    or-long/2addr v1, v6

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1122
    aput-byte v1, v0, v8

    shr-long v1, v9, v23

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1123
    aput-byte v1, v0, v23

    const/16 v1, 0xe

    shr-long v1, v9, v1

    const/4 v4, 0x7

    shl-long v6, v37, v4

    or-long/2addr v1, v6

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1124
    aput-byte v1, v0, v4

    shr-long v1, v37, v20

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1125
    aput-byte v1, v0, v3

    const/16 v1, 0x9

    shr-long v1, v37, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x9

    .line 1126
    aput-byte v1, v0, v2

    const/16 v1, 0x11

    shr-long v1, v37, v1

    shl-long v6, v15, v17

    or-long/2addr v1, v6

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0xa

    .line 1127
    aput-byte v1, v0, v2

    shr-long v1, v15, v17

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0xb

    .line 1128
    aput-byte v1, v0, v2

    const/16 v1, 0xc

    shr-long v1, v15, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0xc

    .line 1129
    aput-byte v1, v0, v2

    const/16 v1, 0x14

    shr-long v1, v15, v1

    shl-long v6, v18, v20

    or-long/2addr v1, v6

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0xd

    .line 1130
    aput-byte v1, v0, v2

    const/4 v1, 0x7

    shr-long v6, v18, v1

    long-to-int v1, v6

    int-to-byte v1, v1

    const/16 v2, 0xe

    .line 1131
    aput-byte v1, v0, v2

    const/16 v1, 0xf

    shr-long v6, v18, v1

    shl-long v9, v21, v23

    or-long/2addr v6, v9

    long-to-int v2, v6

    int-to-byte v2, v2

    .line 1132
    aput-byte v2, v0, v1

    shr-long v1, v21, v5

    long-to-int v1, v1

    int-to-byte v1, v1

    .line 1133
    aput-byte v1, v0, v13

    const/16 v1, 0xa

    shr-long v1, v21, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x11

    .line 1134
    aput-byte v1, v0, v2

    const/16 v1, 0x12

    shr-long v6, v21, v1

    shl-long v9, v24, v26

    or-long/2addr v6, v9

    long-to-int v2, v6

    int-to-byte v2, v2

    .line 1135
    aput-byte v2, v0, v1

    shr-long v1, v24, v8

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x13

    .line 1136
    aput-byte v1, v0, v2

    const/16 v1, 0xd

    shr-long v1, v24, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x14

    .line 1137
    aput-byte v1, v0, v2

    long-to-int v1, v11

    int-to-byte v1, v1

    const/16 v2, 0x15

    .line 1138
    aput-byte v1, v0, v2

    shr-long v1, v11, v3

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x16

    .line 1139
    aput-byte v1, v0, v2

    shr-long v1, v11, v13

    shl-long v6, v29, v8

    or-long/2addr v1, v6

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x17

    .line 1140
    aput-byte v1, v0, v2

    shr-long v1, v29, v26

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x18

    .line 1141
    aput-byte v1, v0, v2

    const/16 v1, 0xb

    shr-long v1, v29, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x19

    .line 1142
    aput-byte v1, v0, v2

    const/16 v1, 0x13

    shr-long v1, v29, v1

    shl-long v5, v31, v5

    or-long/2addr v1, v5

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1a

    .line 1143
    aput-byte v1, v0, v2

    shr-long v1, v31, v23

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1b

    .line 1144
    aput-byte v1, v0, v2

    const/16 v1, 0xe

    shr-long v1, v31, v1

    const/4 v3, 0x7

    shl-long v3, v33, v3

    or-long/2addr v1, v3

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1c

    .line 1145
    aput-byte v1, v0, v2

    shr-long v1, v33, v20

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1d

    .line 1146
    aput-byte v1, v0, v2

    const/16 v1, 0x9

    shr-long v1, v33, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1e

    .line 1147
    aput-byte v1, v0, v2

    const/16 v1, 0x11

    shr-long v1, v33, v1

    long-to-int v1, v1

    int-to-byte v1, v1

    const/16 v2, 0x1f

    .line 1148
    aput-byte v1, v0, v2

    return-void
.end method

.method private static scalarMultWithBase([B)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;
    .locals 8
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "a"
        }
    .end annotation

    const/16 v0, 0x40

    new-array v1, v0, [B

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    const/16 v4, 0x20

    const/4 v5, 0x1

    if-ge v3, v4, :cond_0

    mul-int/lit8 v4, v3, 0x2

    add-int/lit8 v6, v4, 0x0

    .line 577
    aget-byte v7, p0, v3

    and-int/lit16 v7, v7, 0xff

    shr-int/2addr v7, v2

    and-int/lit8 v7, v7, 0xf

    int-to-byte v7, v7

    aput-byte v7, v1, v6

    add-int/2addr v4, v5

    .line 578
    aget-byte v5, p0, v3

    and-int/lit16 v5, v5, 0xff

    shr-int/lit8 v5, v5, 0x4

    and-int/lit8 v5, v5, 0xf

    int-to-byte v5, v5

    aput-byte v5, v1, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    move p0, v2

    move v3, p0

    :goto_1
    const/16 v4, 0x3f

    if-ge p0, v4, :cond_1

    .line 588
    aget-byte v4, v1, p0

    add-int/2addr v4, v3

    int-to-byte v3, v4

    aput-byte v3, v1, p0

    .line 589
    aget-byte v3, v1, p0

    add-int/lit8 v3, v3, 0x8

    shr-int/lit8 v3, v3, 0x4

    .line 591
    aget-byte v4, v1, p0

    shl-int/lit8 v6, v3, 0x4

    sub-int/2addr v4, v6

    int-to-byte v4, v4

    aput-byte v4, v1, p0

    add-int/lit8 p0, p0, 0x1

    goto :goto_1

    .line 593
    :cond_1
    aget-byte p0, v1, v4

    add-int/2addr p0, v3

    int-to-byte p0, p0

    aput-byte p0, v1, v4

    .line 595
    new-instance p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    sget-object v3, Lcom/google/crypto/tink/subtle/Ed25519;->NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;

    invoke-direct {p0, v3}, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    .line 596
    new-instance v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    invoke-direct {v3}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;-><init>()V

    :goto_2
    if-ge v5, v0, :cond_2

    .line 602
    new-instance v4, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    sget-object v6, Lcom/google/crypto/tink/subtle/Ed25519;->CACHED_NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    invoke-direct {v4, v6}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    .line 603
    div-int/lit8 v6, v5, 0x2

    aget-byte v7, v1, v5

    invoke-static {v4, v6, v7}, Lcom/google/crypto/tink/subtle/Ed25519;->select(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;IB)V

    .line 604
    invoke-static {v3, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v6

    invoke-static {p0, v6, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    add-int/lit8 v5, v5, 0x2

    goto :goto_2

    .line 609
    :cond_2
    new-instance v4, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    invoke-direct {v4}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;-><init>()V

    .line 610
    invoke-static {v4, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->fromPartialXYZT(Lcom/google/crypto/tink/subtle/Ed25519$XYZ;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object v5

    invoke-static {p0, v5}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    .line 611
    invoke-static {v4, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->fromPartialXYZT(Lcom/google/crypto/tink/subtle/Ed25519$XYZ;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object v5

    invoke-static {p0, v5}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    .line 612
    invoke-static {v4, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->fromPartialXYZT(Lcom/google/crypto/tink/subtle/Ed25519$XYZ;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object v5

    invoke-static {p0, v5}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    .line 613
    invoke-static {v4, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->fromPartialXYZT(Lcom/google/crypto/tink/subtle/Ed25519$XYZ;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object v4

    invoke-static {p0, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleXYZ(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZ;)V

    :goto_3
    if-ge v2, v0, :cond_3

    .line 617
    new-instance v4, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    sget-object v5, Lcom/google/crypto/tink/subtle/Ed25519;->CACHED_NEUTRAL:Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    invoke-direct {v4, v5}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    .line 618
    div-int/lit8 v5, v2, 0x2

    aget-byte v6, v1, v2

    invoke-static {v4, v5, v6}, Lcom/google/crypto/tink/subtle/Ed25519;->select(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;IB)V

    .line 619
    invoke-static {v3, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$400(Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object v5

    invoke-static {p0, v5, v4}, Lcom/google/crypto/tink/subtle/Ed25519;->add(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V

    add-int/lit8 v2, v2, 0x2

    goto :goto_3

    .line 624
    :cond_3
    new-instance v0, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    invoke-direct {v0, p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;-><init>(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;)V

    .line 625
    invoke-virtual {v0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->isOnCurve()Z

    move-result p0

    if-eqz p0, :cond_4

    return-object v0

    .line 626
    :cond_4
    new-instance p0, Ljava/lang/IllegalStateException;

    const-string v0, "arithmetic error in scalar multiplication"

    invoke-direct {p0, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method static scalarMultWithBaseToBytes([B)[B
    .locals 0
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "a"
        }
    .end annotation

    .line 640
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->scalarMultWithBase([B)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object p0

    invoke-virtual {p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->toBytes()[B

    move-result-object p0

    return-object p0
.end method

.method private static select(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;IB)V
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "t",
            "pos",
            "b"
        }
    .end annotation

    and-int/lit16 v0, p2, 0xff

    const/4 v1, 0x7

    shr-int/2addr v0, v1

    neg-int v2, v0

    and-int/2addr v2, p2

    const/4 v3, 0x1

    shl-int/2addr v2, v3

    sub-int/2addr p2, v2

    .line 547
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    const/4 v4, 0x0

    aget-object v2, v2, v4

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 548
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    const/4 v3, 0x2

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 549
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    const/4 v3, 0x3

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 550
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    const/4 v3, 0x4

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 551
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    const/4 v3, 0x5

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 552
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    const/4 v3, 0x6

    invoke-static {p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v4

    invoke-virtual {p0, v2, v4}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 553
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object v2, v2, p1

    aget-object v2, v2, v3

    invoke-static {p2, v1}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result v3

    invoke-virtual {p0, v2, v3}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 554
    sget-object v2, Lcom/google/crypto/tink/subtle/Ed25519Constants;->B_TABLE:[[Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    aget-object p1, v2, p1

    aget-object p1, p1, v1

    const/16 v1, 0x8

    invoke-static {p2, v1}, Lcom/google/crypto/tink/subtle/Ed25519;->eq(II)I

    move-result p2

    invoke-virtual {p0, p1, p2}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    .line 556
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yMinusX:[J

    const/16 p2, 0xa

    invoke-static {p1, p2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object p1

    .line 557
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yPlusX:[J

    invoke-static {v1, p2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v1

    .line 558
    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->t2d:[J

    invoke-static {v2, p2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object p2

    .line 559
    invoke-static {p2, p2}, Lcom/google/crypto/tink/subtle/Ed25519;->neg([J[J)V

    .line 560
    new-instance v2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;

    invoke-direct {v2, p1, v1, p2}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;-><init>([J[J[J)V

    .line 561
    invoke-virtual {p0, v2, v0}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->copyConditional(Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;I)V

    return-void
.end method

.method static sign([B[B[B)[B
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10,
            0x10
        }
        names = {
            "message",
            "publicKey",
            "hashedPrivateKey"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 1532
    array-length v0, p0

    const/4 v1, 0x0

    invoke-static {p0, v1, v0}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object p0

    .line 1533
    sget-object v0, Lcom/google/crypto/tink/subtle/EngineFactory;->MESSAGE_DIGEST:Lcom/google/crypto/tink/subtle/EngineFactory;

    const-string v2, "SHA-512"

    invoke-virtual {v0, v2}, Lcom/google/crypto/tink/subtle/EngineFactory;->getInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/security/MessageDigest;

    const/16 v2, 0x20

    .line 1534
    invoke-virtual {v0, p2, v2, v2}, Ljava/security/MessageDigest;->update([BII)V

    .line 1535
    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 1536
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    .line 1537
    invoke-static {v3}, Lcom/google/crypto/tink/subtle/Ed25519;->reduce([B)V

    .line 1539
    invoke-static {v3}, Lcom/google/crypto/tink/subtle/Ed25519;->scalarMultWithBase([B)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->toBytes()[B

    move-result-object v4

    invoke-static {v4, v1, v2}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v4

    .line 1540
    invoke-virtual {v0}, Ljava/security/MessageDigest;->reset()V

    .line 1541
    invoke-virtual {v0, v4}, Ljava/security/MessageDigest;->update([B)V

    .line 1542
    invoke-virtual {v0, p1}, Ljava/security/MessageDigest;->update([B)V

    .line 1543
    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 1544
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0

    .line 1545
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->reduce([B)V

    new-array p1, v2, [B

    .line 1547
    invoke-static {p1, p0, p2, v3}, Lcom/google/crypto/tink/subtle/Ed25519;->mulAdd([B[B[B[B)V

    const/4 p0, 0x2

    new-array p0, p0, [[B

    aput-object v4, p0, v1

    const/4 p2, 0x1

    aput-object p1, p0, p2

    .line 1548
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Bytes;->concat([[B)[B

    move-result-object p0

    return-object p0
.end method

.method private static slide([B)[B
    .locals 8
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0
        }
        names = {
            "a"
        }
    .end annotation

    const/16 v0, 0x100

    new-array v1, v0, [B

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    const/4 v4, 0x1

    if-ge v3, v0, :cond_0

    shr-int/lit8 v5, v3, 0x3

    .line 650
    aget-byte v5, p0, v5

    and-int/lit16 v5, v5, 0xff

    and-int/lit8 v6, v3, 0x7

    shr-int/2addr v5, v6

    and-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v1, v3

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_0
    move p0, v2

    :goto_1
    if-ge p0, v0, :cond_5

    .line 655
    aget-byte v3, v1, p0

    if-eqz v3, :cond_4

    move v3, v4

    :goto_2
    const/4 v5, 0x6

    if-gt v3, v5, :cond_4

    add-int v5, p0, v3

    if-ge v5, v0, :cond_4

    .line 657
    aget-byte v6, v1, v5

    if-eqz v6, :cond_3

    .line 658
    aget-byte v6, v1, p0

    aget-byte v7, v1, v5

    shl-int/2addr v7, v3

    add-int/2addr v6, v7

    const/16 v7, 0xf

    if-gt v6, v7, :cond_1

    .line 659
    aget-byte v6, v1, p0

    aget-byte v7, v1, v5

    shl-int/2addr v7, v3

    add-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, v1, p0

    .line 660
    aput-byte v2, v1, v5

    goto :goto_4

    .line 661
    :cond_1
    aget-byte v6, v1, p0

    aget-byte v7, v1, v5

    shl-int/2addr v7, v3

    sub-int/2addr v6, v7

    const/16 v7, -0xf

    if-lt v6, v7, :cond_4

    .line 662
    aget-byte v6, v1, p0

    aget-byte v7, v1, v5

    shl-int/2addr v7, v3

    sub-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, v1, p0

    :goto_3
    if-ge v5, v0, :cond_3

    .line 664
    aget-byte v6, v1, v5

    if-nez v6, :cond_2

    .line 665
    aput-byte v4, v1, v5

    goto :goto_4

    .line 668
    :cond_2
    aput-byte v2, v1, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    :cond_3
    :goto_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :cond_4
    add-int/lit8 p0, p0, 0x1

    goto :goto_1

    :cond_5
    return-object v1
.end method

.method private static sub(Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;Lcom/google/crypto/tink/subtle/Ed25519$XYZT;Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;)V
    .locals 4
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x0,
            0x0,
            0x0
        }
        names = {
            "partialXYZT",
            "extended",
            "cached"
        }
    .end annotation

    const/16 v0, 0xa

    new-array v0, v0, [J

    .line 432
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v3, v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 435
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v3, v3, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 438
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yPlusX:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 441
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v2, v2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->yMinusX:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 444
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object v2, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->t:[J

    iget-object v3, p2, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->t2d:[J

    invoke-static {v1, v2, v3}, Lcom/google/crypto/tink/subtle/Field25519;->mult([J[J[J)V

    .line 447
    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    invoke-virtual {p2, v1, p1}, Lcom/google/crypto/tink/subtle/Ed25519$CachedXYT;->multByZ([J[J)V

    .line 450
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    invoke-static {v0, p1, p2}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 453
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->x:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {p1, p2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 456
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p2, p2, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object v1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object v1, v1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->y:[J

    invoke-static {p1, p2, v1}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    .line 459
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->xyz:Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    iget-object p1, p1, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->z:[J

    iget-object p2, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    invoke-static {p1, v0, p2}, Lcom/google/crypto/tink/subtle/Field25519;->sub([J[J[J)V

    .line 462
    iget-object p1, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    iget-object p0, p0, Lcom/google/crypto/tink/subtle/Ed25519$PartialXYZT;->t:[J

    invoke-static {p1, v0, p0}, Lcom/google/crypto/tink/subtle/Field25519;->sum([J[J[J)V

    return-void
.end method

.method static verify([B[B[B)Z
    .locals 5
    .annotation system Ldalvik/annotation/MethodParameters;
        accessFlags = {
            0x10,
            0x10,
            0x10
        }
        names = {
            "message",
            "signature",
            "publicKey"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/GeneralSecurityException;
        }
    .end annotation

    .line 1589
    array-length v0, p1

    const/16 v1, 0x40

    const/4 v2, 0x0

    if-eq v0, v1, :cond_0

    return v2

    :cond_0
    const/16 v0, 0x20

    .line 1592
    invoke-static {p1, v0, v1}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v1

    .line 1593
    invoke-static {v1}, Lcom/google/crypto/tink/subtle/Ed25519;->isSmallerThanGroupOrder([B)Z

    move-result v3

    if-nez v3, :cond_1

    return v2

    .line 1596
    :cond_1
    sget-object v3, Lcom/google/crypto/tink/subtle/EngineFactory;->MESSAGE_DIGEST:Lcom/google/crypto/tink/subtle/EngineFactory;

    const-string v4, "SHA-512"

    invoke-virtual {v3, v4}, Lcom/google/crypto/tink/subtle/EngineFactory;->getInstance(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/security/MessageDigest;

    .line 1597
    invoke-virtual {v3, p1, v2, v0}, Ljava/security/MessageDigest;->update([BII)V

    .line 1598
    invoke-virtual {v3, p2}, Ljava/security/MessageDigest;->update([B)V

    .line 1599
    invoke-virtual {v3, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 1600
    invoke-virtual {v3}, Ljava/security/MessageDigest;->digest()[B

    move-result-object p0

    .line 1601
    invoke-static {p0}, Lcom/google/crypto/tink/subtle/Ed25519;->reduce([B)V

    .line 1603
    invoke-static {p2}, Lcom/google/crypto/tink/subtle/Ed25519$XYZT;->access$500([B)Lcom/google/crypto/tink/subtle/Ed25519$XYZT;

    move-result-object p2

    .line 1604
    invoke-static {p0, p2, v1}, Lcom/google/crypto/tink/subtle/Ed25519;->doubleScalarMultVarTime([BLcom/google/crypto/tink/subtle/Ed25519$XYZT;[B)Lcom/google/crypto/tink/subtle/Ed25519$XYZ;

    move-result-object p0

    .line 1605
    invoke-virtual {p0}, Lcom/google/crypto/tink/subtle/Ed25519$XYZ;->toBytes()[B

    move-result-object p0

    move p2, v2

    :goto_0
    if-ge p2, v0, :cond_3

    .line 1607
    aget-byte v1, p0, p2

    aget-byte v3, p1, p2

    if-eq v1, v3, :cond_2

    return v2

    :cond_2
    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    :cond_3
    const/4 p0, 0x1

    return p0
.end method
