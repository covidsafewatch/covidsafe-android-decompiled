package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    /* access modifiers changed from: protected */
    public abstract ValueGraph<N, V> delegate();

    ForwardingValueGraph() {
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        return (long) delegate().edges().size();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public Set<N> adjacentNodes(N n) {
        return delegate().adjacentNodes(n);
    }

    public Set<N> predecessors(N n) {
        return delegate().predecessors(n);
    }

    public Set<N> successors(N n) {
        return delegate().successors(n);
    }

    public int degree(N n) {
        return delegate().degree(n);
    }

    public int inDegree(N n) {
        return delegate().inDegree(n);
    }

    public int outDegree(N n) {
        return delegate().outDegree(n);
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @NullableDecl
    public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
        return delegate().edgeValueOrDefault(n, n2, v);
    }

    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v) {
        return delegate().edgeValueOrDefault(endpointPair, v);
    }
}
