package com.google.common.graph;

public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    boolean addNode(N n);

    V putEdgeValue(EndpointPair<N> endpointPair, V v);

    V putEdgeValue(N n, N n2, V v);

    V removeEdge(EndpointPair<N> endpointPair);

    V removeEdge(N n, N n2);

    boolean removeNode(N n);
}
