package com.google.common.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Defaults {
    private static final Double DOUBLE_DEFAULT = Double.valueOf(0.0d);
    private static final Float FLOAT_DEFAULT = Float.valueOf(0.0f);

    private Defaults() {
    }

    @NullableDecl
    public static <T> T defaultValue(Class<T> cls) {
        Preconditions.checkNotNull(cls);
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return 0;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return FLOAT_DEFAULT;
        }
        if (cls == Double.TYPE) {
            return DOUBLE_DEFAULT;
        }
        return null;
    }
}
