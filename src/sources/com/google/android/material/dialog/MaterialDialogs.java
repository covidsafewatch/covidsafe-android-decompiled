package com.google.android.material.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialDialogs {
    private MaterialDialogs() {
    }

    public static InsetDrawable insetDrawable(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Rect getDialogBackgroundInsets(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, (AttributeSet) null, R.styleable.MaterialAlertDialog, i, i2, new int[0]);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            int i3 = dimensionPixelSize3;
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = i3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }
}
