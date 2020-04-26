package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() {
        /* access modifiers changed from: package-private */
        public void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public void set(Matrix matrix) {
            oops();
        }

        public void reset() {
            oops();
        }

        public void setTranslate(float f, float f2) {
            oops();
        }

        public void setScale(float f, float f2, float f3, float f4) {
            oops();
        }

        public void setScale(float f, float f2) {
            oops();
        }

        public void setRotate(float f, float f2, float f3) {
            oops();
        }

        public void setRotate(float f) {
            oops();
        }

        public void setSinCos(float f, float f2, float f3, float f4) {
            oops();
        }

        public void setSinCos(float f, float f2) {
            oops();
        }

        public void setSkew(float f, float f2, float f3, float f4) {
            oops();
        }

        public void setSkew(float f, float f2) {
            oops();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        public boolean preTranslate(float f, float f2) {
            oops();
            return false;
        }

        public boolean preScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public boolean preScale(float f, float f2) {
            oops();
            return false;
        }

        public boolean preRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        public boolean preRotate(float f) {
            oops();
            return false;
        }

        public boolean preSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public boolean preSkew(float f, float f2) {
            oops();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean postTranslate(float f, float f2) {
            oops();
            return false;
        }

        public boolean postScale(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public boolean postScale(float f, float f2) {
            oops();
            return false;
        }

        public boolean postRotate(float f, float f2, float f3) {
            oops();
            return false;
        }

        public boolean postRotate(float f) {
            oops();
            return false;
        }

        public boolean postSkew(float f, float f2, float f3, float f4) {
            oops();
            return false;
        }

        public boolean postSkew(float f, float f2) {
            oops();
            return false;
        }

        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i, float[] fArr2, int i2, int i3) {
            oops();
            return false;
        }

        public void setValues(float[] fArr) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
