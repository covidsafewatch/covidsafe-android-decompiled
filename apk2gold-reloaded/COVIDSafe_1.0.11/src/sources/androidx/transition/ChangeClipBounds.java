package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.Map;

public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = {PROPNAME_CLIP};

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            Rect clipBounds = ViewCompat.getClipBounds(view);
            transitionValues.values.put(PROPNAME_CLIP, clipBounds);
            if (clipBounds == null) {
                transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (!(transitionValues == null || transitionValues2 == null)) {
            Map<String, Object> map = transitionValues.values;
            String str = PROPNAME_CLIP;
            if (map.containsKey(str) && transitionValues2.values.containsKey(str)) {
                Rect rect = (Rect) transitionValues.values.get(str);
                Rect rect2 = (Rect) transitionValues2.values.get(str);
                boolean z = rect2 == null;
                if (rect == null && rect2 == null) {
                    return null;
                }
                String str2 = PROPNAME_BOUNDS;
                if (rect == null) {
                    rect = (Rect) transitionValues.values.get(str2);
                } else if (rect2 == null) {
                    rect2 = (Rect) transitionValues2.values.get(str2);
                }
                if (rect.equals(rect2)) {
                    return null;
                }
                ViewCompat.setClipBounds(transitionValues2.view, rect);
                objectAnimator = ObjectAnimator.ofObject(transitionValues2.view, ViewUtils.CLIP_BOUNDS, new RectEvaluator(new Rect()), new Rect[]{rect, rect2});
                if (z) {
                    final View view = transitionValues2.view;
                    objectAnimator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ViewCompat.setClipBounds(view, null);
                        }
                    });
                }
            }
        }
        return objectAnimator;
    }
}
