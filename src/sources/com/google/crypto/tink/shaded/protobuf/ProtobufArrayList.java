package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return EMPTY_LIST;
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private ProtobufArrayList(E[] eArr, int i) {
        this.array = eArr;
        this.size = i;
    }

    public ProtobufArrayList<E> mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public boolean add(E e) {
        ensureIsMutable();
        int i = this.size;
        E[] eArr = this.array;
        if (i == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public void add(int i, E e) {
        int i2;
        ensureIsMutable();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
        E[] eArr = this.array;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] createArray = createArray(((i2 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, createArray, 0, i);
            System.arraycopy(this.array, i, createArray, i + 1, this.size - i);
            this.array = createArray;
        }
        this.array[i] = e;
        this.size++;
        this.modCount++;
    }

    public E get(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    public E remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public E set(int i, E e) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public int size() {
        return this.size;
    }

    private static <E> E[] createArray(int i) {
        return new Object[i];
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        return "Index:" + i + ", Size:" + this.size;
    }
}
