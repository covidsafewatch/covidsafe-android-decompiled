package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: UploadData.kt */
final class UploadData$zipAndUploadData$response$1 extends Lambda implements Function0<Response> {
    final /* synthetic */ Request $request;
    final /* synthetic */ UploadData this$0;

    UploadData$zipAndUploadData$response$1(UploadData uploadData, Request request) {
        this.this$0 = uploadData;
        this.$request = request;
        super(0);
    }

    public final Response invoke() {
        return this.this$0.okHttpClient.newCall(this.$request).execute();
    }
}
