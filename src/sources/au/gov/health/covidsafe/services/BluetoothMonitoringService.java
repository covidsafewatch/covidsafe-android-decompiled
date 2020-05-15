package au.gov.health.covidsafe.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import au.gov.health.covidsafe.BuildConfig;
import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.bluetooth.BLEAdvertiser;
import au.gov.health.covidsafe.bluetooth.gatt.GATTKt;
import au.gov.health.covidsafe.factory.NetworkFactory;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.networking.service.AwsClient;
import au.gov.health.covidsafe.notifications.NotificationTemplates;
import au.gov.health.covidsafe.receivers.PrivacyCleanerReceiver;
import au.gov.health.covidsafe.status.Status;
import au.gov.health.covidsafe.status.persistence.StatusRecord;
import au.gov.health.covidsafe.status.persistence.StatusRecordStorage;
import au.gov.health.covidsafe.streetpass.ConnectionRecord;
import au.gov.health.covidsafe.streetpass.StreetPassScanner;
import au.gov.health.covidsafe.streetpass.StreetPassServer;
import au.gov.health.covidsafe.streetpass.StreetPassWorker;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import pub.devrel.easypermissions.EasyPermissions;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\r\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0005STUVWB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u00020\u0018H\u0002J\b\u00109\u001a\u00020\u0018H\u0002J\b\u0010:\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020.H\u0016J\"\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020=H\u0016J\b\u0010B\u001a\u00020.H\u0002J\b\u0010C\u001a\u00020.H\u0002J\b\u0010D\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010GJ\b\u0010H\u001a\u00020.H\u0002J\b\u0010I\u001a\u00020.H\u0002J\b\u0010J\u001a\u00020.H\u0002J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020.H\u0002J\b\u0010N\u001a\u00020.H\u0002J\b\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u00020.H\u0002J\u0006\u0010Q\u001a\u00020.J\b\u0010R\u001a\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00060 R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00060$R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService;", "Landroidx/lifecycle/LifecycleService;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "advertiser", "Lau/gov/health/covidsafe/bluetooth/BLEAdvertiser;", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "bluetoothStatusReceiver", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;", "commandHandler", "Lau/gov/health/covidsafe/services/CommandHandler;", "connection", "au/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$connection$1;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "mBound", "", "mNotificationManager", "Landroid/app/NotificationManager;", "mService", "Lau/gov/health/covidsafe/services/SensorMonitoringService;", "serviceUUID", "", "statusReceiver", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;", "statusRecordStorage", "Lau/gov/health/covidsafe/status/persistence/StatusRecordStorage;", "streetPassReceiver", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;", "streetPassRecordStorage", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecordStorage;", "streetPassScanner", "Lau/gov/health/covidsafe/streetpass/StreetPassScanner;", "streetPassServer", "Lau/gov/health/covidsafe/streetpass/StreetPassServer;", "worker", "Lau/gov/health/covidsafe/streetpass/StreetPassWorker;", "actionAdvertise", "", "actionHealthCheck", "actionScan", "actionStart", "actionStop", "actionUpdateBm", "calcPhaseShift", "", "min", "max", "hasLocationPermissions", "isBluetoothEnabled", "onCreate", "onDestroy", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "performHealthCheck", "performScanAndScheduleNextScan", "registerReceivers", "runService", "cmd", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;", "setup", "setupAdvertiser", "setupAdvertisingCycles", "setupCycles", "setupNotifications", "setupScanCycles", "setupScanner", "setupService", "startScan", "teardown", "unregisterReceivers", "BluetoothStatusReceiver", "Command", "Companion", "StatusReceiver", "StreetPassReceiver", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: BluetoothMonitoringService.kt */
public final class BluetoothMonitoringService extends LifecycleService implements CoroutineScope {
    private static final String CHANNEL_ID = "COVIDSafe Updates";
    public static final String CHANNEL_SERVICE = "Foreground Service";
    public static final String COMMAND_KEY = "au.gov.health.covidsafe_CMD";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DAILY_UPLOAD_NOTIFICATION_CODE = 13;
    private static final int NOTIFICATION_ID = 771579;
    public static final int PENDING_ACTIVITY = 5;
    public static final int PENDING_ADVERTISE_REQ_CODE = 8;
    public static final int PENDING_BM_UPDATE = 11;
    public static final int PENDING_HEALTH_CHECK_CODE = 9;
    public static final int PENDING_PRIVACY_CLEANER_CODE = 12;
    public static final int PENDING_SCAN_REQ_CODE = 7;
    public static final int PENDING_START = 6;
    public static final int PENDING_WIZARD_REQ_CODE = 10;
    private static final String TAG = "BTMService";
    public static final long advertisingDuration = 180000;
    public static final long advertisingGap = 5000;
    public static final long blacklistDuration = 100000;
    public static final long bmCheckInterval = 540000;
    /* access modifiers changed from: private */
    public static String broadcastMessage = null;
    public static final long connectionTimeout = 6000;
    public static final long healthCheckInterval = 900000;
    public static final long maxQueueTime = 7000;
    public static final long maxScanInterval = 43000;
    public static final long minScanInterval = 36000;
    public static final long scanDuration = 8000;
    private BLEAdvertiser advertiser;
    private final AwsClient awsClient = NetworkFactory.Companion.getAwsClient();
    private final BluetoothStatusReceiver bluetoothStatusReceiver = new BluetoothStatusReceiver();
    private CommandHandler commandHandler;
    private final BluetoothMonitoringService$connection$1 connection = new BluetoothMonitoringService$connection$1(this);
    private Job job = JobKt.Job$default((Job) null, 1, (Object) null);
    private LocalBroadcastManager localBroadcastManager;
    /* access modifiers changed from: private */
    public boolean mBound;
    private NotificationManager mNotificationManager;
    /* access modifiers changed from: private */
    public SensorMonitoringService mService;
    private String serviceUUID;
    private final StatusReceiver statusReceiver = new StatusReceiver();
    /* access modifiers changed from: private */
    public StatusRecordStorage statusRecordStorage;
    private final StreetPassReceiver streetPassReceiver = new StreetPassReceiver();
    /* access modifiers changed from: private */
    public StreetPassRecordStorage streetPassRecordStorage;
    private StreetPassScanner streetPassScanner;
    private StreetPassServer streetPassServer;
    private StreetPassWorker worker;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Command.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Command.ACTION_START.ordinal()] = 1;
            $EnumSwitchMapping$0[Command.ACTION_SCAN.ordinal()] = 2;
            $EnumSwitchMapping$0[Command.ACTION_ADVERTISE.ordinal()] = 3;
            $EnumSwitchMapping$0[Command.ACTION_UPDATE_BM.ordinal()] = 4;
            $EnumSwitchMapping$0[Command.ACTION_STOP.ordinal()] = 5;
            $EnumSwitchMapping$0[Command.ACTION_SELF_CHECK.ordinal()] = 6;
        }
    }

    public static final /* synthetic */ SensorMonitoringService access$getMService$p(BluetoothMonitoringService bluetoothMonitoringService) {
        SensorMonitoringService sensorMonitoringService = bluetoothMonitoringService.mService;
        if (sensorMonitoringService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mService");
        }
        return sensorMonitoringService;
    }

    public static final /* synthetic */ StatusRecordStorage access$getStatusRecordStorage$p(BluetoothMonitoringService bluetoothMonitoringService) {
        StatusRecordStorage statusRecordStorage2 = bluetoothMonitoringService.statusRecordStorage;
        if (statusRecordStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusRecordStorage");
        }
        return statusRecordStorage2;
    }

    public static final /* synthetic */ StreetPassRecordStorage access$getStreetPassRecordStorage$p(BluetoothMonitoringService bluetoothMonitoringService) {
        StreetPassRecordStorage streetPassRecordStorage2 = bluetoothMonitoringService.streetPassRecordStorage;
        if (streetPassRecordStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("streetPassRecordStorage");
        }
        return streetPassRecordStorage2;
    }

    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    public void onCreate() {
        super.onCreate();
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this);
        Intrinsics.checkExpressionValueIsNotNull(instance, "LocalBroadcastManager.getInstance(this)");
        this.localBroadcastManager = instance;
        setup();
    }

    private final void setup() {
        Object systemService = getSystemService("power");
        if (systemService != null) {
            CentralLog.Companion.setPowerManager((PowerManager) systemService);
            this.commandHandler = new CommandHandler(new WeakReference(this));
            CentralLog.Companion.d(TAG, "Creating service - BluetoothMonitoringService");
            this.serviceUUID = BuildConfig.BLE_SSID;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
            this.worker = new StreetPassWorker(applicationContext);
            unregisterReceivers();
            registerReceivers();
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "this.applicationContext");
            this.streetPassRecordStorage = new StreetPassRecordStorage(applicationContext2);
            Context applicationContext3 = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext3, "this.applicationContext");
            this.statusRecordStorage = new StatusRecordStorage(applicationContext3);
            PrivacyCleanerReceiver.Companion companion = PrivacyCleanerReceiver.Companion;
            Context applicationContext4 = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext4, "this.applicationContext");
            companion.startAlarm(applicationContext4);
            setupNotifications();
            Utils utils = Utils.INSTANCE;
            Context applicationContext5 = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext5, "this.applicationContext");
            broadcastMessage = utils.retrieveBroadcastMessage(applicationContext5);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.PowerManager");
    }

    public final void teardown() {
        StreetPassServer streetPassServer2 = this.streetPassServer;
        if (streetPassServer2 != null) {
            streetPassServer2.tearDown();
        }
        this.streetPassServer = null;
        StreetPassScanner streetPassScanner2 = this.streetPassScanner;
        if (streetPassScanner2 != null) {
            streetPassScanner2.stopScan();
        }
        this.streetPassScanner = null;
        CommandHandler commandHandler2 = this.commandHandler;
        if (commandHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
        }
        commandHandler2.removeCallbacksAndMessages((Object) null);
        Utils utils = Utils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
        utils.cancelBMUpdateCheck(applicationContext);
        Utils utils2 = Utils.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "this.applicationContext");
        utils2.cancelNextScan(applicationContext2);
        Utils utils3 = Utils.INSTANCE;
        Context applicationContext3 = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext3, "this.applicationContext");
        utils3.cancelNextAdvertise(applicationContext3);
    }

    private final void setupNotifications() {
        Object systemService = getSystemService("notification");
        if (systemService != null) {
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("COVIDSafe Updates", "Foreground Service", 2);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(true);
                notificationChannel.setVibrationPattern(new long[]{0});
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    private final boolean hasLocationPermissions() {
        String[] requiredPermissions = Utils.INSTANCE.getRequiredPermissions();
        return EasyPermissions.hasPermissions(getApplicationContext(), (String[]) Arrays.copyOf(requiredPermissions, requiredPermissions.length));
    }

    private final boolean isBluetoothEnabled() {
        BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) LazyKt.lazy(LazyThreadSafetyMode.NONE, new BluetoothMonitoringService$isBluetoothEnabled$bluetoothAdapter$2(this)).getValue();
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.isEnabled();
        }
        return false;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        CentralLog.Companion.i(TAG, "Service onStartCommand");
        bindService(new Intent(getApplicationContext(), SensorMonitoringService.class), this.connection, 1);
        if (!hasLocationPermissions() || !isBluetoothEnabled()) {
            CentralLog.Companion companion = CentralLog.Companion;
            companion.i(TAG, "location permission: " + hasLocationPermissions() + " bluetooth: " + isBluetoothEnabled());
            NotificationTemplates.Companion companion2 = NotificationTemplates.Companion;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
            startForeground(771579, companion2.lackingThingsNotification(applicationContext, "COVIDSafe Updates"));
            return 1;
        } else if (intent != null) {
            runService(Command.Companion.findByValue(intent.getIntExtra(COMMAND_KEY, Command.INVALID.getIndex())));
            return 1;
        } else {
            CentralLog.Companion.e(TAG, "Nothing in intent @ onStartCommand");
            CommandHandler commandHandler2 = this.commandHandler;
            if (commandHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
            }
            commandHandler2.startBluetoothMonitoringService();
            return 1;
        }
    }

    public final void runService(Command command) {
        CentralLog.Companion companion = CentralLog.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("Command is:");
        sb.append(command != null ? command.getString() : null);
        companion.i(TAG, sb.toString());
        if (!hasLocationPermissions() || !isBluetoothEnabled()) {
            CentralLog.Companion companion2 = CentralLog.Companion;
            companion2.i(TAG, "location permission: " + hasLocationPermissions() + " bluetooth: " + isBluetoothEnabled());
            NotificationTemplates.Companion companion3 = NotificationTemplates.Companion;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
            startForeground(771579, companion3.lackingThingsNotification(applicationContext, "COVIDSafe Updates"));
            return;
        }
        if (command != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[command.ordinal()]) {
                case 1:
                    setupService();
                    actionStart();
                    Utils utils = Utils.INSTANCE;
                    Context applicationContext2 = getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "this.applicationContext");
                    utils.scheduleNextHealthCheck(applicationContext2, 900000);
                    Utils utils2 = Utils.INSTANCE;
                    Context applicationContext3 = getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(applicationContext3, "this.applicationContext");
                    utils2.scheduleBMUpdateCheck(applicationContext3, 540000);
                    return;
                case 2:
                    actionScan();
                    return;
                case 3:
                    actionAdvertise();
                    return;
                case 4:
                    actionUpdateBm();
                    return;
                case 5:
                    actionStop();
                    return;
                case 6:
                    actionHealthCheck();
                    return;
            }
        }
        CentralLog.Companion companion4 = CentralLog.Companion;
        companion4.i(TAG, "Invalid command: " + command + ". Nothing to do");
    }

    private final void actionStop() {
        stopForeground(true);
        stopSelf();
        CentralLog.Companion.w(TAG, "Service Stopping");
    }

    private final void actionHealthCheck() {
        Utils utils = Utils.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
        utils.scheduleNextHealthCheck(applicationContext, 900000);
        performHealthCheck();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0040, code lost:
        if (r0.needToUpdate(r2) == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void actionStart() {
        /*
            r6 = this;
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            r1 = r6
            android.content.Context r1 = (android.content.Context) r1
            boolean r0 = r0.isOnBoarded(r1)
            if (r0 == 0) goto L_0x007a
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r2 = "BTMService"
            java.lang.String r3 = "Service Starting "
            r0.d(r2, r3)
            r0 = 771579(0xbc5fb, float:1.081212E-39)
            au.gov.health.covidsafe.notifications.NotificationTemplates$Companion r2 = au.gov.health.covidsafe.notifications.NotificationTemplates.Companion
            android.content.Context r3 = r6.getApplicationContext()
            java.lang.String r4 = "this.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.lang.String r5 = "COVIDSafe Updates"
            android.app.Notification r2 = r2.getRunningNotification(r3, r5)
            r6.startForeground(r0, r2)
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            boolean r0 = r0.isOnBoarded(r1)
            if (r0 == 0) goto L_0x0042
            au.gov.health.covidsafe.Utils r0 = au.gov.health.covidsafe.Utils.INSTANCE
            android.content.Context r2 = r6.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            boolean r0 = r0.needToUpdate(r2)
            if (r0 != 0) goto L_0x0046
        L_0x0042:
            java.lang.String r0 = broadcastMessage
            if (r0 != 0) goto L_0x006f
        L_0x0046:
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r0 = new au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff
            au.gov.health.covidsafe.networking.service.AwsClient r1 = r6.awsClient
            android.content.Context r2 = r6.getApplicationContext()
            java.lang.String r3 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            androidx.lifecycle.Lifecycle r3 = r6.getLifecycle()
            java.lang.String r4 = "lifecycle"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r0.<init>(r1, r2, r3)
            r1 = 0
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionStart$1 r2 = new au.gov.health.covidsafe.services.BluetoothMonitoringService$actionStart$1
            r2.<init>(r6)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionStart$2 r3 = au.gov.health.covidsafe.services.BluetoothMonitoringService$actionStart$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0.invoke(r1, r2, r3)
            goto L_0x007a
        L_0x006f:
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            boolean r0 = r0.isOnBoarded(r1)
            if (r0 == 0) goto L_0x007a
            r6.setupCycles()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.services.BluetoothMonitoringService.actionStart():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0032, code lost:
        if (r0.needToUpdate(r3) == false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void actionUpdateBm() {
        /*
            r5 = this;
            au.gov.health.covidsafe.Utils r0 = au.gov.health.covidsafe.Utils.INSTANCE
            android.content.Context r1 = r5.getApplicationContext()
            java.lang.String r2 = "this.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r3 = 540000(0x83d60, double:2.667954E-318)
            r0.scheduleBMUpdateCheck(r1, r3)
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r1 = "BTMService"
            java.lang.String r3 = "checking need to update BM"
            r0.i(r1, r3)
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            r3 = r5
            android.content.Context r3 = (android.content.Context) r3
            boolean r0 = r0.isOnBoarded(r3)
            if (r0 == 0) goto L_0x0034
            au.gov.health.covidsafe.Utils r0 = au.gov.health.covidsafe.Utils.INSTANCE
            android.content.Context r3 = r5.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r2)
            boolean r0 = r0.needToUpdate(r3)
            if (r0 != 0) goto L_0x0038
        L_0x0034:
            java.lang.String r0 = broadcastMessage
            if (r0 != 0) goto L_0x005e
        L_0x0038:
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r0 = new au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff
            au.gov.health.covidsafe.networking.service.AwsClient r1 = r5.awsClient
            android.content.Context r2 = r5.getApplicationContext()
            java.lang.String r3 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            androidx.lifecycle.Lifecycle r3 = r5.getLifecycle()
            java.lang.String r4 = "lifecycle"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r0.<init>(r1, r2, r3)
            r1 = 0
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionUpdateBm$1 r2 = au.gov.health.covidsafe.services.BluetoothMonitoringService$actionUpdateBm$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionUpdateBm$2 r3 = au.gov.health.covidsafe.services.BluetoothMonitoringService$actionUpdateBm$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0.invoke(r1, r2, r3)
            goto L_0x0065
        L_0x005e:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            java.lang.String r2 = "Don't need to update bm"
            r0.i(r1, r2)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.services.BluetoothMonitoringService.actionUpdateBm():void");
    }

    private final long calcPhaseShift(long j, long j2) {
        return (long) (((double) j) + (Math.random() * ((double) (j2 - j))));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001a, code lost:
        if (r0.needToUpdate(r2) == false) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void actionScan() {
        /*
            r5 = this;
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1
            boolean r0 = r0.isOnBoarded(r1)
            if (r0 == 0) goto L_0x001c
            au.gov.health.covidsafe.Utils r0 = au.gov.health.covidsafe.Utils.INSTANCE
            android.content.Context r2 = r5.getApplicationContext()
            java.lang.String r3 = "this.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            boolean r0 = r0.needToUpdate(r2)
            if (r0 != 0) goto L_0x0020
        L_0x001c:
            java.lang.String r0 = broadcastMessage
            if (r0 != 0) goto L_0x0049
        L_0x0020:
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r0 = new au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff
            au.gov.health.covidsafe.networking.service.AwsClient r1 = r5.awsClient
            android.content.Context r2 = r5.getApplicationContext()
            java.lang.String r3 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            androidx.lifecycle.Lifecycle r3 = r5.getLifecycle()
            java.lang.String r4 = "lifecycle"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r0.<init>(r1, r2, r3)
            r1 = 0
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionScan$1 r2 = new au.gov.health.covidsafe.services.BluetoothMonitoringService$actionScan$1
            r2.<init>(r5)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            au.gov.health.covidsafe.services.BluetoothMonitoringService$actionScan$2 r3 = au.gov.health.covidsafe.services.BluetoothMonitoringService$actionScan$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0.invoke(r1, r2, r3)
            goto L_0x0054
        L_0x0049:
            au.gov.health.covidsafe.Preference r0 = au.gov.health.covidsafe.Preference.INSTANCE
            boolean r0 = r0.isOnBoarded(r1)
            if (r0 == 0) goto L_0x0054
            r5.performScanAndScheduleNextScan()
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.services.BluetoothMonitoringService.actionScan():void");
    }

    private final void actionAdvertise() {
        setupAdvertiser();
        if (isBluetoothEnabled()) {
            BLEAdvertiser bLEAdvertiser = this.advertiser;
            if (bLEAdvertiser != null) {
                bLEAdvertiser.startAdvertising(180000);
            }
        } else {
            CentralLog.Companion.w(TAG, "Unable to start advertising, bluetooth is off");
        }
        CommandHandler commandHandler2 = this.commandHandler;
        if (commandHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
        }
        commandHandler2.scheduleNextAdvertise(185000);
    }

    private final void setupService() {
        StreetPassServer streetPassServer2 = this.streetPassServer;
        if (streetPassServer2 == null) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
            String str = this.serviceUUID;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceUUID");
            }
            streetPassServer2 = new StreetPassServer(applicationContext, str);
        }
        this.streetPassServer = streetPassServer2;
        setupScanner();
        setupAdvertiser();
    }

    private final void setupScanner() {
        StreetPassScanner streetPassScanner2 = this.streetPassScanner;
        if (streetPassScanner2 == null) {
            Context context = this;
            String str = this.serviceUUID;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceUUID");
            }
            streetPassScanner2 = new StreetPassScanner(context, str, 8000);
        }
        this.streetPassScanner = streetPassScanner2;
    }

    private final void setupAdvertiser() {
        BLEAdvertiser bLEAdvertiser = this.advertiser;
        if (bLEAdvertiser == null) {
            String str = this.serviceUUID;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceUUID");
            }
            bLEAdvertiser = new BLEAdvertiser(str);
        }
        this.advertiser = bLEAdvertiser;
    }

    /* access modifiers changed from: private */
    public final void setupCycles() {
        setupScanCycles();
        setupAdvertisingCycles();
    }

    private final void setupScanCycles() {
        actionScan();
    }

    private final void setupAdvertisingCycles() {
        actionAdvertise();
    }

    /* access modifiers changed from: private */
    public final void performScanAndScheduleNextScan() {
        setupScanner();
        CommandHandler commandHandler2 = this.commandHandler;
        if (commandHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
        }
        commandHandler2.scheduleNextScan(calcPhaseShift(36000, 43000) + 8000);
        startScan();
    }

    private final void startScan() {
        if (isBluetoothEnabled()) {
            StreetPassScanner streetPassScanner2 = this.streetPassScanner;
            if (streetPassScanner2 == null) {
                return;
            }
            if (!streetPassScanner2.isScanning()) {
                streetPassScanner2.startScan();
            } else {
                CentralLog.Companion.e(TAG, "Already scanning!");
            }
        } else {
            CentralLog.Companion.w(TAG, "Unable to start scan - bluetooth is off");
        }
    }

    private final void performHealthCheck() {
        CentralLog.Companion.i(TAG, "Performing self diagnosis");
        if (!hasLocationPermissions() || !isBluetoothEnabled()) {
            CentralLog.Companion.i(TAG, "no location permission");
            NotificationTemplates.Companion companion = NotificationTemplates.Companion;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this.applicationContext");
            startForeground(771579, companion.lackingThingsNotification(applicationContext, "COVIDSafe Updates"));
            return;
        }
        NotificationTemplates.Companion companion2 = NotificationTemplates.Companion;
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "this.applicationContext");
        startForeground(771579, companion2.getRunningNotification(applicationContext2, "COVIDSafe Updates"));
        setupService();
        CommandHandler commandHandler2 = this.commandHandler;
        if (commandHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
        }
        if (!commandHandler2.hasScanScheduled()) {
            CentralLog.Companion.w(TAG, "Missing Scan Schedule - rectifying");
            setupScanCycles();
        } else {
            CentralLog.Companion.w(TAG, "Scan Schedule present");
        }
        CommandHandler commandHandler3 = this.commandHandler;
        if (commandHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commandHandler");
        }
        if (!commandHandler3.hasAdvertiseScheduled()) {
            CentralLog.Companion.w(TAG, "Missing Advertise Schedule - rectifying");
            setupAdvertisingCycles();
            return;
        }
        CentralLog.Companion companion3 = CentralLog.Companion;
        StringBuilder sb = new StringBuilder();
        sb.append("Advertise Schedule present. Should be advertising?:  ");
        BLEAdvertiser bLEAdvertiser = this.advertiser;
        boolean z = false;
        sb.append(bLEAdvertiser != null ? bLEAdvertiser.getShouldBeAdvertising() : false);
        sb.append(". Is Advertising?: ");
        BLEAdvertiser bLEAdvertiser2 = this.advertiser;
        if (bLEAdvertiser2 != null) {
            z = bLEAdvertiser2.isAdvertising();
        }
        sb.append(z);
        companion3.w(TAG, sb.toString());
    }

    public void onDestroy() {
        super.onDestroy();
        CentralLog.Companion.i(TAG, "BluetoothMonitoringService destroyed - tearing down");
        teardown();
        unregisterReceivers();
        StreetPassWorker streetPassWorker = this.worker;
        if (streetPassWorker != null) {
            streetPassWorker.terminateConnections();
        }
        StreetPassWorker streetPassWorker2 = this.worker;
        if (streetPassWorker2 != null) {
            streetPassWorker2.unregisterReceivers();
        }
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        unbindService(this.connection);
        this.mBound = false;
        CentralLog.Companion.i(TAG, "BluetoothMonitoringService destroyed");
    }

    private final void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter(GATTKt.ACTION_RECEIVED_STREETPASS);
        LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
        if (localBroadcastManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
        }
        localBroadcastManager2.registerReceiver(this.streetPassReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter(GATTKt.ACTION_RECEIVED_STATUS);
        LocalBroadcastManager localBroadcastManager3 = this.localBroadcastManager;
        if (localBroadcastManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
        }
        localBroadcastManager3.registerReceiver(this.statusReceiver, intentFilter2);
        registerReceiver(this.bluetoothStatusReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        CentralLog.Companion.i(TAG, "Receivers registered");
    }

    private final void unregisterReceivers() {
        try {
            LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
            if (localBroadcastManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            }
            localBroadcastManager2.unregisterReceiver(this.streetPassReceiver);
        } catch (Throwable unused) {
            CentralLog.Companion.w(TAG, "streetPassReceiver is not registered?");
        }
        try {
            LocalBroadcastManager localBroadcastManager3 = this.localBroadcastManager;
            if (localBroadcastManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            }
            localBroadcastManager3.unregisterReceiver(this.statusReceiver);
        } catch (Throwable unused2) {
            CentralLog.Companion.w(TAG, "statusReceiver is not registered?");
        }
        try {
            unregisterReceiver(this.bluetoothStatusReceiver);
        } catch (Throwable unused3) {
            CentralLog.Companion.w(TAG, "bluetoothStatusReceiver is not registered?");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$BluetoothStatusReceiver;", "Landroid/content/BroadcastReceiver;", "(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothMonitoringService.kt */
    public final class BluetoothStatusReceiver extends BroadcastReceiver {
        public BluetoothStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.bluetooth.adapter.action.STATE_CHANGED")) {
                switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)) {
                    case 10:
                        CentralLog.Companion.d(BluetoothMonitoringService.TAG, "BluetoothAdapter.STATE_OFF");
                        return;
                    case 11:
                        CentralLog.Companion.d(BluetoothMonitoringService.TAG, "BluetoothAdapter.STATE_TURNING_ON");
                        return;
                    case 12:
                        CentralLog.Companion.d(BluetoothMonitoringService.TAG, "BluetoothAdapter.STATE_ON");
                        Utils utils = Utils.INSTANCE;
                        Context applicationContext = BluetoothMonitoringService.this.getApplicationContext();
                        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "this@BluetoothMonitoringService.applicationContext");
                        utils.startBluetoothMonitoringService(applicationContext);
                        return;
                    case 13:
                        CentralLog.Companion.d(BluetoothMonitoringService.TAG, "BluetoothAdapter.STATE_TURNING_OFF");
                        NotificationTemplates.Companion companion = NotificationTemplates.Companion;
                        Context applicationContext2 = BluetoothMonitoringService.this.getApplicationContext();
                        Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "this@BluetoothMonitoringService.applicationContext");
                        BluetoothMonitoringService.this.startForeground(771579, companion.lackingThingsNotification(applicationContext2, "COVIDSafe Updates"));
                        BluetoothMonitoringService.this.teardown();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StreetPassReceiver;", "Landroid/content/BroadcastReceiver;", "(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothMonitoringService.kt */
    public final class StreetPassReceiver extends BroadcastReceiver {
        /* access modifiers changed from: private */
        public final String TAG = "StreetPassReceiver";

        public StreetPassReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intent intent2 = intent;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent2, "intent");
            if (Intrinsics.areEqual((Object) GATTKt.ACTION_RECEIVED_STREETPASS, (Object) intent.getAction())) {
                Parcelable parcelableExtra = intent2.getParcelableExtra(GATTKt.STREET_PASS);
                Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtra(STREET_PASS)");
                ConnectionRecord connectionRecord = (ConnectionRecord) parcelableExtra;
                CentralLog.Companion companion = CentralLog.Companion;
                String str = this.TAG;
                companion.d(str, "StreetPass received: " + connectionRecord);
                if (connectionRecord.getMsg().length() > 0) {
                    if (BluetoothMonitoringService.this.mBound) {
                        float proximity = BluetoothMonitoringService.access$getMService$p(BluetoothMonitoringService.this).getProximity();
                        float light = BluetoothMonitoringService.access$getMService$p(BluetoothMonitoringService.this).getLight();
                        CentralLog.Companion companion2 = CentralLog.Companion;
                        String str2 = this.TAG;
                        companion2.d(str2, "Sensor values just before saving StreetPassRecord: proximity=" + proximity + " light=" + light);
                    }
                    Job unused = BuildersKt__Builders_commonKt.launch$default(BluetoothMonitoringService.this, (CoroutineContext) null, (CoroutineStart) null, new BluetoothMonitoringService$StreetPassReceiver$onReceive$1(this, new StreetPassRecord(connectionRecord.getVersion(), connectionRecord.getMsg(), connectionRecord.getOrg(), connectionRecord.getPeripheral().getModelP(), connectionRecord.getCentral().getModelC(), connectionRecord.getRssi(), connectionRecord.getTxPower()), (Continuation) null), 3, (Object) null);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$StatusReceiver;", "Landroid/content/BroadcastReceiver;", "(Lau/gov/health/covidsafe/services/BluetoothMonitoringService;)V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothMonitoringService.kt */
    public final class StatusReceiver extends BroadcastReceiver {
        private final String TAG = "StatusReceiver";

        public StatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (Intrinsics.areEqual((Object) GATTKt.ACTION_RECEIVED_STATUS, (Object) intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra(GATTKt.STATUS);
                Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtra(STATUS)");
                Status status = (Status) parcelableExtra;
                CentralLog.Companion companion = CentralLog.Companion;
                String str = this.TAG;
                companion.d(str, "Status received: " + status.getMsg());
                if (status.getMsg().length() > 0) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(BluetoothMonitoringService.this, (CoroutineContext) null, (CoroutineStart) null, new BluetoothMonitoringService$StatusReceiver$onReceive$1(this, new StatusRecord(status.getMsg()), (Continuation) null), 3, (Object) null);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;", "", "index", "", "string", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getIndex", "()I", "getString", "()Ljava/lang/String;", "INVALID", "ACTION_START", "ACTION_SCAN", "ACTION_STOP", "ACTION_ADVERTISE", "ACTION_SELF_CHECK", "ACTION_UPDATE_BM", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothMonitoringService.kt */
    public enum Command {
        INVALID(-1, "INVALID"),
        ACTION_START(0, "START"),
        ACTION_SCAN(1, "SCAN"),
        ACTION_STOP(2, "STOP"),
        ACTION_ADVERTISE(3, "ADVERTISE"),
        ACTION_SELF_CHECK(4, "SELF_CHECK"),
        ACTION_UPDATE_BM(5, "UPDATE_BM");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public static final Map<Integer, Command> types = null;
        private final int index;
        private final String string;

        private Command(int i, String str) {
            this.index = i;
            this.string = str;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getString() {
            return this.string;
        }

        static {
            int i;
            Companion = new Companion((DefaultConstructorMarker) null);
            Command[] values = values();
            Map<Integer, Command> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (Command command : values) {
                Pair pair = TuplesKt.to(Integer.valueOf(command.index), command);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            types = linkedHashMap;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command$Companion;", "", "()V", "types", "", "", "Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Command;", "findByValue", "value", "app_release"}, k = 1, mv = {1, 1, 16})
        /* compiled from: BluetoothMonitoringService.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Command findByValue(int i) {
                return (Command) Command.types.get(Integer.valueOf(i));
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lau/gov/health/covidsafe/services/BluetoothMonitoringService$Companion;", "", "()V", "CHANNEL_ID", "", "CHANNEL_SERVICE", "COMMAND_KEY", "DAILY_UPLOAD_NOTIFICATION_CODE", "", "NOTIFICATION_ID", "PENDING_ACTIVITY", "PENDING_ADVERTISE_REQ_CODE", "PENDING_BM_UPDATE", "PENDING_HEALTH_CHECK_CODE", "PENDING_PRIVACY_CLEANER_CODE", "PENDING_SCAN_REQ_CODE", "PENDING_START", "PENDING_WIZARD_REQ_CODE", "TAG", "advertisingDuration", "", "advertisingGap", "blacklistDuration", "bmCheckInterval", "broadcastMessage", "getBroadcastMessage", "()Ljava/lang/String;", "setBroadcastMessage", "(Ljava/lang/String;)V", "connectionTimeout", "healthCheckInterval", "maxQueueTime", "maxScanInterval", "minScanInterval", "scanDuration", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BluetoothMonitoringService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getBroadcastMessage() {
            return BluetoothMonitoringService.broadcastMessage;
        }

        public final void setBroadcastMessage(String str) {
            BluetoothMonitoringService.broadcastMessage = str;
        }
    }
}
