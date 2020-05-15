package au.gov.health.covidsafe.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lau/gov/health/covidsafe/scheduler/Scheduler;", "", "()V", "cancelServiceIntent", "", "requestCode", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "scheduleServiceIntent", "timeFromNowInMillis", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Scheduler.kt */
public final class Scheduler {
    public static final Scheduler INSTANCE = new Scheduler();

    private Scheduler() {
    }

    public final void scheduleServiceIntent(int i, Context context, Intent intent, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            AlarmManager alarmManager = (AlarmManager) systemService;
            PendingIntent service = PendingIntent.getService(context, i, intent, 134217728);
            if (Build.VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + j, service);
            } else {
                alarmManager.set(2, SystemClock.elapsedRealtime() + j, service);
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.app.AlarmManager");
        }
    }

    public final void cancelServiceIntent(int i, Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        PendingIntent.getService(context, i, intent, 134217728).cancel();
    }
}
