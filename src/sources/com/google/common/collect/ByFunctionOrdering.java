package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(Function<F, ? extends T> function2, Ordering<T> ordering2) {
        this.function = (Function) Preconditions.checkNotNull(function2);
        this.ordering = (Ordering) Preconditions.checkNotNull(ordering2);
    }

    public int compare(F f, F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (!this.function.equals(byFunctionOrdering.function) || !this.ordering.equals(byFunctionOrdering.ordering)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
