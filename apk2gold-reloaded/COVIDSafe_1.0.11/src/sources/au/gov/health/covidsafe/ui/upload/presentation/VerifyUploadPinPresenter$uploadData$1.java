package au.gov.health.covidsafe.ui.upload.presentation;

import android.content.Context;
import au.gov.health.covidsafe.Preference;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: VerifyUploadPinPresenter.kt */
final class VerifyUploadPinPresenter$uploadData$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ VerifyUploadPinPresenter this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "au.gov.health.covidsafe.ui.upload.presentation.VerifyUploadPinPresenter$uploadData$1$1", f = "VerifyUploadPinPresenter.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: au.gov.health.covidsafe.ui.upload.presentation.VerifyUploadPinPresenter$uploadData$1$1 reason: invalid class name */
    /* compiled from: VerifyUploadPinPresenter.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ VerifyUploadPinPresenter$uploadData$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                StreetPassRecordStorage access$getRecordStorage$p = VerifyUploadPinPresenter.access$getRecordStorage$p(this.this$0.this$0);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (access$getRecordStorage$p.nukeDbAsync(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    VerifyUploadPinPresenter$uploadData$1(VerifyUploadPinPresenter verifyUploadPinPresenter) {
        this.this$0 = verifyUploadPinPresenter;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
        Context context = this.this$0.fragment.getContext();
        if (context != null) {
            Preference preference = Preference.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            preference.setDataIsUploaded(context, true);
        }
        this.this$0.fragment.navigateToNextPage();
    }
}
