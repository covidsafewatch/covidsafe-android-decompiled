package com.google.common.collect;

import com.google.common.base.Preconditions;

final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    static long checkNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j);
    }

    static void checkPositive(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " must be positive but was: " + i);
        }
    }

    static void checkRemove(boolean z) {
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }
}
