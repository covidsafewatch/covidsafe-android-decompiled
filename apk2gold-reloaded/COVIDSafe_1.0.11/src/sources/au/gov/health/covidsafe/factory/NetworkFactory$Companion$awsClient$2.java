package au.gov.health.covidsafe.factory;

import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: NetworkFactory.kt */
final class NetworkFactory$Companion$awsClient$2 extends Lambda implements Function0<AwsClient> {
    public static final NetworkFactory$Companion$awsClient$2 INSTANCE = new NetworkFactory$Companion$awsClient$2();

    NetworkFactory$Companion$awsClient$2() {
        super(0);
    }

    public final AwsClient invoke() {
        return (AwsClient) RetrofitServiceGenerator.INSTANCE.createService(AwsClient.class);
    }
}
