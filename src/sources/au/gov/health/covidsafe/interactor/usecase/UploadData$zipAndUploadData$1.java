package au.gov.health.covidsafe.interactor.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00030\u00060\u0005H@"}, d2 = {"zipAndUploadData", "", "uploadLink", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.interactor.usecase.UploadData", f = "UploadData.kt", i = {0, 0, 0, 0, 0}, l = {71}, m = "zipAndUploadData", n = {"this", "uploadLink", "exportedData", "jsonData", "request"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: UploadData.kt */
final class UploadData$zipAndUploadData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadData$zipAndUploadData$1(UploadData uploadData, Continuation continuation) {
        super(continuation);
        this.this$0 = uploadData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.zipAndUploadData((String) null, this);
    }
}
