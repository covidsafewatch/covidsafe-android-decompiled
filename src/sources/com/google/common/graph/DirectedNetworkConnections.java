package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    protected DirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    static <N, E> DirectedNetworkConnections<N, E> of() {
        return new DirectedNetworkConnections<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    static <N, E> DirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map, Map<E, N> map2, int i) {
        return new DirectedNetworkConnections<>(ImmutableBiMap.copyOf(map), ImmutableBiMap.copyOf(map2), i);
    }

    public Set<N> predecessors() {
        return Collections.unmodifiableSet(((BiMap) this.inEdgeMap).values());
    }

    public Set<N> successors() {
        return Collections.unmodifiableSet(((BiMap) this.outEdgeMap).values());
    }

    public Set<E> edgesConnecting(N n) {
        return new EdgesConnecting(((BiMap) this.outEdgeMap).inverse(), n);
    }
}
