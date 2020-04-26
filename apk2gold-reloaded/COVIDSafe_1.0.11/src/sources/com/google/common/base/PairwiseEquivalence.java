package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<? super T> elementEquivalence;

    PairwiseEquivalence(Equivalence<? super T> equivalence) {
        this.elementEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    /* access modifiers changed from: protected */
    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        do {
            boolean z = false;
            if (!it.hasNext() || !it2.hasNext()) {
                if (!it.hasNext() && !it2.hasNext()) {
                    z = true;
                }
                return z;
            }
        } while (this.elementEquivalence.equivalent(it.next(), it2.next()));
        return false;
    }

    /* access modifiers changed from: protected */
    public int doHash(Iterable<T> iterable) {
        int i = 78721;
        for (T hash : iterable) {
            i = (i * 24943) + this.elementEquivalence.hash(hash);
        }
        return i;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof PairwiseEquivalence)) {
            return false;
        }
        return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.elementEquivalence);
        sb.append(".pairwise()");
        return sb.toString();
    }
}
