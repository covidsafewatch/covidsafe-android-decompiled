package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/io/FilesKt")
/* compiled from: FilePathComponents.kt */
class FilesKt__FilePathComponentsKt {
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default == 0) {
            if (str.length() > 1 && str.charAt(1) == File.separatorChar) {
                int indexOf$default2 = StringsKt.indexOf$default(charSequence, File.separatorChar, 2, false, 4, (Object) null);
                if (indexOf$default2 >= 0) {
                    int i = indexOf$default2 + 1;
                    int indexOf$default3 = StringsKt.indexOf$default(charSequence, File.separatorChar, i, false, 4, (Object) null);
                    if (indexOf$default3 >= 0) {
                        return indexOf$default3 + 1;
                    }
                    return str.length();
                }
            }
            return 1;
        } else if (indexOf$default > 0 && str.charAt(indexOf$default - 1) == ':') {
            return indexOf$default + 1;
        } else {
            if (indexOf$default != -1 || !StringsKt.endsWith$default(charSequence, ':', false, 2, (Object) null)) {
                return 0;
            }
            return str.length();
        }
    }

    public static final String getRootName(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$rootName");
        String path = file.getPath();
        String str = "path";
        Intrinsics.checkExpressionValueIsNotNull(path, str);
        String path2 = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path2, str);
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path2);
        if (path != null) {
            String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final File getRoot(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$root");
        return new File(FilesKt.getRootName(file));
    }

    public static final boolean isRooted(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$isRooted");
        String path = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }

    public static final FilePathComponents toComponents(File file) {
        List list;
        Intrinsics.checkParameterIsNotNull(file, "$this$toComponents");
        String path = file.getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        CharSequence charSequence = substring2;
        if (charSequence.length() == 0) {
            list = CollectionsKt.emptyList();
        } else {
            Iterable<String> split$default = StringsKt.split$default(charSequence, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String file2 : split$default) {
                arrayList.add(new File(file2));
            }
            list = (List) arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }

    public static final File subPath(File file, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(file, "$this$subPath");
        return FilesKt.toComponents(file).subPath(i, i2);
    }
}
