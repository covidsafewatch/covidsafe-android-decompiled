package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class PropertyReference2Impl extends PropertyReference2 {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public PropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.owner = kDeclarationContainer;
        this.name = str;
        this.signature = str2;
    }

    public KDeclarationContainer getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }
}
