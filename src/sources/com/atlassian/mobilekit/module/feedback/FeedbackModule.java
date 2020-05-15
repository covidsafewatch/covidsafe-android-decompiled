package com.atlassian.mobilekit.module.feedback;

import android.app.Application;
import com.atlassian.mobilekit.module.core.ActivityTracker;
import com.atlassian.mobilekit.module.core.AndroidUiNotifier;
import com.atlassian.mobilekit.module.core.DeviceInfo;
import com.atlassian.mobilekit.module.core.JobQueue;
import com.atlassian.mobilekit.module.core.UiInfo;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.feedback.commands.LoadFeedbackConfigCommand;
import com.atlassian.mobilekit.module.feedback.commands.Result;
import com.atlassian.mobilekit.module.feedback.network.JmcRestClient;

public final class FeedbackModule {
    private static final String NAMESPACE = "com.atlassian.mobilekit.module.feedback";
    private static final String STORE_NAME = "com.atlassian.mobilekit.module.feedback.preferences";
    private static UiInfo activityTracker;
    private static UiNotifier androidUiNotifier = new AndroidUiNotifier();
    private static FeedbackClient feedbackClient;
    private static JobQueue jobQueue;

    private FeedbackModule() {
        throw new AssertionError("Instances of this class are not allowed.");
    }

    public static void init(Application application) {
        if (feedbackClient == null) {
            jobQueue = new JobQueue();
            activityTracker = new ActivityTracker(application);
            feedbackClient = new FeedbackClient(new JmcRestClient(), new DeviceInfo(application.getApplicationContext()), jobQueue, androidUiNotifier, activityTracker, new FeedbackSettings(application.getSharedPreferences(STORE_NAME, 0)));
        }
        jobQueue.enqueue(new LoadFeedbackConfigCommand(application.getApplicationContext(), feedbackClient, androidUiNotifier));
    }

    public static void showFeedbackScreen() {
        feedbackClient.showFeedback();
    }

    static void notificationStarted() {
        feedbackClient.notificationStarted();
    }

    static void notificationDismissed() {
        feedbackClient.notificationDismissed();
    }

    static int getNotificationViewId() {
        return feedbackClient.getNotificationViewId();
    }

    static void sendFeedback(String str, String str2) {
        feedbackClient.sendFeedback(str, str2);
    }

    static void setEnableDialogDisplayed() {
        feedbackClient.setEnableDialogDisplayed();
    }

    static void registerSendFeedbackListener(SendFeedbackListener sendFeedbackListener) {
        feedbackClient.registerSendFeedbackListener(sendFeedbackListener);
    }

    static void unregisterSendFeedbackListener(SendFeedbackListener sendFeedbackListener) {
        feedbackClient.unregisterSendFeedbackListener(sendFeedbackListener);
    }

    static void notifySendCompleted(Result result) {
        feedbackClient.notifySendCompleted(result);
    }
}
