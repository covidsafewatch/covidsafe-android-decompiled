package rx.internal.util;

import rx.Notification;
import rx.Observer;
import rx.functions.Action1;

public final class ActionNotificationObserver<T> implements Observer<T> {
    final Action1<Notification<? super T>> onNotification;

    public ActionNotificationObserver(Action1<Notification<? super T>> action1) {
        this.onNotification = action1;
    }

    public void onNext(T t) {
        this.onNotification.call(Notification.createOnNext(t));
    }

    public void onError(Throwable th) {
        this.onNotification.call(Notification.createOnError(th));
    }

    public void onCompleted() {
        this.onNotification.call(Notification.createOnCompleted());
    }
}
