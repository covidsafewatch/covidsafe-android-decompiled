package androidx.lifecycle;

@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    LifecycleRegistry getLifecycle();
}
