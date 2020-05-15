package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private Paint offScreenPaint;
    private RectF offScreenRectF;
    private final Path path;
    private List<PathContent> pathContents;
    private final RectF rect;
    private TransformKeyframeAnimation transformAnimation;

    private static List<Content> contentsFromModels(LottieDrawable lottieDrawable2, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i).toContent(lottieDrawable2, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    static AnimatableTransform findTransform(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel contentModel = list.get(i);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    public ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable2, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), contentsFromModels(lottieDrawable2, baseLayer, shapeGroup.getItems()), findTransform(shapeGroup.getItems()));
    }

    ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, String str, boolean z, List<Content> list, AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable2;
        this.hidden = z;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.transformAnimation = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public String getName() {
        return this.name;
    }

    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            content.setContents(arrayList, this.contents.subList(0, size));
            arrayList.add(content);
        }
    }

    /* access modifiers changed from: package-private */
    public List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i = 0; i < this.contents.size(); i++) {
                Content content = this.contents.get(i);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    /* access modifiers changed from: package-private */
    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        if (!this.hidden) {
            this.matrix.set(matrix2);
            TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
            if (transformKeyframeAnimation != null) {
                this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
                i = (int) ((((((float) (this.transformAnimation.getOpacity() == null ? 100 : this.transformAnimation.getOpacity().getValue().intValue())) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
            }
            boolean z = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && hasTwoOrMoreDrawableContent() && i != 255;
            if (z) {
                this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                getBounds(this.offScreenRectF, this.matrix, true);
                this.offScreenPaint.setAlpha(i);
                Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint);
            }
            if (z) {
                i = 255;
            }
            for (int size = this.contents.size() - 1; size >= 0; size--) {
                Content content = this.contents.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas, this.matrix, i);
                }
            }
            if (z) {
                canvas.restore();
            }
        }
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int i = 0;
        for (int i2 = 0; i2 < this.contents.size(); i2++) {
            if ((this.contents.get(i2) instanceof DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public void getBounds(RectF rectF, Matrix matrix2, boolean z) {
        this.matrix.set(matrix2);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, z);
                rectF.union(this.rect);
            }
        }
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                int incrementDepthBy = i + keyPath.incrementDepthBy(getName(), i);
                for (int i2 = 0; i2 < this.contents.size(); i2++) {
                    Content content = this.contents.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t, lottieValueCallback);
        }
    }
}
