package rx.internal.operators;

import java.util.Arrays;
import java.util.Collection;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class SingleOnSubscribeUsing<T, Resource> implements Single.OnSubscribe<T> {
    final Action1<? super Resource> disposeAction;
    final boolean disposeEagerly;
    final Func0<Resource> resourceFactory;
    final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;

    public SingleOnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Single<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        this.resourceFactory = func0;
        this.singleFactory = func1;
        this.disposeAction = action1;
        this.disposeEagerly = z;
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        try {
            final Resource call = this.resourceFactory.call();
            try {
                Single single = (Single) this.singleFactory.call(call);
                if (single == null) {
                    handleSubscriptionTimeError(singleSubscriber, call, new NullPointerException("The single"));
                    return;
                }
                AnonymousClass1 r2 = new SingleSubscriber<T>() {
                    public void onSuccess(T t) {
                        if (SingleOnSubscribeUsing.this.disposeEagerly) {
                            try {
                                SingleOnSubscribeUsing.this.disposeAction.call(call);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                singleSubscriber.onError(th);
                                return;
                            }
                        }
                        singleSubscriber.onSuccess(t);
                        if (!SingleOnSubscribeUsing.this.disposeEagerly) {
                            try {
                                SingleOnSubscribeUsing.this.disposeAction.call(call);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                RxJavaHooks.onError(th2);
                            }
                        }
                    }

                    public void onError(Throwable th) {
                        SingleOnSubscribeUsing.this.handleSubscriptionTimeError(singleSubscriber, call, th);
                    }
                };
                singleSubscriber.add(r2);
                single.subscribe(r2);
            } catch (Throwable th) {
                handleSubscriptionTimeError(singleSubscriber, call, th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleSubscriber.onError(th2);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleSubscriptionTimeError(SingleSubscriber<? super T> singleSubscriber, Resource resource, Throwable th) {
        Exceptions.throwIfFatal(th);
        if (this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th, th2}));
            }
        }
        singleSubscriber.onError(th);
        if (!this.disposeEagerly) {
            try {
                this.disposeAction.call(resource);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaHooks.onError(th3);
            }
        }
    }
}
