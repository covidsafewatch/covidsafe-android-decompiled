package au.gov.health.covidsafe.streetpass;

import au.gov.health.covidsafe.streetpass.Work;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"au/gov/health/covidsafe/streetpass/StreetPassWorker$onWorkTimeoutListener$1", "Lau/gov/health/covidsafe/streetpass/Work$OnWorkTimeoutListener;", "onWorkTimeout", "", "work", "Lau/gov/health/covidsafe/streetpass/Work;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: StreetPassWorker.kt */
public final class StreetPassWorker$onWorkTimeoutListener$1 implements Work.OnWorkTimeoutListener {
    final /* synthetic */ StreetPassWorker this$0;

    StreetPassWorker$onWorkTimeoutListener$1(StreetPassWorker streetPassWorker) {
        this.this$0 = streetPassWorker;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x00e9, code lost:
        r3 = r3.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onWorkTimeout(au.gov.health.covidsafe.streetpass.Work r8) {
        /*
            r7 = this;
            java.lang.String r0 = "work"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0
            android.bluetooth.BluetoothDevice r1 = r8.getDevice()
            java.lang.String r1 = r1.getAddress()
            boolean r0 = r0.isCurrentlyWorkedOn(r1)
            if (r0 != 0) goto L_0x0022
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r7.this$0
            java.lang.String r1 = r1.TAG
            java.lang.String r2 = "Work already removed. Timeout ineffective??."
            r0.i(r1, r2)
        L_0x0022:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r7.this$0
            java.lang.String r1 = r1.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Work timed out for "
            r2.append(r3)
            android.bluetooth.BluetoothDevice r3 = r8.getDevice()
            java.lang.String r3 = r3.getAddress()
            r2.append(r3)
            java.lang.String r3 = " @ "
            r2.append(r3)
            au.gov.health.covidsafe.streetpass.ConnectablePeripheral r3 = r8.getConnectable()
            int r3 = r3.getRssi()
            r2.append(r3)
            java.lang.String r3 = " queued for "
            r2.append(r3)
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r3 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r3 = r3.getStarted()
            long r3 = r3.getTimePerformed()
            long r5 = r8.getTimeStamp()
            long r3 = r3 - r5
            r2.append(r3)
            java.lang.String r3 = "ms"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r1 = r7.this$0
            java.lang.String r1 = r1.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.bluetooth.BluetoothDevice r3 = r8.getDevice()
            java.lang.String r3 = r3.getAddress()
            r2.append(r3)
            java.lang.String r3 = " work status: "
            r2.append(r3)
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r3 = r8.getChecklist()
            r2.append(r3)
            r3 = 46
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.e(r1, r2)
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getConnected()
            boolean r0 = r0.getStatus()
            java.lang.String r1 = ": "
            r2 = 0
            if (r0 != 0) goto L_0x0142
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r3 = r7.this$0
            java.lang.String r3 = r3.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "No connection formed for "
            r4.append(r5)
            android.bluetooth.BluetoothDevice r5 = r8.getDevice()
            java.lang.String r5 = r5.getAddress()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.e(r3, r4)
            android.bluetooth.BluetoothDevice r0 = r8.getDevice()
            java.lang.String r0 = r0.getAddress()
            au.gov.health.covidsafe.streetpass.StreetPassWorker r3 = r7.this$0
            au.gov.health.covidsafe.streetpass.Work r3 = r3.currentPendingConnection
            if (r3 == 0) goto L_0x00f4
            android.bluetooth.BluetoothDevice r3 = r3.getDevice()
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r3.getAddress()
            goto L_0x00f5
        L_0x00f4:
            r3 = r2
        L_0x00f5:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0102
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0
            au.gov.health.covidsafe.streetpass.Work r2 = (au.gov.health.covidsafe.streetpass.Work) r2
            r0.currentPendingConnection = r2
        L_0x0102:
            android.bluetooth.BluetoothGatt r0 = r8.getGatt()     // Catch:{ Exception -> 0x010c }
            if (r0 == 0) goto L_0x013b
            r0.close()     // Catch:{ Exception -> 0x010c }
            goto L_0x013b
        L_0x010c:
            r0 = move-exception
            au.gov.health.covidsafe.logging.CentralLog$Companion r2 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r3 = r7.this$0
            java.lang.String r3 = r3.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unexpected error while attempting to close clientIf to "
            r4.append(r5)
            android.bluetooth.BluetoothDevice r5 = r8.getDevice()
            java.lang.String r5 = r5.getAddress()
            r4.append(r5)
            r4.append(r1)
            java.lang.String r0 = r0.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.e(r3, r0)
        L_0x013b:
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0
            r0.finishWork(r8)
            goto L_0x027b
        L_0x0142:
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getConnected()
            boolean r0 = r0.getStatus()
            if (r0 == 0) goto L_0x024d
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getDisconnected()
            boolean r0 = r0.getStatus()
            if (r0 != 0) goto L_0x024d
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getReadCharacteristic()
            boolean r0 = r0.getStatus()
            java.lang.String r1 = "Failed to clean up work, bluetooth state likely changed or other device's advertiser stopped: "
            if (r0 != 0) goto L_0x01ed
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getWriteCharacteristic()
            boolean r0 = r0.getStatus()
            if (r0 != 0) goto L_0x01ed
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r0 = r8.getChecklist()
            au.gov.health.covidsafe.streetpass.Work$Check r0 = r0.getSkipped()
            boolean r0 = r0.getStatus()
            if (r0 == 0) goto L_0x018b
            goto L_0x01ed
        L_0x018b:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r3 = r7.this$0
            java.lang.String r3 = r3.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Connected but did nothing for "
            r4.append(r5)
            android.bluetooth.BluetoothDevice r5 = r8.getDevice()
            java.lang.String r5 = r5.getAddress()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.e(r3, r4)
            android.bluetooth.BluetoothGatt r0 = r8.getGatt()     // Catch:{ all -> 0x01cc }
            if (r0 == 0) goto L_0x01b8
            r0.disconnect()     // Catch:{ all -> 0x01cc }
        L_0x01b8:
            android.bluetooth.BluetoothGatt r0 = r8.getGatt()     // Catch:{ all -> 0x01cc }
            if (r0 != 0) goto L_0x027b
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0     // Catch:{ all -> 0x01cc }
            au.gov.health.covidsafe.streetpass.Work r2 = (au.gov.health.covidsafe.streetpass.Work) r2     // Catch:{ all -> 0x01cc }
            r0.currentPendingConnection = r2     // Catch:{ all -> 0x01cc }
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0     // Catch:{ all -> 0x01cc }
            r0.finishWork(r8)     // Catch:{ all -> 0x01cc }
            goto L_0x027b
        L_0x01cc:
            r8 = move-exception
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r2 = r7.this$0
            java.lang.String r2 = r2.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.getLocalizedMessage()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.e(r2, r8)
            goto L_0x027b
        L_0x01ed:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r3 = r7.this$0
            java.lang.String r3 = r3.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Connected but did not disconnect in time for "
            r4.append(r5)
            android.bluetooth.BluetoothDevice r5 = r8.getDevice()
            java.lang.String r5 = r5.getAddress()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.e(r3, r4)
            android.bluetooth.BluetoothGatt r0 = r8.getGatt()     // Catch:{ all -> 0x022d }
            if (r0 == 0) goto L_0x021a
            r0.disconnect()     // Catch:{ all -> 0x022d }
        L_0x021a:
            android.bluetooth.BluetoothGatt r0 = r8.getGatt()     // Catch:{ all -> 0x022d }
            if (r0 != 0) goto L_0x027b
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0     // Catch:{ all -> 0x022d }
            au.gov.health.covidsafe.streetpass.Work r2 = (au.gov.health.covidsafe.streetpass.Work) r2     // Catch:{ all -> 0x022d }
            r0.currentPendingConnection = r2     // Catch:{ all -> 0x022d }
            au.gov.health.covidsafe.streetpass.StreetPassWorker r0 = r7.this$0     // Catch:{ all -> 0x022d }
            r0.finishWork(r8)     // Catch:{ all -> 0x022d }
            goto L_0x027b
        L_0x022d:
            r8 = move-exception
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r2 = r7.this$0
            java.lang.String r2 = r2.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r8 = r8.getLocalizedMessage()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.e(r2, r8)
            goto L_0x027b
        L_0x024d:
            au.gov.health.covidsafe.logging.CentralLog$Companion r0 = au.gov.health.covidsafe.logging.CentralLog.Companion
            au.gov.health.covidsafe.streetpass.StreetPassWorker r2 = r7.this$0
            java.lang.String r2 = r2.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Disconnected but callback not invoked in time. Waiting.: "
            r3.append(r4)
            android.bluetooth.BluetoothDevice r4 = r8.getDevice()
            java.lang.String r4 = r4.getAddress()
            r3.append(r4)
            r3.append(r1)
            au.gov.health.covidsafe.streetpass.Work$WorkCheckList r8 = r8.getChecklist()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.e(r2, r8)
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.streetpass.StreetPassWorker$onWorkTimeoutListener$1.onWorkTimeout(au.gov.health.covidsafe.streetpass.Work):void");
    }
}
