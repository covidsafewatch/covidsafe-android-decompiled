package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY scaleXY = new ScaleXY();

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
    }

    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY2 = (ScaleXY) keyframe.startValue;
        ScaleXY scaleXY3 = (ScaleXY) keyframe.endValue;
        if (this.valueCallback != null) {
            ScaleXY scaleXY4 = (ScaleXY) this.valueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY2, scaleXY3, f, getLinearCurrentKeyframeProgress(), getProgress());
            if (scaleXY4 != null) {
                return scaleXY4;
            }
        }
        this.scaleXY.set(MiscUtils.lerp(scaleXY2.getScaleX(), scaleXY3.getScaleX(), f), MiscUtils.lerp(scaleXY2.getScaleY(), scaleXY3.getScaleY(), f));
        return this.scaleXY;
    }
}
