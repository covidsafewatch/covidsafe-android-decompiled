.class public final Lcom/github/razir/progressbutton/ProgressButtonHolderKt;
.super Ljava/lang/Object;
.source "ProgressButtonHolder.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nProgressButtonHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProgressButtonHolder.kt\ncom/github/razir/progressbutton/ProgressButtonHolderKt\n*L\n1#1,103:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005*\u0002\u000e\u0011\u001a\u000c\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0000\u001a\u000c\u0010\u0015\u001a\u00020\u0014*\u00020\u0002H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002\u001a\n\u0010\u0019\u001a\u00020\u0014*\u00020\u0002\u001a\u000c\u0010\u001a\u001a\u00020\u0014*\u00020\u0002H\u0002\u001a\u000c\u0010\u001b\u001a\u00020\u0014*\u00020\u0002H\u0000\"&\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0080\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\" \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u0001X\u0080\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0006\" \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0001X\u0080\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006\"\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000f\"\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0012\u00a8\u0006\u001c"
    }
    d2 = {
        "activeAnimations",
        "Ljava/util/WeakHashMap;",
        "Landroid/widget/TextView;",
        "",
        "Landroid/animation/Animator;",
        "getActiveAnimations",
        "()Ljava/util/WeakHashMap;",
        "activeViews",
        "Lcom/github/razir/progressbutton/DrawableViewData;",
        "getActiveViews",
        "attachedViews",
        "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
        "getAttachedViews",
        "drawablesAttachListener",
        "com/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1",
        "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;",
        "textAnimationsAttachListener",
        "com/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1",
        "Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;",
        "addDrawableAttachViewListener",
        "",
        "addTextAnimationAttachViewListener",
        "bindProgressButton",
        "Landroidx/lifecycle/LifecycleOwner;",
        "button",
        "cleanUpDrawable",
        "removeDrawableAttachViewListener",
        "removeTextAnimationAttachViewListener",
        "progressbutton_release"
    }
    k = 0x2
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field private static final activeAnimations:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Ljava/util/List<",
            "Landroid/animation/Animator;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final activeViews:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Lcom/github/razir/progressbutton/DrawableViewData;",
            ">;"
        }
    .end annotation
.end field

.field private static final attachedViews:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
            ">;"
        }
    .end annotation
.end field

.field private static final drawablesAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;

.field private static final textAnimationsAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 13
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->attachedViews:Ljava/util/WeakHashMap;

    .line 14
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeAnimations:Ljava/util/WeakHashMap;

    .line 15
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    sput-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeViews:Ljava/util/WeakHashMap;

    .line 71
    new-instance v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;

    invoke-direct {v0}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;-><init>()V

    sput-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->textAnimationsAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;

    .line 82
    new-instance v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;

    invoke-direct {v0}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;-><init>()V

    sput-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->drawablesAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;

    return-void
.end method

.method public static final synthetic access$removeDrawableAttachViewListener(Landroid/widget/TextView;)V
    .locals 0

    .line 1
    invoke-static {p0}, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->removeDrawableAttachViewListener(Landroid/widget/TextView;)V

    return-void
.end method

.method public static final addDrawableAttachViewListener(Landroid/widget/TextView;)V
    .locals 1

    const-string v0, "$this$addDrawableAttachViewListener"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 64
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->drawablesAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;

    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    return-void
.end method

.method public static final addTextAnimationAttachViewListener(Landroid/widget/TextView;)V
    .locals 1

    const-string v0, "$this$addTextAnimationAttachViewListener"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 56
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->textAnimationsAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;

    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    return-void
.end method

.method public static final bindProgressButton(Landroidx/lifecycle/LifecycleOwner;Landroid/widget/TextView;)V
    .locals 2

    const-string v0, "$this$bindProgressButton"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "button"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 24
    invoke-interface {p0}, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;

    move-result-object p0

    new-instance v0, Lcom/github/razir/progressbutton/ProgressButtonHolder;

    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-direct {v0, v1}, Lcom/github/razir/progressbutton/ProgressButtonHolder;-><init>(Ljava/lang/ref/WeakReference;)V

    check-cast v0, Landroidx/lifecycle/LifecycleObserver;

    invoke-virtual {p0, v0}, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V

    return-void
.end method

.method public static final cleanUpDrawable(Landroid/widget/TextView;)V
    .locals 2

    const-string v0, "$this$cleanUpDrawable"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeViews:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 29
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeViews:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/github/razir/progressbutton/DrawableViewData;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/github/razir/progressbutton/DrawableViewData;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 30
    instance-of v1, v0, Landroid/graphics/drawable/Animatable;

    if-eqz v1, :cond_0

    .line 31
    move-object v1, v0

    check-cast v1, Landroid/graphics/drawable/Animatable;

    invoke-interface {v1}, Landroid/graphics/drawable/Animatable;->stop()V

    :cond_0
    const/4 v1, 0x0

    .line 33
    check-cast v1, Landroid/graphics/drawable/Drawable$Callback;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 35
    :cond_1
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeViews:Ljava/util/WeakHashMap;

    invoke-virtual {v0, p0}, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    return-void
.end method

.method public static final getActiveAnimations()Ljava/util/WeakHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Ljava/util/List<",
            "Landroid/animation/Animator;",
            ">;>;"
        }
    .end annotation

    .line 14
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeAnimations:Ljava/util/WeakHashMap;

    return-object v0
.end method

.method public static final getActiveViews()Ljava/util/WeakHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Lcom/github/razir/progressbutton/DrawableViewData;",
            ">;"
        }
    .end annotation

    .line 15
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->activeViews:Ljava/util/WeakHashMap;

    return-object v0
.end method

.method public static final getAttachedViews()Ljava/util/WeakHashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/WeakHashMap<",
            "Landroid/widget/TextView;",
            "Lcom/github/razir/progressbutton/TextChangeAnimatorParams;",
            ">;"
        }
    .end annotation

    .line 13
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->attachedViews:Ljava/util/WeakHashMap;

    return-object v0
.end method

.method private static final removeDrawableAttachViewListener(Landroid/widget/TextView;)V
    .locals 1

    .line 68
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->drawablesAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$drawablesAttachListener$1;

    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    return-void
.end method

.method public static final removeTextAnimationAttachViewListener(Landroid/widget/TextView;)V
    .locals 1

    const-string v0, "$this$removeTextAnimationAttachViewListener"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 60
    sget-object v0, Lcom/github/razir/progressbutton/ProgressButtonHolderKt;->textAnimationsAttachListener:Lcom/github/razir/progressbutton/ProgressButtonHolderKt$textAnimationsAttachListener$1;

    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V

    return-void
.end method
