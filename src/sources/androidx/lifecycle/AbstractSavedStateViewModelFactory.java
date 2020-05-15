package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {
    static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";
    private final Bundle mDefaultArgs;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    /* access modifiers changed from: protected */
    public abstract <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle);

    public AbstractSavedStateViewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls) {
        SavedStateHandleController create = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        T create2 = create(str, cls, create.getHandle());
        create2.setTagIfAbsent(TAG_SAVED_STATE_HANDLE_CONTROLLER, create);
        return create2;
    }

    public final <T extends ViewModel> T create(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* access modifiers changed from: package-private */
    public void onRequery(ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }
}
