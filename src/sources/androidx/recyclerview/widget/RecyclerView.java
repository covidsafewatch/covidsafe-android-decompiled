package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.google.common.primitives.Ints;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (Build.VERSION.SDK_INT >= 23);
    static final boolean ALLOW_THREAD_GAP_WORK = (Build.VERSION.SDK_INT >= 21);
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (Build.VERSION.SDK_INT <= 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (Build.VERSION.SDK_INT <= 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (Build.VERSION.SDK_INT >= 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i, int i2);
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                if (RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.mIsAttached) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.mLayoutSuppressed) {
                        RecyclerView.this.mLayoutWasDefered = true;
                    } else {
                        RecyclerView.this.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                if (RecyclerView.this.mItemAnimator != null) {
                    RecyclerView.this.mItemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
            public void processDisappeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void processPersistent(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                if (RecyclerView.this.mDataSetHasChangedAfterLayout) {
                    if (RecyclerView.this.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (RecyclerView.this.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            public void unused(ViewHolder viewHolder) {
                RecyclerView.this.mLayout.removeAndRecycleView(viewHolder.itemView, RecyclerView.this.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (NoSuchMethodException e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                } catch (ClassNotFoundException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e3);
                } catch (InvocationTargetException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e4);
                } catch (InstantiationException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e7);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public void detachViewFromParent(int i) {
                ViewHolder childViewHolderInt;
                View childAt = getChildAt(i);
                if (!(childAt == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) == null)) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public void onEnteredHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public void onLeftHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
            public ViewHolder findViewHolder(int i) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView.this.mItemsAddedOrRemoved = true;
                RecyclerView.this.mState.mDeletedInvisibleItemCountSincePreviousLayout += i2;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            /* access modifiers changed from: package-private */
            public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                int i = updateOp.cmd;
                if (i == 1) {
                    RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, updateOp.positionStart, updateOp.itemCount);
                } else if (i == 2) {
                    RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, updateOp.positionStart, updateOp.itemCount);
                } else if (i == 4) {
                    RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                } else if (i == 8) {
                    RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, updateOp.positionStart, updateOp.itemCount, 1);
                }
            }

            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    private void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z);
        this.mState.mStructureChanged = true;
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.clear();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.clear();
            }
            this.mChildHelper.removeAllViewsUnfiltered();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    this.mLayout.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.updateViewCacheSize();
            requestLayout();
        }
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mLayout != null && this.mPendingSavedState.mLayoutState != null) {
            this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.addView(view, true);
        } else {
            this.mChildHelper.hide(view);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
        if (removeViewIfHidden) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
        }
        stopInterceptRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.setViewCacheSize(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
        } else if (this.mAdapterHelper.hasPendingUpdates()) {
            if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.consumePostponedUpdates();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.endSection();
            } else if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.endSection();
            }
        }
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i7, i8, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i6 = i10;
            i5 = i9;
            i4 = i7 - i9;
            i3 = i8 - i10;
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i5, i6, i4, i3, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i11 = i4 - iArr4[0];
        int i12 = i3 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i13 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !MotionEventCompat.isFromSource(motionEvent2, 8194)) {
                pullGlows(motionEvent.getX(), (float) i11, motionEvent.getY(), (float) i12);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(i5 == 0 && i6 == 0)) {
            dispatchOnScrolled(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z && i5 == 0 && i6 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, (Interpolator) null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i4 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.smoothScrollBy(i, i2, i3, interpolator);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }

    public boolean fling(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        int i3 = 0;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f, f2, z);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null && onFlingListener.onFling(i, i2)) {
                    return true;
                }
                if (z) {
                    if (canScrollHorizontally) {
                        i3 = 1;
                    }
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    int i4 = this.mMaxFlingVelocity;
                    int max = Math.max(-i4, Math.min(i, i4));
                    int i5 = this.mMaxFlingVelocity;
                    this.mViewFlinger.fling(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.EdgeEffectCompat.onPull(r1, r4, r9)
        L_0x001f:
            r9 = r3
            goto L_0x003c
        L_0x0021:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.onPull(r1, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r1, r7)
            goto L_0x0072
        L_0x0056:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r1, r2)
            goto L_0x0072
        L_0x0071:
            r3 = r9
        L_0x0072:
            if (r3 != 0) goto L_0x007c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
            this.mLeftGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
            this.mRightGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
            this.mTopGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
            this.mBottomGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = true;
        boolean z3 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = instance.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i3) != null) {
                    z2 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
                z = z2;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i);
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        requestChildOnScreen(view2, (View) null);
        return view;
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            i2 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c = 0;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i + exceptionLabel());
                            } else if (c > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i2 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i2 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c > 0 || (c == 0 && i2 * i3 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c < 0 || (c == 0 && i2 * i3 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z = false;
        }
        this.mFirstLayoutComplete = z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            GapWorker gapWorker = GapWorker.sGapWorker.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                float f = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                this.mGapWorker.mFrameIntervalNs = (long) (1.0E9f / f);
                GapWorker.sGapWorker.set(this.mGapWorker);
            }
            this.mGapWorker.add(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener != null) {
            onItemTouchListener.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i |= 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x01e9
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x01e9
        L_0x000f:
            boolean r0 = r17.dispatchToOnItemTouchListeners(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.cancelScroll()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.mNestedOffsets
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.mNestedOffsets
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01b8
            if (r0 == r9) goto L_0x0176
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01de
        L_0x0066:
            r17.onPointerUp(r18)
            goto L_0x01de
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x01de
        L_0x0087:
            r17.cancelScroll()
            goto L_0x01de
        L_0x008c:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.mScrollPointerId
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00fb
            if (r10 == 0) goto L_0x00df
            if (r0 <= 0) goto L_0x00d4
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00db
        L_0x00d4:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00db:
            if (r0 == 0) goto L_0x00df
            r2 = r9
            goto L_0x00e0
        L_0x00df:
            r2 = r8
        L_0x00e0:
            if (r11 == 0) goto L_0x00f6
            if (r1 <= 0) goto L_0x00ec
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00f3
        L_0x00ec:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00f3:
            if (r1 == 0) goto L_0x00f6
            r2 = r9
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r6.setScrollState(r9)
        L_0x00fb:
            r15 = r0
            r16 = r1
            int r0 = r6.mScrollState
            if (r0 != r9) goto L_0x01de
            int[] r0 = r6.mReusableIntPair
            r0[r8] = r8
            r0[r9] = r8
            if (r10 == 0) goto L_0x010c
            r1 = r15
            goto L_0x010d
        L_0x010c:
            r1 = r8
        L_0x010d:
            if (r11 == 0) goto L_0x0112
            r2 = r16
            goto L_0x0113
        L_0x0112:
            r2 = r8
        L_0x0113:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0142
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0142:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0154
            r1 = r15
            goto L_0x0155
        L_0x0154:
            r1 = r8
        L_0x0155:
            if (r11 == 0) goto L_0x0159
            r2 = r0
            goto L_0x015a
        L_0x0159:
            r2 = r8
        L_0x015a:
            boolean r1 = r6.scrollByInternal(r1, r2, r7)
            if (r1 == 0) goto L_0x0167
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0167:
            androidx.recyclerview.widget.GapWorker r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x01de
            if (r15 != 0) goto L_0x016f
            if (r0 == 0) goto L_0x01de
        L_0x016f:
            androidx.recyclerview.widget.GapWorker r1 = r6.mGapWorker
            r1.postFromTraversal(r6, r15, r0)
            goto L_0x01de
        L_0x0176:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.mMaxFlingVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0192
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x0193
        L_0x0192:
            r1 = r0
        L_0x0193:
            if (r11 == 0) goto L_0x019f
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01a0
        L_0x019f:
            r2 = r0
        L_0x01a0:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01a8
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01b0
        L_0x01a8:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01b3
        L_0x01b0:
            r6.setScrollState(r8)
        L_0x01b3:
            r17.resetScroll()
            r8 = r9
            goto L_0x01de
        L_0x01b8:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r10 == 0) goto L_0x01d6
            r0 = r9
            goto L_0x01d7
        L_0x01d6:
            r0 = r8
        L_0x01d7:
            if (r11 == 0) goto L_0x01db
            r0 = r0 | 2
        L_0x01db:
            r6.startNestedScroll(r0, r8)
        L_0x01de:
            if (r8 != 0) goto L_0x01e5
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x01e5:
            r12.recycle()
            return r9
        L_0x01e9:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f = motionEvent.getAxisValue(10);
                    if (!(f2 == 0.0f && f == 0.0f)) {
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f2 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f = axisValue;
                        f2 = 0.0f;
                        scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f2 = 0.0f;
                f = 0.0f;
                scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
            }
            f = 0.0f;
            scrollByInternal((int) (f * this.mScaledHorizontalScrollFactor), (int) (f2 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.mRunPredictiveAnimations) {
                    this.mState.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.mItemCount = adapter.getItemCount();
            } else {
                this.mState.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener((ItemAnimator.ItemAnimatorListener) null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes != 0) {
            i = contentChangeTypes;
        }
        this.mEatenAccessibilityChangeFlags |= i;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.mRunSimpleAnimations = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        State state = this.mState;
        if (state.mRunSimpleAnimations && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        state.mRunPredictiveAnimations = z;
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.mIsMeasuring = false;
            if (this.mState.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        int i;
        ViewHolder viewHolder = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.mFocusedItemId = this.mAdapter.hasStableIds() ? viewHolder.getItemId() : -1;
        State state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (viewHolder.isRemoved()) {
            i = viewHolder.mOldPosition;
        } else {
            i = viewHolder.getAdapterPosition();
        }
        state.mFocusedItemPosition = i;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void resetFocusInfo() {
        this.mState.mFocusedItemId = -1;
        this.mState.mFocusedItemPosition = -1;
        this.mState.mFocusedSubChildId = -1;
    }

    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        int i = this.mState.mFocusedItemPosition != -1 ? this.mState.mFocusedItemPosition : 0;
        int itemCount = this.mState.getItemCount();
        int i2 = i;
        while (i2 < itemCount) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i2++;
            }
        }
        int min = Math.min(itemCount, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.isHidden(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                ViewHolder findViewHolderForItemId = (this.mState.mFocusedItemId == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.mFocusedItemId);
                if (findViewHolderForItemId != null && !this.mChildHelper.isHidden(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    if (!(((long) this.mState.mFocusedSubChildId) == -1 || (findViewById = view.findViewById(this.mState.mFocusedSubChildId)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
        state.mRemainingScrollVertical = 0;
    }

    private void dispatchLayoutStep1() {
        boolean z = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (!state.mRunSimpleAnimations || !this.mItemsChanged) {
            z = false;
        }
        state.mTrackOldChangeHolders = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State state2 = this.mState;
        state2.mInPreLayout = state2.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            boolean z2 = this.mState.mStructureChanged;
            this.mState.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.mStructureChanged = z2;
            for (int i2 = 0; i2 < this.mChildHelper.getChildCount(); i2++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        this.mState.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        this.mPendingSavedState = null;
        State state = this.mState;
        state.mRunSimpleAnimations = state.mRunSimpleAnimations && this.mItemAnimator != null;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.mLayoutStep = 1;
        if (this.mState.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders == null || fromOldChangeHolders.shouldIgnore()) {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    } else {
                        boolean isDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (!isDisappearing || fromOldChangeHolders != childViewHolderInt) {
                            ItemAnimator.ItemHolderInfo popFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo popFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (popFromPreLayout == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            } else {
                                animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, isDisappearing, isDisappearing2);
                            }
                        } else {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        }
                    }
                }
            }
            this.mViewInfoStore.process(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state = this.mState;
        state.mPreviousLayoutItemCount = state.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.mRunSimpleAnimations = false;
        this.mState.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.mChangedScrap != null) {
            this.mRecycler.mChangedScrap.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            this.mLayout.mPrefetchMaxCountObserved = 0;
            this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.updateViewCacheSize();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.mPosition;
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z3 = z;
        }
        if (z3) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i4 && childViewHolderInt.mPosition <= i3) {
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i, int i2) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i, i2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i, i2, z);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i, int i2, Object obj) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i3 = i + i2;
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i4);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(i, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    /* access modifiers changed from: package-private */
    public ViewHolder findViewHolderForPosition(int i, boolean z) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i = 0; i < unfilteredChildCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= ((float) childAt.getLeft()) + translationX && f <= ((float) childAt.getRight()) + translationX && f2 >= ((float) childAt.getTop()) + translationY && f2 <= ((float) childAt.getBottom()) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
    }

    class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest = false;
        Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger() {
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void run() {
            int i;
            int i2;
            if (RecyclerView.this.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            RecyclerView.this.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.mLastFlingX;
                int i4 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.dispatchNestedPreScroll(i3, i4, recyclerView.mReusableIntPair, (int[]) null, 1)) {
                    i3 -= RecyclerView.this.mReusableIntPair[0];
                    i4 -= RecyclerView.this.mReusableIntPair[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (RecyclerView.this.mAdapter != null) {
                    RecyclerView.this.mReusableIntPair[0] = 0;
                    RecyclerView.this.mReusableIntPair[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.scrollStep(i3, i4, recyclerView2.mReusableIntPair);
                    i2 = RecyclerView.this.mReusableIntPair[0];
                    i = RecyclerView.this.mReusableIntPair[1];
                    i3 -= i2;
                    i4 -= i;
                    SmoothScroller smoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i2, i);
                        } else {
                            smoothScroller.onAnimation(i2, i);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.mReusableIntPair[0] = 0;
                RecyclerView.this.mReusableIntPair[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.dispatchNestedScroll(i2, i, i3, i4, (int[]) null, 1, recyclerView3.mReusableIntPair);
                int i5 = i3 - RecyclerView.this.mReusableIntPair[0];
                int i6 = i4 - RecyclerView.this.mReusableIntPair[1];
                if (!(i2 == 0 && i == 0)) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) || !z) {
                    postOnAnimation();
                    if (RecyclerView.this.mGapWorker != null) {
                        RecyclerView.this.mGapWorker.postFromTraversal(RecyclerView.this, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        /* access modifiers changed from: package-private */
        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            if (this.mInterpolator != RecyclerView.sQuinticInterpolator) {
                this.mInterpolator = RecyclerView.sQuinticInterpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.mOverScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = computeScrollDuration(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        private int computeScrollDuration(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = (float) width;
            float f2 = (float) i6;
            float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, RecyclerView.MAX_SCROLL_DURATION);
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mChildHelper.getChildAt(i);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView.this.mState.mStructureChanged = true;
            RecyclerView.this.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i, i2, obj)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i, i2)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i, i2)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i, i2, i3)) {
                triggerUpdateProcessor();
            }
        }

        /* access modifiers changed from: package-private */
        public void triggerUpdateProcessor() {
            if (!RecyclerView.POST_UPDATES_ON_ANIMATION || !RecyclerView.this.mHasFixedSize || !RecyclerView.this.mIsAttached) {
                RecyclerView.this.mAdapterUpdateDuringMeasure = true;
                RecyclerView.this.requestLayout();
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
        }
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        /* access modifiers changed from: protected */
        public EdgeEffect createEdgeEffect(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount = 0;
        SparseArray<ScrapData> mScrap = new SparseArray<>();

        static class ScrapData {
            long mBindRunningAverageNs = 0;
            long mCreateRunningAverageNs = 0;
            int mMaxScrap = 5;
            final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();

            ScrapData() {
            }
        }

        public void clear() {
            for (int i = 0; i < this.mScrap.size(); i++) {
                this.mScrap.valueAt(i).mScrapHeap.clear();
            }
        }

        public void setMaxRecycledViews(int i, int i2) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mMaxScrap = i2;
            ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public int getRecycledViewCount(int i) {
            return getScrapDataForType(i).mScrapHeap.size();
        }

        public ViewHolder getRecycledView(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData == null || scrapData.mScrapHeap.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int size() {
            int i = 0;
            for (int i2 = 0; i2 < this.mScrap.size(); i2++) {
                ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i2).mScrapHeap;
                if (arrayList != null) {
                    i += arrayList.size();
                }
            }
            return i;
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            if (this.mScrap.get(itemViewType).mMaxScrap > arrayList.size()) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        public long runningAverage(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public void factorInCreateTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j);
        }

        /* access modifiers changed from: package-private */
        public void factorInBindTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j);
        }

        /* access modifiers changed from: package-private */
        public boolean willCreateInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mCreateRunningAverageNs;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public boolean willBindInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mBindRunningAverageNs;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public void attach() {
            this.mAttachCount++;
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            this.mAttachCount--;
        }

        /* access modifiers changed from: package-private */
        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                detach();
            }
            if (!z && this.mAttachCount == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach();
            }
        }

        private ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.mScrap.put(i, scrapData2);
            return scrapData2;
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        if (viewHolder.mNestedRecyclerView != null) {
            View view = (View) viewHolder.mNestedRecyclerView.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap = new ArrayList<>();
        final ArrayList<ViewHolder> mCachedViews = new ArrayList<>();
        ArrayList<ViewHolder> mChangedScrap = null;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax = 2;
        private final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax = 2;

        public Recycler() {
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void setViewCacheSize(int i) {
            this.mRequestedCacheMax = i;
            updateViewCacheSize();
        }

        /* access modifiers changed from: package-private */
        public void updateViewCacheSize() {
            this.mViewCacheMax = this.mRequestedCacheMax + (RecyclerView.this.mLayout != null ? RecyclerView.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        /* access modifiers changed from: package-private */
        public boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.isPreLayout();
            }
            if (viewHolder.mPosition < 0 || viewHolder.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.mAdapter.hasStableIds()) {
                    return true;
                }
                if (viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        private boolean tryBindViewHolderByDeadline(ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
            this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (!RecyclerView.this.mState.isPreLayout()) {
                return true;
            }
            viewHolder.mPreLayoutPosition = i2;
            return true;
        }

        public void bindViewToPosition(View view, int i) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i);
                if (findPositionOffset < 0 || findPositionOffset >= RecyclerView.this.mAdapter.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
                }
                tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i, Long.MAX_VALUE);
                ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    childViewHolderInt.itemView.setLayoutParams(layoutParams);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                    childViewHolderInt.itemView.setLayoutParams(layoutParams);
                } else {
                    layoutParams = (LayoutParams) layoutParams2;
                }
                boolean z = true;
                layoutParams.mInsetsDirty = true;
                layoutParams.mViewHolder = childViewHolderInt;
                if (childViewHolderInt.itemView.getParent() != null) {
                    z = false;
                }
                layoutParams.mPendingInvalidate = z;
                return;
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.getItemCount()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.isPreLayout()) {
                return i;
            } else {
                return RecyclerView.this.mAdapterHelper.findPositionOffset(i);
            }
        }

        public View getViewForPosition(int i) {
            return getViewForPosition(i, false);
        }

        /* access modifiers changed from: package-private */
        public View getViewForPosition(int i, boolean z) {
            return tryGetViewHolderForPositionByDeadline(i, z, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0210  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0233
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                int r1 = r1.getItemCount()
                if (r3 >= r1) goto L_0x0233
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                boolean r1 = r1.isPreLayout()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.getChangedScrapViewForPosition(r17)
                if (r1 == 0) goto L_0x0028
                r4 = r7
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = r8
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.getScrapOrHiddenOrCachedHolderForPosition(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.validateViewHolderForOffsetPosition(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.recycleViewHolderInternal(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = r7
            L_0x005d:
                if (r1 != 0) goto L_0x0183
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r5 = r5.mAdapterHelper
                int r5 = r5.findPositionOffset(r3)
                if (r5 < 0) goto L_0x014b
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x014b
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.mAdapter
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.mAdapter
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r6.getScrapOrCachedViewForId(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = r7
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r0 = r6.mViewCacheExtension
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.getViewForPositionAndType(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r0 = r16.getRecycledViewPool()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.getRecycledView(r9)
                if (r0 == 0) goto L_0x0101
                r0.resetInternal()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r1 == 0) goto L_0x0101
                r6.invalidateDisplayListInt(r0)
            L_0x0101:
                r1 = r0
            L_0x0102:
                if (r1 != 0) goto L_0x0183
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r6.mRecyclerPool
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.willCreateInTime(r11, r12, r14)
                if (r5 != 0) goto L_0x0120
                return r2
            L_0x0120:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r2.mAdapter
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r2.createViewHolder(r5, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r5 == 0) goto L_0x013d
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r5)
                if (r5 == 0) goto L_0x013d
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013d:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r5 = r6.mRecyclerPool
                long r10 = r10 - r0
                r5.factorInCreateTime(r9, r10)
                r9 = r2
                goto L_0x0184
            L_0x014b:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.getItemCount()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0183:
                r9 = r1
            L_0x0184:
                r10 = r4
                if (r10 == 0) goto L_0x01bf
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.isPreLayout()
                if (r0 != 0) goto L_0x01bf
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01bf
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.mRunSimpleAnimations
                if (r0 == 0) goto L_0x01bf
                int r0 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r1 = r1.mItemAnimator
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r0 = r1.recordPreLayoutInformation(r2, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r9, r0)
            L_0x01bf:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.isPreLayout()
                if (r0 == 0) goto L_0x01d2
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01d2
                r9.mPreLayoutPosition = r3
                goto L_0x01e5
            L_0x01d2:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01e7
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x01e7
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x01e5
                goto L_0x01e7
            L_0x01e5:
                r0 = r8
                goto L_0x01fa
            L_0x01e7:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                int r2 = r0.findPositionOffset(r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.tryBindViewHolderByDeadline(r1, r2, r3, r4)
            L_0x01fa:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0210
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0228
            L_0x0210:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0226
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0228
            L_0x0226:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0228:
                r1.mViewHolder = r9
                if (r10 == 0) goto L_0x022f
                if (r0 == 0) goto L_0x022f
                goto L_0x0230
            L_0x022f:
                r7 = r8
            L_0x0230:
                r1.mPendingInvalidate = r7
                return r9
            L_0x0233:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.getItemCount()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.tryGetViewHolderForPositionByDeadline(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (RecyclerView.this.mAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view);
                    }
                    ViewCompat.setAccessibilityDelegate(view, itemDelegate);
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            if (viewHolder.itemView instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) viewHolder.itemView, false);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        /* access modifiers changed from: package-private */
        public void recycleCachedViewAt(int i) {
            addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
            this.mCachedViews.remove(i);
        }

        /* access modifiers changed from: package-private */
        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!viewHolder.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.mAdapter != null && doesTransientStatePreventRecycling && RecyclerView.this.mAdapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                    if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.mCachedViews.size();
                        if (size >= this.mViewCacheMax && size > 0) {
                            recycleCachedViewAt(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i).mPosition)) {
                                    break;
                                }
                                i--;
                            }
                            size = i + 1;
                        }
                        this.mCachedViews.add(size, viewHolder);
                        z = true;
                    }
                    if (!z) {
                        addViewHolderToRecycledViewPool(viewHolder, true);
                    } else {
                        z3 = false;
                    }
                    z2 = z;
                } else {
                    z3 = false;
                }
                RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                if (!z2 && !z3 && doesTransientStatePreventRecycling) {
                    viewHolder.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            if (RecyclerView.this.mAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view) : null);
            }
            if (z) {
                dispatchViewRecycled(viewHolder);
            }
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        /* access modifiers changed from: package-private */
        public void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        public void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.mAttachedScrap.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        /* access modifiers changed from: package-private */
        public View getScrapViewAt(int i) {
            return this.mAttachedScrap.get(i).itemView;
        }

        /* access modifiers changed from: package-private */
        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getChangedScrapViewForPosition(int i) {
            int size;
            int findPositionOffset;
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    ViewHolder viewHolder = this.mChangedScrap.get(i3);
                    if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i) {
                        i3++;
                    } else {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i)) > 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(findPositionOffset);
                    while (i2 < size) {
                        ViewHolder viewHolder2 = this.mChangedScrap.get(i2);
                        if (viewHolder2.wasReturnedFromScrap() || viewHolder2.getItemId() != itemId) {
                            i2++;
                        } else {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i, boolean z) {
            View findHiddenNonRemovedView;
            int size = this.mAttachedScrap.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i3);
                if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i || viewHolder.isInvalid() || (!RecyclerView.this.mState.mInPreLayout && viewHolder.isRemoved())) {
                    i3++;
                } else {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (z || (findHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i)) == null) {
                int size2 = this.mCachedViews.size();
                while (i2 < size2) {
                    ViewHolder viewHolder2 = this.mCachedViews.get(i2);
                    if (viewHolder2.isInvalid() || viewHolder2.getLayoutPosition() != i || viewHolder2.isAttachedToTransitionOverlay()) {
                        i2++;
                    } else {
                        if (!z) {
                            this.mCachedViews.remove(i2);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
            RecyclerView.this.mChildHelper.unhide(findHiddenNonRemovedView);
            int indexOfChild = RecyclerView.this.mChildHelper.indexOfChild(findHiddenNonRemovedView);
            if (indexOfChild != -1) {
                RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild);
                scrapView(findHiddenNonRemovedView);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getScrapOrCachedViewForId(long j, int i, boolean z) {
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z) {
                        this.mAttachedScrap.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        quickRecycleScrapView(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.mCachedViews.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z) {
                        recycleCachedViewAt(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void dispatchViewRecycled(ViewHolder viewHolder) {
            if (RecyclerView.this.mRecyclerListener != null) {
                RecyclerView.this.mRecyclerListener.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.mAdapter != null) {
                RecyclerView.this.mAdapter.onViewRecycled(viewHolder);
            }
            if (RecyclerView.this.mState != null) {
                RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        public void onAdapterChanged(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z);
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForMove(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i5 = -1;
                i4 = i;
                i3 = i2;
            } else {
                i5 = 1;
                i3 = i;
                i4 = i2;
            }
            int size = this.mCachedViews.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.mCachedViews.get(i6);
                if (viewHolder != null && viewHolder.mPosition >= i4 && viewHolder.mPosition <= i3) {
                    if (viewHolder.mPosition == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i5, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForInsert(int i, int i2) {
            int size = this.mCachedViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.mCachedViews.get(i3);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    if (viewHolder.mPosition >= i3) {
                        viewHolder.offsetPosition(-i2, z);
                    } else if (viewHolder.mPosition >= i) {
                        viewHolder.addFlags(8);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        /* access modifiers changed from: package-private */
        public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.mRecyclerPool.attach();
            }
        }

        /* access modifiers changed from: package-private */
        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
            }
            return this.mRecyclerPool;
        }

        /* access modifiers changed from: package-private */
        public void viewRangeUpdate(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i4) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void markKnownViewsInvalid() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.mCachedViews.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload((Object) null);
                }
            }
            if (RecyclerView.this.mAdapter == null || !RecyclerView.this.mAdapter.hasStableIds()) {
                recycleAndClearCachedViews();
            }
        }

        /* access modifiers changed from: package-private */
        public void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                this.mCachedViews.get(i).clearOldPosition();
            }
            int size2 = this.mAttachedScrap.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mAttachedScrap.get(i2).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.mChangedScrap.get(i3).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void markItemDecorInsetsDirty() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds = false;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).mInsetsDirty = true;
            }
            TraceCompat.endSection();
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }

            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        };
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }

            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        };
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(State state) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = Ints.MAX_POWER_OF_TWO;
            this.mHeightMode = Ints.MAX_POWER_OF_TWO;
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i4) {
                    i4 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i5) {
                    i5 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i4, i5, i3, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int indexOfChild = this.mChildHelper.indexOfChild(view);
                if (i == -1) {
                    i = this.mChildHelper.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (indexOfChild != i) {
                    this.mRecyclerView.mLayout.moveView(indexOfChild, i);
                }
            } else {
                this.mChildHelper.addView(view, i, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public void removeView(View view) {
            this.mChildHelper.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.detachViewFromParent(i);
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    recycler.scrapView(view);
                    this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
                    return;
                }
                removeViewAt(i);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i = scrapCount - 1; i >= 0; i--) {
                View scrapViewAt = recycler.getScrapViewAt(i);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.quickRecycleScrapView(scrapViewAt);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i2, layoutParams.height);
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i3, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i4, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = r2
                goto L_0x001e
            L_0x000f:
                if (r3 < 0) goto L_0x0013
            L_0x0011:
                r2 = r0
                goto L_0x001e
            L_0x0013:
                r4 = -1
                if (r3 != r4) goto L_0x0018
                r3 = r1
                goto L_0x0011
            L_0x0018:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1
            L_0x001e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0020
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0020
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001e
            L_0x001c:
                r5 = r3
                goto L_0x0031
            L_0x001e:
                if (r7 != r1) goto L_0x0022
            L_0x0020:
                r7 = r4
                goto L_0x0031
            L_0x0022:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x0029
                goto L_0x002c
            L_0x0029:
                r7 = r4
                r5 = r6
                goto L_0x0031
            L_0x002c:
                r7 = r4
                r5 = r2
                goto L_0x0031
            L_0x002f:
                r5 = r6
                r7 = r5
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + layoutParams.leftMargin, i2 + rect.top + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.mRecyclerView.mAdapter != null) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i = 0;
            int position = canScrollVertically() ? getPosition(view) : 0;
            if (canScrollHorizontally()) {
                i = getPosition(view);
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(position, 1, i, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r8, androidx.recyclerview.widget.RecyclerView.State r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.mRecyclerView
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = r9
                r3 = r2
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.getHeight()
                int r11 = r7.getPaddingTop()
                int r8 = r8 - r11
                int r11 = r7.getPaddingBottom()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = r9
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.mRecyclerView
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.getHeight()
                int r10 = r7.getPaddingTop()
                int r8 = r8 - r10
                int r10 = r7.getPaddingBottom()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = r9
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.mRecyclerView
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.getWidth()
                int r11 = r7.getPaddingLeft()
                int r10 = r10 - r11
                int r11 = r7.getPaddingRight()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = r9
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.mRecyclerView
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.smoothScrollBy(r2, r3, r4, r5, r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Ints.MAX_POWER_OF_TWO));
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        Recycler mScrapContainer = null;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionFor(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
    }

    /* access modifiers changed from: package-private */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets = new Rect();
        boolean mInsetsDirty = true;
        boolean mPendingInvalidate = false;
        ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getAdapterPosition();
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction = new Action(0, 0);
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i, int i2, State state, Action action);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, State state, Action action);

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            if (this.mTargetPosition != -1) {
                recyclerView.mState.mTargetPosition = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (!(!this.mPendingInitialRun || this.mTargetView != null || this.mLayoutManager == null || (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) == null || (computeScrollVectorForPosition.x == 0.0f && computeScrollVectorForPosition.y == 0.0f))) {
                recyclerView.scrollStep((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean hasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (hasJumpTarget && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, (Interpolator) null);
            }

            public Action(int i, int i2, int i3) {
                this(i, i2, i3, (Interpolator) null);
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            public void jumpTo(int i) {
                this.mJumpToPosition = i;
            }

            /* access modifiers changed from: package-private */
            public boolean hasJumpTarget() {
                return this.mJumpToPosition >= 0;
            }

            /* access modifiers changed from: package-private */
            public void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                } else if (this.mChanged) {
                    validate();
                    recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    int i2 = this.mConsecutiveUpdates + 1;
                    this.mConsecutiveUpdates = i2;
                    if (i2 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.mChanged = false;
                } else {
                    this.mConsecutiveUpdates = 0;
                }
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int getDx() {
                return this.mDx;
            }

            public void setDx(int i) {
                this.mChanged = true;
                this.mDx = i;
            }

            public int getDy() {
                return this.mDy;
            }

            public void setDy(int i) {
                this.mChanged = true;
                this.mDy = i;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public void setDuration(int i) {
                this.mChanged = true;
                this.mDuration = i;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, (Object) null);
        }

        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable mLayoutState;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        /* access modifiers changed from: package-private */
        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout = false;
        boolean mIsMeasuring = false;
        int mItemCount = 0;
        int mLayoutStep = 1;
        int mPreviousLayoutItemCount = 0;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations = false;
        boolean mRunSimpleAnimations = false;
        boolean mStructureChanged = false;
        int mTargetPosition = -1;
        boolean mTrackOldChangeHolders = false;

        /* access modifiers changed from: package-private */
        public void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
            }
        }

        /* access modifiers changed from: package-private */
        public void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray != null) {
                sparseArray.remove(i);
            }
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        public void put(int i, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i, obj);
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            return this.mTargetPosition != -1;
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        private ItemAnimatorListener mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder viewHolder);
        }

        public abstract boolean animateAppearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
            return true;
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public void onAnimationFinished(ViewHolder viewHolder) {
        }

        public void onAnimationStarted(ViewHolder viewHolder) {
        }

        public abstract void runPendingAnimations();

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        /* access modifiers changed from: package-private */
        public void setListener(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public ItemHolderInfo recordPreLayoutInformation(State state, ViewHolder viewHolder, int i, List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public ItemHolderInfo recordPostLayoutInformation(State state, ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = viewHolder.getOldPosition();
            int adapterPosition = viewHolder.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.mFinishedListeners.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo setFrom(ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }
}
