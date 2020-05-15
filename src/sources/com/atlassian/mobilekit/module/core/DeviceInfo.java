package com.atlassian.mobilekit.module.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import java.util.Locale;
import java.util.UUID;

public final class DeviceInfo {
    private static final String ANDROID_OS = "Android OS";
    private static final String NAMESPACE = "com.atlassian.mobilekit.module.core";
    private static final String STORE_NAME = "com.atlassian.mobilekit.module.core.preferences";
    private static final String UUID_KEY = "com.atlassian.mobilekit.module.core.UUID";
    private int appVersionCode = -1;
    private String appVersionName;
    private final Context ctx;
    private final SharedPreferences store;
    private String udid;
    private String uuid;

    public String getSystemName() {
        return ANDROID_OS;
    }

    public DeviceInfo(Context context) {
        this.ctx = context.getApplicationContext();
        this.store = context.getSharedPreferences(STORE_NAME, 0);
    }

    private synchronized String initUdid() {
        String string;
        string = Settings.Secure.getString(this.ctx.getContentResolver(), "android_id");
        if (string == null) {
            throw new AssertionError("ANDROID_ID setting was null");
        }
        return string;
    }

    private synchronized String initUuid() {
        String string;
        string = this.store.getString(UUID_KEY, (String) null);
        if (string == null) {
            string = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(UUID_KEY, string);
            edit.apply();
        }
        return string;
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = initUuid();
        }
        return this.uuid;
    }

    public String getUdid() {
        if (this.udid == null) {
            this.udid = initUdid();
        }
        return this.udid;
    }

    public String getAppPkgName() {
        return this.ctx.getPackageName();
    }

    public String getAppName() {
        return this.ctx.getPackageManager().getApplicationLabel(this.ctx.getApplicationInfo()).toString();
    }

    public String getAppVersionName() {
        if (this.appVersionName == null) {
            this.appVersionName = getPackageInfo().versionName;
        }
        return this.appVersionName;
    }

    public int getAppVersionCode() {
        if (this.appVersionCode == -1) {
            this.appVersionCode = getPackageInfo().versionCode;
        }
        return this.appVersionCode;
    }

    public String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getDeviceName() {
        return Build.DEVICE;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getLanguage() {
        return Locale.getDefault().getDisplayLanguage();
    }

    public String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public boolean hasConnectivity() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.ctx.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    private PackageInfo getPackageInfo() {
        try {
            return this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
