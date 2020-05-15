package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    private final ImmutableMap<K, V> map;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return true;
    }

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public int size() {
        return this.map.size();
    }

    public UnmodifiableIterator<K> iterator() {
        return this.map.keyIterator();
    }

    public boolean contains(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public K get(int i) {
        return ((Map.Entry) this.map.entrySet().asList().get(i)).getKey();
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }

    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.map.keySet();
        }
    }
}
