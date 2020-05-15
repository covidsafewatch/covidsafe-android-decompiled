package com.atlassian.mobilekit.module.core;

import android.os.Handler;
import android.os.Looper;

public class AndroidUiNotifier implements UiNotifier {
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public void post(Runnable runnable) {
        this.uiHandler.post(runnable);
    }

    public void postDelayed(Runnable runnable, int i) {
        this.uiHandler.postDelayed(runnable, (long) i);
    }
}
