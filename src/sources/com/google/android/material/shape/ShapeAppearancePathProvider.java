package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    private float angleOfEdge(int i) {
        return (float) ((i + 1) * 90);
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, Path path) {
        calculatePath(shapeAppearanceModel, f, rectF, (PathListener) null, path);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, Path path) {
        path.rewind();
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
        for (int i = 0; i < 4; i++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i);
            setEdgePathAndTransform(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
    }

    private void setCornerPathAndTransform(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        getCornerTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i);
        this.cornerTransforms[i].reset();
        getCoordinatesOfCorner(i, shapeAppearancePathSpec.bounds, this.pointF);
        this.cornerTransforms[i].setTranslate(this.pointF.x, this.pointF.y);
        this.cornerTransforms[i].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i) {
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i);
        this.edgeTransforms[i].reset();
        Matrix matrix = this.edgeTransforms[i];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i].preRotate(angleOfEdge);
    }

    private void appendCornerPath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        this.scratch[0] = this.cornerPaths[i].getStartX();
        this.scratch[1] = this.cornerPaths[i].getStartY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onCornerPathCreated(this.cornerPaths[i], this.cornerTransforms[i], i);
        }
    }

    private void appendEdgePath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        int i2 = (i + 1) % 4;
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i);
        this.shapePath.reset(0.0f, 0.0f);
        getEdgeTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.shapePath.applyToPath(this.edgeTransforms[i], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i], i);
        }
    }

    private float getEdgeCenterForIndex(RectF rectF, int i) {
        this.scratch[0] = this.cornerPaths[i].endX;
        this.scratch[1] = this.cornerPaths[i].endY;
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 1 || i == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private CornerTreatment getCornerTreatmentForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private CornerSize getCornerSizeForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i, ShapeAppearanceModel shapeAppearanceModel) {
        if (i == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    private void getCoordinatesOfCorner(int i, RectF rectF, PointF pointF2) {
        if (i == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    static final class ShapeAppearancePathSpec {
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel2, float f, RectF rectF, PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path2;
        }
    }
}
