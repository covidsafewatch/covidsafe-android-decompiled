package au.gov.health.covidsafe.services;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0002 !B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lau/gov/health/covidsafe/services/SensorMonitoringService;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "()V", "_light", "", "_proximity", "binder", "Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;", "light", "", "getLight", "()F", "proximity", "getProximity", "sensorManager", "Landroid/hardware/SensorManager;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "Companion", "LocalBinder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SensorMonitoringService.kt */
public final class SensorMonitoringService extends Service implements SensorEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SENSOR_DELAY_SUPER_SLOW = 3000000;
    public static final String TAG = "SensorMonitoringService";
    private float[] _light;
    private float[] _proximity;
    private final LocalBinder binder = new LocalBinder();
    private SensorManager sensorManager;

    public void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager2 = (SensorManager) systemService;
            this.sensorManager = sensorManager2;
            if (sensorManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
            }
            Sensor defaultSensor = sensorManager2.getDefaultSensor(8);
            SensorManager sensorManager3 = this.sensorManager;
            if (sensorManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
            }
            Sensor defaultSensor2 = sensorManager3.getDefaultSensor(5);
            if (defaultSensor != null) {
                CentralLog.Companion companion = CentralLog.Companion;
                companion.d(TAG, "Proximity sensor: " + defaultSensor);
                SensorManager sensorManager4 = this.sensorManager;
                if (sensorManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
                }
                sensorManager4.registerListener(this, defaultSensor, SENSOR_DELAY_SUPER_SLOW);
            } else {
                CentralLog.Companion.d(TAG, "Proximity sensor not available");
            }
            if (defaultSensor2 != null) {
                CentralLog.Companion companion2 = CentralLog.Companion;
                companion2.d(TAG, "Light sensor: " + defaultSensor2);
                SensorManager sensorManager5 = this.sensorManager;
                if (sensorManager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
                }
                sensorManager5.registerListener(this, defaultSensor2, SENSOR_DELAY_SUPER_SLOW);
            } else {
                CentralLog.Companion.d(TAG, "Light sensor not available");
            }
            CentralLog.Companion.d(TAG, "SensorMonitoringService started");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void onDestroy() {
        SensorManager sensorManager2 = this.sensorManager;
        if (sensorManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sensorManager");
        }
        sensorManager2.unregisterListener(this);
        CentralLog.Companion.d(TAG, "SensorMonitoringService destroyed");
        super.onDestroy();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/services/SensorMonitoringService$LocalBinder;", "Landroid/os/Binder;", "(Lau/gov/health/covidsafe/services/SensorMonitoringService;)V", "getService", "Lau/gov/health/covidsafe/services/SensorMonitoringService;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SensorMonitoringService.kt */
    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public final SensorMonitoringService getService() {
            return SensorMonitoringService.this;
        }
    }

    public IBinder onBind(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        return this.binder;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        CentralLog.Companion companion = CentralLog.Companion;
        companion.d(TAG, "Sensor accuracy changed! " + sensor);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkParameterIsNotNull(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        Sensor sensor = sensorEvent.sensor;
        Intrinsics.checkExpressionValueIsNotNull(sensor, "event.sensor");
        int type = sensor.getType();
        if (type == 5) {
            this._light = sensorEvent.values;
        } else if (type != 8) {
            CentralLog.Companion companion = CentralLog.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected sensor type changed: ");
            Sensor sensor2 = sensorEvent.sensor;
            Intrinsics.checkExpressionValueIsNotNull(sensor2, "event.sensor");
            sb.append(sensor2.getType());
            companion.w(TAG, sb.toString());
        } else {
            this._proximity = sensorEvent.values;
        }
    }

    public final float getProximity() {
        float[] fArr = this._proximity;
        if (fArr == null) {
            return -1.0f;
        }
        if (fArr != null) {
            int i = 1;
            if (!(fArr.length == 0)) {
                float f = fArr[0];
                int lastIndex = ArraysKt.getLastIndex(fArr);
                if (1 <= lastIndex) {
                    while (true) {
                        float f2 = fArr[i];
                        f += f2 * f2;
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                return (float) Math.sqrt((double) f);
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.FloatArray");
    }

    public final float getLight() {
        float[] fArr = this._light;
        if (fArr == null) {
            return -1.0f;
        }
        if (fArr != null) {
            int i = 1;
            if (!(fArr.length == 0)) {
                float f = fArr[0];
                int lastIndex = ArraysKt.getLastIndex(fArr);
                if (1 <= lastIndex) {
                    while (true) {
                        float f2 = fArr[i];
                        f += f2 * f2;
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                return (float) Math.sqrt((double) f);
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.FloatArray");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/services/SensorMonitoringService$Companion;", "", "()V", "SENSOR_DELAY_SUPER_SLOW", "", "TAG", "", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: SensorMonitoringService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
