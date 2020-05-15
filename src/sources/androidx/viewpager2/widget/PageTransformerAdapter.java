package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2.PageTransformer mPageTransformer;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    /* access modifiers changed from: package-private */
    public void setPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.mPageTransformer = pageTransformer;
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.mPageTransformer != null) {
            float f2 = -f;
            int i3 = 0;
            while (i3 < this.mLayoutManager.getChildCount()) {
                View childAt = this.mLayoutManager.getChildAt(i3);
                if (childAt != null) {
                    this.mPageTransformer.transformPage(childAt, ((float) (this.mLayoutManager.getPosition(childAt) - i)) + f2);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.mLayoutManager.getChildCount())}));
                }
            }
        }
    }
}
