package com.atlassian.mobilekit.module.feedback;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import com.atlassian.mobilekit.module.core.UiInfo;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.core.UiReceiver;
import com.atlassian.mobilekit.module.feedback.commands.Result;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarReceiver implements UiReceiver<Result> {
    /* access modifiers changed from: private */
    public final String email;
    /* access modifiers changed from: private */
    public final String message;
    private final Runnable showFailureRunnable = new Runnable() {
        private int numOfRetries;

        public void run() {
            final Activity currentActivity = SnackbarReceiver.this.uiInfo.getCurrentActivity();
            if (!SnackbarReceiver.this.uiInfo.isAppVisible()) {
                FeedbackModule.notifySendCompleted(Result.FAIL);
            } else if (currentActivity == null) {
                int i = this.numOfRetries;
                if (i < 3) {
                    this.numOfRetries = i + 1;
                    SnackbarReceiver.this.uiNotifier.postDelayed(this, Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                } else {
                    FeedbackModule.notifySendCompleted(Result.FAIL);
                }
            } else {
                FeedbackModule.notifySendCompleted(Result.FAIL);
                final Snackbar build = SnackbarBuilder.build(currentActivity, R.string.mk_fb_feedback_failed);
                final SnackbarCallback snackbarCallback = new SnackbarCallback();
                build.addCallback(snackbarCallback);
                build.setAction(R.string.mk_fb_retry, (OnClickListener) new OnClickListener() {
                    public void onClick(View view) {
                        FeedbackModule.sendFeedback(SnackbarReceiver.this.message, SnackbarReceiver.this.email);
                        build.removeCallback(snackbarCallback);
                        SnackbarReceiver.showProgressBar(currentActivity);
                        FeedbackModule.notificationDismissed();
                    }
                });
                FeedbackModule.notificationStarted();
                SnackbarReceiver.dismissProgressBar(currentActivity);
                build.show();
            }
        }
    };
    private final Runnable showSuccessRunnable = new Runnable() {
        private int numOfRetries;

        public void run() {
            final Activity currentActivity = SnackbarReceiver.this.uiInfo.getCurrentActivity();
            if (!SnackbarReceiver.this.uiInfo.isAppVisible()) {
                FeedbackModule.notifySendCompleted(Result.SUCCESS);
            } else if (currentActivity == null) {
                int i = this.numOfRetries;
                if (i < 3) {
                    this.numOfRetries = i + 1;
                    SnackbarReceiver.this.uiNotifier.postDelayed(this, Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                } else {
                    FeedbackModule.notifySendCompleted(Result.SUCCESS);
                }
            } else {
                FeedbackModule.notifySendCompleted(Result.SUCCESS);
                Snackbar build = SnackbarBuilder.build(currentActivity, R.string.mk_fb_feedback_sent);
                build.addCallback(new SnackbarCallback() {
                    public void onDismissed(Snackbar snackbar, int i) {
                        super.onDismissed(snackbar, i);
                        SnackbarReceiver.doFinish(currentActivity);
                    }
                });
                FeedbackModule.notificationStarted();
                SnackbarReceiver.dismissProgressBar(currentActivity);
                build.show();
            }
        }
    };
    /* access modifiers changed from: private */
    public final UiInfo uiInfo;
    /* access modifiers changed from: private */
    public final UiNotifier uiNotifier;

    /* renamed from: com.atlassian.mobilekit.module.feedback.SnackbarReceiver$3 reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.atlassian.mobilekit.module.feedback.commands.Result[] r0 = com.atlassian.mobilekit.module.feedback.commands.Result.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result = r0
                com.atlassian.mobilekit.module.feedback.commands.Result r1 = com.atlassian.mobilekit.module.feedback.commands.Result.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atlassian.mobilekit.module.feedback.commands.Result r1 = com.atlassian.mobilekit.module.feedback.commands.Result.FAIL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atlassian.mobilekit.module.feedback.SnackbarReceiver.AnonymousClass3.<clinit>():void");
        }
    }

    SnackbarReceiver(UiInfo uiInfo2, UiNotifier uiNotifier2, String str, String str2) {
        this.uiInfo = uiInfo2;
        this.uiNotifier = uiNotifier2;
        this.message = str;
        this.email = str2;
    }

    public void receive(Result result) {
        int i = AnonymousClass3.$SwitchMap$com$atlassian$mobilekit$module$feedback$commands$Result[result.ordinal()];
        if (i == 1) {
            this.showSuccessRunnable.run();
        } else if (i == 2) {
            this.showFailureRunnable.run();
        }
    }

    /* access modifiers changed from: private */
    public static void showProgressBar(Activity activity) {
        if (activity instanceof ProgressDialogActions) {
            ((ProgressDialogActions) activity).showProgressDialog();
        }
    }

    /* access modifiers changed from: private */
    public static void dismissProgressBar(Activity activity) {
        if (activity instanceof ProgressDialogActions) {
            ((ProgressDialogActions) activity).dismissProgressDialog();
        }
    }

    /* access modifiers changed from: private */
    public static void doFinish(Activity activity) {
        if (activity instanceof FinishAction) {
            ((FinishAction) activity).doFinish();
        }
    }
}
