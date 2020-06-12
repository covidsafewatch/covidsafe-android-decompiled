package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {
    private final float size;

    public AbsoluteCornerSize(float f) {
        this.size = f;
    }

    public float getCornerSize(RectF rectF) {
        return this.size;
    }

    public float getCornerSize() {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AbsoluteCornerSize) && this.size == ((AbsoluteCornerSize) obj).size) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.size)});
    }
}
