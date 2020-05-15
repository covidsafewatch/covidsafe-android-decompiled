package com.atlassian.mobilekit.module.feedback.model;

public final class FeedbackConfig {
    private final String apiKey;
    private final String[] components;
    private final String host;
    private final String projectKey;

    public FeedbackConfig(String str, String str2, String str3, String[] strArr) {
        this.host = str;
        this.apiKey = str2;
        this.projectKey = str3;
        this.components = strArr;
    }

    public String getHost() {
        return this.host;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public String[] getComponents() {
        return this.components;
    }
}
