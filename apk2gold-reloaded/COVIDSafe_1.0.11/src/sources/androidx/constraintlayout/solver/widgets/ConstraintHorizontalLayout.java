package androidx.constraintlayout.solver.widgets;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment = ContentAlignment.MIDDLE;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public ConstraintHorizontalLayout() {
    }

    public ConstraintHorizontalLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public ConstraintHorizontalLayout(int i, int i2) {
        super(i, i2);
    }

    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r10) {
        /*
            r9 = this;
            java.util.ArrayList r0 = r9.mChildren
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0069
            r0 = 0
            java.util.ArrayList r1 = r9.mChildren
            int r1 = r1.size()
            r4 = r9
        L_0x0010:
            if (r0 >= r1) goto L_0x0052
            java.util.ArrayList r2 = r9.mChildren
            java.lang.Object r2 = r2.get(r0)
            r8 = r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r8
            if (r4 == r9) goto L_0x002c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r8.connect(r2, r4, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r4.connect(r2, r8, r3)
            goto L_0x0040
        L_0x002c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r3 = r9.mAlignment
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r5 = androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.ContentAlignment.END
            if (r3 != r5) goto L_0x0036
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
        L_0x0036:
            r7 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r6 = 0
            r2 = r8
            r2.connect(r3, r4, r5, r6, r7)
        L_0x0040:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            r8.connect(r2, r9, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r8.connect(r2, r9, r3)
            int r0 = r0 + 1
            r4 = r8
            goto L_0x0010
        L_0x0052:
            if (r4 == r9) goto L_0x0069
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.STRONG
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r1 = r9.mAlignment
            androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout$ContentAlignment r2 = androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.ContentAlignment.BEGIN
            if (r1 != r2) goto L_0x005e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Strength r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Strength.WEAK
        L_0x005e:
            r7 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r6 = 0
            r2 = r4
            r4 = r9
            r2.connect(r3, r4, r5, r6, r7)
        L_0x0069:
            super.addToSolver(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }
}
