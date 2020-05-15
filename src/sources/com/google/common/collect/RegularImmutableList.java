package com.google.common.collect;

import com.google.common.base.Preconditions;

class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    RegularImmutableList(Object[] objArr, int i) {
        this.array = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return this.array;
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.array, 0, objArr, i, this.size);
        return i + this.size;
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, this.size);
        return this.array[i];
    }
}
