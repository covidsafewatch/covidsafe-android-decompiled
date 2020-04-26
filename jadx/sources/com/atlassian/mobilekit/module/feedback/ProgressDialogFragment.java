package com.atlassian.mobilekit.module.feedback;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ProgressDialogFragment extends AppCompatDialogFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity(), getTheme());
        progressDialog.setTitle((CharSequence) null);
        progressDialog.setMessage(getString(R.string.mk_fb_sending));
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(0);
        return progressDialog;
    }
}
