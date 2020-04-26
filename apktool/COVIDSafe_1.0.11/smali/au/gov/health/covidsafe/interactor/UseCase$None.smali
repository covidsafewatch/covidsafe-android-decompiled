.class public final Lau/gov/health/covidsafe/interactor/UseCase$None;
.super Ljava/lang/Object;
.source "UseCase.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/interactor/UseCase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "None"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/UseCase$None;",
        "",
        "()V",
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
.field public static final INSTANCE:Lau/gov/health/covidsafe/interactor/UseCase$None;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 74
    new-instance v0, Lau/gov/health/covidsafe/interactor/UseCase$None;

    invoke-direct {v0}, Lau/gov/health/covidsafe/interactor/UseCase$None;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/interactor/UseCase$None;->INSTANCE:Lau/gov/health/covidsafe/interactor/UseCase$None;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
