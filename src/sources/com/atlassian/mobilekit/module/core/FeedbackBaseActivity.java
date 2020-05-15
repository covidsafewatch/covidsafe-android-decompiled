package com.atlassian.mobilekit.module.core;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackBaseActivity extends AppCompatActivity {
    private boolean isPaused;
    private long pausedAt;

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        this.pausedAt = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        this.pausedAt = 0;
    }

    /* access modifiers changed from: protected */
    public boolean isPaused() {
        return this.isPaused;
    }

    /* access modifiers changed from: protected */
    public long getPausedDuration() {
        return System.currentTimeMillis() - this.pausedAt;
    }
}
