package com.atlassian.mobilekit.module.feedback;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarBuilder {
    private SnackbarBuilder() {
    }

    public static Snackbar build(Activity activity, int i) {
        return Snackbar.make(getNotificationView(activity), (CharSequence) applyColorSpan(activity.getString(i)), 0);
    }

    private static SpannableStringBuilder applyColorSpan(String str) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    private static View getNotificationView(Activity activity) {
        int notificationViewId = FeedbackModule.getNotificationViewId();
        if (notificationViewId == 0) {
            notificationViewId = 16908290;
        }
        View findViewById = activity.findViewById(notificationViewId);
        return findViewById == null ? activity.findViewById(16908290) : findViewById;
    }
}
