package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    private final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    CompositeOnPageChangeCallback(int i) {
        this.mCallbacks = new ArrayList(i);
    }

    /* access modifiers changed from: package-private */
    public void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallbacks.add(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallbacks.remove(onPageChangeCallback);
    }

    public void onPageScrolled(int i, float f, int i2) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrolled : this.mCallbacks) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            throwCallbackListModifiedWhileInUse(e);
        }
    }

    public void onPageSelected(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageSelected : this.mCallbacks) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            throwCallbackListModifiedWhileInUse(e);
        }
    }

    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrollStateChanged : this.mCallbacks) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            throwCallbackListModifiedWhileInUse(e);
        }
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
