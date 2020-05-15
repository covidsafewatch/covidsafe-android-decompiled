package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {
    static final Notification<Object> COMPLETE = new Notification<>((Object) null);
    final Object value;

    private Notification(Object obj) {
        this.value = obj;
    }

    public boolean isOnComplete() {
        return this.value == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    public boolean isOnNext() {
        Object obj = this.value;
        return obj != null && !NotificationLite.isError(obj);
    }

    public T getValue() {
        Object obj = this.value;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.value;
    }

    public Throwable getError() {
        Object obj = this.value;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.value, ((Notification) obj).value);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.value;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.value + "]";
    }

    public static <T> Notification<T> createOnNext(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    public static <T> Notification<T> createOnComplete() {
        return COMPLETE;
    }
}
