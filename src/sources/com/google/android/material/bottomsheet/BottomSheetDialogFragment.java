package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }

    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        if (!behavior.isHideable() || !bottomSheetDialog.getDismissWithAnimation()) {
            return false;
        }
        dismissWithAnimation(behavior, z);
        return true;
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetDismissCallback());
        bottomSheetBehavior.setState(5);
    }

    /* access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        public void onSlide(View view, float f) {
        }

        private BottomSheetDismissCallback() {
        }

        public void onStateChanged(View view, int i) {
            if (i == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }
}
