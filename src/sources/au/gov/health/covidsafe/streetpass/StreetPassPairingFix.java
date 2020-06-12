package au.gov.health.covidsafe.streetpass;

import android.bluetooth.BluetoothGatt;
import au.gov.health.covidsafe.logging.CentralLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lau/gov/health/covidsafe/streetpass/StreetPassPairingFix;", "", "()V", "TAG", "", "bluetoothGattClass", "Ljava/lang/Class;", "Landroid/bluetooth/BluetoothGatt;", "initComplete", "", "initFailed", "mAuthRetryField", "Ljava/lang/reflect/Field;", "mAuthRetryStateField", "bypassAuthenticationRetry", "", "gatt", "tryInit", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassPairingFix.kt */
public final class StreetPassPairingFix {
    public static final StreetPassPairingFix INSTANCE = new StreetPassPairingFix();
    private static final String TAG = "StreetPassPairingFix";
    private static Class<BluetoothGatt> bluetoothGattClass = BluetoothGatt.class;
    private static boolean initComplete;
    private static boolean initFailed;
    private static Field mAuthRetryField;
    private static Field mAuthRetryStateField;

    private StreetPassPairingFix() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2 = au.gov.health.covidsafe.logging.CentralLog.Companion;
        r2.i(TAG, "Encountered Exception while initialising: " + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0099, code lost:
        r2 = au.gov.health.covidsafe.logging.CentralLog.Companion;
        r2.i(TAG, "Encountered NPE while initialising: " + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b6, code lost:
        r2 = au.gov.health.covidsafe.logging.CentralLog.Companion;
        r2.i(TAG, "Encountered sandbox exception while initialising: " + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        r2 = au.gov.health.covidsafe.logging.CentralLog.Companion;
        r2.i(TAG, "Unable to find field while initialising: " + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f0, code lost:
        au.gov.health.covidsafe.logging.CentralLog.Companion.i(TAG, "Failed to initialise, bypassAuthenticationRetry will quietly fail");
        initComplete = true;
        initFailed = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0100, code lost:
        return !true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[ExcHandler: RuntimeException (r0v25 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:17:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b A[ExcHandler: NullPointerException (r0v22 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:17:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d A[ExcHandler: SecurityException (r0v19 'e' java.lang.SecurityException A[CUSTOM_DECLARE]), Splitter:B:17:0x0035] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0101=Splitter:B:38:0x0101, B:15:0x002c=Splitter:B:15:0x002c, B:22:0x004f=Splitter:B:22:0x004f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean tryInit() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = initFailed     // Catch:{ all -> 0x0106 }
            r1 = 1
            if (r0 != 0) goto L_0x0101
            boolean r0 = initComplete     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0101
        L_0x000c:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0106 }
            r2 = 28
            if (r0 <= r2) goto L_0x002c
            android.content.pm.ApplicationInfo r0 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x0106 }
            r0.<init>()     // Catch:{ all -> 0x0106 }
            int r0 = r0.targetSdkVersion     // Catch:{ all -> 0x0106 }
            if (r0 <= r2) goto L_0x002c
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Failed to initialise: mAuthRetryState is in restricted grey-list post API 28"
            r0.i(r2, r3)     // Catch:{ all -> 0x0106 }
            initFailed = r1     // Catch:{ all -> 0x0106 }
            initComplete = r1     // Catch:{ all -> 0x0106 }
            r0 = r1 ^ r1
            monitor-exit(r6)
            return r0
        L_0x002c:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Initialising StreetPassParingFix fields"
            r0.i(r2, r3)     // Catch:{ all -> 0x0106 }
            java.lang.Class<android.bluetooth.BluetoothGatt> r0 = bluetoothGattClass     // Catch:{ NoSuchFieldException -> 0x004f, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "mAuthRetryState"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x004f, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            mAuthRetryStateField = r0     // Catch:{ NoSuchFieldException -> 0x004f, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ NoSuchFieldException -> 0x004f, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Found mAuthRetryState"
            r0.i(r2, r3)     // Catch:{ NoSuchFieldException -> 0x004f, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            goto L_0x006b
        L_0x0049:
            r0 = move-exception
            goto L_0x007c
        L_0x004b:
            r0 = move-exception
            goto L_0x0099
        L_0x004d:
            r0 = move-exception
            goto L_0x00b6
        L_0x004f:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "No mAuthRetryState on this device, trying for mAuthRetry"
            r0.i(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.Class<android.bluetooth.BluetoothGatt> r0 = bluetoothGattClass     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "mAuthRetry"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            mAuthRetryField = r0     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Found mAuthRetry"
            r0.i(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
        L_0x006b:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Initialisation complete"
            r0.i(r2, r3)     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            initComplete = r1     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            r0 = 0
            initFailed = r0     // Catch:{ NoSuchFieldException -> 0x00d3, SecurityException -> 0x004d, NullPointerException -> 0x004b, RuntimeException -> 0x0049 }
            r0 = r0 ^ r1
            monitor-exit(r6)
            return r0
        L_0x007c:
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "StreetPassPairingFix"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r4.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "Encountered Exception while initialising: "
            r4.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0106 }
            r4.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0106 }
            r2.i(r3, r0)     // Catch:{ all -> 0x0106 }
            goto L_0x00f0
        L_0x0099:
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "StreetPassPairingFix"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r4.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "Encountered NPE while initialising: "
            r4.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0106 }
            r4.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0106 }
            r2.i(r3, r0)     // Catch:{ all -> 0x0106 }
            goto L_0x00f0
        L_0x00b6:
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "StreetPassPairingFix"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r4.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "Encountered sandbox exception while initialising: "
            r4.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0106 }
            r4.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0106 }
            r2.i(r3, r0)     // Catch:{ all -> 0x0106 }
            goto L_0x00f0
        L_0x00d3:
            r0 = move-exception
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "StreetPassPairingFix"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r4.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r5 = "Unable to find field while initialising: "
            r4.append(r5)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0106 }
            r4.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0106 }
            r2.i(r3, r0)     // Catch:{ all -> 0x0106 }
        L_0x00f0:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "StreetPassPairingFix"
            java.lang.String r3 = "Failed to initialise, bypassAuthenticationRetry will quietly fail"
            r0.i(r2, r3)     // Catch:{ all -> 0x0106 }
            initComplete = r1     // Catch:{ all -> 0x0106 }
            initFailed = r1     // Catch:{ all -> 0x0106 }
            r0 = r1 ^ r1
            monitor-exit(r6)
            return r0
        L_0x0101:
            boolean r0 = initFailed     // Catch:{ all -> 0x0106 }
            r0 = r0 ^ r1
            monitor-exit(r6)
            return r0
        L_0x0106:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassPairingFix.tryInit():boolean");
    }

    public final synchronized void bypassAuthenticationRetry(BluetoothGatt bluetoothGatt) {
        Intrinsics.checkParameterIsNotNull(bluetoothGatt, "gatt");
        if (tryInit()) {
            try {
                if (mAuthRetryStateField != null) {
                    CentralLog.Companion.i(TAG, "Attempting to bypass mAuthRetryState bonding conditional");
                    Field field = mAuthRetryStateField;
                    if (field == null) {
                        Intrinsics.throwNpe();
                    }
                    boolean isAccessible = field.isAccessible();
                    if (!isAccessible) {
                        Field field2 = mAuthRetryStateField;
                        if (field2 == null) {
                            Intrinsics.throwNpe();
                        }
                        field2.setAccessible(true);
                    }
                    Field field3 = mAuthRetryStateField;
                    if (field3 == null) {
                        Intrinsics.throwNpe();
                    }
                    field3.setInt(bluetoothGatt, 2);
                    Field field4 = mAuthRetryStateField;
                    if (field4 == null) {
                        Intrinsics.throwNpe();
                    }
                    field4.setAccessible(isAccessible);
                } else {
                    CentralLog.Companion.i(TAG, "Attempting to bypass mAuthRetry bonding conditional");
                    Field field5 = mAuthRetryField;
                    if (field5 == null) {
                        Intrinsics.throwNpe();
                    }
                    boolean isAccessible2 = field5.isAccessible();
                    if (!isAccessible2) {
                        Field field6 = mAuthRetryField;
                        if (field6 == null) {
                            Intrinsics.throwNpe();
                        }
                        field6.setAccessible(true);
                    }
                    Field field7 = mAuthRetryField;
                    if (field7 == null) {
                        Intrinsics.throwNpe();
                    }
                    field7.setBoolean(bluetoothGatt, true);
                    Field field8 = mAuthRetryField;
                    if (field8 == null) {
                        Intrinsics.throwNpe();
                    }
                    field8.setAccessible(isAccessible2);
                }
            } catch (SecurityException e) {
                CentralLog.Companion companion = CentralLog.Companion;
                companion.i(TAG, "Encountered sandbox exception in bypassAuthenticationRetry: " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                CentralLog.Companion companion2 = CentralLog.Companion;
                companion2.i(TAG, "Encountered argument exception in bypassAuthenticationRetry: " + e2.getMessage());
            } catch (NullPointerException e3) {
                CentralLog.Companion companion3 = CentralLog.Companion;
                companion3.i(TAG, "Encountered NPE in bypassAuthenticationRetry: " + e3.getMessage());
            } catch (ExceptionInInitializerError e4) {
                CentralLog.Companion companion4 = CentralLog.Companion;
                companion4.i(TAG, "Encountered reflection in bypassAuthenticationRetry: " + e4.getMessage());
            }
        }
    }
}
