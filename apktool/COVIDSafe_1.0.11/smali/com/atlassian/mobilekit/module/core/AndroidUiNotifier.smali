.class public Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;
.super Ljava/lang/Object;
.source "AndroidUiNotifier.java"

# interfaces
.implements Lcom/atlassian/mobilekit/module/core/UiNotifier;


# instance fields
.field private final uiHandler:Landroid/os/Handler;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;->uiHandler:Landroid/os/Handler;

    return-void
.end method


# virtual methods
.method public post(Ljava/lang/Runnable;)V
    .locals 1

    .line 17
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;->uiHandler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public postDelayed(Ljava/lang/Runnable;I)V
    .locals 3

    .line 22
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/core/AndroidUiNotifier;->uiHandler:Landroid/os/Handler;

    int-to-long v1, p2

    invoke-virtual {v0, p1, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    return-void
.end method
