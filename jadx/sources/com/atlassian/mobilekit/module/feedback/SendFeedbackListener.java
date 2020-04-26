package com.atlassian.mobilekit.module.feedback;

import com.atlassian.mobilekit.module.feedback.commands.Result;

public interface SendFeedbackListener {
    void onSendCompleted(Result result);
}
