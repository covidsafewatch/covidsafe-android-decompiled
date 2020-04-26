package com.google.common.collect;

interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    SetMultimap<K, V> unfiltered();
}
