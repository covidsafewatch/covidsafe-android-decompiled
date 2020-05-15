package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    LocaleListPlatformWrapper(LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    public int size() {
        return this.mLocaleList.size();
    }

    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    public boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }

    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public Locale getFirstMatch(String[] strArr) {
        return this.mLocaleList.getFirstMatch(strArr);
    }
}
