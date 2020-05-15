package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;

public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges = false;
    ElementOrder<? super E> edgeOrder = ElementOrder.insertion();
    Optional<Integer> expectedEdgeCount = Optional.absent();

    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    private NetworkBuilder(boolean z) {
        super(z);
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.common.graph.Network<N, E>, com.google.common.graph.Network] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <N, E> com.google.common.graph.NetworkBuilder<N, E> from(com.google.common.graph.Network<N, E> r2) {
        /*
            com.google.common.graph.NetworkBuilder r0 = new com.google.common.graph.NetworkBuilder
            boolean r1 = r2.isDirected()
            r0.<init>(r1)
            boolean r1 = r2.allowsParallelEdges()
            com.google.common.graph.NetworkBuilder r0 = r0.allowsParallelEdges(r1)
            boolean r1 = r2.allowsSelfLoops()
            com.google.common.graph.NetworkBuilder r0 = r0.allowsSelfLoops(r1)
            com.google.common.graph.ElementOrder r1 = r2.nodeOrder()
            com.google.common.graph.NetworkBuilder r0 = r0.nodeOrder(r1)
            com.google.common.graph.ElementOrder r2 = r2.edgeOrder()
            com.google.common.graph.NetworkBuilder r2 = r0.edgeOrder(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.NetworkBuilder.from(com.google.common.graph.Network):com.google.common.graph.NetworkBuilder");
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(cast());
    }

    public NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.allowsParallelEdges = z;
        return this;
    }

    public NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    public NetworkBuilder<N, E> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public NetworkBuilder<N, E> expectedEdgeCount(int i) {
        this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> cast = cast();
        cast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> cast = cast();
        cast.edgeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new ConfigurableMutableNetwork(this);
    }
}
