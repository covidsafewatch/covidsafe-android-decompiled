package com.google.common.base;

interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
