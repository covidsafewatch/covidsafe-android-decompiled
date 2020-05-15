package com.airbnb.lottie.model;

import android.graphics.PointF;

public class CubicCurveData {
    private final PointF controlPoint1;
    private final PointF controlPoint2;
    private final PointF vertex;

    public CubicCurveData() {
        this.controlPoint1 = new PointF();
        this.controlPoint2 = new PointF();
        this.vertex = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.controlPoint1 = pointF;
        this.controlPoint2 = pointF2;
        this.vertex = pointF3;
    }

    public void setControlPoint1(float f, float f2) {
        this.controlPoint1.set(f, f2);
    }

    public PointF getControlPoint1() {
        return this.controlPoint1;
    }

    public void setControlPoint2(float f, float f2) {
        this.controlPoint2.set(f, f2);
    }

    public PointF getControlPoint2() {
        return this.controlPoint2;
    }

    public void setVertex(float f, float f2) {
        this.vertex.set(f, f2);
    }

    public PointF getVertex() {
        return this.vertex;
    }
}
