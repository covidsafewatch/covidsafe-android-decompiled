package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return Reflection.property0(this);
    }

    public Object invoke() {
        return get();
    }

    public KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }
}
