package com.google.common.cache;

public interface Weigher<K, V> {
    int weigh(K k, V v);
}
