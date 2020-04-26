package io.reactivex.internal.util;

import java.util.ArrayList;

public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int i) {
        this.capacityHint = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[(this.capacityHint + 1)];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i = this.indexInTail;
        int i2 = this.capacityHint;
        if (i == i2) {
            Object[] objArr2 = new Object[(i2 + 1)];
            objArr2[0] = obj;
            this.tail[i2] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i] = obj;
        this.indexInTail = i + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] head2 = head();
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(head2[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                head2 = (Object[]) head2[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
