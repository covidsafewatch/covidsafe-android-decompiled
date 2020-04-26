package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public interface TintableBackgroundView {
    ColorStateList getSupportBackgroundTintList();

    Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(Mode mode);
}
