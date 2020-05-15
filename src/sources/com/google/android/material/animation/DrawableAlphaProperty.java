package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    private final WeakHashMap<Drawable, Integer> alphaCache = new WeakHashMap<>();

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
    }

    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.alphaCache.containsKey(drawable)) {
            return this.alphaCache.get(drawable);
        }
        return 255;
    }

    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.alphaCache.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
