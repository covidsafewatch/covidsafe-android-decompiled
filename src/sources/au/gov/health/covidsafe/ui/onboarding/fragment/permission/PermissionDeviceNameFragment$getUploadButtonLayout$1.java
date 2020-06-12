package au.gov.health.covidsafe.ui.onboarding.fragment.permission;

import android.bluetooth.BluetoothAdapter;
import android.widget.EditText;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PermissionDeviceNameFragment.kt */
final class PermissionDeviceNameFragment$getUploadButtonLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PermissionDeviceNameFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionDeviceNameFragment$getUploadButtonLayout$1(PermissionDeviceNameFragment permissionDeviceNameFragment) {
        super(0);
        this.this$0 = permissionDeviceNameFragment;
    }

    public final void invoke() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            EditText editText = (EditText) this.this$0._$_findCachedViewById(R.id.change_device_name_text_box);
            Intrinsics.checkExpressionValueIsNotNull(editText, "change_device_name_text_box");
            defaultAdapter.setName(editText.getText().toString());
        }
        this.this$0.navigateToNextPage();
    }
}
