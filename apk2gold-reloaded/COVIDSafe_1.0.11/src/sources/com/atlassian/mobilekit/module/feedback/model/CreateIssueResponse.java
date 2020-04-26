package com.atlassian.mobilekit.module.feedback.model;

import java.util.List;

public final class CreateIssueResponse {
    private List<String> comments;
    private long dateCreated;
    private long dateUpdated;
    private String description;
    private boolean hasUpdates;
    private String key;
    private String status;
    private String summary;

    public String getKey() {
        return this.key;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }

    public long getDateUpdated() {
        return this.dateUpdated;
    }

    public long getDateCreated() {
        return this.dateCreated;
    }

    public boolean hasUpdates() {
        return this.hasUpdates;
    }

    public List<String> getComments() {
        return this.comments;
    }
}
