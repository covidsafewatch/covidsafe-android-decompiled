.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;
.super Ljava/lang/Object;
.source "EnterPinFragmentArgs.kt"

# interfaces
.implements Landroidx/navigation/NavArgs;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J+\u0010\u000e\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008\u00a8\u0006\u0019"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;",
        "Landroidx/navigation/NavArgs;",
        "session",
        "",
        "challengeName",
        "phoneNumber",
        "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
        "getChallengeName",
        "()Ljava/lang/String;",
        "getPhoneNumber",
        "getSession",
        "component1",
        "component2",
        "component3",
        "copy",
        "equals",
        "",
        "other",
        "",
        "hashCode",
        "",
        "toBundle",
        "Landroid/os/Bundle;",
        "toString",
        "Companion",
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
.field public static final Companion:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;


# instance fields
.field private final challengeName:Ljava/lang/String;

.field private final phoneNumber:Ljava/lang/String;

.field private final session:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->Companion:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    const-string v0, "phoneNumber"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    iput-object p3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    return-void
.end method

.method public static synthetic copy$default(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;
    .locals 0

    and-int/lit8 p5, p4, 0x1

    if-eqz p5, :cond_0

    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    :cond_0
    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_1

    iget-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    :cond_1
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_2

    iget-object p3, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    :cond_2
    invoke-virtual {p0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;

    move-result-object p0

    return-object p0
.end method

.method public static final fromBundle(Landroid/os/Bundle;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;
    .locals 1
    .annotation runtime Lkotlin/jvm/JvmStatic;
    .end annotation

    sget-object v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->Companion:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;

    invoke-virtual {v0, p0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs$Companion;->fromBundle(Landroid/os/Bundle;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;

    move-result-object p0

    return-object p0
.end method


# virtual methods
.method public final component1()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    return-object v0
.end method

.method public final component2()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    return-object v0
.end method

.method public final component3()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public final copy(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;
    .locals 1

    const-string v0, "phoneNumber"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;

    invoke-direct {v0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2

    if-eq p0, p1, :cond_1

    instance-of v0, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;

    if-eqz v0, :cond_0

    check-cast p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    iget-object v1, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    iget-object p1, p1, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    return p1

    :cond_1
    :goto_0
    const/4 p1, 0x1

    return p1
.end method

.method public final getChallengeName()Ljava/lang/String;
    .locals 1

    .line 11
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    return-object v0
.end method

.method public final getPhoneNumber()Ljava/lang/String;
    .locals 1

    .line 12
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    return-object v0
.end method

.method public final getSession()Ljava/lang/String;
    .locals 1

    .line 10
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_1

    :cond_1
    move v2, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_2
    add-int/2addr v0, v1

    return v0
.end method

.method public final toBundle()Landroid/os/Bundle;
    .locals 3

    .line 15
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 16
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    const-string v2, "session"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    const-string v2, "challengeName"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    const-string v2, "phoneNumber"

    invoke-virtual {v0, v2, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "EnterPinFragmentArgs(session="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->session:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", challengeName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->challengeName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", phoneNumber="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragmentArgs;->phoneNumber:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
