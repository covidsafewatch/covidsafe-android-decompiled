package au.gov.health.covidsafe.ui.home;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.BuildConfig;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.WebViewActivity;
import au.gov.health.covidsafe.extensions.PermissionExtensionsKt;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.home.view.ExternalLinkCard;
import au.gov.health.covidsafe.ui.home.view.PermissionStatusCard;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u001e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0016J\u001e\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0016J-\u0010&\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0(2\u0006\u0010)\u001a\u00020*H\u0016¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u0015H\u0016J\u001a\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010/\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0002J\b\u00105\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lau/gov/health/covidsafe/ui/home/HomeFragment;", "Lau/gov/health/covidsafe/ui/BaseFragment;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "()V", "counter", "", "mBroadcastListener", "Landroid/content/BroadcastReceiver;", "mIsBroadcastListenerRegistered", "", "presenter", "Lau/gov/health/covidsafe/ui/home/HomePresenter;", "allPermissionsEnabled", "formatBlueToothTitle", "", "on", "formatLocationTitle", "formatNonBatteryOptimizationTitle", "formatPushNotificationTitle", "getPermissionEnabledTitle", "goToCovidApp", "", "goToNewsWebsite", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onPermissionsDenied", "requestCode", "perms", "", "onPermissionsGranted", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "refreshSetupCompleteOrIncompleteUi", "registerBroadcast", "shareThisApp", "updateBatteryOptimizationStatus", "updateBlueToothStatus", "updateLocationStatus", "updatePushNotificationStatus", "app_release"}, k = 1, mv = {1, 1, 16})
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        this.presenter = new HomePresenter(this);
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) view.findViewById(R.id.home_header_help)).setOnClickListener(new HomeFragment$onViewCreated$1(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.home_version_number);
        Intrinsics.checkExpressionValueIsNotNull(textView, "home_version_number");
        textView.setText(getString(R.string.home_version_number, BuildConfig.VERSION_NAME));
    }

    public void onResume() {
        super.onResume();
        ((PermissionStatusCard) _$_findCachedViewById(R.id.bluetooth_card_view)).setOnClickListener(new HomeFragment$onResume$1(this));
        ((PermissionStatusCard) _$_findCachedViewById(R.id.location_card_view)).setOnClickListener(new HomeFragment$onResume$2(this));
        ((PermissionStatusCard) _$_findCachedViewById(R.id.battery_card_view)).setOnClickListener(new HomeFragment$onResume$3(this));
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_been_tested_button)).setOnClickListener(new HomeFragment$onResume$4(this));
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
        ((ExternalLinkCard) _$_findCachedViewById(R.id.home_been_tested_button)).setOnClickListener((View.OnClickListener) null);
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
        boolean z;
        Context context = getContext();
        if (context != null) {
            Preference preference = Preference.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(context, "it");
            z = preference.isDataUploaded(context);
        } else {
            HomeFragment homeFragment = this;
            z = false;
        }
        ExternalLinkCard externalLinkCard = (ExternalLinkCard) _$_findCachedViewById(R.id.home_been_tested_button);
        Intrinsics.checkExpressionValueIsNotNull(externalLinkCard, "home_been_tested_button");
        externalLinkCard.setVisibility(z ? 8 : 0);
        if (!allPermissionsEnabled()) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded);
            Intrinsics.checkExpressionValueIsNotNull(textView, "home_header_setup_complete_header_uploaded");
            textView.setVisibility(8);
            View _$_findCachedViewById = _$_findCachedViewById(R.id.home_header_setup_complete_header_divider);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "home_header_setup_complete_header_divider");
            _$_findCachedViewById.setVisibility(8);
            ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setText(R.string.home_header_inactive_title);
            ((LottieAnimationView) _$_findCachedViewById(R.id.home_header_picture_setup_complete)).setImageResource(R.drawable.ic_logo_home_inactive);
            ((ImageView) _$_findCachedViewById(R.id.home_header_help)).setImageResource(R.drawable.ic_help_outline_black);
            Context context2 = getContext();
            if (context2 != null) {
                int color = ContextCompat.getColor(context2, R.color.grey);
                _$_findCachedViewById(R.id.header_background).setBackgroundColor(color);
                _$_findCachedViewById(R.id.header_background_overlap).setBackgroundColor(color);
                int color2 = ContextCompat.getColor(context2, R.color.slack_black);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded)).setTextColor(color2);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setTextColor(color2);
            }
            Group group = (Group) _$_findCachedViewById(R.id.content_setup_incomplete_group);
            Intrinsics.checkExpressionValueIsNotNull(group, "content_setup_incomplete_group");
            group.setVisibility(0);
            updateBlueToothStatus();
            updatePushNotificationStatus();
            updateBatteryOptimizationStatus();
            updateLocationStatus();
        } else if (z) {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "home_header_setup_complete_header_uploaded");
            textView2.setVisibility(0);
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.home_header_setup_complete_header_divider);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "home_header_setup_complete_header_divider");
            _$_findCachedViewById2.setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setText(R.string.home_header_active_title);
            ((LottieAnimationView) _$_findCachedViewById(R.id.home_header_picture_setup_complete)).setImageResource(R.drawable.ic_logo_home_uploaded);
            ((LottieAnimationView) _$_findCachedViewById(R.id.home_header_picture_setup_complete)).setAnimation("spinner_home_upload_complete.json");
            ((ImageView) _$_findCachedViewById(R.id.home_header_help)).setImageResource(R.drawable.ic_help_outline_white);
            Group group2 = (Group) _$_findCachedViewById(R.id.content_setup_incomplete_group);
            Intrinsics.checkExpressionValueIsNotNull(group2, "content_setup_incomplete_group");
            group2.setVisibility(8);
            Context context3 = getContext();
            if (context3 != null) {
                int color3 = ContextCompat.getColor(context3, R.color.dark_green);
                _$_findCachedViewById(R.id.header_background).setBackgroundColor(color3);
                _$_findCachedViewById(R.id.header_background_overlap).setBackgroundColor(color3);
                int color4 = ContextCompat.getColor(context3, R.color.white);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded)).setTextColor(color4);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setTextColor(color4);
            }
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "home_header_setup_complete_header_uploaded");
            textView3.setVisibility(8);
            View _$_findCachedViewById3 = _$_findCachedViewById(R.id.home_header_setup_complete_header_divider);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "home_header_setup_complete_header_divider");
            _$_findCachedViewById3.setVisibility(8);
            ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setText(R.string.home_header_active_title);
            ((ImageView) _$_findCachedViewById(R.id.home_header_help)).setImageResource(R.drawable.ic_help_outline_black);
            ((LottieAnimationView) _$_findCachedViewById(R.id.home_header_picture_setup_complete)).setAnimation("spinner_home.json");
            Group group3 = (Group) _$_findCachedViewById(R.id.content_setup_incomplete_group);
            Intrinsics.checkExpressionValueIsNotNull(group3, "content_setup_incomplete_group");
            group3.setVisibility(8);
            Context context4 = getContext();
            if (context4 != null) {
                int color5 = ContextCompat.getColor(context4, R.color.lighter_green);
                _$_findCachedViewById(R.id.header_background).setBackgroundColor(color5);
                _$_findCachedViewById(R.id.header_background_overlap).setBackgroundColor(color5);
                int color6 = ContextCompat.getColor(context4, R.color.slack_black);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header_uploaded)).setTextColor(color6);
                ((TextView) _$_findCachedViewById(R.id.home_header_setup_complete_header)).setTextColor(color6);
            }
        }
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
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(string));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
            intent2.putExtra(WebViewActivity.Companion.getURL_ARG(), string);
            startActivity(intent2);
        }
    }

    /* access modifiers changed from: private */
    public final void goToCovidApp() {
        String string = getString(R.string.home_set_complete_external_link_app_url);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.home_…te_external_link_app_url)");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(string));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
            intent2.putExtra(WebViewActivity.Companion.getURL_ARG(), string);
            startActivity(intent2);
        }
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