package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.AssemblyStackTraceException;

public final class OnSubscribeOnAssembly<T> implements Observable.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Observable.OnSubscribe<T> source;
    final String stacktrace = createStacktrace();

    public OnSubscribeOnAssembly(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    static String createStacktrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder("Assembly trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            if (fullStackTrace || (stackTraceElement.getLineNumber() > 1 && !stackTraceElement2.contains("RxJavaHooks.") && !stackTraceElement2.contains("OnSubscribeOnAssembly") && !stackTraceElement2.contains(".junit.runner") && !stackTraceElement2.contains(".junit4.runner") && !stackTraceElement2.contains(".junit.internal") && !stackTraceElement2.contains("sun.reflect") && !stackTraceElement2.contains("java.lang.Thread.") && !stackTraceElement2.contains("ThreadPoolExecutor") && !stackTraceElement2.contains("org.apache.catalina.") && !stackTraceElement2.contains("org.apache.tomcat."))) {
                sb.append("\n at ");
                sb.append(stackTraceElement2);
            }
        }
        sb.append("\nOriginal exception:");
        return sb.toString();
    }

    public void call(Subscriber<? super T> subscriber) {
        this.source.call(new OnAssemblySubscriber(subscriber, this.stacktrace));
    }

    static final class OnAssemblySubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySubscriber(Subscriber<? super T> subscriber, String str) {
            super(subscriber);
            this.actual = subscriber;
            this.stacktrace = str;
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.stacktrace).attachTo(th);
            this.actual.onError(th);
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }
    }
}
