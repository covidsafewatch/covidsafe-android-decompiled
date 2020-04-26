package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
    float radius = -1.0f;

    public RoundedCornerTreatment() {
    }

    @Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }

    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(0.0f, 0.0f, f4, f4, 180.0f, f);
    }
}
