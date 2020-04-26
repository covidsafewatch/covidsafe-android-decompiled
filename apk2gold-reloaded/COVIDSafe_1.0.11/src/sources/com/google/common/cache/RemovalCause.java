package com.google.common.cache;

public enum RemovalCause {
    EXPLICIT {
        /* access modifiers changed from: 0000 */
        public boolean wasEvicted() {
            return false;
        }
    },
    REPLACED {
        /* access modifiers changed from: 0000 */
        public boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED {
        /* access modifiers changed from: 0000 */
        public boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED {
        /* access modifiers changed from: 0000 */
        public boolean wasEvicted() {
            return true;
        }
    },
    SIZE {
        /* access modifiers changed from: 0000 */
        public boolean wasEvicted() {
            return true;
        }
    };

    /* access modifiers changed from: 0000 */
    public abstract boolean wasEvicted();
}
