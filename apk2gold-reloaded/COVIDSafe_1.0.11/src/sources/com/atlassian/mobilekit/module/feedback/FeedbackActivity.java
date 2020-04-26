package com.atlassian.mobilekit.module.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle.State;
import com.atlassian.mobilekit.module.core.DeviceInfo;
import com.atlassian.mobilekit.module.core.utils.SystemUtils;
import com.atlassian.mobilekit.module.feedback.commands.Result;

public class FeedbackActivity extends AppCompatActivity implements ProgressDialogActions, FinishAction, SendFeedbackListener {
    private DeviceInfo deviceInfo = null;
    private EditText feedbackEmailEt;
    /* access modifiers changed from: private */
    public EditText feedbackEt;
    private MenuItem sendMenuItem = null;

    private abstract class TextWatcherAdapter implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private TextWatcherAdapter() {
        }
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, FeedbackActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().clearFlags(1024);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedbackActivity.this.finish();
            }
        });
        EditText editText = (EditText) findViewById(R.id.feedbackIssueDescriptionEditText);
        this.feedbackEt = editText;
        editText.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FeedbackActivity.this.updateSendButtonState();
            }
        });
        EditText editText2 = (EditText) findViewById(R.id.feedbackIssueEmailEditText);
        this.feedbackEmailEt = editText2;
        editText2.addTextChangedListener(new TextWatcherAdapter() {
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FeedbackActivity.this.updateSendButtonState();
            }
        });
        this.feedbackEmailEt.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return FeedbackActivity.this.lambda$onCreate$0$FeedbackActivity(textView, i, keyEvent);
            }
        });
        View findViewById = findViewById(R.id.feedback_content_parent);
        if (findViewById != null) {
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FeedbackActivity.this.lambda$onCreate$1$FeedbackActivity(view);
                }
            });
        }
        View findViewById2 = findViewById(16908290);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FeedbackActivity.this.lambda$onCreate$2$FeedbackActivity(view);
                }
            });
        }
        if (bundle == null) {
            focusOnFeedbackEditText();
        }
        this.deviceInfo = new DeviceInfo(getApplicationContext());
        FeedbackModule.registerSendFeedbackListener(this);
    }

    public /* synthetic */ boolean lambda$onCreate$0$FeedbackActivity(TextView textView, int i, KeyEvent keyEvent) {
        onOptionsItemSelected(this.sendMenuItem);
        return true;
    }

    public /* synthetic */ void lambda$onCreate$1$FeedbackActivity(View view) {
        focusOnFeedbackEditText();
    }

    public /* synthetic */ void lambda$onCreate$2$FeedbackActivity(View view) {
        focusOnFeedbackEditText();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FeedbackModule.unregisterSendFeedbackListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_feedback, menu);
        MenuItem findItem = menu.findItem(R.id.action_send);
        this.sendMenuItem = findItem;
        findItem.setEnabled(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_send) {
            return super.onOptionsItemSelected(menuItem);
        }
        String trim = this.feedbackEt.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            Toast.makeText(this, R.string.mk_fb_feedback_empty, 0).show();
            return true;
        }
        String trim2 = this.feedbackEmailEt.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) || !Patterns.EMAIL_ADDRESS.matcher(trim2).matches()) {
            Toast.makeText(this, R.string.mk_fb_invalid_email_address, 0).show();
            return true;
        } else if (!this.deviceInfo.hasConnectivity()) {
            Toast.makeText(this, R.string.mk_fb_device_offline, 0).show();
            return true;
        } else {
            this.sendMenuItem = menuItem;
            SystemUtils.hideSoftKeyboard(this.feedbackEt);
            SystemUtils.hideSoftKeyboard(this.feedbackEmailEt);
            sendFeedback(trim, trim2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void updateSendButtonState() {
        String obj = this.feedbackEt.getText().toString();
        String obj2 = this.feedbackEmailEt.getText().toString();
        if (TextUtils.isEmpty(obj) || !Patterns.EMAIL_ADDRESS.matcher(obj2).matches()) {
            this.sendMenuItem.setEnabled(false);
        } else {
            this.sendMenuItem.setEnabled(true);
        }
    }

    public void showProgressDialog() {
        new ProgressDialogFragment().show(getSupportFragmentManager(), ProgressDialogFragment.class.getSimpleName());
    }

    public void dismissProgressDialog() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(ProgressDialogFragment.class.getSimpleName());
        if (findFragmentByTag != null && (findFragmentByTag instanceof ProgressDialogFragment)) {
            ((ProgressDialogFragment) findFragmentByTag).dismiss();
        }
    }

    public void doFinish() {
        finish();
    }

    private void focusOnFeedbackEditText() {
        this.feedbackEt.requestFocus();
        showKeyboard();
    }

    private void sendFeedback(String str, String str2) {
        FeedbackModule.sendFeedback(str, str2);
        showProgressDialog();
    }

    public void onSendCompleted(Result result) {
        if (Result.SUCCESS == result) {
            MenuItem menuItem = this.sendMenuItem;
            if (menuItem != null) {
                menuItem.setEnabled(false);
            }
            this.feedbackEt.setEnabled(false);
        }
        if (!getLifecycle().getCurrentState().isAtLeast(State.RESUMED)) {
            finish();
        }
    }

    private void showKeyboard() {
        this.feedbackEt.postDelayed(new Runnable() {
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) FeedbackActivity.this.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(FeedbackActivity.this.feedbackEt, 1);
                }
            }
        }, 300);
    }
}
