package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

final class UnsafeReflectionAccessor extends ReflectionAccessor {
    private static Class unsafeClass;
    private final Field overrideField = getOverrideField();
    private final Object theUnsafe = getUnsafeInstance();

    UnsafeReflectionAccessor() {
    }

    public void makeAccessible(AccessibleObject accessibleObject) {
        if (!makeAccessibleWithUnsafe(accessibleObject)) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean makeAccessibleWithUnsafe(AccessibleObject accessibleObject) {
        if (!(this.theUnsafe == null || this.overrideField == null)) {
            try {
                long longValue = ((Long) unsafeClass.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.theUnsafe, new Object[]{this.overrideField})).longValue();
                unsafeClass.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.theUnsafe, new Object[]{accessibleObject, Long.valueOf(longValue), true});
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object getUnsafeInstance() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            unsafeClass = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field getOverrideField() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
