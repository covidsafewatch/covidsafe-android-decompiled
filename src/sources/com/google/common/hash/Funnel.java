package com.google.common.hash;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;

@DoNotMock("Implement with a lambda")
public interface Funnel<T> extends Serializable {
    void funnel(T t, PrimitiveSink primitiveSink);
}
