package com.atlassian.mobilekit.module.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.atlassian.mobilekit.module.feedback.R;

public class MobileKitDialogViewBuilder {
    private final ViewGroup container;
    private final LayoutInflater inflater;
    private int msgResId;
    private int negBtnResId;
    private OnClickListener negClickListener;
    private int posBtnResId;
    private OnClickListener posClickListener;
    private int titleResId;

    public MobileKitDialogViewBuilder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.inflater = layoutInflater;
        this.container = viewGroup;
    }

    public MobileKitDialogViewBuilder title(int i) {
        this.titleResId = i;
        return this;
    }

    public MobileKitDialogViewBuilder message(int i) {
        this.msgResId = i;
        return this;
    }

    public MobileKitDialogViewBuilder positiveButton(int i, OnClickListener onClickListener) {
        this.posBtnResId = i;
        this.posClickListener = onClickListener;
        return this;
    }

    public MobileKitDialogViewBuilder negativeButton(int i, OnClickListener onClickListener) {
        this.negBtnResId = i;
        this.negClickListener = onClickListener;
        return this;
    }

    public View build() {
        View inflate = this.inflater.inflate(R.layout.mk_feedback_dialog_container, this.container, false);
        this.inflater.inflate(R.layout.mk_feedback_dialog_content, (FrameLayout) inflate.findViewById(R.id.dialog_container));
        AppCompatTextView appCompatTextView = (AppCompatTextView) inflate.findViewById(R.id.title);
        int i = this.titleResId;
        if (i == 0) {
            appCompatTextView.setVisibility(8);
        } else {
            appCompatTextView.setText(i);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) inflate.findViewById(R.id.message);
        int i2 = this.msgResId;
        if (i2 == 0) {
            appCompatTextView2.setVisibility(8);
        } else {
            appCompatTextView2.setText(i2);
        }
        Button button = (Button) inflate.findViewById(R.id.positive_btn);
        int i3 = this.posBtnResId;
        if (i3 == 0) {
            button.setVisibility(8);
        } else {
            button.setText(i3);
            button.setOnClickListener(this.posClickListener);
        }
        Button button2 = (Button) inflate.findViewById(R.id.negative_btn);
        int i4 = this.negBtnResId;
        if (i4 == 0) {
            button2.setVisibility(8);
        } else {
            button2.setText(i4);
            button2.setOnClickListener(this.negClickListener);
        }
        return inflate;
    }
}
