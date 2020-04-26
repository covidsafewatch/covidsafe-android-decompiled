package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

class FragmentViewLifecycleOwner implements LifecycleOwner {
    private LifecycleRegistry mLifecycleRegistry = null;

    FragmentViewLifecycleOwner() {
    }

    /* access modifiers changed from: 0000 */
    public void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isInitialized() {
        return this.mLifecycleRegistry != null;
    }

    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    /* access modifiers changed from: 0000 */
    public void handleLifecycleEvent(Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }
}
