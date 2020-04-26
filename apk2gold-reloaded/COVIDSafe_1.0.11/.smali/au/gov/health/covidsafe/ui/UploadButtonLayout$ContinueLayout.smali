.class public final Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;
.super Lau/gov/health/covidsafe/ui/UploadButtonLayout;
.source "PagerChildFragment.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/ui/UploadButtonLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ContinueLayout"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u00a8\u0006\u000c"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;",
        "Lau/gov/health/covidsafe/ui/UploadButtonLayout;",
        "buttonText",
        "",
        "buttonListener",
        "Lkotlin/Function0;",
        "",
        "(ILkotlin/jvm/functions/Function0;)V",
        "getButtonListener",
        "()Lkotlin/jvm/functions/Function0;",
        "getButtonText",
        "()I",
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
.field private final buttonListener:Lkotlin/jvm/functions/Function0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field

.field private final buttonText:I


# direct methods
.method public constructor <init>(ILkotlin/jvm/functions/Function0;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 60
    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/ui/UploadButtonLayout;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    iput p1, p0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->buttonText:I

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->buttonListener:Lkotlin/jvm/functions/Function0;

    return-void
.end method


# virtual methods
.method public final getButtonListener()Lkotlin/jvm/functions/Function0;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    .line 60
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->buttonListener:Lkotlin/jvm/functions/Function0;

    return-object v0
.end method

.method public final getButtonText()I
    .locals 1

    .line 60
    iget v0, p0, Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;->buttonText:I

    return v0
.end method
