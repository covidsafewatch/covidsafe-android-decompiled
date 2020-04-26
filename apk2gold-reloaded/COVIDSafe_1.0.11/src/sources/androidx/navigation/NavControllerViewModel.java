package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

class NavControllerViewModel extends ViewModel {
    private static final Factory FACTORY = new Factory() {
        public <T extends ViewModel> T create(Class<T> cls) {
            return new NavControllerViewModel();
        }
    };
    private final HashMap<UUID, ViewModelStore> mViewModelStores = new HashMap<>();

    NavControllerViewModel() {
    }

    static NavControllerViewModel getInstance(ViewModelStore viewModelStore) {
        return (NavControllerViewModel) new ViewModelProvider(viewModelStore, FACTORY).get(NavControllerViewModel.class);
    }

    /* access modifiers changed from: 0000 */
    public void clear(UUID uuid) {
        ViewModelStore viewModelStore = (ViewModelStore) this.mViewModelStores.remove(uuid);
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        for (ViewModelStore clear : this.mViewModelStores.values()) {
            clear.clear();
        }
        this.mViewModelStores.clear();
    }

    /* access modifiers changed from: 0000 */
    public ViewModelStore getViewModelStore(UUID uuid) {
        ViewModelStore viewModelStore = (ViewModelStore) this.mViewModelStores.get(uuid);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.mViewModelStores.put(uuid, viewModelStore2);
        return viewModelStore2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator it = this.mViewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
