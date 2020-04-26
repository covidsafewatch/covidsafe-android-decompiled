package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages = new HashSet();

    public void debug(String str) {
        debug(str, null);
    }

    public void debug(String str, Throwable th) {
        if (L.DBG) {
            Log.d(L.TAG, str, th);
        }
    }

    public void warning(String str) {
        warning(str, null);
    }

    public void warning(String str, Throwable th) {
        if (!loggedMessages.contains(str)) {
            Log.w(L.TAG, str, th);
            loggedMessages.add(str);
        }
    }

    public void error(String str, Throwable th) {
        if (L.DBG) {
            Log.d(L.TAG, str, th);
        }
    }
}
