.class Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;
.super Ljava/lang/Object;
.source "StatusRecordDao_Impl.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->insert(Lau/gov/health/covidsafe/status/persistence/StatusRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

.field final synthetic val$record:Lau/gov/health/covidsafe/status/persistence/StatusRecord;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;Lau/gov/health/covidsafe/status/persistence/StatusRecord;)V
    .locals 0

    .line 72
    iput-object p1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    iput-object p2, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->val$record:Lau/gov/health/covidsafe/status/persistence/StatusRecord;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 72
    invoke-virtual {p0}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->call()Lkotlin/Unit;

    move-result-object v0

    return-object v0
.end method

.method public call()Lkotlin/Unit;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 75
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-static {v0}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->access$000(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/RoomDatabase;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/room/RoomDatabase;->beginTransaction()V

    .line 77
    :try_start_0
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-static {v0}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->access$100(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/EntityInsertionAdapter;

    move-result-object v0

    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->val$record:Lau/gov/health/covidsafe/status/persistence/StatusRecord;

    invoke-virtual {v0, v1}, Landroidx/room/EntityInsertionAdapter;->insert(Ljava/lang/Object;)V

    .line 78
    iget-object v0, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-static {v0}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->access$000(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/RoomDatabase;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/room/RoomDatabase;->setTransactionSuccessful()V

    .line 79
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-static {v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->access$000(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/RoomDatabase;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/room/RoomDatabase;->endTransaction()V

    return-object v0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl$4;->this$0:Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;

    invoke-static {v1}, Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;->access$000(Lau/gov/health/covidsafe/status/persistence/StatusRecordDao_Impl;)Landroidx/room/RoomDatabase;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/room/RoomDatabase;->endTransaction()V

    .line 82
    throw v0
.end method
