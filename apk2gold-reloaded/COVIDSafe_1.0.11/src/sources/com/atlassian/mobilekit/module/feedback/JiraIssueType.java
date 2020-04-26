package com.atlassian.mobilekit.module.feedback;

public enum JiraIssueType {
    BUG("Bug"),
    EPIC("Epic"),
    IMPROVEMENT("Improvement"),
    STORY("Story"),
    SUPPORT("Support"),
    TASK("Task");
    
    private String type;

    private JiraIssueType(String str) {
        this.type = str;
    }

    public String toString() {
        return this.type;
    }
}
