package com.google.common.collect;

abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    /* access modifiers changed from: 0000 */
    public abstract E get(int i);

    IndexedImmutableSet() {
    }

    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    /* access modifiers changed from: 0000 */
    public int copyIntoArray(Object[] objArr, int i) {
        return asList().copyIntoArray(objArr, i);
    }

    /* access modifiers changed from: 0000 */
    public ImmutableList<E> createAsList() {
        return new ImmutableList<E>() {
            public E get(int i) {
                return IndexedImmutableSet.this.get(i);
            }

            /* access modifiers changed from: 0000 */
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }
}
