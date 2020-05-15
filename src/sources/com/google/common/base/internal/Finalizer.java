package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    @NullableDecl
    private static final Constructor<Thread> bigThreadConstructor;
    @NullableDecl
    private static final Field inheritableThreadLocals;
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        Constructor<Thread> bigThreadConstructor2 = getBigThreadConstructor();
        bigThreadConstructor = bigThreadConstructor2;
        inheritableThreadLocals = bigThreadConstructor2 == null ? getInheritableThreadLocalsField() : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e A[Catch:{ all -> 0x0064 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startFinalizer(java.lang.Class<?> r7, java.lang.ref.ReferenceQueue<java.lang.Object> r8, java.lang.ref.PhantomReference<java.lang.Object> r9) {
        /*
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = "com.google.common.base.FinalizableReference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            com.google.common.base.internal.Finalizer r0 = new com.google.common.base.internal.Finalizer
            r0.<init>(r7, r8, r9)
            java.lang.Class<com.google.common.base.internal.Finalizer> r7 = com.google.common.base.internal.Finalizer.class
            java.lang.String r7 = r7.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r8 = bigThreadConstructor
            r9 = 1
            r1 = 0
            if (r8 == 0) goto L_0x004c
            r2 = 0
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0042 }
            r5 = r1
            java.lang.ThreadGroup r5 = (java.lang.ThreadGroup) r5     // Catch:{ all -> 0x0042 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0042 }
            r4[r9] = r0     // Catch:{ all -> 0x0042 }
            r5 = 2
            r4[r5] = r7     // Catch:{ all -> 0x0042 }
            r5 = 3
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0042 }
            r4[r5] = r2     // Catch:{ all -> 0x0042 }
            r2 = 4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0042 }
            r4[r2] = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r8 = r8.newInstance(r4)     // Catch:{ all -> 0x0042 }
            java.lang.Thread r8 = (java.lang.Thread) r8     // Catch:{ all -> 0x0042 }
            goto L_0x004d
        L_0x0042:
            r8 = move-exception
            java.util.logging.Logger r2 = logger
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r8)
        L_0x004c:
            r8 = r1
        L_0x004d:
            if (r8 != 0) goto L_0x0057
            java.lang.Thread r8 = new java.lang.Thread
            r2 = r1
            java.lang.ThreadGroup r2 = (java.lang.ThreadGroup) r2
            r8.<init>(r2, r0, r7)
        L_0x0057:
            r8.setDaemon(r9)
            java.lang.reflect.Field r7 = inheritableThreadLocals     // Catch:{ all -> 0x0064 }
            if (r7 == 0) goto L_0x006e
            java.lang.reflect.Field r7 = inheritableThreadLocals     // Catch:{ all -> 0x0064 }
            r7.set(r8, r1)     // Catch:{ all -> 0x0064 }
            goto L_0x006e
        L_0x0064:
            r7 = move-exception
            java.util.logging.Logger r9 = logger
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r9.log(r0, r1, r7)
        L_0x006e:
            r8.start()
            return
        L_0x0072:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Expected com.google.common.base.FinalizableReference."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.startFinalizer(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.queue = referenceQueue;
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = phantomReference;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:0|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:2:0x000a, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.ref.ReferenceQueue<java.lang.Object> r0 = r1.queue     // Catch:{ InterruptedException -> 0x0000 }
            java.lang.ref.Reference r0 = r0.remove()     // Catch:{ InterruptedException -> 0x0000 }
            boolean r0 = r1.cleanUp(r0)     // Catch:{ InterruptedException -> 0x0000 }
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.run():void");
    }

    private boolean cleanUp(Reference<?> reference) {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        if (finalizeReferentMethod == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.frqReference) {
                return false;
            }
            try {
                finalizeReferentMethod.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.queue.poll();
        } while (reference != null);
        return true;
    }

    @NullableDecl
    private Method getFinalizeReferentMethod() {
        Class cls = (Class) this.finalizableReferenceClassReference.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @NullableDecl
    private static Field getInheritableThreadLocalsField() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    @NullableDecl
    private static Constructor<Thread> getBigThreadConstructor() {
        try {
            return Thread.class.getConstructor(new Class[]{ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE});
        } catch (Throwable unused) {
            return null;
        }
    }
}
