package androidx.recyclerview.widget;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;
    int mLastEventPosition = -1;
    int mLastEventType = 0;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i = this.mLastEventType;
        if (i != 0) {
            if (i == 1) {
                this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
            } else if (i == 2) {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            } else if (i == 3) {
                this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
            }
            this.mLastEventPayload = null;
            this.mLastEventType = 0;
        }
    }

    public void onInserted(int i, int i2) {
        if (this.mLastEventType == 1) {
            int i3 = this.mLastEventPosition;
            if (i >= i3) {
                int i4 = this.mLastEventCount;
                if (i <= i3 + i4) {
                    this.mLastEventCount = i4 + i2;
                    this.mLastEventPosition = Math.min(i, i3);
                    return;
                }
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i2;
        this.mLastEventType = 1;
    }

    public void onRemoved(int i, int i2) {
        if (this.mLastEventType == 2) {
            int i3 = this.mLastEventPosition;
            if (i3 >= i && i3 <= i + i2) {
                this.mLastEventCount += i2;
                this.mLastEventPosition = i;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i2;
        this.mLastEventType = 2;
    }

    public void onMoved(int i, int i2) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        if (this.mLastEventType == 3) {
            int i3 = this.mLastEventPosition;
            int i4 = this.mLastEventCount;
            if (i <= i3 + i4) {
                int i5 = i + i2;
                if (i5 >= i3 && this.mLastEventPayload == obj) {
                    int i6 = i4 + i3;
                    this.mLastEventPosition = Math.min(i, i3);
                    this.mLastEventCount = Math.max(i6, i5) - this.mLastEventPosition;
                    return;
                }
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i;
        this.mLastEventCount = i2;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }
}
