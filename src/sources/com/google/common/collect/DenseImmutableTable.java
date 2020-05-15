package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"R", "C", "V"})
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    /* access modifiers changed from: private */
    public final int[] columnCounts = new int[this.columnKeyToIndex.size()];
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    /* access modifiers changed from: private */
    public final int[] rowCounts = new int[this.rowKeyToIndex.size()];
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    /* access modifiers changed from: private */
    public final V[][] values;

    DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        int size = immutableSet.size();
        int[] iArr = new int[2];
        iArr[1] = immutableSet2.size();
        iArr[0] = size;
        this.values = (Object[][]) Array.newInstance(Object.class, iArr);
        this.rowKeyToIndex = Maps.indexMap(immutableSet);
        this.columnKeyToIndex = Maps.indexMap(immutableSet2);
        int[] iArr2 = new int[immutableList.size()];
        int[] iArr3 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            int intValue = this.rowKeyToIndex.get(rowKey).intValue();
            int intValue2 = this.columnKeyToIndex.get(columnKey).intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[intValue][intValue2], cell.getValue());
            this.values[intValue][intValue2] = cell.getValue();
            int[] iArr4 = this.rowCounts;
            iArr4[intValue] = iArr4[intValue] + 1;
            int[] iArr5 = this.columnCounts;
            iArr5[intValue2] = iArr5[intValue2] + 1;
            iArr2[i] = intValue;
            iArr3[i] = intValue2;
        }
        this.cellRowIndices = iArr2;
        this.cellColumnIndices = iArr3;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        /* access modifiers changed from: package-private */
        @NullableDecl
        public abstract V getValue(int i);

        /* access modifiers changed from: package-private */
        public abstract ImmutableMap<K, Integer> keyToIndex();

        ImmutableArrayMap(int i) {
            this.size = i;
        }

        private boolean isFull() {
            return this.size == keyToIndex().size();
        }

        /* access modifiers changed from: package-private */
        public K getKey(int i) {
            return keyToIndex().keySet().asList().get(i);
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> createKeySet() {
            return isFull() ? keyToIndex().keySet() : super.createKeySet();
        }

        public int size() {
            return this.size;
        }

        public V get(@NullableDecl Object obj) {
            Integer num = (Integer) keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        /* access modifiers changed from: package-private */
        public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIterator<Map.Entry<K, V>>() {
                private int index = -1;
                private final int maxIndex = ImmutableArrayMap.this.keyToIndex().size();

                /* access modifiers changed from: protected */
                public Map.Entry<K, V> computeNext() {
                    int i = this.index;
                    while (true) {
                        this.index = i + 1;
                        int i2 = this.index;
                        if (i2 >= this.maxIndex) {
                            return (Map.Entry) endOfData();
                        }
                        Object value = ImmutableArrayMap.this.getValue(i2);
                        if (value != null) {
                            return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), value);
                        }
                        i = this.index;
                    }
                }
            };
        }
    }

    private final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        Row(int i) {
            super(DenseImmutableTable.this.rowCounts[i]);
            this.rowIndex = i;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        /* access modifiers changed from: package-private */
        public V getValue(int i) {
            return DenseImmutableTable.this.values[this.rowIndex][i];
        }
    }

    private final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        Column(int i) {
            super(DenseImmutableTable.this.columnCounts[i]);
            this.columnIndex = i;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        /* access modifiers changed from: package-private */
        public V getValue(int i) {
            return DenseImmutableTable.this.values[i][this.columnIndex];
        }
    }

    private final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return false;
        }

        private RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<C, V> getValue(int i) {
            return new Row(i);
        }
    }

    private final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return false;
        }

        private ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<R, V> getValue(int i) {
            return new Column(i);
        }
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    public V get(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    public int size() {
        return this.cellRowIndices.length;
    }

    /* access modifiers changed from: package-private */
    public Table.Cell<R, C, V> getCell(int i) {
        int i2 = this.cellRowIndices[i];
        int i3 = this.cellColumnIndices[i];
        return cellOf(rowKeySet().asList().get(i2), columnKeySet().asList().get(i3), this.values[i2][i3]);
    }

    /* access modifiers changed from: package-private */
    public V getValue(int i) {
        return this.values[this.cellRowIndices[i]][this.cellColumnIndices[i]];
    }

    /* access modifiers changed from: package-private */
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }
}
