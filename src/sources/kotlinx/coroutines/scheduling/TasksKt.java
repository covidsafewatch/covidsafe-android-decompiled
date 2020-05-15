package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\r\u001a\u00020\u000e*\u00020\u000f8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_SCHEDULER_NAME", "", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/TimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: Tasks.kt */
public final class TasksKt {
    public static final int BLOCKING_DEFAULT_PARALLELISM = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    public static final int CORE_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    public static final int MAX_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    public static TimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;

    public static final boolean isBlocking(Task task) {
        return task.taskContext.getTaskMode() == 1;
    }
}
