package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import java.util.ArrayList;

public class Snapshot {
    private ArrayList<Connection> mConnections = new ArrayList<>();
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    static class Connection {
        private ConstraintAnchor mAnchor;
        private int mCreator;
        private int mMargin;
        private ConstraintAnchor.Strength mStrengh;
        private ConstraintAnchor mTarget;

        public Connection(ConstraintAnchor constraintAnchor) {
            this.mAnchor = constraintAnchor;
            this.mTarget = constraintAnchor.getTarget();
            this.mMargin = constraintAnchor.getMargin();
            this.mStrengh = constraintAnchor.getStrength();
            this.mCreator = constraintAnchor.getConnectionCreator();
        }

        public void updateFrom(ConstraintWidget constraintWidget) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(this.mAnchor.getType());
            this.mAnchor = anchor;
            if (anchor != null) {
                this.mTarget = anchor.getTarget();
                this.mMargin = this.mAnchor.getMargin();
                this.mStrengh = this.mAnchor.getStrength();
                this.mCreator = this.mAnchor.getConnectionCreator();
                return;
            }
            this.mTarget = null;
            this.mMargin = 0;
            this.mStrengh = ConstraintAnchor.Strength.STRONG;
            this.mCreator = 0;
        }

        public void applyTo(ConstraintWidget constraintWidget) {
            constraintWidget.getAnchor(this.mAnchor.getType()).connect(this.mTarget, this.mMargin, this.mStrengh, this.mCreator);
        }
    }

    public Snapshot(ConstraintWidget constraintWidget) {
        this.mX = constraintWidget.getX();
        this.mY = constraintWidget.getY();
        this.mWidth = constraintWidget.getWidth();
        this.mHeight = constraintWidget.getHeight();
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            this.mConnections.add(new Connection(anchors.get(i)));
        }
    }

    public void updateFrom(ConstraintWidget constraintWidget) {
        this.mX = constraintWidget.getX();
        this.mY = constraintWidget.getY();
        this.mWidth = constraintWidget.getWidth();
        this.mHeight = constraintWidget.getHeight();
        int size = this.mConnections.size();
        for (int i = 0; i < size; i++) {
            this.mConnections.get(i).updateFrom(constraintWidget);
        }
    }

    public void applyTo(ConstraintWidget constraintWidget) {
        constraintWidget.setX(this.mX);
        constraintWidget.setY(this.mY);
        constraintWidget.setWidth(this.mWidth);
        constraintWidget.setHeight(this.mHeight);
        int size = this.mConnections.size();
        for (int i = 0; i < size; i++) {
            this.mConnections.get(i).applyTo(constraintWidget);
        }
    }
}
