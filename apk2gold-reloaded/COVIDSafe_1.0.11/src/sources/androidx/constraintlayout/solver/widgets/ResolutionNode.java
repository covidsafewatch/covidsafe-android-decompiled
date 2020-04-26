package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode {
    public static final int REMOVED = 2;
    public static final int RESOLVED = 1;
    public static final int UNRESOLVED = 0;
    HashSet<ResolutionNode> dependents = new HashSet<>(2);
    int state = 0;

    public void remove(ResolutionDimension resolutionDimension) {
    }

    public void resolve() {
    }

    public void addDependent(ResolutionNode resolutionNode) {
        this.dependents.add(resolutionNode);
    }

    public void reset() {
        this.state = 0;
        this.dependents.clear();
    }

    public void invalidate() {
        this.state = 0;
        Iterator it = this.dependents.iterator();
        while (it.hasNext()) {
            ((ResolutionNode) it.next()).invalidate();
        }
    }

    public void invalidateAnchors() {
        if (this instanceof ResolutionAnchor) {
            this.state = 0;
        }
        Iterator it = this.dependents.iterator();
        while (it.hasNext()) {
            ((ResolutionNode) it.next()).invalidateAnchors();
        }
    }

    public void didResolve() {
        this.state = 1;
        Iterator it = this.dependents.iterator();
        while (it.hasNext()) {
            ((ResolutionNode) it.next()).resolve();
        }
    }

    public boolean isResolved() {
        return this.state == 1;
    }
}
