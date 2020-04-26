package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @MonotonicNonNullDecl
    transient Object[] elements;
    @MonotonicNonNullDecl
    private transient int[] entries;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @MonotonicNonNullDecl
    private transient Object table;

    /* access modifiers changed from: 0000 */
    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    CompactHashSet() {
        init(3);
    }

    CompactHashSet(int i) {
        init(i);
    }

    /* access modifiers changed from: 0000 */
    public void init(int i) {
        Preconditions.checkArgument(i >= 0, "Expected size must be >= 0");
        this.metadata = Math.max(1, Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, i));
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
        this.elements = new Object[i];
        return i;
    }

    private void setHashTableMask(int i) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* access modifiers changed from: 0000 */
    public void incrementModCount() {
        this.metadata += 32;
    }

    public boolean add(@NullableDecl E e) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        int[] iArr = this.entries;
        Object[] objArr = this.elements;
        int i = this.size;
        int i2 = i + 1;
        int smearedHash = Hashing.smearedHash(e);
        int hashTableMask = hashTableMask();
        int i3 = smearedHash & hashTableMask;
        int tableGet = CompactHashing.tableGet(this.table, i3);
        if (tableGet != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
            while (true) {
                int i4 = tableGet - 1;
                int i5 = iArr[i4];
                if (CompactHashing.getHashPrefix(i5, hashTableMask) == hashPrefix && Objects.equal(e, objArr[i4])) {
                    return false;
                }
                int next = CompactHashing.getNext(i5, hashTableMask);
                if (next != 0) {
                    tableGet = next;
                } else if (i2 > hashTableMask) {
                    hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i);
                } else {
                    iArr[i4] = CompactHashing.maskCombine(i5, i2, hashTableMask);
                }
            }
        } else if (i2 > hashTableMask) {
            hashTableMask = resizeTable(hashTableMask, CompactHashing.newCapacity(hashTableMask), smearedHash, i);
        } else {
            CompactHashing.tableSet(this.table, i3, i2);
        }
        resizeMeMaybe(i2);
        insertEntry(i, e, smearedHash, hashTableMask);
        this.size = i2;
        incrementModCount();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void insertEntry(int i, @NullableDecl E e, int i2, int i3) {
        this.entries[i] = CompactHashing.maskCombine(i2, 0, i3);
        this.elements[i] = e;
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
        this.elements = Arrays.copyOf(this.elements, i);
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

    public boolean contains(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int hashTableMask = hashTableMask();
        int tableGet = CompactHashing.tableGet(this.table, smearedHash & hashTableMask);
        if (tableGet == 0) {
            return false;
        }
        int hashPrefix = CompactHashing.getHashPrefix(smearedHash, hashTableMask);
        do {
            int i = tableGet - 1;
            int i2 = this.entries[i];
            if (CompactHashing.getHashPrefix(i2, hashTableMask) == hashPrefix && Objects.equal(obj, this.elements[i])) {
                return true;
            }
            tableGet = CompactHashing.getNext(i2, hashTableMask);
        } while (tableGet != 0);
        return false;
    }

    public boolean remove(@NullableDecl Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int hashTableMask = hashTableMask();
        int remove = CompactHashing.remove(obj, null, hashTableMask, this.table, this.entries, this.elements, null);
        if (remove == -1) {
            return false;
        }
        moveLastEntry(remove, hashTableMask);
        this.size--;
        incrementModCount();
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void moveLastEntry(int i, int i2) {
        int size2 = size() - 1;
        if (i < size2) {
            Object[] objArr = this.elements;
            Object obj = objArr[size2];
            objArr[i] = obj;
            objArr[size2] = null;
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
            this.elements[i] = null;
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

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int currentIndex = CompactHashSet.this.firstEntryIndex();
            int expectedMetadata = CompactHashSet.this.metadata;
            int indexToRemove = -1;

            public boolean hasNext() {
                return this.currentIndex >= 0;
            }

            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    this.indexToRemove = this.currentIndex;
                    E[] eArr = CompactHashSet.this.elements;
                    int i = this.currentIndex;
                    E e = eArr[i];
                    this.currentIndex = CompactHashSet.this.getSuccessor(i);
                    return e;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                incrementExpectedModCount();
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.elements[this.indexToRemove]);
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }

            /* access modifiers changed from: 0000 */
            public void incrementExpectedModCount() {
                this.expectedMetadata += 32;
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.metadata != this.expectedMetadata) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        return Arrays.copyOf(this.elements, this.size);
    }

    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            return ObjectArrays.toArrayImpl(this.elements, 0, this.size, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
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
            Arrays.fill(this.elements, 0, this.size, null);
            CompactHashing.tableClear(this.table);
            Arrays.fill(this.entries, 0, this.size, 0);
            this.size = 0;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.elements[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }
}
