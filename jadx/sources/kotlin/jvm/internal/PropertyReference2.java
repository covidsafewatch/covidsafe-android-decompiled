package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty2;

public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return Reflection.property2(this);
    }

    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public KProperty2.Getter getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }

    public Object getDelegate(Object obj, Object obj2) {
        return ((KProperty2) getReflected()).getDelegate(obj, obj2);
    }
}
