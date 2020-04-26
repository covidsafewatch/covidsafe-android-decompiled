.class public final Lau/gov/health/covidsafe/PeekActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "PeekActivity.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0002J\u0008\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00082\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u0008H\u0002J\u0008\u0010\u000e\u001a\u00020\u0008H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"
    }
    d2 = {
        "Lau/gov/health/covidsafe/PeekActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "timePeriod",
        "",
        "viewModel",
        "Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;",
        "newPeek",
        "",
        "nextTimePeriod",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "startService",
        "stopService",
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

.field private timePeriod:I

.field private viewModel:Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method public static final synthetic access$getViewModel$p(Lau/gov/health/covidsafe/PeekActivity;)Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;
    .locals 1

    .line 22
    iget-object p0, p0, Lau/gov/health/covidsafe/PeekActivity;->viewModel:Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;

    if-nez p0, :cond_0

    const-string v0, "viewModel"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    return-object p0
.end method

.method public static final synthetic access$nextTimePeriod(Lau/gov/health/covidsafe/PeekActivity;)I
    .locals 0

    .line 22
    invoke-direct {p0}, Lau/gov/health/covidsafe/PeekActivity;->nextTimePeriod()I

    move-result p0

    return p0
.end method

.method public static final synthetic access$setViewModel$p(Lau/gov/health/covidsafe/PeekActivity;Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;)V
    .locals 0

    .line 22
    iput-object p1, p0, Lau/gov/health/covidsafe/PeekActivity;->viewModel:Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;

    return-void
.end method

.method public static final synthetic access$startService(Lau/gov/health/covidsafe/PeekActivity;)V
    .locals 0

    .line 22
    invoke-direct {p0}, Lau/gov/health/covidsafe/PeekActivity;->startService()V

    return-void
.end method

.method public static final synthetic access$stopService(Lau/gov/health/covidsafe/PeekActivity;)V
    .locals 0

    .line 22
    invoke-direct {p0}, Lau/gov/health/covidsafe/PeekActivity;->stopService()V

    return-void
.end method

.method private final newPeek()V
    .locals 5

    const v0, 0x7f0d0024

    .line 32
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/PeekActivity;->setContentView(I)V

    const v0, 0x7f0a0184

    .line 33
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    .line 34
    new-instance v1, Lau/gov/health/covidsafe/RecordListAdapter;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    invoke-direct {v1, v2}, Lau/gov/health/covidsafe/RecordListAdapter;-><init>(Landroid/content/Context;)V

    const-string v3, "recyclerView"

    .line 35
    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v3, v1

    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$Adapter;

    invoke-virtual {v0, v3}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 36
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-direct {v3, v2}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    .line 37
    move-object v2, v3

    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    invoke-virtual {v0, v2}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 39
    new-instance v2, Landroidx/recyclerview/widget/DividerItemDecoration;

    .line 40
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getContext()Landroid/content/Context;

    move-result-object v4

    .line 41
    invoke-virtual {v3}, Landroidx/recyclerview/widget/LinearLayoutManager;->getOrientation()I

    move-result v3

    .line 39
    invoke-direct {v2, v4, v3}, Landroidx/recyclerview/widget/DividerItemDecoration;-><init>(Landroid/content/Context;I)V

    .line 43
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;

    invoke-virtual {v0, v2}, Landroidx/recyclerview/widget/RecyclerView;->addItemDecoration(Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;)V

    .line 45
    new-instance v0, Landroidx/lifecycle/ViewModelProvider;

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/ViewModelStoreOwner;

    invoke-direct {v0, v2}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    const-class v2, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;

    invoke-virtual {v0, v2}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object v0

    const-string v2, "ViewModelProvider(this).\u2026ordViewModel::class.java)"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;

    iput-object v0, p0, Lau/gov/health/covidsafe/PeekActivity;->viewModel:Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;

    if-nez v0, :cond_0

    const-string v2, "viewModel"

    .line 46
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :cond_0
    invoke-virtual {v0}, Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;->getAllRecords()Landroidx/lifecycle/LiveData;

    move-result-object v0

    move-object v2, p0

    check-cast v2, Landroidx/lifecycle/LifecycleOwner;

    new-instance v3, Lau/gov/health/covidsafe/PeekActivity$newPeek$1;

    invoke-direct {v3, v1}, Lau/gov/health/covidsafe/PeekActivity$newPeek$1;-><init>(Lau/gov/health/covidsafe/RecordListAdapter;)V

    check-cast v3, Landroidx/lifecycle/Observer;

    invoke-virtual {v0, v2, v3}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    const v0, 0x7f0a00af

    .line 50
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 51
    new-instance v2, Lau/gov/health/covidsafe/PeekActivity$newPeek$2;

    invoke-direct {v2, p0, v1}, Lau/gov/health/covidsafe/PeekActivity$newPeek$2;-><init>(Lau/gov/health/covidsafe/PeekActivity;Lau/gov/health/covidsafe/RecordListAdapter;)V

    check-cast v2, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a0070

    .line 57
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 58
    new-instance v2, Lau/gov/health/covidsafe/PeekActivity$newPeek$3;

    invoke-direct {v2, p0, v1}, Lau/gov/health/covidsafe/PeekActivity$newPeek$3;-><init>(Lau/gov/health/covidsafe/PeekActivity;Lau/gov/health/covidsafe/RecordListAdapter;)V

    check-cast v2, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a01c5

    .line 65
    invoke-virtual {p0, v0}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 66
    new-instance v1, Lau/gov/health/covidsafe/PeekActivity$newPeek$4;

    invoke-direct {v1, p0}, Lau/gov/health/covidsafe/PeekActivity$newPeek$4;-><init>(Lau/gov/health/covidsafe/PeekActivity;)V

    check-cast v1, Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v1, 0x7f0a01c6

    .line 70
    invoke-virtual {p0, v1}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 71
    new-instance v2, Lau/gov/health/covidsafe/PeekActivity$newPeek$5;

    invoke-direct {v2, p0}, Lau/gov/health/covidsafe/PeekActivity$newPeek$5;-><init>(Lau/gov/health/covidsafe/PeekActivity;)V

    check-cast v2, Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v2, 0x7f0a0086

    .line 75
    invoke-virtual {p0, v2}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 76
    new-instance v3, Lau/gov/health/covidsafe/PeekActivity$newPeek$6;

    invoke-direct {v3, p0}, Lau/gov/health/covidsafe/PeekActivity$newPeek$6;-><init>(Lau/gov/health/covidsafe/PeekActivity;)V

    check-cast v3, Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v3, 0x7f0a017d

    .line 109
    invoke-virtual {p0, v3}, Lau/gov/health/covidsafe/PeekActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;

    .line 110
    new-instance v4, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;

    invoke-direct {v4, p0}, Lau/gov/health/covidsafe/PeekActivity$newPeek$7;-><init>(Lau/gov/health/covidsafe/PeekActivity;)V

    check-cast v4, Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const-string v3, "start"

    .line 117
    invoke-static {v0, v3}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setVisibility(I)V

    const-string v0, "stop"

    .line 118
    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setVisibility(I)V

    const-string v0, "delete"

    .line 119
    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkExpressionValueIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;->setVisibility(I)V

    return-void
.end method

.method private final nextTimePeriod()I
    .locals 5

    .line 127
    iget v0, p0, Lau/gov/health/covidsafe/PeekActivity;->timePeriod:I

    const/16 v1, 0xc

    const/4 v2, 0x6

    const/4 v3, 0x3

    const/4 v4, 0x1

    if-eq v0, v4, :cond_2

    if-eq v0, v3, :cond_1

    if-eq v0, v2, :cond_3

    if-eq v0, v1, :cond_0

    move v1, v4

    goto :goto_0

    :cond_0
    const/16 v1, 0x18

    goto :goto_0

    :cond_1
    move v1, v2

    goto :goto_0

    :cond_2
    move v1, v3

    :cond_3
    :goto_0
    iput v1, p0, Lau/gov/health/covidsafe/PeekActivity;->timePeriod:I

    return v1
.end method

.method private final startService()V
    .locals 2

    .line 140
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->startBluetoothMonitoringService(Landroid/content/Context;)V

    return-void
.end method

.method private final stopService()V
    .locals 2

    .line 144
    sget-object v0, Lau/gov/health/covidsafe/Utils;->INSTANCE:Lau/gov/health/covidsafe/Utils;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lau/gov/health/covidsafe/Utils;->stopBluetoothMonitoringService(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public _$_clearFindViewByIdCache()V
    .locals 1

    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_0
    return-void
.end method

.method public _$_findCachedViewById(I)Landroid/view/View;
    .locals 2

    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity;->_$_findViewCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lau/gov/health/covidsafe/PeekActivity;->_$_findViewCache:Ljava/util/HashMap;

    :cond_0
    iget-object v0, p0, Lau/gov/health/covidsafe/PeekActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    if-nez v0, :cond_1

    invoke-virtual {p0, p1}, Landroidx/fragment/app/FragmentActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/PeekActivity;->_$_findViewCache:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0

    .line 27
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-direct {p0}, Lau/gov/health/covidsafe/PeekActivity;->newPeek()V

    return-void
.end method
