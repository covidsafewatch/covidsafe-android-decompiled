package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Handshake.kt */
public final class Handshake {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Handshake.class), "peerCertificates", "peerCertificates()Ljava/util/List;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final Lazy peerCertificates$delegate;
    private final TlsVersion tlsVersion;

    @JvmStatic
    public static final Handshake get(SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    @JvmStatic
    public static final Handshake get(TlsVersion tlsVersion2, CipherSuite cipherSuite2, List<? extends Certificate> list, List<? extends Certificate> list2) {
        return Companion.get(tlsVersion2, cipherSuite2, list, list2);
    }

    public final List<Certificate> peerCertificates() {
        Lazy lazy = this.peerCertificates$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
    }

    public Handshake(TlsVersion tlsVersion2, CipherSuite cipherSuite2, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkParameterIsNotNull(tlsVersion2, "tlsVersion");
        Intrinsics.checkParameterIsNotNull(cipherSuite2, "cipherSuite");
        Intrinsics.checkParameterIsNotNull(list, "localCertificates");
        Intrinsics.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.tlsVersion = tlsVersion2;
        this.cipherSuite = cipherSuite2;
        this.localCertificates = list;
        this.peerCertificates$delegate = LazyKt.lazy(function0);
    }

    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "tlsVersion", imports = {}))
    /* renamed from: -deprecated_tlsVersion  reason: not valid java name */
    public final TlsVersion m1091deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cipherSuite", imports = {}))
    /* renamed from: -deprecated_cipherSuite  reason: not valid java name */
    public final CipherSuite m1086deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerCertificates", imports = {}))
    /* renamed from: -deprecated_peerCertificates  reason: not valid java name */
    public final List<Certificate> m1089deprecated_peerCertificates() {
        return peerCertificates();
    }

    public final Principal peerPrincipal() {
        Object firstOrNull = CollectionsKt.firstOrNull(peerCertificates());
        X500Principal x500Principal = null;
        if (!(firstOrNull instanceof X509Certificate)) {
            firstOrNull = null;
        }
        X509Certificate x509Certificate = (X509Certificate) firstOrNull;
        if (x509Certificate != null) {
            x500Principal = x509Certificate.getSubjectX500Principal();
        }
        return x500Principal;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "peerPrincipal", imports = {}))
    /* renamed from: -deprecated_peerPrincipal  reason: not valid java name */
    public final Principal m1090deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localCertificates", imports = {}))
    /* renamed from: -deprecated_localCertificates  reason: not valid java name */
    public final List<Certificate> m1087deprecated_localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object firstOrNull = CollectionsKt.firstOrNull(this.localCertificates);
        X500Principal x500Principal = null;
        if (!(firstOrNull instanceof X509Certificate)) {
            firstOrNull = null;
        }
        X509Certificate x509Certificate = (X509Certificate) firstOrNull;
        if (x509Certificate != null) {
            x500Principal = x509Certificate.getSubjectX500Principal();
        }
        return x500Principal;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "localPrincipal", imports = {}))
    /* renamed from: -deprecated_localPrincipal  reason: not valid java name */
    public final Principal m1088deprecated_localPrincipal() {
        return localPrincipal();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            return handshake.tlsVersion == this.tlsVersion && Intrinsics.areEqual((Object) handshake.cipherSuite, (Object) this.cipherSuite) && Intrinsics.areEqual((Object) handshake.peerCertificates(), (Object) peerCertificates()) && Intrinsics.areEqual((Object) handshake.localCertificates, (Object) this.localCertificates);
        }
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public String toString() {
        String str;
        try {
            Iterable<Certificate> peerCertificates = peerCertificates();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(peerCertificates, 10));
            for (Certificate name : peerCertificates) {
                arrayList.add(getName(name));
            }
            str = ((List) arrayList).toString();
        } catch (SSLPeerUnverifiedException unused) {
            str = "Failed: SSLPeerUnverifiedException";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(str);
        sb.append(' ');
        sb.append("localCertificates=");
        Iterable<Certificate> iterable = this.localCertificates;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Certificate name2 : iterable) {
            arrayList2.add(getName(name2));
        }
        sb.append((List) arrayList2);
        sb.append('}');
        return sb.toString();
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0011\u0010\u0010\u001a\u00020\u0004*\u00020\u0006H\u0007¢\u0006\u0002\b\u0003J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokhttp3/Handshake$Companion;", "", "()V", "get", "Lokhttp3/Handshake;", "sslSession", "Ljavax/net/ssl/SSLSession;", "-deprecated_get", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "peerCertificates", "", "Ljava/security/cert/Certificate;", "localCertificates", "handshake", "toImmutableList", "", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Handshake.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Handshake get(SSLSession sSLSession) throws IOException {
            List<Certificate> list;
            Intrinsics.checkParameterIsNotNull(sSLSession, "$this$handshake");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite != null) {
                int hashCode = cipherSuite.hashCode();
                if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                    throw new IOException("cipherSuite == " + cipherSuite);
                }
                CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
                String protocol = sSLSession.getProtocol();
                if (protocol == null) {
                    throw new IllegalStateException("tlsVersion == null".toString());
                } else if (!Intrinsics.areEqual((Object) "NONE", (Object) protocol)) {
                    TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
                    try {
                        list = toImmutableList(sSLSession.getPeerCertificates());
                    } catch (SSLPeerUnverifiedException unused) {
                        list = CollectionsKt.emptyList();
                    }
                    return new Handshake(forJavaName2, forJavaName, toImmutableList(sSLSession.getLocalCertificates()), new Handshake$Companion$handshake$1(list));
                } else {
                    throw new IOException("tlsVersion == NONE");
                }
            } else {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            if (certificateArr != null) {
                return Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length));
            }
            return CollectionsKt.emptyList();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sslSession.handshake()", imports = {}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final Handshake m1092deprecated_get(SSLSession sSLSession) throws IOException {
            Intrinsics.checkParameterIsNotNull(sSLSession, "sslSession");
            return get(sSLSession);
        }

        @JvmStatic
        public final Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<? extends Certificate> list, List<? extends Certificate> list2) {
            Intrinsics.checkParameterIsNotNull(tlsVersion, "tlsVersion");
            Intrinsics.checkParameterIsNotNull(cipherSuite, "cipherSuite");
            Intrinsics.checkParameterIsNotNull(list, "peerCertificates");
            Intrinsics.checkParameterIsNotNull(list2, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(list2), new Handshake$Companion$get$1(Util.toImmutableList(list)));
        }
    }
}
