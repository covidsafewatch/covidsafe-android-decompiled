.class Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;
.super Ljava/lang/Object;
.source "AbstractCommand.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->updateReceiver(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;

.field final synthetic val$data:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;Ljava/lang/Object;)V
    .locals 0

    .line 31
    iput-object p1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;

    iput-object p2, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;->val$data:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .line 34
    iget-object v0, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;->this$0:Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;

    invoke-static {v0}, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;->access$000(Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand;)Lcom/atlassian/mobilekit/module/core/Receiver;

    move-result-object v0

    iget-object v1, p0, Lcom/atlassian/mobilekit/module/feedback/commands/AbstractCommand$1;->val$data:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/atlassian/mobilekit/module/core/Receiver;->receive(Ljava/lang/Object;)V

    return-void
.end method
