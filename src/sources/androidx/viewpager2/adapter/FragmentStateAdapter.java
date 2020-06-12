package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    public abstract Fragment createFragment(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Preconditions.checkArgument(this.mFragmentMaxLifecycleEnforcer == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return FragmentViewHolder.create(viewGroup);
    }

    public final void onBindViewHolder(final FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id));
        ensureFragment(i);
        final FrameLayout container = fragmentViewHolder.getContainer();
        if (ViewCompat.isAttachedToWindow(container)) {
            if (container.getParent() == null) {
                container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        if (container.getParent() != null) {
                            container.removeOnLayoutChangeListener(this);
                            FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        gcFragments();
    }

    /* access modifiers changed from: package-private */
    public void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i = 0; i < this.mFragments.size(); i++) {
                long keyAt = this.mFragments.keyAt(i);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
                    long keyAt2 = this.mFragments.keyAt(i2);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long longValue : arraySet) {
                removeFragment(longValue.longValue());
            }
        }
    }

    private boolean isFragmentViewBound(long j) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j)) {
            return true;
        }
        Fragment fragment = this.mFragments.get(j);
        if (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) {
            return false;
        }
        return true;
    }

    private Long itemForViewHolder(int i) {
        Long l = null;
        for (int i2 = 0; i2 < this.mItemIdToViewHolder.size(); i2++) {
            if (this.mItemIdToViewHolder.valueAt(i2).intValue() == i) {
                if (l == null) {
                    l = Long.valueOf(this.mItemIdToViewHolder.keyAt(i2));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l;
    }

    private void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (!this.mFragments.containsKey(itemId)) {
            Fragment createFragment = createFragment(i);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.mFragments.put(itemId, createFragment);
        }
    }

    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    /* access modifiers changed from: package-private */
    public void placeFragmentInViewHolder(final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout container = fragmentViewHolder.getContainer();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                scheduleViewAttach(fragment, container);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    addViewToContainer(view, container);
                } else if (!shouldDelayFragmentTransactions()) {
                    scheduleViewAttach(fragment, container);
                    FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                    beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                    this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                } else if (!this.mFragmentManager.isDestroyed()) {
                    this.mLifecycle.addObserver(new LifecycleEventObserver() {
                        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
                                    FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    private void scheduleViewAttach(final Fragment fragment, final FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    public void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    private void removeFragment(long j) {
        ViewParent parent;
        Fragment fragment = this.mFragments.get(j);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j)) {
                this.mSavedStates.remove(j);
            }
            if (!fragment.isAdded()) {
                this.mFragments.remove(j);
            } else if (shouldDelayFragmentTransactions()) {
                this.mHasStaleFragments = true;
            } else {
                if (fragment.isAdded() && containsItem(j)) {
                    this.mSavedStates.put(j, this.mFragmentManager.saveFragmentInstanceState(fragment));
                }
                this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
                this.mFragments.remove(j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i = 0; i < this.mFragments.size(); i++) {
            long keyAt = this.mFragments.keyAt(i);
            Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i2 = 0; i2 < this.mSavedStates.size(); i2++) {
            long keyAt2 = this.mSavedStates.keyAt(i2);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    public final void restoreState(Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.mFragments.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.put(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, str));
            } else if (isValidKey(str, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + str);
            }
        }
        if (!this.mFragments.isEmpty()) {
            this.mHasStaleFragments = true;
            this.mIsInGracePeriod = true;
            gcFragments();
            scheduleGracePeriodEnd();
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass4 r1 = new Runnable() {
            public void run() {
                FragmentStateAdapter.this.mIsInGracePeriod = false;
                FragmentStateAdapter.this.gcFragments();
            }
        };
        this.mLifecycle.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r1);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(r1, GRACE_WINDOW_TIME_MS);
    }

    private static String createKey(String str, long j) {
        return str + j;
    }

    private static boolean isValidKey(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private static long parseIdFromKey(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        FragmentMaxLifecycleEnforcer() {
        }

        /* access modifiers changed from: package-private */
        public void register(RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            AnonymousClass1 r2 = new ViewPager2.OnPageChangeCallback() {
                public void onPageScrollStateChanged(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                public void onPageSelected(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = r2;
            this.mViewPager.registerOnPageChangeCallback(r2);
            AnonymousClass2 r22 = new DataSetChangeObserver() {
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = r22;
            FragmentStateAdapter.this.registerAdapterDataObserver(r22);
            this.mLifecycleObserver = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            FragmentStateAdapter.this.mLifecycle.addObserver(this.mLifecycleObserver);
        }

        /* access modifiers changed from: package-private */
        public void unregister(RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        /* access modifiers changed from: package-private */
        public void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            Fragment fragment;
            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions() && this.mViewPager.getScrollState() == 0 && !FragmentStateAdapter.this.mFragments.isEmpty() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.mViewPager.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.mPrimaryItemId || z) && (fragment = FragmentStateAdapter.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                    this.mPrimaryItemId = itemId;
                    FragmentTransaction beginTransaction = FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                    Fragment fragment2 = null;
                    for (int i = 0; i < FragmentStateAdapter.this.mFragments.size(); i++) {
                        long keyAt = FragmentStateAdapter.this.mFragments.keyAt(i);
                        Fragment valueAt = FragmentStateAdapter.this.mFragments.valueAt(i);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.mPrimaryItemId) {
                                beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                            } else {
                                fragment2 = valueAt;
                            }
                            valueAt.setMenuVisibility(keyAt == this.mPrimaryItemId);
                        }
                    }
                    if (fragment2 != null) {
                        beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                    }
                    if (!beginTransaction.isEmpty()) {
                        beginTransaction.commitNow();
                    }
                }
            }
        }

        private ViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }
    }

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }
}
