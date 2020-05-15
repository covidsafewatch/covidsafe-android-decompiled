package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class Recreator implements GenericLifecycleObserver {
    static final String CLASSES_KEY = "classes_to_restore";
    static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    private final SavedStateRegistryOwner mOwner;

    Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            Bundle consumeRestoredStateForKey = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
            if (consumeRestoredStateForKey != null) {
                ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList(CLASSES_KEY);
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        reflectiveNew(it.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    private void reflectiveNew(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.AutoRecreated) declaredConstructor.newInstance(new Object[0])).onRecreated(this.mOwner);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        final Set<String> mClasses = new HashSet();

        SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(Recreator.CLASSES_KEY, new ArrayList(this.mClasses));
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public void add(String str) {
            this.mClasses.add(str);
        }
    }
}
