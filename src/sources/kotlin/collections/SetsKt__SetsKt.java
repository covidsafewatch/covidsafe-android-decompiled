package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001f\b\u0001\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b\u001a\u001f\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000bH\b\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\rj\b\u0012\u0004\u0012\u0002H\u000b`\u000e\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0011\u001a\u001f\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000bH\b\u001a5\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u000b0\u0013j\b\u0012\u0004\u0012\u0002H\u000b`\u0014\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000bH\b\u001a+\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000bH\b\u001a+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u000b0\u0010\"\u0002H\u000b¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0000\u001a!\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0001H\b¨\u0006\u001b"}, d2 = {"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/collections/SetsKt")
/* compiled from: Sets.kt */
class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        return tArr.length > 0 ? ArraysKt.toSet(tArr) : SetsKt.emptySet();
    }

    private static final <T> Set<T> setOf() {
        return SetsKt.emptySet();
    }

    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet<>();
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        return (Set) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        return (HashSet) ArraysKt.toCollection(tArr, new HashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "elements");
        return (LinkedHashSet) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <E> Set<E> buildSet(Function1<? super Set<E>, Unit> function1) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        function1.invoke(linkedHashSet);
        return linkedHashSet;
    }

    private static final <E> Set<E> buildSet(int i, Function1<? super Set<E>, Unit> function1) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(i));
        function1.invoke(linkedHashSet);
        return linkedHashSet;
    }

    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        return set != null ? set : SetsKt.emptySet();
    }

    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics.checkParameterIsNotNull(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size == 0) {
            return SetsKt.emptySet();
        }
        if (size != 1) {
            return set;
        }
        return SetsKt.setOf(set.iterator().next());
    }
}
