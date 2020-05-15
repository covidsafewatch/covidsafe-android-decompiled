package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.capacity = i;
        Object[] objArr = new Object[(i + 1)];
        this.head = objArr;
        this.tail = objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(T r4) {
        /*
            r3 = this;
            int r0 = r3.capacity
            int r1 = r3.offset
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.tail
            r2[r0] = r1
            r3.tail = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.tail
            r0[r1] = r4
            int r1 = r1 + 1
            r3.offset = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.add(java.lang.Object):void");
    }

    public void setFirst(T t) {
        this.head[0] = t;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = objArr[i]) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, subscriber)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, observer)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 != null && !biPredicate.test(s, objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
            objArr = objArr[i];
        }
    }
}
