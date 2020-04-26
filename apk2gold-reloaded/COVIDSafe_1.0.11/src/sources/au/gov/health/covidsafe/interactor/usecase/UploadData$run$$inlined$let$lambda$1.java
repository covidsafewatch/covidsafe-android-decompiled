package au.gov.health.covidsafe.interactor.usecase;

import au.gov.health.covidsafe.networking.response.InitiateUploadResponse;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lretrofit2/Response;", "Lau/gov/health/covidsafe/networking/response/InitiateUploadResponse;", "kotlin.jvm.PlatformType", "invoke", "au/gov/health/covidsafe/interactor/usecase/UploadData$run$2$initialUploadResponse$1"}, k = 3, mv = {1, 1, 16})
/* compiled from: UploadData.kt */
final class UploadData$run$$inlined$let$lambda$1 extends Lambda implements Function0<Response<InitiateUploadResponse>> {
    final /* synthetic */ Continuation $continuation$inlined;
    final /* synthetic */ String $jwtToken;
    final /* synthetic */ String $params$inlined;
    final /* synthetic */ UploadData this$0;

    UploadData$run$$inlined$let$lambda$1(String str, UploadData uploadData, Continuation continuation, String str2) {
        this.$jwtToken = str;
        this.this$0 = uploadData;
        this.$continuation$inlined = continuation;
        this.$params$inlined = str2;
        super(0);
    }

    public final Response<InitiateUploadResponse> invoke() {
        AwsClient access$getAwsClient$p = this.this$0.awsClient;
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(this.$jwtToken);
        return access$getAwsClient$p.initiateUpload(sb.toString(), this.$params$inlined).execute();
    }
}
