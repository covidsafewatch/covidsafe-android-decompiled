package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    public abstract K getKey();

    public abstract V getValue();

    AbstractMapEntry() {
    }

    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        Object key = getKey();
        Object value = getValue();
        int i2 = 0;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        if (value != null) {
            i2 = value.hashCode();
        }
        return i ^ i2;
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
