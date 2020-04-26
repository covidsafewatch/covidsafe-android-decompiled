package com.atlassian.mobilekit.module.feedback.model;

import android.text.TextUtils;
import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.util.List;

public final class CreateIssueRequest {
    private static final int MAX_SUMMARY_LENGTH = 240;
    private final String appId;
    private final String appName;
    private final String appVersion;
    private final List<String> components;
    private final String description;
    private final String devName;
    private final boolean isCrash;
    private final String language;
    private final String model;
    private final String summary;
    private final String systemName;
    private final String systemVersion;
    private final String type;
    private final String udid;
    private final String uuid;

    public static class Builder {
        /* access modifiers changed from: private */
        public String appId;
        /* access modifiers changed from: private */
        public String appName;
        /* access modifiers changed from: private */
        public String appVersion;
        /* access modifiers changed from: private */
        public List<String> components;
        /* access modifiers changed from: private */
        public String description;
        /* access modifiers changed from: private */
        public String deviceName;
        /* access modifiers changed from: private */
        public boolean isCrash;
        /* access modifiers changed from: private */
        public String language;
        /* access modifiers changed from: private */
        public String model;
        /* access modifiers changed from: private */
        public String summary;
        /* access modifiers changed from: private */
        public String systemName;
        /* access modifiers changed from: private */
        public String systemVersion;
        /* access modifiers changed from: private */
        public String type;
        /* access modifiers changed from: private */
        public String udid;
        /* access modifiers changed from: private */
        public String uuid;

        public Builder issueType(String str) {
            this.type = str;
            return this;
        }

        public Builder summary(String str) {
            this.summary = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder appendToDescription(String str) {
            if (!TextUtils.isEmpty(this.description)) {
                StringBuilder sb = new StringBuilder();
                String str2 = StringUtils.EOL;
                sb.append(str2);
                sb.append(str2);
                sb.append(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.description);
                sb2.append(sb.toString());
                this.description = sb2.toString();
            }
            return this;
        }

        public Builder isCrash(boolean z) {
            this.isCrash = z;
            return this;
        }

        public Builder udid(String str) {
            this.udid = str;
            return this;
        }

        public Builder uuid(String str) {
            this.uuid = str;
            return this;
        }

        public Builder appName(String str) {
            this.appName = str;
            return this;
        }

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder systemVersion(String str) {
            this.systemVersion = str;
            return this;
        }

        public Builder systemName(String str) {
            this.systemName = str;
            return this;
        }

        public Builder deviceName(String str) {
            this.deviceName = str;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder components(List<String> list) {
            this.components = list;
            return this;
        }

        public CreateIssueRequest build() {
            return new CreateIssueRequest(this);
        }
    }

    public CreateIssueRequest(Builder builder) {
        this.type = builder.type;
        this.summary = StringUtils.ellipsize(builder.summary, MAX_SUMMARY_LENGTH);
        this.description = builder.description;
        this.isCrash = builder.isCrash;
        this.udid = builder.udid;
        this.uuid = builder.uuid;
        this.appName = builder.appName;
        this.appId = builder.appId;
        this.appVersion = builder.appVersion;
        this.systemVersion = builder.systemVersion;
        this.systemName = builder.systemName;
        this.devName = builder.deviceName;
        this.model = builder.model;
        this.language = builder.language;
        this.components = builder.components;
    }

    public String getType() {
        return this.type;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCrash() {
        return this.isCrash;
    }

    public String getUdid() {
        return this.udid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getSystemVersion() {
        return this.systemVersion;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public String getDeviceName() {
        return this.devName;
    }

    public String getModel() {
        return this.model;
    }

    public String getLanguage() {
        return this.language;
    }

    public List<String> getComponents() {
        return this.components;
    }
}
