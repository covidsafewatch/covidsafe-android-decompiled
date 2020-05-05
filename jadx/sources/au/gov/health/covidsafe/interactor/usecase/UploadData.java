package au.gov.health.covidsafe.interactor.usecase;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import au.gov.health.covidsafe.interactor.UseCase;
import au.gov.health.covidsafe.networking.service.AwsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Metadata(
    bv = {1, 0, 3},
    d1 =
        {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ)\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"},
    d2 =
        {"Lau/gov/health/covidsafe/interactor/usecase/UploadData;",
         "Lau/gov/health/covidsafe/interactor/UseCase;",
         "Lau/gov/health/covidsafe/interactor/UseCase$None;",
         "",
         "awsClient",
         "Lau/gov/health/covidsafe/networking/service/AwsClient;",
         "okHttpClient",
         "Lokhttp3/OkHttpClient;",
         "context",
         "Landroid/content/Context;",
         "lifecycle",
         "Landroidx/lifecycle/Lifecycle;",
         "(Lau/gov/health/covidsafe/networking/service/AwsClient;Lokhttp3/OkHttpClient;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V",
         "TAG",
         "run",
         "Lau/gov/health/covidsafe/interactor/Either;",
         "Ljava/lang/Exception;",
         "Lkotlin/Exception;",
         "params",
         "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;",
         "zipAndUploadData",
         "uploadLink",
         "app_release"},
    k = 1, mv = {1, 1, 16})
/* compiled from: UploadData.kt */
public final class UploadData extends UseCase<UseCase.None, String> {
  private final String TAG;
  /* access modifiers changed from: private */
  public final AwsClient awsClient;
  private final Context context;
  /* access modifiers changed from: private */
  public final OkHttpClient okHttpClient;

  /* JADX INFO: super call moved to the top of the method (can break code
   * semantics) */
  public UploadData(AwsClient awsClient2, OkHttpClient okHttpClient2,
                    Context context2, Lifecycle lifecycle) {
    super(lifecycle);
    Intrinsics.checkParameterIsNotNull(awsClient2, "awsClient");
    Intrinsics.checkParameterIsNotNull(okHttpClient2, "okHttpClient");
    Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
    this.awsClient = awsClient2;
    this.okHttpClient = okHttpClient2;
    this.context = context2;
    String simpleName = getClass().getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(simpleName,
                                             "this.javaClass.simpleName");
    this.TAG = simpleName;
  }

