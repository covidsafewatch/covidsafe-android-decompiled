package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
    protected final BaseGraph<N> graph;
    protected final N node;

    IncidentEdgeSet(BaseGraph<N> baseGraph, N n) {
        this.graph = baseGraph;
        this.node = n;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        if (this.graph.isDirected()) {
            return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
        }
        return this.graph.adjacentNodes(this.node).size();
    }

    public boolean contains(@NullableDecl Object obj) {
        boolean z = false;
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.graph.isDirected()) {
            if (!endpointPair.isOrdered()) {
                return false;
            }
            Object source = endpointPair.source();
            Object target = endpointPair.target();
            if ((this.node.equals(source) && this.graph.successors(this.node).contains(target)) || (this.node.equals(target) && this.graph.predecessors(this.node).contains(source))) {
                z = true;
            }
            return z;
        } else if (endpointPair.isOrdered()) {
            return false;
        } else {
            Set adjacentNodes = this.graph.adjacentNodes(this.node);
            Object nodeU = endpointPair.nodeU();
            Object nodeV = endpointPair.nodeV();
            if ((this.node.equals(nodeV) && adjacentNodes.contains(nodeU)) || (this.node.equals(nodeU) && adjacentNodes.contains(nodeV))) {
                z = true;
            }
            return z;
        }
    }
}
