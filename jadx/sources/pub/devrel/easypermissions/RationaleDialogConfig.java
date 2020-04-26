package pub.devrel.easypermissions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

class RationaleDialogConfig {
    private static final String KEY_NEGATIVE_BUTTON = "negativeButton";
    private static final String KEY_PERMISSIONS = "permissions";
    private static final String KEY_POSITIVE_BUTTON = "positiveButton";
    private static final String KEY_RATIONALE_MESSAGE = "rationaleMsg";
    private static final String KEY_REQUEST_CODE = "requestCode";
    private static final String KEY_THEME = "theme";
    String negativeButton;
    String[] permissions;
    String positiveButton;
    String rationaleMsg;
    int requestCode;
    int theme;

    RationaleDialogConfig(String str, String str2, String str3, int i, int i2, String[] strArr) {
        this.positiveButton = str;
        this.negativeButton = str2;
        this.rationaleMsg = str3;
        this.theme = i;
        this.requestCode = i2;
        this.permissions = strArr;
    }

    RationaleDialogConfig(Bundle bundle) {
        this.positiveButton = bundle.getString(KEY_POSITIVE_BUTTON);
        this.negativeButton = bundle.getString(KEY_NEGATIVE_BUTTON);
        this.rationaleMsg = bundle.getString(KEY_RATIONALE_MESSAGE);
        this.theme = bundle.getInt(KEY_THEME);
        this.requestCode = bundle.getInt(KEY_REQUEST_CODE);
        this.permissions = bundle.getStringArray(KEY_PERMISSIONS);
    }

    /* access modifiers changed from: package-private */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_POSITIVE_BUTTON, this.positiveButton);
        bundle.putString(KEY_NEGATIVE_BUTTON, this.negativeButton);
        bundle.putString(KEY_RATIONALE_MESSAGE, this.rationaleMsg);
        bundle.putInt(KEY_THEME, this.theme);
        bundle.putInt(KEY_REQUEST_CODE, this.requestCode);
        bundle.putStringArray(KEY_PERMISSIONS, this.permissions);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public AlertDialog createSupportDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        int i = this.theme;
        if (i > 0) {
            builder = new AlertDialog.Builder(context, i);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        return builder.setCancelable(false).setPositiveButton((CharSequence) this.positiveButton, onClickListener).setNegativeButton((CharSequence) this.negativeButton, onClickListener).setMessage((CharSequence) this.rationaleMsg).create();
    }

    /* access modifiers changed from: package-private */
    public android.app.AlertDialog createFrameworkDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;
        if (this.theme > 0) {
            builder = new AlertDialog.Builder(context, this.theme);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        return builder.setCancelable(false).setPositiveButton(this.positiveButton, onClickListener).setNegativeButton(this.negativeButton, onClickListener).setMessage(this.rationaleMsg).create();
    }
}
