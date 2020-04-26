package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/FloatCompanionObject;", "", "()V", "MAX_VALUE", "", "getMAX_VALUE", "()F", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", "NaN", "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: PrimitiveCompanionObjects.kt */
public final class FloatCompanionObject {
    public static final FloatCompanionObject INSTANCE = new FloatCompanionObject();
    private static final float MAX_VALUE = Float.MAX_VALUE;
    private static final float MIN_VALUE = MIN_VALUE;
    private static final float NEGATIVE_INFINITY = NEGATIVE_INFINITY;
    private static final float NaN = NaN;
    private static final float POSITIVE_INFINITY = POSITIVE_INFINITY;

    private FloatCompanionObject() {
    }

    public final float getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final float getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final float getPOSITIVE_INFINITY() {
        return POSITIVE_INFINITY;
    }

    public final float getNEGATIVE_INFINITY() {
        return NEGATIVE_INFINITY;
    }

    public final float getNaN() {
        return NaN;
    }
}
