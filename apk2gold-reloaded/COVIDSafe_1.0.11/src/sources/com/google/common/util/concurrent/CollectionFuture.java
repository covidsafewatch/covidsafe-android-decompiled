package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    private List<Optional<V>> values;

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            init();
        }

        public List<V> combine(List<Optional<V>> list) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            for (Optional optional : list) {
                newArrayListWithCapacity.add(optional != null ? optional.orNull() : null);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract C combine(List<Optional<V>> list);

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
        List<Optional<V>> list;
        super(immutableCollection, z, true);
        if (immutableCollection.isEmpty()) {
            list = ImmutableList.of();
        } else {
            list = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        this.values = list;
        for (int i = 0; i < immutableCollection.size(); i++) {
            this.values.add(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void collectOneValue(int i, @NullableDecl V v) {
        List<Optional<V>> list = this.values;
        if (list != null) {
            list.set(i, Optional.fromNullable(v));
        }
    }

    /* access modifiers changed from: 0000 */
    public final void handleAllCompleted() {
        List<Optional<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    /* access modifiers changed from: 0000 */
    public void releaseResources(ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }
}
