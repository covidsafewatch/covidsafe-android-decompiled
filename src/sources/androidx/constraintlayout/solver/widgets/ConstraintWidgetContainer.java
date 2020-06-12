package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 7;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public String getType() {
        return "ConstraintLayout";
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int i) {
        if ((this.mOptimizationLevel & i) == i) {
            return USE_SNAPSHOT;
        }
        return false;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return USE_SNAPSHOT;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = USE_SNAPSHOT;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = USE_SNAPSHOT;
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.mChildren.get(i2)).analyze(i);
        }
    }

    /* JADX WARNING: type inference failed for: r8v17, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.mX
            int r3 = r1.mY
            int r0 = r21.getWidth()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.getHeight()
            int r6 = java.lang.Math.max(r4, r0)
            r1.mWidthMeasuredTooSmall = r4
            r1.mHeightMeasuredTooSmall = r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mParent
            if (r0 == 0) goto L_0x0046
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.mSnapshot
            if (r0 != 0) goto L_0x002a
            androidx.constraintlayout.solver.widgets.Snapshot r0 = new androidx.constraintlayout.solver.widgets.Snapshot
            r0.<init>(r1)
            r1.mSnapshot = r0
        L_0x002a:
            androidx.constraintlayout.solver.widgets.Snapshot r0 = r1.mSnapshot
            r0.updateFrom(r1)
            int r0 = r1.mPaddingLeft
            r1.setX(r0)
            int r0 = r1.mPaddingTop
            r1.setY(r0)
            r21.resetAnchors()
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.solver.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            goto L_0x004a
        L_0x0046:
            r1.mX = r4
            r1.mY = r4
        L_0x004a:
            int r0 = r1.mOptimizationLevel
            r7 = 32
            r8 = 8
            r9 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r1.optimizeFor(r8)
            if (r0 != 0) goto L_0x005c
            r21.optimizeReset()
        L_0x005c:
            boolean r0 = r1.optimizeFor(r7)
            if (r0 != 0) goto L_0x0065
            r21.optimize()
        L_0x0065:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r9
            goto L_0x006e
        L_0x006a:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r4
        L_0x006e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r10 = r0[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r11 = r0[r4]
            r21.resetChains()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0092
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            r0.clear()
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r12 = new androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup
            java.util.ArrayList r13 = r1.mChildren
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x0092:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            int r12 = r0.size()
            java.util.ArrayList r13 = r1.mChildren
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 == r14) goto L_0x00ad
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r21.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r14) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r14 = 0
            goto L_0x00ae
        L_0x00ad:
            r14 = 1
        L_0x00ae:
            r0 = 0
            r15 = 0
        L_0x00b0:
            if (r15 >= r12) goto L_0x02f6
            boolean r8 = r1.mSkipSolver
            if (r8 != 0) goto L_0x02f6
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r8 = r1.mWidgetGroups
            java.lang.Object r8 = r8.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r8
            boolean r8 = r8.mSkipSolver
            if (r8 == 0) goto L_0x00c6
            r19 = r12
            goto L_0x02ea
        L_0x00c6:
            boolean r8 = r1.optimizeFor(r7)
            if (r8 == 0) goto L_0x00fb
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 != r7) goto L_0x00ed
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r21.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 != r8) goto L_0x00ed
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List r7 = r7.getWidgetsToSolve()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.mChildren = r7
            goto L_0x00fb
        L_0x00ed:
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r7 = r1.mWidgetGroups
            java.lang.Object r7 = r7.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r7 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r7
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r7 = r7.mConstrainedGroup
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.mChildren = r7
        L_0x00fb:
            r21.resetChains()
            java.util.ArrayList r7 = r1.mChildren
            int r7 = r7.size()
            r8 = 0
        L_0x0105:
            if (r8 >= r7) goto L_0x011d
            java.util.ArrayList r4 = r1.mChildren
            java.lang.Object r4 = r4.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r4
            boolean r9 = r4 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer
            if (r9 == 0) goto L_0x0118
            androidx.constraintlayout.solver.widgets.WidgetContainer r4 = (androidx.constraintlayout.solver.widgets.WidgetContainer) r4
            r4.layout()
        L_0x0118:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0105
        L_0x011d:
            r4 = r0
            r0 = 0
            r8 = 1
        L_0x0120:
            if (r8 == 0) goto L_0x02d9
            r17 = r4
            r9 = 1
            int r4 = r0 + 1
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0164 }
            r0.reset()     // Catch:{ Exception -> 0x0164 }
            r21.resetChains()     // Catch:{ Exception -> 0x0164 }
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0164 }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x0164 }
            r0 = 0
        L_0x0135:
            if (r0 >= r7) goto L_0x014b
            java.util.ArrayList r9 = r1.mChildren     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Exception -> 0x0164 }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9     // Catch:{ Exception -> 0x0164 }
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem     // Catch:{ Exception -> 0x0160 }
            r9.createObjectVariables(r8)     // Catch:{ Exception -> 0x0160 }
            int r0 = r0 + 1
            r8 = r18
            goto L_0x0135
        L_0x014b:
            r18 = r8
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x0160 }
            boolean r8 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x0160 }
            if (r8 == 0) goto L_0x015d
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x015b }
            r0.minimize()     // Catch:{ Exception -> 0x015b }
            goto L_0x015d
        L_0x015b:
            r0 = move-exception
            goto L_0x0167
        L_0x015d:
            r19 = r12
            goto L_0x0186
        L_0x0160:
            r0 = move-exception
            r8 = r18
            goto L_0x0167
        L_0x0164:
            r0 = move-exception
            r18 = r8
        L_0x0167:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
            r8 = r18
        L_0x0186:
            if (r8 == 0) goto L_0x0191
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem
            boolean[] r9 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r8, r9)
        L_0x018f:
            r9 = 2
            goto L_0x01da
        L_0x0191:
            androidx.constraintlayout.solver.LinearSystem r8 = r1.mSystem
            r1.updateFromSolver(r8)
            r8 = 0
        L_0x0197:
            if (r8 >= r7) goto L_0x018f
            java.util.ArrayList r9 = r1.mChildren
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r9.mListDimensionBehaviors
            r16 = 0
            r12 = r12[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x01bc
            int r0 = r9.getWidth()
            int r12 = r9.getWrapWidth()
            if (r0 >= r12) goto L_0x01bc
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r8 = 2
            r12 = 1
            r0[r8] = r12
            goto L_0x018f
        L_0x01bc:
            r12 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r9.mListDimensionBehaviors
            r0 = r0[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r12) goto L_0x01d6
            int r0 = r9.getHeight()
            int r9 = r9.getWrapHeight()
            if (r0 >= r9) goto L_0x01d6
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r8 = 1
            r9 = 2
            r0[r9] = r8
            goto L_0x01da
        L_0x01d6:
            r9 = 2
            int r8 = r8 + 1
            goto L_0x0197
        L_0x01da:
            if (r14 == 0) goto L_0x0252
            r8 = 8
            if (r4 >= r8) goto L_0x0252
            boolean[] r0 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            boolean r0 = r0[r9]
            if (r0 == 0) goto L_0x0252
            r0 = 0
            r9 = 0
            r12 = 0
        L_0x01e9:
            if (r0 >= r7) goto L_0x0213
            java.util.ArrayList r8 = r1.mChildren
            java.lang.Object r8 = r8.get(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r8
            r18 = r4
            int r4 = r8.mX
            int r20 = r8.getWidth()
            int r4 = r4 + r20
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r8.mY
            int r8 = r8.getHeight()
            int r4 = r4 + r8
            int r12 = java.lang.Math.max(r12, r4)
            int r0 = r0 + 1
            r4 = r18
            r8 = 8
            goto L_0x01e9
        L_0x0213:
            r18 = r4
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r9)
            int r4 = r1.mMinHeight
            int r4 = java.lang.Math.max(r4, r12)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r8) goto L_0x0239
            int r8 = r21.getWidth()
            if (r8 >= r0) goto L_0x0239
            r1.setWidth(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r17 = 1
            goto L_0x023a
        L_0x0239:
            r0 = 0
        L_0x023a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r8) goto L_0x0255
            int r8 = r21.getHeight()
            if (r8 >= r4) goto L_0x0255
            r1.setHeight(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r17 = 1
            goto L_0x0255
        L_0x0252:
            r18 = r4
            r0 = 0
        L_0x0255:
            int r4 = r1.mMinWidth
            int r8 = r21.getWidth()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.getWidth()
            if (r4 <= r8) goto L_0x0272
            r1.setWidth(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 0
            r0[r8] = r4
            r0 = 1
            r17 = 1
        L_0x0272:
            int r4 = r1.mMinHeight
            int r8 = r21.getHeight()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.getHeight()
            if (r4 <= r8) goto L_0x028f
            r1.setHeight(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x0292
        L_0x028f:
            r8 = 1
            r9 = r17
        L_0x0292:
            if (r9 != 0) goto L_0x02d1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r12 = 0
            r4 = r4[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r12) goto L_0x02b3
            if (r5 <= 0) goto L_0x02b3
            int r4 = r21.getWidth()
            if (r4 <= r5) goto L_0x02b3
            r1.mWidthMeasuredTooSmall = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = 0
            r0[r9] = r4
            r1.setWidth(r5)
            r0 = 1
            r9 = 1
        L_0x02b3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.mListDimensionBehaviors
            r4 = r4[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r12) goto L_0x02d1
            if (r6 <= 0) goto L_0x02d1
            int r4 = r21.getHeight()
            if (r4 <= r6) goto L_0x02d1
            r1.mHeightMeasuredTooSmall = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r4
            r1.setHeight(r6)
            r4 = 1
            r8 = 1
            goto L_0x02d3
        L_0x02d1:
            r8 = r0
            r4 = r9
        L_0x02d3:
            r0 = r18
            r12 = r19
            goto L_0x0120
        L_0x02d9:
            r17 = r4
            r19 = r12
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r0 = r1.mWidgetGroups
            java.lang.Object r0 = r0.get(r15)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r0 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup) r0
            r0.updateUnresolvedWidgets()
            r0 = r17
        L_0x02ea:
            int r15 = r15 + 1
            r12 = r19
            r4 = 0
            r7 = 32
            r8 = 8
            r9 = 1
            goto L_0x00b0
        L_0x02f6:
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            r1.mChildren = r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mParent
            if (r4 == 0) goto L_0x032a
            int r2 = r1.mMinWidth
            int r3 = r21.getWidth()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.mMinHeight
            int r4 = r21.getHeight()
            int r3 = java.lang.Math.max(r3, r4)
            androidx.constraintlayout.solver.widgets.Snapshot r4 = r1.mSnapshot
            r4.applyTo(r1)
            int r4 = r1.mPaddingLeft
            int r2 = r2 + r4
            int r4 = r1.mPaddingRight
            int r2 = r2 + r4
            r1.setWidth(r2)
            int r2 = r1.mPaddingTop
            int r3 = r3 + r2
            int r2 = r1.mPaddingBottom
            int r3 = r3 + r2
            r1.setHeight(r3)
            goto L_0x032e
        L_0x032a:
            r1.mX = r2
            r1.mY = r3
        L_0x032e:
            if (r0 == 0) goto L_0x033a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r2 = 0
            r0[r2] = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.mListDimensionBehaviors
            r2 = 1
            r0[r2] = r10
        L_0x033a:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            androidx.constraintlayout.solver.Cache r0 = r0.getCache()
            r1.resetSolverVariables(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r0 = r21.getRootConstraintContainer()
            if (r1 != r0) goto L_0x034c
            r21.updateDrawPosition()
        L_0x034c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void optimizeForDimensions(int i, int i2) {
        if (!(this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }
}
