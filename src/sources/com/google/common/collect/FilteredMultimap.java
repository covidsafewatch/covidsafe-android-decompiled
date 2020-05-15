package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Map;

interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Predicate<? super Map.Entry<K, V>> entryPredicate();

    Multimap<K, V> unfiltered();
}
