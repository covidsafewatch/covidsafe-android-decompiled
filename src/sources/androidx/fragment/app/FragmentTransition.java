package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final FragmentTransitionImpl PLATFORM_IMPL = (Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null);
    private static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    interface Callback {
        void onComplete(Fragment fragment, CancellationSignal cancellationSignal);

        void onStart(Fragment fragment, CancellationSignal cancellationSignal);
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void startTransitions(FragmentManager fragmentManager, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, Callback callback) {
        FragmentManager fragmentManager2 = fragmentManager;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i3 = i2;
        boolean z2 = z;
        if (fragmentManager2.mCurState >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i4 = i; i4 < i3; i4++) {
                BackStackRecord backStackRecord = arrayList3.get(i4);
                if (arrayList4.get(i4).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z2);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z2);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManager2.mHost.getContext());
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList3, arrayList4, i, i3);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i5);
                    if (z2) {
                        configureTransitionsReordered(fragmentManager, keyAt, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    } else {
                        configureTransitionsOrdered(fragmentManager, keyAt, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    }
                }
            }
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r12 = r4.lastIn;
        r13 = r4.firstOut;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void configureTransitionsReordered(androidx.fragment.app.FragmentManager r17, int r18, androidx.fragment.app.FragmentTransition.FragmentContainerTransition r19, android.view.View r20, androidx.collection.ArrayMap<java.lang.String, java.lang.String> r21, androidx.fragment.app.FragmentTransition.Callback r22) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            r10 = r22
            androidx.fragment.app.FragmentContainer r1 = r0.mContainer
            boolean r1 = r1.onHasView()
            if (r1 == 0) goto L_0x001b
            androidx.fragment.app.FragmentContainer r0 = r0.mContainer
            r1 = r18
            android.view.View r0 = r0.onFindViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r11 = r0
            if (r11 != 0) goto L_0x0020
            return
        L_0x0020:
            androidx.fragment.app.Fragment r12 = r4.lastIn
            androidx.fragment.app.Fragment r13 = r4.firstOut
            androidx.fragment.app.FragmentTransitionImpl r14 = chooseImpl(r13, r12)
            if (r14 != 0) goto L_0x002b
            return
        L_0x002b:
            boolean r15 = r4.lastInIsPop
            boolean r0 = r4.firstOutIsPop
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.Object r6 = getEnterTransition(r14, r12, r15)
            java.lang.Object r5 = getExitTransition(r14, r13, r0)
            r0 = r14
            r1 = r11
            r2 = r20
            r3 = r21
            r4 = r19
            r17 = r5
            r5 = r7
            r18 = r6
            r6 = r8
            r16 = r11
            r11 = r7
            r7 = r18
            r10 = r8
            r8 = r17
            java.lang.Object r8 = configureSharedElementsReordered(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r18
            if (r6 != 0) goto L_0x0066
            if (r8 != 0) goto L_0x0066
            r7 = r17
            if (r7 != 0) goto L_0x0068
            return
        L_0x0066:
            r7 = r17
        L_0x0068:
            java.util.ArrayList r5 = configureEnteringExitingViews(r14, r7, r13, r11, r9)
            java.util.ArrayList r9 = configureEnteringExitingViews(r14, r6, r12, r10, r9)
            r0 = 4
            setViewVisibility(r9, r0)
            r0 = r14
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r12
            r12 = r5
            r5 = r15
            java.lang.Object r15 = mergeTransitions(r0, r1, r2, r3, r4, r5)
            if (r13 == 0) goto L_0x00a1
            if (r12 == 0) goto L_0x00a1
            int r0 = r12.size()
            if (r0 > 0) goto L_0x008f
            int r0 = r11.size()
            if (r0 <= 0) goto L_0x00a1
        L_0x008f:
            androidx.core.os.CancellationSignal r0 = new androidx.core.os.CancellationSignal
            r0.<init>()
            r1 = r22
            r1.onStart(r13, r0)
            androidx.fragment.app.FragmentTransition$1 r2 = new androidx.fragment.app.FragmentTransition$1
            r2.<init>(r1, r13, r0)
            r14.setListenerForTransitionEnd(r13, r15, r0, r2)
        L_0x00a1:
            if (r15 == 0) goto L_0x00cb
            replaceHide(r14, r7, r13, r12)
            java.util.ArrayList r13 = r14.prepareSetNameOverridesReordered(r10)
            r0 = r14
            r1 = r15
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r12
            r6 = r8
            r7 = r10
            r0.scheduleRemoveTargets(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r14.beginDelayedTransition(r0, r15)
            r1 = r14
            r2 = r0
            r3 = r11
            r4 = r10
            r5 = r13
            r6 = r21
            r1.setNameOverridesReordered(r2, r3, r4, r5, r6)
            r0 = 0
            setViewVisibility(r9, r0)
            r14.swapSharedElementTargets(r8, r11, r10)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.configureTransitionsReordered(androidx.fragment.app.FragmentManager, int, androidx.fragment.app.FragmentTransition$FragmentContainerTransition, android.view.View, androidx.collection.ArrayMap, androidx.fragment.app.FragmentTransition$Callback):void");
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() {
                public void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static void configureTransitionsOrdered(FragmentManager fragmentManager, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, Callback callback) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl chooseImpl;
        Object obj;
        FragmentManager fragmentManager2 = fragmentManager;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        final Callback callback2 = callback;
        ViewGroup viewGroup = fragmentManager2.mContainer.onHasView() ? (ViewGroup) fragmentManager2.mContainer.onFindViewById(i) : null;
        if (viewGroup != null && (chooseImpl = chooseImpl(fragment2, fragment)) != null) {
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            Object enterTransition = getEnterTransition(chooseImpl, (fragment = fragmentContainerTransition2.lastIn), z);
            Object exitTransition = getExitTransition(chooseImpl, (fragment2 = fragmentContainerTransition2.firstOut), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = exitTransition;
            Object obj3 = enterTransition;
            FragmentTransitionImpl fragmentTransitionImpl = chooseImpl;
            final Fragment fragment3 = fragment2;
            Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList3, arrayList2, obj3, obj2);
            Object obj4 = obj3;
            if (obj4 == null && configureSharedElementsOrdered == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(fragmentTransitionImpl, obj, fragment3, arrayList4, view2);
            Object obj5 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : obj;
            fragmentTransitionImpl.addTarget(obj4, view2);
            Object mergeTransitions = mergeTransitions(fragmentTransitionImpl, obj4, obj5, configureSharedElementsOrdered, fragment, fragmentContainerTransition2.lastInIsPop);
            if (!(fragment3 == null || configureEnteringExitingViews == null || (configureEnteringExitingViews.size() <= 0 && arrayList4.size() <= 0))) {
                final CancellationSignal cancellationSignal = new CancellationSignal();
                callback2.onStart(fragment3, cancellationSignal);
                fragmentTransitionImpl.setListenerForTransitionEnd(fragment3, mergeTransitions, cancellationSignal, new Runnable() {
                    public void run() {
                        callback2.onComplete(fragment3, cancellationSignal);
                    }
                });
            }
            if (mergeTransitions != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
                fragmentTransitionImpl2.scheduleRemoveTargets(mergeTransitions, obj4, arrayList5, obj5, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
                scheduleTargetChange(fragmentTransitionImpl2, viewGroup, fragment, view, arrayList2, obj4, arrayList5, obj5, configureEnteringExitingViews);
                ArrayList arrayList6 = arrayList2;
                ArrayMap<String, String> arrayMap3 = arrayMap;
                fragmentTransitionImpl.setNameOverridesOrdered(viewGroup, arrayList6, arrayMap3);
                fragmentTransitionImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                fragmentTransitionImpl.scheduleNameReset(viewGroup, arrayList6, arrayMap3);
            }
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    fragmentTransitionImpl2.removeTarget(obj, view2);
                    arrayList5.addAll(FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl2, obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        fragmentTransitionImpl2.replaceTargets(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
            return PLATFORM_IMPL;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && canHandleAll(fragmentTransitionImpl2, arrayList)) {
            return SUPPORT_IMPL;
        }
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(obj));
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(obj);
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        final Rect rect;
        final View view2;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition2.lastInIsPop;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z);
        }
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, arrayMap2, obj3, fragmentContainerTransition2);
        ArrayMap<String, View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl, arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            obj4 = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList3, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList4, captureInSharedElements, arrayMap.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            fragmentTransitionImpl.setSharedElementTargets(obj4, view3, arrayList3);
            setOutEpicenter(fragmentTransitionImpl, obj4, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            Rect rect2 = new Rect();
            View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition2, obj5, z);
            if (inEpicenterView != null) {
                fragmentTransitionImpl.setEpicenter(obj5, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayMap<String, View> arrayMap3 = captureInSharedElements;
        final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public void run() {
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, arrayMap3, false);
                View view = view2;
                if (view != null) {
                    fragmentTransitionImpl3.getBoundsOnScreen(view, rect);
                }
            }
        });
        return obj4;
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition2.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = getSharedElementTransition(fragmentTransitionImpl2, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl2, arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(captureOutSharedElements.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj4 != null) {
            rect = new Rect();
            fragmentTransitionImpl2.setSharedElementTargets(obj4, view, arrayList3);
            setOutEpicenter(fragmentTransitionImpl, obj4, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            if (obj5 != null) {
                fragmentTransitionImpl2.setEpicenter(obj5, rect);
            }
        } else {
            rect = null;
        }
        final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
        final ArrayMap<String, String> arrayMap3 = arrayMap;
        final Object obj6 = obj4;
        final FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition;
        AnonymousClass6 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                ArrayMap<String, View> captureInSharedElements = FragmentTransition.captureInSharedElements(fragmentTransitionImpl3, arrayMap3, obj6, fragmentContainerTransition3);
                if (captureInSharedElements != null) {
                    arrayList4.addAll(captureInSharedElements.values());
                    arrayList4.add(view2);
                }
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, captureInSharedElements, false);
                Object obj = obj6;
                if (obj != null) {
                    fragmentTransitionImpl3.swapSharedElementTargets(obj, arrayList5, arrayList4);
                    View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, fragmentContainerTransition3, obj7, z2);
                    if (inEpicenterView != null) {
                        fragmentTransitionImpl3.getBoundsOnScreen(inEpicenterView, rect2);
                    }
                }
            }
        };
        OneShotPreDrawListener.add(viewGroup, r13);
        return obj4;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList arrayList;
        String findKeyForValue;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.remove(findKeyForValue2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (findKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) backStackRecord.mSharedElementSourceNames.get(0);
        } else {
            str = (String) backStackRecord.mSharedElementTargetNames.get(0);
        }
        return arrayMap.get(str);
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            if (z) {
                str = (String) backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                str = (String) backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback sharedElementCallback;
        int i;
        if (z) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                sharedElementCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op) backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op) backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    static boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0070, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008c, code lost:
        if (r0.mHidden == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00db A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void addToFirstInLastOut(androidx.fragment.app.BackStackRecord r8, androidx.fragment.app.FragmentTransaction.Op r9, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.mFragment
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = INVERSE_OPS
            int r9 = r9.mCmd
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.mCmd
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x0081
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x0081
            r9 = 0
        L_0x0029:
            r4 = 0
            r5 = 0
            goto L_0x0094
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0090
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0090
            goto L_0x008e
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x0091
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0072
        L_0x004d:
            goto L_0x0070
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x004d
        L_0x0057:
            if (r12 == 0) goto L_0x0074
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0072
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0072
            android.view.View r9 = r0.mView
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0072
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0072
        L_0x0070:
            r9 = 1
            goto L_0x007d
        L_0x0072:
            r9 = 0
            goto L_0x007d
        L_0x0074:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0072
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0072
            goto L_0x0070
        L_0x007d:
            r5 = r9
            r9 = 0
            r4 = 1
            goto L_0x0094
        L_0x0081:
            if (r12 == 0) goto L_0x0086
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x0091
        L_0x0086:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0090
        L_0x008e:
            r9 = 1
            goto L_0x0091
        L_0x0090:
            r9 = 0
        L_0x0091:
            r2 = r9
            r9 = 1
            goto L_0x0029
        L_0x0094:
            java.lang.Object r6 = r10.get(r1)
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r6 = (androidx.fragment.app.FragmentTransition.FragmentContainerTransition) r6
            if (r2 == 0) goto L_0x00a6
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r6 = ensureContainer(r6, r10, r1)
            r6.lastIn = r0
            r6.lastInIsPop = r11
            r6.lastInTransaction = r8
        L_0x00a6:
            r2 = 0
            if (r12 != 0) goto L_0x00c7
            if (r9 == 0) goto L_0x00c7
            if (r6 == 0) goto L_0x00b3
            androidx.fragment.app.Fragment r9 = r6.firstOut
            if (r9 != r0) goto L_0x00b3
            r6.firstOut = r2
        L_0x00b3:
            androidx.fragment.app.FragmentManager r9 = r8.mManager
            int r7 = r0.mState
            if (r7 >= r3) goto L_0x00c7
            int r7 = r9.mCurState
            if (r7 < r3) goto L_0x00c7
            boolean r7 = r8.mReorderingAllowed
            if (r7 != 0) goto L_0x00c7
            r9.makeActive(r0)
            r9.moveToState((androidx.fragment.app.Fragment) r0, (int) r3)
        L_0x00c7:
            if (r5 == 0) goto L_0x00d9
            if (r6 == 0) goto L_0x00cf
            androidx.fragment.app.Fragment r9 = r6.firstOut
            if (r9 != 0) goto L_0x00d9
        L_0x00cf:
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r6 = ensureContainer(r6, r10, r1)
            r6.firstOut = r0
            r6.firstOutIsPop = r11
            r6.firstOutTransaction = r8
        L_0x00d9:
            if (r12 != 0) goto L_0x00e5
            if (r4 == 0) goto L_0x00e5
            if (r6 == 0) goto L_0x00e5
            androidx.fragment.app.Fragment r8 = r6.lastIn
            if (r8 != r0) goto L_0x00e5
            r6.lastIn = r2
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.addToFirstInLastOut(androidx.fragment.app.BackStackRecord, androidx.fragment.app.FragmentTransaction$Op, android.util.SparseArray, boolean, boolean):void");
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    private FragmentTransition() {
    }
}
