package androidx.core.content;

import java.util.ArrayList;

public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean mimeTypeAgainstFilter(String[] strArr, String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        } else if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        } else if (strArr.length != 2) {
            return false;
        } else {
            String str = "*";
            if (!str.equals(strArr2[0]) && !strArr2[0].equals(strArr[0])) {
                return false;
            }
            if (str.equals(strArr2[1]) || strArr2[1].equals(strArr[1])) {
                return true;
            }
            return false;
        }
    }

    public static boolean matches(String str, String str2) {
        if (str == null) {
            return false;
        }
        String str3 = "/";
        return mimeTypeAgainstFilter(str.split(str3), str2.split(str3));
    }

    public static String matches(String str, String[] strArr) {
        if (str == null) {
            return null;
        }
        String str2 = "/";
        String[] split = str.split(str2);
        for (String str3 : strArr) {
            if (mimeTypeAgainstFilter(split, str3.split(str2))) {
                return str3;
            }
        }
        return null;
    }

    public static String matches(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        String str2 = "/";
        String[] split = str.split(str2);
        for (String str3 : strArr) {
            if (mimeTypeAgainstFilter(str3.split(str2), split)) {
                return str3;
            }
        }
        return null;
    }

    public static String[] matchesMany(String[] strArr, String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "/";
        String[] split = str.split(str2);
        for (String str3 : strArr) {
            if (mimeTypeAgainstFilter(str3.split(str2), split)) {
                arrayList.add(str3);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
