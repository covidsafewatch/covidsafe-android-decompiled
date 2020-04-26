package com.google.common.collect;

public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    private BoundType(boolean z) {
        this.inclusive = z;
    }

    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    /* access modifiers changed from: package-private */
    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
