package okhttp3;

import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: CertificatePinner.kt */
final class CertificatePinner$check$1 extends Lambda implements Function0<List<? extends X509Certificate>> {
    final /* synthetic */ String $hostname;
    final /* synthetic */ List $peerCertificates;
    final /* synthetic */ CertificatePinner this$0;

    CertificatePinner$check$1(CertificatePinner certificatePinner, List list, String str) {
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
        super(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0 != null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.security.cert.X509Certificate> invoke() {
        /*
            r3 = this;
            okhttp3.CertificatePinner r0 = r3.this$0
            okhttp3.internal.tls.CertificateChainCleaner r0 = r0.getCertificateChainCleaner$okhttp()
            if (r0 == 0) goto L_0x0013
            java.util.List r1 = r3.$peerCertificates
            java.lang.String r2 = r3.$hostname
            java.util.List r0 = r0.clean(r1, r2)
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            java.util.List r0 = r3.$peerCertificates
        L_0x0015:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0028:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r0.next()
            java.security.cert.Certificate r2 = (java.security.cert.Certificate) r2
            if (r2 == 0) goto L_0x003c
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            r1.add(r2)
            goto L_0x0028
        L_0x003c:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.CertificatePinner$check$1.invoke():java.util.List");
    }
}
