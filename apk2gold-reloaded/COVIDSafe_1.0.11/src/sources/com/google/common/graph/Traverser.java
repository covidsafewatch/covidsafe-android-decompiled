package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Traverser<N> {

    private static final class GraphTraverser<N> extends Traverser<N> {
        /* access modifiers changed from: private */
        public final SuccessorsFunction<N> graph;

        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object next : iterable) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
            }

            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public N next() {
                N remove = this.queue.remove();
                for (Object next : GraphTraverser.this.graph.successors(remove)) {
                    if (this.visited.add(next)) {
                        this.queue.add(next);
                    }
                }
                return remove;
            }
        }

        private final class DepthFirstIterator extends AbstractIterator<N> {
            private final Order order;
            private final Deque<com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator.NodeAndSuccessors> stack = new ArrayDeque();
            private final Set<N> visited = new HashSet();

            private final class NodeAndSuccessors {
                @NullableDecl
                final N node;
                final Iterator<? extends N> successorIterator;

                NodeAndSuccessors(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.successorIterator = iterable.iterator();
                }
            }

            DepthFirstIterator(Iterable<? extends N> iterable, Order order2) {
                this.stack.push(new NodeAndSuccessors(null, iterable));
                this.order = order2;
            }

            /* access modifiers changed from: protected */
            public N computeNext() {
                while (!this.stack.isEmpty()) {
                    NodeAndSuccessors nodeAndSuccessors = (NodeAndSuccessors) this.stack.getFirst();
                    boolean z = true;
                    boolean z2 = !nodeAndSuccessors.successorIterator.hasNext();
                    if ((!this.visited.add(nodeAndSuccessors.node) || this.order != Order.PREORDER) && (!z2 || this.order != Order.POSTORDER)) {
                        z = false;
                    }
                    if (z2) {
                        this.stack.pop();
                    } else {
                        Object next = nodeAndSuccessors.successorIterator.next();
                        if (!this.visited.contains(next)) {
                            this.stack.push(withSuccessors(next));
                        }
                    }
                    if (z && nodeAndSuccessors.node != null) {
                        return nodeAndSuccessors.node;
                    }
                }
                return endOfData();
            }

            /* access modifiers changed from: 0000 */
            public com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator.NodeAndSuccessors withSuccessors(N n) {
                return new NodeAndSuccessors(n, GraphTraverser.this.graph.successors(n));
            }
        }

        GraphTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.graph = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.PREORDER);
                }
            };
        }

        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInGraph : iterable) {
                checkThatNodeIsInGraph(checkThatNodeIsInGraph);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstIterator(iterable, Order.POSTORDER);
                }
            };
        }

        private void checkThatNodeIsInGraph(N n) {
            this.graph.successors(n);
        }
    }

    private enum Order {
        PREORDER,
        POSTORDER
    }

    private static final class TreeTraverser<N> extends Traverser<N> {
        /* access modifiers changed from: private */
        public final SuccessorsFunction<N> tree;

        private final class BreadthFirstIterator extends UnmodifiableIterator<N> {
            private final Queue<N> queue = new ArrayDeque();

            BreadthFirstIterator(Iterable<? extends N> iterable) {
                for (Object add : iterable) {
                    this.queue.add(add);
                }
            }

            public boolean hasNext() {
                return !this.queue.isEmpty();
            }

            public N next() {
                N remove = this.queue.remove();
                Iterables.addAll(this.queue, TreeTraverser.this.tree.successors(remove));
                return remove;
            }
        }

        private final class DepthFirstPostOrderIterator extends AbstractIterator<N> {
            private final ArrayDeque<com.google.common.graph.Traverser$TreeTraverser$DepthFirstPostOrderIterator.NodeAndChildren> stack;

            private final class NodeAndChildren {
                final Iterator<? extends N> childIterator;
                @NullableDecl
                final N node;

                NodeAndChildren(@NullableDecl N n, Iterable<? extends N> iterable) {
                    this.node = n;
                    this.childIterator = iterable.iterator();
                }
            }

            DepthFirstPostOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque<com.google.common.graph.Traverser$TreeTraverser$DepthFirstPostOrderIterator.NodeAndChildren> arrayDeque = new ArrayDeque<>();
                this.stack = arrayDeque;
                arrayDeque.addLast(new NodeAndChildren(null, iterable));
            }

            /* access modifiers changed from: protected */
            public N computeNext() {
                while (!this.stack.isEmpty()) {
                    NodeAndChildren nodeAndChildren = (NodeAndChildren) this.stack.getLast();
                    if (nodeAndChildren.childIterator.hasNext()) {
                        this.stack.addLast(withChildren(nodeAndChildren.childIterator.next()));
                    } else {
                        this.stack.removeLast();
                        if (nodeAndChildren.node != null) {
                            return nodeAndChildren.node;
                        }
                    }
                }
                return endOfData();
            }

            /* access modifiers changed from: 0000 */
            public com.google.common.graph.Traverser$TreeTraverser$DepthFirstPostOrderIterator.NodeAndChildren withChildren(N n) {
                return new NodeAndChildren(n, TreeTraverser.this.tree.successors(n));
            }
        }

        private final class DepthFirstPreOrderIterator extends UnmodifiableIterator<N> {
            private final Deque<Iterator<? extends N>> stack;

            DepthFirstPreOrderIterator(Iterable<? extends N> iterable) {
                ArrayDeque arrayDeque = new ArrayDeque();
                this.stack = arrayDeque;
                arrayDeque.addLast(iterable.iterator());
            }

            public boolean hasNext() {
                return !this.stack.isEmpty();
            }

            public N next() {
                Iterator it = (Iterator) this.stack.getLast();
                N checkNotNull = Preconditions.checkNotNull(it.next());
                if (!it.hasNext()) {
                    this.stack.removeLast();
                }
                Iterator it2 = TreeTraverser.this.tree.successors(checkNotNull).iterator();
                if (it2.hasNext()) {
                    this.stack.addLast(it2);
                }
                return checkNotNull;
            }
        }

        TreeTraverser(SuccessorsFunction<N> successorsFunction) {
            super();
            this.tree = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
        }

        public Iterable<N> breadthFirst(N n) {
            Preconditions.checkNotNull(n);
            return breadthFirst((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> breadthFirst(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new BreadthFirstIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPreOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPreOrder((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPreOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstPreOrderIterator(iterable);
                }
            };
        }

        public Iterable<N> depthFirstPostOrder(N n) {
            Preconditions.checkNotNull(n);
            return depthFirstPostOrder((Iterable<? extends N>) ImmutableSet.of(n));
        }

        public Iterable<N> depthFirstPostOrder(final Iterable<? extends N> iterable) {
            Preconditions.checkNotNull(iterable);
            if (Iterables.isEmpty(iterable)) {
                return ImmutableSet.of();
            }
            for (Object checkThatNodeIsInTree : iterable) {
                checkThatNodeIsInTree(checkThatNodeIsInTree);
            }
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new DepthFirstPostOrderIterator(iterable);
                }
            };
        }

        private void checkThatNodeIsInTree(N n) {
            this.tree.successors(n);
        }
    }

    public abstract Iterable<N> breadthFirst(Iterable<? extends N> iterable);

    public abstract Iterable<N> breadthFirst(N n);

    public abstract Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPostOrder(N n);

    public abstract Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable);

    public abstract Iterable<N> depthFirstPreOrder(N n);

    public static <N> Traverser<N> forGraph(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        return new GraphTraverser(successorsFunction);
    }

    public static <N> Traverser<N> forTree(SuccessorsFunction<N> successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new TreeTraverser(successorsFunction);
    }

    private Traverser() {
    }
}
