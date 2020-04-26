package androidx.navigation;

import android.os.Bundle;

public interface NavDirections {
    int getActionId();

    Bundle getArguments();
}
