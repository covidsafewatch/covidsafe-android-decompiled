.class public final Landroidx/navigation/NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1;
.super Lkotlin/jvm/internal/LocalVariableReference;
.source "NavGraphViewModelLazy.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0xf
    }
.end annotation


# static fields
.field public static final INSTANCE:Lkotlin/reflect/KProperty0;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Landroidx/navigation/NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1;

    invoke-direct {v0}, Landroidx/navigation/NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1;-><init>()V

    sput-object v0, Landroidx/navigation/NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$1;->INSTANCE:Lkotlin/reflect/KProperty0;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lkotlin/jvm/internal/LocalVariableReference;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    const-string v0, "backStackEntry"

    return-object v0
.end method

.method public getOwner()Lkotlin/reflect/KDeclarationContainer;
    .locals 2

    const-class v0, Landroidx/navigation/NavGraphViewModelLazyKt;

    const-string v1, "navigation-fragment-ktx_release"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinPackage(Ljava/lang/Class;Ljava/lang/String;)Lkotlin/reflect/KDeclarationContainer;

    move-result-object v0

    return-object v0
.end method

.method public getSignature()Ljava/lang/String;
    .locals 1

    const-string v0, "<v#0>"

    return-object v0
.end method
