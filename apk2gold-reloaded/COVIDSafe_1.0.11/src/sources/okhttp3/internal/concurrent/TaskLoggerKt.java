package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a2\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\b¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\b¨\u0006\u0012"}, d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k = 2, mv = {1, 1, 16})
/* compiled from: TaskLogger.kt */
public final class TaskLoggerKt {
    public static final void taskLog(Task task, TaskQueue taskQueue, Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(taskQueue, "queue");
        Intrinsics.checkParameterIsNotNull(function0, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) function0.invoke());
        }
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, Function0<? extends T> function0) {
        long j;
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(taskQueue, "queue");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j = -1;
        }
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                long nanoTime = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j;
                StringBuilder sb = new StringBuilder();
                sb.append("finished run in ");
                sb.append(formatDuration(nanoTime));
                log(task, taskQueue, sb.toString());
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                long nanoTime2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("failed a run in ");
                sb2.append(formatDuration(nanoTime2));
                log(task, taskQueue, sb2.toString());
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str};
        String format = String.format("%-22s", Arrays.copyOf(objArr, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final String formatDuration(long j) {
        String str;
        String str2 = " s ";
        if (j <= ((long) -999500000)) {
            StringBuilder sb = new StringBuilder();
            sb.append((j - ((long) 500000000)) / ((long) 1000000000));
            sb.append(str2);
            str = sb.toString();
        } else {
            String str3 = " ms";
            if (j <= ((long) -999500)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append((j - ((long) 500000)) / ((long) 1000000));
                sb2.append(str3);
                str = sb2.toString();
            } else {
                String str4 = " µs";
                if (j <= 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append((j - ((long) 500)) / ((long) 1000));
                    sb3.append(str4);
                    str = sb3.toString();
                } else if (j < ((long) 999500)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append((j + ((long) 500)) / ((long) 1000));
                    sb4.append(str4);
                    str = sb4.toString();
                } else if (j < ((long) 999500000)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append((j + ((long) 500000)) / ((long) 1000000));
                    sb5.append(str3);
                    str = sb5.toString();
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append((j + ((long) 500000000)) / ((long) 1000000000));
                    sb6.append(str2);
                    str = sb6.toString();
                }
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str5 = "%6s";
        String format = String.format(str5, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
