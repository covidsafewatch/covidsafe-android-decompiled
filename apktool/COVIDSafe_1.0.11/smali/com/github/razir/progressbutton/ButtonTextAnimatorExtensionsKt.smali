.class public final Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;
.super Ljava/lang/Object;
.source "ButtonTextAnimatorExtensions.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nButtonTextAnimatorExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ButtonTextAnimatorExtensions.kt\ncom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,178:1\n1591#2,2:179\n*E\n*S KotlinDebug\n*F\n+ 1 ButtonTextAnimatorExtensions.kt\ncom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt\n*L\n157#1,2:179\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0008H\u0000\u001a%\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0019\u0008\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\u0008\r\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0008\u0010\n\u001a\u0004\u0018\u00010\u000c\u001a\u000c\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\u000c\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0002\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0002\u001a\u000c\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0002\u00a8\u0006\u0016"
    }
    d2 = {
        "addAnimator",
        "",
        "Landroid/widget/TextView;",
        "animator",
        "Landroid/animation/Animator;",
        "animateTextChange",
        "newText",
        "Landroid/text/SpannableString;",
        "",
        "attachTextChangeAnimator",
        "params",
        "Lkotlin/Function1;",
        "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
        "Lkotlin/ExtensionFunctionType;",
        "cancelAnimations",
        "cleaAnimator",
        "detachTextChangeAnimator",
        "getAnimateTextColor",
        "",
        "isAnimatorAttached",
        "",
        "resetColor",
        "progressbutton_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# direct methods
.method public static final synthetic access$addAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->addAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V

    return-void
.end method

.method public static final synthetic access$cleaAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->cleaAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V

    return-void
.end method

.method public static final synthetic access$resetColor(Landroid/widget/TextView;)V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->resetColor(Landroid/widget/TextView;)V

    return-void
.end method

.method private static final addAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V
    .locals 3

    .line 124
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 125
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/util/List;

    if-eqz p0, :cond_1

    .line 126
    invoke-interface {p0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 128
    :cond_0
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/animation/Animator;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {v1}, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    :goto_0
    return-void
.end method

.method public static final animateTextChange(Landroid/widget/TextView;Landroid/text/SpannableString;)V
    .locals 9

    const-string v0, "$this$animateTextChange"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 66
    invoke-static {p0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->cancelAnimations(Landroid/widget/TextView;)V

    .line 67
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_0
    const-string v1, "attachedViews[this]!!"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    .line 68
    invoke-static {p0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->getAnimateTextColor(Landroid/widget/TextView;)I

    move-result v1

    const/4 v2, 0x2

    new-array v3, v2, [I

    const/4 v4, 0x0

    .line 70
    invoke-static {v1, v4}, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(II)I

    move-result v5

    aput v5, v3, v4

    const/4 v5, 0x1

    aput v1, v3, v5

    const-string v6, "textColor"

    invoke-static {p0, v6, v3}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v3

    .line 72
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getFadeInMills()J

    move-result-wide v7

    invoke-virtual {v3, v7, v8}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 73
    new-instance v7, Landroid/animation/ArgbEvaluator;

    invoke-direct {v7}, Landroid/animation/ArgbEvaluator;-><init>()V

    check-cast v7, Landroid/animation/TypeEvaluator;

    invoke-virtual {v3, v7}, Landroid/animation/ObjectAnimator;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    .line 74
    new-instance v7, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1;

    invoke-direct {v7, p0, v0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$1;-><init>(Landroid/widget/TextView;Lcom/github/razir/progressbutton/TextChangeAnimatorParams;)V

    check-cast v7, Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v3, v7}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 92
    invoke-virtual {v3}, Landroid/animation/ObjectAnimator;->start()V

    new-array v2, v2, [I

    aput v1, v2, v4

    .line 95
    invoke-static {v1, v4}, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(II)I

    move-result v1

    aput v1, v2, v5

    invoke-static {p0, v6, v2}, Landroid/animation/ObjectAnimator;->ofInt(Ljava/lang/Object;Ljava/lang/String;[I)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 97
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getFadeOutMills()J

    move-result-wide v4

    invoke-virtual {v1, v4, v5}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 98
    new-instance v2, Landroid/animation/ArgbEvaluator;

    invoke-direct {v2}, Landroid/animation/ArgbEvaluator;-><init>()V

    check-cast v2, Landroid/animation/TypeEvaluator;

    invoke-virtual {v1, v2}, Landroid/animation/ObjectAnimator;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    .line 99
    new-instance v2, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;

    invoke-direct {v2, p0, v0, p1, v3}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;-><init>(Landroid/widget/TextView;Lcom/github/razir/progressbutton/TextChangeAnimatorParams;Landroid/text/SpannableString;Landroid/animation/ObjectAnimator;)V

    check-cast v2, Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v1, v2}, Landroid/animation/ObjectAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 120
    invoke-virtual {v1}, Landroid/animation/ObjectAnimator;->start()V

    return-void
.end method

.method public static final animateTextChange(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 1

    const-string v0, "$this$animateTextChange"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_0

    .line 62
    new-instance v0, Landroid/text/SpannableString;

    check-cast p1, Ljava/lang/CharSequence;

    invoke-direct {v0, p1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {p0, v0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->animateTextChange(Landroid/widget/TextView;Landroid/text/SpannableString;)V

    return-void
.end method

.method public static final attachTextChangeAnimator(Landroid/widget/TextView;Lcom/github/razir/progressbutton/TextChangeAnimatorParams;)V
    .locals 3

    const-string v0, "$this$attachTextChangeAnimator"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    if-eqz p1, :cond_0

    move-object v0, p1

    goto :goto_0

    .line 31
    :cond_0
    new-instance v0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    invoke-direct {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;-><init>()V

    .line 32
    :goto_0
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getUseCurrentTextColor()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 33
    invoke-virtual {p0}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->setTextColorList(Landroid/content/res/ColorStateList;)V

    goto :goto_1

    .line 35
    :cond_1
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColorRes()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 36
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColorRes()Ljava/lang/Integer;

    move-result-object v2

    if-nez v2, :cond_2

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_2
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v1, v2}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->setTextColor(I)V

    .line 39
    :cond_3
    :goto_1
    invoke-static {p0}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->addTextAnimationAttachViewListener(Landroid/widget/TextView;)V

    .line 40
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public static final attachTextChangeAnimator(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TextView;",
            "Lkotlin/jvm/functions/Function1<",
            "-",
            "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "$this$attachTextChangeAnimator"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "params"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 21
    new-instance v0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    invoke-direct {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;-><init>()V

    .line 22
    invoke-interface {p1, v0}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    invoke-static {p0, v0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->attachTextChangeAnimator(Landroid/widget/TextView;Lcom/github/razir/progressbutton/TextChangeAnimatorParams;)V

    return-void
.end method

.method public static synthetic attachTextChangeAnimator$default(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)V
    .locals 0

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    .line 20
    sget-object p1, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$attachTextChangeAnimator$1;->INSTANCE:Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$attachTextChangeAnimator$1;

    check-cast p1, Lkotlin/jvm/functions/Function1;

    :cond_0
    invoke-static {p0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->attachTextChangeAnimator(Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public static final cancelAnimations(Landroid/widget/TextView;)V
    .locals 2

    const-string v0, "$this$cancelAnimations"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 154
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 155
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_0
    const-string v1, "activeAnimations[this]!!"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/util/List;

    .line 156
    new-instance v1, Ljava/util/ArrayList;

    check-cast v0, Ljava/util/Collection;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 157
    check-cast v1, Ljava/lang/Iterable;

    .line 179
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/animation/Animator;

    .line 158
    invoke-virtual {v1}, Landroid/animation/Animator;->cancel()V

    goto :goto_0

    .line 160
    :cond_1
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-void
.end method

.method private static final cleaAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V
    .locals 2

    .line 133
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 134
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_0
    const-string v1, "activeAnimations[this]!!"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/util/List;

    .line 135
    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 136
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result p1

    if-eqz p1, :cond_1

    .line 137
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getActiveAnimations()Ljava/util/WeakHashMap;

    move-result-object p1

    invoke-virtual {p1, p0}, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-void
.end method

.method public static final detachTextChangeAnimator(Landroid/widget/TextView;)V
    .locals 1

    const-string v0, "$this$detachTextChangeAnimator"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 47
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    invoke-static {p0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->cancelAnimations(Landroid/widget/TextView;)V

    .line 49
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    invoke-static {p0}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->removeTextAnimationAttachViewListener(Landroid/widget/TextView;)V

    :cond_0
    return-void
.end method

.method private static final getAnimateTextColor(Landroid/widget/TextView;)I
    .locals 2

    .line 165
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_0
    const-string v1, "attachedViews[this]!!"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    .line 167
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColorList()Landroid/content/res/ColorStateList;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 168
    invoke-virtual {p0}, Landroid/widget/TextView;->getDrawableState()[I

    move-result-object p0

    .line 169
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColorList()Landroid/content/res/ColorStateList;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_1
    const/high16 v1, -0x1000000

    invoke-virtual {v0, p0, v1}, Landroid/content/res/ColorStateList;->getColorForState([II)I

    move-result p0

    goto :goto_0

    .line 172
    :cond_2
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColor()I

    move-result p0

    :goto_0
    return p0
.end method

.method public static final isAnimatorAttached(Landroid/widget/TextView;)Z
    .locals 1

    const-string v0, "$this$isAnimatorAttached"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 58
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method

.method private static final resetColor(Landroid/widget/TextView;)V
    .locals 2

    .line 143
    invoke-static {p0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->isAnimatorAttached(Landroid/widget/TextView;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 144
    invoke-static {}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->getAttachedViews()Ljava/util/WeakHashMap;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Lkotlin/jvm/internal/Intrinsics;->throwNpe()V

    :cond_0
    const-string v1, "attachedViews[this]!!"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    .line 145
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColorList()Landroid/content/res/ColorStateList;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 146
    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    goto :goto_0

    .line 148
    :cond_1
    invoke-virtual {v0}, Lcom/github/razir/progressbutton/TextChangeAnimatorParams;->getTextColor()I

    move-result v0

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setTextColor(I)V

    :cond_2
    :goto_0
    return-void
.end method
