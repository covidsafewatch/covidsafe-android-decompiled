package au.gov.health.covidsafe.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.services.SensorMonitoringService;
import au.gov.health.covidsafe.status.persistence.StatusRecordStorage;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/receivers/PrivacyCleanerReceiver;", "Landroid/content/BroadcastReceiver;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "TAG", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PrivacyCleanerReceiver.kt */
public final class PrivacyCleanerReceiver extends BroadcastReceiver implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private final String TAG;
    private Job job = JobKt.Job$default((Job) null, 1, (Object) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lau/gov/health/covidsafe/receivers/PrivacyCleanerReceiver$Companion;", "", "()V", "cleanDb", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntent", "Landroid/app/PendingIntent;", "requestCode", "", "startAlarm", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PrivacyCleanerReceiver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PendingIntent getIntent(Context context, int i) {
            return PendingIntent.getBroadcast(context, i, new Intent(context, PrivacyCleanerReceiver.class), 268435456);
        }

        public final void startAlarm(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            PendingIntent intent = getIntent(context, 12);
            Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (systemService != null) {
                ((AlarmManager) systemService).setRepeating(1, System.currentTimeMillis(), 86400000, intent);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.AlarmManager");
        }

        public final Object cleanDb(Context context, Continuation<? super Unit> continuation) {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            instance.add(5, -21);
            StreetPassRecordStorage streetPassRecordStorage = new StreetPassRecordStorage(context);
            Intrinsics.checkExpressionValueIsNotNull(instance, "twentyOneDaysAgo");
            int deleteDataOlderThan = streetPassRecordStorage.deleteDataOlderThan(instance.getTimeInMillis());
            int deleteDataOlderThan2 = new StatusRecordStorage(context).deleteDataOlderThan(instance.getTimeInMillis());
            au.gov.health.covidsafe.logging.CentralLog.Companion companion = CentralLog.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("Street info deleted count : ");
            sb.append(deleteDataOlderThan);
            String sb2 = sb.toString();
            String str = SensorMonitoringService.TAG;
            companion.i(str, sb2);
            au.gov.health.covidsafe.logging.CentralLog.Companion companion2 = CentralLog.Companion;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Status info deleted count : ");
            sb3.append(deleteDataOlderThan2);
            companion2.i(str, sb3.toString());
            return Unit.INSTANCE;
        }
    }

    public PrivacyCleanerReceiver() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getDefault().plus(this.job);
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new PrivacyCleanerReceiver$onReceive$1(context, null), 3, null);
    }
}
