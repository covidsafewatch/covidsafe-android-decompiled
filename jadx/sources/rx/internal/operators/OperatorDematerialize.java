package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

public final class OperatorDematerialize<T> implements Observable.Operator<T, Notification<T>> {

    static final class Holder {
        static final OperatorDematerialize<Object> INSTANCE = new OperatorDematerialize<>();

        Holder() {
        }
    }

    public static OperatorDematerialize instance() {
        return Holder.INSTANCE;
    }

    OperatorDematerialize() {
    }

    public Subscriber<? super Notification<T>> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<Notification<T>>(subscriber) {
            boolean terminated;

            public void onNext(Notification<T> notification) {
                int i = AnonymousClass2.$SwitchMap$rx$Notification$Kind[notification.getKind().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        onError(notification.getThrowable());
                    } else if (i != 3) {
                        onError(new IllegalArgumentException("Unsupported notification type: " + notification));
                    } else {
                        onCompleted();
                    }
                } else if (!this.terminated) {
                    subscriber.onNext(notification.getValue());
                }
            }

            public void onError(Throwable th) {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onError(th);
                }
            }

            public void onCompleted() {
                if (!this.terminated) {
                    this.terminated = true;
                    subscriber.onCompleted();
                }
            }
        };
    }

    /* renamed from: rx.internal.operators.OperatorDematerialize$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$rx$Notification$Kind;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                rx.Notification$Kind[] r0 = rx.Notification.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$rx$Notification$Kind = r0
                rx.Notification$Kind r1 = rx.Notification.Kind.OnNext     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$rx$Notification$Kind     // Catch:{ NoSuchFieldError -> 0x001d }
                rx.Notification$Kind r1 = rx.Notification.Kind.OnError     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$rx$Notification$Kind     // Catch:{ NoSuchFieldError -> 0x0028 }
                rx.Notification$Kind r1 = rx.Notification.Kind.OnCompleted     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorDematerialize.AnonymousClass2.<clinit>():void");
        }
    }
}
