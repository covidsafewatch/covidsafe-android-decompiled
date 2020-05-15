package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OnSubscribeToMultimap<T, K, V> implements Observable.OnSubscribe<Map<K, Collection<V>>>, Func0<Map<K, Collection<V>>> {
    private final Func1<? super K, ? extends Collection<V>> collectionFactory;
    private final Func1<? super T, ? extends K> keySelector;
    private final Func0<? extends Map<K, Collection<V>>> mapFactory;
    private final Observable<T> source;
    private final Func1<? super T, ? extends V> valueSelector;

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(observable, func1, func12, (Func0) null, DefaultMultimapCollectionFactory.instance());
    }

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        this(observable, func1, func12, func0, DefaultMultimapCollectionFactory.instance());
    }

    public OnSubscribeToMultimap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        this.source = observable;
        this.keySelector = func1;
        this.valueSelector = func12;
        if (func0 == null) {
            this.mapFactory = this;
        } else {
            this.mapFactory = func0;
        }
        this.collectionFactory = func13;
    }

    public Map<K, Collection<V>> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, Collection<V>>> subscriber) {
        try {
            new ToMultimapSubscriber(subscriber, (Map) this.mapFactory.call(), this.keySelector, this.valueSelector, this.collectionFactory).subscribeTo(this.source);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }

    private static final class ToMultimapSubscriber<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, Collection<V>>> {
        private final Func1<? super K, ? extends Collection<V>> collectionFactory;
        private final Func1<? super T, ? extends K> keySelector;
        private final Func1<? super T, ? extends V> valueSelector;

        ToMultimapSubscriber(Subscriber<? super Map<K, Collection<V>>> subscriber, Map<K, Collection<V>> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<? super K, ? extends Collection<V>> func13) {
            super(subscriber);
            this.value = map;
            this.hasValue = true;
            this.keySelector = func1;
            this.valueSelector = func12;
            this.collectionFactory = func13;
        }

        public void onStart() {
            request(LongCompanionObject.MAX_VALUE);
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    Object call = this.keySelector.call(t);
                    Object call2 = this.valueSelector.call(t);
                    Collection collection = (Collection) ((Map) this.value).get(call);
                    if (collection == null) {
                        collection = (Collection) this.collectionFactory.call(call);
                        ((Map) this.value).put(call, collection);
                    }
                    collection.add(call2);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }
    }

    private static final class DefaultMultimapCollectionFactory<K, V> implements Func1<K, Collection<V>> {
        private static final DefaultMultimapCollectionFactory<Object, Object> INSTANCE = new DefaultMultimapCollectionFactory<>();

        private DefaultMultimapCollectionFactory() {
        }

        static <K, V> DefaultMultimapCollectionFactory<K, V> instance() {
            return INSTANCE;
        }

        public Collection<V> call(K k) {
            return new ArrayList();
        }
    }
}
