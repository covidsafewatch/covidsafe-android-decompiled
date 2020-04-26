package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventBus {
    private static final Logger logger = Logger.getLogger(EventBus.class.getName());
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    static final class LoggingHandler implements SubscriberExceptionHandler {
        static final LoggingHandler INSTANCE = new LoggingHandler();

        LoggingHandler() {
        }

        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger logger = logger(subscriberExceptionContext);
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, message(subscriberExceptionContext), th);
            }
        }

        private static Logger logger(SubscriberExceptionContext subscriberExceptionContext) {
            StringBuilder sb = new StringBuilder();
            sb.append(EventBus.class.getName());
            sb.append(".");
            sb.append(subscriberExceptionContext.getEventBus().identifier());
            return Logger.getLogger(sb.toString());
        }

        private static String message(SubscriberExceptionContext subscriberExceptionContext) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            StringBuilder sb = new StringBuilder();
            sb.append("Exception thrown by subscriber method ");
            sb.append(subscriberMethod.getName());
            sb.append('(');
            sb.append(subscriberMethod.getParameterTypes()[0].getName());
            sb.append(')');
            sb.append(" on subscriber ");
            sb.append(subscriberExceptionContext.getSubscriber());
            sb.append(" when dispatching event: ");
            sb.append(subscriberExceptionContext.getEvent());
            return sb.toString();
        }
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), subscriberExceptionHandler);
    }

    EventBus(String str, Executor executor2, Dispatcher dispatcher2, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.checkNotNull(str);
        this.executor = (Executor) Preconditions.checkNotNull(executor2);
        this.dispatcher = (Dispatcher) Preconditions.checkNotNull(dispatcher2);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }

    public final String identifier() {
        return this.identifier;
    }

    /* access modifiers changed from: 0000 */
    public final Executor executor() {
        return this.executor;
    }

    /* access modifiers changed from: 0000 */
    public void handleSubscriberException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(th);
        Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.exceptionHandler.handleException(th, subscriberExceptionContext);
        } catch (Throwable th2) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th2, th}), th2);
        }
    }

    public void register(Object obj) {
        this.subscribers.register(obj);
    }

    public void unregister(Object obj) {
        this.subscribers.unregister(obj);
    }

    public void post(Object obj) {
        Iterator subscribers2 = this.subscribers.getSubscribers(obj);
        if (subscribers2.hasNext()) {
            this.dispatcher.dispatch(obj, subscribers2);
        } else if (!(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).addValue((Object) this.identifier).toString();
    }
}
