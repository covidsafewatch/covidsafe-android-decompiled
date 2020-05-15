package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "verifySignature", "toVerify", "Ljava/security/cert/X509Certificate;", "signingCert", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: BasicCertificateChainCleaner.kt */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex2) {
        Intrinsics.checkParameterIsNotNull(trustRootIndex2, "trustRootIndex");
        this.trustRootIndex = trustRootIndex2;
    }

    public List<Certificate> clean(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(list, "chain");
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        Deque arrayDeque = new ArrayDeque(list);
        List<Certificate> arrayList = new ArrayList<>();
        Object removeFirst = arrayDeque.removeFirst();
        Intrinsics.checkExpressionValueIsNotNull(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        int i = 0;
        boolean z = false;
        while (i < 9) {
            Certificate certificate = arrayList.get(arrayList.size() - 1);
            if (certificate != null) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                X509Certificate findByIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature(x509Certificate);
                if (findByIssuerAndSignature != null) {
                    if (arrayList.size() > 1 || (!Intrinsics.areEqual((Object) x509Certificate, (Object) findByIssuerAndSignature))) {
                        arrayList.add(findByIssuerAndSignature);
                    }
                    if (verifySignature(findByIssuerAndSignature, findByIssuerAndSignature)) {
                        return arrayList;
                    }
                    z = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    Intrinsics.checkExpressionValueIsNotNull(it, "queue.iterator()");
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            X509Certificate x509Certificate2 = (X509Certificate) next;
                            if (verifySignature(x509Certificate, x509Certificate2)) {
                                it.remove();
                                arrayList.add(x509Certificate2);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                        }
                    }
                    if (z) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                i++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics.areEqual((Object) x509Certificate.getIssuerDN(), (Object) x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasicCertificateChainCleaner) || !Intrinsics.areEqual((Object) ((BasicCertificateChainCleaner) obj).trustRootIndex, (Object) this.trustRootIndex)) {
            return false;
        }
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "()V", "MAX_SIGNERS", "", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: BasicCertificateChainCleaner.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
