package au.gov.health.covidsafe;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.streetpass.view.RecordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/PeekActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "timePeriod", "", "viewModel", "Lau/gov/health/covidsafe/streetpass/view/RecordViewModel;", "newPeek", "", "nextTimePeriod", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startService", "stopService", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PeekActivity.kt */
public final class PeekActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private int timePeriod;
    /* access modifiers changed from: private */
    public RecordViewModel viewModel;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ RecordViewModel access$getViewModel$p(PeekActivity peekActivity) {
        RecordViewModel recordViewModel = peekActivity.viewModel;
        if (recordViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return recordViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        newPeek();
    }

    private final void newPeek() {
        setContentView((int) R.layout.database_peek);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Context context = this;
        RecordListAdapter recordListAdapter = new RecordListAdapter(context);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        recyclerView.setAdapter(recordListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation()));
        ViewModel viewModel2 = new ViewModelProvider(this).get(RecordViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProvider(this).…ordViewModel::class.java)");
        RecordViewModel recordViewModel = (RecordViewModel) viewModel2;
        this.viewModel = recordViewModel;
        if (recordViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        recordViewModel.getAllRecords().observe(this, new PeekActivity$newPeek$1(recordListAdapter));
        ((FloatingActionButton) findViewById(R.id.expand)).setOnClickListener(new PeekActivity$newPeek$2(this, recordListAdapter));
        ((FloatingActionButton) findViewById(R.id.collapse)).setOnClickListener(new PeekActivity$newPeek$3(this, recordListAdapter));
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.start);
        floatingActionButton.setOnClickListener(new PeekActivity$newPeek$4(this));
        FloatingActionButton floatingActionButton2 = (FloatingActionButton) findViewById(R.id.stop);
        floatingActionButton2.setOnClickListener(new PeekActivity$newPeek$5(this));
        FloatingActionButton floatingActionButton3 = (FloatingActionButton) findViewById(R.id.delete);
        floatingActionButton3.setOnClickListener(new PeekActivity$newPeek$6(this));
        ((FloatingActionButton) findViewById(R.id.plot)).setOnClickListener(new PeekActivity$newPeek$7(this));
        Intrinsics.checkExpressionValueIsNotNull(floatingActionButton, "start");
        floatingActionButton.setVisibility(8);
        Intrinsics.checkExpressionValueIsNotNull(floatingActionButton2, "stop");
        floatingActionButton2.setVisibility(8);
        Intrinsics.checkExpressionValueIsNotNull(floatingActionButton3, "delete");
        floatingActionButton3.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final int nextTimePeriod() {
        int i = this.timePeriod;
        int i2 = 12;
        if (i == 1) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 6;
        } else if (i != 6) {
            i2 = i != 12 ? 1 : 24;
        }
        this.timePeriod = i2;
        return i2;
    }

    /* access modifiers changed from: private */
    public final void startService() {
        Utils.INSTANCE.startBluetoothMonitoringService(this);
    }

    /* access modifiers changed from: private */
    public final void stopService() {
        Utils.INSTANCE.stopBluetoothMonitoringService(this);
    }
}
