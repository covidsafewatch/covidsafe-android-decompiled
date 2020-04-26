package rx.internal.operators;

import rx.Completable.OnSubscribe;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssemblyCompletable<T> implements OnSubscribe {
    public static volatile boolean fullStackTrace;
    final OnSubscribe source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    static final class OnAssemblyCompletableSubscriber implements CompletableSubscriber {
        final CompletableSubscriber actual;
        final String stacktrace;

        public OnAssemblyCompletableSubscriber(CompletableSubscriber completableSubscriber, String str) {
            this.actual = completableSubscriber;
            this.stacktrace = str;
        }

        public void onSubscribe(Subscription subscription) {
            this.actual.onSubscribe(subscription);
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }
    }

    public OnSubscribeOnAssemblyCompletable(OnSubscribe onSubscribe) {
        this.source = onSubscribe;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        this.source.call(new OnAssemblyCompletableSubscriber(completableSubscriber, this.stacktrace));
    }
}
