package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavOptions.Builder;
import androidx.navigation.Navigator.Extras;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private Activity mActivity;
    final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    private Parcelable[] mBackStackToRestore;
    private final Context mContext;
    private boolean mDeepLinkHandled;
    private boolean mEnableOnBackPressedCallback = true;
    NavGraph mGraph;
    private NavInflater mInflater;
    private final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            if (NavController.this.mGraph != null) {
                for (NavBackStackEntry handleLifecycleEvent : NavController.this.mBackStack) {
                    handleLifecycleEvent.handleLifecycleEvent(event);
                }
            }
        }
    };
    private LifecycleOwner mLifecycleOwner;
    private final NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    private Bundle mNavigatorStateToRestore;
    private final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) {
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    private final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    private NavControllerViewModel mViewModel;

    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public NavController(Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    /* access modifiers changed from: 0000 */
    public Context getContext() {
        return this.mContext;
    }

    public NavigatorProvider getNavigatorProvider() {
        return this.mNavigatorProvider;
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.mBackStack.isEmpty()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.mBackStack.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, navBackStackEntry.getDestination(), navBackStackEntry.getArguments());
        }
        this.mOnDestinationChangedListeners.add(onDestinationChangedListener);
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener onDestinationChangedListener) {
        this.mOnDestinationChangedListeners.remove(onDestinationChangedListener);
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    public boolean popBackStack(int i, boolean z) {
        return popBackStackInternal(i, z) && dispatchOnDestinationChanged();
    }

    /* access modifiers changed from: 0000 */
    public boolean popBackStackInternal(int i, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            NavDestination destination = ((NavBackStackEntry) descendingIterator.next()).getDestination();
            Navigator navigator = this.mNavigatorProvider.getNavigator(destination.getNavigatorName());
            if (z || destination.getId() != i) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            String displayName = NavDestination.getDisplayName(this.mContext, i);
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring popBackStack to destination ");
            sb.append(displayName);
            sb.append(" as it was not found on the current back stack");
            Log.i(TAG, sb.toString());
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.mBackStack.removeLast();
            navBackStackEntry.setMaxLifecycle(State.DESTROYED);
            NavControllerViewModel navControllerViewModel = this.mViewModel;
            if (navControllerViewModel != null) {
                navControllerViewModel.clear(navBackStackEntry.mId);
            }
            z3 = true;
        }
        updateOnBackPressedCallbackEnabled();
        return z3;
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() != 1) {
            return popBackStack();
        }
        NavDestination currentDestination = getCurrentDestination();
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestination() != id) {
                new NavDeepLinkBuilder(this).setDestination(parent.getId()).createTaskStackBuilder().startActivities();
                Activity activity = this.mActivity;
                if (activity != null) {
                    activity.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    private int getDestinationCountOnBackStack() {
        int i = 0;
        for (NavBackStackEntry destination : this.mBackStack) {
            if (!(destination.getDestination() instanceof NavGraph)) {
                i++;
            }
        }
        return i;
    }

    private boolean dispatchOnDestinationChanged() {
        while (!this.mBackStack.isEmpty() && (((NavBackStackEntry) this.mBackStack.peekLast()).getDestination() instanceof NavGraph)) {
            if (!popBackStackInternal(((NavBackStackEntry) this.mBackStack.peekLast()).getDestination().getId(), true)) {
                break;
            }
        }
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        NavDestination destination = ((NavBackStackEntry) this.mBackStack.peekLast()).getDestination();
        NavDestination navDestination = null;
        if (destination instanceof FloatingWindow) {
            Iterator descendingIterator = this.mBackStack.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                NavDestination destination2 = ((NavBackStackEntry) descendingIterator.next()).getDestination();
                if (!(destination2 instanceof NavGraph) && !(destination2 instanceof FloatingWindow)) {
                    navDestination = destination2;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator descendingIterator2 = this.mBackStack.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) descendingIterator2.next();
            State maxLifecycle = navBackStackEntry.getMaxLifecycle();
            NavDestination destination3 = navBackStackEntry.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                if (maxLifecycle != State.RESUMED) {
                    hashMap.put(navBackStackEntry, State.RESUMED);
                }
                destination = destination.getParent();
            } else if (navDestination == null || destination3.getId() != navDestination.getId()) {
                navBackStackEntry.setMaxLifecycle(State.CREATED);
            } else {
                if (maxLifecycle == State.RESUMED) {
                    navBackStackEntry.setMaxLifecycle(State.STARTED);
                } else if (maxLifecycle != State.STARTED) {
                    hashMap.put(navBackStackEntry, State.STARTED);
                }
                navDestination = navDestination.getParent();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : this.mBackStack) {
            State state = (State) hashMap.get(navBackStackEntry2);
            if (state != null) {
                navBackStackEntry2.setMaxLifecycle(state);
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) this.mBackStack.peekLast();
        Iterator it = this.mOnDestinationChangedListeners.iterator();
        while (it.hasNext()) {
            ((OnDestinationChangedListener) it.next()).onDestinationChanged(this, navBackStackEntry3.getDestination(), navBackStackEntry3.getArguments());
        }
        return true;
    }

    public NavInflater getNavInflater() {
        if (this.mInflater == null) {
            this.mInflater = new NavInflater(this.mContext, this.mNavigatorProvider);
        }
        return this.mInflater;
    }

    public void setGraph(int i) {
        setGraph(i, (Bundle) null);
    }

    public void setGraph(int i, Bundle bundle) {
        setGraph(getNavInflater().inflate(i), bundle);
    }

    public void setGraph(NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void setGraph(NavGraph navGraph, Bundle bundle) {
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 != null) {
            popBackStackInternal(navGraph2.getId(), true);
        }
        this.mGraph = navGraph;
        onGraphCreated(bundle);
    }

    private void onGraphCreated(Bundle bundle) {
        Bundle bundle2 = this.mNavigatorStateToRestore;
        if (bundle2 != null) {
            ArrayList stringArrayList = bundle2.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES);
            if (stringArrayList != null) {
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    Navigator navigator = this.mNavigatorProvider.getNavigator(str);
                    Bundle bundle3 = this.mNavigatorStateToRestore.getBundle(str);
                    if (bundle3 != null) {
                        navigator.onRestoreState(bundle3);
                    }
                }
            }
        }
        Parcelable[] parcelableArr = this.mBackStackToRestore;
        boolean z = false;
        if (parcelableArr != null) {
            int length = parcelableArr.length;
            int i = 0;
            while (i < length) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i];
                NavDestination findDestination = findDestination(navBackStackEntryState.getDestinationId());
                if (findDestination != null) {
                    Bundle args = navBackStackEntryState.getArgs();
                    if (args != null) {
                        args.setClassLoader(this.mContext.getClassLoader());
                    }
                    NavBackStackEntry navBackStackEntry = new NavBackStackEntry(this.mContext, findDestination, args, this.mLifecycleOwner, this.mViewModel, navBackStackEntryState.getUUID(), navBackStackEntryState.getSavedState());
                    this.mBackStack.add(navBackStackEntry);
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown destination during restore: ");
                    sb.append(this.mContext.getResources().getResourceName(navBackStackEntryState.getDestinationId()));
                    throw new IllegalStateException(sb.toString());
                }
            }
            updateOnBackPressedCallbackEnabled();
            this.mBackStackToRestore = null;
        }
        if (this.mGraph != null && this.mBackStack.isEmpty()) {
            if (!this.mDeepLinkHandled) {
                Activity activity = this.mActivity;
                if (activity != null && handleDeepLink(activity.getIntent())) {
                    z = true;
                }
            }
            if (!z) {
                navigate((NavDestination) this.mGraph, bundle, (NavOptions) null, (Extras) null);
            }
        }
    }

    public boolean handleDeepLink(Intent intent) {
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray(KEY_DEEP_LINK_IDS) : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle(KEY_DEEP_LINK_EXTRAS) : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null) {
            DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(intent.getData());
            if (matchDeepLink != null) {
                intArray = matchDeepLink.getDestination().buildDeepLinkIds();
                bundle.putAll(matchDeepLink.getMatchingArgs());
            }
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String findInvalidDestinationDisplayNameInDeepLink = findInvalidDestinationDisplayNameInDeepLink(intArray);
        if (findInvalidDestinationDisplayNameInDeepLink != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not find destination ");
            sb.append(findInvalidDestinationDisplayNameInDeepLink);
            sb.append(" in the navigation graph, ignoring the deep link from ");
            sb.append(intent);
            Log.i(TAG, sb.toString());
            return false;
        }
        bundle.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i = 268435456 & flags;
        if (i == 0 || (flags & 32768) != 0) {
            String str = "unknown destination during deep link: ";
            if (i != 0) {
                if (!this.mBackStack.isEmpty()) {
                    popBackStackInternal(this.mGraph.getId(), true);
                }
                int i2 = 0;
                while (i2 < intArray.length) {
                    int i3 = i2 + 1;
                    int i4 = intArray[i2];
                    NavDestination findDestination = findDestination(i4);
                    if (findDestination != null) {
                        navigate(findDestination, bundle, new Builder().setEnterAnim(0).setExitAnim(0).build(), (Extras) null);
                        i2 = i3;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(NavDestination.getDisplayName(this.mContext, i4));
                        throw new IllegalStateException(sb2.toString());
                    }
                }
                return true;
            }
            NavGraph navGraph2 = this.mGraph;
            int i5 = 0;
            while (i5 < intArray.length) {
                int i6 = intArray[i5];
                NavDestination findNode = i5 == 0 ? this.mGraph : navGraph2.findNode(i6);
                if (findNode != null) {
                    if (i5 != intArray.length - 1) {
                        while (true) {
                            navGraph = (NavGraph) findNode;
                            if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                                break;
                            }
                            findNode = navGraph.findNode(navGraph.getStartDestination());
                        }
                        navGraph2 = navGraph;
                    } else {
                        navigate(findNode, findNode.addInDefaultArgs(bundle), new Builder().setPopUpTo(this.mGraph.getId(), true).setEnterAnim(0).setExitAnim(0).build(), (Extras) null);
                    }
                    i5++;
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(NavDestination.getDisplayName(this.mContext, i6));
                    throw new IllegalStateException(sb3.toString());
                }
            }
            this.mDeepLinkHandled = true;
            return true;
        }
        intent.addFlags(32768);
        TaskStackBuilder.create(this.mContext).addNextIntentWithParentStack(intent).startActivities();
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.finish();
            this.mActivity.overridePendingTransition(0, 0);
        }
        return true;
    }

    private String findInvalidDestinationDisplayNameInDeepLink(int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        int i = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            if (i != 0) {
                navDestination = navGraph2.findNode(i2, false);
            } else if (this.mGraph.getId() == i2) {
                navDestination = this.mGraph;
            }
            if (navDestination == null) {
                return NavDestination.getDisplayName(this.mContext, i2);
            }
            if (i != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i++;
        }
    }

    public NavGraph getGraph() {
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public NavDestination getCurrentDestination() {
        if (this.mBackStack.isEmpty()) {
            return null;
        }
        return ((NavBackStackEntry) this.mBackStack.getLast()).getDestination();
    }

    /* access modifiers changed from: 0000 */
    public NavDestination findDestination(int i) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 == null) {
            return null;
        }
        if (navGraph2.getId() == i) {
            return this.mGraph;
        }
        if (this.mBackStack.isEmpty()) {
            navDestination = this.mGraph;
        } else {
            navDestination = ((NavBackStackEntry) this.mBackStack.getLast()).getDestination();
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.getParent();
        }
        return navGraph.findNode(i);
    }

    public void navigate(int i) {
        navigate(i, (Bundle) null);
    }

    public void navigate(int i, Bundle bundle) {
        navigate(i, bundle, (NavOptions) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions) {
        navigate(i, bundle, navOptions, (Extras) null);
    }

    public void navigate(int i, Bundle bundle, NavOptions navOptions, Extras extras) {
        NavDestination navDestination;
        int i2;
        String str;
        if (this.mBackStack.isEmpty()) {
            navDestination = this.mGraph;
        } else {
            navDestination = ((NavBackStackEntry) this.mBackStack.getLast()).getDestination();
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(i);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i2 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i2 = i;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i2 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
            } else if (i2 != 0) {
                NavDestination findDestination = findDestination(i2);
                if (findDestination == null) {
                    String displayName = NavDestination.getDisplayName(this.mContext, i2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("navigation destination ");
                    sb.append(displayName);
                    if (action != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" referenced from action ");
                        sb2.append(NavDestination.getDisplayName(this.mContext, i));
                        str = sb2.toString();
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(" is unknown to this NavController");
                    throw new IllegalArgumentException(sb.toString());
                }
                navigate(findDestination, bundle2, navOptions, extras);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public void navigate(Uri uri) {
        navigate(uri, (NavOptions) null);
    }

    public void navigate(Uri uri, NavOptions navOptions) {
        navigate(uri, navOptions, (Extras) null);
    }

    public void navigate(Uri uri, NavOptions navOptions, Extras extras) {
        DeepLinkMatch matchDeepLink = this.mGraph.matchDeepLink(uri);
        if (matchDeepLink != null) {
            navigate(matchDeepLink.getDestination(), matchDeepLink.getMatchingArgs(), navOptions, extras);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("navigation destination with deepLink ");
        sb.append(uri);
        sb.append(" is unknown to this NavController");
        throw new IllegalArgumentException(sb.toString());
    }

    private void navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
        boolean popBackStackInternal = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : popBackStackInternal(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.getNavigatorName());
        Bundle addInDefaultArgs = navDestination.addInDefaultArgs(bundle);
        NavDestination navigate = navigator.navigate(navDestination, addInDefaultArgs, navOptions, extras);
        if (navigate != null) {
            if (!(navigate instanceof FloatingWindow)) {
                while (!this.mBackStack.isEmpty() && (((NavBackStackEntry) this.mBackStack.peekLast()).getDestination() instanceof FloatingWindow)) {
                    if (!popBackStackInternal(((NavBackStackEntry) this.mBackStack.peekLast()).getDestination().getId(), true)) {
                        break;
                    }
                }
            }
            if (this.mBackStack.isEmpty()) {
                NavBackStackEntry navBackStackEntry = new NavBackStackEntry(this.mContext, this.mGraph, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel);
                this.mBackStack.add(navBackStackEntry);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            NavDestination navDestination2 = navigate;
            while (navDestination2 != null && findDestination(navDestination2.getId()) == null) {
                navDestination2 = navDestination2.getParent();
                if (navDestination2 != null) {
                    NavBackStackEntry navBackStackEntry2 = new NavBackStackEntry(this.mContext, navDestination2, addInDefaultArgs, this.mLifecycleOwner, this.mViewModel);
                    arrayDeque.addFirst(navBackStackEntry2);
                }
            }
            this.mBackStack.addAll(arrayDeque);
            NavBackStackEntry navBackStackEntry3 = new NavBackStackEntry(this.mContext, navigate, navigate.addInDefaultArgs(addInDefaultArgs), this.mLifecycleOwner, this.mViewModel);
            this.mBackStack.add(navBackStackEntry3);
        }
        updateOnBackPressedCallbackEnabled();
        if (popBackStackInternal || navigate != null) {
            dispatchOnDestinationChanged();
        }
    }

    public void navigate(NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(NavDirections navDirections, NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(NavDirections navDirections, Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), (NavOptions) null, extras);
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public Bundle saveState() {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        for (Entry entry : this.mNavigatorProvider.getNavigators().entrySet()) {
            String str = (String) entry.getKey();
            Bundle onSaveState = ((Navigator) entry.getValue()).onSaveState();
            if (onSaveState != null) {
                arrayList.add(str);
                bundle2.putBundle(str, onSaveState);
            }
        }
        if (!arrayList.isEmpty()) {
            bundle = new Bundle();
            bundle2.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, arrayList);
            bundle.putBundle(KEY_NAVIGATOR_STATE, bundle2);
        } else {
            bundle = null;
        }
        if (!this.mBackStack.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.mBackStack.size()];
            int i = 0;
            for (NavBackStackEntry navBackStackEntryState : this.mBackStack) {
                int i2 = i + 1;
                parcelableArr[i] = new NavBackStackEntryState(navBackStackEntryState);
                i = i2;
            }
            bundle.putParcelableArray(KEY_BACK_STACK, parcelableArr);
        }
        if (this.mDeepLinkHandled) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(KEY_DEEP_LINK_HANDLED, this.mDeepLinkHandled);
        }
        return bundle;
    }

    public void restoreState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(this.mContext.getClassLoader());
            this.mNavigatorStateToRestore = bundle.getBundle(KEY_NAVIGATOR_STATE);
            this.mBackStackToRestore = bundle.getParcelableArray(KEY_BACK_STACK);
            this.mDeepLinkHandled = bundle.getBoolean(KEY_DEEP_LINK_HANDLED);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.mLifecycleObserver);
    }

    /* access modifiers changed from: 0000 */
    public void setOnBackPressedDispatcher(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.mLifecycleOwner != null) {
            this.mOnBackPressedCallback.remove();
            onBackPressedDispatcher.addCallback(this.mLifecycleOwner, this.mOnBackPressedCallback);
            return;
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    /* access modifiers changed from: 0000 */
    public void enableOnBackPressed(boolean z) {
        this.mEnableOnBackPressedCallback = z;
        updateOnBackPressedCallbackEnabled();
    }

    private void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        boolean z = true;
        if (!this.mEnableOnBackPressedCallback || getDestinationCountOnBackStack() <= 1) {
            z = false;
        }
        onBackPressedCallback.setEnabled(z);
    }

    /* access modifiers changed from: 0000 */
    public void setViewModelStore(ViewModelStore viewModelStore) {
        if (this.mBackStack.isEmpty()) {
            this.mViewModel = NavControllerViewModel.getInstance(viewModelStore);
            return;
        }
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int i) {
        if (this.mViewModel != null) {
            NavBackStackEntry backStackEntry = getBackStackEntry(i);
            if (backStackEntry.getDestination() instanceof NavGraph) {
                return backStackEntry;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No NavGraph with ID ");
            sb.append(i);
            sb.append(" is on the NavController's back stack");
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
    }

    public NavBackStackEntry getBackStackEntry(int i) {
        NavBackStackEntry navBackStackEntry;
        Iterator descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = (NavBackStackEntry) descendingIterator.next();
            if (navBackStackEntry.getDestination().getId() == i) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No destination with ID ");
        sb.append(i);
        sb.append(" is on the NavController's back stack");
        throw new IllegalArgumentException(sb.toString());
    }
}