  /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
  /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[Catch:{
   * Exception -> 0x0046 }] */
  /* JADX WARNING: Removed duplicated region for block: B:33:0x00a5 A[Catch:{
   * Exception -> 0x0046 }] */
  /* JADX WARNING: Removed duplicated region for block: B:63:0x0126 A[RETURN] */
  /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
  /* Code decompiled incorrectly, please refer to instructions dump. */
  public java.lang.Object
  run(java.lang.String r11,
      kotlin.coroutines.Continuation<
          ? super au.gov.health.covidsafe.interactor.Either<
                ? extends java.lang.Exception,
                          au.gov.health.covidsafe.interactor.UseCase.None>>
          r12) {
    /*
        r10 = this;
        boolean r0 = r12 instanceof
    au.gov.health.covidsafe.interactor.usecase.UploadData$run$1 if (r0 == 0)
    goto L_0x0014 r0 = r12
        au.gov.health.covidsafe.interactor.usecase.UploadData$run$1 r0 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData$run$1) r0 int r1 =
    r0.label r2 = -2147483648(0xffffffff80000000, float:-0.0) r1 = r1 & r2 if
    (r1 == 0) goto L_0x0014 int r12 = r0.label int r12 = r12 - r2 r0.label = r12
        goto L_0x0019
    L_0x0014:
        au.gov.health.covidsafe.interactor.usecase.UploadData$run$1 r0 = new
    au.gov.health.covidsafe.interactor.usecase.UploadData$run$1 r0.<init>(r10,
    r12) L_0x0019: java.lang.Object r12 = r0.result java.lang.Object r1 =
    kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() int r2 =
    r0.label r3 = 2 r4 = 1 if (r2 == 0) goto L_0x006e if (r2 == r4) goto
    L_0x0051 if (r2 != r3) goto L_0x0049 java.lang.Object r11 = r0.L$5
        java.lang.String r11 = (java.lang.String) r11
        java.lang.Object r11 = r0.L$4
        retrofit2.Response r11 = (retrofit2.Response) r11
        java.lang.Object r11 = r0.L$3
        java.lang.String r11 = (java.lang.String) r11
        java.lang.Object r11 = r0.L$2
        java.lang.String r11 = (java.lang.String) r11
        java.lang.Object r11 = r0.L$1
        java.lang.String r11 = (java.lang.String) r11
        java.lang.Object r11 = r0.L$0
        au.gov.health.covidsafe.interactor.usecase.UploadData r11 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData) r11
        kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0046 }
        goto L_0x00ea
    L_0x0046:
        r12 = move-exception
        goto L_0x011c
    L_0x0049:
        java.lang.IllegalStateException r11 = new
    java.lang.IllegalStateException java.lang.String r12 = "call to 'resume'
    before 'invoke' with coroutine" r11.<init>(r12) throw r11 L_0x0051:
        java.lang.Object r11 = r0.L$3
        java.lang.String r11 = (java.lang.String) r11
        java.lang.Object r2 = r0.L$2
        java.lang.String r2 = (java.lang.String) r2
        java.lang.Object r5 = r0.L$1
        java.lang.String r5 = (java.lang.String) r5
        java.lang.Object r6 = r0.L$0
        au.gov.health.covidsafe.interactor.usecase.UploadData r6 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData) r6
        kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x006a }
        r9 = r12
        r12 = r11
        r11 = r6
        r6 = r2
        r2 = r9
        goto L_0x0096
    L_0x006a:
        r12 = move-exception
        r11 = r6
        goto L_0x011c
    L_0x006e:
        kotlin.ResultKt.throwOnFailure(r12)
        au.gov.health.covidsafe.Preference r12 =
    au.gov.health.covidsafe.Preference.INSTANCE android.content.Context r2 =
    r10.context java.lang.String r12 = r12.getEncrypterJWTToken(r2) if (r12 ==
    0) goto L_0x0127
        au.gov.health.covidsafe.interactor.usecase.UploadData$run$$inlined$let$lambda$1
    r2 = new
    au.gov.health.covidsafe.interactor.usecase.UploadData$run$$inlined$let$lambda$1
    // Catch:{ Exception -> 0x011a } r2.<init>(r12, r10, r0, r11)     // Catch:{
    Exception -> 0x011a } kotlin.jvm.functions.Function0 r2 =
    (kotlin.jvm.functions.Function0) r2     // Catch:{ Exception -> 0x011a }
        r0.L$0 = r10     // Catch:{ Exception -> 0x011a }
        r0.L$1 = r11     // Catch:{ Exception -> 0x011a }
        r0.L$2 = r12     // Catch:{ Exception -> 0x011a }
        r0.L$3 = r12     // Catch:{ Exception -> 0x011a }
        r0.label = r4     // Catch:{ Exception -> 0x011a }
        java.lang.Object r2 = r10.retryRetrofitCall(r2, r0)     // Catch:{
    Exception -> 0x011a } if (r2 != r1) goto L_0x0093 return r1 L_0x0093: r5 =
    r11 r6 = r12 r11 = r10 L_0x0096: retrofit2.Response r2 =
    (retrofit2.Response) r2     // Catch:{ Exception -> 0x0046 } if (r2 != 0)
    goto L_0x00a5 au.gov.health.covidsafe.interactor.Failure r12 = new
    au.gov.health.covidsafe.interactor.Failure     // Catch:{ Exception ->
    0x0046 }
        au.gov.health.covidsafe.interactor.usecase.UploadDataException$UploadDataIncorrectPinException
    r0 =
    au.gov.health.covidsafe.interactor.usecase.UploadDataException.UploadDataIncorrectPinException.INSTANCE
    // Catch:{ Exception -> 0x0046 } r12.<init>(r0)     // Catch:{ Exception ->
    0x0046 } au.gov.health.covidsafe.interactor.Either r12 =
    (au.gov.health.covidsafe.interactor.Either) r12     // Catch:{ Exception ->
    0x0046 } goto L_0x0124 L_0x00a5: boolean r7 = r2.isSuccessful()     //
    Catch:{ Exception -> 0x0046 } if (r7 == 0) goto L_0x00ed java.lang.Object r7
    = r2.body()     // Catch:{ Exception -> 0x0046 }
        au.gov.health.covidsafe.networking.response.InitiateUploadResponse r7 =
    (au.gov.health.covidsafe.networking.response.InitiateUploadResponse) r7 //
    Catch:{ Exception -> 0x0046 } if (r7 == 0) goto L_0x00b8 java.lang.String r7
    = r7.getUploadLink()     // Catch:{ Exception -> 0x0046 } goto L_0x00b9
    L_0x00b8:
        r7 = 0
    L_0x00b9:
        r8 = r7
        java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{
    Exception -> 0x0046 } if (r8 == 0) goto L_0x00c6 int r8 = r8.length()     //
    Catch:{ Exception -> 0x0046 } if (r8 != 0) goto L_0x00c5 goto L_0x00c6
    L_0x00c5:
        r4 = 0
    L_0x00c6:
        if (r4 == 0) goto L_0x00d5
        au.gov.health.covidsafe.interactor.Failure r12 = new
    au.gov.health.covidsafe.interactor.Failure     // Catch:{ Exception ->
    0x0046 } java.lang.Exception r0 = new java.lang.Exception     // Catch:{
    Exception -> 0x0046 } r0.<init>()     // Catch:{ Exception -> 0x0046 }
        r12.<init>(r0)     // Catch:{ Exception -> 0x0046 }
        au.gov.health.covidsafe.interactor.Either r12 =
    (au.gov.health.covidsafe.interactor.Either) r12     // Catch:{ Exception ->
    0x0046 } goto L_0x0124 L_0x00d5: r0.L$0 = r11     // Catch:{ Exception ->
    0x0046 } r0.L$1 = r5     // Catch:{ Exception -> 0x0046 } r0.L$2 = r6     //
    Catch:{ Exception -> 0x0046 } r0.L$3 = r12     // Catch:{ Exception ->
    0x0046 } r0.L$4 = r2     // Catch:{ Exception -> 0x0046 } r0.L$5 = r7     //
    Catch:{ Exception -> 0x0046 } r0.label = r3     // Catch:{ Exception ->
    0x0046 } java.lang.Object r12 = r11.zipAndUploadData(r7, r0)     // Catch:{
    Exception -> 0x0046 } if (r12 != r1) goto L_0x00ea return r1 L_0x00ea:
        au.gov.health.covidsafe.interactor.Either r12 =
    (au.gov.health.covidsafe.interactor.Either) r12     // Catch:{ Exception ->
    0x0046 } goto L_0x0124 L_0x00ed: int r12 = r2.code()     // Catch:{
    Exception -> 0x0046 } r0 = 400(0x190, float:5.6E-43) if (r12 != r0) goto
    L_0x00fd au.gov.health.covidsafe.interactor.Failure r12 = new
    au.gov.health.covidsafe.interactor.Failure     // Catch:{ Exception ->
    0x0046 }
        au.gov.health.covidsafe.interactor.usecase.UploadDataException$UploadDataIncorrectPinException
    r0 =
    au.gov.health.covidsafe.interactor.usecase.UploadDataException.UploadDataIncorrectPinException.INSTANCE
    // Catch:{ Exception -> 0x0046 } r12.<init>(r0)     // Catch:{ Exception ->
    0x0046 } goto L_0x0117 L_0x00fd: int r12 = r2.code()     // Catch:{
    Exception -> 0x0046 } r0 = 403(0x193, float:5.65E-43) if (r12 != r0) goto
    L_0x010d au.gov.health.covidsafe.interactor.Failure r12 = new
    au.gov.health.covidsafe.interactor.Failure     // Catch:{ Exception ->
    0x0046 }
        au.gov.health.covidsafe.interactor.usecase.UploadDataException$UploadDataJwtExpiredException
    r0 =
    au.gov.health.covidsafe.interactor.usecase.UploadDataException.UploadDataJwtExpiredException.INSTANCE
    // Catch:{ Exception -> 0x0046 } r12.<init>(r0)     // Catch:{ Exception ->
    0x0046 } goto L_0x0117 L_0x010d: au.gov.health.covidsafe.interactor.Failure
    r12 = new au.gov.health.covidsafe.interactor.Failure     // Catch:{
    Exception -> 0x0046 } java.lang.Exception r0 = new java.lang.Exception //
    Catch:{ Exception -> 0x0046 } r0.<init>()     // Catch:{ Exception -> 0x0046
    } r12.<init>(r0)     // Catch:{ Exception -> 0x0046 } L_0x0117:
        au.gov.health.covidsafe.interactor.Either r12 =
    (au.gov.health.covidsafe.interactor.Either) r12     // Catch:{ Exception ->
    0x0046 } goto L_0x0124 L_0x011a: r12 = move-exception r11 = r10 L_0x011c:
        au.gov.health.covidsafe.interactor.Failure r0 = new
    au.gov.health.covidsafe.interactor.Failure r0.<init>(r12) r12 = r0
        au.gov.health.covidsafe.interactor.Either r12 =
    (au.gov.health.covidsafe.interactor.Either) r12 L_0x0124: if (r12 == 0) goto
    L_0x0128 return r12 L_0x0127: r11 = r10 L_0x0128:
        au.gov.health.covidsafe.interactor.usecase.UploadData r11 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData) r11
        au.gov.health.covidsafe.interactor.Failure r11 = new
    au.gov.health.covidsafe.interactor.Failure java.lang.Exception r12 = new
    java.lang.Exception r12.<init>() r11.<init>(r12) return r11
    */
    throw new UnsupportedOperationException(
        "Method not decompiled: au.gov.health.covidsafe.interactor.usecase.UploadData.run(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
  }

  /* access modifiers changed from: package-private */
  /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
  /* JADX WARNING: Removed duplicated region for block: B:21:0x00bd A[Catch:{
   * Exception -> 0x00d4 }] */
  /* JADX WARNING: Removed duplicated region for block: B:22:0x00ca A[Catch:{
   * Exception -> 0x00d4 }] */
  /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
  /* Code decompiled incorrectly, please refer to instructions dump. */
  public final /* synthetic */ java.lang.Object zipAndUploadData(
      java.lang.String r8,
      kotlin.coroutines.Continuation<
          ? super au.gov.health.covidsafe.interactor.Either<
                ? extends java.lang.Exception,
                          au.gov.health.covidsafe.interactor.UseCase.None>>
          r9) {
    /*
        r7 = this;
        boolean r0 = r9 instanceof
    au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$1 if
    (r0 == 0) goto L_0x0014 r0 = r9
        au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$1
    r0 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$1)
    r0 int r1 = r0.label r2 = -2147483648(0xffffffff80000000, float:-0.0) r1 =
    r1 & r2 if (r1 == 0) goto L_0x0014 int r9 = r0.label int r9 = r9 - r2
        r0.label = r9
        goto L_0x0019
    L_0x0014:
        au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$1
    r0 = new
    au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$1
        r0.<init>(r7, r9)
    L_0x0019:
        java.lang.Object r9 = r0.result
        java.lang.Object r1 =
    kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() int r2 =
    r0.label r3 = 1 if (r2 == 0) goto L_0x0046 if (r2 != r3) goto L_0x003e
        java.lang.Object r8 = r0.L$4
        okhttp3.Request r8 = (okhttp3.Request) r8
        java.lang.Object r8 = r0.L$3
        java.lang.String r8 = (java.lang.String) r8
        java.lang.Object r8 = r0.L$2
        au.gov.health.covidsafe.ui.upload.model.ExportData r8 =
    (au.gov.health.covidsafe.ui.upload.model.ExportData) r8 java.lang.Object r8
    = r0.L$1 java.lang.String r8 = (java.lang.String) r8 java.lang.Object r8 =
    r0.L$0 au.gov.health.covidsafe.interactor.usecase.UploadData r8 =
    (au.gov.health.covidsafe.interactor.usecase.UploadData) r8
        kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x00d4 }
        goto L_0x00b9
    L_0x003e:
        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
        r8.<init>(r9)
        throw r8
    L_0x0046:
        kotlin.ResultKt.throwOnFailure(r9)
        au.gov.health.covidsafe.ui.upload.model.ExportData r9 = new
    au.gov.health.covidsafe.ui.upload.model.ExportData
        au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage
    r2 = new
    au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage
        au.gov.health.covidsafe.TracerApp$Companion r4 =
    au.gov.health.covidsafe.TracerApp.Companion android.content.Context r4 =
    r4.getAppContext() r2.<init>(r4) java.util.List r2 = r2.getAllRecords()
        r9.<init>(r2)
        au.gov.health.covidsafe.logging.CentralLog$Companion r2 =
    au.gov.health.covidsafe.logging.CentralLog.Companion java.lang.String r4 =
    r7.TAG java.lang.StringBuilder r5 = new java.lang.StringBuilder r5.<init>()
        java.lang.String r6 = "records: "
        r5.append(r6)
        java.util.List r6 = r9.getRecords()
        r5.append(r6)
        java.lang.String r5 = r5.toString()
        r2.d(r4, r5)
        com.google.gson.Gson r2 = new com.google.gson.Gson
        r2.<init>()
        java.lang.String r2 = r2.toJson((java.lang.Object) r9)
        okhttp3.Request$Builder r4 = new okhttp3.Request$Builder
        r4.<init>()
        okhttp3.Request$Builder r4 = r4.url((java.lang.String) r8)
        okhttp3.RequestBody$Companion r5 = okhttp3.RequestBody.Companion
        java.lang.String r6 = "jsonData"
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
        r6 = 0
        okhttp3.RequestBody r5 = r5.create((java.lang.String) r2,
    (okhttp3.MediaType) r6) okhttp3.Request$Builder r4 = r4.put(r5)
        okhttp3.Request r4 = r4.build()
        au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$response$1
    r5 = new
    au.gov.health.covidsafe.interactor.usecase.UploadData$zipAndUploadData$response$1
    // Catch:{ Exception -> 0x00d4 } r5.<init>(r7, r4)     // Catch:{ Exception
    -> 0x00d4 } kotlin.jvm.functions.Function0 r5 =
    (kotlin.jvm.functions.Function0) r5     // Catch:{ Exception -> 0x00d4 }
        r0.L$0 = r7     // Catch:{ Exception -> 0x00d4 }
        r0.L$1 = r8     // Catch:{ Exception -> 0x00d4 }
        r0.L$2 = r9     // Catch:{ Exception -> 0x00d4 }
        r0.L$3 = r2     // Catch:{ Exception -> 0x00d4 }
        r0.L$4 = r4     // Catch:{ Exception -> 0x00d4 }
        r0.label = r3     // Catch:{ Exception -> 0x00d4 }
        java.lang.Object r9 = r7.retryOkhttpCall(r5, r0)     // Catch:{
    Exception -> 0x00d4 } if (r9 != r1) goto L_0x00b9 return r1 L_0x00b9:
        okhttp3.Response r9 = (okhttp3.Response) r9     // Catch:{ Exception ->
    0x00d4 } if (r9 != 0) goto L_0x00ca
        au.gov.health.covidsafe.interactor.Failure r8 = new
    au.gov.health.covidsafe.interactor.Failure     // Catch:{ Exception ->
    0x00d4 } java.lang.Exception r9 = new java.lang.Exception     // Catch:{
    Exception -> 0x00d4 } r9.<init>()     // Catch:{ Exception -> 0x00d4 }
        r8.<init>(r9)     // Catch:{ Exception -> 0x00d4 }
        au.gov.health.covidsafe.interactor.Either r8 =
    (au.gov.health.covidsafe.interactor.Either) r8     // Catch:{ Exception ->
    0x00d4 } goto L_0x00d3 L_0x00ca: au.gov.health.covidsafe.interactor.Success
    r8 = new au.gov.health.covidsafe.interactor.Success     // Catch:{ Exception
    -> 0x00d4 } au.gov.health.covidsafe.interactor.UseCase$None r9 =
    au.gov.health.covidsafe.interactor.UseCase.None.INSTANCE     // Catch:{
    Exception -> 0x00d4 } r8.<init>(r9)     // Catch:{ Exception -> 0x00d4 }
        au.gov.health.covidsafe.interactor.Either r8 =
    (au.gov.health.covidsafe.interactor.Either) r8     // Catch:{ Exception ->
    0x00d4 } L_0x00d3: return r8 L_0x00d4:
        au.gov.health.covidsafe.interactor.Failure r8 = new
    au.gov.health.covidsafe.interactor.Failure java.lang.Exception r9 = new
    java.lang.Exception r9.<init>() r8.<init>(r9) return r8
    */
    throw new UnsupportedOperationException(
        "Method not decompiled: au.gov.health.covidsafe.interactor.usecase.UploadData.zipAndUploadData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
  }
}
