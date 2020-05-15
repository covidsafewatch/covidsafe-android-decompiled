package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {
    /* access modifiers changed from: protected */
    public abstract NavigableSet<E> delegate();

    protected ForwardingNavigableSet() {
    }

    public E lower(E e) {
        return delegate().lower(e);
    }

    /* access modifiers changed from: protected */
    public E standardLower(E e) {
        return Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    public E floor(E e) {
        return delegate().floor(e);
    }

    /* access modifiers changed from: protected */
    public E standardFloor(E e) {
        return Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    public E ceiling(E e) {
        return delegate().ceiling(e);
    }

    /* access modifiers changed from: protected */
    public E standardCeiling(E e) {
        return Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    public E higher(E e) {
        return delegate().higher(e);
    }

    /* access modifiers changed from: protected */
    public E standardHigher(E e) {
        return Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    public E pollFirst() {
        return delegate().pollFirst();
    }

    /* access modifiers changed from: protected */
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    public E pollLast() {
        return delegate().pollLast();
    }

    /* access modifiers changed from: protected */
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    /* access modifiers changed from: protected */
    public E standardFirst() {
        return iterator().next();
    }

    /* access modifiers changed from: protected */
    public E standardLast() {
        return descendingIterator().next();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet() {
            super(ForwardingNavigableSet.this);
        }
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return delegate().subSet(e, z, e2, z2);
    }

    /* access modifiers changed from: protected */
    public NavigableSet<E> standardSubSet(E e, boolean z, E e2, boolean z2) {
        return tailSet(e, z).headSet(e2, z2);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardSubSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    public NavigableSet<E> headSet(E e, boolean z) {
        return delegate().headSet(e, z);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardHeadSet(E e) {
        return headSet(e, false);
    }

    public NavigableSet<E> tailSet(E e, boolean z) {
        return delegate().tailSet(e, z);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardTailSet(E e) {
        return tailSet(e, true);
    }
}
