package com.airbnb.lottie.model;

import androidx.core.util.Pair;

public class MutablePair<T> {
    T first;
    T second;

    public void set(T t, T t2) {
        this.first = t;
        this.second = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!objectsEqual(pair.first, this.first) || !objectsEqual(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.first;
        int i = 0;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.second;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}
