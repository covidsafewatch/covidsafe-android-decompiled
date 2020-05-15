package com.google.common.collect;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet(new Object[0], 0, (Object[]) null, 0, 0);
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    final transient Object[] table;

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i2;
        this.hashCode = i;
        this.size = i3;
    }

    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        while (true) {
            int i = smearedHash & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            smearedHash = i + 1;
        }
    }

    public int size() {
        return this.size;
    }

    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return this.elements;
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.elements, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.size);
    }

    public int hashCode() {
        return this.hashCode;
    }
}
