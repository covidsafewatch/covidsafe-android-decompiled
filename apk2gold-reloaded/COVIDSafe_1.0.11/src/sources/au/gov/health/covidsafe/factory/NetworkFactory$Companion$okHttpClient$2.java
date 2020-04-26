package au.gov.health.covidsafe.factory;

import au.gov.health.covidsafe.factory.NetworkFactory.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: NetworkFactory.kt */
final class NetworkFactory$Companion$okHttpClient$2 extends Lambda implements Function0<OkHttpClient> {
    final /* synthetic */ Companion this$0;

    NetworkFactory$Companion$okHttpClient$2(Companion companion) {
        this.this$0 = companion;
        super(0);
    }

    public final OkHttpClient invoke() {
        Builder builder = new Builder();
        builder.interceptors().contains(Companion.logging);
        return builder.build();
    }
}
