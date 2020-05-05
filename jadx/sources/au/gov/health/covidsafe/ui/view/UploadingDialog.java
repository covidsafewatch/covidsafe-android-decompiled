package au.gov.health.covidsafe.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
    bv = {1, 0, 3},
    d1 =
        {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"},
    d2 = {"Lau/gov/health/covidsafe/ui/view/UploadingDialog;",
          "Landroid/app/Dialog;", "context", "Landroid/content/Context;",
          "(Landroid/content/Context;)V", "onCreate", "", "savedInstanceState",
          "Landroid/os/Bundle;", "app_release"},
    k = 1, mv = {1, 1, 16})
/* compiled from: UploadingDialog.kt */
public final class UploadingDialog extends Dialog {
  /* JADX INFO: super call moved to the top of the method (can break code
   * semantics) */
  public UploadingDialog(Context context) {
    super(context);
    Intrinsics.checkParameterIsNotNull(context, "context");
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }

  /* access modifiers changed from: protected */
  public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    requestWindowFeature(1);
    setContentView(R.layout.dialog_uploading);
    Window window = getWindow();
    if (window != null) {
      window.setLayout(-1, -1);
    }
  }
}
