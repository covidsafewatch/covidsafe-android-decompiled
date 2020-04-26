.class public final Lau/gov/health/covidsafe/streetpass/Work$Check;
.super Ljava/lang/Object;
.source "Work.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/streetpass/Work;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Check"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e\u00a8\u0006\u000f"
    }
    d2 = {
        "Lau/gov/health/covidsafe/streetpass/Work$Check;",
        "",
        "(Lau/gov/health/covidsafe/streetpass/Work;)V",
        "status",
        "",
        "getStatus",
        "()Z",
        "setStatus",
        "(Z)V",
        "timePerformed",
        "",
        "getTimePerformed",
        "()J",
        "setTimePerformed",
        "(J)V",
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
.field private status:Z

.field final synthetic this$0:Lau/gov/health/covidsafe/streetpass/Work;

.field private timePerformed:J


# direct methods
.method public constructor <init>(Lau/gov/health/covidsafe/streetpass/Work;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 63
    iput-object p1, p0, Lau/gov/health/covidsafe/streetpass/Work$Check;->this$0:Lau/gov/health/covidsafe/streetpass/Work;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final getStatus()Z
    .locals 1

    .line 64
    iget-boolean v0, p0, Lau/gov/health/covidsafe/streetpass/Work$Check;->status:Z

    return v0
.end method

.method public final getTimePerformed()J
    .locals 2

    .line 65
    iget-wide v0, p0, Lau/gov/health/covidsafe/streetpass/Work$Check;->timePerformed:J

    return-wide v0
.end method

.method public final setStatus(Z)V
    .locals 0

    .line 64
    iput-boolean p1, p0, Lau/gov/health/covidsafe/streetpass/Work$Check;->status:Z

    return-void
.end method

.method public final setTimePerformed(J)V
    .locals 0

    .line 65
    iput-wide p1, p0, Lau/gov/health/covidsafe/streetpass/Work$Check;->timePerformed:J

    return-void
.end method
