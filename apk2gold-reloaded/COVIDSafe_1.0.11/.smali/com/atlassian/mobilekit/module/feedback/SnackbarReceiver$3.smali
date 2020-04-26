.class synthetic Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$3;
.super Ljava/lang/Object;
.source "SnackbarReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 31
    invoke-static {}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->values()[Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$3;->$SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result:[I

    :try_start_0
    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->SUCCESS:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    :try_start_1
    sget-object v0, Lcom/atlassian/mobilekit/module/feedback/SnackbarReceiver$3;->$SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result:[I

    sget-object v1, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->FAIL:Lcom/atlassian/mobilekit/module/feedback/commands/Result;

    invoke-virtual {v1}, Lcom/atlassian/mobilekit/module/feedback/commands/Result;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :catch_1
    return-void
.end method
