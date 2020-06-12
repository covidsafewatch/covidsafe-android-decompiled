package androidx.transition;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r8, androidx.transition.TransitionValues r9, androidx.transition.TransitionValues r10) {
        /*
            r7 = this;
            r8 = 0
            if (r9 == 0) goto L_0x007e
            if (r10 == 0) goto L_0x007e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.values
            java.lang.String r1 = "android:clipBounds:clip"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x007e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r10.values
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0018
            goto L_0x007e
        L_0x0018:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.values
            java.lang.Object r0 = r0.get(r1)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            java.util.Map<java.lang.String, java.lang.Object> r2 = r10.values
            java.lang.Object r1 = r2.get(r1)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x002e
            r4 = 1
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            if (r0 != 0) goto L_0x0034
            if (r1 != 0) goto L_0x0034
            return r8
        L_0x0034:
            java.lang.String r5 = "android:clipBounds:bounds"
            if (r0 != 0) goto L_0x0042
            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.values
            java.lang.Object r9 = r9.get(r5)
            r0 = r9
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            goto L_0x004d
        L_0x0042:
            if (r1 != 0) goto L_0x004d
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.values
            java.lang.Object r9 = r9.get(r5)
            r1 = r9
            android.graphics.Rect r1 = (android.graphics.Rect) r1
        L_0x004d:
            boolean r9 = r0.equals(r1)
            if (r9 == 0) goto L_0x0054
            return r8
        L_0x0054:
            android.view.View r8 = r10.view
            androidx.core.view.ViewCompat.setClipBounds(r8, r0)
            androidx.transition.RectEvaluator r8 = new androidx.transition.RectEvaluator
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r8.<init>(r9)
            android.view.View r9 = r10.view
            android.util.Property<android.view.View, android.graphics.Rect> r5 = androidx.transition.ViewUtils.CLIP_BOUNDS
            r6 = 2
            android.graphics.Rect[] r6 = new android.graphics.Rect[r6]
            r6[r3] = r0
            r6[r2] = r1
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofObject(r9, r5, r8, r6)
            if (r4 == 0) goto L_0x007e
            android.view.View r9 = r10.view
            androidx.transition.ChangeClipBounds$1 r10 = new androidx.transition.ChangeClipBounds$1
            r10.<init>(r9)
            r8.addListener(r10)
        L_0x007e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeClipBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }
}
