package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, AnimationListener {
    private final BaseKeyframeAnimation<?, Float> endAnimation;
    private final boolean hidden;
    private final List<AnimationListener> listeners = new ArrayList();
    private final String name;
    private final BaseKeyframeAnimation<?, Float> offsetAnimation;
    private final BaseKeyframeAnimation<?, Float> startAnimation;
    private final Type type;

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.hidden = shapeTrimPath.isHidden();
        this.type = shapeTrimPath.getType();
        this.startAnimation = shapeTrimPath.getStart().createAnimation();
        this.endAnimation = shapeTrimPath.getEnd().createAnimation();
        this.offsetAnimation = shapeTrimPath.getOffset().createAnimation();
        baseLayer.addAnimation(this.startAnimation);
        baseLayer.addAnimation(this.endAnimation);
        baseLayer.addAnimation(this.offsetAnimation);
        this.startAnimation.addUpdateListener(this);
        this.endAnimation.addUpdateListener(this);
        this.offsetAnimation.addUpdateListener(this);
    }

    public void onValueChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            ((AnimationListener) this.listeners.get(i)).onValueChanged();
        }
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: 0000 */
    public void addListener(AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    /* access modifiers changed from: 0000 */
    public Type getType() {
        return this.type;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.startAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.endAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.offsetAnimation;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
