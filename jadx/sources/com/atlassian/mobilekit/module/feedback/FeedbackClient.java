package com.atlassian.mobilekit.module.feedback;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.atlassian.mobilekit.module.core.DeviceInfo;
import com.atlassian.mobilekit.module.core.JobQueue;
import com.atlassian.mobilekit.module.core.Receiver;
import com.atlassian.mobilekit.module.core.UiInfo;
import com.atlassian.mobilekit.module.core.UiInfoListener;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.feedback.commands.Result;
import com.atlassian.mobilekit.module.feedback.commands.SendFeedbackCommand;
import com.atlassian.mobilekit.module.feedback.model.CreateIssueRequest;
import com.atlassian.mobilekit.module.feedback.model.FeedbackConfig;
import com.atlassian.mobilekit.module.feedback.network.BaseApiParams;
import com.atlassian.mobilekit.module.feedback.network.JmcRestClient;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

class FeedbackClient implements Receiver<FeedbackConfig>, UiInfoListener {
    private static final Set<Class<?>> IGNORE_ACTIVITIES;
    private static final String LOG_TAG = FeedbackClient.class.getSimpleName();
    private static final String PROTOCOL_HTTPS = "https://";
    private final Map<String, String> baseQueryMap = new HashMap();
    /* access modifiers changed from: private */
    public final DeviceInfo deviceInfo;
    private FeedbackConfig feedbackConfig;
    private FeedbackDataProvider feedbackDataProvider;
    private final JobQueue jobQueue;
    private final CopyOnWriteArraySet<FeedbackNotificationListener> notificationListeners = new CopyOnWriteArraySet<>();
    private final AtomicInteger notificationViewId = new AtomicInteger(0);
    private final JmcRestClient restClient;
    private final CopyOnWriteArraySet<SendFeedbackListener> sendFeedbackListeners = new CopyOnWriteArraySet<>();
    private final FeedbackSettings settings;
    private final UiInfo uiInfo;
    private final UiNotifier uiNotifier;

    public void onAppNotVisible() {
    }

    public void onAppVisible() {
    }

    static {
        HashSet hashSet = new HashSet();
        IGNORE_ACTIVITIES = hashSet;
        hashSet.add(FeedbackActivity.class);
    }

    FeedbackClient(JmcRestClient jmcRestClient, DeviceInfo deviceInfo2, JobQueue jobQueue2, UiNotifier uiNotifier2, UiInfo uiInfo2, FeedbackSettings feedbackSettings) {
        this.restClient = jmcRestClient;
        this.jobQueue = jobQueue2;
        this.deviceInfo = deviceInfo2;
        this.uiNotifier = uiNotifier2;
        this.uiInfo = uiInfo2;
        this.settings = feedbackSettings;
        init();
    }

    private void init() {
        this.uiInfo.registerListener(this);
    }

    public void receive(FeedbackConfig feedbackConfig2) {
        this.feedbackConfig = feedbackConfig2;
        this.restClient.init(PROTOCOL_HTTPS, feedbackConfig2.getHost());
        this.baseQueryMap.put(BaseApiParams.API_KEY, feedbackConfig2.getApiKey());
        this.baseQueryMap.put(BaseApiParams.PROJECT, feedbackConfig2.getProjectKey());
    }

    /* access modifiers changed from: package-private */
    public final void sendFeedback(String str, final String str2) {
        CreateIssueRequest.Builder components = new CreateIssueRequest.Builder().summary(str).description(str).isCrash(false).udid(this.deviceInfo.getUdid()).uuid(this.deviceInfo.getUuid()).appName(this.deviceInfo.getAppName()).appId(this.deviceInfo.getAppPkgName()).systemName(this.deviceInfo.getSystemName()).deviceName(this.deviceInfo.getDeviceName()).language(this.deviceInfo.getLanguage()).components(Arrays.asList(this.feedbackConfig.getComponents()));
        setFeedbackDataProvider(new FeedbackDataProvider() {
            public String getAdditionalDescription() {
                return null;
            }

            public JiraIssueType getIssueType() {
                return JiraIssueType.SUPPORT;
            }

            public Map<String, Object> getCustomFieldsData() {
                HashMap hashMap = new HashMap();
                hashMap.put("E-mail", str2);
                hashMap.put("OS version", FeedbackClient.this.deviceInfo.getSystemVersion());
                hashMap.put("App version", FeedbackClient.this.deviceInfo.getAppVersionName());
                hashMap.put("Phone model", FeedbackClient.this.deviceInfo.getModel());
                return hashMap;
            }
        });
        this.jobQueue.enqueue(new SendFeedbackCommand(this.baseQueryMap, components, this.feedbackDataProvider, this.restClient, new SnackbarReceiver(this.uiInfo, this.uiNotifier, str, str2), this.uiNotifier));
    }

    /* access modifiers changed from: package-private */
    public final void showFeedback() {
        final Activity currentActivity = this.uiInfo.getCurrentActivity();
        if (currentActivity == null) {
            Log.e(LOG_TAG, "No usable current activity. Abort Feedback.");
        } else if (IGNORE_ACTIVITIES.contains(currentActivity.getClass())) {
            Log.e(LOG_TAG, "User is already in Feedback flow. Abort.");
        } else {
            final Context applicationContext = currentActivity.getApplicationContext();
            this.uiNotifier.post(new Runnable() {
                public void run() {
                    FeedbackClient.this.launchFeedbackScreen(currentActivity, applicationContext);
                }
            });
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void launchFeedbackScreen(android.app.Activity r2, android.content.Context r3) {
        /*
            r1 = this;
            boolean r0 = r2.isFinishing()
            if (r0 != 0) goto L_0x000c
            boolean r0 = r2.isChangingConfigurations()
            if (r0 == 0) goto L_0x000d
        L_0x000c:
            r2 = r3
        L_0x000d:
            android.content.Intent r3 = com.atlassian.mobilekit.module.feedback.FeedbackActivity.getIntent(r2)
            r2.startActivity(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atlassian.mobilekit.module.feedback.FeedbackClient.launchFeedbackScreen(android.app.Activity, android.content.Context):void");
    }

    private void setFeedbackDataProvider(FeedbackDataProvider feedbackDataProvider2) {
        this.feedbackDataProvider = feedbackDataProvider2;
    }

    /* access modifiers changed from: package-private */
    public final int getNotificationViewId() {
        return this.notificationViewId.get();
    }

    /* access modifiers changed from: package-private */
    public final void registerSendFeedbackListener(SendFeedbackListener sendFeedbackListener) {
        this.sendFeedbackListeners.add(sendFeedbackListener);
    }

    /* access modifiers changed from: package-private */
    public final void unregisterSendFeedbackListener(SendFeedbackListener sendFeedbackListener) {
        this.sendFeedbackListeners.remove(sendFeedbackListener);
    }

    /* access modifiers changed from: package-private */
    public final void notifySendCompleted(Result result) {
        Iterator<SendFeedbackListener> it = this.sendFeedbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onSendCompleted(result);
        }
    }

    /* access modifiers changed from: package-private */
    public final void notificationStarted() {
        Iterator<FeedbackNotificationListener> it = this.notificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onNotificationStarted();
        }
    }

    /* access modifiers changed from: package-private */
    public final void notificationDismissed() {
        Iterator<FeedbackNotificationListener> it = this.notificationListeners.iterator();
        while (it.hasNext()) {
            it.next().onNotificationDismissed();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setEnableDialogDisplayed() {
        this.settings.setEnableDialogDisplayed();
    }
}
