package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface Predicate<T> {
    boolean apply(@NullableDecl T t);

    boolean equals(@NullableDecl Object obj);
}
