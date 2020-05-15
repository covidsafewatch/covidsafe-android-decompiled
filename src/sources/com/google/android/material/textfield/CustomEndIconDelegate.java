package com.google.android.material.textfield;

import android.view.View;

class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener((View.OnClickListener) null);
        this.textInputLayout.setEndIconOnLongClickListener((View.OnLongClickListener) null);
    }
}
