package com.google.common.graph;

public interface MutableGraph<N> extends Graph<N> {
    boolean addNode(N n);

    boolean putEdge(EndpointPair<N> endpointPair);

    boolean putEdge(N n, N n2);

    boolean removeEdge(EndpointPair<N> endpointPair);

    boolean removeEdge(N n, N n2);

    boolean removeNode(N n);
}
