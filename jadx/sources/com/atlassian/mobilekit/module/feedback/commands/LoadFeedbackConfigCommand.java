package com.atlassian.mobilekit.module.feedback.commands;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.atlassian.mobilekit.module.core.Receiver;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.feedback.R;
import com.atlassian.mobilekit.module.feedback.model.FeedbackConfig;
import java.net.URI;
import java.net.URISyntaxException;

public final class LoadFeedbackConfigCommand extends AbstractCommand<FeedbackConfig> {
    private static final String LOG_TAG = LoadFeedbackConfigCommand.class.getSimpleName();
    private final Context context;

    public LoadFeedbackConfigCommand(Context context2, Receiver<FeedbackConfig> receiver, UiNotifier uiNotifier) {
        super(receiver, uiNotifier);
        this.context = context2;
    }

    public void run() {
        FeedbackConfig feedbackConfig = new FeedbackConfig(this.context.getString(R.string.mp_feedback_host), this.context.getString(R.string.mp_feedback_apikey), this.context.getString(R.string.mp_feedback_projectkey), this.context.getResources().getStringArray(R.array.mp_feedback_components));
        String errorCheck = errorCheck(feedbackConfig);
        if (errorCheck == null) {
            updateReceiver(feedbackConfig);
            return;
        }
        throw new IllegalStateException(errorCheck);
    }

    private String errorCheck(FeedbackConfig feedbackConfig) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(feedbackConfig.getHost())) {
            sb.append(getConfigEmptyErrMsg(R.string.mp_feedback_host));
        } else if (!isValidHost(feedbackConfig.getHost())) {
            sb.append(getConfigInvalidErrMsg(R.string.mp_feedback_host));
        }
        if (TextUtils.isEmpty(feedbackConfig.getApiKey())) {
            sb.append(getConfigEmptyErrMsg(R.string.mp_feedback_apikey));
        }
        if (TextUtils.isEmpty(feedbackConfig.getProjectKey())) {
            sb.append(getConfigEmptyErrMsg(R.string.mp_feedback_projectkey));
        }
        if (sb.length() <= 0) {
            return null;
        }
        sb.append(this.context.getString(R.string.mk_fb_config_err_help));
        return sb.toString();
    }

    private String getConfigEmptyErrMsg(int i) {
        return this.context.getString(R.string.mk_fb_no_config_property, new Object[]{this.context.getResources().getResourceEntryName(i)});
    }

    private String getConfigInvalidErrMsg(int i) {
        return this.context.getString(R.string.mk_fb_invalid_config_property, new Object[]{this.context.getResources().getResourceEntryName(i)});
    }

    private boolean isValidHost(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("/") >= 0) {
            return false;
        }
        try {
            URI uri = new URI("scheme://" + str);
            String host = uri.getHost();
            int port = uri.getPort();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(host);
            if (port != -1) {
                sb.append(":");
                sb.append(port);
            }
            return str.equals(sb.toString());
        } catch (URISyntaxException e) {
            Log.e(LOG_TAG, "URI Validation Failed.", e);
            return false;
        }
    }
}
