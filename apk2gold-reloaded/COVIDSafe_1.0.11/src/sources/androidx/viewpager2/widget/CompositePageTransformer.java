package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2.PageTransformer;
import java.util.ArrayList;
import java.util.List;

public final class CompositePageTransformer implements PageTransformer {
    private final List<PageTransformer> mTransformers = new ArrayList();

    public void addTransformer(PageTransformer pageTransformer) {
        this.mTransformers.add(pageTransformer);
    }

    public void removeTransformer(PageTransformer pageTransformer) {
        this.mTransformers.remove(pageTransformer);
    }

    public void transformPage(View view, float f) {
        for (PageTransformer transformPage : this.mTransformers) {
            transformPage.transformPage(view, f);
        }
    }
}
