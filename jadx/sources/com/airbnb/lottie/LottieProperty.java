package com.airbnb.lottie;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import com.airbnb.lottie.value.ScaleXY;

public interface LottieProperty {
    public static final Integer COLOR = 1;
    public static final ColorFilter COLOR_FILTER = new ColorFilter();
    public static final Float CORNER_RADIUS;
    public static final PointF ELLIPSE_SIZE = new PointF();
    public static final Integer[] GRADIENT_COLOR = new Integer[0];
    public static final Integer OPACITY = 4;
    public static final Float POLYSTAR_INNER_RADIUS = Float.valueOf(8.0f);
    public static final Float POLYSTAR_INNER_ROUNDEDNESS = Float.valueOf(10.0f);
    public static final Float POLYSTAR_OUTER_RADIUS = Float.valueOf(9.0f);
    public static final Float POLYSTAR_OUTER_ROUNDEDNESS = Float.valueOf(11.0f);
    public static final Float POLYSTAR_POINTS = Float.valueOf(6.0f);
    public static final Float POLYSTAR_ROTATION = Float.valueOf(7.0f);
    public static final PointF POSITION = new PointF();
    public static final PointF RECTANGLE_SIZE = new PointF();
    public static final Float REPEATER_COPIES = Float.valueOf(4.0f);
    public static final Float REPEATER_OFFSET = Float.valueOf(5.0f);
    public static final Integer STROKE_COLOR = 2;
    public static final Float STROKE_WIDTH = Float.valueOf(2.0f);
    public static final Float TEXT_SIZE = Float.valueOf(14.0f);
    public static final Float TEXT_TRACKING = Float.valueOf(3.0f);
    public static final Float TIME_REMAP = Float.valueOf(13.0f);
    public static final PointF TRANSFORM_ANCHOR_POINT = new PointF();
    public static final Float TRANSFORM_END_OPACITY = Float.valueOf(12.1f);
    public static final Integer TRANSFORM_OPACITY = 3;
    public static final PointF TRANSFORM_POSITION = new PointF();
    public static final Float TRANSFORM_ROTATION = Float.valueOf(1.0f);
    public static final ScaleXY TRANSFORM_SCALE = new ScaleXY();
    public static final Float TRANSFORM_SKEW;
    public static final Float TRANSFORM_SKEW_ANGLE;
    public static final Float TRANSFORM_START_OPACITY = Float.valueOf(12.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        CORNER_RADIUS = valueOf;
        TRANSFORM_SKEW = valueOf;
        TRANSFORM_SKEW_ANGLE = valueOf;
    }
}
