package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    /* access modifiers changed from: package-private */
    public abstract Table.Cell<R, C, V> getCell(int i);

    /* access modifiers changed from: package-private */
    public abstract V getValue(int i);

    RegularImmutableTable() {
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    private final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return false;
        }

        private CellSet() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        /* access modifiers changed from: package-private */
        public Table.Cell<R, C, V> get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object obj2 = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
            if (obj2 == null || !obj2.equals(cell.getValue())) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    private final class Values extends ImmutableList<V> {
        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        private Values() {
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }

        public V get(int i) {
            return RegularImmutableTable.this.getValue(i);
        }
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> list, @NullableDecl final Comparator<? super R> comparator, @NullableDecl final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new Comparator<Table.Cell<R, C, V>>() {
                public int compare(Table.Cell<R, C, V> cell, Table.Cell<R, C, V> cell2) {
                    int i;
                    Comparator comparator = comparator;
                    if (comparator == null) {
                        i = 0;
                    } else {
                        i = comparator.compare(cell.getRowKey(), cell2.getRowKey());
                    }
                    if (i != 0) {
                        return i;
                    }
                    Comparator comparator2 = comparator2;
                    if (comparator2 == null) {
                        return 0;
                    }
                    return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, (Comparator) null, (Comparator) null);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> iterable, @NullableDecl Comparator<? super R> comparator, @NullableDecl Comparator<? super C> comparator2) {
        ImmutableSet<E> immutableSet;
        ImmutableSet<E> immutableSet2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList<E> copyOf = ImmutableList.copyOf(iterable);
        for (Table.Cell next : iterable) {
            linkedHashSet.add(next.getRowKey());
            linkedHashSet2.add(next.getColumnKey());
        }
        if (comparator == null) {
            immutableSet = ImmutableSet.copyOf(linkedHashSet);
        } else {
            immutableSet = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            immutableSet2 = ImmutableSet.copyOf(linkedHashSet2);
        } else {
            immutableSet2 = ImmutableSet.copyOf(ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return forOrderedComponents(copyOf, immutableSet, immutableSet2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    /* access modifiers changed from: package-private */
    public final void checkNoDuplicate(R r, C c, V v, V v2) {
        Preconditions.checkArgument(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c, v2, v);
    }
}
