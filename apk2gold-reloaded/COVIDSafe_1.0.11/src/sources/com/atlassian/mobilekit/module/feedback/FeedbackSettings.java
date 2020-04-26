package com.atlassian.mobilekit.module.feedback;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class FeedbackSettings {
    private static final String KEY_ENABLE_DIALOG_SHOWN = "enable_dialog_shown";
    private final SharedPreferences store;

    FeedbackSettings(SharedPreferences sharedPreferences) {
        this.store = sharedPreferences;
    }

    /* access modifiers changed from: 0000 */
    public final void setEnableDialogDisplayed() {
        Editor edit = this.store.edit();
        edit.putBoolean(KEY_ENABLE_DIALOG_SHOWN, true);
        edit.apply();
    }
}
