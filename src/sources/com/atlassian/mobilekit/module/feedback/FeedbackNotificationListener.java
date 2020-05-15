package com.atlassian.mobilekit.module.feedback;

public interface FeedbackNotificationListener {
    void onNotificationDismissed();

    void onNotificationStarted();
}
