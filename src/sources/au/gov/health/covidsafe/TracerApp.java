package au.gov.health.covidsafe;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.services.BluetoothMonitoringService;
import au.gov.health.covidsafe.streetpass.CentralDevice;
import au.gov.health.covidsafe.streetpass.PeripheralDevice;
import com.atlassian.mobilekit.module.feedback.FeedbackModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lau/gov/health/covidsafe/TracerApp;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: TracerApp.kt */
public final class TracerApp extends Application {
    public static Context AppContext = null;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ORG = "AU_DTA";
    private static final String TAG = "TracerApp";
    public static final int protocolVersion = 2;

    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        AppContext = applicationContext;
        FeedbackModule.init(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/TracerApp$Companion;", "", "()V", "AppContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "ORG", "", "TAG", "protocolVersion", "", "asCentralDevice", "Lau/gov/health/covidsafe/streetpass/CentralDevice;", "asPeripheralDevice", "Lau/gov/health/covidsafe/streetpass/PeripheralDevice;", "thisDeviceMsg", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: TracerApp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context getAppContext() {
            Context access$getAppContext$cp = TracerApp.AppContext;
            if (access$getAppContext$cp == null) {
                Intrinsics.throwUninitializedPropertyAccessException("AppContext");
            }
            return access$getAppContext$cp;
        }

        public final void setAppContext(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "<set-?>");
            TracerApp.AppContext = context;
        }

        public final String thisDeviceMsg() {
            String broadcastMessage = BluetoothMonitoringService.Companion.getBroadcastMessage();
            if (broadcastMessage != null) {
                CentralLog.Companion companion = CentralLog.Companion;
                companion.i(TracerApp.TAG, "Retrieved BM for storage: " + broadcastMessage);
                return broadcastMessage;
            }
            CentralLog.Companion.e(TracerApp.TAG, "No local Broadcast Message");
            String broadcastMessage2 = BluetoothMonitoringService.Companion.getBroadcastMessage();
            if (broadcastMessage2 == null) {
                Intrinsics.throwNpe();
            }
            return broadcastMessage2;
        }

        public final PeripheralDevice asPeripheralDevice() {
            String str = Build.MODEL;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
            return new PeripheralDevice(str, "SELF");
        }

        public final CentralDevice asCentralDevice() {
            String str = Build.MODEL;
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
            return new CentralDevice(str, "SELF");
        }
    }
}
