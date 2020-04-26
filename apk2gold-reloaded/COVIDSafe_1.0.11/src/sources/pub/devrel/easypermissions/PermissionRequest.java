package pub.devrel.easypermissions;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.util.Arrays;
import pub.devrel.easypermissions.helper.PermissionHelper;

public final class PermissionRequest {
    private final PermissionHelper mHelper;
    private final String mNegativeButtonText;
    private final String[] mPerms;
    private final String mPositiveButtonText;
    private final String mRationale;
    private final int mRequestCode;
    private final int mTheme;

    public static final class Builder {
        private final PermissionHelper mHelper;
        private String mNegativeButtonText;
        private final String[] mPerms;
        private String mPositiveButtonText;
        private String mRationale;
        private final int mRequestCode;
        private int mTheme = -1;

        public Builder(Activity activity, int i, String... strArr) {
            this.mHelper = PermissionHelper.newInstance(activity);
            this.mRequestCode = i;
            this.mPerms = strArr;
        }

        public Builder(Fragment fragment, int i, String... strArr) {
            this.mHelper = PermissionHelper.newInstance(fragment);
            this.mRequestCode = i;
            this.mPerms = strArr;
        }

        public Builder setRationale(String str) {
            this.mRationale = str;
            return this;
        }

        public Builder setRationale(int i) {
            this.mRationale = this.mHelper.getContext().getString(i);
            return this;
        }

        public Builder setPositiveButtonText(String str) {
            this.mPositiveButtonText = str;
            return this;
        }

        public Builder setPositiveButtonText(int i) {
            this.mPositiveButtonText = this.mHelper.getContext().getString(i);
            return this;
        }

        public Builder setNegativeButtonText(String str) {
            this.mNegativeButtonText = str;
            return this;
        }

        public Builder setNegativeButtonText(int i) {
            this.mNegativeButtonText = this.mHelper.getContext().getString(i);
            return this;
        }

        public Builder setTheme(int i) {
            this.mTheme = i;
            return this;
        }

        public PermissionRequest build() {
            if (this.mRationale == null) {
                this.mRationale = this.mHelper.getContext().getString(R.string.rationale_ask);
            }
            if (this.mPositiveButtonText == null) {
                this.mPositiveButtonText = this.mHelper.getContext().getString(17039370);
            }
            if (this.mNegativeButtonText == null) {
                this.mNegativeButtonText = this.mHelper.getContext().getString(17039360);
            }
            PermissionRequest permissionRequest = new PermissionRequest(this.mHelper, this.mPerms, this.mRequestCode, this.mRationale, this.mPositiveButtonText, this.mNegativeButtonText, this.mTheme);
            return permissionRequest;
        }
    }

    private PermissionRequest(PermissionHelper permissionHelper, String[] strArr, int i, String str, String str2, String str3, int i2) {
        this.mHelper = permissionHelper;
        this.mPerms = (String[]) strArr.clone();
        this.mRequestCode = i;
        this.mRationale = str;
        this.mPositiveButtonText = str2;
        this.mNegativeButtonText = str3;
        this.mTheme = i2;
    }

    public PermissionHelper getHelper() {
        return this.mHelper;
    }

    public String[] getPerms() {
        return (String[]) this.mPerms.clone();
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public String getRationale() {
        return this.mRationale;
    }

    public String getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    public String getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PermissionRequest permissionRequest = (PermissionRequest) obj;
        if (!Arrays.equals(this.mPerms, permissionRequest.mPerms) || this.mRequestCode != permissionRequest.mRequestCode) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.mPerms) * 31) + this.mRequestCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PermissionRequest{mHelper=");
        sb.append(this.mHelper);
        sb.append(", mPerms=");
        sb.append(Arrays.toString(this.mPerms));
        sb.append(", mRequestCode=");
        sb.append(this.mRequestCode);
        sb.append(", mRationale='");
        sb.append(this.mRationale);
        sb.append('\'');
        sb.append(", mPositiveButtonText='");
        sb.append(this.mPositiveButtonText);
        sb.append('\'');
        sb.append(", mNegativeButtonText='");
        sb.append(this.mNegativeButtonText);
        sb.append('\'');
        sb.append(", mTheme=");
        sb.append(this.mTheme);
        sb.append('}');
        return sb.toString();
    }
}
