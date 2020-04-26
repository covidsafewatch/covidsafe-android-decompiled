package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import java.util.Locale;

public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        CharSequence charSequence = null;
        if (VERSION.SDK_INT < 28) {
            return null;
        }
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        int size = serviceInfo.getNamedContentLocales().size();
        if (size == 0) {
            return null;
        }
        String[] strArr = new String[size];
        int i = 0;
        for (Locale languageTag : serviceInfo.getNamedContentLocales()) {
            strArr[i] = languageTag.toLanguageTag();
            i++;
        }
        Locale firstMatch = locales.getFirstMatch(strArr);
        if (firstMatch != null) {
            charSequence = serviceInfo.getNameForLocale(firstMatch);
        }
        return charSequence;
    }
}
