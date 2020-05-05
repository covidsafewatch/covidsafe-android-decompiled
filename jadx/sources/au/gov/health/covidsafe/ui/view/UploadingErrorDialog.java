package au.gov.health.covidsafe.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.upload.presentation.VerifyUploadPinFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lau/gov/health/covidsafe/ui/view/UploadingErrorDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "listener", "Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;", "(Landroid/content/Context;Lau/gov/health/covidsafe/ui/upload/presentation/VerifyUploadPinFragment$OnUploadErrorInterface;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UploadingErrorDialog.kt */
public final class UploadingErrorDialog extends Dialog {
    /* access modifiers changed from: private */
    public final VerifyUploadPinFragment.OnUploadErrorInterface listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadingErrorDialog(Context context, VerifyUploadPinFragment.OnUploadErrorInterface onUploadErrorInterface) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(onUploadErrorInterface, "listener");
        this.listener = onUploadErrorInterface;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_error_uploading);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        ((Button) findViewById(R.id.dialog_error_positive)).setOnClickListener(new UploadingErrorDialog$onCreate$1(this));
        ((Button) findViewById(R.id.dialog_error_negative)).setOnClickListener(new UploadingErrorDialog$onCreate$2(this));
    }
}
