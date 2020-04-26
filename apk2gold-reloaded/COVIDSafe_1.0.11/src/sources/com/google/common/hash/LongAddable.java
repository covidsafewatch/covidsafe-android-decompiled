package com.google.common.hash;

interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}
