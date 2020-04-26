package com.google.common.cache;

interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}
