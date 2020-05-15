package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }

    public void onSelected(View view) {
    }

    ItemTouchUIUtilImpl() {
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
            ViewCompat.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float elevation = ViewCompat.getElevation(childAt);
                if (elevation > f) {
                    f = elevation;
                }
            }
        }
        return f;
    }

    public void clearView(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                ViewCompat.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, (Object) null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
