.class public final Lau/gov/health/covidsafe/streetpass/BlacklistEntry;
.super Ljava/lang/Object;
.source "BlacklistEntry.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u00a8\u0006\u0007"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/BlacklistEntry;",
        "",
        "uniqueIdentifier",
        "",
        "(Ljava/lang/String;)V",
        "getUniqueIdentifier",
        "()Ljava/lang/String;",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field private final uniqueIdentifier:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;->uniqueIdentifier:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public final getUniqueIdentifier()Ljava/lang/String;
    .locals 1

    .line 3
    iget-object v0, p0, Lau/gov/health/covidsafe/streetpass/BlacklistEntry;->uniqueIdentifier:Ljava/lang/String;

    return-object v0
.end method
