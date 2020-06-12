package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.core.util.LogWriter;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    private static boolean DEBUG = false;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    static final String TAG = "FragmentManager";
    ArrayList<BackStackRecord> mBackStack;
    private ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    private final AtomicInteger mBackStackIndex = new AtomicInteger();
    FragmentContainer mContainer;
    private ArrayList<Fragment> mCreatedMenus;
    int mCurState = -1;
    private boolean mDestroyed;
    private Runnable mExecCommit = new Runnable() {
        public void run() {
            FragmentManager.this.execPendingActions(true);
        }
    };
    private boolean mExecutingActions;
    private ConcurrentHashMap<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals = new ConcurrentHashMap<>();
    private FragmentFactory mFragmentFactory = null;
    private final FragmentStore mFragmentStore = new FragmentStore();
    private final FragmentTransition.Callback mFragmentTransitionCallback = new FragmentTransition.Callback() {
        public void onStart(Fragment fragment, CancellationSignal cancellationSignal) {
            FragmentManager.this.addCancellationSignal(fragment, cancellationSignal);
        }

        public void onComplete(Fragment fragment, CancellationSignal cancellationSignal) {
            if (!cancellationSignal.isCanceled()) {
                FragmentManager.this.removeCancellationSignal(fragment, cancellationSignal);
            }
        }
    };
    private boolean mHavePendingDeferredStart;
    FragmentHostCallback<?> mHost;
    private FragmentFactory mHostFragmentFactory = new FragmentFactory() {
        public Fragment instantiate(ClassLoader classLoader, String str) {
            return FragmentManager.this.mHost.instantiate(FragmentManager.this.mHost.getContext(), str, (Bundle) null);
        }
    };
    private final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
    private boolean mNeedMenuInvalidate;
    private FragmentManagerViewModel mNonConfig;
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) {
        public void handleOnBackPressed() {
            FragmentManager.this.handleOnBackPressed();
        }
    };
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private Fragment mParent;
    private final ArrayList<OpGenerator> mPendingActions = new ArrayList<>();
    private ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    Fragment mPrimaryNav;
    private boolean mStateSaved;
    private boolean mStopped;
    private ArrayList<Fragment> mTmpAddedFragments;
    private ArrayList<Boolean> mTmpIsPop;
    private ArrayList<BackStackRecord> mTmpRecords;

    public interface BackStackEntry {
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Deprecated
        CharSequence getBreadCrumbTitle();

        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    static int reverseTransit(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i == 4099) {
            return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
        }
        if (i != 8194) {
            return 0;
        }
        return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    }

    @Deprecated
    public static void enableDebugLogging(boolean z) {
        DEBUG = z;
    }

    static boolean isLoggingEnabled(int i) {
        return DEBUG || Log.isLoggable(TAG, i);
    }

    private void throwException(RuntimeException runtimeException) {
        Log.e(TAG, runtimeException.getMessage());
        Log.e(TAG, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(TAG, "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions(true);
        forcePostponedTransactions();
        return execPendingActions;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (getBackStackEntryCount() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (isPrimaryNavigation(r3.mParent) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.setEnabled(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.mOnBackPressedCallback;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateOnBackPressedCallbackEnabled() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r0 = r3.mPendingActions
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r1 = r3.mPendingActions     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.OnBackPressedCallback r1 = r3.mOnBackPressedCallback     // Catch:{ all -> 0x002a }
            r1.setEnabled(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.OnBackPressedCallback r0 = r3.mOnBackPressedCallback
            int r1 = r3.getBackStackEntryCount()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.mParent
            boolean r1 = r3.isPrimaryNavigation(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.setEnabled(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.updateOnBackPressedCallbackEnabled():void");
    }

    /* access modifiers changed from: package-private */
    public boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.getPrimaryNavigationFragment()) || !isPrimaryNavigation(fragmentManager.mParent)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void handleOnBackPressed() {
        execPendingActions(true);
        if (this.mOnBackPressedCallback.isEnabled()) {
            popBackStackImmediate();
        } else {
            this.mOnBackPressedDispatcher.onBackPressed();
        }
    }

    public void popBackStack() {
        enqueueAction(new PopBackStackState((String) null, -1, 0), false);
    }

    public boolean popBackStackImmediate() {
        return popBackStackImmediate((String) null, -1, 0);
    }

    public void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    public boolean popBackStackImmediate(String str, int i) {
        return popBackStackImmediate(str, -1, i);
    }

    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new PopBackStackState((String) null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean popBackStackImmediate(int i, int i2) {
        if (i >= 0) {
            return popBackStackImmediate((String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && str == null && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return popBackStackState;
    }

    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public BackStackEntry getBackStackEntryAt(int i) {
        return this.mBackStack.get(i);
    }

    public void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<>();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<OnBackStackChangedListener> arrayList = this.mBackStackChangeListeners;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void addCancellationSignal(Fragment fragment, CancellationSignal cancellationSignal) {
        if (this.mExitAnimationCancellationSignals.get(fragment) == null) {
            this.mExitAnimationCancellationSignals.put(fragment, new HashSet());
        }
        this.mExitAnimationCancellationSignals.get(fragment).add(cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    public void removeCancellationSignal(Fragment fragment, CancellationSignal cancellationSignal) {
        HashSet hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.mExitAnimationCancellationSignals.remove(fragment);
            if (fragment.mState < 3) {
                destroyFragmentView(fragment);
                moveToState(fragment, fragment.getStateAfterAnimating());
            }
        }
    }

    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment findActiveFragment = findActiveFragment(string);
        if (findActiveFragment == null) {
            throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return findActiveFragment;
    }

    public static <F extends Fragment> F findFragment(View view) {
        F findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            return findViewFragment;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    private static Fragment findViewFragment(View view) {
        while (view != null) {
            Fragment viewFragment = getViewFragment(view);
            if (viewFragment != null) {
                return viewFragment;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    static Fragment getViewFragment(View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    static FragmentManager findFragmentManager(View view) {
        Fragment findViewFragment = findViewFragment(view);
        if (findViewFragment != null) {
            return findViewFragment.getChildFragmentManager();
        }
        Context context = view.getContext();
        FragmentActivity fragmentActivity = null;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public List<Fragment> getFragments() {
        return this.mFragmentStore.getFragments();
    }

    /* access modifiers changed from: package-private */
    public ViewModelStore getViewModelStore(Fragment fragment) {
        return this.mNonConfig.getViewModelStore(fragment);
    }

    private FragmentManagerViewModel getChildNonConfig(Fragment fragment) {
        return this.mNonConfig.getChildNonConfig(fragment);
    }

    /* access modifiers changed from: package-private */
    public void addRetainedFragment(Fragment fragment) {
        if (isStateSaved()) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.mNonConfig.addRetainedFragment(fragment) && isLoggingEnabled(2)) {
            Log.v(TAG, "Updating retained Fragments: Added " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeRetainedFragment(Fragment fragment) {
        if (isStateSaved()) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.mNonConfig.removeRetainedFragment(fragment) && isLoggingEnabled(2)) {
            Log.v(TAG, "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> getActiveFragments() {
        return this.mFragmentStore.getActiveFragments();
    }

    /* access modifiers changed from: package-private */
    public int getActiveFragmentCount() {
        return this.mFragmentStore.getActiveFragmentCount();
    }

    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        FragmentStateManager fragmentStateManager = this.mFragmentStore.getFragmentStateManager(fragment.mWho);
        if (fragmentStateManager == null || !fragmentStateManager.getFragment().equals(fragment)) {
            throwException(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return fragmentStateManager.saveInstanceState();
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.mFragmentStore.dump(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.mCreatedMenus;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.mCreatedMenus.get(i).toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                BackStackRecord backStackRecord = this.mBackStack.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            int size3 = this.mPendingActions.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.mPendingActions.get(i3));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    /* access modifiers changed from: package-private */
    public void performPendingDeferredStart(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.mExecutingActions) {
            this.mHavePendingDeferredStart = true;
            return;
        }
        fragment.mDeferStart = false;
        moveToState(fragment, this.mCurState);
    }

    /* access modifiers changed from: package-private */
    public boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r2 != 3) goto L_0x0209;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveToState(androidx.fragment.app.Fragment r13, int r14) {
        /*
            r12 = this;
            androidx.fragment.app.FragmentStore r0 = r12.mFragmentStore
            java.lang.String r1 = r13.mWho
            androidx.fragment.app.FragmentStateManager r0 = r0.getFragmentStateManager(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0015
            androidx.fragment.app.FragmentStateManager r0 = new androidx.fragment.app.FragmentStateManager
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r2 = r12.mLifecycleCallbacksDispatcher
            r0.<init>(r2, r13)
            r0.setFragmentManagerState(r1)
        L_0x0015:
            int r2 = r0.computeMaxState()
            int r14 = java.lang.Math.min(r14, r2)
            int r2 = r13.mState
            r3 = 0
            java.lang.String r4 = "FragmentManager"
            r5 = -1
            r6 = 2
            r7 = 3
            if (r2 > r14) goto L_0x010c
            int r2 = r13.mState
            if (r2 >= r14) goto L_0x0036
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r12.mExitAnimationCancellationSignals
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0036
            r12.cancelExitAnimation(r13)
        L_0x0036:
            int r2 = r13.mState
            if (r2 == r5) goto L_0x0044
            if (r2 == 0) goto L_0x00e9
            if (r2 == r1) goto L_0x00ee
            if (r2 == r6) goto L_0x0100
            if (r2 == r7) goto L_0x0105
            goto L_0x0209
        L_0x0044:
            if (r14 <= r5) goto L_0x00e9
            boolean r2 = isLoggingEnabled(r7)
            if (r2 == 0) goto L_0x0060
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "moveto ATTACHED: "
            r2.append(r8)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r4, r2)
        L_0x0060:
            androidx.fragment.app.Fragment r2 = r13.mTarget
            java.lang.String r8 = " that does not belong to this FragmentManager!"
            java.lang.String r9 = " declared target fragment "
            java.lang.String r10 = "Fragment "
            if (r2 == 0) goto L_0x00ae
            androidx.fragment.app.Fragment r2 = r13.mTarget
            androidx.fragment.app.Fragment r11 = r13.mTarget
            java.lang.String r11 = r11.mWho
            androidx.fragment.app.Fragment r11 = r12.findActiveFragment(r11)
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x008e
            androidx.fragment.app.Fragment r2 = r13.mTarget
            int r2 = r2.mState
            if (r2 >= r1) goto L_0x0085
            androidx.fragment.app.Fragment r2 = r13.mTarget
            r12.moveToState((androidx.fragment.app.Fragment) r2, (int) r1)
        L_0x0085:
            androidx.fragment.app.Fragment r2 = r13.mTarget
            java.lang.String r2 = r2.mWho
            r13.mTargetWho = r2
            r13.mTarget = r3
            goto L_0x00ae
        L_0x008e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r0.append(r13)
            r0.append(r9)
            androidx.fragment.app.Fragment r13 = r13.mTarget
            r0.append(r13)
            r0.append(r8)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        L_0x00ae:
            java.lang.String r2 = r13.mTargetWho
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = r13.mTargetWho
            androidx.fragment.app.Fragment r2 = r12.findActiveFragment(r2)
            if (r2 == 0) goto L_0x00c2
            int r3 = r2.mState
            if (r3 >= r1) goto L_0x00e2
            r12.moveToState((androidx.fragment.app.Fragment) r2, (int) r1)
            goto L_0x00e2
        L_0x00c2:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r0.append(r13)
            r0.append(r9)
            java.lang.String r13 = r13.mTargetWho
            r0.append(r13)
            r0.append(r8)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        L_0x00e2:
            androidx.fragment.app.FragmentHostCallback<?> r2 = r12.mHost
            androidx.fragment.app.Fragment r3 = r12.mParent
            r0.attach(r2, r12, r3)
        L_0x00e9:
            if (r14 <= 0) goto L_0x00ee
            r0.create()
        L_0x00ee:
            if (r14 <= r5) goto L_0x00f3
            r0.ensureInflatedView()
        L_0x00f3:
            if (r14 <= r1) goto L_0x0100
            androidx.fragment.app.FragmentContainer r1 = r12.mContainer
            r0.createView(r1)
            r0.activityCreated()
            r0.restoreViewState()
        L_0x0100:
            if (r14 <= r6) goto L_0x0105
            r0.start()
        L_0x0105:
            if (r14 <= r7) goto L_0x0209
            r0.resume()
            goto L_0x0209
        L_0x010c:
            int r2 = r13.mState
            if (r2 <= r14) goto L_0x0209
            int r2 = r13.mState
            if (r2 == 0) goto L_0x0200
            r8 = 0
            if (r2 == r1) goto L_0x01bd
            if (r2 == r6) goto L_0x012a
            if (r2 == r7) goto L_0x0125
            r9 = 4
            if (r2 == r9) goto L_0x0120
            goto L_0x0209
        L_0x0120:
            if (r14 >= r9) goto L_0x0125
            r0.pause()
        L_0x0125:
            if (r14 >= r7) goto L_0x012a
            r0.stop()
        L_0x012a:
            if (r14 >= r6) goto L_0x01bd
            boolean r2 = isLoggingEnabled(r7)
            if (r2 == 0) goto L_0x0146
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "movefrom ACTIVITY_CREATED: "
            r2.append(r6)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r4, r2)
        L_0x0146:
            android.view.View r2 = r13.mView
            if (r2 == 0) goto L_0x0159
            androidx.fragment.app.FragmentHostCallback<?> r2 = r12.mHost
            boolean r2 = r2.onShouldSaveFragmentState(r13)
            if (r2 == 0) goto L_0x0159
            android.util.SparseArray<android.os.Parcelable> r2 = r13.mSavedViewState
            if (r2 != 0) goto L_0x0159
            r0.saveViewState()
        L_0x0159:
            android.view.View r2 = r13.mView
            if (r2 == 0) goto L_0x01ae
            android.view.ViewGroup r2 = r13.mContainer
            if (r2 == 0) goto L_0x01ae
            android.view.ViewGroup r2 = r13.mContainer
            android.view.View r6 = r13.mView
            r2.endViewTransition(r6)
            android.view.View r2 = r13.mView
            r2.clearAnimation()
            boolean r2 = r13.isRemovingParent()
            if (r2 != 0) goto L_0x01ae
            int r2 = r12.mCurState
            r6 = 0
            if (r2 <= r5) goto L_0x0196
            boolean r2 = r12.mDestroyed
            if (r2 != 0) goto L_0x0196
            android.view.View r2 = r13.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0196
            float r2 = r13.mPostponedAlpha
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0196
            androidx.fragment.app.FragmentHostCallback<?> r2 = r12.mHost
            android.content.Context r2 = r2.getContext()
            androidx.fragment.app.FragmentContainer r3 = r12.mContainer
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r3 = androidx.fragment.app.FragmentAnim.loadAnimation(r2, r3, r13, r8)
        L_0x0196:
            r13.mPostponedAlpha = r6
            android.view.ViewGroup r2 = r13.mContainer
            android.view.View r5 = r13.mView
            if (r3 == 0) goto L_0x01a6
            r13.setStateAfterAnimating(r14)
            androidx.fragment.app.FragmentTransition$Callback r6 = r12.mFragmentTransitionCallback
            androidx.fragment.app.FragmentAnim.animateRemoveFragment(r13, r3, r6)
        L_0x01a6:
            r2.removeView(r5)
            android.view.ViewGroup r3 = r13.mContainer
            if (r2 == r3) goto L_0x01ae
            return
        L_0x01ae:
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r12.mExitAnimationCancellationSignals
            java.lang.Object r2 = r2.get(r13)
            if (r2 != 0) goto L_0x01ba
            r12.destroyFragmentView(r13)
            goto L_0x01bd
        L_0x01ba:
            r13.setStateAfterAnimating(r14)
        L_0x01bd:
            if (r14 >= r1) goto L_0x0200
            boolean r2 = r13.mRemoving
            if (r2 == 0) goto L_0x01ca
            boolean r2 = r13.isInBackStack()
            if (r2 != 0) goto L_0x01ca
            r8 = 1
        L_0x01ca:
            if (r8 != 0) goto L_0x01ea
            androidx.fragment.app.FragmentManagerViewModel r2 = r12.mNonConfig
            boolean r2 = r2.shouldDestroy(r13)
            if (r2 == 0) goto L_0x01d5
            goto L_0x01ea
        L_0x01d5:
            java.lang.String r2 = r13.mTargetWho
            if (r2 == 0) goto L_0x01ed
            java.lang.String r2 = r13.mTargetWho
            androidx.fragment.app.Fragment r2 = r12.findActiveFragment(r2)
            if (r2 == 0) goto L_0x01ed
            boolean r3 = r2.getRetainInstance()
            if (r3 == 0) goto L_0x01ed
            r13.mTarget = r2
            goto L_0x01ed
        L_0x01ea:
            r12.makeInactive(r0)
        L_0x01ed:
            java.util.concurrent.ConcurrentHashMap<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r12.mExitAnimationCancellationSignals
            java.lang.Object r2 = r2.get(r13)
            if (r2 == 0) goto L_0x01f9
            r13.setStateAfterAnimating(r14)
            goto L_0x0201
        L_0x01f9:
            androidx.fragment.app.FragmentHostCallback<?> r1 = r12.mHost
            androidx.fragment.app.FragmentManagerViewModel r2 = r12.mNonConfig
            r0.destroy(r1, r2)
        L_0x0200:
            r1 = r14
        L_0x0201:
            if (r1 >= 0) goto L_0x0208
            androidx.fragment.app.FragmentManagerViewModel r14 = r12.mNonConfig
            r0.detach(r14)
        L_0x0208:
            r14 = r1
        L_0x0209:
            int r0 = r13.mState
            if (r0 == r14) goto L_0x023b
            boolean r0 = isLoggingEnabled(r7)
            if (r0 == 0) goto L_0x0239
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r13.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r4, r0)
        L_0x0239:
            r13.mState = r14
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.moveToState(androidx.fragment.app.Fragment, int):void");
    }

    private void cancelExitAnimation(Fragment fragment) {
        HashSet hashSet = this.mExitAnimationCancellationSignals.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((CancellationSignal) it.next()).cancel();
            }
            hashSet.clear();
            destroyFragmentView(fragment);
            this.mExitAnimationCancellationSignals.remove(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
        }
    }

    private void destroyFragmentView(Fragment fragment) {
        fragment.performDestroyView();
        this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState);
    }

    private void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, fragment, !fragment.mHidden);
            if (loadAnimation == null || loadAnimation.animator == null) {
                if (loadAnimation != null) {
                    fragment.mView.startAnimation(loadAnimation.animation);
                    loadAnimation.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                loadAnimation.animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    loadAnimation.animator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null && fragment.mHidden) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                loadAnimation.animator.start();
            }
        }
        if (fragment.mAdded && isMenuAvailable(fragment)) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        r0 = r0.mView;
        r1 = r4.mContainer;
        r0 = r1.indexOfChild(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void moveFragmentToExpectedState(androidx.fragment.app.Fragment r4) {
        /*
            r3 = this;
            androidx.fragment.app.FragmentStore r0 = r3.mFragmentStore
            java.lang.String r1 = r4.mWho
            boolean r0 = r0.containsActiveFragment(r1)
            if (r0 != 0) goto L_0x003a
            r0 = 3
            boolean r0 = isLoggingEnabled(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring moving "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " to state "
            r0.append(r4)
            int r4 = r3.mCurState
            r0.append(r4)
            java.lang.String r4 = "since it is not added to "
            r0.append(r4)
            r0.append(r3)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "FragmentManager"
            android.util.Log.d(r0, r4)
        L_0x0039:
            return
        L_0x003a:
            r3.moveToState(r4)
            android.view.View r0 = r4.mView
            if (r0 == 0) goto L_0x00a3
            androidx.fragment.app.FragmentStore r0 = r3.mFragmentStore
            androidx.fragment.app.Fragment r0 = r0.findFragmentUnder(r4)
            if (r0 == 0) goto L_0x0061
            android.view.View r0 = r0.mView
            android.view.ViewGroup r1 = r4.mContainer
            int r0 = r1.indexOfChild(r0)
            android.view.View r2 = r4.mView
            int r2 = r1.indexOfChild(r2)
            if (r2 >= r0) goto L_0x0061
            r1.removeViewAt(r2)
            android.view.View r2 = r4.mView
            r1.addView(r2, r0)
        L_0x0061:
            boolean r0 = r4.mIsNewlyAdded
            if (r0 == 0) goto L_0x00a3
            android.view.ViewGroup r0 = r4.mContainer
            if (r0 == 0) goto L_0x00a3
            float r0 = r4.mPostponedAlpha
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0077
            android.view.View r0 = r4.mView
            float r2 = r4.mPostponedAlpha
            r0.setAlpha(r2)
        L_0x0077:
            r4.mPostponedAlpha = r1
            r0 = 0
            r4.mIsNewlyAdded = r0
            androidx.fragment.app.FragmentHostCallback<?> r0 = r3.mHost
            android.content.Context r0 = r0.getContext()
            androidx.fragment.app.FragmentContainer r1 = r3.mContainer
            r2 = 1
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r0 = androidx.fragment.app.FragmentAnim.loadAnimation(r0, r1, r4, r2)
            if (r0 == 0) goto L_0x00a3
            android.view.animation.Animation r1 = r0.animation
            if (r1 == 0) goto L_0x0097
            android.view.View r1 = r4.mView
            android.view.animation.Animation r0 = r0.animation
            r1.startAnimation(r0)
            goto L_0x00a3
        L_0x0097:
            android.animation.Animator r1 = r0.animator
            android.view.View r2 = r4.mView
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.animator
            r0.start()
        L_0x00a3:
            boolean r0 = r4.mHiddenChanged
            if (r0 == 0) goto L_0x00aa
            r3.completeShowHideFragment(r4)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.moveFragmentToExpectedState(androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void moveToState(int i, boolean z) {
        FragmentHostCallback<?> fragmentHostCallback;
        if (this.mHost == null && i != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.mCurState) {
            this.mCurState = i;
            for (Fragment moveFragmentToExpectedState : this.mFragmentStore.getFragments()) {
                moveFragmentToExpectedState(moveFragmentToExpectedState);
            }
            for (Fragment next : this.mFragmentStore.getActiveFragments()) {
                if (next != null && !next.mIsNewlyAdded) {
                    moveFragmentToExpectedState(next);
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 4) {
                fragmentHostCallback.onSupportInvalidateOptionsMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    private void startPendingDeferredFragments() {
        for (Fragment next : this.mFragmentStore.getActiveFragments()) {
            if (next != null) {
                performPendingDeferredStart(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void makeActive(Fragment fragment) {
        if (!this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            FragmentStateManager fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragment);
            fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
            this.mFragmentStore.makeActive(fragmentStateManager);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    addRetainedFragment(fragment);
                } else {
                    removeRetainedFragment(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            fragmentStateManager.setFragmentManagerState(this.mCurState);
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Added fragment to active set " + fragment);
            }
        }
    }

    private void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (this.mFragmentStore.containsActiveFragment(fragment.mWho)) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "Removed fragment from active set " + fragment);
            }
            this.mFragmentStore.makeInactive(fragmentStateManager);
            removeRetainedFragment(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void addFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "add: " + fragment);
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            this.mFragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.mFragmentStore.removeFragment(fragment);
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void showFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    public void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "remove from detach: " + fragment);
                }
                this.mFragmentStore.removeFragment(fragment);
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v(TAG, "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public Fragment findFragmentById(int i) {
        return this.mFragmentStore.findFragmentById(i);
    }

    public Fragment findFragmentByTag(String str) {
        return this.mFragmentStore.findFragmentByTag(str);
    }

    /* access modifiers changed from: package-private */
    public Fragment findFragmentByWho(String str) {
        return this.mFragmentStore.findFragmentByWho(str);
    }

    /* access modifiers changed from: package-private */
    public Fragment findActiveFragment(String str) {
        return this.mFragmentStore.findActiveFragment(str);
    }

    private void checkStateLoss() {
        if (isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean isStateSaved() {
        return this.mStateSaved || this.mStopped;
    }

    /* access modifiers changed from: package-private */
    public void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost != null) {
                checkStateLoss();
            } else if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.mPendingActions) {
            if (this.mHost != null) {
                this.mPendingActions.add(opGenerator);
                scheduleCommit();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scheduleCommit() {
        synchronized (this.mPendingActions) {
            boolean z = false;
            boolean z2 = this.mPostponedTransactions != null && !this.mPostponedTransactions.isEmpty();
            if (this.mPendingActions.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
                updateOnBackPressedCallbackEnabled();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int allocBackStackIndex() {
        return this.mBackStackIndex.getAndIncrement();
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.mHost.getHandler().getLooper()) {
            if (!z) {
                checkStateLoss();
            }
            if (this.mTmpRecords == null) {
                this.mTmpRecords = new ArrayList<>();
                this.mTmpIsPop = new ArrayList<>();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
            } finally {
                this.mExecutingActions = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* access modifiers changed from: package-private */
    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            updateOnBackPressedCallbackEnabled();
            doPendingDeferredStart();
            this.mFragmentStore.burpActive();
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean execPendingActions(boolean z) {
        ensureExecReady(z);
        boolean z2 = false;
        while (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                z2 = true;
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.burpActive();
        return z2;
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.mPostponedTransactions;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
            if (arrayList != null && !startEnterTransitionListener.mIsBack && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.mRecord)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                startEnterTransitionListener.cancelTransaction();
            } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                if (arrayList == null || startEnterTransitionListener.mIsBack || (indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.completeTransaction();
                } else {
                    startEnterTransitionListener.cancelTransaction();
                }
            }
            i++;
        }
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                executePostponedTransaction(arrayList, arrayList2);
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    if (!arrayList.get(i).mReorderingAllowed) {
                        if (i2 != i) {
                            executeOpsTogether(arrayList, arrayList2, i2, i);
                        }
                        i2 = i + 1;
                        if (arrayList2.get(i).booleanValue()) {
                            while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).mReorderingAllowed) {
                                i2++;
                            }
                        }
                        executeOpsTogether(arrayList, arrayList2, i, i2);
                        i = i2 - 1;
                    }
                    i++;
                }
                if (i2 != size) {
                    executeOpsTogether(arrayList, arrayList2, i2, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i4 = i;
        int i5 = i2;
        boolean z = arrayList3.get(i4).mReorderingAllowed;
        ArrayList<Fragment> arrayList5 = this.mTmpAddedFragments;
        if (arrayList5 == null) {
            this.mTmpAddedFragments = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            BackStackRecord backStackRecord = arrayList3.get(i6);
            if (!arrayList4.get(i6).booleanValue()) {
                primaryNavigationFragment = backStackRecord.expandOps(this.mTmpAddedFragments, primaryNavigationFragment);
            } else {
                primaryNavigationFragment = backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, primaryNavigationFragment);
            }
            z2 = z2 || backStackRecord.mAddToBackStack;
        }
        this.mTmpAddedFragments.clear();
        if (!z) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i2, false, this.mFragmentTransitionCallback);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet arraySet = new ArraySet();
            addAddedFragments(arraySet);
            int postponePostponableTransactions = postponePostponableTransactions(arrayList, arrayList2, i, i2, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i3 = postponePostponableTransactions;
        } else {
            i3 = i5;
        }
        if (i3 != i4 && z) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, i, i3, true, this.mFragmentTransitionCallback);
            moveToState(this.mCurState, true);
        }
        while (i4 < i5) {
            BackStackRecord backStackRecord2 = arrayList3.get(i4);
            if (arrayList4.get(i4).booleanValue() && backStackRecord2.mIndex >= 0) {
                backStackRecord2.mIndex = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i4++;
        }
        if (z2) {
            reportBackStackChanged();
        }
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = arraySet.valueAt(i);
            if (!valueAt.mAdded) {
                View requireView = valueAt.requireView();
                valueAt.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2)) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true, this.mFragmentTransitionCallback);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        for (Fragment next : this.mFragmentStore.getActiveFragments()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && backStackRecord.interactsWith(next.mContainerId)) {
                if (next.mPostponedAlpha > 0.0f) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z3) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.executePopOps(z);
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    private void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag)).setNextAnim(fragment.getNextAnim());
        }
    }

    private ViewGroup getFragmentContainer(Fragment fragment) {
        if (fragment.mContainerId > 0 && this.mContainer.onHasView()) {
            View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById instanceof ViewGroup) {
                return (ViewGroup) onFindViewById;
            }
        }
        return null;
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        int i = this.mCurState;
        if (i >= 1) {
            int min = Math.min(i, 3);
            for (Fragment next : this.mFragmentStore.getFragments()) {
                if (next.mState < min) {
                    moveToState(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        arraySet.add(next);
                    }
                }
            }
        }
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }

    private void endAnimatingAwayFragments() {
        if (!this.mExitAnimationCancellationSignals.isEmpty()) {
            for (Fragment next : this.mExitAnimationCancellationSignals.keySet()) {
                cancelExitAnimation(next);
                moveToState(next, next.getStateAfterAnimating());
            }
        }
    }

    private boolean generateOpsForPendingActions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.mPendingActions) {
            if (this.mPendingActions.isEmpty()) {
                return false;
            }
            int size = this.mPendingActions.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.mPendingActions.get(i).generateOps(arrayList, arrayList2);
            }
            this.mPendingActions.clear();
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            return z;
        }
    }

    private void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    private void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                this.mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<>();
        }
        this.mBackStack.add(backStackRecord);
    }

    /* access modifiers changed from: package-private */
    public boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<BackStackRecord> arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                int size2 = this.mBackStack.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = this.mBackStack.get(size2);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.mBackStack.get(size2);
                        if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.mIndex)) {
                            break;
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.mBackStack.size() - 1) {
                return false;
            }
            for (int size3 = this.mBackStack.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.mBackStack.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig retainNonConfig() {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.mNonConfig.getSnapshot();
    }

    /* access modifiers changed from: package-private */
    public Parcelable saveAllState() {
        int size;
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        ArrayList<FragmentState> saveActiveFragments = this.mFragmentStore.saveActiveFragments();
        BackStackState[] backStackStateArr = null;
        if (saveActiveFragments.isEmpty()) {
            if (isLoggingEnabled(2)) {
                Log.v(TAG, "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> saveAddedFragments = this.mFragmentStore.saveAddedFragments();
        ArrayList<BackStackRecord> arrayList = this.mBackStack;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new BackStackState(this.mBackStack.get(i));
                if (isLoggingEnabled(2)) {
                    Log.v(TAG, "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = saveActiveFragments;
        fragmentManagerState.mAdded = saveAddedFragments;
        fragmentManagerState.mBackStack = backStackStateArr;
        fragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null) {
            fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
        }
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (this.mHost instanceof ViewModelStoreOwner) {
            throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.mNonConfig.restoreFromSnapshot(fragmentManagerNonConfig);
        restoreSaveState(parcelable);
    }

    /* access modifiers changed from: package-private */
    public void restoreSaveState(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                this.mFragmentStore.resetActiveFragments();
                Iterator<FragmentState> it = fragmentManagerState.mActive.iterator();
                while (it.hasNext()) {
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment findRetainedFragmentByWho = this.mNonConfig.findRetainedFragmentByWho(next.mWho);
                        if (findRetainedFragmentByWho != null) {
                            if (isLoggingEnabled(2)) {
                                Log.v(TAG, "restoreSaveState: re-attaching retained " + findRetainedFragmentByWho);
                            }
                            fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, findRetainedFragmentByWho, next);
                        } else {
                            fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mHost.getContext().getClassLoader(), getFragmentFactory(), next);
                        }
                        Fragment fragment = fragmentStateManager.getFragment();
                        fragment.mFragmentManager = this;
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreSaveState: active (" + fragment.mWho + "): " + fragment);
                        }
                        fragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
                        this.mFragmentStore.makeActive(fragmentStateManager);
                        fragmentStateManager.setFragmentManagerState(this.mCurState);
                    }
                }
                for (Fragment next2 : this.mNonConfig.getRetainedFragments()) {
                    if (!this.mFragmentStore.containsActiveFragment(next2.mWho)) {
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                        }
                        moveToState(next2, 1);
                        next2.mRemoving = true;
                        moveToState(next2, -1);
                    }
                }
                this.mFragmentStore.restoreAddedFragments(fragmentManagerState.mAdded);
                if (fragmentManagerState.mBackStack != null) {
                    this.mBackStack = new ArrayList<>(fragmentManagerState.mBackStack.length);
                    for (int i = 0; i < fragmentManagerState.mBackStack.length; i++) {
                        BackStackRecord instantiate = fragmentManagerState.mBackStack[i].instantiate(this);
                        if (isLoggingEnabled(2)) {
                            Log.v(TAG, "restoreAllState: back stack #" + i + " (index " + instantiate.mIndex + "): " + instantiate);
                            PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                            instantiate.dump("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(instantiate);
                    }
                } else {
                    this.mBackStack = null;
                }
                this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
                if (fragmentManagerState.mPrimaryNavActiveWho != null) {
                    Fragment findActiveFragment = findActiveFragment(fragmentManagerState.mPrimaryNavActiveWho);
                    this.mPrimaryNav = findActiveFragment;
                    dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment getParent() {
        return this.mParent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachController(androidx.fragment.app.FragmentHostCallback<?> r3, androidx.fragment.app.FragmentContainer r4, androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r2.mHost
            if (r0 != 0) goto L_0x004b
            r2.mHost = r3
            r2.mContainer = r4
            r2.mParent = r5
            if (r5 == 0) goto L_0x000f
            r2.updateOnBackPressedCallbackEnabled()
        L_0x000f:
            boolean r4 = r3 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r4 == 0) goto L_0x0026
            r4 = r3
            androidx.activity.OnBackPressedDispatcherOwner r4 = (androidx.activity.OnBackPressedDispatcherOwner) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.mOnBackPressedDispatcher = r0
            if (r5 == 0) goto L_0x001f
            r4 = r5
        L_0x001f:
            androidx.activity.OnBackPressedDispatcher r0 = r2.mOnBackPressedDispatcher
            androidx.activity.OnBackPressedCallback r1 = r2.mOnBackPressedCallback
            r0.addCallback(r4, r1)
        L_0x0026:
            if (r5 == 0) goto L_0x0031
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.FragmentManagerViewModel r3 = r3.getChildNonConfig(r5)
            r2.mNonConfig = r3
            goto L_0x004a
        L_0x0031:
            boolean r4 = r3 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r4 == 0) goto L_0x0042
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelStore r3 = r3.getViewModelStore()
            androidx.fragment.app.FragmentManagerViewModel r3 = androidx.fragment.app.FragmentManagerViewModel.getInstance(r3)
            r2.mNonConfig = r3
            goto L_0x004a
        L_0x0042:
            androidx.fragment.app.FragmentManagerViewModel r3 = new androidx.fragment.app.FragmentManagerViewModel
            r4 = 0
            r3.<init>(r4)
            r2.mNonConfig = r3
        L_0x004a:
            return
        L_0x004b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.attachController(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        if (this.mHost != null) {
            this.mStateSaved = false;
            this.mStopped = false;
            for (Fragment next : this.mFragmentStore.getFragments()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(2);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStart() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(3);
    }

    /* access modifiers changed from: package-private */
    public void dispatchResume() {
        this.mStateSaved = false;
        this.mStopped = false;
        dispatchStateChange(4);
    }

    /* access modifiers changed from: package-private */
    public void dispatchPause() {
        dispatchStateChange(3);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStop() {
        this.mStopped = true;
        dispatchStateChange(2);
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    /* access modifiers changed from: package-private */
    public void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        dispatchStateChange(-1);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            this.mOnBackPressedCallback.remove();
            this.mOnBackPressedDispatcher = null;
        }
    }

    /* JADX INFO: finally extract failed */
    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            this.mFragmentStore.dispatchStateChange(i);
            moveToState(i, false);
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchMultiWindowModeChanged(boolean z) {
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchConfigurationChanged(Configuration configuration) {
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchLowMemory() {
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment = this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment next : this.mFragmentStore.getFragments()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState >= 1) {
            for (Fragment next : this.mFragmentStore.getFragments()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (fragment.equals(findActiveFragment(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.mPrimaryNav;
            this.mPrimaryNav = fragment;
            dispatchParentPrimaryNavigationFragmentChanged(fragment2);
            dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    private void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null && fragment.equals(findActiveFragment(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchPrimaryNavigationFragmentChanged() {
        updateOnBackPressedCallbackEnabled();
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    /* access modifiers changed from: package-private */
    public void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public void setFragmentFactory(FragmentFactory fragmentFactory) {
        this.mFragmentFactory = fragmentFactory;
    }

    public FragmentFactory getFragmentFactory() {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    /* access modifiers changed from: package-private */
    public FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher() {
        return this.mLifecycleCallbacksDispatcher;
    }

    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, z);
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    public boolean checkForMenus() {
        boolean z = false;
        for (Fragment next : this.mFragmentStore.getActiveFragments()) {
            if (next != null) {
                z = isMenuAvailable(next);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean isMenuAvailable(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.checkForMenus();
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 getLayoutInflaterFactory() {
        return this.mLayoutInflaterFactory;
    }

    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManager.this.mPrimaryNav != null && this.mId < 0 && this.mName == null && FragmentManager.this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()) {
                return false;
            }
            return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {
        final boolean mIsBack;
        private int mNumPostponed;
        final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void onStartEnterTransition() {
            int i = this.mNumPostponed - 1;
            this.mNumPostponed = i;
            if (i == 0) {
                this.mRecord.mManager.scheduleCommit();
            }
        }

        public void startListening() {
            this.mNumPostponed++;
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        /* access modifiers changed from: package-private */
        public void completeTransaction() {
            boolean z = this.mNumPostponed > 0;
            for (Fragment next : this.mRecord.mManager.getFragments()) {
                next.setOnStartEnterTransitionListener((Fragment.OnStartEnterTransitionListener) null);
                if (z && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, !z, true);
        }

        /* access modifiers changed from: package-private */
        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }
    }
}
