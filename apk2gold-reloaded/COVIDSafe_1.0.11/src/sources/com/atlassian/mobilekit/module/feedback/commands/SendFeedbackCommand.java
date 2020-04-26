package com.atlassian.mobilekit.module.feedback.commands;

import android.text.TextUtils;
import android.util.Log;
import com.atlassian.mobilekit.module.core.Receiver;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.feedback.FeedbackDataProvider;
import com.atlassian.mobilekit.module.feedback.JiraIssueType;
import com.atlassian.mobilekit.module.feedback.model.CreateIssueRequest.Builder;
import com.atlassian.mobilekit.module.feedback.model.CreateIssueResponse;
import com.atlassian.mobilekit.module.feedback.network.JmcRestClient;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import retrofit2.Response;

public final class SendFeedbackCommand extends AbstractCommand<Result> {
    private static final String LOG_TAG = SendFeedbackCommand.class.getSimpleName();
    private final FeedbackDataProvider feedbackDataProvider;
    private final Map<String, String> queryMap;
    private final Builder requestBuilder;
    private final JmcRestClient restClient;

    public SendFeedbackCommand(Map<String, String> map, Builder builder, FeedbackDataProvider feedbackDataProvider2, JmcRestClient jmcRestClient, Receiver<Result> receiver, UiNotifier uiNotifier) {
        super(receiver, uiNotifier);
        this.queryMap = map;
        this.requestBuilder = builder;
        this.feedbackDataProvider = feedbackDataProvider2;
        this.restClient = jmcRestClient;
    }

    public void run() {
        JiraIssueType jiraIssueType = JiraIssueType.TASK;
        ArrayList arrayList = new ArrayList();
        FeedbackDataProvider feedbackDataProvider2 = this.feedbackDataProvider;
        if (feedbackDataProvider2 != null) {
            String additionalDescription = feedbackDataProvider2.getAdditionalDescription();
            if (!TextUtils.isEmpty(additionalDescription)) {
                this.requestBuilder.appendToDescription(additionalDescription);
            }
            JiraIssueType issueType = this.feedbackDataProvider.getIssueType();
            if (issueType != null) {
                jiraIssueType = issueType;
            }
            Map customFieldsData = this.feedbackDataProvider.getCustomFieldsData();
            if (customFieldsData != null) {
                arrayList.add(Part.createFormData("customfields", "customfields.json", RequestBody.create(MediaType.parse("application/json"), new Gson().toJson((Object) customFieldsData))));
            }
        }
        this.requestBuilder.issueType(jiraIssueType.toString());
        try {
            Response execute = this.restClient.getJmcApi().createIssue(this.queryMap, this.requestBuilder.build(), Collections.emptyList(), arrayList).execute();
            Log.d(LOG_TAG, String.format("Response code %1$d\nmessage %2$s\nbody %3$s", new Object[]{Integer.valueOf(execute.code()), execute.message(), execute.body()}));
            if (execute.isSuccessful()) {
                CreateIssueResponse createIssueResponse = (CreateIssueResponse) execute.body();
                if (createIssueResponse == null) {
                    Log.e(LOG_TAG, "Bad api response. Empty body.");
                } else if (TextUtils.isEmpty(createIssueResponse.getKey())) {
                    Log.e(LOG_TAG, "Bad api response. Missing Issue Key.");
                } else {
                    Log.d(LOG_TAG, String.format("New Issue Created %s", new Object[]{createIssueResponse.getKey()}));
                    updateReceiver(Result.SUCCESS);
                    return;
                }
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Failed to create new issue.", e);
        }
        updateReceiver(Result.FAIL);
    }
}
