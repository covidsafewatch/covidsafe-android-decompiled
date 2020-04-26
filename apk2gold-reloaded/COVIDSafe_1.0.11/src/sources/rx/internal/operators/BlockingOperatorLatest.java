package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorLatest {

    static final class LatestObserverIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        Notification<? extends T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<? extends T>> value = new AtomicReference<>();

        public void onCompleted() {
        }

        public void onError(Throwable th) {
        }

        LatestObserverIterator() {
        }

        public void onNext(Notification<? extends T> notification) {
            if (this.value.getAndSet(notification) == null) {
                this.notify.release();
            }
        }

        public boolean hasNext() {
            Notification<? extends T> notification = this.iteratorNotification;
            if (notification == null || !notification.isOnError()) {
                Notification<? extends T> notification2 = this.iteratorNotification;
                if ((notification2 == null || !notification2.isOnCompleted()) && this.iteratorNotification == null) {
                    try {
                        this.notify.acquire();
                        Notification<? extends T> notification3 = (Notification) this.value.getAndSet(null);
                        this.iteratorNotification = notification3;
                        if (notification3.isOnError()) {
                            throw Exceptions.propagate(this.iteratorNotification.getThrowable());
                        }
                    } catch (InterruptedException e) {
                        unsubscribe();
                        Thread.currentThread().interrupt();
                        this.iteratorNotification = Notification.createOnError(e);
                        throw Exceptions.propagate(e);
                    }
                }
                return !this.iteratorNotification.isOnCompleted();
            }
            throw Exceptions.propagate(this.iteratorNotification.getThrowable());
        }

        public T next() {
            if (!hasNext() || !this.iteratorNotification.isOnNext()) {
                throw new NoSuchElementException();
            }
            T value2 = this.iteratorNotification.getValue();
            this.iteratorNotification = null;
            return value2;
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    private BlockingOperatorLatest() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> latest(final Observable<? extends T> observable) {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                LatestObserverIterator latestObserverIterator = new LatestObserverIterator();
                observable.materialize().subscribe((Subscriber<? super T>) latestObserverIterator);
                return latestObserverIterator;
            }
        };
    }
}
