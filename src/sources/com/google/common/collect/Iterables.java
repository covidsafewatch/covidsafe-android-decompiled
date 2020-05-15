package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Iterables {
    private Iterables() {
    }

    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.checkNotNull(immutableCollection);
    }

    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        private UnmodifiableIterable(Iterable<? extends T> iterable2) {
            this.iterable = iterable2;
        }

        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        public String toString() {
            return this.iterable.toString();
        }
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Collection) {
            return Collections2.safeContains((Collection) iterable, obj);
        }
        return Iterators.contains(iterable.iterator(), obj);
    }

    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.removeAll(iterable.iterator(), collection);
    }

    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).retainAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.retainAll(iterable.iterator(), collection);
    }

    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            return Iterators.removeIf(iterable.iterator(), predicate);
        }
        return removeIfFromRandomAccessList((List) iterable, (Predicate) Preconditions.checkNotNull(predicate));
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!predicate.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (UnsupportedOperationException unused) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        slowRemoveIfForRemainingElements(list, predicate, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        if (i != i2) {
            return true;
        }
        return false;
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    @NullableDecl
    static <T> T removeFirstMatching(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if (!(iterable instanceof Collection) || !(iterable2 instanceof Collection) || ((Collection) iterable).size() == ((Collection) iterable2).size()) {
            return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        }
        return false;
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @NullableDecl T t) {
        return Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> cls) {
        return toArray(iterable, (T[]) ObjectArrays.newArray(cls, 0));
    }

    static <T> T[] toArray(Iterable<? extends T> iterable, T[] tArr) {
        return castOrCopyToCollection(iterable).toArray(tArr);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.newArrayList(iterable.iterator());
    }

    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(Collections2.cast(iterable));
        }
        return Iterators.addAll(collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static int frequency(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.cycle(iterable);
            }

            public String toString() {
                return iterable.toString() + " (cycled)";
            }
        };
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList((E[]) tArr));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.concat(iterable, iterable2);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.concat(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... iterableArr) {
        return FluentIterable.concat(iterableArr);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.concat(iterable);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() {
            public Iterator<List<T>> iterator() {
                return Iterators.partition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() {
            public Iterator<List<T>> iterator() {
                return Iterators.paddedPartition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<T> filter(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.filter(iterable.iterator(), predicate);
            }
        };
    }

    public static <T> Iterable<T> filter(Iterable<?> iterable, Class<T> cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return filter(iterable, Predicates.instanceOf(cls));
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.find(iterable.iterator(), predicate);
    }

    @NullableDecl
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @NullableDecl T t) {
        return Iterators.find(iterable.iterator(), predicate, t);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.transform(iterable.iterator(), function);
            }
        };
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return ((List) iterable).get(i);
        }
        return Iterators.get(iterable.iterator(), i);
    }

    @NullableDecl
    public static <T> T get(Iterable<? extends T> iterable, int i, @NullableDecl T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(i);
        if (iterable instanceof List) {
            List<? extends T> cast = Lists.cast(iterable);
            return i < cast.size() ? cast.get(i) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.advance(it, i);
        return Iterators.getNext(it, t);
    }

    @NullableDecl
    public static <T> T getFirst(Iterable<? extends T> iterable, @NullableDecl T t) {
        return Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.getLast(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return getLastInNonemptyList(list);
        }
        throw new NoSuchElementException();
    }

    @NullableDecl
    public static <T> T getLast(Iterable<? extends T> iterable, @NullableDecl T t) {
        if (iterable instanceof Collection) {
            if (Collections2.cast(iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return Iterators.getLast(iterable.iterator(), t);
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                Iterable iterable = iterable;
                if (iterable instanceof List) {
                    List list = (List) iterable;
                    return list.subList(Math.min(list.size(), i), list.size()).iterator();
                }
                final Iterator it = iterable.iterator();
                Iterators.advance(it, i);
                return new Iterator<T>() {
                    boolean atStart = true;

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public T next() {
                        T next = it.next();
                        this.atStart = false;
                        return next;
                    }

                    public void remove() {
                        CollectPreconditions.checkRemove(!this.atStart);
                        it.remove();
                    }
                };
            }
        };
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "limit is negative");
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.limit(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            public String toString() {
                return "Iterables.consumingIterable(...)";
            }

            public Iterator<T> iterator() {
                Iterable iterable = iterable;
                if (iterable instanceof Queue) {
                    return new ConsumingQueueIterator((Queue) iterable);
                }
                return Iterators.consumingIterator(iterable.iterator());
            }
        };
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterable, final Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.mergeSorted(Iterables.transform(iterable, Iterables.toIterator()), comparator);
            }
        });
    }

    static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new Function<Iterable<? extends T>, Iterator<? extends T>>() {
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }
}
