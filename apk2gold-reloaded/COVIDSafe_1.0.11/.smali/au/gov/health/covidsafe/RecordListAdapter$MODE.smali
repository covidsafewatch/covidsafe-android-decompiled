.class public final enum Lau/gov/health/covidsafe/RecordListAdapter$MODE;
.super Ljava/lang/Enum;
.source "RecordListAdapter.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/RecordListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum<",
        "Lau/gov/health/covidsafe/RecordListAdapter$MODE;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006\u00a8\u0006\u0007"
    }
    d2 = {
        "Lau/gov/health/covidsafe/RecordListAdapter$MODE;",
        "",
        "(Ljava/lang/String;I)V",
        "ALL",
        "COLLAPSE",
        "MODEL_P",
        "MODEL_C",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lau/gov/health/covidsafe/RecordListAdapter$MODE;

.field public static final enum ALL:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

.field public static final enum COLLAPSE:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

.field public static final enum MODEL_C:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

.field public static final enum MODEL_P:Lau/gov/health/covidsafe/RecordListAdapter$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    const/4 v0, 0x4

    new-array v0, v0, [Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    new-instance v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    const/4 v2, 0x0

    const-string v3, "ALL"

    invoke-direct {v1, v3, v2}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->ALL:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    const/4 v2, 0x1

    const-string v3, "COLLAPSE"

    invoke-direct {v1, v3, v2}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->COLLAPSE:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    const/4 v2, 0x2

    const-string v3, "MODEL_P"

    invoke-direct {v1, v3, v2}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->MODEL_P:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    aput-object v1, v0, v2

    new-instance v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    const/4 v2, 0x3

    const-string v3, "MODEL_C"

    invoke-direct {v1, v3, v2}, Lau/gov/health/covidsafe/RecordListAdapter$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v1, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->MODEL_C:Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    aput-object v1, v0, v2

    sput-object v0, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->$VALUES:[Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 19
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lau/gov/health/covidsafe/RecordListAdapter$MODE;
    .locals 1

    const-class v0, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object p0

    check-cast p0, Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    return-object p0
.end method

.method public static values()[Lau/gov/health/covidsafe/RecordListAdapter$MODE;
    .locals 1

    sget-object v0, Lau/gov/health/covidsafe/RecordListAdapter$MODE;->$VALUES:[Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    invoke-virtual {v0}, [Lau/gov/health/covidsafe/RecordListAdapter$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lau/gov/health/covidsafe/RecordListAdapter$MODE;

    return-object v0
.end method
