package au.gov.health.covidsafe;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import au.gov.health.covidsafe.security.crypto.AESEncryptionForPreAndroidM;
import au.gov.health.covidsafe.security.crypto.EncryptedSharedPreferences;
import au.gov.health.covidsafe.security.crypto.MasterKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010'\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010)\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010+\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010/\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00100\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u00101\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0004J\u0016\u00103\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007J\u0016\u00106\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007J\u0016\u00107\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0004J\u0016\u00108\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0004J\u0016\u00109\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0004J\u001a\u0010:\u001a\u0002042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010;\u001a\u0004\u0018\u00010\u0004J\u0016\u0010<\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\"J\u001a\u0010>\u001a\u0002042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u00105\u001a\u0004\u0018\u00010\u0004J\u0016\u0010?\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020.J\u0016\u0010A\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020.J\u0016\u0010B\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\u0004J\u0016\u0010D\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007J\u0016\u0010E\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\"J\u0016\u0010F\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0004J\u0016\u0010G\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u0004J\u0016\u0010I\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00105\u001a\u00020.R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lau/gov/health/covidsafe/Preference;", "", "()V", "AES_IV", "", "AGE", "AUSTRALIA_CALLING_CODE", "", "AUSTRALIA_COUNTRY_NAME_RES_ID", "AUSTRALIA_NATIONAL_FLAG_RES_ID", "CALLING_CODE", "COUNTRY_NAME_RES_ID", "DATA_UPLOADED_DATE_MS", "DEVICE_ID", "ENCRYPTED_AES_KEY", "EXPIRY_TIME", "HANDSHAKE_PIN", "IS_DATA_UPLOADED", "IS_MINOR", "IS_ONBOARDED", "JWT_TOKEN", "NAME", "NATIONAL_FLAG_RES_ID", "NEXT_FETCH_TIME", "PHONE_NUMBER", "POST_CODE", "PREF_ID", "UPLOADED_MORE_THAN_24_HRS", "getAge", "context", "Landroid/content/Context;", "getCallingCode", "getCountryNameResID", "getDataUploadedDateMs", "", "getDeviceID", "getEncodedAESInitialisationVector", "getEncodedRSAEncryptedAESKey", "getEncrypterJWTToken", "getExpiryTimeInMillis", "getName", "getNationalFlagResID", "getNextFetchTimeInMillis", "getPhoneNumber", "getPostCode", "isDataUploaded", "", "isMinor", "isOnBoarded", "putAge", "age", "putCallingCode", "", "value", "putCountryNameResID", "putDeviceID", "putEncodedAESInitialisationVector", "putEncodedRSAEncryptedAESKey", "putEncrypterJWTToken", "jwtToken", "putExpiryTimeInMillis", "time", "putHandShakePin", "putIsMinor", "minor", "putIsOnBoarded", "putName", "name", "putNationalFlagResID", "putNextFetchTimeInMillis", "putPhoneNumber", "putPostCode", "state", "setDataIsUploaded", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Preference.kt */
public final class Preference {
    private static final String AES_IV = "AES_IV";
    private static final String AGE = "AGE";
    private static final int AUSTRALIA_CALLING_CODE = 61;
    private static final int AUSTRALIA_COUNTRY_NAME_RES_ID = 2131951682;
    private static final int AUSTRALIA_NATIONAL_FLAG_RES_ID = 2131230884;
    private static final String CALLING_CODE = "CALLING_CODE";
    private static final String COUNTRY_NAME_RES_ID = "COUNTRY_NAME";
    private static final String DATA_UPLOADED_DATE_MS = "DATA_UPLOADED_DATE_MS";
    private static final String DEVICE_ID = "DEVICE_ID";
    private static final String ENCRYPTED_AES_KEY = "ENCRYPTED_AES_KEY";
    private static final String EXPIRY_TIME = "EXPIRY_TIME";
    private static final String HANDSHAKE_PIN = "HANDSHAKE_PIN";
    public static final Preference INSTANCE = new Preference();
    private static final String IS_DATA_UPLOADED = "IS_DATA_UPLOADED";
    private static final String IS_MINOR = "IS_MINOR";
    private static final String IS_ONBOARDED = "IS_ONBOARDED";
    private static final String JWT_TOKEN = "JWT_TOKEN";
    private static final String NAME = "NAME";
    private static final String NATIONAL_FLAG_RES_ID = "NATIONAL_FLAG_RES_ID";
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
        SharedPreferences.Editor putString = context.getSharedPreferences(PREF_ID, 0).edit().putString(DEVICE_ID, str);
        if (putString != null) {
            putString.apply();
        }
    }

    public final String getDeviceID(Context context) {
        SharedPreferences sharedPreferences;
        String string;
        if (context == null || (sharedPreferences = context.getSharedPreferences(PREF_ID, 0)) == null || (string = sharedPreferences.getString(DEVICE_ID, "")) == null) {
            return "";
        }
        return string;
    }

    public final void putEncodedAESInitialisationVector(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "value");
        SharedPreferences.Editor putString = context.getSharedPreferences(PREF_ID, 0).edit().putString(AES_IV, str);
        if (putString != null) {
            putString.apply();
        }
    }

    public final String getEncodedAESInitialisationVector(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getString(AES_IV, (String) null);
    }

    public final void putEncodedRSAEncryptedAESKey(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "value");
        SharedPreferences.Editor putString = context.getSharedPreferences(PREF_ID, 0).edit().putString(ENCRYPTED_AES_KEY, str);
        if (putString != null) {
            putString.apply();
        }
    }

    public final String getEncodedRSAEncryptedAESKey(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(ENCRYPTED_AES_KEY, (String) null);
        }
        return null;
    }

    public final void putEncrypterJWTToken(Context context, String str) {
        SharedPreferences.Editor putString;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            String orCreate = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            Intrinsics.checkExpressionValueIsNotNull(orCreate, "MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)");
            SharedPreferences.Editor edit = EncryptedSharedPreferences.create(PREF_ID, orCreate, context, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM).edit();
            if (edit != null && (putString = edit.putString(JWT_TOKEN, str)) != null) {
                putString.apply();
                return;
            }
            return;
        }
        SharedPreferences.Editor putString2 = context.getSharedPreferences(PREF_ID, 0).edit().putString(JWT_TOKEN, str != null ? AESEncryptionForPreAndroidM.INSTANCE.encrypt(str) : null);
        if (putString2 != null) {
            putString2.apply();
        }
    }

    public final String getEncrypterJWTToken(Context context) {
        String string;
        String decrypt;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            String orCreate = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            Intrinsics.checkExpressionValueIsNotNull(orCreate, "MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)");
            decrypt = EncryptedSharedPreferences.create(PREF_ID, orCreate, context, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM).getString(JWT_TOKEN, (String) null);
        } else {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
            if (sharedPreferences == null || (string = sharedPreferences.getString(JWT_TOKEN, (String) null)) == null) {
                return null;
            }
            AESEncryptionForPreAndroidM aESEncryptionForPreAndroidM = AESEncryptionForPreAndroidM.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(string, "it");
            decrypt = aESEncryptionForPreAndroidM.decrypt(string);
        }
        return decrypt;
    }

    public final void putHandShakePin(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        if (context != null && (sharedPreferences = context.getSharedPreferences(PREF_ID, 0)) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(HANDSHAKE_PIN, str)) != null) {
            putString.apply();
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

    public final String getPhoneNumber(Context context) {
        String string;
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences == null || (string = sharedPreferences.getString(PHONE_NUMBER, "")) == null) {
            return "";
        }
        return string;
    }

    public final void putCallingCode(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putInt(CALLING_CODE, i).apply();
    }

    public final int getCallingCode(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(CALLING_CODE, 61);
        }
        return 61;
    }

    public final void putCountryNameResID(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putInt(COUNTRY_NAME_RES_ID, i).apply();
    }

    public final int getCountryNameResID(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(COUNTRY_NAME_RES_ID, R.string.country_au);
        }
        return R.string.country_au;
    }

    public final void putNationalFlagResID(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context.getSharedPreferences(PREF_ID, 0).edit().putInt(NATIONAL_FLAG_RES_ID, i).apply();
    }

    public final int getNationalFlagResID(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt(NATIONAL_FLAG_RES_ID, 2131230884);
        }
        return 2131230884;
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
        SharedPreferences.Editor edit = context.getSharedPreferences(PREF_ID, 0).edit();
        edit.putBoolean(IS_DATA_UPLOADED, z);
        if (z) {
            edit.putLong(DATA_UPLOADED_DATE_MS, System.currentTimeMillis());
        } else {
            edit.remove(DATA_UPLOADED_DATE_MS);
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
        return context.getSharedPreferences(PREF_ID, 0).getString(NAME, (String) null);
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
        return context.getSharedPreferences(PREF_ID, 0).getString(POST_CODE, (String) null);
    }

    public final boolean putAge(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "age");
        return context.getSharedPreferences(PREF_ID, 0).edit().putString(AGE, str).commit();
    }

    public final String getAge(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return context.getSharedPreferences(PREF_ID, 0).getString(AGE, (String) null);
    }
}
