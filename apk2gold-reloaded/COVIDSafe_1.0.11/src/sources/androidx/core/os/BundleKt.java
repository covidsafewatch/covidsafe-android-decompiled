package androidx.core.os;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Bundle.kt */
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkParameterIsNotNull(pairArr, "pairs");
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                bundle.putString(str, null);
            } else if (component2 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) component2).booleanValue());
            } else if (component2 instanceof Byte) {
                bundle.putByte(str, ((Number) component2).byteValue());
            } else if (component2 instanceof Character) {
                bundle.putChar(str, ((Character) component2).charValue());
            } else if (component2 instanceof Double) {
                bundle.putDouble(str, ((Number) component2).doubleValue());
            } else if (component2 instanceof Float) {
                bundle.putFloat(str, ((Number) component2).floatValue());
            } else if (component2 instanceof Integer) {
                bundle.putInt(str, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                bundle.putLong(str, ((Number) component2).longValue());
            } else if (component2 instanceof Short) {
                bundle.putShort(str, ((Number) component2).shortValue());
            } else if (component2 instanceof Bundle) {
                bundle.putBundle(str, (Bundle) component2);
            } else if (component2 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) component2);
            } else if (component2 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) component2);
            } else if (component2 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) component2);
            } else if (component2 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) component2);
            } else if (component2 instanceof char[]) {
                bundle.putCharArray(str, (char[]) component2);
            } else if (component2 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) component2);
            } else if (component2 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) component2);
            } else if (component2 instanceof int[]) {
                bundle.putIntArray(str, (int[]) component2);
            } else if (component2 instanceof long[]) {
                bundle.putLongArray(str, (long[]) component2);
            } else if (component2 instanceof short[]) {
                bundle.putShortArray(str, (short[]) component2);
            } else {
                String str2 = " for key \"";
                if (component2 instanceof Object[]) {
                    Class componentType = component2.getClass().getComponentType();
                    if (componentType == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(componentType, "value::class.java.componentType!!");
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        if (component2 != null) {
                            bundle.putParcelableArray(str, (Parcelable[]) component2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                        }
                    } else if (String.class.isAssignableFrom(componentType)) {
                        if (component2 != null) {
                            bundle.putStringArray(str, (String[]) component2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                        }
                    } else if (CharSequence.class.isAssignableFrom(componentType)) {
                        if (component2 != null) {
                            bundle.putCharSequenceArray(str, (CharSequence[]) component2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                        }
                    } else if (Serializable.class.isAssignableFrom(componentType)) {
                        bundle.putSerializable(str, (Serializable) component2);
                    } else {
                        String canonicalName = componentType.getCanonicalName();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Illegal value array type ");
                        sb.append(canonicalName);
                        sb.append(str2);
                        sb.append(str);
                        sb.append(Typography.quote);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else if (component2 instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) component2);
                } else if (VERSION.SDK_INT >= 18 && (component2 instanceof Binder)) {
                    bundle.putBinder(str, (IBinder) component2);
                } else if (VERSION.SDK_INT >= 21 && (component2 instanceof Size)) {
                    bundle.putSize(str, (Size) component2);
                } else if (VERSION.SDK_INT < 21 || !(component2 instanceof SizeF)) {
                    String canonicalName2 = component2.getClass().getCanonicalName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal value type ");
                    sb2.append(canonicalName2);
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(Typography.quote);
                    throw new IllegalArgumentException(sb2.toString());
                } else {
                    bundle.putSizeF(str, (SizeF) component2);
                }
            }
        }
        return bundle;
    }
}
