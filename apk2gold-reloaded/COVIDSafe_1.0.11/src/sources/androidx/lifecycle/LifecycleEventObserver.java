package androidx.lifecycle;

import androidx.lifecycle.Lifecycle.Event;

public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(LifecycleOwner lifecycleOwner, Event event);
}
