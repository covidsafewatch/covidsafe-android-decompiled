.class public Lcom/atlassian/mobilekit/module/core/ActivityTracker;
.super Ljava/lang/Object;
.source "ActivityTracker.java"

# interfaces
.implements Landroid/app/Application$ActivityLifecycleCallbacks;
.implements Lcom/atlassian/mobilekit/module/core/UiInfo;


# instance fields
.field private activityRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private isAppVisible:Z

.field private final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Lcom/atlassian/mobilekit/module/core/UiInfoListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Application;)V
    .locals 2

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Ljava/lang/ref/WeakReference;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    const/4 v0, 0x0

    .line 15
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->isAppVisible:Z

    .line 16
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 19
    invoke-virtual {p1, p0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method private notifyAppNotVisible()V
    .locals 2

    const/4 v0, 0x0

    .line 59
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->isAppVisible:Z

    .line 60
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/atlassian/mobilekit/module/core/UiInfoListener;

    .line 61
    invoke-interface {v1}, Lcom/atlassian/mobilekit/module/core/UiInfoListener;->onAppNotVisible()V

    goto :goto_0

    :cond_0
    return-void
.end method

.method private notifyAppVisible()V
    .locals 2

    const/4 v0, 0x1

    .line 52
    iput-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->isAppVisible:Z

    .line 53
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/atlassian/mobilekit/module/core/UiInfoListener;

    .line 54
    invoke-interface {v1}, Lcom/atlassian/mobilekit/module/core/UiInfoListener;->onAppVisible()V

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method public getCurrentActivity()Landroid/app/Activity;
    .locals 3

    .line 24
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 27
    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v2

    if-nez v2, :cond_0

    .line 28
    invoke-virtual {v0}, Landroid/app/Activity;->isChangingConfigurations()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 30
    :cond_0
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    move-object v0, v1

    :cond_1
    return-object v0
.end method

.method public isAppVisible()Z
    .locals 1

    .line 38
    iget-boolean v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->isAppVisible:Z

    return v0
.end method

.method public onActivityCreated(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    return-void
.end method

.method public onActivityDestroyed(Landroid/app/Activity;)V
    .locals 1

    .line 104
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-ne v0, p1, :cond_0

    .line 105
    new-instance p1, Ljava/lang/ref/WeakReference;

    const/4 v0, 0x0

    invoke-direct {p1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    :cond_0
    return-void
.end method

.method public onActivityPaused(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public onActivityResumed(Landroid/app/Activity;)V
    .locals 2

    .line 76
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 77
    :goto_0
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_1

    .line 80
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->notifyAppVisible()V

    :cond_1
    return-void
.end method

.method public onActivitySaveInstanceState(Landroid/app/Activity;Landroid/os/Bundle;)V
    .locals 0

    return-void
.end method

.method public onActivityStarted(Landroid/app/Activity;)V
    .locals 0

    return-void
.end method

.method public onActivityStopped(Landroid/app/Activity;)V
    .locals 1

    .line 91
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-ne v0, p1, :cond_0

    .line 92
    new-instance p1, Ljava/lang/ref/WeakReference;

    const/4 v0, 0x0

    invoke-direct {p1, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object p1, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->activityRef:Ljava/lang/ref/WeakReference;

    .line 93
    invoke-direct {p0}, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->notifyAppNotVisible()V

    :cond_0
    return-void
.end method

.method public registerListener(Lcom/atlassian/mobilekit/module/core/UiInfoListener;)V
    .locals 1

    .line 43
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public unregisterListener(Lcom/atlassian/mobilekit/module/core/UiInfoListener;)V
    .locals 1

    .line 48
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/ActivityTracker;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    return-void
.end method
