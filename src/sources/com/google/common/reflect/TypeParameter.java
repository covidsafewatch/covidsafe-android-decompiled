package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class TypeParameter<T> extends TypeCapture<T> {
    final TypeVariable<?> typeVariable;

    protected TypeParameter() {
        Type capture = capture();
        Preconditions.checkArgument(capture instanceof TypeVariable, "%s should be a type variable.", (Object) capture);
        this.typeVariable = (TypeVariable) capture;
    }

    public final int hashCode() {
        return this.typeVariable.hashCode();
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof TypeParameter) {
            return this.typeVariable.equals(((TypeParameter) obj).typeVariable);
        }
        return false;
    }

    public String toString() {
        return this.typeVariable.toString();
    }
}
