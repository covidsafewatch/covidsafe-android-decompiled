package org.reactivestreams;

public interface Subscription {
    void cancel();

    void request(long j);
}
