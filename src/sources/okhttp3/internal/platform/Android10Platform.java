package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.Android10CertificateChainCleaner;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.UtilKt;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "getSelectedProtocol", "isCleartextTrafficPermitted", "", "log", "message", "level", "", "t", "", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Android10Platform.kt */
public final class Android10Platform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final boolean isSupported = (AndroidPlatform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29);
    private final List<SocketAdapter> socketAdapters;

    public Android10Platform() {
        SocketAdapter[] socketAdapterArr = {Android10SocketAdapter.Companion.buildIfSupported(), ConscryptSocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter("com.google.android.gms.org.conscrypt")};
        Collection arrayList = new ArrayList();
        for (Object next : CollectionsKt.listOfNotNull((T[]) socketAdapterArr)) {
            if (((SocketAdapter) next).isSupported()) {
                arrayList.add(next);
            }
        }
        this.socketAdapters = (List) arrayList;
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

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
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

    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Android10CertificateChainCleaner buildIfSupported = Android10CertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        return buildIfSupported != null ? buildIfSupported : super.buildCertificateChainCleaner(x509TrustManager);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/Android10Platform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Android10Platform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new Android10Platform();
            }
            return null;
        }
    }
}
