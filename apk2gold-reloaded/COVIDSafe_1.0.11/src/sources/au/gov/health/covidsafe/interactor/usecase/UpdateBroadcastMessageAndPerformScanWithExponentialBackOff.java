package au.gov.health.covidsafe.interactor.usecase;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import au.gov.health.covidsafe.interactor.UseCase;
import au.gov.health.covidsafe.networking.response.BroadcastMessageResponse;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J+\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/interactor/usecase/UpdateBroadcastMessageAndPerformScanWithExponentialBackOff;", "Lau/gov/health/covidsafe/interactor/UseCase;", "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;", "Ljava/lang/Void;", "awsClient", "Lau/gov/health/covidsafe/networking/service/AwsClient;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Lau/gov/health/covidsafe/networking/service/AwsClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "RETRIES_LIMIT", "", "TAG", "", "call", "Lretrofit2/Response;", "jwtToken", "run", "Lau/gov/health/covidsafe/interactor/Either;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "params", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.kt */
public final class UpdateBroadcastMessageAndPerformScanWithExponentialBackOff extends UseCase<BroadcastMessageResponse, Void> {
    private final int RETRIES_LIMIT = 3;
    private final String TAG;
    private final AwsClient awsClient;
    private final Context context;

    public UpdateBroadcastMessageAndPerformScanWithExponentialBackOff(AwsClient awsClient2, Context context2, Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(awsClient2, "awsClient");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        super(lifecycle);
        this.awsClient = awsClient2;
        this.context = context2;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this.javaClass.simpleName");
        this.TAG = simpleName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object run(java.lang.Void r18, kotlin.coroutines.Continuation<? super au.gov.health.covidsafe.interactor.Either<? extends java.lang.Exception, au.gov.health.covidsafe.networking.response.BroadcastMessageResponse>> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1 r2 = (au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1 r2 = new au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff$run$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0052
            if (r4 != r6) goto L_0x004a
            long r7 = r2.J$0
            int r4 = r2.I$0
            java.lang.Object r7 = r2.L$4
            retrofit2.Response r7 = (retrofit2.Response) r7
            java.lang.Object r7 = r2.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r2.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.L$1
            java.lang.Void r9 = (java.lang.Void) r9
            java.lang.Object r10 = r2.L$0
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r10 = (au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff) r10
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r9
            r9 = r8
            r8 = r7
            goto L_0x009f
        L_0x004a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            au.gov.health.covidsafe.Preference r1 = au.gov.health.covidsafe.Preference.INSTANCE
            android.content.Context r4 = r0.context
            java.lang.String r1 = r1.getEncrypterJWTToken(r4)
            if (r1 == 0) goto L_0x013d
            retrofit2.Response r4 = r0.call(r1)
            r10 = r0
            r8 = r1
            r9 = r8
            r7 = r5
            r1 = r18
        L_0x0069:
            r11 = 1000(0x3e8, float:1.401E-42)
            if (r4 == 0) goto L_0x0079
            boolean r12 = r4.isSuccessful()
            if (r12 == 0) goto L_0x0079
            java.lang.Object r12 = r4.body()
            if (r12 != 0) goto L_0x00aa
        L_0x0079:
            int r12 = r10.RETRIES_LIMIT
            if (r7 >= r12) goto L_0x00aa
            r12 = 2
            double r12 = (double) r12
            double r14 = (double) r7
            double r12 = java.lang.Math.pow(r12, r14)
            long r12 = (long) r12
            long r14 = (long) r11
            long r12 = r12 * r14
            r2.L$0 = r10
            r2.L$1 = r1
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r4
            r2.I$0 = r7
            r2.J$0 = r12
            r2.label = r6
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r12, r2)
            if (r4 != r3) goto L_0x009e
            return r3
        L_0x009e:
            r4 = r7
        L_0x009f:
            retrofit2.Response r7 = r10.call(r8)
            int r4 = r4 + r6
            r16 = r7
            r7 = r4
            r4 = r16
            goto L_0x0069
        L_0x00aa:
            if (r4 == 0) goto L_0x0130
            boolean r1 = r4.isSuccessful()
            if (r1 == 0) goto L_0x0130
            java.lang.Object r1 = r4.body()
            au.gov.health.covidsafe.networking.response.BroadcastMessageResponse r1 = (au.gov.health.covidsafe.networking.response.BroadcastMessageResponse) r1
            if (r1 == 0) goto L_0x0121
            java.lang.String r2 = r1.getTempId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00c8
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00c9
        L_0x00c8:
            r5 = r6
        L_0x00c9:
            if (r5 == 0) goto L_0x00d8
            au.gov.health.covidsafe.interactor.Failure r1 = new au.gov.health.covidsafe.interactor.Failure
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            r1.<init>(r2)
            au.gov.health.covidsafe.interactor.Either r1 = (au.gov.health.covidsafe.interactor.Either) r1
            goto L_0x013c
        L_0x00d8:
            java.lang.String r2 = r1.getExpiryTime()
            r3 = 0
            if (r2 == 0) goto L_0x00eb
            java.lang.Long r2 = kotlin.text.StringsKt.toLongOrNull(r2)
            if (r2 == 0) goto L_0x00eb
            long r5 = r2.longValue()
            goto L_0x00ec
        L_0x00eb:
            r5 = r3
        L_0x00ec:
            au.gov.health.covidsafe.Preference r2 = au.gov.health.covidsafe.Preference.INSTANCE
            android.content.Context r7 = r10.context
            long r8 = (long) r11
            long r5 = r5 * r8
            r2.putExpiryTimeInMillis(r7, r5)
            java.lang.String r2 = r1.getRefreshTime()
            if (r2 == 0) goto L_0x0105
            java.lang.Long r2 = kotlin.text.StringsKt.toLongOrNull(r2)
            if (r2 == 0) goto L_0x0105
            long r3 = r2.longValue()
        L_0x0105:
            au.gov.health.covidsafe.Preference r2 = au.gov.health.covidsafe.Preference.INSTANCE
            android.content.Context r5 = r10.context
            long r3 = r3 * r8
            r2.putNextFetchTimeInMillis(r5, r3)
            au.gov.health.covidsafe.Utils r2 = au.gov.health.covidsafe.Utils.INSTANCE
            android.content.Context r3 = r10.context
            java.lang.String r4 = r1.getTempId()
            r2.storeBroadcastMessage(r3, r4)
            au.gov.health.covidsafe.interactor.Success r2 = new au.gov.health.covidsafe.interactor.Success
            r2.<init>(r1)
            r1 = r2
            au.gov.health.covidsafe.interactor.Either r1 = (au.gov.health.covidsafe.interactor.Either) r1
            goto L_0x013c
        L_0x0121:
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r10 = (au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff) r10
            au.gov.health.covidsafe.interactor.Failure r1 = new au.gov.health.covidsafe.interactor.Failure
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            r1.<init>(r2)
            au.gov.health.covidsafe.interactor.Either r1 = (au.gov.health.covidsafe.interactor.Either) r1
            goto L_0x013c
        L_0x0130:
            au.gov.health.covidsafe.interactor.Failure r1 = new au.gov.health.covidsafe.interactor.Failure
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            r1.<init>(r2)
            au.gov.health.covidsafe.interactor.Either r1 = (au.gov.health.covidsafe.interactor.Either) r1
        L_0x013c:
            return r1
        L_0x013d:
            r1 = r0
            au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff r1 = (au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff) r1
            au.gov.health.covidsafe.interactor.Failure r1 = new au.gov.health.covidsafe.interactor.Failure
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>()
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.usecase.UpdateBroadcastMessageAndPerformScanWithExponentialBackOff.run(java.lang.Void, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Response<BroadcastMessageResponse> call(String str) {
        try {
            AwsClient awsClient2 = this.awsClient;
            StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(str);
            return awsClient2.getTempId(sb.toString()).execute();
        } catch (Exception unused) {
            return null;
        }
    }
}
