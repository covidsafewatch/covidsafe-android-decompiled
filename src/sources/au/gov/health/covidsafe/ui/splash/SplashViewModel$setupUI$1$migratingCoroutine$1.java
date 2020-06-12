package au.gov.health.covidsafe.ui.splash;

import androidx.lifecycle.ViewModelKt;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import au.gov.health.covidsafe.ui.splash.SplashNavigationEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "au.gov.health.covidsafe.ui.splash.SplashViewModel$setupUI$1$migratingCoroutine$1", f = "SplashViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SplashViewModel.kt */
final class SplashViewModel$setupUI$1$migratingCoroutine$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SplashViewModel$setupUI$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplashViewModel$setupUI$1$migratingCoroutine$1(SplashViewModel$setupUI$1 splashViewModel$setupUI$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = splashViewModel$setupUI$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SplashViewModel$setupUI$1$migratingCoroutine$1 splashViewModel$setupUI$1$migratingCoroutine$1 = new SplashViewModel$setupUI$1$migratingCoroutine$1(this.this$0, continuation);
        splashViewModel$setupUI$1$migratingCoroutine$1.p$ = (CoroutineScope) obj;
        return splashViewModel$setupUI$1$migratingCoroutine$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SplashViewModel$setupUI$1$migratingCoroutine$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SupportSQLiteOpenHelper openHelper = this.this$0.this$0.getDb().getOpenHelper();
            Intrinsics.checkExpressionValueIsNotNull(openHelper, "db.openHelper");
            this.this$0.this$0.migrated = !openHelper.getReadableDatabase().needUpgrade(3);
            return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation) null), 3, (Object) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
    @DebugMetadata(c = "au.gov.health.covidsafe.ui.splash.SplashViewModel$setupUI$1$migratingCoroutine$1$1", f = "SplashViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: au.gov.health.covidsafe.ui.splash.SplashViewModel$setupUI$1$migratingCoroutine$1$1  reason: invalid class name */
    /* compiled from: SplashViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ SplashViewModel$setupUI$1$migratingCoroutine$1 this$0;

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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.this$0.this$0.migrated && this.this$0.this$0.this$0.splashScreenPassed) {
                    this.this$0.this$0.this$0.getSplashNavigationLiveData().setValue(SplashNavigationEvent.GoToNextScreen.INSTANCE);
                } else if (!this.this$0.this$0.this$0.migrated) {
                    this.this$0.this$0.this$0.getSplashNavigationLiveData().setValue(SplashNavigationEvent.ShowMigrationScreen.INSTANCE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
