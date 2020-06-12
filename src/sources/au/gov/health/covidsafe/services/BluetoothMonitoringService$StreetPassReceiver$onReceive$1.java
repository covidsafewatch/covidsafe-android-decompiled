package au.gov.health.covidsafe.services;

import au.gov.health.covidsafe.Utils;
import au.gov.health.covidsafe.logging.CentralLog;
import au.gov.health.covidsafe.services.BluetoothMonitoringService;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecord;
import au.gov.health.covidsafe.streetpass.persistence.StreetPassRecordStorage;
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
@DebugMetadata(c = "au.gov.health.covidsafe.services.BluetoothMonitoringService$StreetPassReceiver$onReceive$1", f = "BluetoothMonitoringService.kt", i = {0}, l = {620}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: BluetoothMonitoringService.kt */
final class BluetoothMonitoringService$StreetPassReceiver$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StreetPassRecord $record;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ BluetoothMonitoringService.StreetPassReceiver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BluetoothMonitoringService$StreetPassReceiver$onReceive$1(BluetoothMonitoringService.StreetPassReceiver streetPassReceiver, StreetPassRecord streetPassRecord, Continuation continuation) {
        super(2, continuation);
        this.this$0 = streetPassReceiver;
        this.$record = streetPassRecord;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        BluetoothMonitoringService$StreetPassReceiver$onReceive$1 bluetoothMonitoringService$StreetPassReceiver$onReceive$1 = new BluetoothMonitoringService$StreetPassReceiver$onReceive$1(this.this$0, this.$record, continuation);
        bluetoothMonitoringService$StreetPassReceiver$onReceive$1.p$ = (CoroutineScope) obj;
        return bluetoothMonitoringService$StreetPassReceiver$onReceive$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BluetoothMonitoringService$StreetPassReceiver$onReceive$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            CentralLog.Companion companion = CentralLog.Companion;
            String access$getTAG$p = this.this$0.TAG;
            companion.d(access$getTAG$p, "Coroutine - Saving StreetPassRecord: " + Utils.INSTANCE.getDate(this.$record.getTimestamp()) + ' ' + this.$record);
            StreetPassRecordStorage access$getStreetPassRecordStorage$p = BluetoothMonitoringService.access$getStreetPassRecordStorage$p(BluetoothMonitoringService.this);
            StreetPassRecord streetPassRecord = this.$record;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (access$getStreetPassRecordStorage$p.saveRecord(streetPassRecord, this) == coroutine_suspended) {
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
