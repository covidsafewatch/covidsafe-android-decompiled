package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    protected UndirectedNetworkConnections(Map<E, N> map) {
        super(map);
    }

    static <N, E> UndirectedNetworkConnections<N, E> of() {
        return new UndirectedNetworkConnections<>(HashBiMap.create(2));
    }

    static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.copyOf(map));
    }

    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap) this.incidentEdgeMap).values());
    }

    public Set<E> edgesConnecting(N n) {
        return new EdgesConnecting(((BiMap) this.incidentEdgeMap).inverse(), n);
    }
}
