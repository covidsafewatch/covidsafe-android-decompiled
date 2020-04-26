package org.reactivestreams;

public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
