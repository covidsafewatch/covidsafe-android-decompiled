package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(@NullableDecl Object obj);

        @NullableDecl
        C getColumnKey();

        @NullableDecl
        R getRowKey();

        @NullableDecl
        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@NullableDecl Object obj, @NullableDecl Object obj2);

    boolean containsColumn(@NullableDecl Object obj);

    boolean containsRow(@NullableDecl Object obj);

    boolean containsValue(@NullableDecl Object obj);

    boolean equals(@NullableDecl Object obj);

    V get(@NullableDecl Object obj, @NullableDecl Object obj2);

    int hashCode();

    boolean isEmpty();

    @NullableDecl
    V put(R r, C c, V v);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @NullableDecl
    V remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
