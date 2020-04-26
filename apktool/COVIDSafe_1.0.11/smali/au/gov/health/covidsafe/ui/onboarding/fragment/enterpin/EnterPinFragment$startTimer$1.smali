.class public final Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;
.super Landroid/os/CountDownTimer;
.source "EnterPinFragment.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->startTimer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEnterPinFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnterPinFragment.kt\nau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1\n*L\n1#1,179:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"
    }
    d2 = {
        "au/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1",
        "Landroid/os/CountDownTimer;",
        "onFinish",
        "",
        "onTick",
        "millisUntilFinished",
        "",
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
.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;JJ)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ)V"
        }
    .end annotation

    .line 86
    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-direct {p0, p2, p3, p4, p5}, Landroid/os/CountDownTimer;-><init>(JJ)V

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 3

    .line 102
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    sget v1, Lau/gov/health/covidsafe/R$id;->enter_pin_timer_value:I

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/appcompat/widget/AppCompatTextView;

    if-eqz v0, :cond_0

    const-string v1, "0:00"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroidx/appcompat/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    sget v1, Lau/gov/health/covidsafe/R$id;->enter_pin_resend_pin:I

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const-string v1, "enter_pin_resend_pin"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEnabled(Z)V

    .line 104
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    invoke-virtual {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 105
    iget-object v1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    sget v2, Lau/gov/health/covidsafe/R$id;->enter_pin_resend_pin:I

    invoke-virtual {v1, v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    check-cast v0, Landroid/content/Context;

    const v2, 0x7f06006b

    invoke-static {v0, v2}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setLinkTextColor(I)V

    :cond_1
    return-void
.end method

.method public onTick(J)V
    .locals 4

    long-to-double p1, p1

    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    mul-double/2addr v0, p1

    const v2, 0xea60

    int-to-double v2, v2

    div-double/2addr v0, v2

    .line 88
    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-int v0, v0

    const-wide v1, 0x408f400000000000L    # 1000.0

    div-double/2addr p1, v1

    const/16 v1, 0x3c

    int-to-double v1, v1

    rem-double/2addr p1, v1

    .line 90
    invoke-static {p1, p2}, Ljava/lang/Math;->floor(D)D

    move-result-wide p1

    double-to-int p1, p1

    const/16 p2, 0xa

    if-ge p1, p2, :cond_0

    .line 93
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v1, 0x30

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 95
    :cond_0
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    .line 98
    :goto_0
    iget-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment$startTimer$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;

    sget v1, Lau/gov/health/covidsafe/R$id;->enter_pin_timer_value:I

    invoke-virtual {p2, v1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enterpin/EnterPinFragment;->_$_findCachedViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroidx/appcompat/widget/AppCompatTextView;

    if-eqz p2, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const/16 v0, 0x3a

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {p2, p1}, Landroidx/appcompat/widget/AppCompatTextView;->setText(Ljava/lang/CharSequence;)V

    :cond_1
    return-void
.end method
