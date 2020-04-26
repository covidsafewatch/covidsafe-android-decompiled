package rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;

public interface AssertableSubscriber<T> extends Observer<T>, Subscription {
    AssertableSubscriber<T> assertCompleted();

    AssertableSubscriber<T> assertError(Class<? extends Throwable> cls);

    AssertableSubscriber<T> assertError(Throwable th);

    AssertableSubscriber<T> assertFailure(Class<? extends Throwable> cls, T... tArr);

    AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr);

    AssertableSubscriber<T> assertNoErrors();

    AssertableSubscriber<T> assertNoTerminalEvent();

    AssertableSubscriber<T> assertNoValues();

    AssertableSubscriber<T> assertNotCompleted();

    AssertableSubscriber<T> assertReceivedOnNext(List<T> list);

    AssertableSubscriber<T> assertResult(T... tArr);

    AssertableSubscriber<T> assertTerminalEvent();

    AssertableSubscriber<T> assertUnsubscribed();

    AssertableSubscriber<T> assertValue(T t);

    AssertableSubscriber<T> assertValueCount(int i);

    AssertableSubscriber<T> assertValues(T... tArr);

    AssertableSubscriber<T> assertValuesAndClear(T t, T... tArr);

    AssertableSubscriber<T> awaitTerminalEvent();

    AssertableSubscriber<T> awaitTerminalEvent(long j, TimeUnit timeUnit);

    AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long j, TimeUnit timeUnit);

    AssertableSubscriber<T> awaitValueCount(int i, long j, TimeUnit timeUnit);

    int getCompletions();

    Thread getLastSeenThread();

    List<Throwable> getOnErrorEvents();

    List<T> getOnNextEvents();

    int getValueCount();

    boolean isUnsubscribed();

    void onStart();

    AssertableSubscriber<T> perform(Action0 action0);

    AssertableSubscriber<T> requestMore(long j);

    void setProducer(Producer producer);

    void unsubscribe();
}
