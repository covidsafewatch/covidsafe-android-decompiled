package com.google.common.base;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class MoreObjects {
    public static <T> T firstNonNull(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String str, @NullableDecl Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper add(String str, boolean z) {
            return addHolder(str, String.valueOf(z));
        }

        public ToStringHelper add(String str, char c) {
            return addHolder(str, String.valueOf(c));
        }

        public ToStringHelper add(String str, double d) {
            return addHolder(str, String.valueOf(d));
        }

        public ToStringHelper add(String str, float f) {
            return addHolder(str, String.valueOf(f));
        }

        public ToStringHelper add(String str, int i) {
            return addHolder(str, String.valueOf(i));
        }

        public ToStringHelper add(String str, long j) {
            return addHolder(str, String.valueOf(j));
        }

        public ToStringHelper addValue(@NullableDecl Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper addValue(boolean z) {
            return addHolder(String.valueOf(z));
        }

        public ToStringHelper addValue(char c) {
            return addHolder(String.valueOf(c));
        }

        public ToStringHelper addValue(double d) {
            return addHolder(String.valueOf(d));
        }

        public ToStringHelper addValue(float f) {
            return addHolder(String.valueOf(f));
        }

        public ToStringHelper addValue(int i) {
            return addHolder(String.valueOf(i));
        }

        public ToStringHelper addValue(long j) {
            return addHolder(String.valueOf(j));
        }

        public String toString() {
            boolean z = this.omitNullValues;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.className);
            sb.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z || obj != null) {
                    sb.append(str);
                    if (valueHolder.name != null) {
                        sb.append(valueHolder.name);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append(deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(@NullableDecl Object obj) {
            addHolder().value = obj;
            return this;
        }

        private ToStringHelper addHolder(String str, @NullableDecl Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private static final class ValueHolder {
            @NullableDecl
            String name;
            @NullableDecl
            ValueHolder next;
            @NullableDecl
            Object value;

            private ValueHolder() {
            }
        }
    }

    private MoreObjects() {
    }
}
