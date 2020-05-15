package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void setType(int i) {
        this.mIndicatedType = i;
        this.mResolvedType = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.mIndicatedType;
            if (i2 == 5) {
                this.mResolvedType = 0;
            } else if (i2 == 6) {
                this.mResolvedType = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.mIndicatedType;
                if (i3 == 5) {
                    this.mResolvedType = 1;
                } else if (i3 == 6) {
                    this.mResolvedType = 0;
                }
            } else {
                int i4 = this.mIndicatedType;
                if (i4 == 5) {
                    this.mResolvedType = 0;
                } else if (i4 == 6) {
                    this.mResolvedType = 1;
                }
            }
        }
        this.mBarrier.setBarrierType(this.mResolvedType);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mBarrier = new androidx.constraintlayout.solver.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.mBarrier.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mBarrier.setAllowsGoneWidget(z);
    }

    public boolean allowsGoneWidget() {
        return this.mBarrier.allowsGoneWidget();
    }
}
