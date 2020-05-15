package androidx.constraintlayout.solver;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.util.ArrayList;

public class Metrics {
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long iterations;
    public long lastTableSize;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measures;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts = new ArrayList<>();
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;

    public String toString() {
        return "\n*** Metrics ***\nmeasures: " + this.measures + "\nadditionalMeasures: " + this.additionalMeasures + "\nresolutions passes: " + this.resolutions + "\ntable increases: " + this.tableSizeIncrease + "\nmaxTableSize: " + this.maxTableSize + "\nmaxVariables: " + this.maxVariables + "\nmaxRows: " + this.maxRows + "\n\nminimize: " + this.minimize + "\nminimizeGoal: " + this.minimizeGoal + "\nconstraints: " + this.constraints + "\nsimpleconstraints: " + this.simpleconstraints + "\noptimize: " + this.optimize + "\niterations: " + this.iterations + "\npivots: " + this.pivots + "\nbfs: " + this.bfs + "\nvariables: " + this.variables + "\nerrors: " + this.errors + "\nslackvariables: " + this.slackvariables + "\nextravariables: " + this.extravariables + "\nfullySolved: " + this.fullySolved + "\ngraphOptimizer: " + this.graphOptimizer + "\nresolvedWidgets: " + this.resolvedWidgets + "\noldresolvedWidgets: " + this.oldresolvedWidgets + "\nnonresolvedWidgets: " + this.nonresolvedWidgets + "\ncenterConnectionResolved: " + this.centerConnectionResolved + "\nmatchConnectionResolved: " + this.matchConnectionResolved + "\nchainConnectionResolved: " + this.chainConnectionResolved + "\nbarrierConnectionResolved: " + this.barrierConnectionResolved + "\nproblematicsLayouts: " + this.problematicLayouts + StringUtils.EOL;
    }

    public void reset() {
        this.measures = 0;
        this.additionalMeasures = 0;
        this.resolutions = 0;
        this.tableSizeIncrease = 0;
        this.maxTableSize = 0;
        this.lastTableSize = 0;
        this.maxVariables = 0;
        this.maxRows = 0;
        this.minimize = 0;
        this.minimizeGoal = 0;
        this.constraints = 0;
        this.simpleconstraints = 0;
        this.optimize = 0;
        this.iterations = 0;
        this.pivots = 0;
        this.bfs = 0;
        this.variables = 0;
        this.errors = 0;
        this.slackvariables = 0;
        this.extravariables = 0;
        this.fullySolved = 0;
        this.graphOptimizer = 0;
        this.resolvedWidgets = 0;
        this.oldresolvedWidgets = 0;
        this.nonresolvedWidgets = 0;
        this.centerConnectionResolved = 0;
        this.matchConnectionResolved = 0;
        this.chainConnectionResolved = 0;
        this.barrierConnectionResolved = 0;
        this.problematicLayouts.clear();
    }
}
