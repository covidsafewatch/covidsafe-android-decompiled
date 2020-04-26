package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NavDestination {
    private static final HashMap<String, Class<?>> sClasses = new HashMap<>();
    private SparseArrayCompat<NavAction> mActions;
    private HashMap<String, NavArgument> mArguments;
    private ArrayList<NavDeepLink> mDeepLinks;
    private int mId;
    private String mIdName;
    private CharSequence mLabel;
    private final String mNavigatorName;
    private NavGraph mParent;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

    /* access modifiers changed from: package-private */
    public boolean supportsActions() {
        return true;
    }

    static class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination mDestination;
        private final boolean mIsExactDeepLink;
        private final Bundle mMatchingArgs;

        DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z) {
            this.mDestination = navDestination;
            this.mMatchingArgs = bundle;
            this.mIsExactDeepLink = z;
        }

        /* access modifiers changed from: package-private */
        public NavDestination getDestination() {
            return this.mDestination;
        }

        /* access modifiers changed from: package-private */
        public Bundle getMatchingArgs() {
            return this.mMatchingArgs;
        }

        public int compareTo(DeepLinkMatch deepLinkMatch) {
            if (this.mIsExactDeepLink && !deepLinkMatch.mIsExactDeepLink) {
                return 1;
            }
            if (this.mIsExactDeepLink || !deepLinkMatch.mIsExactDeepLink) {
                return this.mMatchingArgs.size() - deepLinkMatch.mMatchingArgs.size();
            }
            return -1;
        }
    }

    protected static <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        Class<?> cls2 = sClasses.get(str);
        if (cls2 == null) {
            try {
                cls2 = Class.forName(str, true, context.getClassLoader());
                sClasses.put(str, cls2);
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    static String getDisplayName(Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    public final Map<String, NavArgument> getArguments() {
        HashMap<String, NavArgument> hashMap = this.mArguments;
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.getNameForNavigator(navigator.getClass()));
    }

    public NavDestination(String str) {
        this.mNavigatorName = str;
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        setId(obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0));
        this.mIdName = getDisplayName(context, this.mId);
        setLabel(obtainAttributes.getText(R.styleable.Navigator_android_label));
        obtainAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public final void setParent(NavGraph navGraph) {
        this.mParent = navGraph;
    }

    public final NavGraph getParent() {
        return this.mParent;
    }

    public final int getId() {
        return this.mId;
    }

    public final void setId(int i) {
        this.mId = i;
        this.mIdName = null;
    }

    /* access modifiers changed from: package-private */
    public String getDisplayName() {
        if (this.mIdName == null) {
            this.mIdName = Integer.toString(this.mId);
        }
        return this.mIdName;
    }

    public final void setLabel(CharSequence charSequence) {
        this.mLabel = charSequence;
    }

    public final CharSequence getLabel() {
        return this.mLabel;
    }

    public final String getNavigatorName() {
        return this.mNavigatorName;
    }

    public boolean hasDeepLink(Uri uri) {
        return matchDeepLink(uri) != null;
    }

    public final void addDeepLink(String str) {
        if (this.mDeepLinks == null) {
            this.mDeepLinks = new ArrayList<>();
        }
        this.mDeepLinks.add(new NavDeepLink(str));
    }

    /* access modifiers changed from: package-private */
    public DeepLinkMatch matchDeepLink(Uri uri) {
        ArrayList<NavDeepLink> arrayList = this.mDeepLinks;
        DeepLinkMatch deepLinkMatch = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<NavDeepLink> it = arrayList.iterator();
        while (it.hasNext()) {
            NavDeepLink next = it.next();
            Bundle matchingArguments = next.getMatchingArguments(uri, getArguments());
            if (matchingArguments != null) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, next.isExactDeepLink());
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    /* access modifiers changed from: package-private */
    public int[] buildDeepLinkIds() {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this;
        while (true) {
            NavGraph parent = navGraph.getParent();
            if (parent == null || parent.getStartDestination() != navGraph.getId()) {
                arrayDeque.addFirst(navGraph);
            }
            if (parent == null) {
                break;
            }
            navGraph = parent;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i] = ((NavDestination) it.next()).getId();
            i++;
        }
        return iArr;
    }

    public final NavAction getAction(int i) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.mActions;
        NavAction navAction = sparseArrayCompat == null ? null : sparseArrayCompat.get(i);
        if (navAction != null) {
            return navAction;
        }
        if (getParent() != null) {
            return getParent().getAction(i);
        }
        return null;
    }

    public final void putAction(int i, int i2) {
        putAction(i, new NavAction(i2));
    }

    public final void putAction(int i, NavAction navAction) {
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i != 0) {
            if (this.mActions == null) {
                this.mActions = new SparseArrayCompat<>();
            }
            this.mActions.put(i, navAction);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }

    public final void removeAction(int i) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.mActions;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.delete(i);
        }
    }

    public final void addArgument(String str, NavArgument navArgument) {
        if (this.mArguments == null) {
            this.mArguments = new HashMap<>();
        }
        this.mArguments.put(str, navArgument);
    }

    public final void removeArgument(String str) {
        HashMap<String, NavArgument> hashMap = this.mArguments;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle addInDefaultArgs(Bundle bundle) {
        HashMap<String, NavArgument> hashMap;
        if (bundle == null && ((hashMap = this.mArguments) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, NavArgument> hashMap2 = this.mArguments;
        if (hashMap2 != null) {
            for (Map.Entry next : hashMap2.entrySet()) {
                ((NavArgument) next.getValue()).putDefaultValue((String) next.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, NavArgument> hashMap3 = this.mArguments;
            if (hashMap3 != null) {
                for (Map.Entry next2 : hashMap3.entrySet()) {
                    if (!((NavArgument) next2.getValue()).verify((String) next2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + ((String) next2.getKey()) + "' in argument bundle. " + ((NavArgument) next2.getValue()).getType().getName() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.mIdName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.mId));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.mLabel != null) {
            sb.append(" label=");
            sb.append(this.mLabel);
        }
        return sb.toString();
    }
}
