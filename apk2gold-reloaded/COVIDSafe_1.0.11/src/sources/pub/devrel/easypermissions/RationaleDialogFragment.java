package pub.devrel.easypermissions;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;
import pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks;

public class RationaleDialogFragment extends DialogFragment {
    public static final String TAG = "RationaleDialogFragment";
    private PermissionCallbacks mPermissionCallbacks;
    private RationaleCallbacks mRationaleCallbacks;
    private boolean mStateSaved = false;

    public static RationaleDialogFragment newInstance(String str, String str2, String str3, int i, int i2, String[] strArr) {
        RationaleDialogFragment rationaleDialogFragment = new RationaleDialogFragment();
        RationaleDialogConfig rationaleDialogConfig = new RationaleDialogConfig(str, str2, str3, i, i2, strArr);
        rationaleDialogFragment.setArguments(rationaleDialogConfig.toBundle());
        return rationaleDialogFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (VERSION.SDK_INT >= 17 && getParentFragment() != null) {
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

    public void onSaveInstanceState(Bundle bundle) {
        this.mStateSaved = true;
        super.onSaveInstanceState(bundle);
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if ((VERSION.SDK_INT < 26 || !fragmentManager.isStateSaved()) && !this.mStateSaved) {
            show(fragmentManager, str);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mPermissionCallbacks = null;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        RationaleDialogConfig rationaleDialogConfig = new RationaleDialogConfig(getArguments());
        return rationaleDialogConfig.createFrameworkDialog(getActivity(), new RationaleDialogClickListener(this, rationaleDialogConfig, this.mPermissionCallbacks, this.mRationaleCallbacks));
    }
}
