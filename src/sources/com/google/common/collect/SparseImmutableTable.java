package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;

@Immutable(containerOf = {"R", "C", "V"})
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap<R, Integer> indexMap = Maps.indexMap(immutableSet);
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        UnmodifiableIterator<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            newLinkedHashMap.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap newLinkedHashMap2 = Maps.newLinkedHashMap();
        UnmodifiableIterator<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            newLinkedHashMap2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i = 0; i < immutableList.size(); i++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i);
            Object rowKey = cell.getRowKey();
            Object columnKey = cell.getColumnKey();
            Object value = cell.getValue();
            iArr[i] = indexMap.get(rowKey).intValue();
            Map map = (Map) newLinkedHashMap.get(rowKey);
            iArr2[i] = map.size();
            checkNoDuplicate(rowKey, columnKey, map.put(columnKey, value), value);
            ((Map) newLinkedHashMap2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(newLinkedHashMap.size());
        for (Map.Entry entry : newLinkedHashMap.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = builder.build();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(newLinkedHashMap2.size());
        for (Map.Entry entry2 : newLinkedHashMap2.entrySet()) {
            builder2.put(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = builder2.build();
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf(this.columnMap);
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf(this.rowMap);
    }

    public int size() {
        return this.cellRowIndices.length;
    }

    /* access modifiers changed from: package-private */
    public Table.Cell<R, C, V> getCell(int i) {
        Map.Entry entry = (Map.Entry) this.rowMap.entrySet().asList().get(this.cellRowIndices[i]);
        Map.Entry entry2 = (Map.Entry) ((ImmutableMap) entry.getValue()).entrySet().asList().get(this.cellColumnInRowIndices[i]);
        return cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* access modifiers changed from: package-private */
    public V getValue(int i) {
        int i2 = this.cellRowIndices[i];
        return ((ImmutableMap) this.rowMap.values().asList().get(i2)).values().asList().get(this.cellColumnInRowIndices[i]);
    }

    /* access modifiers changed from: package-private */
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap indexMap = Maps.indexMap(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        UnmodifiableIterator it = cellSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) indexMap.get(((Table.Cell) it.next()).getColumnKey())).intValue();
            i++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }
}
