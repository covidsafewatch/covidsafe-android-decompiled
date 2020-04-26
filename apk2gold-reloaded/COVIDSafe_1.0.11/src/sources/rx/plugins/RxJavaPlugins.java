package rx.plugins;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {
    };
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    RxJavaPlugins() {
    }

    public void reset() {
        INSTANCE.errorHandler.set(null);
        INSTANCE.observableExecutionHook.set(null);
        INSTANCE.singleExecutionHook.set(null);
        INSTANCE.completableExecutionHook.set(null);
        INSTANCE.schedulersHook.set(null);
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaErrorHandler.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
            } else {
                this.errorHandler.compareAndSet(null, (RxJavaErrorHandler) pluginImplementationViaProperty);
            }
        }
        return (RxJavaErrorHandler) this.errorHandler.get();
    }

    public void registerErrorHandler(RxJavaErrorHandler rxJavaErrorHandler) {
        if (!this.errorHandler.compareAndSet(null, rxJavaErrorHandler)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Another strategy was already registered: ");
            sb.append(this.errorHandler.get());
            throw new IllegalStateException(sb.toString());
        }
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return (RxJavaObservableExecutionHook) this.observableExecutionHook.get();
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        if (!this.observableExecutionHook.compareAndSet(null, rxJavaObservableExecutionHook)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Another strategy was already registered: ");
            sb.append(this.observableExecutionHook.get());
            throw new IllegalStateException(sb.toString());
        }
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook) pluginImplementationViaProperty);
            }
        }
        return (RxJavaSingleExecutionHook) this.singleExecutionHook.get();
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        if (!this.singleExecutionHook.compareAndSet(null, rxJavaSingleExecutionHook)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Another strategy was already registered: ");
            sb.append(this.singleExecutionHook.get());
            throw new IllegalStateException(sb.toString());
        }
    }

    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.completableExecutionHook.compareAndSet(null, new RxJavaCompletableExecutionHook() {
                });
            } else {
                this.completableExecutionHook.compareAndSet(null, (RxJavaCompletableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return (RxJavaCompletableExecutionHook) this.completableExecutionHook.get();
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        if (!this.completableExecutionHook.compareAndSet(null, rxJavaCompletableExecutionHook)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Another strategy was already registered: ");
            sb.append(this.singleExecutionHook.get());
            throw new IllegalStateException(sb.toString());
        }
    }

    static Properties getSystemPropertiesSafe() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        r3 = r7.substring(0, r7.length() - 6).substring(14);
        r5 = new java.lang.StringBuilder();
        r5.append(r2);
        r5.append(r3);
        r5.append(r4);
        r2 = r5.toString();
        r11 = r11.getProperty(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0087, code lost:
        if (r11 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Implementing class declaration for ");
        r3.append(r0);
        r3.append(" missing: ");
        r3.append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a8, code lost:
        throw new java.lang.IllegalStateException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a9, code lost:
        r1 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5 A[SYNTHETIC, Splitter:B:24:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Object getPluginImplementationViaProperty(java.lang.Class<?> r10, java.util.Properties r11) {
        /*
            java.lang.Object r11 = r11.clone()
            java.util.Properties r11 = (java.util.Properties) r11
            java.lang.String r0 = r10.getSimpleName()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "rxjava.plugin."
            r1.append(r2)
            r1.append(r0)
            java.lang.String r3 = ".implementation"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r11.getProperty(r1)
            if (r1 != 0) goto L_0x00b3
            java.lang.String r3 = ".class"
            java.lang.String r4 = ".impl"
            java.util.Set r5 = r11.entrySet()     // Catch:{ SecurityException -> 0x00ab }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ SecurityException -> 0x00ab }
        L_0x0032:
            boolean r6 = r5.hasNext()     // Catch:{ SecurityException -> 0x00ab }
            if (r6 == 0) goto L_0x00b3
            java.lang.Object r6 = r5.next()     // Catch:{ SecurityException -> 0x00ab }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ SecurityException -> 0x00ab }
            java.lang.Object r7 = r6.getKey()     // Catch:{ SecurityException -> 0x00ab }
            java.lang.String r7 = r7.toString()     // Catch:{ SecurityException -> 0x00ab }
            boolean r8 = r7.startsWith(r2)     // Catch:{ SecurityException -> 0x00ab }
            if (r8 == 0) goto L_0x0032
            boolean r8 = r7.endsWith(r3)     // Catch:{ SecurityException -> 0x00ab }
            if (r8 == 0) goto L_0x0032
            java.lang.Object r6 = r6.getValue()     // Catch:{ SecurityException -> 0x00ab }
            java.lang.String r6 = r6.toString()     // Catch:{ SecurityException -> 0x00ab }
            boolean r6 = r0.equals(r6)     // Catch:{ SecurityException -> 0x00ab }
            if (r6 == 0) goto L_0x0032
            r3 = 0
            int r5 = r7.length()     // Catch:{ SecurityException -> 0x00ab }
            int r5 = r5 + -6
            java.lang.String r3 = r7.substring(r3, r5)     // Catch:{ SecurityException -> 0x00ab }
            r5 = 14
            java.lang.String r3 = r3.substring(r5)     // Catch:{ SecurityException -> 0x00ab }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x00ab }
            r5.<init>()     // Catch:{ SecurityException -> 0x00ab }
            r5.append(r2)     // Catch:{ SecurityException -> 0x00ab }
            r5.append(r3)     // Catch:{ SecurityException -> 0x00ab }
            r5.append(r4)     // Catch:{ SecurityException -> 0x00ab }
            java.lang.String r2 = r5.toString()     // Catch:{ SecurityException -> 0x00ab }
            java.lang.String r11 = r11.getProperty(r2)     // Catch:{ SecurityException -> 0x00ab }
            if (r11 == 0) goto L_0x008a
            goto L_0x00b2
        L_0x008a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x00a9 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x00a9 }
            r3.<init>()     // Catch:{ SecurityException -> 0x00a9 }
            java.lang.String r4 = "Implementing class declaration for "
            r3.append(r4)     // Catch:{ SecurityException -> 0x00a9 }
            r3.append(r0)     // Catch:{ SecurityException -> 0x00a9 }
            java.lang.String r4 = " missing: "
            r3.append(r4)     // Catch:{ SecurityException -> 0x00a9 }
            r3.append(r2)     // Catch:{ SecurityException -> 0x00a9 }
            java.lang.String r2 = r3.toString()     // Catch:{ SecurityException -> 0x00a9 }
            r1.<init>(r2)     // Catch:{ SecurityException -> 0x00a9 }
            throw r1     // Catch:{ SecurityException -> 0x00a9 }
        L_0x00a9:
            r1 = move-exception
            goto L_0x00af
        L_0x00ab:
            r11 = move-exception
            r9 = r1
            r1 = r11
            r11 = r9
        L_0x00af:
            r1.printStackTrace()
        L_0x00b2:
            r1 = r11
        L_0x00b3:
            if (r1 == 0) goto L_0x0136
            java.lang.Class r11 = java.lang.Class.forName(r1)     // Catch:{ ClassCastException -> 0x0113, ClassNotFoundException -> 0x00f8, InstantiationException -> 0x00dd, IllegalAccessException -> 0x00c2 }
            java.lang.Class r10 = r11.asSubclass(r10)     // Catch:{ ClassCastException -> 0x0113, ClassNotFoundException -> 0x00f8, InstantiationException -> 0x00dd, IllegalAccessException -> 0x00c2 }
            java.lang.Object r10 = r10.newInstance()     // Catch:{ ClassCastException -> 0x0113, ClassNotFoundException -> 0x00f8, InstantiationException -> 0x00dd, IllegalAccessException -> 0x00c2 }
            return r10
        L_0x00c2:
            r10 = move-exception
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " implementation not able to be accessed: "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0, r10)
            throw r11
        L_0x00dd:
            r10 = move-exception
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " implementation not able to be instantiated: "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0, r10)
            throw r11
        L_0x00f8:
            r10 = move-exception
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " implementation class not found: "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0, r10)
            throw r11
        L_0x0113:
            r10 = move-exception
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = " implementation is not an instance of "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ": "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r11.<init>(r0, r10)
            throw r11
        L_0x0136:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.plugins.RxJavaPlugins.getPluginImplementationViaProperty(java.lang.Class, java.util.Properties):java.lang.Object");
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook) pluginImplementationViaProperty);
            }
        }
        return (RxJavaSchedulersHook) this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxJavaSchedulersHook rxJavaSchedulersHook) {
        if (!this.schedulersHook.compareAndSet(null, rxJavaSchedulersHook)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Another strategy was already registered: ");
            sb.append(this.schedulersHook.get());
            throw new IllegalStateException(sb.toString());
        }
    }
}
