package com.google.common.collect;

import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @NullableDecl
    private T nextOrNull;

    /* access modifiers changed from: protected */
    @NullableDecl
    public abstract T computeNext(T t);

    protected AbstractSequentialIterator(@NullableDecl T t) {
        this.nextOrNull = t;
    }

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                return this.nextOrNull;
            } finally {
                this.nextOrNull = computeNext(this.nextOrNull);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
