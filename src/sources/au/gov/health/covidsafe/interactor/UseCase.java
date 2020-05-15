package au.gov.health.covidsafe.interactor;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u00032\u00020\u0004:\u0001$B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JB\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u00122\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00020\u000f0\u0012H\u0002¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0007J\b\u0010\u0018\u001a\u00020\u000fH\u0007J#\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H \u0018\u00010\u001f\"\u0004\b\u0002\u0010 2\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H \u0018\u00010\u001f0\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ)\u0010!\u001a\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0010\u001a\u00028\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010#R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lau/gov/health/covidsafe/interactor/UseCase;", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "invoke", "", "params", "onSuccess", "Lkotlin/Function1;", "onFailure", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onDestroy", "onStop", "retryOkhttpCall", "Lokhttp3/Response;", "call", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryRetrofitCall", "Lretrofit2/Response;", "S", "run", "Lau/gov/health/covidsafe/interactor/Either;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "None", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: UseCase.kt */
public abstract class UseCase<Type, Params> implements CoroutineScope, LifecycleObserver {
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private Job job = JobKt.Job$default((Job) null, 1, (Object) null);

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public abstract Object run(Params params, Continuation<? super Either<? extends Exception, ? extends Type>> continuation);

    public UseCase(Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        lifecycle.addObserver(this);
    }

    public final void invoke(Params params, Function1<? super Type, Unit> function1, Function1<? super Exception, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "onSuccess");
        Intrinsics.checkParameterIsNotNull(function12, "onFailure");
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        this.job = BuildersKt__Builders_commonKt.launch$default(this, getCoroutineContext(), (CoroutineStart) null, new UseCase$invoke$1(this, params, function12, function1, (Continuation) null), 2, (Object) null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this, (CancellationException) null, 1, (Object) null);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093 A[RETURN] */
    protected final <S> java.lang.Object retryRetrofitCall(kotlin.jvm.functions.Function0<retrofit2.Response<S>> r11, kotlin.coroutines.Continuation<? super retrofit2.Response<S>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof au.gov.health.covidsafe.interactor.UseCase$retryRetrofitCall$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            au.gov.health.covidsafe.interactor.UseCase$retryRetrofitCall$1 r0 = (au.gov.health.covidsafe.interactor.UseCase$retryRetrofitCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            au.gov.health.covidsafe.interactor.UseCase$retryRetrofitCall$1 r0 = new au.gov.health.covidsafe.interactor.UseCase$retryRetrofitCall$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            long r4 = r0.J$0
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$2
            retrofit2.Response r2 = (retrofit2.Response) r2
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r4 = r0.L$0
            au.gov.health.covidsafe.interactor.UseCase r4 = (au.gov.health.covidsafe.interactor.UseCase) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x008b
        L_0x003d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.invoke()
            retrofit2.Response r12 = (retrofit2.Response) r12
            r2 = 0
            r4 = r10
        L_0x0050:
            if (r12 == 0) goto L_0x0066
            boolean r5 = r12.isSuccessful()
            if (r5 != 0) goto L_0x0060
            int r5 = r12.code()
            r6 = 403(0x193, float:5.65E-43)
            if (r5 != r6) goto L_0x0066
        L_0x0060:
            java.lang.Object r5 = r12.body()
            if (r5 != 0) goto L_0x0093
        L_0x0066:
            int r5 = au.gov.health.covidsafe.interactor.UseCaseKt.access$getRETRIES_LIMIT$p()
            if (r2 >= r5) goto L_0x0093
            r5 = 2
            double r5 = (double) r5
            double r7 = (double) r2
            double r5 = java.lang.Math.pow(r5, r7)
            long r5 = (long) r5
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7
            long r5 = r5 * r7
            r0.L$0 = r4
            r0.L$1 = r11
            r0.L$2 = r12
            r0.I$0 = r2
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r12 != r1) goto L_0x008b
            return r1
        L_0x008b:
            java.lang.Object r12 = r11.invoke()
            retrofit2.Response r12 = (retrofit2.Response) r12
            int r2 = r2 + r3
            goto L_0x0050
        L_0x0093:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.UseCase.retryRetrofitCall(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    protected final java.lang.Object retryOkhttpCall(kotlin.jvm.functions.Function0<okhttp3.Response> r11, kotlin.coroutines.Continuation<? super okhttp3.Response> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof au.gov.health.covidsafe.interactor.UseCase$retryOkhttpCall$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            au.gov.health.covidsafe.interactor.UseCase$retryOkhttpCall$1 r0 = (au.gov.health.covidsafe.interactor.UseCase$retryOkhttpCall$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            au.gov.health.covidsafe.interactor.UseCase$retryOkhttpCall$1 r0 = new au.gov.health.covidsafe.interactor.UseCase$retryOkhttpCall$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            long r4 = r0.J$0
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$2
            okhttp3.Response r2 = (okhttp3.Response) r2
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            java.lang.Object r4 = r0.L$0
            au.gov.health.covidsafe.interactor.UseCase r4 = (au.gov.health.covidsafe.interactor.UseCase) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x0083
        L_0x003d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.invoke()
            okhttp3.Response r12 = (okhttp3.Response) r12
            r2 = 0
            r4 = r10
        L_0x0050:
            if (r12 == 0) goto L_0x005e
            boolean r5 = r12.isSuccessful()
            if (r5 == 0) goto L_0x005e
            okhttp3.ResponseBody r5 = r12.body()
            if (r5 != 0) goto L_0x008b
        L_0x005e:
            int r5 = au.gov.health.covidsafe.interactor.UseCaseKt.RETRIES_LIMIT
            if (r2 >= r5) goto L_0x008b
            r5 = 2
            double r5 = (double) r5
            double r7 = (double) r2
            double r5 = java.lang.Math.pow(r5, r7)
            long r5 = (long) r5
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7
            long r5 = r5 * r7
            r0.L$0 = r4
            r0.L$1 = r11
            r0.L$2 = r12
            r0.I$0 = r2
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r12 != r1) goto L_0x0083
            return r1
        L_0x0083:
            java.lang.Object r12 = r11.invoke()
            okhttp3.Response r12 = (okhttp3.Response) r12
            int r2 = r2 + r3
            goto L_0x0050
        L_0x008b:
            if (r12 == 0) goto L_0x0094
            boolean r11 = r12.isSuccessful()
            if (r11 == 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r12 = 0
        L_0x0095:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: au.gov.health.covidsafe.interactor.UseCase.retryOkhttpCall(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lau/gov/health/covidsafe/interactor/UseCase$None;", "", "()V", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: UseCase.kt */
    public static final class None {
        public static final None INSTANCE = new None();

        private None() {
        }
    }
}
