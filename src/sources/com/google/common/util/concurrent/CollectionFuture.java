package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
    private List<Optional<V>> values;

    /* access modifiers changed from: package-private */
    public abstract C combine(List<Optional<V>> list);

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
        super(immutableCollection, z, true);
        List<Optional<V>> list;
        if (immutableCollection.isEmpty()) {
            list = ImmutableList.of();
        } else {
            list = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        this.values = list;
        for (int i = 0; i < immutableCollection.size(); i++) {
            this.values.add((Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void collectOneValue(int i, @NullableDecl V v) {
        List<Optional<V>> list = this.values;
        if (list != null) {
            list.set(i, Optional.fromNullable(v));
        }
    }

    /* access modifiers changed from: package-private */
    public final void handleAllCompleted() {
        List<Optional<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            init();
        }

        public List<V> combine(List<Optional<V>> list) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator<Optional<V>> it = list.iterator();
            while (it.hasNext()) {
                Optional next = it.next();
                newArrayListWithCapacity.add(next != null ? next.orNull() : null);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }
}
