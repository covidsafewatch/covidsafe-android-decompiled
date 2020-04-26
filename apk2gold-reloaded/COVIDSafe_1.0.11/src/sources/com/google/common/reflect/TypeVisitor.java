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

    /* access modifiers changed from: 0000 */
    public void visitClass(Class<?> cls) {
    }

    /* access modifiers changed from: 0000 */
    public void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    /* access modifiers changed from: 0000 */
    public void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    /* access modifiers changed from: 0000 */
    public void visitTypeVariable(TypeVariable<?> typeVariable) {
    }

    /* access modifiers changed from: 0000 */
    public void visitWildcardType(WildcardType wildcardType) {
    }

    TypeVisitor() {
    }

    public final void visit(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.visited.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        visitTypeVariable((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        visitWildcardType((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        visitParameterizedType((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        visitClass((Class) type);
                    } else if (type instanceof GenericArrayType) {
                        visitGenericArrayType((GenericArrayType) type);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown type: ");
                        sb.append(type);
                        throw new AssertionError(sb.toString());
                    }
                } catch (Throwable th) {
                    this.visited.remove(type);
                    throw th;
                }
            }
        }
    }
}
