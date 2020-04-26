package pub.devrel.easypermissions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AppSettingsDialogHolderActivity extends AppCompatActivity implements OnClickListener {
    private static final int APP_SETTINGS_RC = 7534;
    private AlertDialog mDialog;
    private int mIntentFlags;

    public static Intent createShowDialogIntent(Context context, AppSettingsDialog appSettingsDialog) {
        Intent intent = new Intent(context, AppSettingsDialogHolderActivity.class);
        intent.putExtra("extra_app_settings", appSettingsDialog);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AppSettingsDialog fromIntent = AppSettingsDialog.fromIntent(getIntent(), this);
        this.mIntentFlags = fromIntent.getIntentFlags();
        this.mDialog = fromIntent.showDialog(this, this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Intent data = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", getPackageName(), null));
            data.addFlags(this.mIntentFlags);
            startActivityForResult(data, APP_SETTINGS_RC);
        } else if (i == -2) {
            setResult(0);
            finish();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown button type: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }
}
