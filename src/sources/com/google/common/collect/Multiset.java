package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@NullableDecl E e, int i);

    boolean add(E e);

    boolean contains(@NullableDecl Object obj);

    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@NullableDecl Object obj);

    int hashCode();

    Iterator<E> iterator();

    int remove(@NullableDecl Object obj, int i);

    boolean remove(@NullableDecl Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    int size();

    String toString();
}
