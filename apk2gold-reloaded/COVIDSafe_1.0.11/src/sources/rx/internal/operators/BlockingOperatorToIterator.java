package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

public final class BlockingOperatorToIterator {

    public static final class SubscriberIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        static final int LIMIT = ((RxRingBuffer.SIZE * 3) / 4);
        private Notification<? extends T> buf;
        private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
        private int received;

        public void onCompleted() {
        }

        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        public void onError(Throwable th) {
            this.notifications.offer(Notification.createOnError(th));
        }

        public void onNext(Notification<? extends T> notification) {
            this.notifications.offer(notification);
        }

        public boolean hasNext() {
            if (this.buf == null) {
                this.buf = take();
                int i = this.received + 1;
                this.received = i;
                if (i >= LIMIT) {
                    request((long) i);
                    this.received = 0;
                }
            }
            if (!this.buf.isOnError()) {
                return !this.buf.isOnCompleted();
            }
            throw Exceptions.propagate(this.buf.getThrowable());
        }

        public T next() {
            if (hasNext()) {
                T value = this.buf.getValue();
                this.buf = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        private Notification<? extends T> take() {
            try {
                Notification<? extends T> notification = (Notification) this.notifications.poll();
                if (notification != null) {
                    return notification;
                }
                return (Notification) this.notifications.take();
            } catch (InterruptedException e) {
                unsubscribe();
                throw Exceptions.propagate(e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }
    }

    private BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> toIterator(Observable<? extends T> observable) {
        SubscriberIterator subscriberIterator = new SubscriberIterator();
        observable.materialize().subscribe((Subscriber<? super T>) subscriberIterator);
        return subscriberIterator;
    }
}
