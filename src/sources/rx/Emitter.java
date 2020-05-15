package rx;

import rx.functions.Cancellable;

public interface Emitter<T> extends Observer<T> {

    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }

    long requested();

    void setCancellation(Cancellable cancellable);

    void setSubscription(Subscription subscription);
}
