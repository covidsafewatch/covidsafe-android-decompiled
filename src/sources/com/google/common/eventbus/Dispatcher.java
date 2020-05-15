package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher {
    /* access modifiers changed from: package-private */
    public abstract void dispatch(Object obj, Iterator<Subscriber> it);

    Dispatcher() {
    }

    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() {
                /* access modifiers changed from: protected */
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() {
                /* access modifiers changed from: protected */
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0037 A[Catch:{ all -> 0x005e }, LOOP:1: B:6:0x0037->B:8:0x0041, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void dispatch(java.lang.Object r4, java.util.Iterator<com.google.common.eventbus.Subscriber> r5) {
            /*
                r3 = this;
                com.google.common.base.Preconditions.checkNotNull(r4)
                com.google.common.base.Preconditions.checkNotNull(r5)
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r3.queue
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = 0
                r1.<init>(r4, r5)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                java.lang.Object r4 = r4.get()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L_0x006a
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                r5 = 1
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                r4.set(r5)
            L_0x002f:
                java.lang.Object r4 = r0.poll()     // Catch:{ all -> 0x005e }
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r4 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r4     // Catch:{ all -> 0x005e }
                if (r4 == 0) goto L_0x0053
            L_0x0037:
                java.util.Iterator r5 = r4.subscribers     // Catch:{ all -> 0x005e }
                boolean r5 = r5.hasNext()     // Catch:{ all -> 0x005e }
                if (r5 == 0) goto L_0x002f
                java.util.Iterator r5 = r4.subscribers     // Catch:{ all -> 0x005e }
                java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x005e }
                com.google.common.eventbus.Subscriber r5 = (com.google.common.eventbus.Subscriber) r5     // Catch:{ all -> 0x005e }
                java.lang.Object r1 = r4.event     // Catch:{ all -> 0x005e }
                r5.dispatchEvent(r1)     // Catch:{ all -> 0x005e }
                goto L_0x0037
            L_0x0053:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.dispatching
                r4.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r4 = r3.queue
                r4.remove()
                goto L_0x006a
            L_0x005e:
                r4 = move-exception
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r3.dispatching
                r5.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r5 = r3.queue
                r5.remove()
                throw r4
            L_0x006a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.dispatch(java.lang.Object, java.util.Iterator):void");
        }

        private static final class Event {
            /* access modifiers changed from: private */
            public final Object event;
            /* access modifiers changed from: private */
            public final Iterator<Subscriber> subscribers;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }
    }

    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        /* access modifiers changed from: package-private */
        public void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll != null) {
                    poll.subscriber.dispatchEvent(poll.event);
                } else {
                    return;
                }
            }
        }

        private static final class EventWithSubscriber {
            /* access modifiers changed from: private */
            public final Object event;
            /* access modifiers changed from: private */
            public final Subscriber subscriber;

            private EventWithSubscriber(Object obj, Subscriber subscriber2) {
                this.event = obj;
                this.subscriber = subscriber2;
            }
        }
    }

    private static final class ImmediateDispatcher extends Dispatcher {
        /* access modifiers changed from: private */
        public static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        /* access modifiers changed from: package-private */
        public void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }
}
