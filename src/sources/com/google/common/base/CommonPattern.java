package com.google.common.base;

abstract class CommonPattern {
    public abstract int flags();

    public abstract CommonMatcher matcher(CharSequence charSequence);

    public abstract String pattern();

    public abstract String toString();

    CommonPattern() {
    }

    public static CommonPattern compile(String str) {
        return Platform.compilePattern(str);
    }

    public static boolean isPcreLike() {
        return Platform.patternCompilerIsPcreLike();
    }
}
