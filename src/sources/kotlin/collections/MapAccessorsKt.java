package kotlin.collections;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0002\u0010\n\u001a@\u0010\u0000\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\b¢\u0006\u0004\b\f\u0010\n\u001aO\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000b\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0004\b\r\u0010\n\u001aF\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVarContravariant", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* compiled from: MapAccessors.kt */
public final class MapAccessorsKt {
    private static final <V, V1 extends V> V1 getValue(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(map, "$this$getValue");
        return MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    private static final <V, V1 extends V> V1 getVar(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkParameterIsNotNull(map, "$this$getValue");
        return MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use getValue() with two type parameters instead")
    private static final <V> V getVarContravariant(Map<? super String, ? super V> map, Object obj, KProperty<?> kProperty) {
        return MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    private static final <V> void setValue(Map<? super String, ? super V> map, Object obj, KProperty<?> kProperty, V v) {
        Intrinsics.checkParameterIsNotNull(map, "$this$setValue");
        map.put(kProperty.getName(), v);
    }
}
