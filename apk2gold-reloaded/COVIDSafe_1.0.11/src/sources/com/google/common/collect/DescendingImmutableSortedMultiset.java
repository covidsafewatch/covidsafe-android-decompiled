package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> forward;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    public int count(@NullableDecl Object obj) {
        return this.forward.count(obj);
    }

    public Entry<E> firstEntry() {
        return this.forward.lastEntry();
    }

    public Entry<E> lastEntry() {
        return this.forward.firstEntry();
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }

    /* access modifiers changed from: 0000 */
    public Entry<E> getEntry(int i) {
        return (Entry) this.forward.entrySet().asList().reverse().get(i);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    public ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.forward.tailMultiset(e, boundType).descendingMultiset();
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.forward.headMultiset(e, boundType).descendingMultiset();
    }

    /* access modifiers changed from: 0000 */
    public boolean isPartialView() {
        return this.forward.isPartialView();
    }
}
