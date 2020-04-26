.class public Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;
.super Ljava/lang/Object;
.source "MobileKitDialogViewBuilder.java"


# instance fields
.field private final container:Landroid/view/ViewGroup;

.field private final inflater:Landroid/view/LayoutInflater;

.field private msgResId:I

.field private negBtnResId:I

.field private negClickListener:Landroid/view/View$OnClickListener;

.field private posBtnResId:I

.field private posClickListener:Landroid/view/View$OnClickListener;

.field private titleResId:I


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V
    .locals 0

    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->inflater:Landroid/view/LayoutInflater;

    .line 27
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->container:Landroid/view/ViewGroup;

    return-void
.end method


# virtual methods
.method public build()Landroid/view/View;
    .locals 4

    .line 59
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->inflater:Landroid/view/LayoutInflater;

    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$layout;->mk_feedback_dialog_container:I

    iget-object v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->container:Landroid/view/ViewGroup;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 60
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->dialog_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 61
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->inflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/atlassian/mobilekit/module/feedback/R$layout;->mk_feedback_dialog_content:I

    invoke-virtual {v2, v3, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 63
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroidx/appcompat/widget/AppCompatTextView;

    .line 64
    iget v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->titleResId:I

    const/16 v3, 0x8

    if-nez v2, :cond_0

    .line 65
    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/AppCompatTextView;->setVisibility(I)V

    goto :goto_0

    .line 67
    :cond_0
    invoke-virtual {v1, v2}, Landroidx/appcompat/widget/AppCompatTextView;->setText(I)V

    .line 70
    :goto_0
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->message:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroidx/appcompat/widget/AppCompatTextView;

    .line 71
    iget v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->msgResId:I

    if-nez v2, :cond_1

    .line 72
    invoke-virtual {v1, v3}, Landroidx/appcompat/widget/AppCompatTextView;->setVisibility(I)V

    goto :goto_1

    .line 74
    :cond_1
    invoke-virtual {v1, v2}, Landroidx/appcompat/widget/AppCompatTextView;->setText(I)V

    .line 77
    :goto_1
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->positive_btn:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 78
    iget v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->posBtnResId:I

    if-nez v2, :cond_2

    .line 79
    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_2

    .line 81
    :cond_2
    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(I)V

    .line 82
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->posClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    :goto_2
    sget v1, Lcom/atlassian/mobilekit/module/feedback/R$id;->negative_btn:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 86
    iget v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->negBtnResId:I

    if-nez v2, :cond_3

    .line 87
    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_3

    .line 89
    :cond_3
    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(I)V

    .line 90
    iget-object v2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->negClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :goto_3
    return-object v0
.end method

.method public message(I)Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;
    .locals 0

    .line 36
    iput p1, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->msgResId:I

    return-object p0
.end method

.method public negativeButton(ILandroid/view/View$OnClickListener;)Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;
    .locals 0

    .line 51
    iput p1, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->negBtnResId:I

    .line 52
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->negClickListener:Landroid/view/View$OnClickListener;

    return-object p0
.end method

.method public positiveButton(ILandroid/view/View$OnClickListener;)Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;
    .locals 0

    .line 43
    iput p1, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->posBtnResId:I

    .line 44
    iput-object p2, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->posClickListener:Landroid/view/View$OnClickListener;

    return-object p0
.end method

.method public title(I)Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;
    .locals 0

    .line 31
    iput p1, p0, Lcom/atlassian/mobilekit/module/core/MobileKitDialogViewBuilder;->titleResId:I

    return-object p0
.end method
