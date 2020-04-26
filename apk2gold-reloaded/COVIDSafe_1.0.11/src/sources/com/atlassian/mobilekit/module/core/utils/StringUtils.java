package com.atlassian.mobilekit.module.core.utils;

import android.text.TextUtils;

public final class StringUtils {
    private static final String ELLIPSIS = "…";
    private static final int ELLIPSIS_LEN = 1;
    public static final String EOL = "\n";

    private StringUtils() {
    }

    public static String ellipsize(String str, int i) {
        if (TextUtils.isEmpty(str) || str.length() <= ELLIPSIS_LEN + i) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, i));
        sb.append(ELLIPSIS);
        return sb.toString();
    }
}
