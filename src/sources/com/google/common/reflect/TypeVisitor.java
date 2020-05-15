package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

abstract class TypeVisitor {
    private final Set<Type> visited = Sets.newHashSet();

    /* access modifiers changed from: package-private */
    public void visitClass(Class<?> cls) {
    }

    /* access modifiers changed from: package-private */
    public void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    /* access modifiers changed from: package-private */
    public void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    /* access modifiers changed from: package-private */
    public void visitTypeVariable(TypeVariable<?> typeVariable) {
    }

    /* access modifiers changed from: package-private */
    public void visitWildcardType(WildcardType wildcardType) {
    }

    TypeVisitor() {
    }

    public final void visit(Type... typeArr) {
        for (TypeVariable typeVariable : typeArr) {
            if (typeVariable != null && this.visited.add(typeVariable)) {
                try {
                    if (typeVariable instanceof TypeVariable) {
                        visitTypeVariable(typeVariable);
                    } else if (typeVariable instanceof WildcardType) {
                        visitWildcardType((WildcardType) typeVariable);
                    } else if (typeVariable instanceof ParameterizedType) {
                        visitParameterizedType(typeVariable);
                    } else if (typeVariable instanceof Class) {
                        visitClass(typeVariable);
                    } else if (typeVariable instanceof GenericArrayType) {
                        visitGenericArrayType(typeVariable);
                    } else {
                        throw new AssertionError("Unknown type: " + typeVariable);
                    }
                } catch (Throwable th) {
                    this.visited.remove(typeVariable);
                    throw th;
                }
            }
        }
    }
}
