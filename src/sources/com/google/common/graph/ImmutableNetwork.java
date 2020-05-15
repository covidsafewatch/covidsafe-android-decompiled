package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@Immutable(containerOf = {"N", "E"})
public final class ImmutableNetwork<N, E> extends ConfigurableNetwork<N, E> {
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        return network instanceof ImmutableNetwork ? (ImmutableNetwork) network : new ImmutableNetwork<>(network);
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N next : network.nodes()) {
            builder.put(next, connectionsOf(network, next));
        }
        return builder.build();
    }

    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E next : network.edges()) {
            builder.put(next, network.incidentNodes(next).nodeU());
        }
        return builder.build();
    }

    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n) {
        if (network.isDirected()) {
            Map<K, V> asMap = Maps.asMap(network.inEdges(n), sourceNodeFn(network));
            Map<K, V> asMap2 = Maps.asMap(network.outEdges(n), targetNodeFn(network));
            int size = network.edgesConnecting(n, n).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map<K, V> asMap3 = Maps.asMap(network.incidentEdges(n), adjacentNodeFn(network, n));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> network) {
        return new Function<E, N>() {
            public N apply(E e) {
                return network.incidentNodes(e).source();
            }
        };
    }

    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> network) {
        return new Function<E, N>() {
            public N apply(E e) {
                return network.incidentNodes(e).target();
            }
        };
    }

    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> network, final N n) {
        return new Function<E, N>() {
            public N apply(E e) {
                return network.incidentNodes(e).adjacentNode(n);
            }
        };
    }

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        Builder(NetworkBuilder<N, E> networkBuilder) {
            this.mutableNetwork = networkBuilder.build();
        }

        public Builder<N, E> addNode(N n) {
            this.mutableNetwork.addNode(n);
            return this;
        }

        public Builder<N, E> addEdge(N n, N n2, E e) {
            this.mutableNetwork.addEdge(n, n2, e);
            return this;
        }

        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e) {
            this.mutableNetwork.addEdge(endpointPair, e);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }
    }
}
