.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1;
.super Ljava/lang/Object;
.source "EnterNumberFragment.kt"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;-><init>()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterNumberFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterNumberFragment.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n3882#2:135\n3978#2,2:136\n37#3,2:138\n*E\n*S KotlinDebug\n*F\n+ 1 EnterNumberFragment.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1\n*L\n50#1:135\n50#1,2:136\n50#1,2:138\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\u000c\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1",
        "Landroid/text/TextWatcher;",
        "afterTextChanged",
        "",
        "s",
        "Landroid/text/Editable;",
        "beforeTextChanged",
        "",
        "start",
        "",
        "count",
        "after",
        "onTextChanged",
        "before",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 40
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 8

    .line 43
    sget-object v0, Lau/gov/health/covidsafe/TracerApp;->Companion:Lau/gov/health/covidsafe/TracerApp$Companion;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/TracerApp$Companion;->getAppContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 44
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    sget v2, Lau/gov/health/covidsafe/R$id;->enter_number_phone_number:I

    invoke-virtual {v1, v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    const-string v2, "enter_number_phone_number"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1}, Landroid/widget/EditText;->getFilters()[Landroid/text/InputFilter;

    move-result-object v1

    const/4 v3, 0x0

    if-eqz p1, :cond_0

    .line 45
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    if-eqz p1, :cond_0

    const/4 v4, 0x2

    const/4 v5, 0x0

    const-string v6, "0"

    invoke-static {p1, v6, v3, v4, v5}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result p1

    const/4 v4, 0x1

    if-ne p1, v4, :cond_0

    add-int/lit8 v0, v0, 0x1

    .line 50
    :cond_0
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    sget v4, Lau/gov/health/covidsafe/R$id;->enter_number_phone_number:I

    invoke-virtual {p1, v4}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/EditText;

    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "filters"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 135
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    check-cast v2, Ljava/util/Collection;

    .line 136
    array-length v4, v1

    move v5, v3

    :goto_0
    if-ge v5, v4, :cond_2

    aget-object v6, v1, v5

    .line 50
    instance-of v7, v6, Landroid/text/InputFilter$LengthFilter;

    if-nez v7, :cond_1

    invoke-interface {v2, v6}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 137
    :cond_2
    check-cast v2, Ljava/util/List;

    check-cast v2, Ljava/util/Collection;

    new-array v1, v3, [Landroid/text/InputFilter;

    .line 139
    invoke-interface {v2, v1}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 51
    new-instance v2, Landroid/text/InputFilter$LengthFilter;

    invoke-direct {v2, v0}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    .line 50
    invoke-static {v1, v2}, Lkotlin/collections/ArraysKt;->plus([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/InputFilter;

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 53
    iget-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    invoke-virtual {p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->updateButtonState()V

    return-void

    .line 139
    :cond_3
    new-instance p1, Lkotlin/TypeCastException;

    const-string v0, "null cannot be cast to non-null type kotlin.Array<T>"

    invoke-direct {p1, v0}, Lkotlin/TypeCastException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method
