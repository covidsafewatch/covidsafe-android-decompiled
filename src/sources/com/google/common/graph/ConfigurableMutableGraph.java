package com.google.common.graph;

import com.google.common.graph.GraphConstants;

final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    /* access modifiers changed from: protected */
    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    public boolean addNode(N n) {
        return this.backingValueGraph.addNode(n);
    }

    public boolean putEdge(N n, N n2) {
        return this.backingValueGraph.putEdgeValue(n, n2, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public boolean removeNode(N n) {
        return this.backingValueGraph.removeNode(n);
    }

    public boolean removeEdge(N n, N n2) {
        return this.backingValueGraph.removeEdge(n, n2) != null;
    }

    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
