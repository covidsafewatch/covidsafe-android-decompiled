package androidx.navigation;

import android.os.Bundle;

public final class NavArgument {
    private final Object mDefaultValue;
    private final boolean mDefaultValuePresent;
    private final boolean mIsNullable;
    private final NavType mType;

    NavArgument(NavType<?> navType, boolean z, Object obj, boolean z2) {
        if (!navType.isNullableAllowed() && z) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        } else if (z || !z2 || obj != null) {
            this.mType = navType;
            this.mIsNullable = z;
            this.mDefaultValue = obj;
            this.mDefaultValuePresent = z2;
        } else {
            throw new IllegalArgumentException("Argument with type " + navType.getName() + " has null value but is not nullable.");
        }
    }

    public boolean isDefaultValuePresent() {
        return this.mDefaultValuePresent;
    }

    public NavType<?> getType() {
        return this.mType;
    }

    public boolean isNullable() {
        return this.mIsNullable;
    }

    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    /* access modifiers changed from: package-private */
    public void putDefaultValue(String str, Bundle bundle) {
        if (this.mDefaultValuePresent) {
            this.mType.put(bundle, str, this.mDefaultValue);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean verify(String str, Bundle bundle) {
        if (!this.mIsNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.mType.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.mIsNullable != navArgument.mIsNullable || this.mDefaultValuePresent != navArgument.mDefaultValuePresent || !this.mType.equals(navArgument.mType)) {
            return false;
        }
        Object obj2 = this.mDefaultValue;
        Object obj3 = navArgument.mDefaultValue;
        if (obj2 != null) {
            return obj2.equals(obj3);
        }
        if (obj3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.mType.hashCode() * 31) + (this.mIsNullable ? 1 : 0)) * 31) + (this.mDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.mDefaultValue;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public static final class Builder {
        private Object mDefaultValue;
        private boolean mDefaultValuePresent = false;
        private boolean mIsNullable = false;
        private NavType<?> mType;

        public Builder setType(NavType<?> navType) {
            this.mType = navType;
            return this;
        }

        public Builder setIsNullable(boolean z) {
            this.mIsNullable = z;
            return this;
        }

        public Builder setDefaultValue(Object obj) {
            this.mDefaultValue = obj;
            this.mDefaultValuePresent = true;
            return this;
        }

        public NavArgument build() {
            if (this.mType == null) {
                this.mType = NavType.inferFromValueType(this.mDefaultValue);
            }
            return new NavArgument(this.mType, this.mIsNullable, this.mDefaultValue, this.mDefaultValuePresent);
        }
    }
}
