.class public final Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;
.super Landroid/widget/LinearLayout;
.source "SegmentedProgressBar.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nSegmentedProgressBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedProgressBar.kt\nau/gov/health/covidsafe/ui/view/SegmentedProgressBar\n*L\n1#1,53:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u0008J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"
    }
    d2 = {
        "Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;",
        "Landroid/widget/LinearLayout;",
        "context",
        "Landroid/content/Context;",
        "attrs",
        "Landroid/util/AttributeSet;",
        "defStyle",
        "",
        "(Landroid/content/Context;Landroid/util/AttributeSet;I)V",
        "maxValue",
        "value",
        "progress",
        "getProgress",
        "()I",
        "setProgress",
        "(I)V",
        "segmentSpacing",
        "drawProgress",
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
.field private _$_findViewCache:Ljava/util/HashMap;

.field private final maxValue:I

.field private progress:I

.field private final segmentSpacing:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 6

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x6

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;IILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6

    const/4 v3, 0x0

    const/4 v4, 0x4

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;IILkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    const/4 v0, 0x0

    .line 24
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setOrientation(I)V

    .line 25
    sget-object v1, Lau/gov/health/covidsafe/R$styleable;->SegmentedProgressBar:[I

    invoke-virtual {p1, p2, v1, p3, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object p1

    const/4 p2, 0x5

    .line 26
    invoke-virtual {p1, v0, p2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p2

    iput p2, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->maxValue:I

    .line 28
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->getResources()Landroid/content/res/Resources;

    move-result-object p2

    const-string p3, "resources"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p2

    iget p2, p2, Landroid/util/DisplayMetrics;->density:F

    float-to-int p2, p2

    mul-int/lit8 p2, p2, 0x4

    const/4 p3, 0x2

    .line 27
    invoke-virtual {p1, p3, p2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result p2

    iput p2, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->segmentSpacing:I

    const/4 p2, 0x1

    .line 29
    invoke-virtual {p1, p2, v0}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result p2

    invoke-virtual {p0, p2}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->setProgress(I)V

    .line 30
    invoke-direct {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->drawProgress()V

    .line 31
    invoke-virtual {p1}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method

.method public synthetic constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;IILkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_0

    const/4 p2, 0x0

    .line 10
    check-cast p2, Landroid/util/AttributeSet;

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    const/4 p3, -0x1

    :cond_1
    invoke-direct {p0, p1, p2, p3}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method private final drawProgress()V
    .locals 8

    .line 35
    iget v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->maxValue:I

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_4

    .line 36
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->generateDefaultLayoutParams()Landroid/widget/LinearLayout$LayoutParams;

    move-result-object v3

    const/4 v4, -0x2

    .line 37
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 38
    iput v1, v3, Landroid/widget/LinearLayout$LayoutParams;->width:I

    const/high16 v4, 0x3f800000    # 1.0f

    .line 39
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 40
    iget v4, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->maxValue:I

    const/4 v5, 0x1

    sub-int/2addr v4, v5

    if-le v5, v2, :cond_0

    goto :goto_1

    :cond_0
    if-le v4, v2, :cond_1

    iget v4, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->segmentSpacing:I

    goto :goto_2

    :cond_1
    :goto_1
    move v4, v1

    :goto_2
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->rightMargin:I

    if-lez v2, :cond_2

    .line 41
    iget v4, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->segmentSpacing:I

    goto :goto_3

    :cond_2
    move v4, v1

    :goto_3
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->leftMargin:I

    .line 43
    new-instance v4, Landroid/view/View;

    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v4, v6}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 44
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->getContext()Landroid/content/Context;

    move-result-object v6

    const v7, 0x7f0800c8

    invoke-static {v6, v7}, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    add-int/lit8 v2, v2, 0x1

    .line 45
    iget v6, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->progress:I

    if-gt v2, v6, :cond_3

    goto :goto_4

    :cond_3
    move v5, v1

    :goto_4
    invoke-virtual {v4, v5}, Landroid/view/View;->setSelected(Z)V

    .line 46
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {p0, v4, v3}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    :cond_4
    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_1

    invoke-virtual {p0, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-object v0
.end method

.method public final getProgress()I
    .locals 1

    .line 12
    iget v0, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->progress:I

    return v0
.end method

.method public final setProgress(I)V
    .locals 5

    .line 14
    iput p1, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->progress:I

    .line 15
    invoke-virtual {p0}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->getChildCount()I

    move-result p1

    if-ltz p1, :cond_2

    const/4 v0, 0x0

    move v1, v0

    .line 16
    :goto_0
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_1

    add-int/lit8 v3, v1, 0x1

    .line 17
    iget v4, p0, Lau/gov/health/covidsafe/ui/view/SegmentedProgressBar;->progress:I

    if-gt v3, v4, :cond_0

    const/4 v3, 0x1

    goto :goto_1

    :cond_0
    move v3, v0

    :goto_1
    invoke-virtual {v2, v3}, Landroid/view/View;->setSelected(Z)V

    :cond_1
    if-eq v1, p1, :cond_2

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_2
    return-void
.end method
