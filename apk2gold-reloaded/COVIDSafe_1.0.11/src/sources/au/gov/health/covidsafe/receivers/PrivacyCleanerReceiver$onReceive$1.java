package au.gov.health.covidsafe.receivers;

import android.content.Context;
import au.gov.health.covidsafe.receivers.PrivacyCleanerReceiver.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.receivers.PrivacyCleanerReceiver$onReceive$1", f = "PrivacyCleanerReceiver.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: PrivacyCleanerReceiver.kt */
final class PrivacyCleanerReceiver$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    private CoroutineScope p$;

    PrivacyCleanerReceiver$onReceive$1(Context context, Continuation continuation) {
        this.$context = context;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        PrivacyCleanerReceiver$onReceive$1 privacyCleanerReceiver$onReceive$1 = new PrivacyCleanerReceiver$onReceive$1(this.$context, continuation);
        privacyCleanerReceiver$onReceive$1.p$ = (CoroutineScope) obj;
        return privacyCleanerReceiver$onReceive$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PrivacyCleanerReceiver$onReceive$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Companion companion = PrivacyCleanerReceiver.Companion;
            Context context = this.$context;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (companion.cleanDb(context, this) == coroutine_suspended) {
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
