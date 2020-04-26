package pub.devrel.easypermissions;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;
import pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks;

public class RationaleDialogFragmentCompat extends AppCompatDialogFragment {
    public static final String TAG = "RationaleDialogFragmentCompat";
    private PermissionCallbacks mPermissionCallbacks;
    private RationaleCallbacks mRationaleCallbacks;

    public static RationaleDialogFragmentCompat newInstance(String str, String str2, String str3, int i, int i2, String[] strArr) {
        RationaleDialogFragmentCompat rationaleDialogFragmentCompat = new RationaleDialogFragmentCompat();
        RationaleDialogConfig rationaleDialogConfig = new RationaleDialogConfig(str2, str3, str, i, i2, strArr);
        rationaleDialogFragmentCompat.setArguments(rationaleDialogConfig.toBundle());
        return rationaleDialogFragmentCompat;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (!fragmentManager.isStateSaved()) {
            show(fragmentManager, str);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() != null) {
            if (getParentFragment() instanceof PermissionCallbacks) {
                this.mPermissionCallbacks = (PermissionCallbacks) getParentFragment();
            }
            if (getParentFragment() instanceof RationaleCallbacks) {
                this.mRationaleCallbacks = (RationaleCallbacks) getParentFragment();
            }
        }
        if (context instanceof PermissionCallbacks) {
            this.mPermissionCallbacks = (PermissionCallbacks) context;
        }
        if (context instanceof RationaleCallbacks) {
            this.mRationaleCallbacks = (RationaleCallbacks) context;
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mPermissionCallbacks = null;
        this.mRationaleCallbacks = null;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        RationaleDialogConfig rationaleDialogConfig = new RationaleDialogConfig(getArguments());
        return rationaleDialogConfig.createSupportDialog(getContext(), new RationaleDialogClickListener(this, rationaleDialogConfig, this.mPermissionCallbacks, this.mRationaleCallbacks));
    }
}
