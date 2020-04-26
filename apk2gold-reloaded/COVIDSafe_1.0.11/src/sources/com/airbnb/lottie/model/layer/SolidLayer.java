package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint = new LPaint();
    private final Path path = new Path();
    private final float[] points = new float[8];
    private final RectF rect = new RectF();

    SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.layerModel = layer;
        this.paint.setAlpha(0);
        this.paint.setStyle(Style.FILL);
        this.paint.setColor(layer.getSolidColor());
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.layerModel.getSolidColor());
        if (alpha != 0) {
            int intValue = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) (this.transform.getOpacity() == null ? 100 : ((Integer) this.transform.getOpacity().getValue()).intValue()))) / 100.0f) * 255.0f);
            this.paint.setAlpha(intValue);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter((ColorFilter) baseKeyframeAnimation.getValue());
            }
            if (intValue > 0) {
                float[] fArr = this.points;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.layerModel.getSolidWidth();
                float[] fArr2 = this.points;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.layerModel.getSolidWidth();
                this.points[5] = (float) this.layerModel.getSolidHeight();
                float[] fArr3 = this.points;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.layerModel.getSolidHeight();
                matrix.mapPoints(this.points);
                this.path.reset();
                Path path2 = this.path;
                float[] fArr4 = this.points;
                path2.moveTo(fArr4[0], fArr4[1]);
                Path path3 = this.path;
                float[] fArr5 = this.points;
                path3.lineTo(fArr5[2], fArr5[3]);
                Path path4 = this.path;
                float[] fArr6 = this.points;
                path4.lineTo(fArr6[4], fArr6[5]);
                Path path5 = this.path;
                float[] fArr7 = this.points;
                path5.lineTo(fArr7[6], fArr7[7]);
                Path path6 = this.path;
                float[] fArr8 = this.points;
                path6.lineTo(fArr8[0], fArr8[1]);
                this.path.close();
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.rect.set(0.0f, 0.0f, (float) this.layerModel.getSolidWidth(), (float) this.layerModel.getSolidHeight());
        this.boundsMatrix.mapRect(this.rect);
        rectF.set(this.rect);
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.colorFilterAnimation = null;
        } else {
            this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }
}
