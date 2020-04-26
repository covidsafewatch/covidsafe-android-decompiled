package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof TextView) {
            TextView textView = (TextView) transitionValues.view;
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(textView.getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ValueAnimator valueAnimator = null;
        if (transitionValues != null && transitionValues2 != null && (transitionValues.view instanceof TextView) && (transitionValues2.view instanceof TextView)) {
            final TextView textView = (TextView) transitionValues2.view;
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            String str = PROPNAME_SCALE;
            float f = 1.0f;
            float floatValue = map.get(str) != null ? ((Float) map.get(str)).floatValue() : 1.0f;
            if (map2.get(str) != null) {
                f = ((Float) map2.get(str)).floatValue();
            }
            if (floatValue == f) {
                return null;
            }
            valueAnimator = ValueAnimator.ofFloat(new float[]{floatValue, f});
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    textView.setScaleX(floatValue);
                    textView.setScaleY(floatValue);
                }
            });
        }
        return valueAnimator;
    }
}
