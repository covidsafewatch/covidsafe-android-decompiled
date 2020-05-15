package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class PropertyReference1Impl extends PropertyReference1 {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
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

    public Object get(Object obj) {
        return getGetter().call(obj);
    }
}
