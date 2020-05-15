package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;

@Navigator.Name("dialog")
public final class DialogFragmentNavigator extends Navigator<Destination> {
    private static final String DIALOG_TAG = "androidx-nav-fragment:navigator:dialog:";
    private static final String KEY_DIALOG_COUNT = "androidx-nav-dialogfragment:navigator:count";
    private static final String TAG = "DialogFragmentNavigator";
    private final Context mContext;
    private int mDialogCount = 0;
    private final FragmentManager mFragmentManager;
    private LifecycleEventObserver mObserver = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_STOP) {
                DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
                if (!dialogFragment.requireDialog().isShowing()) {
                    NavHostFragment.findNavController(dialogFragment).popBackStack();
                }
            }
        }
    };

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
    }

    public boolean popBackStack() {
        if (this.mDialogCount == 0) {
            return false;
        }
        if (this.mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        StringBuilder sb = new StringBuilder();
        sb.append(DIALOG_TAG);
        int i = this.mDialogCount - 1;
        this.mDialogCount = i;
        sb.append(i);
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(sb.toString());
        if (findFragmentByTag != null) {
            findFragmentByTag.getLifecycle().removeObserver(this.mObserver);
            ((DialogFragment) findFragmentByTag).dismiss();
        }
        return true;
    }

    public Destination createDestination() {
        return new Destination((Navigator<? extends Destination>) this);
    }

    public NavDestination navigate(Destination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        if (this.mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String className = destination.getClassName();
        if (className.charAt(0) == '.') {
            className = this.mContext.getPackageName() + className;
        }
        Fragment instantiate = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), className);
        if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
            DialogFragment dialogFragment = (DialogFragment) instantiate;
            dialogFragment.setArguments(bundle);
            dialogFragment.getLifecycle().addObserver(this.mObserver);
            FragmentManager fragmentManager = this.mFragmentManager;
            StringBuilder sb = new StringBuilder();
            sb.append(DIALOG_TAG);
            int i = this.mDialogCount;
            this.mDialogCount = i + 1;
            sb.append(i);
            dialogFragment.show(fragmentManager, sb.toString());
            return destination;
        }
        throw new IllegalArgumentException("Dialog destination " + destination.getClassName() + " is not an instance of DialogFragment");
    }

    public Bundle onSaveState() {
        if (this.mDialogCount == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_DIALOG_COUNT, this.mDialogCount);
        return bundle;
    }

    public void onRestoreState(Bundle bundle) {
        if (bundle != null) {
            int i = 0;
            this.mDialogCount = bundle.getInt(KEY_DIALOG_COUNT, 0);
            while (i < this.mDialogCount) {
                FragmentManager fragmentManager = this.mFragmentManager;
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(DIALOG_TAG + i);
                if (dialogFragment != null) {
                    dialogFragment.getLifecycle().addObserver(this.mObserver);
                    i++;
                } else {
                    throw new IllegalStateException("DialogFragment " + i + " doesn't exist in the FragmentManager");
                }
            }
        }
    }

    public static class Destination extends NavDestination implements FloatingWindow {
        private String mClassName;

        public Destination(NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(DialogFragmentNavigator.class));
        }

        public Destination(Navigator<? extends Destination> navigator) {
            super((Navigator<? extends NavDestination>) navigator);
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.DialogFragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.DialogFragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }

        public final Destination setClassName(String str) {
            this.mClassName = str;
            return this;
        }

        public final String getClassName() {
            String str = this.mClassName;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }
    }
}
