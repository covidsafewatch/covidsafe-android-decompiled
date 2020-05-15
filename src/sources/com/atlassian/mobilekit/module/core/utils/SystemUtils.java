package com.atlassian.mobilekit.module.core.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SystemUtils {
    public static void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
