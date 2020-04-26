.class public final Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;
.super Ljava/lang/Object;
.source "ButtonTextAnimatorExtensions.kt"

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->animateTextChange(Landroid/widget/TextView;Landroid/text/SpannableString;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0008\u0004\n\u0002\u0008\u0004\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"
    }
    d2 = {
        "com/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$fadeOutAnim$1$1",
        "Landroid/animation/Animator$AnimatorListener;",
        "onAnimationCancel",
        "",
        "animation",
        "Landroid/animation/Animator;",
        "onAnimationEnd",
        "onAnimationRepeat",
        "onAnimationStart",
        "progressbutton_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $fadeInAnim$inlined:Landroid/animation/ObjectAnimator;

.field final synthetic $newText$inlined:Landroid/text/SpannableString;

.field final synthetic $params$inlined:Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

.field final synthetic $this_animateTextChange$inlined:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Landroid/widget/TextView;Lcom/github/razir/progressbutton/TextChangeAnimatorParams;Landroid/text/SpannableString;Landroid/animation/ObjectAnimator;)V
    .locals 0

    iput-object p1, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    iput-object p2, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$params$inlined:Lcom/github/razir/progressbutton/TextChangeAnimatorParams;

    iput-object p3, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$newText$inlined:Landroid/text/SpannableString;

    iput-object p4, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$fadeInAnim$inlined:Landroid/animation/ObjectAnimator;

    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    const-string v0, "animation"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$newText$inlined:Landroid/text/SpannableString;

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    invoke-static {v0}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->access$resetColor(Landroid/widget/TextView;)V

    .line 112
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    invoke-static {v0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->access$cleaAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V

    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    const-string v0, "animation"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$newText$inlined:Landroid/text/SpannableString;

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$fadeInAnim$inlined:Landroid/animation/ObjectAnimator;

    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->start()V

    .line 106
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    invoke-static {v0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->access$cleaAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V

    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 1

    const-string v0, "animation"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 1

    const-string v0, "animation"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 116
    iget-object v0, p0, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt$animateTextChange$$inlined$apply$lambda$2;->$this_animateTextChange$inlined:Landroid/widget/TextView;

    invoke-static {v0, p1}, Lcom/github/razir/progressbutton/ButtonTextAnimatorExtensionsKt;->access$addAnimator(Landroid/widget/TextView;Landroid/animation/Animator;)V

    return-void
.end method
