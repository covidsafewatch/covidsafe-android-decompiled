package au.gov.health.covidsafe.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.BuildConfig;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.extensions.PermissionExtensionsKt;
import au.gov.health.covidsafe.extensions.ViewExtensionsKt;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.home.view.ExternalLinkCard;
import au.gov.health.covidsafe.ui.home.view.PermissionStatusCard;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u001e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%H\u0016J\u001e\u0010&\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%H\u0016J-\u0010'\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00052\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0)2\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\u0015H\u0016J\u001a\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0002J\b\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0015H\u0002J\b\u00107\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lau/gov/health/covidsafe/ui/home/HomeFragment;", "Lau/gov/health/covidsafe/ui/BaseFragment;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "()V", "counter", "", "mBroadcastListener", "Landroid/content/BroadcastReceiver;", "mIsBroadcastListenerRegistered", "", "presenter", "Lau/gov/health/covidsafe/ui/home/HomePresenter;", "allPermissionsEnabled", "formatBlueToothTitle", "", "on", "formatLocationTitle", "formatNonBatteryOptimizationTitle", "formatPushNotificationTitle", "getPermissionEnabledTitle", "goToCovidApp", "", "goToNewsWebsite", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "onPermissionsDenied", "requestCode", "perms", "", "onPermissionsGranted", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "refreshActionCards", "refreshSetupCompleteOrIncompleteUi", "refreshUploadedCard", "registerBroadcast", "shareThisApp", "updateBatteryOptimizationStatus", "updateBlueToothStatus", "updateLocationStatus", "updatePushNotificationStatus", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HomeFragment.kt */
public final class HomeFragment extends BaseFragment implements EasyPermissions.PermissionCallbacks {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int counter;
    private final BroadcastReceiver mBroadcastListener = new HomeFragment$mBroadcastListener$1(this);
    private boolean mIsBroadcastListenerRegistered;
    private HomePresenter presenter;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.presenter = new HomePresenter(this);
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.home_header_help)).setOnClickListener(new HomeFragment$onViewCreated$1(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.home_version_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "home_version_number");
        textView.setText(getString(R.string.home_version_number, BuildConfig.VERSION_NAME));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.home_header_label_setup_complete_disclaimer_content);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "home_header_label_setup_…mplete_disclaimer_content");
        ViewExtensionsKt.toHyperlink(textView2, "FAQ", new HomeFragment$onViewCreated$3(this));
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.home_header_label_setup_complete_disclaimer_content);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "home_header_label_setup_…mplete_disclaimer_content");
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onResume() {
        super.onResume();
        ((PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view)).setOnClickListener(new HomeFragment$onResume$1(this));
        ((PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view)).setOnClickListener(new HomeFragment$onResume$2(this));
        ((PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view)).setOnClickListener(new HomeFragment$onResume$3(this));
        ((Button) _$_findCachedViewById(R.id.home_been_tested_button)).setOnClickListener(new HomeFragment$onResume$4(this));
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_share)).setOnClickListener(new HomeFragment$onResume$5(this));
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_news)).setOnClickListener(new HomeFragment$onResume$6(this));
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_app)).setOnClickListener(new HomeFragment$onResume$7(this));
        if (!this.mIsBroadcastListenerRegistered) {
            registerBroadcast();
        }
        refreshSetupCompleteOrIncompleteUi();
    }

    public void onPause() {
        super.onPause();
        ((PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view)).setOnClickListener((View.OnClickListener) null);
        ((PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view)).setOnClickListener((View.OnClickListener) null);
        ((PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view)).setOnClickListener((View.OnClickListener) null);
        ((Button) _$_findCachedViewById(R.id.home_been_tested_button)).setOnClickListener((View.OnClickListener) null);
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_share)).setOnClickListener((View.OnClickListener) null);
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_news)).setOnClickListener((View.OnClickListener) null);
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_setup_complete_app)).setOnClickListener((View.OnClickListener) null);
        FragmentActivity activity = getActivity();
        if (activity != null && this.mIsBroadcastListenerRegistered) {
            activity.unregisterReceiver(this.mBroadcastListener);
            this.mIsBroadcastListenerRegistered = false;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((ScrollView) _$_findCachedViewById(R.id.home_root)).removeAllViews();
        _$_clearFindViewByIdCache();
    }

    /* access modifiers changed from: private */
    public final void refreshSetupCompleteOrIncompleteUi() {
        if (allPermissionsEnabled()) {
            Group group = (Group) _$_findCachedViewById(R.id.header_setup_complete);
            Intrinsics.checkExpressionValueIsNotNull(group, "header_setup_complete");
            group.setVisibility(0);
            Group group2 = (Group) _$_findCachedViewById(R.id.header_setup_incomplete);
            Intrinsics.checkExpressionValueIsNotNull(group2, "header_setup_incomplete");
            group2.setVisibility(8);
            Group group3 = (Group) _$_findCachedViewById(R.id.content_setup_complete);
            Intrinsics.checkExpressionValueIsNotNull(group3, "content_setup_complete");
            group3.setVisibility(0);
            Group group4 = (Group) _$_findCachedViewById(R.id.content_setup_incomplete_group);
            Intrinsics.checkExpressionValueIsNotNull(group4, "content_setup_incomplete_group");
            group4.setVisibility(8);
            refreshActionCards();
            return;
        }
        CardView cardView = (CardView) _$_findCachedViewById(R.id.home_setup_complete_been_tested);
        Intrinsics.checkExpressionValueIsNotNull(cardView, "home_setup_complete_been_tested");
        cardView.setVisibility(8);
        CardView cardView2 = (CardView) _$_findCachedViewById(R.id.home_setup_complete_uploaded_card);
        Intrinsics.checkExpressionValueIsNotNull(cardView2, "home_setup_complete_uploaded_card");
        cardView2.setVisibility(8);
        Group group5 = (Group) _$_findCachedViewById(R.id.header_setup_complete);
        Intrinsics.checkExpressionValueIsNotNull(group5, "header_setup_complete");
        group5.setVisibility(8);
        Group group6 = (Group) _$_findCachedViewById(R.id.header_setup_incomplete);
        Intrinsics.checkExpressionValueIsNotNull(group6, "header_setup_incomplete");
        group6.setVisibility(0);
        Group group7 = (Group) _$_findCachedViewById(R.id.content_setup_complete);
        Intrinsics.checkExpressionValueIsNotNull(group7, "content_setup_complete");
        group7.setVisibility(8);
        Group group8 = (Group) _$_findCachedViewById(R.id.content_setup_incomplete_group);
        Intrinsics.checkExpressionValueIsNotNull(group8, "content_setup_incomplete_group");
        group8.setVisibility(0);
        updateBlueToothStatus();
        updatePushNotificationStatus();
        updateBatteryOptimizationStatus();
        updateLocationStatus();
    }

    private final void refreshActionCards() {
        boolean z;
        Context context = getContext();
        int i = 0;
        if (context != null) {
            Preference preference = Preference.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(context, "it");
            z = preference.isDataUploaded(context);
        } else {
            HomeFragment homeFragment = this;
            z = false;
        }
        if (z) {
            refreshUploadedCard();
        }
        CardView cardView = (CardView) _$_findCachedViewById(R.id.home_setup_complete_been_tested);
        Intrinsics.checkExpressionValueIsNotNull(cardView, "home_setup_complete_been_tested");
        cardView.setVisibility(z ^ true ? 0 : 8);
        CardView cardView2 = (CardView) _$_findCachedViewById(R.id.home_setup_complete_uploaded_card);
        Intrinsics.checkExpressionValueIsNotNull(cardView2, "home_setup_complete_uploaded_card");
        View view = cardView2;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final void refreshUploadedCard() {
        ((ImageView) _$_findCachedViewById(R.id.home_data_uploaded_icon)).setImageResource(R.drawable.ic_check);
        ((TextView) _$_findCachedViewById(R.id.home_data_uploaded_title)).setText(R.string.home_data_has_been_uploaded);
        TextView textView = (TextView) _$_findCachedViewById(R.id.home_data_uploaded_message);
        Intrinsics.checkExpressionValueIsNotNull(textView, "home_data_uploaded_message");
        textView.setVisibility(8);
    }

    private final boolean allPermissionsEnabled() {
        Boolean isBlueToothEnabled = PermissionExtensionsKt.isBlueToothEnabled(this);
        boolean booleanValue = isBlueToothEnabled != null ? isBlueToothEnabled.booleanValue() : true;
        Boolean isPushNotificationEnabled = PermissionExtensionsKt.isPushNotificationEnabled(this);
        boolean booleanValue2 = isPushNotificationEnabled != null ? isPushNotificationEnabled.booleanValue() : true;
        Boolean isNonBatteryOptimizationAllowed = PermissionExtensionsKt.isNonBatteryOptimizationAllowed(this);
        boolean booleanValue3 = isNonBatteryOptimizationAllowed != null ? isNonBatteryOptimizationAllowed.booleanValue() : true;
        Boolean isFineLocationEnabled = PermissionExtensionsKt.isFineLocationEnabled(this);
        boolean booleanValue4 = isFineLocationEnabled != null ? isFineLocationEnabled.booleanValue() : true;
        if (!booleanValue || !booleanValue2 || !booleanValue3 || !booleanValue4) {
            return false;
        }
        return true;
    }

    private final void registerBroadcast() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.mBroadcastListener, new IntentFilter());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            activity.registerReceiver(this.mBroadcastListener, intentFilter);
            this.mIsBroadcastListenerRegistered = true;
        }
    }

    /* access modifiers changed from: private */
    public final void shareThisApp() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", getString(R.string.share_this_app_content));
        intent.putExtra(IntentCompat.EXTRA_HTML_TEXT, getString(R.string.share_this_app_content_html));
        startActivity(Intent.createChooser(intent, (CharSequence) null));
    }

    private final void updateBlueToothStatus() {
        Boolean isBlueToothEnabled = PermissionExtensionsKt.isBlueToothEnabled(this);
        if (isBlueToothEnabled != null) {
            boolean booleanValue = isBlueToothEnabled.booleanValue();
            PermissionStatusCard permissionStatusCard = (PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view);
            Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard, "bluetooth_card_view");
            permissionStatusCard.setVisibility(0);
            ((PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view)).render(formatBlueToothTitle(booleanValue), booleanValue);
            return;
        }
        PermissionStatusCard permissionStatusCard2 = (PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view);
        Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard2, "bluetooth_card_view");
        permissionStatusCard2.setVisibility(8);
    }

    private final void updatePushNotificationStatus() {
        Boolean isPushNotificationEnabled = PermissionExtensionsKt.isPushNotificationEnabled(this);
        if (isPushNotificationEnabled != null) {
            boolean booleanValue = isPushNotificationEnabled.booleanValue();
            PermissionStatusCard permissionStatusCard = (PermissionStatusCard) _$_findCachedViewById(R.id.push_card_view);
            Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard, "push_card_view");
            permissionStatusCard.setVisibility(0);
            ((PermissionStatusCard) _$_findCachedViewById(R.id.push_card_view)).render(formatPushNotificationTitle(booleanValue), booleanValue);
            return;
        }
        PermissionStatusCard permissionStatusCard2 = (PermissionStatusCard) _$_findCachedViewById(R.id.push_card_view);
        Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard2, "push_card_view");
        permissionStatusCard2.setVisibility(8);
    }

    private final void updateBatteryOptimizationStatus() {
        Boolean isNonBatteryOptimizationAllowed = PermissionExtensionsKt.isNonBatteryOptimizationAllowed(this);
        if (isNonBatteryOptimizationAllowed != null) {
            boolean booleanValue = isNonBatteryOptimizationAllowed.booleanValue();
            PermissionStatusCard permissionStatusCard = (PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view);
            Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard, "battery_card_view");
            permissionStatusCard.setVisibility(0);
            ((PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view)).render(formatNonBatteryOptimizationTitle(!booleanValue), booleanValue);
            return;
        }
        PermissionStatusCard permissionStatusCard2 = (PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view);
        Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard2, "battery_card_view");
        permissionStatusCard2.setVisibility(8);
    }

    private final void updateLocationStatus() {
        Boolean isFineLocationEnabled = PermissionExtensionsKt.isFineLocationEnabled(this);
        if (isFineLocationEnabled != null) {
            boolean booleanValue = isFineLocationEnabled.booleanValue();
            PermissionStatusCard permissionStatusCard = (PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view);
            Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard, "location_card_view");
            permissionStatusCard.setVisibility(0);
            ((PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view)).render(formatLocationTitle(booleanValue), booleanValue);
            return;
        }
        PermissionStatusCard permissionStatusCard2 = (PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view);
        Intrinsics.checkExpressionValueIsNotNull(permissionStatusCard2, "location_card_view");
        permissionStatusCard2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final String formatBlueToothTitle(boolean z) {
        String string = getResources().getString(R.string.home_bluetooth_permission, new Object[]{getPermissionEnabledTitle(z)});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…rmissionEnabledTitle(on))");
        return string;
    }

    private final String formatLocationTitle(boolean z) {
        String string = getResources().getString(R.string.home_location_permission, new Object[]{getPermissionEnabledTitle(z)});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…rmissionEnabledTitle(on))");
        return string;
    }

    private final String formatNonBatteryOptimizationTitle(boolean z) {
        String string = getResources().getString(R.string.home_non_battery_optimization_permission, new Object[]{getPermissionEnabledTitle(z)});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…rmissionEnabledTitle(on))");
        return string;
    }

    private final String formatPushNotificationTitle(boolean z) {
        String string = getResources().getString(R.string.home_push_notification_permission, new Object[]{getPermissionEnabledTitle(z)});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…rmissionEnabledTitle(on))");
        return string;
    }

    private final String getPermissionEnabledTitle(boolean z) {
        String string = getResources().getString(z ? R.string.home_permission_on : R.string.home_permission_off);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(if (…ring.home_permission_off)");
        return string;
    }

    /* access modifiers changed from: private */
    public final void goToNewsWebsite() {
        String string = getString(R.string.home_set_complete_external_link_news_url);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.home_…e_external_link_news_url)");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(string));
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void goToCovidApp() {
        String string = getString(R.string.home_set_complete_external_link_app_url);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.home_…te_external_link_app_url)");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(string));
        startActivity(intent);
    }

    public void onPermissionsDenied(int i, List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "perms");
        if (i == 345) {
            Fragment fragment = this;
            if (EasyPermissions.somePermissionPermanentlyDenied(fragment, (List<String>) CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION"))) {
                new AppSettingsDialog.Builder(fragment).build().show();
            }
        }
    }

    public void onPermissionsGranted(int i, List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "perms");
        if (i == 345) {
            PermissionExtensionsKt.checkBLESupport(this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i, strArr, iArr, this);
    }
}
