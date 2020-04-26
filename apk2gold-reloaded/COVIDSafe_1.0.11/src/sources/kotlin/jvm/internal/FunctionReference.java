package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;

    public FunctionReference(int i) {
        this.arity = i;
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    /* access modifiers changed from: protected */
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(getBoundReceiver(), r5.getBoundReceiver()) != false) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof kotlin.jvm.internal.FunctionReference
            r2 = 0
            if (r1 == 0) goto L_0x0053
            kotlin.jvm.internal.FunctionReference r5 = (kotlin.jvm.internal.FunctionReference) r5
            kotlin.reflect.KDeclarationContainer r1 = r4.getOwner()
            if (r1 != 0) goto L_0x0018
            kotlin.reflect.KDeclarationContainer r1 = r5.getOwner()
            if (r1 != 0) goto L_0x0051
            goto L_0x0026
        L_0x0018:
            kotlin.reflect.KDeclarationContainer r1 = r4.getOwner()
            kotlin.reflect.KDeclarationContainer r3 = r5.getOwner()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0051
        L_0x0026:
            java.lang.String r1 = r4.getName()
            java.lang.String r3 = r5.getName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r4.getSignature()
            java.lang.String r3 = r5.getSignature()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r4.getBoundReceiver()
            java.lang.Object r5 = r5.getBoundReceiver()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r5 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            return r0
        L_0x0053:
            boolean r0 = r5 instanceof kotlin.reflect.KFunction
            if (r0 == 0) goto L_0x0060
            kotlin.reflect.KCallable r0 = r4.compute()
            boolean r5 = r5.equals(r0)
            return r5
        L_0x0060:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.FunctionReference.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        String str;
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            str = "constructor (Kotlin reflection is not available)";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("function ");
            sb.append(getName());
            sb.append(" (Kotlin reflection is not available)");
            str = sb.toString();
        }
        return str;
    }
}
