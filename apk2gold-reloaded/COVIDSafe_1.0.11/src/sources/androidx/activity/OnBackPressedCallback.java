package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;

    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean z) {
        this.mEnabled = z;
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator it = this.mCancellables.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    /* access modifiers changed from: 0000 */
    public void addCancellable(Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    /* access modifiers changed from: 0000 */
    public void removeCancellable(Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }
}
