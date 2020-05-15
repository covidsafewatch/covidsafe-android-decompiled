package com.atlassian.mobilekit.module.feedback;

import android.content.SharedPreferences;

class FeedbackSettings {
    private static final String KEY_ENABLE_DIALOG_SHOWN = "enable_dialog_shown";
    private final SharedPreferences store;

    FeedbackSettings(SharedPreferences sharedPreferences) {
        this.store = sharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public final void setEnableDialogDisplayed() {
        SharedPreferences.Editor edit = this.store.edit();
        edit.putBoolean(KEY_ENABLE_DIALOG_SHOWN, true);
        edit.apply();
    }
}
