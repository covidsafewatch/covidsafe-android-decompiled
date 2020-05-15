package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    /* access modifiers changed from: protected */
    public abstract Deque<E> delegate();

    protected ForwardingDeque() {
    }

    public void addFirst(E e) {
        delegate().addFirst(e);
    }

    public void addLast(E e) {
        delegate().addLast(e);
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public E getFirst() {
        return delegate().getFirst();
    }

    public E getLast() {
        return delegate().getLast();
    }

    public boolean offerFirst(E e) {
        return delegate().offerFirst(e);
    }

    public boolean offerLast(E e) {
        return delegate().offerLast(e);
    }

    public E peekFirst() {
        return delegate().peekFirst();
    }

    public E peekLast() {
        return delegate().peekLast();
    }

    public E pollFirst() {
        return delegate().pollFirst();
    }

    public E pollLast() {
        return delegate().pollLast();
    }

    public E pop() {
        return delegate().pop();
    }

    public void push(E e) {
        delegate().push(e);
    }

    public E removeFirst() {
        return delegate().removeFirst();
    }

    public E removeLast() {
        return delegate().removeLast();
    }

    public boolean removeFirstOccurrence(Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    public boolean removeLastOccurrence(Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
