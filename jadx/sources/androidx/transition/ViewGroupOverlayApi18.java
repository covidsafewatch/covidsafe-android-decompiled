package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.mViewGroupOverlay = viewGroup.getOverlay();
    }

    public void add(Drawable drawable) {
        this.mViewGroupOverlay.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.mViewGroupOverlay.remove(drawable);
    }

    public void add(View view) {
        this.mViewGroupOverlay.add(view);
    }

    public void remove(View view) {
        this.mViewGroupOverlay.remove(view);
    }
}
