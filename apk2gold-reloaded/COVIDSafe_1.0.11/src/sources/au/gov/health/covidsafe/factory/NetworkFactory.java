package au.gov.health.covidsafe.factory;

import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/factory/NetworkFactory;", "", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: NetworkFactory.kt */
public interface NetworkFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lau/gov/health/covidsafe/factory/NetworkFactory$Companion;", "", "()V", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "getAwsClient", "()Lau/gov/health/covidsafe/networking/service/AwsClient;", "awsClient$delegate", "Lkotlin/Lazy;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: NetworkFactory.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        private static final Lazy awsClient$delegate = LazyKt.lazy(NetworkFactory$Companion$awsClient$2.INSTANCE);
        /* access modifiers changed from: private */
        public static final HttpLoggingInterceptor logging = new HttpLoggingInterceptor(null, 1, null).setLevel(Level.BODY);
        private static final Lazy okHttpClient$delegate;

        public final AwsClient getAwsClient() {
            return (AwsClient) awsClient$delegate.getValue();
        }

        public final OkHttpClient getOkHttpClient() {
            return (OkHttpClient) okHttpClient$delegate.getValue();
        }

        static {
            Companion companion = new Companion();
            $$INSTANCE = companion;
            okHttpClient$delegate = LazyKt.lazy(new NetworkFactory$Companion$okHttpClient$2(companion));
        }

        private Companion() {
        }
    }
}
