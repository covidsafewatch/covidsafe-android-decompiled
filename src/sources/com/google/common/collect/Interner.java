package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Use Interners.new*Interner")
public interface Interner<E> {
    E intern(E e);
}
