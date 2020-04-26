package au.gov.health.covidsafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002%&B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0002J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\"\u001a\u00020\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001b\u0010#\u001a\u00020\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0000¢\u0006\u0002\b$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lau/gov/health/covidsafe/RecordListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "inflater", "Landroid/view/LayoutInflater;", "mode", "Lau/gov/health/covidsafe/RecordListAdapter$MODE;", "records", "", "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;", "sourceData", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "filter", "sample", "filterByModelC", "model", "words", "filterByModelP", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "prepareCollapsedData", "prepareViewData", "setMode", "setRecords", "setSourceData", "setSourceData$app_release", "MODE", "RecordViewHolder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RecordListAdapter.kt */
public final class RecordListAdapter extends Adapter<RecordViewHolder> {
    private final LayoutInflater inflater;
    private MODE mode = MODE.ALL;
    private List<StreetPassRecordViewModel> records = CollectionsKt.emptyList();
    private List<StreetPassRecord> sourceData = CollectionsKt.emptyList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/RecordListAdapter$MODE;", "", "(Ljava/lang/String;I)V", "ALL", "COLLAPSE", "MODEL_P", "MODEL_C", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RecordListAdapter.kt */
    public enum MODE {
        ALL,
        COLLAPSE,
        MODEL_P,
        MODEL_C
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lau/gov/health/covidsafe/RecordListAdapter;Landroid/view/View;)V", "filterModelC", "getFilterModelC", "()Landroid/view/View;", "filterModelP", "getFilterModelP", "findsView", "Landroid/widget/TextView;", "getFindsView", "()Landroid/widget/TextView;", "modelCView", "getModelCView", "modelPView", "getModelPView", "msgView", "getMsgView", "org", "getOrg", "signalStrengthView", "getSignalStrengthView", "timestampView", "getTimestampView", "txpowerView", "getTxpowerView", "version", "getVersion", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RecordListAdapter.kt */
    public final class RecordViewHolder extends ViewHolder {
        private final View filterModelC;
        private final View filterModelP;
        private final TextView findsView;
        private final TextView modelCView;
        private final TextView modelPView;
        private final TextView msgView;

        /* renamed from: org reason: collision with root package name */
        private final TextView f4org;
        private final TextView signalStrengthView;
        final /* synthetic */ RecordListAdapter this$0;
        private final TextView timestampView;
        private final TextView txpowerView;
        private final TextView version;

