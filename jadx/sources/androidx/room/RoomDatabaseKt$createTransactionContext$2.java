package androidx.room;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: RoomDatabase.kt */
final class RoomDatabaseKt$createTransactionContext$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableJob $controlJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt$createTransactionContext$2(CompletableJob completableJob) {
        super(1);
        this.$controlJob = completableJob;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Job.DefaultImpls.cancel$default((Job) this.$controlJob, (CancellationException) null, 1, (Object) null);
    }
}
