package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i = 0;
        GradientColor gradientColor2 = (GradientColor) ((Keyframe) list.get(0)).startValue;
        if (gradientColor2 != null) {
            i = gradientColor2.getSize();
        }
        this.gradientColor = new GradientColor(new float[i], new int[i]);
    }

    /* access modifiers changed from: 0000 */
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.gradientColor.lerp((GradientColor) keyframe.startValue, (GradientColor) keyframe.endValue, f);
        return this.gradientColor;
    }
}
