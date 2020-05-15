package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        AccessibilityDelegateCompat itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof ItemDelegate)) {
            this.mItemDelegate = new ItemDelegate(this);
        } else {
            this.mItemDelegate = (ItemDelegate) itemDelegate;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates = new WeakHashMap();
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.mRecyclerViewDelegate = recyclerViewAccessibilityDelegate;
        }

        /* access modifiers changed from: package-private */
        public void saveOriginalDelegate(View view) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(view);
            if (accessibilityDelegate != null && accessibilityDelegate != this) {
                this.mOriginalItemDelegates.put(view, accessibilityDelegate);
            }
        }

        /* access modifiers changed from: package-private */
        public AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View view) {
            return this.mOriginalItemDelegates.remove(view);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                return;
            }
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (this.mRecyclerViewDelegate.shouldIgnore() || this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                if (accessibilityDelegateCompat.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(viewGroup);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.mOriginalItemDelegates.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
