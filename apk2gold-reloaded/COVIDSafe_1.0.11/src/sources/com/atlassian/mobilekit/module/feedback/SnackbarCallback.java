package com.atlassian.mobilekit.module.feedback;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.Snackbar.Callback;

public class SnackbarCallback extends Callback {
    private boolean isDismissed = false;

    public void onDismissed(Snackbar snackbar, int i) {
        super.onDismissed(snackbar, i);
        if (!this.isDismissed) {
            this.isDismissed = true;
            FeedbackModule.notificationDismissed();
        }
    }
}
