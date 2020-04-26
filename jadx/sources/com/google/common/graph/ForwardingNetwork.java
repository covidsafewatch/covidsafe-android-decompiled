package com.google.common.graph;

import java.util.Set;

abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    /* access modifiers changed from: protected */
    public abstract Network<N, E> delegate();

    ForwardingNetwork() {
    }

    public Set<N> nodes() {
        return delegate().nodes();
    }

    public Set<E> edges() {
        return delegate().edges();
    }

    public boolean isDirected() {
        return delegate().isDirected();
    }

    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
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

    public Set<E> incidentEdges(N n) {
        return delegate().incidentEdges(n);
    }

    public Set<E> inEdges(N n) {
        return delegate().inEdges(n);
    }

    public Set<E> outEdges(N n) {
        return delegate().outEdges(n);
    }

    public EndpointPair<N> incidentNodes(E e) {
        return delegate().incidentNodes(e);
    }

    public Set<E> adjacentEdges(E e) {
        return delegate().adjacentEdges(e);
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

    public Set<E> edgesConnecting(N n, N n2) {
        return delegate().edgesConnecting(n, n2);
    }

    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return delegate().edgesConnecting(endpointPair);
    }

    public E edgeConnectingOrNull(N n, N n2) {
        return delegate().edgeConnectingOrNull(n, n2);
    }

    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return delegate().edgeConnectingOrNull(endpointPair);
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }
}
