package androidx.navigation;

public final class NavOptions {
    private int mEnterAnim;
    private int mExitAnim;
    private int mPopEnterAnim;
    private int mPopExitAnim;
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    NavOptions(boolean z, int i, boolean z2, int i2, int i3, int i4, int i5) {
        this.mSingleTop = z;
        this.mPopUpTo = i;
        this.mPopUpToInclusive = z2;
        this.mEnterAnim = i2;
        this.mExitAnim = i3;
        this.mPopEnterAnim = i4;
        this.mPopExitAnim = i5;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }

    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    public int getExitAnim() {
        return this.mExitAnim;
    }

    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    public static final class Builder {
        int mEnterAnim = -1;
        int mExitAnim = -1;
        int mPopEnterAnim = -1;
        int mPopExitAnim = -1;
        int mPopUpTo = -1;
        boolean mPopUpToInclusive;
        boolean mSingleTop;

        public Builder setLaunchSingleTop(boolean z) {
            this.mSingleTop = z;
            return this;
        }

        public Builder setPopUpTo(int i, boolean z) {
            this.mPopUpTo = i;
            this.mPopUpToInclusive = z;
            return this;
        }

        public Builder setEnterAnim(int i) {
            this.mEnterAnim = i;
            return this;
        }

        public Builder setExitAnim(int i) {
            this.mExitAnim = i;
            return this;
        }

        public Builder setPopEnterAnim(int i) {
            this.mPopEnterAnim = i;
            return this;
        }

        public Builder setPopExitAnim(int i) {
            this.mPopExitAnim = i;
            return this;
        }

        public NavOptions build() {
            return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
        }
    }
}
