package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Graphs {

    private enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    private static class TransposedGraph<N> extends ForwardingGraph<N> {
        /* access modifiers changed from: private */
        public final Graph<N> graph;

        TransposedGraph(Graph<N> graph2) {
            this.graph = graph2;
        }

        /* access modifiers changed from: protected */
        public Graph<N> delegate() {
            return this.graph;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors(n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors(n);
        }

        public Set<EndpointPair<N>> incidentEdges(N n) {
            return new IncidentEdgeSet<N>(this, n) {
                public Iterator<EndpointPair<N>> iterator() {
                    return Iterators.transform(TransposedGraph.this.delegate().incidentEdges(this.node).iterator(), new Function<EndpointPair<N>, EndpointPair<N>>() {
                        public EndpointPair<N> apply(EndpointPair<N> endpointPair) {
                            return EndpointPair.of(TransposedGraph.this.delegate(), endpointPair.nodeV(), endpointPair.nodeU());
                        }
                    });
                }
            };
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }

        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }
    }

    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        /* access modifiers changed from: private */
        public final Network<N, E> network;

        TransposedNetwork(Network<N, E> network2) {
            this.network = network2;
        }

        /* access modifiers changed from: protected */
        public Network<N, E> delegate() {
            return this.network;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors(n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors(n);
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public Set<E> inEdges(N n) {
            return delegate().outEdges(n);
        }

        public Set<E> outEdges(N n) {
            return delegate().inEdges(n);
        }

        public EndpointPair<N> incidentNodes(E e) {
            EndpointPair incidentNodes = delegate().incidentNodes(e);
            return EndpointPair.of(this.network, incidentNodes.nodeV(), incidentNodes.nodeU());
        }

        public Set<E> edgesConnecting(N n, N n2) {
            return delegate().edgesConnecting(n2, n);
        }

        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return delegate().edgesConnecting(Graphs.transpose(endpointPair));
        }

        public E edgeConnectingOrNull(N n, N n2) {
            return delegate().edgeConnectingOrNull(n2, n);
        }

        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(endpointPair));
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }

        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }
    }

    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        /* access modifiers changed from: private */
        public final ValueGraph<N, V> graph;

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.graph = valueGraph;
        }

        /* access modifiers changed from: protected */
        public ValueGraph<N, V> delegate() {
            return this.graph;
        }

        public Set<N> predecessors(N n) {
            return delegate().successors(n);
        }

        public Set<N> successors(N n) {
            return delegate().predecessors(n);
        }

        public int inDegree(N n) {
            return delegate().outDegree(n);
        }

        public int outDegree(N n) {
            return delegate().inDegree(n);
        }

        public boolean hasEdgeConnecting(N n, N n2) {
            return delegate().hasEdgeConnecting(n2, n);
        }

        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @NullableDecl
        public V edgeValueOrDefault(N n, N n2, @NullableDecl V v) {
            return delegate().edgeValueOrDefault(n2, n, v);
        }

        @NullableDecl
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v) {
            return delegate().edgeValueOrDefault(Graphs.transpose(endpointPair), v);
        }
    }

    private Graphs() {
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        for (Object subgraphHasCycle : graph.nodes()) {
            if (subgraphHasCycle(graph, newHashMapWithExpectedSize, subgraphHasCycle, null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> map, N n, @NullableDecl N n2) {
        NodeVisitState nodeVisitState = (NodeVisitState) map.get(n);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        if (nodeVisitState == NodeVisitState.PENDING) {
            return true;
        }
        map.put(n, NodeVisitState.PENDING);
        for (Object next : graph.successors(n)) {
            if (canTraverseWithoutReusingEdge(graph, next, n2) && subgraphHasCycle(graph, map, next, n)) {
                return true;
            }
        }
        map.put(n, NodeVisitState.COMPLETE);
        return false;
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, @NullableDecl Object obj2) {
        return graph.isDirected() || !Objects.equal(obj2, obj);
    }

    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        MutableGraph build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (Object next : graph.nodes()) {
                for (Object putEdge : reachableNodes(graph, next)) {
                    build.putEdge(next, putEdge);
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (Object next2 : graph.nodes()) {
                if (!hashSet.contains(next2)) {
                    Set reachableNodes = reachableNodes(graph, next2);
                    hashSet.addAll(reachableNodes);
                    int i = 1;
                    for (Object next3 : reachableNodes) {
                        int i2 = i + 1;
                        for (Object putEdge2 : Iterables.limit(reachableNodes, i)) {
                            build.putEdge(next3, putEdge2);
                        }
                        i = i2;
                    }
                }
            }
        }
        return build;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n) {
        Preconditions.checkArgument(graph.nodes().contains(n), "Node %s is not an element of this graph.", (Object) n);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst(n));
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (!graph.isDirected()) {
            return graph;
        }
        if (graph instanceof TransposedGraph) {
            return ((TransposedGraph) graph).graph;
        }
        return new TransposedGraph(graph);
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof TransposedValueGraph) {
            return ((TransposedValueGraph) valueGraph).graph;
        }
        return new TransposedValueGraph(valueGraph);
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof TransposedNetwork) {
            return ((TransposedNetwork) network).network;
        }
        return new TransposedNetwork(network);
    }

    static <N> EndpointPair<N> transpose(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        MutableGraph<N> mutableGraph;
        if (iterable instanceof Collection) {
            mutableGraph = GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableGraph = GraphBuilder.from(graph).build();
        }
        for (Object addNode : iterable) {
            mutableGraph.addNode(addNode);
        }
        for (Object next : mutableGraph.nodes()) {
            for (Object next2 : graph.successors(next)) {
                if (mutableGraph.nodes().contains(next2)) {
                    mutableGraph.putEdge(next, next2);
                }
            }
        }
        return mutableGraph;
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        MutableValueGraph<N, V> mutableValueGraph;
        if (iterable instanceof Collection) {
            mutableValueGraph = ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableValueGraph = ValueGraphBuilder.from(valueGraph).build();
        }
        for (Object addNode : iterable) {
            mutableValueGraph.addNode(addNode);
        }
        for (Object next : mutableValueGraph.nodes()) {
            for (Object next2 : valueGraph.successors(next)) {
                if (mutableValueGraph.nodes().contains(next2)) {
                    mutableValueGraph.putEdgeValue(next, next2, valueGraph.edgeValueOrDefault(next, next2, null));
                }
            }
        }
        return mutableValueGraph;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        MutableNetwork<N, E> mutableNetwork;
        if (iterable instanceof Collection) {
            mutableNetwork = NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableNetwork = NetworkBuilder.from(network).build();
        }
        for (Object addNode : iterable) {
            mutableNetwork.addNode(addNode);
        }
        for (Object next : mutableNetwork.nodes()) {
            for (Object next2 : network.outEdges(next)) {
                Object adjacentNode = network.incidentNodes(next2).adjacentNode(next);
                if (mutableNetwork.nodes().contains(adjacentNode)) {
                    mutableNetwork.addEdge(next, adjacentNode, next2);
                }
            }
        }
        return mutableNetwork;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> build = GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        for (Object addNode : graph.nodes()) {
            build.addNode(addNode);
        }
        for (EndpointPair endpointPair : graph.edges()) {
            build.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return build;
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> build = ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        for (Object addNode : valueGraph.nodes()) {
            build.addNode(addNode);
        }
        for (EndpointPair endpointPair : valueGraph.edges()) {
            build.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
        }
        return build;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> build = NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        for (Object addNode : network.nodes()) {
            build.addNode(addNode);
        }
        for (Object next : network.edges()) {
            EndpointPair incidentNodes = network.incidentNodes(next);
            build.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), next);
        }
        return build;
    }

    static int checkNonNegative(int i) {
        Preconditions.checkArgument(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    static long checkNonNegative(long j) {
        Preconditions.checkArgument(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    static int checkPositive(int i) {
        Preconditions.checkArgument(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    static long checkPositive(long j) {
        Preconditions.checkArgument(j > 0, "Not true that %s is positive.", j);
        return j;
    }
}
