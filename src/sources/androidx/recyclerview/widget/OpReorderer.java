package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i, int i2) {
        AdapterHelper.UpdateOp updateOp = list.get(i);
        AdapterHelper.UpdateOp updateOp2 = list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 == 1) {
            swapMoveAdd(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 2) {
            swapMoveRemove(list, i, updateOp, i2, updateOp2);
        } else if (i3 == 4) {
            swapMoveUpdate(list, i, updateOp, i2, updateOp2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveRemove(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.positionStart
            int r1 = r11.itemCount
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001b
            int r0 = r13.positionStart
            int r1 = r11.positionStart
            if (r0 != r1) goto L_0x0019
            int r0 = r13.itemCount
            int r1 = r11.itemCount
            int r4 = r11.positionStart
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x0019
            r0 = 0
            goto L_0x002c
        L_0x0019:
            r0 = 0
            goto L_0x002f
        L_0x001b:
            int r0 = r13.positionStart
            int r1 = r11.itemCount
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.itemCount
            int r1 = r11.positionStart
            int r4 = r11.itemCount
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
        L_0x002c:
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.itemCount
            int r4 = r13.positionStart
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.positionStart
            int r1 = r1 - r3
            r13.positionStart = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.itemCount
            int r4 = r13.positionStart
            int r6 = r13.itemCount
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.itemCount
            int r10 = r10 - r3
            r13.itemCount = r10
            r11.cmd = r5
            r11.itemCount = r3
            int r10 = r13.itemCount
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            androidx.recyclerview.widget.OpReorderer$Callback r9 = r8.mCallback
            r9.recycleUpdateOp(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.positionStart
            int r4 = r13.positionStart
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.positionStart
            int r1 = r1 + r3
            r13.positionStart = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.positionStart
            int r4 = r13.positionStart
            int r7 = r13.itemCount
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.positionStart
            int r4 = r13.itemCount
            int r1 = r1 + r4
            int r4 = r11.positionStart
            int r1 = r1 - r4
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.mCallback
            int r7 = r11.positionStart
            int r7 = r7 + r3
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r6 = r4.obtainUpdateOp(r5, r7, r1, r6)
            int r1 = r11.positionStart
            int r3 = r13.positionStart
            int r1 = r1 - r3
            r13.itemCount = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            androidx.recyclerview.widget.OpReorderer$Callback r9 = r8.mCallback
            r9.recycleUpdateOp(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00d0
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.positionStart
            int r1 = r6.positionStart
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.positionStart
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r11.positionStart = r0
        L_0x00a8:
            int r0 = r11.itemCount
            int r1 = r6.positionStart
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.itemCount
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r11.itemCount = r0
        L_0x00b5:
            int r0 = r11.positionStart
            int r1 = r13.positionStart
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.positionStart
            int r1 = r13.itemCount
            int r0 = r0 - r1
            r11.positionStart = r0
        L_0x00c2:
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            if (r0 <= r1) goto L_0x0106
            int r0 = r11.itemCount
            int r1 = r13.itemCount
            int r0 = r0 - r1
            r11.itemCount = r0
            goto L_0x0106
        L_0x00d0:
            if (r6 == 0) goto L_0x00ec
            int r0 = r11.positionStart
            int r1 = r6.positionStart
            if (r0 < r1) goto L_0x00df
            int r0 = r11.positionStart
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r11.positionStart = r0
        L_0x00df:
            int r0 = r11.itemCount
            int r1 = r6.positionStart
            if (r0 < r1) goto L_0x00ec
            int r0 = r11.itemCount
            int r1 = r6.itemCount
            int r0 = r0 - r1
            r11.itemCount = r0
        L_0x00ec:
            int r0 = r11.positionStart
            int r1 = r13.positionStart
            if (r0 < r1) goto L_0x00f9
            int r0 = r11.positionStart
            int r1 = r13.itemCount
            int r0 = r0 - r1
            r11.positionStart = r0
        L_0x00f9:
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            if (r0 < r1) goto L_0x0106
            int r0 = r11.itemCount
            int r1 = r13.itemCount
            int r0 = r0 - r1
            r11.itemCount = r0
        L_0x0106:
            r9.set(r10, r13)
            int r13 = r11.positionStart
            int r0 = r11.itemCount
            if (r13 == r0) goto L_0x0113
            r9.set(r12, r11)
            goto L_0x0116
        L_0x0113:
            r9.remove(r12)
        L_0x0116:
            if (r6 == 0) goto L_0x011b
            r9.add(r10, r6)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveRemove(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i, AdapterHelper.UpdateOp updateOp, int i2, AdapterHelper.UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r8, int r9, androidx.recyclerview.widget.AdapterHelper.UpdateOp r10, int r11, androidx.recyclerview.widget.AdapterHelper.UpdateOp r12) {
        /*
            r7 = this;
            int r0 = r10.itemCount
            int r1 = r12.positionStart
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.positionStart
            int r0 = r0 - r4
            r12.positionStart = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.itemCount
            int r1 = r12.positionStart
            int r5 = r12.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.itemCount
            int r0 = r0 - r4
            r12.itemCount = r0
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r7.mCallback
            int r1 = r10.positionStart
            java.lang.Object r5 = r12.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.positionStart
            int r5 = r12.positionStart
            if (r1 > r5) goto L_0x0035
            int r1 = r12.positionStart
            int r1 = r1 + r4
            r12.positionStart = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.positionStart
            int r5 = r12.positionStart
            int r6 = r12.itemCount
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.positionStart
            int r3 = r12.itemCount
            int r1 = r1 + r3
            int r3 = r10.positionStart
            int r1 = r1 - r3
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r7.mCallback
            int r5 = r10.positionStart
            int r5 = r5 + r4
            java.lang.Object r4 = r12.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r5, r1, r4)
            int r2 = r12.itemCount
            int r2 = r2 - r1
            r12.itemCount = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.itemCount
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            androidx.recyclerview.widget.OpReorderer$Callback r10 = r7.mCallback
            r10.recycleUpdateOp(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}
