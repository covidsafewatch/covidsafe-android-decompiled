package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = (Build.VERSION.SDK_INT >= 21);
    private boolean backgroundOverwritten = false;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet = false;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private Drawable maskDrawable;
    private final MaterialButton materialButton;
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke = false;
    private ColorStateList strokeColor;
    private int strokeWidth;

    MaterialButtonHelper(MaterialButton materialButton2, ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
            this.cornerRadius = dimensionPixelSize;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) dimensionPixelSize));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation((float) dimensionPixelSize2);
        }
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    /* access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() != null && this.backgroundTintMode != null) {
                DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        this.shouldDrawSurfaceColorStroke = z;
        updateStroke();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
        if (IS_LOLLIPOP) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.maskDrawable = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable2 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
            this.rippleDrawable = rippleDrawable2;
            return rippleDrawable2;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = rippleDrawableCompat;
        DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
        this.rippleDrawable = layerDrawable;
        return wrapDrawableWithInset(layerDrawable);
    }

    /* access modifiers changed from: package-private */
    public void updateMaskBounds(int i, int i2) {
        Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i2 - this.insetRight, i - this.insetBottom);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundColor(int i) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else if (!IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* access modifiers changed from: package-private */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    /* access modifiers changed from: package-private */
    public void setStrokeWidth(int i) {
        if (this.strokeWidth != i) {
            this.strokeWidth = i;
            updateStroke();
        }
    }

    /* access modifiers changed from: package-private */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    private void updateStroke() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(int i) {
        if (!this.cornerRadiusSet || this.cornerRadius != i) {
            this.cornerRadius = i;
            this.cornerRadiusSet = true;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) i));
        }
    }

    /* access modifiers changed from: package-private */
    public int getCornerRadius() {
        return this.cornerRadius;
    }

    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (IS_LOLLIPOP) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(z ^ true ? 1 : 0);
        }
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(z ^ true ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }

    /* access modifiers changed from: package-private */
    public void setCheckable(boolean z) {
        this.checkable = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void updateButtonShape(ShapeAppearanceModel shapeAppearanceModel2) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        updateButtonShape(shapeAppearanceModel2);
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }
}
