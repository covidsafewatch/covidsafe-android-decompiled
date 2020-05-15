package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
    float size = -1.0f;

    public CutCornerTreatment() {
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }

    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = (double) f3;
        double d2 = (double) f2;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f)) * d * d2), (float) (Math.sin(Math.toRadians((double) (90.0f - f))) * d * d2));
    }
}
