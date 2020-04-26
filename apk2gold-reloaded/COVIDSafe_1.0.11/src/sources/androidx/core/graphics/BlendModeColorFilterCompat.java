package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;

public class BlendModeColorFilterCompat {
    public static ColorFilter createBlendModeColorFilterCompat(int i, BlendModeCompat blendModeCompat) {
        BlendModeColorFilter blendModeColorFilter = null;
        if (VERSION.SDK_INT >= 29) {
            BlendMode obtainBlendModeFromCompat = BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat);
            if (obtainBlendModeFromCompat != null) {
                blendModeColorFilter = new BlendModeColorFilter(i, obtainBlendModeFromCompat);
            }
            return blendModeColorFilter;
        }
        Mode obtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        if (obtainPorterDuffFromCompat != null) {
            blendModeColorFilter = new PorterDuffColorFilter(i, obtainPorterDuffFromCompat);
        }
        return blendModeColorFilter;
    }

    private BlendModeColorFilterCompat() {
    }
}
