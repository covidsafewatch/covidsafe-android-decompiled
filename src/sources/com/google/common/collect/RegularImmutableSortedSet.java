package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), Ordering.natural());
    final transient ImmutableList<E> elements;

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    public UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }

    public UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    public int size() {
        return this.elements.size();
    }

    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return unsafeBinarySearch(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!SortedIterables.hasSameComparator(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int unsafeCompare = unsafeCompare(next2, next);
                if (unsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (unsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (unsafeCompare > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    private int unsafeBinarySearch(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.elements, obj, unsafeComparator());
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        return this.elements.copyIntoArray(objArr, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Comparator r1 = r5.comparator
            boolean r1 = com.google.common.collect.SortedIterables.hasSameComparator(r1, r6)
            if (r1 == 0) goto L_0x0047
            java.util.Iterator r6 = r6.iterator()
            com.google.common.collect.UnmodifiableIterator r1 = r5.iterator()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x0045
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            java.lang.Object r4 = r6.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r4 == 0) goto L_0x0044
            int r3 = r5.unsafeCompare(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x002e
        L_0x0044:
            return r2
        L_0x0045:
            return r0
        L_0x0046:
            return r2
        L_0x0047:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableSortedSet.equals(java.lang.Object):boolean");
    }

    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public E lower(E e) {
        int headIndex = headIndex(e, false) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    public E floor(E e) {
        int headIndex = headIndex(e, true) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    public E ceiling(E e) {
        int tailIndex = tailIndex(e, true);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    public E higher(E e) {
        int tailIndex = tailIndex(e, false);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return getSubSet(0, headIndex(e, z));
    }

    /* access modifiers changed from: package-private */
    public int headIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, Preconditions.checkNotNull(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return ~binarySearch;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return tailSetImpl(e, z).headSetImpl(e2, z2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return getSubSet(tailIndex(e, z), size());
    }

    /* access modifiers changed from: package-private */
    public int tailIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, Preconditions.checkNotNull(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return ~binarySearch;
    }

    /* access modifiers changed from: package-private */
    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public RegularImmutableSortedSet<E> getSubSet(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet<>(this.elements.subList(i, i2), this.comparator);
        }
        return emptySet(this.comparator);
    }

    /* access modifiers changed from: package-private */
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (binarySearch >= 0) {
                return binarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public ImmutableList<E> asList() {
        return this.elements;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> createDescendingSet() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return emptySet(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.elements.reverse(), reverseOrder);
    }
}
