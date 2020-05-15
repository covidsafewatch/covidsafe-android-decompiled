package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    /* access modifiers changed from: protected */
    public abstract Table<R, C, V> delegate();

    protected ForwardingTable() {
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(C c) {
        return delegate().column(c);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    public boolean contains(Object obj, Object obj2) {
        return delegate().contains(obj, obj2);
    }

    public boolean containsColumn(Object obj) {
        return delegate().containsColumn(obj);
    }

    public boolean containsRow(Object obj) {
        return delegate().containsRow(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    public V get(Object obj, Object obj2) {
        return delegate().get(obj, obj2);
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public V put(R r, C c, V v) {
        return delegate().put(r, c, v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    public V remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public Map<C, V> row(R r) {
        return delegate().row(r);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }
}
