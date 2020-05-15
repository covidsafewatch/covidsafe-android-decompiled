package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point = new PointF();
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    public void setProgress(float f) {
        this.xAnimation.setProgress(f);
        this.yAnimation.setProgress(f);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        for (int i = 0; i < this.listeners.size(); i++) {
            ((BaseKeyframeAnimation.AnimationListener) this.listeners.get(i)).onValueChanged();
        }
    }

    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        return this.point;
    }
}
