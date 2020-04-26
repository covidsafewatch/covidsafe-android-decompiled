package rx.observers;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;

public class TestSubscriber<T> extends Subscriber<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        public void onCompleted() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }
    };
    private int completions;
    private final Observer<T> delegate;
    private final List<Throwable> errors;
    private volatile Thread lastSeenThread;
    private final CountDownLatch latch;
    private volatile int valueCount;
    private final List<T> values;

    public TestSubscriber(long j) {
        this(INERT, j);
    }

    public TestSubscriber(Observer<T> observer, long j) {
        this.latch = new CountDownLatch(1);
        if (observer != null) {
            this.delegate = observer;
            if (j >= 0) {
                request(j);
            }
            this.values = new ArrayList();
            this.errors = new ArrayList();
            return;
        }
        throw null;
    }

    public TestSubscriber(Subscriber<T> subscriber) {
        this(subscriber, -1);
    }

    public TestSubscriber(Observer<T> observer) {
        this(observer, -1);
    }

    public TestSubscriber() {
        this(-1);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<>();
    }

    public static <T> TestSubscriber<T> create(long j) {
        return new TestSubscriber<>(j);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer, long j) {
        return new TestSubscriber<>(observer, j);
    }

    public static <T> TestSubscriber<T> create(Subscriber<T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    public static <T> TestSubscriber<T> create(Observer<T> observer) {
        return new TestSubscriber<>(observer);
    }

    public void onCompleted() {
        try {
            this.completions++;
            this.lastSeenThread = Thread.currentThread();
            this.delegate.onCompleted();
        } finally {
            this.latch.countDown();
        }
    }

    @Deprecated
    public List<Notification<T>> getOnCompletedEvents() {
        int i = this.completions;
        ArrayList arrayList = new ArrayList(i != 0 ? i : 1);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Notification.createOnCompleted());
        }
        return arrayList;
    }

    public final int getCompletions() {
        return this.completions;
    }

    public void onError(Throwable th) {
        try {
            this.lastSeenThread = Thread.currentThread();
            this.errors.add(th);
            this.delegate.onError(th);
        } finally {
            this.latch.countDown();
        }
    }

    public List<Throwable> getOnErrorEvents() {
        return this.errors;
    }

    public void onNext(T t) {
        this.lastSeenThread = Thread.currentThread();
        this.values.add(t);
        this.valueCount = this.values.size();
        this.delegate.onNext(t);
    }

    public final int getValueCount() {
        return this.valueCount;
    }

    public void requestMore(long j) {
        request(j);
    }

    public List<T> getOnNextEvents() {
        return this.values;
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.values.size() != list.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Number of items does not match. Provided: ");
            sb.append(list.size());
            sb.append("  Actual: ");
            sb.append(this.values.size());
            sb.append(".\nProvided values: ");
            sb.append(list);
            sb.append("\nActual values: ");
            sb.append(this.values);
            sb.append(StringUtils.EOL);
            assertionError(sb.toString());
        }
        for (int i = 0; i < list.size(); i++) {
            assertItem(list.get(i), i);
        }
    }

    private void assertItem(T t, int i) {
        Object obj = this.values.get(i);
        String str = "Value at index: ";
        if (t == null) {
            if (obj != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i);
                sb.append(" expected: [null] but was: [");
                sb.append(obj);
                sb.append("]\n");
                assertionError(sb.toString());
            }
        } else if (!t.equals(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(i);
            sb2.append(" expected: [");
            sb2.append(t);
            String str2 = "] (";
            sb2.append(str2);
            sb2.append(t.getClass().getSimpleName());
            sb2.append(") but was: [");
            sb2.append(obj);
            sb2.append(str2);
            sb2.append(obj != null ? obj.getClass().getSimpleName() : "null");
            sb2.append(")\n");
            assertionError(sb2.toString());
        }
    }

    public final boolean awaitValueCount(int i, long j, TimeUnit timeUnit) {
        while (j != 0 && this.valueCount < i) {
            try {
                timeUnit.sleep(1);
                j--;
            } catch (InterruptedException e) {
                throw new IllegalStateException("Interrupted", e);
            }
        }
        return this.valueCount >= i;
    }

    public void assertTerminalEvent() {
        if (this.errors.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Too many onError events: ");
            sb.append(this.errors.size());
            assertionError(sb.toString());
        }
        if (this.completions > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Too many onCompleted events: ");
            sb2.append(this.completions);
            assertionError(sb2.toString());
        }
        if (this.completions == 1 && this.errors.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.completions == 0 && this.errors.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    public void assertUnsubscribed() {
        if (!isUnsubscribed()) {
            assertionError("Not unsubscribed.");
        }
    }

    public void assertNoErrors() {
        if (!getOnErrorEvents().isEmpty()) {
            assertionError("Unexpected onError events");
        }
    }

    public void awaitTerminalEvent() {
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    public void awaitTerminalEvent(long j, TimeUnit timeUnit) {
        try {
            this.latch.await(j, timeUnit);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted", e);
        }
    }

    public void awaitTerminalEventAndUnsubscribeOnTimeout(long j, TimeUnit timeUnit) {
        try {
            if (!this.latch.await(j, timeUnit)) {
                unsubscribe();
            }
        } catch (InterruptedException unused) {
            unsubscribe();
        }
    }

    public Thread getLastSeenThread() {
        return this.lastSeenThread;
    }

    public void assertCompleted() {
        int i = this.completions;
        if (i == 0) {
            assertionError("Not completed!");
        } else if (i > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Completed multiple times: ");
            sb.append(i);
            assertionError(sb.toString());
        }
    }

    public void assertNotCompleted() {
        int i = this.completions;
        if (i == 1) {
            assertionError("Completed!");
        } else if (i > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Completed multiple times: ");
            sb.append(i);
            assertionError(sb.toString());
        }
    }

    public void assertError(Class<? extends Throwable> cls) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple errors: ");
            sb.append(list.size());
            AssertionError assertionError = new AssertionError(sb.toString());
            assertionError.initCause(new CompositeException((Collection<? extends Throwable>) list));
            throw assertionError;
        } else if (!cls.isInstance(list.get(0))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exceptions differ; expected: ");
            sb2.append(cls);
            sb2.append(", actual: ");
            sb2.append(list.get(0));
            AssertionError assertionError2 = new AssertionError(sb2.toString());
            assertionError2.initCause((Throwable) list.get(0));
            throw assertionError2;
        }
    }

    public void assertError(Throwable th) {
        List<Throwable> list = this.errors;
        if (list.isEmpty()) {
            assertionError("No errors");
        } else if (list.size() > 1) {
            assertionError("Multiple errors");
        } else if (!th.equals(list.get(0))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exceptions differ; expected: ");
            sb.append(th);
            sb.append(", actual: ");
            sb.append(list.get(0));
            assertionError(sb.toString());
        }
    }

    public void assertNoTerminalEvent() {
        List<Throwable> list = this.errors;
        int i = this.completions;
        if (!list.isEmpty() || i > 0) {
            String str = " completion events instead of none";
            String str2 = " errors and ";
            String str3 = "Found ";
            if (list.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(list.size());
                sb.append(str2);
                sb.append(i);
                sb.append(str);
                assertionError(sb.toString());
            } else if (list.size() == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(list.size());
                sb2.append(str2);
                sb2.append(i);
                sb2.append(str);
                assertionError(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(list.size());
                sb3.append(str2);
                sb3.append(i);
                sb3.append(str);
                assertionError(sb3.toString());
            }
        }
    }

    public void assertNoValues() {
        int size = this.values.size();
        if (size != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("No onNext events expected yet some received: ");
            sb.append(size);
            assertionError(sb.toString());
        }
    }

    public void assertValueCount(int i) {
        int size = this.values.size();
        if (size != i) {
            StringBuilder sb = new StringBuilder();
            sb.append("Number of onNext events differ; expected: ");
            sb.append(i);
            sb.append(", actual: ");
            sb.append(size);
            assertionError(sb.toString());
        }
    }

    public void assertValues(T... tArr) {
        assertReceivedOnNext(Arrays.asList(tArr));
    }

    public void assertValue(T t) {
        assertReceivedOnNext(Collections.singletonList(t));
    }

    /* access modifiers changed from: 0000 */
    public final void assertionError(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int i = this.completions;
        sb.append(i);
        sb.append(" completion");
        if (i != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.errors.isEmpty()) {
            int size = this.errors.size();
            sb.append(" (+");
            sb.append(size);
            sb.append(" error");
            if (size != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause((Throwable) this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException((Collection<? extends Throwable>) this.errors));
            }
        }
        throw assertionError;
    }

    public final void assertValuesAndClear(T t, T... tArr) {
        assertValueCount(tArr.length + 1);
        assertItem(t, 0);
        int i = 0;
        while (i < tArr.length) {
            T t2 = tArr[i];
            i++;
            assertItem(t2, i);
        }
        this.values.clear();
        this.valueCount = 0;
    }
}
