package androidx.navigation;

import android.os.Bundle;

public final class ActionOnlyNavDirections implements NavDirections {
    private final int mActionId;

    public ActionOnlyNavDirections(int i) {
        this.mActionId = i;
    }

    public int getActionId() {
        return this.mActionId;
    }

    public Bundle getArguments() {
        return new Bundle();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return getActionId() == ((ActionOnlyNavDirections) obj).getActionId();
    }

    public int hashCode() {
        return 31 + getActionId();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionOnlyNavDirections(actionId=");
        sb.append(getActionId());
        sb.append(")");
        return sb.toString();
    }
}
