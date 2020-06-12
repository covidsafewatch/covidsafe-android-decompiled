package au.gov.health.covidsafe.factory;

import android.os.Build;
import au.gov.health.covidsafe.factory.NetworkFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: NetworkFactory.kt */
final class NetworkFactory$Companion$okHttpClient$2 extends Lambda implements Function0<OkHttpClient> {
    final /* synthetic */ NetworkFactory.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetworkFactory$Companion$okHttpClient$2(NetworkFactory.Companion companion) {
        super(0);
        this.this$0 = companion;
    }

    public final OkHttpClient invoke() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().contains(NetworkFactory.Companion.logging);
        if (Build.VERSION.SDK_INT <= 23) {
            builder.certificatePinner(new CertificatePinner.Builder().add("**.aws.covidsafe.gov.au", "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=", "sha256/f0KW/FtqTjs108NpYj42SrGvOB2PpxIVM8nWxjPqJGE=", "sha256/NqvDJlas/GRcYbcWE8S/IceH9cq77kg0jVhZeAPXq8k=", "sha256/9+ze1cZgR9KO1kZrVDxA4HQ6voHRCSVNz4RdTCx4U8U=", "sha256/KwccWaCgrnaw6tsrrSO61FgLacNgG2MMLq8GE6+oP5I=").build());
        }
        return builder.build();
    }
}
