package okhttp3.internal.platform;

import android.os.Build;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.platform.android.UtilKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J-\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\u001b\u001a\r\u0012\t\u0012\u00070\u001c¢\u0006\u0002\b\u001d0\u0006H\u0016J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u00100\u001a\u000201H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "api23IsCleartextTrafficPermitted", "", "hostname", "", "networkPolicyClass", "Ljava/lang/Class;", "networkSecurityPolicy", "", "api24IsCleartextTrafficPermitted", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: AndroidPlatform.kt */
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean isAndroid;
    /* access modifiers changed from: private */
    public static final boolean isSupported;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    public AndroidPlatform() {
        SocketAdapter[] socketAdapterArr = {StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, (String) null, 1, (Object) null), ConscryptSocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter("com.google.android.gms.org.conscrypt")};
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.listOfNotNull((T[]) socketAdapterArr)) {
            if (((SocketAdapter) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.socketAdapters = (List) arrayList;
        this.closeGuard = CloseGuard.Companion.get();
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        Intrinsics.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(sSLSocketFactory, "sslSocketFactory");
        Iterator it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SocketAdapter) obj).matchesSocketFactory(sSLSocketFactory)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.trustManager(sSLSocketFactory);
        }
        return null;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        Iterator it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sSLSocket, str, list);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SocketAdapter) obj).matchesSocket(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) obj;
        if (socketAdapter != null) {
            return socketAdapter.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    public void log(String str, int i, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        UtilKt.androidLog(i, str, th);
    }

    public Object getStackTraceForCloseable(String str) {
        Intrinsics.checkParameterIsNotNull(str, "closer");
        return this.closeGuard.createAndOpen(str);
    }

    public void logCloseableLeak(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        if (!this.closeGuard.warnIfOpen(obj)) {
            Platform.log$default(this, str, 5, (Throwable) null, 4, (Object) null);
        }
    }

    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(cls, "networkPolicyClass");
            Intrinsics.checkExpressionValueIsNotNull(invoke, "networkSecurityPolicy");
            return api24IsCleartextTrafficPermitted(str, cls, invoke);
        } catch (ClassNotFoundException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (NoSuchMethodException unused2) {
            return super.isCleartextTrafficPermitted(str);
        } catch (IllegalAccessException e) {
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            throw new AssertionError("unable to determine cleartext support", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("unable to determine cleartext support", e3);
        }
    }

    private final boolean api24IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            Object invoke = cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str});
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (NoSuchMethodException unused) {
            return api23IsCleartextTrafficPermitted(str, cls, obj);
        }
    }

    private final boolean api23IsCleartextTrafficPermitted(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            Object invoke = cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0]);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        } catch (NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        AndroidCertificateChainCleaner build = AndroidCertificateChainCleaner.Companion.build(x509TrustManager);
        return build != null ? build : super.buildCertificateChainCleaner(x509TrustManager);
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AndroidPlatform.kt */
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int i, Object obj) {
            if ((i & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((i & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        public final CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Intrinsics.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(x509TrustManager, method);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.areEqual((Object) this.trustManager, (Object) customTrustRootIndex.trustManager) && Intrinsics.areEqual((Object) this.findByIssuerAndSignatureMethod, (Object) customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.trustManager;
            int i = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.findByIssuerAndSignatureMethod;
            if (method != null) {
                i = method.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ")";
        }

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Intrinsics.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            Intrinsics.checkParameterIsNotNull(x509Certificate, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[]{x509Certificate});
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isAndroid", "", "()Z", "isSupported", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: AndroidPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isAndroid() {
            return AndroidPlatform.isAndroid;
        }

        public final boolean isSupported() {
            return AndroidPlatform.isSupported;
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new AndroidPlatform();
            }
            return null;
        }
    }

    static {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            if (Build.VERSION.SDK_INT > 0) {
                z = true;
                isAndroid = z;
                if (!z) {
                    z2 = false;
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        z3 = true;
                    }
                    if (!z3) {
                        throw new IllegalStateException(("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT).toString());
                    }
                }
                isSupported = z2;
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        } catch (ClassNotFoundException | UnsatisfiedLinkError unused) {
            z = false;
        }
    }
}