        public RecordViewHolder(RecordListAdapter recordListAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = recordListAdapter;
            super(view);
            View findViewById = view.findViewById(R.id.modelc);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.modelc)");
            this.modelCView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.modelp);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.modelp)");
            this.modelPView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.timestamp);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.timestamp)");
            this.timestampView = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.finds);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.finds)");
            this.findsView = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.txpower);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.txpower)");
            this.txpowerView = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.signal_strength);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.signal_strength)");
            this.signalStrengthView = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.filter_by_modelp);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.filter_by_modelp)");
            this.filterModelP = findViewById7;
            View findViewById8 = view.findViewById(R.id.filter_by_modelc);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.filter_by_modelc)");
            this.filterModelC = findViewById8;
            View findViewById9 = view.findViewById(R.id.msg);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "itemView.findViewById(R.id.msg)");
            this.msgView = (TextView) findViewById9;
            View findViewById10 = view.findViewById(R.id.version);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "itemView.findViewById(R.id.version)");
            this.version = (TextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.f3org);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "itemView.findViewById(R.id.org)");
            this.f4org = (TextView) findViewById11;
        }

        public final TextView getModelCView() {
            return this.modelCView;
        }

        public final TextView getModelPView() {
            return this.modelPView;
        }

        public final TextView getTimestampView() {
            return this.timestampView;
        }

        public final TextView getFindsView() {
            return this.findsView;
        }

        public final TextView getTxpowerView() {
            return this.txpowerView;
        }

        public final TextView getSignalStrengthView() {
            return this.signalStrengthView;
        }

        public final View getFilterModelP() {
            return this.filterModelP;
        }

        public final View getFilterModelC() {
            return this.filterModelC;
        }

        public final TextView getMsgView() {
            return this.msgView;
        }

        public final TextView getVersion() {
            return this.version;
        }

        public final TextView getOrg() {
            return this.f4org;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MODE.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MODE.COLLAPSE.ordinal()] = 1;
            $EnumSwitchMapping$0[MODE.ALL.ordinal()] = 2;
            $EnumSwitchMapping$0[MODE.MODEL_P.ordinal()] = 3;
            $EnumSwitchMapping$0[MODE.MODEL_C.ordinal()] = 4;
        }
    }

    public RecordListAdapter(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.inflater = from;
    }

    public RecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = this.inflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        return new RecordViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecordViewHolder recordViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(recordViewHolder, "holder");
        StreetPassRecordViewModel streetPassRecordViewModel = (StreetPassRecordViewModel) this.records.get(i);
        recordViewHolder.getMsgView().setText(streetPassRecordViewModel.getMsg());
        recordViewHolder.getModelCView().setText(streetPassRecordViewModel.getModelC());
        recordViewHolder.getModelPView().setText(streetPassRecordViewModel.getModelP());
        TextView findsView = recordViewHolder.getFindsView();
        StringBuilder sb = new StringBuilder();
        sb.append("Detections: ");
        sb.append(streetPassRecordViewModel.getNumber());
        findsView.setText(sb.toString());
        recordViewHolder.getTimestampView().setText(Utils.INSTANCE.getDate(streetPassRecordViewModel.getTimeStamp()));
        TextView version = recordViewHolder.getVersion();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("v: ");
        sb2.append(streetPassRecordViewModel.getVersion());
        version.setText(sb2.toString());
        TextView org2 = recordViewHolder.getOrg();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ORG: ");
        sb3.append(streetPassRecordViewModel.getOrg());
        org2.setText(sb3.toString());
        recordViewHolder.getFilterModelP().setTag(streetPassRecordViewModel);
        recordViewHolder.getFilterModelC().setTag(streetPassRecordViewModel);
        TextView signalStrengthView = recordViewHolder.getSignalStrengthView();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Signal Strength: ");
        sb4.append(streetPassRecordViewModel.getRssi());
        signalStrengthView.setText(sb4.toString());
        TextView txpowerView = recordViewHolder.getTxpowerView();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Tx Power: ");
        sb5.append(streetPassRecordViewModel.getTransmissionPower());
        txpowerView.setText(sb5.toString());
        recordViewHolder.getFilterModelP().setOnClickListener(new RecordListAdapter$onBindViewHolder$1(this));
        recordViewHolder.getFilterModelC().setOnClickListener(new RecordListAdapter$onBindViewHolder$2(this));
    }

    private final List<StreetPassRecordViewModel> filter(StreetPassRecordViewModel streetPassRecordViewModel) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1) {
            return prepareCollapsedData(this.sourceData);
        }
        if (i == 2) {
            return prepareViewData(this.sourceData);
        }
        if (i == 3) {
            return filterByModelP(streetPassRecordViewModel, this.sourceData);
        }
        if (i != 4) {
            return prepareViewData(this.sourceData);
        }
        return filterByModelC(streetPassRecordViewModel, this.sourceData);
    }

    private final List<StreetPassRecordViewModel> filterByModelC(StreetPassRecordViewModel streetPassRecordViewModel, List<StreetPassRecord> list) {
        if (streetPassRecordViewModel == null) {
            return prepareViewData(list);
        }
        Iterable iterable = list;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (Intrinsics.areEqual((Object) ((StreetPassRecord) next).getModelC(), (Object) streetPassRecordViewModel.getModelC())) {
                arrayList.add(next);
            }
        }
        return prepareViewData((List) arrayList);
    }

    private final List<StreetPassRecordViewModel> filterByModelP(StreetPassRecordViewModel streetPassRecordViewModel, List<StreetPassRecord> list) {
        if (streetPassRecordViewModel == null) {
            return prepareViewData(list);
        }
        Iterable iterable = list;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (Intrinsics.areEqual((Object) ((StreetPassRecord) next).getModelP(), (Object) streetPassRecordViewModel.getModelP())) {
                arrayList.add(next);
            }
        }
        return prepareViewData((List) arrayList);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.Object, au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord, ?[OBJECT, ARRAY]]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord, ?[OBJECT, ARRAY]]
      mth insns count: 84
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel> prepareCollapsedData(java.util.List<au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord> r13) {
        /*
            r12 = this;
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            java.util.Iterator r1 = r13.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r1.next()
            r3 = r2
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r3 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r3
            java.lang.String r3 = r3.getModelC()
            java.lang.Object r4 = r0.get(r3)
            if (r4 != 0) goto L_0x002c
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0.put(r3, r4)
        L_0x002c:
            java.util.List r4 = (java.util.List) r4
            r4.add(r2)
            goto L_0x000d
        L_0x0032:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x0040:
            boolean r3 = r13.hasNext()
            if (r3 == 0) goto L_0x005b
            java.lang.Object r3 = r13.next()
            r4 = r3
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r4 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r4
            java.lang.String r4 = r4.getModelC()
            boolean r4 = r1.add(r4)
            if (r4 == 0) goto L_0x0040
            r2.add(r3)
            goto L_0x0040
        L_0x005b:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r13 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r1)
            r13.<init>(r1)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r1 = r2.iterator()
        L_0x0070:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00f9
            java.lang.Object r2 = r1.next()
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r2 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r2
            java.lang.String r3 = r2.getModelC()
            java.lang.Object r3 = r0.get(r3)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            if (r3 == 0) goto L_0x0092
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0093
        L_0x0092:
            r3 = r4
        L_0x0093:
            if (r3 == 0) goto L_0x00ee
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.lang.String r5 = r2.getModelC()
            java.lang.Object r5 = r0.get(r5)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x00df
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x00b4
            goto L_0x00dd
        L_0x00b4:
            java.lang.Object r4 = r5.next()
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x00bf
            goto L_0x00dd
        L_0x00bf:
            r6 = r4
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r6 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r6
            long r6 = r6.getTimestamp()
        L_0x00c6:
            java.lang.Object r8 = r5.next()
            r9 = r8
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r9 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r9
            long r9 = r9.getTimestamp()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x00d7
            r4 = r8
            r6 = r9
        L_0x00d7:
            boolean r8 = r5.hasNext()
            if (r8 != 0) goto L_0x00c6
        L_0x00dd:
            au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord r4 = (au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord) r4
        L_0x00df:
            if (r4 == 0) goto L_0x00e7
            au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel r2 = new au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel
            r2.<init>(r4, r3)
            goto L_0x00f4
        L_0x00e7:
            au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel r4 = new au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel
            r4.<init>(r2, r3)
            r2 = r4
            goto L_0x00f4
        L_0x00ee:
            au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel r3 = new au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel
            r3.<init>(r2)
            r2 = r3
        L_0x00f4:
            r13.add(r2)
            goto L_0x0070
        L_0x00f9:
            java.util.List r13 = (java.util.List) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.RecordListAdapter.prepareCollapsedData(java.util.List):java.util.List");
    }

    private final List<StreetPassRecordViewModel> prepareViewData(List<StreetPassRecord> list) {
        Iterable<StreetPassRecord> reversed = CollectionsKt.reversed(list);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reversed, 10));
        for (StreetPassRecord streetPassRecordViewModel : reversed) {
            arrayList.add(new StreetPassRecordViewModel(streetPassRecordViewModel));
        }
        return (List) arrayList;
    }

    public final void setMode(MODE mode2) {
        Intrinsics.checkParameterIsNotNull(mode2, "mode");
        setMode(mode2, null);
    }

    /* access modifiers changed from: private */
    public final void setMode(MODE mode2, StreetPassRecordViewModel streetPassRecordViewModel) {
        this.mode = mode2;
        setRecords(filter(streetPassRecordViewModel));
    }

    private final void setRecords(List<StreetPassRecordViewModel> list) {
        this.records = list;
        notifyDataSetChanged();
    }

    public final void setSourceData$app_release(List<StreetPassRecord> list) {
        Intrinsics.checkParameterIsNotNull(list, "records");
        this.sourceData = list;
        setMode(this.mode);
    }

    public int getItemCount() {
        return this.records.size();
    }
}
