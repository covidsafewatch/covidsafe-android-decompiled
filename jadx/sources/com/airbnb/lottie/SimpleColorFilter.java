package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public class SimpleColorFilter extends PorterDuffColorFilter {
    public SimpleColorFilter(int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
