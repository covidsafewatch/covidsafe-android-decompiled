package com.google.common.reflect;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ClassPath {
    private static final String CLASS_FILE_NAME_EXTENSION = ".class";
    /* access modifiers changed from: private */
    public static final Splitter CLASS_PATH_ATTRIBUTE_SEPARATOR = Splitter.on(" ").omitEmptyStrings();
    private static final Predicate<ClassInfo> IS_TOP_LEVEL = new Predicate<ClassInfo>() {
        public boolean apply(ClassInfo classInfo) {
            return classInfo.className.indexOf(36) == -1;
        }
    };
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ClassPath.class.getName());
    private final ImmutableSet<ResourceInfo> resources;

    public static final class ClassInfo extends ResourceInfo {
        /* access modifiers changed from: private */
        public final String className;

        ClassInfo(String str, ClassLoader classLoader) {
            super(str, classLoader);
            this.className = ClassPath.getClassName(str);
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.className);
        }

        public String getSimpleName() {
            int lastIndexOf = this.className.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.inRange('0', '9').trimLeadingFrom(this.className.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.className;
            }
            return this.className.substring(packageName.length() + 1);
        }

        public String getName() {
            return this.className;
        }

        public Class<?> load() {
            try {
                return this.loader.loadClass(this.className);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException(e);
            }
        }

        public String toString() {
            return this.className;
        }
    }

    static final class DefaultScanner extends Scanner {
        private final SetMultimap<ClassLoader, String> resources = MultimapBuilder.hashKeys().linkedHashSetValues().build();

        DefaultScanner() {
        }

        /* access modifiers changed from: 0000 */
        public ImmutableSet<ResourceInfo> getResources() {
            Builder builder = ImmutableSet.builder();
            for (Entry entry : this.resources.entries()) {
                builder.add((Object) ResourceInfo.of((String) entry.getValue(), (ClassLoader) entry.getKey()));
            }
            return builder.build();
        }

        /* access modifiers changed from: protected */
        public void scanJarFile(ClassLoader classLoader, JarFile jarFile) {
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                if (!jarEntry.isDirectory() && !jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
                    this.resources.get(classLoader).add(jarEntry.getName());
                }
            }
        }

        /* access modifiers changed from: protected */
        public void scanDirectory(ClassLoader classLoader, File file) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            scanDirectory(file, classLoader, "", hashSet);
        }

        private void scanDirectory(File file, ClassLoader classLoader, String str, Set<File> set) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Logger access$100 = ClassPath.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot read directory ");
                sb.append(file);
                access$100.warning(sb.toString());
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(name);
                        sb2.append("/");
                        scanDirectory(canonicalFile, classLoader, sb2.toString(), set);
                        set.remove(canonicalFile);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(name);
                    String sb4 = sb3.toString();
                    if (!sb4.equals("META-INF/MANIFEST.MF")) {
                        this.resources.get(classLoader).add(sb4);
                    }
                }
            }
        }
    }

    public static class ResourceInfo {
        final ClassLoader loader;
        private final String resourceName;

        static ResourceInfo of(String str, ClassLoader classLoader) {
            if (str.endsWith(ClassPath.CLASS_FILE_NAME_EXTENSION)) {
                return new ClassInfo(str, classLoader);
            }
            return new ResourceInfo(str, classLoader);
        }

        ResourceInfo(String str, ClassLoader classLoader) {
            this.resourceName = (String) Preconditions.checkNotNull(str);
            this.loader = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        public final URL url() {
            URL resource = this.loader.getResource(this.resourceName);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.resourceName);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public final String getResourceName() {
            return this.resourceName;
        }

        public int hashCode() {
            return this.resourceName.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            if (!this.resourceName.equals(resourceInfo.resourceName) || this.loader != resourceInfo.loader) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.resourceName;
        }
    }

    static abstract class Scanner {
        private final Set<File> scannedUris = Sets.newHashSet();

        /* access modifiers changed from: protected */
        public abstract void scanDirectory(ClassLoader classLoader, File file) throws IOException;

        /* access modifiers changed from: protected */
        public abstract void scanJarFile(ClassLoader classLoader, JarFile jarFile) throws IOException;

        Scanner() {
        }

        public final void scan(ClassLoader classLoader) throws IOException {
            UnmodifiableIterator it = getClassPathEntries(classLoader).entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                scan((File) entry.getKey(), (ClassLoader) entry.getValue());
            }
        }

        /* access modifiers changed from: 0000 */
        public final void scan(File file, ClassLoader classLoader) throws IOException {
            if (this.scannedUris.add(file.getCanonicalFile())) {
                scanFrom(file, classLoader);
            }
        }

        private void scanFrom(File file, ClassLoader classLoader) throws IOException {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        scanDirectory(classLoader, file);
                    } else {
                        scanJar(file, classLoader);
                    }
                }
            } catch (SecurityException e) {
                Logger access$100 = ClassPath.logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot access ");
                sb.append(file);
                sb.append(": ");
                sb.append(e);
                access$100.warning(sb.toString());
            }
        }

        private void scanJar(File file, ClassLoader classLoader) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator it = getClassPathFromManifest(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        scan((File) it.next(), classLoader);
                    }
                    scanJarFile(classLoader, jarFile);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        static ImmutableSet<File> getClassPathFromManifest(File file, @NullableDecl Manifest manifest) {
            if (manifest == null) {
                return ImmutableSet.of();
            }
            Builder builder = ImmutableSet.builder();
            String value = manifest.getMainAttributes().getValue(Name.CLASS_PATH.toString());
            if (value != null) {
                for (String str : ClassPath.CLASS_PATH_ATTRIBUTE_SEPARATOR.split(value)) {
                    try {
                        URL classPathEntry = getClassPathEntry(file, str);
                        if (classPathEntry.getProtocol().equals("file")) {
                            builder.add((Object) ClassPath.toFile(classPathEntry));
                        }
                    } catch (MalformedURLException unused) {
                        Logger access$100 = ClassPath.logger;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid Class-Path entry: ");
                        sb.append(str);
                        access$100.warning(sb.toString());
                    }
                }
            }
            return builder.build();
        }

        static ImmutableMap<File, ClassLoader> getClassPathEntries(ClassLoader classLoader) {
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            ClassLoader parent = classLoader.getParent();
            if (parent != null) {
                newLinkedHashMap.putAll(getClassPathEntries(parent));
            }
            UnmodifiableIterator it = getClassLoaderUrls(classLoader).iterator();
            while (it.hasNext()) {
                URL url = (URL) it.next();
                if (url.getProtocol().equals("file")) {
                    File file = ClassPath.toFile(url);
                    if (!newLinkedHashMap.containsKey(file)) {
                        newLinkedHashMap.put(file, classLoader);
                    }
                }
            }
            return ImmutableMap.copyOf((Map<? extends K, ? extends V>) newLinkedHashMap);
        }

        private static ImmutableList<URL> getClassLoaderUrls(ClassLoader classLoader) {
            if (classLoader instanceof URLClassLoader) {
                return ImmutableList.copyOf((E[]) ((URLClassLoader) classLoader).getURLs());
            }
            if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
                return parseJavaClassPath();
            }
            return ImmutableList.of();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|7|8|15|12|1) */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0039, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0050, code lost:
            r4 = com.google.common.reflect.ClassPath.access$100();
            r5 = java.util.logging.Level.WARNING;
            r6 = new java.lang.StringBuilder();
            r6.append("malformed classpath entry: ");
            r6.append(r2);
            r4.log(r5, r6.toString(), r3);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static com.google.common.collect.ImmutableList<java.net.URL> parseJavaClassPath() {
            /*
                com.google.common.collect.ImmutableList$Builder r0 = com.google.common.collect.ImmutableList.builder()
                com.google.common.base.StandardSystemProperty r1 = com.google.common.base.StandardSystemProperty.PATH_SEPARATOR
                java.lang.String r1 = r1.value()
                com.google.common.base.Splitter r1 = com.google.common.base.Splitter.on(r1)
                com.google.common.base.StandardSystemProperty r2 = com.google.common.base.StandardSystemProperty.JAVA_CLASS_PATH
                java.lang.String r2 = r2.value()
                java.lang.Iterable r1 = r1.split(r2)
                java.util.Iterator r1 = r1.iterator()
            L_0x001c:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x006b
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                java.io.File r3 = new java.io.File     // Catch:{ SecurityException -> 0x003b }
                r3.<init>(r2)     // Catch:{ SecurityException -> 0x003b }
                java.net.URI r3 = r3.toURI()     // Catch:{ SecurityException -> 0x003b }
                java.net.URL r3 = r3.toURL()     // Catch:{ SecurityException -> 0x003b }
                r0.add(r3)     // Catch:{ SecurityException -> 0x003b }
                goto L_0x001c
            L_0x0039:
                r3 = move-exception
                goto L_0x0050
            L_0x003b:
                java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0039 }
                java.lang.String r4 = "file"
                r5 = 0
                java.io.File r6 = new java.io.File     // Catch:{ MalformedURLException -> 0x0039 }
                r6.<init>(r2)     // Catch:{ MalformedURLException -> 0x0039 }
                java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ MalformedURLException -> 0x0039 }
                r3.<init>(r4, r5, r6)     // Catch:{ MalformedURLException -> 0x0039 }
                r0.add(r3)     // Catch:{ MalformedURLException -> 0x0039 }
                goto L_0x001c
            L_0x0050:
                java.util.logging.Logger r4 = com.google.common.reflect.ClassPath.logger
                java.util.logging.Level r5 = java.util.logging.Level.WARNING
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "malformed classpath entry: "
                r6.append(r7)
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r4.log(r5, r2, r3)
                goto L_0x001c
            L_0x006b:
                com.google.common.collect.ImmutableList r0 = r0.build()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.ClassPath.Scanner.parseJavaClassPath():com.google.common.collect.ImmutableList");
        }

        static URL getClassPathEntry(File file, String str) throws MalformedURLException {
            return new URL(file.toURI().toURL(), str);
        }
    }

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.resources = immutableSet;
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        DefaultScanner defaultScanner = new DefaultScanner();
        defaultScanner.scan(classLoader);
        return new ClassPath(defaultScanner.getResources());
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.resources;
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from((Iterable<E>) this.resources).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from((Iterable<E>) this.resources).filter(ClassInfo.class).filter(IS_TOP_LEVEL).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        Builder builder = ImmutableSet.builder();
        UnmodifiableIterator it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = (ClassInfo) it.next();
            if (classInfo.getPackageName().equals(str)) {
                builder.add((Object) classInfo);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        String sb2 = sb.toString();
        Builder builder = ImmutableSet.builder();
        UnmodifiableIterator it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo classInfo = (ClassInfo) it.next();
            if (classInfo.getName().startsWith(sb2)) {
                builder.add((Object) classInfo);
            }
        }
        return builder.build();
    }

    static String getClassName(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    static File toFile(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }
}
