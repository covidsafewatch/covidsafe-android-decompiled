package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(L l);
    }

    ListenerCallQueue() {
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(l, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> add : this.listeners) {
                add.add(event, obj);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor2) {
            this.listener = Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        /* access modifiers changed from: package-private */
        public void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger access$000 = ListenerCallQueue.logger;
                        Level level = Level.SEVERE;
                        access$000.log(level, "Exception while running callbacks for " + this.listener + " on " + this.executor, e);
                        throw e;
                    }
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
            	at java.base/java.util.Objects.checkIndex(Objects.java:372)
            	at java.base/java.util.ArrayList.get(ArrayList.java:458)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r9 = this;
            L_0x0000:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch:{ all -> 0x0058 }
                boolean r2 = r9.isThreadScheduled     // Catch:{ all -> 0x004c }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x004c }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r9.waitQueue     // Catch:{ all -> 0x004c }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x004c }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x004c }
                java.util.Queue<java.lang.Object> r3 = r9.labelQueue     // Catch:{ all -> 0x004c }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x004c }
                if (r2 != 0) goto L_0x001f
                r9.isThreadScheduled = r0     // Catch:{ all -> 0x004c }
                monitor-exit(r9)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r1 = move-exception
                r2 = 0
                goto L_0x004f
            L_0x001f:
                monitor-exit(r9)     // Catch:{ all -> 0x004c }
                L r4 = r9.listener     // Catch:{ RuntimeException -> 0x0026 }
                r2.call(r4)     // Catch:{ RuntimeException -> 0x0026 }
                goto L_0x0000
            L_0x0026:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.logger     // Catch:{ all -> 0x0058 }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0058 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
                r6.<init>()     // Catch:{ all -> 0x0058 }
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch:{ all -> 0x0058 }
                L r7 = r9.listener     // Catch:{ all -> 0x0058 }
                r6.append(r7)     // Catch:{ all -> 0x0058 }
                java.lang.String r7 = " "
                r6.append(r7)     // Catch:{ all -> 0x0058 }
                r6.append(r3)     // Catch:{ all -> 0x0058 }
                java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0058 }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x0058 }
                goto L_0x0000
            L_0x004c:
                r2 = move-exception
                r1 = r2
                r2 = 1
            L_0x004f:
                monitor-exit(r9)     // Catch:{ all -> 0x0056 }
                throw r1     // Catch:{ all -> 0x0051 }
            L_0x0051:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L_0x0059
            L_0x0056:
                r1 = move-exception
                goto L_0x004f
            L_0x0058:
                r2 = move-exception
            L_0x0059:
                if (r1 == 0) goto L_0x0063
                monitor-enter(r9)
                r9.isThreadScheduled = r0     // Catch:{ all -> 0x0060 }
                monitor-exit(r9)     // Catch:{ all -> 0x0060 }
                goto L_0x0063
            L_0x0060:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0060 }
                throw r0
            L_0x0063:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}
