package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use GraphBuilder to create a real instance")
public interface Graph<N> extends BaseGraph<N> {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean equals(@NullableDecl Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(N n);

    Set<N> successors(N n);
}
