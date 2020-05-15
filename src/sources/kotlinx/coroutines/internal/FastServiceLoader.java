package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\b¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: FastServiceLoader.kt */
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        MainDispatcherFactory mainDispatcherFactory;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return load(cls, cls.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = cls.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = cls.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (Throwable unused3) {
            return load(cls, cls.getClassLoader());
        }
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> List<S> load(Class<S> cls, ClassLoader classLoader) {
        try {
            return loadProviders$kotlinx_coroutines_core(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt.toList(ServiceLoader.load(cls, classLoader));
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> cls, ClassLoader classLoader) {
        ArrayList<T> list = Collections.list(classLoader.getResources(PREFIX + cls.getName()));
        Intrinsics.checkExpressionValueIsNotNull(list, "java.util.Collections.list(this)");
        Collection arrayList = new ArrayList();
        for (T parse : list) {
            CollectionsKt.addAll(arrayList, INSTANCE.parse(parse));
        }
        Set set = CollectionsKt.toSet((List) arrayList);
        if (!set.isEmpty()) {
            Iterable<String> iterable = set;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String providerInstance : iterable) {
                arrayList2.add(INSTANCE.getProviderInstance(providerInstance, classLoader, cls));
            }
            return (List) arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S getProviderInstance(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        kotlin.ExceptionsKt.addSuppressed(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> parse(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toString()
            r1 = 0
            r2 = 2
            r3 = 0
            java.lang.String r4 = "jar"
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r0, r4, r1, r2, r3)
            if (r4 == 0) goto L_0x0069
            java.lang.String r6 = "jar:file:"
            java.lang.String r6 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r3, (int) r2, (java.lang.Object) r3)
            r4 = 33
            java.lang.String r6 = kotlin.text.StringsKt.substringBefore$default((java.lang.String) r6, (char) r4, (java.lang.String) r3, (int) r2, (java.lang.Object) r3)
            java.lang.String r4 = "!/"
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r4, (java.lang.String) r3, (int) r2, (java.lang.Object) r3)
            java.util.jar.JarFile r2 = new java.util.jar.JarFile
            r2.<init>(r6, r1)
            r6 = r3
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x005d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x005d }
            java.util.zip.ZipEntry r4 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            java.io.InputStream r0 = r2.getInputStream(r4)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r0, r4)     // Catch:{ all -> 0x005d }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ all -> 0x005d }
            r6.<init>(r1)     // Catch:{ all -> 0x005d }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x005d }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x005d }
            r0 = r6
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0056 }
            kotlinx.coroutines.internal.FastServiceLoader r1 = INSTANCE     // Catch:{ all -> 0x0056 }
            java.util.List r0 = r1.parseFile(r0)     // Catch:{ all -> 0x0056 }
            kotlin.io.CloseableKt.closeFinally(r6, r3)     // Catch:{ all -> 0x005d }
            r2.close()     // Catch:{ all -> 0x0054 }
            return r0
        L_0x0054:
            r6 = move-exception
            throw r6
        L_0x0056:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)     // Catch:{ all -> 0x005d }
            throw r1     // Catch:{ all -> 0x005d }
        L_0x005d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x0064 }
            throw r0
        L_0x0064:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r6, r0)
            throw r6
        L_0x0069:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r6 = r6.openStream()
            r1.<init>(r6)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r6 = r0
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x008a }
            kotlinx.coroutines.internal.FastServiceLoader r1 = INSTANCE     // Catch:{ all -> 0x008a }
            java.util.List r6 = r1.parseFile(r6)     // Catch:{ all -> 0x008a }
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return r6
        L_0x008a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x008c }
        L_0x008c:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.parse(java.net.URL):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
        kotlin.ExceptionsKt.addSuppressed(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R use(java.util.jar.JarFile r3, kotlin.jvm.functions.Function1<? super java.util.jar.JarFile, ? extends R> r4) {
        /*
            r2 = this;
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r0 = 1
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0014 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r3.close()     // Catch:{ all -> 0x0012 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r4
        L_0x0012:
            r3 = move-exception
            throw r3
        L_0x0014:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r3.close()     // Catch:{ all -> 0x0021 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        L_0x0021:
            r3 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.use(java.util.jar.JarFile, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private final List<String> parseFile(BufferedReader bufferedReader) {
        boolean z;
        Set linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt.toList(linkedHashSet);
            }
            String substringBefore$default = StringsKt.substringBefore$default(readLine, "#", (String) null, 2, (Object) null);
            if (substringBefore$default != null) {
                String obj = StringsKt.trim((CharSequence) substringBefore$default).toString();
                CharSequence charSequence = obj;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    if (i >= charSequence.length()) {
                        z = true;
                        break;
                    }
                    char charAt = charSequence.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    if (charSequence.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }
}
