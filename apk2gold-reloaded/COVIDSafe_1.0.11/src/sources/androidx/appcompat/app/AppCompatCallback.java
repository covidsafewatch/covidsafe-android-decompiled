package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;

public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode actionMode);

    void onSupportActionModeStarted(ActionMode actionMode);

    ActionMode onWindowStartingSupportActionMode(Callback callback);
}
