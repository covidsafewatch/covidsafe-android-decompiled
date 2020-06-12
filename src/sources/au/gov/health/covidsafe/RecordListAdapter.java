package au.gov.health.covidsafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.view.StreetPassRecordViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J\u0016\u0010\u0019\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u001b\u0010\u001a\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0000¢\u0006\u0002\b\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lau/gov/health/covidsafe/RecordListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "inflater", "Landroid/view/LayoutInflater;", "records", "", "Lau/gov/health/covidsafe/streetpass/view/StreetPassRecordViewModel;", "sourceData", "Lau/gov/health/covidsafe/streetpass/persistence/StreetPassRecord;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "prepareViewData", "words", "setRecords", "setSourceData", "setSourceData$app_release", "RecordViewHolder", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: RecordListAdapter.kt */
public final class RecordListAdapter extends RecyclerView.Adapter<RecordViewHolder> {
    private final LayoutInflater inflater;
    private List<StreetPassRecordViewModel> records = CollectionsKt.emptyList();
    private List<StreetPassRecord> sourceData = CollectionsKt.emptyList();

    public RecordListAdapter(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.inflater = from;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lau/gov/health/covidsafe/RecordListAdapter$RecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lau/gov/health/covidsafe/RecordListAdapter;Landroid/view/View;)V", "filterModelC", "getFilterModelC", "()Landroid/view/View;", "filterModelP", "getFilterModelP", "findsView", "Landroid/widget/TextView;", "getFindsView", "()Landroid/widget/TextView;", "modelCView", "getModelCView", "modelPView", "getModelPView", "msgView", "getMsgView", "org", "getOrg", "signalStrengthView", "getSignalStrengthView", "timestampView", "getTimestampView", "txpowerView", "getTxpowerView", "version", "getVersion", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: RecordListAdapter.kt */
    public final class RecordViewHolder extends RecyclerView.ViewHolder {
        private final View filterModelC;
        private final View filterModelP;
        private final TextView findsView;
        private final TextView modelCView;
        private final TextView modelPView;
        private final TextView msgView;

        /* renamed from: org  reason: collision with root package name */
        private final TextView f4org;
        private final TextView signalStrengthView;
        final /* synthetic */ RecordListAdapter this$0;
        private final TextView timestampView;
        private final TextView txpowerView;
        private final TextView version;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecordViewHolder(RecordListAdapter recordListAdapter, View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = recordListAdapter;
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

    public RecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = this.inflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        return new RecordViewHolder(this, inflate);
    }

    public void onBindViewHolder(RecordViewHolder recordViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(recordViewHolder, "holder");
        StreetPassRecordViewModel streetPassRecordViewModel = this.records.get(i);
        recordViewHolder.getMsgView().setText(streetPassRecordViewModel.getMsg());
        recordViewHolder.getModelCView().setText(streetPassRecordViewModel.getModelC());
        recordViewHolder.getModelPView().setText(streetPassRecordViewModel.getModelP());
        TextView findsView = recordViewHolder.getFindsView();
        findsView.setText("Detections: " + streetPassRecordViewModel.getNumber());
        recordViewHolder.getTimestampView().setText(Utils.INSTANCE.getDate(streetPassRecordViewModel.getTimeStamp()));
        TextView version = recordViewHolder.getVersion();
        version.setText("v: " + streetPassRecordViewModel.getVersion());
        TextView org2 = recordViewHolder.getOrg();
        org2.setText("ORG: " + streetPassRecordViewModel.getOrg());
        recordViewHolder.getFilterModelP().setTag(streetPassRecordViewModel);
        recordViewHolder.getFilterModelC().setTag(streetPassRecordViewModel);
        TextView signalStrengthView = recordViewHolder.getSignalStrengthView();
        signalStrengthView.setText("Signal Strength: " + streetPassRecordViewModel.getRssi());
        TextView txpowerView = recordViewHolder.getTxpowerView();
        txpowerView.setText("Tx Power: " + streetPassRecordViewModel.getTransmissionPower());
    }

    private final void setRecords(List<StreetPassRecordViewModel> list) {
        this.records = list;
        notifyDataSetChanged();
    }

    public final void setSourceData$app_release(List<StreetPassRecord> list) {
        Intrinsics.checkParameterIsNotNull(list, "records");
        this.sourceData = list;
        setRecords(prepareViewData(list));
    }

    private final List<StreetPassRecordViewModel> prepareViewData(List<StreetPassRecord> list) {
        Iterable<StreetPassRecord> reversed = CollectionsKt.reversed(list);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reversed, 10));
        for (StreetPassRecord streetPassRecordViewModel : reversed) {
            arrayList.add(new StreetPassRecordViewModel(streetPassRecordViewModel));
        }
        return (List) arrayList;
    }

    public int getItemCount() {
        return this.records.size();
    }
}
