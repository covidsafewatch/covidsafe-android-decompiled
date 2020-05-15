package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    /* access modifiers changed from: package-private */
    public abstract void initialize();

    /* access modifiers changed from: package-private */
    public boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(TextInputLayout textInputLayout2) {
        this.textInputLayout = textInputLayout2;
        this.context = textInputLayout2.getContext();
        this.endIconView = textInputLayout2.getEndIconView();
    }
}
