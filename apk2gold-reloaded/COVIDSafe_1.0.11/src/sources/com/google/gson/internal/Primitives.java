package com.google.gson.internal;

import java.lang.reflect.Type;

public final class Primitives {
    private Primitives() {
    }

    public static boolean isPrimitive(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public static boolean isWrapperType(Type type) {
        return type == Integer.class || type == Float.class || type == Byte.class || type == Double.class || type == Long.class || type == Character.class || type == Boolean.class || type == Short.class || type == Void.class;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<T>, code=java.lang.Class, for r1v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.lang.Class<T> wrap(java.lang.Class r1) {
        /*
            java.lang.Class r0 = java.lang.Integer.TYPE
            if (r1 != r0) goto L_0x0007
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            return r1
        L_0x0007:
            java.lang.Class r0 = java.lang.Float.TYPE
            if (r1 != r0) goto L_0x000e
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            return r1
        L_0x000e:
            java.lang.Class r0 = java.lang.Byte.TYPE
            if (r1 != r0) goto L_0x0015
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            return r1
        L_0x0015:
            java.lang.Class r0 = java.lang.Double.TYPE
            if (r1 != r0) goto L_0x001c
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            return r1
        L_0x001c:
            java.lang.Class r0 = java.lang.Long.TYPE
            if (r1 != r0) goto L_0x0023
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            return r1
        L_0x0023:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r1 != r0) goto L_0x002a
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            return r1
        L_0x002a:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            if (r1 != r0) goto L_0x0031
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            return r1
        L_0x0031:
            java.lang.Class r0 = java.lang.Short.TYPE
            if (r1 != r0) goto L_0x0038
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            return r1
        L_0x0038:
            java.lang.Class r0 = java.lang.Void.TYPE
            if (r1 != r0) goto L_0x003e
            java.lang.Class<java.lang.Void> r1 = java.lang.Void.class
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Primitives.wrap(java.lang.Class):java.lang.Class");
    }

    public static <T> Class<T> unwrap(Class<T> cls) {
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Void.class) {
            cls = Void.TYPE;
        }
        return cls;
    }
}
