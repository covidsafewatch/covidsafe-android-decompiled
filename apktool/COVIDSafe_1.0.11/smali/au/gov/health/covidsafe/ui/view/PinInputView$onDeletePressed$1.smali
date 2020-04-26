.class final Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;
.super Ljava/lang/Object;
.source "PinInputView.kt"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/view/PinInputView;->onDeletePressed(Landroid/widget/EditText;Landroid/widget/EditText;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPinInputView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PinInputView.kt\nau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1\n*L\n1#1,77:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00080\u0008H\n\u00a2\u0006\u0002\u0008\t"
    }
    d2 = {
        "<anonymous>",
        "",
        "view",
        "Landroid/view/View;",
        "kotlin.jvm.PlatformType",
        "keyCode",
        "",
        "keyEvent",
        "Landroid/view/KeyEvent;",
        "onKey"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $prev:Landroid/widget/EditText;

.field final synthetic $this_onDeletePressed:Landroid/widget/EditText;

.field final synthetic this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/view/PinInputView;Landroid/widget/EditText;Landroid/widget/EditText;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->$this_onDeletePressed:Landroid/widget/EditText;

    iput-object p3, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->$prev:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 1

    const/4 p1, 0x1

    const/4 p3, 0x0

    const/16 v0, 0x43

    if-ne p2, v0, :cond_3

    .line 67
    iget-object p2, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->$this_onDeletePressed:Landroid/widget/EditText;

    invoke-virtual {p2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    if-eqz p2, :cond_1

    invoke-interface {p2}, Ljava/lang/CharSequence;->length()I

    move-result p2

    if-nez p2, :cond_0

    goto :goto_0

    :cond_0
    move p2, p3

    goto :goto_1

    :cond_1
    :goto_0
    move p2, p1

    :goto_1
    if-eqz p2, :cond_3

    .line 68
    iget-object p2, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->$prev:Landroid/widget/EditText;

    if-eqz p2, :cond_2

    invoke-virtual {p2}, Landroid/widget/EditText;->requestFocus()Z

    .line 69
    :cond_2
    iget-object p2, p0, Lau/gov/health/covidsafe/ui/view/PinInputView$onDeletePressed$1;->this$0:Lau/gov/health/covidsafe/ui/view/PinInputView;

    invoke-virtual {p2}, Lau/gov/health/covidsafe/ui/view/PinInputView;->getOnPinChanged()Lkotlin/jvm/functions/Function0;

    move-result-object p2

    if-eqz p2, :cond_4

    invoke-interface {p2}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lkotlin/Unit;

    goto :goto_2

    :cond_3
    move p1, p3

    :cond_4
    :goto_2
    return p1
.end method
