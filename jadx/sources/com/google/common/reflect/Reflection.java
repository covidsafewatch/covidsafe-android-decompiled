package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class Reflection {
    public static String getPackageName(Class<?> cls) {
        return getPackageName(cls.getName());
    }

    public static String getPackageName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static void initialize(Class<?>... clsArr) {
        int length = clsArr.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = clsArr[i];
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                i++;
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        Preconditions.checkNotNull(invocationHandler);
        Preconditions.checkArgument(cls.isInterface(), "%s is not an interface", (Object) cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    private Reflection() {
    }
}
