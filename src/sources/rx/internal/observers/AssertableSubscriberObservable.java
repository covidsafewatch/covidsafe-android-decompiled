package rx.internal.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.AssertableSubscriber;
import rx.observers.TestSubscriber;

public class AssertableSubscriberObservable<T> extends Subscriber<T> implements AssertableSubscriber<T> {
    private final TestSubscriber<T> ts;

    public AssertableSubscriberObservable(TestSubscriber<T> testSubscriber) {
        this.ts = testSubscriber;
    }

    public static <T> AssertableSubscriberObservable<T> create(long j) {
        TestSubscriber testSubscriber = new TestSubscriber(j);
        AssertableSubscriberObservable<T> assertableSubscriberObservable = new AssertableSubscriberObservable<>(testSubscriber);
        assertableSubscriberObservable.add(testSubscriber);
        return assertableSubscriberObservable;
    }

    public void onStart() {
        this.ts.onStart();
    }

    public void onCompleted() {
        this.ts.onCompleted();
    }

    public void setProducer(Producer producer) {
        this.ts.setProducer(producer);
    }

    public final int getCompletions() {
        return this.ts.getCompletions();
    }

    public void onError(Throwable th) {
        this.ts.onError(th);
    }

    public List<Throwable> getOnErrorEvents() {
        return this.ts.getOnErrorEvents();
    }

    public void onNext(T t) {
        this.ts.onNext(t);
    }

    public final int getValueCount() {
        return this.ts.getValueCount();
    }

    public AssertableSubscriber<T> requestMore(long j) {
        this.ts.requestMore(j);
        return this;
    }

    public List<T> getOnNextEvents() {
        return this.ts.getOnNextEvents();
    }

    public AssertableSubscriber<T> assertReceivedOnNext(List<T> list) {
        this.ts.assertReceivedOnNext(list);
        return this;
    }

    public final AssertableSubscriber<T> awaitValueCount(int i, long j, TimeUnit timeUnit) {
        if (this.ts.awaitValueCount(i, j, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i + ", Actual: " + this.ts.getValueCount());
    }

    public AssertableSubscriber<T> assertTerminalEvent() {
        this.ts.assertTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertUnsubscribed() {
        this.ts.assertUnsubscribed();
        return this;
    }

    public AssertableSubscriber<T> assertNoErrors() {
        this.ts.assertNoErrors();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent() {
        this.ts.awaitTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent(long j, TimeUnit timeUnit) {
        this.ts.awaitTerminalEvent(j, timeUnit);
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long j, TimeUnit timeUnit) {
        this.ts.awaitTerminalEventAndUnsubscribeOnTimeout(j, timeUnit);
        return this;
    }

    public Thread getLastSeenThread() {
        return this.ts.getLastSeenThread();
    }

    public AssertableSubscriber<T> assertCompleted() {
        this.ts.assertCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertNotCompleted() {
        this.ts.assertNotCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertError(Class<? extends Throwable> cls) {
        this.ts.assertError(cls);
        return this;
    }

    public AssertableSubscriber<T> assertError(Throwable th) {
        this.ts.assertError(th);
        return this;
    }

    public AssertableSubscriber<T> assertNoTerminalEvent() {
        this.ts.assertNoTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertNoValues() {
        this.ts.assertNoValues();
        return this;
    }

    public AssertableSubscriber<T> assertValueCount(int i) {
        this.ts.assertValueCount(i);
        return this;
    }

    public AssertableSubscriber<T> assertValues(T... tArr) {
        this.ts.assertValues(tArr);
        return this;
    }

    public AssertableSubscriber<T> assertValue(T t) {
        this.ts.assertValue(t);
        return this;
    }

    public final AssertableSubscriber<T> assertValuesAndClear(T t, T... tArr) {
        this.ts.assertValuesAndClear(t, tArr);
        return this;
    }

    public final AssertableSubscriber<T> perform(Action0 action0) {
        action0.call();
        return this;
    }

    public String toString() {
        return this.ts.toString();
    }

    public final AssertableSubscriber<T> assertResult(T... tArr) {
        this.ts.assertValues(tArr);
        this.ts.assertNoErrors();
        this.ts.assertCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailure(Class<? extends Throwable> cls, T... tArr) {
        this.ts.assertValues(tArr);
        this.ts.assertError(cls);
        this.ts.assertNotCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        this.ts.assertValues(tArr);
        this.ts.assertError(cls);
        this.ts.assertNotCompleted();
        String message = this.ts.getOnErrorEvents().get(0).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }
}
