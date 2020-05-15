package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

public final class NavHostController extends NavController {
    public NavHostController(Context context) {
        super(context);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher onBackPressedDispatcher) {
        super.setOnBackPressedDispatcher(onBackPressedDispatcher);
    }

    public void enableOnBackPressed(boolean z) {
        super.enableOnBackPressed(z);
    }

    public void setViewModelStore(ViewModelStore viewModelStore) {
        super.setViewModelStore(viewModelStore);
    }
}
