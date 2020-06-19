package au.gov.health.covidsafe.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.home.view.PermissionStatusCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"au/gov/health/covidsafe/ui/home/HomeFragment$mBroadcastListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HomeFragment.kt */
public final class HomeFragment$mBroadcastListener$1 extends BroadcastReceiver {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$mBroadcastListener$1(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.bluetooth.adapter.action.STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            if (intExtra == 10) {
                PermissionStatusCard.render$default((PermissionStatusCard) this.this$0._$_findCachedViewById(R.id.bluetooth_card_view), this.this$0.formatBlueToothTitle(false), false, (String) null, 4, (Object) null);
                this.this$0.refreshSetupCompleteOrIncompleteUi();
            } else if (intExtra == 12) {
                PermissionStatusCard.render$default((PermissionStatusCard) this.this$0._$_findCachedViewById(R.id.bluetooth_card_view), this.this$0.formatBlueToothTitle(true), true, (String) null, 4, (Object) null);
                this.this$0.refreshSetupCompleteOrIncompleteUi();
            } else if (intExtra == 13) {
                PermissionStatusCard.render$default((PermissionStatusCard) this.this$0._$_findCachedViewById(R.id.bluetooth_card_view), this.this$0.formatBlueToothTitle(false), false, (String) null, 4, (Object) null);
                this.this$0.refreshSetupCompleteOrIncompleteUi();
            }
        }
    }
}
