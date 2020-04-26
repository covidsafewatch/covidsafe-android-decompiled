package au.gov.health.covidsafe;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences.PrefKeyEncryptionScheme;
import androidx.security.crypto.EncryptedSharedPreferences.PrefValueEncryptionScheme;
import androidx.security.crypto.MasterKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0004J\u001a\u0010'\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010)\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0017J\u001a\u0010+\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010&\u001a\u0004\u0018\u00010\u0004J\u0016\u0010,\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001fJ\u0016\u0010.\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001fJ\u0016\u0010/\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0004J\u0016\u00101\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0017J\u0016\u00102\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0004J\u0016\u00103\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0004J\u0016\u00105\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lau/gov/health/covidsafe/Preference;", "", "()V", "AGE", "", "DATA_UPLOADED_DATE_MS", "DEVICE_ID", "EXPIRY_TIME", "HANDSHAKE_PIN", "IS_DATA_UPLOADED", "IS_MINOR", "IS_ONBOARDED", "JWT_TOKEN", "NAME", "NEXT_FETCH_TIME", "PHONE_NUMBER", "POST_CODE", "PREF_ID", "UPLOADED_MORE_THAN_24_HRS", "getAge", "context", "Landroid/content/Context;", "getDataUploadedDateMs", "", "getDeviceID", "getEncrypterJWTToken", "getExpiryTimeInMillis", "getName", "getNextFetchTimeInMillis", "getPostCode", "isDataUploaded", "", "isMinor", "isOnBoarded", "putAge", "age", "putDeviceID", "", "value", "putEncrypterJWTToken", "jwtToken", "putExpiryTimeInMillis", "time", "putHandShakePin", "putIsMinor", "minor", "putIsOnBoarded", "putName", "name", "putNextFetchTimeInMillis", "putPhoneNumber", "putPostCode", "state", "setDataIsUploaded", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Preference.kt */
public final class Preference {
    private static final String AGE = "AGE";
    private static final String DATA_UPLOADED_DATE_MS = "DATA_UPLOADED_DATE_MS";
    private static final String DEVICE_ID = "DEVICE_ID";
    private static final String EXPIRY_TIME = "EXPIRY_TIME";
    private static final String HANDSHAKE_PIN = "HANDSHAKE_PIN";
    public static final Preference INSTANCE = new Preference();
    private static final String IS_DATA_UPLOADED = "IS_DATA_UPLOADED";
    private static final String IS_MINOR = "IS_MINOR";
    private static final String IS_ONBOARDED = "IS_ONBOARDED";
    private static final String JWT_TOKEN = "JWT_TOKEN";
    private static final String NAME = "NAME";
    private static final String NEXT_FETCH_TIME = "NEXT_FETCH_TIME";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
    private static final String POST_CODE = "POST_CODE";
    private static final String PREF_ID = "Tracer_pref";
    private static final String UPLOADED_MORE_THAN_24_HRS = "UPLOADED_MORE_THAN_24_HRS";

    private Preference() {
    }

    public final void putDeviceID(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "value");
        Editor putString = context.getSharedPreferences(PREF_ID, 0).edit().putString(DEVICE_ID, str);
        if (putString != null) {
            putString.apply();
        }
    }

    public final String getDeviceID(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences == null) {
            return str;
        }
        String string = sharedPreferences.getString(DEVICE_ID, str);
        return string != null ? string : str;
    }

    public final void putEncrypterJWTToken(Context context, String str) {
        if (context != null) {
            String orCreate = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            Intrinsics.checkExpressionValueIsNotNull(orCreate, "MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)");
            Editor edit = EncryptedSharedPreferences.create(PREF_ID, orCreate, context, PrefKeyEncryptionScheme.AES256_SIV, PrefValueEncryptionScheme.AES256_GCM).edit();
            if (edit != null) {
                Editor putString = edit.putString(JWT_TOKEN, str);
                if (putString != null) {
                    putString.apply();
                }
            }
        }
    }

    public final String getEncrypterJWTToken(Context context) {
        if (context == null) {
            return null;
        }
        String orCreate = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        Intrinsics.checkExpressionValueIsNotNull(orCreate, "MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)");
        return EncryptedSharedPreferences.create(PREF_ID, orCreate, context, PrefKeyEncryptionScheme.AES256_SIV, PrefValueEncryptionScheme.AES256_GCM).getString(JWT_TOKEN, null);
    }

    public final void putHandShakePin(Context context, String str) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    Editor putString = edit.putString(HANDSHAKE_PIN, str);
                    if (putString != null) {
                        putString.apply();
                    }
                }
            }
        }
    }

    public final void putIsOnBoarded(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putBoolean(IS_ONBOARDED, z).apply();
    }

    public final boolean isOnBoarded(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getBoolean(IS_ONBOARDED, false);
    }

    public final void putPhoneNumber(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "value");
        context.getSharedPreferences(PREF_ID, 0).edit().putString(PHONE_NUMBER, str).apply();
    }

    public final void putNextFetchTimeInMillis(Context context, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putLong(NEXT_FETCH_TIME, j).apply();
    }

    public final long getNextFetchTimeInMillis(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getLong(NEXT_FETCH_TIME, 0);
    }

    public final void putExpiryTimeInMillis(Context context, long j) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putLong(EXPIRY_TIME, j).apply();
    }

    public final long getExpiryTimeInMillis(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getLong(EXPIRY_TIME, 0);
    }

    public final boolean isDataUploaded(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getBoolean(IS_DATA_UPLOADED, false);
    }

    public final void setDataIsUploaded(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Editor edit = context.getSharedPreferences(PREF_ID, 0).edit();
        edit.putBoolean(IS_DATA_UPLOADED, z);
        String str = DATA_UPLOADED_DATE_MS;
        if (z) {
            edit.putLong(str, System.currentTimeMillis());
        } else {
            edit.remove(str);
        }
        edit.apply();
    }

    public final long getDataUploadedDateMs(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getLong(DATA_UPLOADED_DATE_MS, System.currentTimeMillis());
    }

    public final boolean putName(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "name");
        return context.getSharedPreferences(PREF_ID, 0).edit().putString(NAME, str).commit();
    }

    public final String getName(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getString(NAME, null);
    }

    public final boolean putIsMinor(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).edit().putBoolean(IS_MINOR, z).commit();
    }

    public final boolean isMinor(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getBoolean(IS_MINOR, false);
    }

    public final boolean putPostCode(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "state");
        return context.getSharedPreferences(PREF_ID, 0).edit().putString(POST_CODE, str).commit();
    }

    public final String getPostCode(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getString(POST_CODE, null);
    }

    public final boolean putAge(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "age");
        return context.getSharedPreferences(PREF_ID, 0).edit().putString(AGE, str).commit();
    }

    public final String getAge(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getString(AGE, null);
    }
}
