package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    /* access modifiers changed from: private */
    public static final Object NOT_FOUND = new Object();
    @NullableDecl
    transient int[] entries;
    @MonotonicNonNullDecl
    private transient Set<Entry<K, V>> entrySetView;
    @MonotonicNonNullDecl
    private transient Set<K> keySetView;
    @NullableDecl
    transient Object[] keys;
    /* access modifiers changed from: private */
    public transient int metadata;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Object table;
    @NullableDecl
    transient Object[] values;
    @MonotonicNonNullDecl
    private transient Collection<V> valuesView;

    class EntrySetView extends AbstractSet<Entry<K, V>> {
        EntrySetView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public boolean contains(@NullableDecl Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            boolean z = false;
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                int access$400 = CompactHashMap.this.indexOf(entry.getKey());
                if (access$400 != -1 && Objects.equal(CompactHashMap.this.values[access$400], entry.getValue())) {
                    z = true;
                }
            }
            return z;
        }

        public boolean remove(@NullableDecl Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int access$500 = CompactHashMap.this.hashTableMask();
            int remove = CompactHashing.remove(entry.getKey(), entry.getValue(), access$500, CompactHashMap.this.table, CompactHashMap.this.entries, CompactHashMap.this.keys, CompactHashMap.this.values);
            if (remove == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(remove, access$500);
            CompactHashMap.this.size = CompactHashMap.this.size - 1;
            CompactHashMap.this.incrementModCount();
            return true;
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;

        /* access modifiers changed from: 0000 */
        public abstract T getOutput(int i);

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i = this.currentIndex;
                this.indexToRemove = i;
                T output = getOutput(i);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            incrementExpectedModCount();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.keys[this.indexToRemove]);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }

        /* access modifiers changed from: 0000 */
        public void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public boolean remove(@NullableDecl Object obj) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.keySet().remove(obj);
            }
            return CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {
        @NullableDecl
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i) {
            this.key = CompactHashMap.this.keys[i];
            this.lastKnownIndex = i;
        }

        @NullableDecl
        public K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            if (i == -1 || i >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @NullableDecl
        public V getValue() {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.get(this.key);
            }
            updateLastKnownIndex();
            return this.lastKnownIndex == -1 ? null : CompactHashMap.this.values[this.lastKnownIndex];
        }

        public V setValue(V v) {
            Map delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.put(this.key, v);
            }
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                CompactHashMap.this.put(this.key, v);
                return null;
            }
            V v2 = CompactHashMap.this.values[this.lastKnownIndex];
            CompactHashMap.this.values[this.lastKnownIndex] = v;
            return v2;
        }
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }
    }

    /* access modifiers changed from: 0000 */
    public void accessEntry(int i) {
    }

    /* access modifiers changed from: 0000 */
    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int i) {
        init(i);
    }

    /* access modifiers changed from: 0000 */
    public void init(int i) {
        Preconditions.checkArgument(i >= 0, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* access modifiers changed from: 0000 */
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    /* access modifiers changed from: 0000 */
    public int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i = this.metadata;
        int tableSize = CompactHashing.tableSize(i);
        this.table = CompactHashing.createTable(tableSize);
        setHashTableMask(tableSize - 1);
        this.entries = new int[i];
        this.keys = new Object[i];
        this.values = new Object[i];
        return i;
    }

    /* access modifiers changed from: 0000 */
    @NullableDecl
    public Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public Map<K, V> createHashFloodingResistantDelegate(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    /* access modifiers changed from: 0000 */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(this.keys[firstEntryIndex], this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    private void setHashTableMask(int i) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* access modifiers changed from: 0000 */
    public void incrementModCount() {
        this.metadata += 32;
    }

    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        int i;
        int resizeTable;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k, v);
        }
        int[] iArr = this.entries;
        Object[] objArr = this.keys;
        V[] vArr = this.values;
        int i2 = this.size;
        int i3 = i2 + 1;
        int smearedHash = Hashing.smearedHash(k);
        int hashTableMask = hashTableMask();
        int i4 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(this.table, i4);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            int i5 = 0;
            while (true) {
                int i6 = tableGet - 1;
                int i7 = iArr[i6];
                if (CompactHashing.getHashPrefix(i7, hashTableMask) != hashPrefix || !Objects.equal(k, objArr[i6])) {
                    int next = CompactHashing.getNext(i7, hashTableMask);
                    i5++;
                    if (next != 0) {
                        tableGet = next;
                    } else if (i5 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k, v);
                    } else {
                        if (i3 > hashTableMask) {
                            resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i2);
                        } else {
                            iArr[i6] = CompactHashing.maskCombine(i7, i3, hashTableMask);
                        }
                    }
                } else {
                    V v2 = vArr[i6];
                    vArr[i6] = v;
                    accessEntry(i6);
                    return v2;
                }
            }
            i = hashTableMask;
            resizeMeMaybe(i3);
            insertEntry(i2, k, v, smearedHash, i);
            this.size = i3;
            incrementModCount();
            return null;
        } else if (i3 > hashTableMask) {
            resizeTable = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i2);
        } else {
            CompactHashing.tableSet(this.table, i4, i3);
            i = hashTableMask;
            resizeMeMaybe(i3);
            insertEntry(i2, k, v, smearedHash, i);
            this.size = i3;
            incrementModCount();
            return null;
        }
        i = resizeTable;
        resizeMeMaybe(i3);
        insertEntry(i2, k, v, smearedHash, i);
        this.size = i3;
        incrementModCount();
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void insertEntry(int i, @NullableDecl K k, @NullableDecl V v, int i2, int i3) {
        this.entries[i] = CompactHashing.maskCombine(i2, 0, i3);
        this.keys[i] = k;
        this.values[i] = v;
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int min = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1);
            if (min != length) {
                resizeEntries(min);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void resizeEntries(int i) {
        this.entries = Arrays.copyOf(this.entries, i);
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
    }

    private int resizeTable(int i, int i2, int i3, int i4) {
        Object createTable = CompactHashing.createTable(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            CompactHashing.tableSet(createTable, i3 & i5, i4 + 1);
        }
        Object obj = this.table;
        int[] iArr = this.entries;
        for (int i6 = 0; i6 <= i; i6++) {
            int tableGet = CompactHashing.tableGet(obj, i6);
            while (tableGet != 0) {
                int i7 = tableGet - 1;
                int i8 = iArr[i7];
                int hashPrefix = CompactHashing.getHashPrefix(i8, i) | i6;
                int i9 = hashPrefix & i5;
                int tableGet2 = CompactHashing.tableGet(createTable, i9);
                CompactHashing.tableSet(createTable, i9, tableGet);
                iArr[i7] = CompactHashing.maskCombine(hashPrefix, tableGet2, i5);
                tableGet = CompactHashing.getNext(i8, i);
            }
        }
        this.table = createTable;
        setHashTableMask(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(this.table, smearedHash & hashTableMask);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i = tableGet - 1;
            int i2 = this.entries[i];
            if (CompactHashing.getHashPrefix(i2, hashTableMask) == hashPrefix && Objects.equal(obj, this.keys[i])) {
                return i;
            }
            tableGet = CompactHashing.getNext(i2, hashTableMask);
        } while (tableGet != 0);
        return -1;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    public V get(@NullableDecl Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return this.values[indexOf];
    }

    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V removeHelper = removeHelper(obj);
        if (removeHelper == NOT_FOUND) {
            removeHelper = null;
        }
        return removeHelper;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public Object removeHelper(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, null, hashTableMask, this.table, this.entries, this.keys, null);
        if (remove == -1) {
            return NOT_FOUND;
        }
        Object obj2 = this.values[remove];
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return obj2;
    }

    /* access modifiers changed from: 0000 */
    public void moveLastEntry(int i, int i2) {
        int size2 = size() - 1;
        if (i < size2) {
            Object[] objArr = this.keys;
            Object obj = objArr[size2];
            objArr[i] = obj;
            Object[] objArr2 = this.values;
            objArr2[i] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            int[] iArr = this.entries;
            iArr[i] = iArr[size2];
            iArr[size2] = 0;
            int smearedHash = Hashing.smearedHash(obj) & i2;
            int tableGet = CompactHashing.tableGet(this.table, smearedHash);
            int i3 = size2 + 1;
            if (tableGet == i3) {
                CompactHashing.tableSet(this.table, smearedHash, i + 1);
                return;
            }
            while (true) {
                int i4 = tableGet - 1;
                int i5 = this.entries[i4];
                int next = CompactHashing.getNext(i5, i2);
                if (next == i3) {
                    this.entries[i4] = CompactHashing.maskCombine(i5, i + 1, i2);
                    return;
                }
                tableGet = next;
            }
        } else {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = 0;
        }
    }

    /* access modifiers changed from: 0000 */
    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: 0000 */
    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: 0000 */
    public Set<K> createKeySet() {
        return new KeySetView();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<K> keySetIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.keySet().iterator();
        }
        return new Itr<K>() {
            /* access modifiers changed from: 0000 */
            public K getOutput(int i) {
                return CompactHashMap.this.keys[i];
            }
        };
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    /* access modifiers changed from: 0000 */
    public Set<Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<Entry<K, V>> entrySetIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.entrySet().iterator();
        }
        return new Itr<Entry<K, V>>() {
            /* access modifiers changed from: 0000 */
            public Entry<K, V> getOutput(int i) {
                return new MapEntry(i);
            }
        };
    }

    public int size() {
        Map delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(obj, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    /* access modifiers changed from: 0000 */
    public Collection<V> createValues() {
        return new ValuesView();
    }

    /* access modifiers changed from: 0000 */
    public Iterator<V> valuesIterator() {
        Map delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.values().iterator();
        }
        return new Itr<V>() {
            /* access modifiers changed from: 0000 */
            public V getOutput(int i) {
                return CompactHashMap.this.values[i];
            }
        };
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Map delegateOrNull = delegateOrNull();
            if (delegateOrNull != null) {
                Map createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
                createHashFloodingResistantDelegate.putAll(delegateOrNull);
                this.table = createHashFloodingResistantDelegate;
                return;
            }
            int i = this.size;
            if (i < this.entries.length) {
                resizeEntries(i);
            }
            int tableSize = CompactHashing.tableSize(i);
            int hashTableMask = hashTableMask();
            if (tableSize < hashTableMask) {
                resizeTable(hashTableMask, tableSize, 0, 0);
            }
        }
    }

    public void clear() {
        if (!needsAllocArrays()) {
            incrementModCount();
            if (delegateOrNull() != null) {
                this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                this.table = null;
                this.size = 0;
            } else {
                Arrays.fill(this.keys, 0, this.size, null);
                Arrays.fill(this.values, 0, this.size, null);
                CompactHashing.tableClear(this.table);
                Arrays.fill(this.entries, 0, this.size, 0);
                this.size = 0;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Entry entry = (Entry) entrySetIterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }
}
