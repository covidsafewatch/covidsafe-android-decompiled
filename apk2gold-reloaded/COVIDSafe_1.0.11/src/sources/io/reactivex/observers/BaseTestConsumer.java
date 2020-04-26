package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected final CountDownLatch done = new CountDownLatch(1);
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();

    public enum TestWaitStrategy implements Runnable {
        SPIN {
            public void run() {
            }
        },
        YIELD {
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            public void run() {
                sleep(1);
            }
        },
        SLEEP_10MS {
            public void run() {
                sleep(10);
            }
        },
        SLEEP_100MS {
            public void run() {
                sleep(100);
            }
        },
        SLEEP_1000MS {
            public void run() {
                sleep(1000);
            }
        };

        public abstract void run();

        static void sleep(int i) {
            try {
                Thread.sleep((long) i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract U assertNotSubscribed();

    public abstract U assertSubscribed();

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final List<T> values() {
        return this.values;
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    public final long completions() {
        return this.completions;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final int errorCount() {
        return this.errors.size();
    }

    /* access modifiers changed from: protected */
    public final AssertionError fail(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        String str2 = ", ";
        sb.append(str2);
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(str2);
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(str2);
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause((Throwable) this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException((Iterable<? extends Throwable>) this.errors));
            }
        }
        return assertionError;
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(j, timeUnit);
        this.timeout = !z;
        return z;
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j == 0) {
            throw fail("Not completed");
        } else if (j <= 1) {
            return this;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple completions: ");
            sb.append(j);
            throw fail(sb.toString());
        }
    }

    public final U assertNotComplete() {
        long j = this.completions;
        int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
        if (i == 0) {
            throw fail("Completed!");
        } else if (i <= 0) {
            return this;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Multiple completions: ");
            sb.append(j);
            throw fail(sb.toString());
        }
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error(s) present: ");
        sb.append(this.errors);
        throw fail(sb.toString());
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            boolean z = false;
            Iterator it = this.errors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (predicate.test((Throwable) it.next())) {
                        z = true;
                        break;
                    }
                } catch (Exception e) {
                    throw ExceptionHelper.wrapOrThrow(e);
                }
            }
            if (!z) {
                throw fail("Error not present");
            } else if (size == 1) {
                return this;
            } else {
                throw fail("Error present but other errors as well");
            }
        } else {
            throw fail("No errors");
        }
    }

    public final U assertValue(T t) {
        String str = " but was: ";
        String str2 = "expected: ";
        if (this.values.size() == 1) {
            Object obj = this.values.get(0);
            if (ObjectHelper.equals(t, obj)) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(valueAndClass(t));
            sb.append(str);
            sb.append(valueAndClass(obj));
            throw fail(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(valueAndClass(t));
        sb2.append(str);
        sb2.append(this.values);
        throw fail(sb2.toString());
    }

    public final U assertNever(T t) {
        int size = this.values.size();
        int i = 0;
        while (i < size) {
            if (!ObjectHelper.equals(this.values.get(i), t)) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Value at position ");
                sb.append(i);
                sb.append(" is equal to ");
                sb.append(valueAndClass(t));
                sb.append("; Expected them to be different");
                throw fail(sb.toString());
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.values.size();
        int i = 0;
        while (i < size) {
            try {
                if (!predicate.test(this.values.get(i))) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Value at position ");
                    sb.append(i);
                    sb.append(" matches predicate ");
                    sb.append(predicate.toString());
                    sb.append(", which was not expected.");
                    throw fail(sb.toString());
                }
            } catch (Exception e) {
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this;
    }

    public final U assertValueAt(int i, T t) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        } else if (i < size) {
            Object obj = this.values.get(i);
            if (ObjectHelper.equals(t, obj)) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected: ");
            sb.append(valueAndClass(t));
            sb.append(" but was: ");
            sb.append(valueAndClass(obj));
            throw fail(sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid index: ");
            sb2.append(i);
            throw fail(sb2.toString());
        }
    }

    public final U assertValueAt(int i, Predicate<T> predicate) {
        if (this.values.size() == 0) {
            throw fail("No values");
        } else if (i < this.values.size()) {
            try {
                if (predicate.test(this.values.get(i))) {
                    return this;
                }
                throw fail("Value not present");
            } catch (Exception e) {
                throw ExceptionHelper.wrapOrThrow(e);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid index: ");
            sb.append(i);
            throw fail(sb.toString());
        }
    }

    public static String valueAndClass(Object obj) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(" (class: ");
        sb.append(obj.getClass().getSimpleName());
        sb.append(")");
        return sb.toString();
    }

    public final U assertValueCount(int i) {
        int size = this.values.size();
        if (size == i) {
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Value counts differ; expected: ");
        sb.append(i);
        sb.append(" but was: ");
        sb.append(size);
        throw fail(sb.toString());
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        String str = " but was: ";
        if (size == tArr.length) {
            int i = 0;
            while (i < size) {
                Object obj = this.values.get(i);
                T t = tArr[i];
                if (ObjectHelper.equals(t, obj)) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Values at position ");
                    sb.append(i);
                    sb.append(" differ; expected: ");
                    sb.append(valueAndClass(t));
                    sb.append(str);
                    sb.append(valueAndClass(obj));
                    throw fail(sb.toString());
                }
            }
            return this;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Value count differs; expected: ");
        sb2.append(tArr.length);
        String str2 = " ";
        sb2.append(str2);
        sb2.append(Arrays.toString(tArr));
        sb2.append(str);
        sb2.append(size);
        sb2.append(str2);
        sb2.append(this.values);
        throw fail(sb2.toString());
    }

    public final U assertValuesOnly(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (Object next : this.values) {
            if (!collection.contains(next)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Value not in the expected collection: ");
                sb.append(valueAndClass(next));
                throw fail(sb.toString());
            }
        }
        return this;
    }

    public final U assertValueSetOnly(Collection<? extends T> collection) {
        return assertSubscribed().assertValueSet(collection).assertNoErrors().assertNotComplete();
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator it = this.values.iterator();
        Iterator it2 = iterable.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                String str = ")";
            } else {
                Object next = it2.next();
                Object next2 = it.next();
                if (ObjectHelper.equals(next, next2)) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Values at position ");
                    sb.append(i);
                    sb.append(" differ; expected: ");
                    sb.append(valueAndClass(next));
                    sb.append(" but was: ");
                    sb.append(valueAndClass(next2));
                    throw fail(sb.toString());
                }
            }
        }
        String str2 = ")";
        if (hasNext2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("More values received than expected (");
            sb2.append(i);
            sb2.append(str2);
            throw fail(sb2.toString());
        } else if (!hasNext) {
            return this;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Fewer values received than expected (");
            sb3.append(i);
            sb3.append(str2);
            throw fail(sb3.toString());
        }
    }

    public final U assertValueSequenceOnly(Iterable<? extends T> iterable) {
        return assertSubscribed().assertValueSequence(iterable).assertNoErrors().assertNotComplete();
    }

    public final U assertTerminated() {
        if (this.done.getCount() == 0) {
            long j = this.completions;
            if (j <= 1) {
                int size = this.errors.size();
                if (size > 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Terminated with multiple errors: ");
                    sb.append(size);
                    throw fail(sb.toString());
                } else if (j == 0 || size == 0) {
                    return this;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Terminated with multiple completions and errors: ");
                    sb2.append(j);
                    throw fail(sb2.toString());
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Terminated with multiple completions: ");
                sb3.append(j);
                throw fail(sb3.toString());
            }
        } else {
            throw fail("Subscriber still running!");
        }
    }

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean awaitTerminalEvent(long j, TimeUnit timeUnit) {
        try {
            return await(j, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size == 0) {
            throw fail("No errors");
        } else if (size == 1) {
            String message = ((Throwable) this.errors.get(0)).getMessage();
            if (ObjectHelper.equals(str, message)) {
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Error message differs; exptected: ");
            sb.append(str);
            sb.append(" but was: ");
            sb.append(message);
            throw fail(sb.toString());
        } else {
            throw fail("Multiple errors");
        }
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j = 0; j < this.completions; j++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final U assertResult(T... tArr) {
        return assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U awaitDone(long j, TimeUnit timeUnit) {
        try {
            if (!this.done.await(j, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    public final U assertEmpty() {
        return assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    public final U awaitCount(int i) {
        return awaitCount(i, TestWaitStrategy.SLEEP_10MS, 5000);
    }

    public final U awaitCount(int i, Runnable runnable) {
        return awaitCount(i, runnable, 5000);
    }

    public final U awaitCount(int i, Runnable runnable, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j <= 0 || System.currentTimeMillis() - currentTimeMillis < j) {
                if (this.done.getCount() == 0 || this.values.size() >= i) {
                    break;
                }
                runnable.run();
            } else {
                this.timeout = true;
                break;
            }
        }
        return this;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertNoTimeout() {
        if (!this.timeout) {
            return this;
        }
        throw fail("Timeout?!");
    }
}
