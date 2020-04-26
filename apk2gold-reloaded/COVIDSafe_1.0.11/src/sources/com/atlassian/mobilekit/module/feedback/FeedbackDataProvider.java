package com.atlassian.mobilekit.module.feedback;

import java.util.Map;

public interface FeedbackDataProvider {
    String getAdditionalDescription();

    Map<String, Object> getCustomFieldsData();

    JiraIssueType getIssueType();
}
