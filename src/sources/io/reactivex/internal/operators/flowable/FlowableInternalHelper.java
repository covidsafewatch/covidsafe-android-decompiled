package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {
    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> consumer;

        SimpleGenerator(Consumer<Emitter<T>> consumer2) {
            this.consumer = consumer2;
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(emitter);
            return s;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleGenerator(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> consumer;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.consumer = biConsumer;
        }

        public S apply(S s, Emitter<T> emitter) throws Exception {
            this.consumer.accept(s, emitter);
            return s;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> simpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> itemDelay;

        ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.itemDelay = function;
        }

        public Publisher<T> apply(T t) throws Exception {
            return new FlowableTakePublisher((Publisher) ObjectHelper.requireNonNull(this.itemDelay.apply(t), "The itemDelay returned a null Publisher"), 1).map(Functions.justFunction(t)).defaultIfEmpty(t);
        }
    }

    public static <T, U> Function<T, Publisher<T>> itemDelay(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> subscriber;

        SubscriberOnNext(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        public void accept(T t) throws Exception {
            this.subscriber.onNext(t);
        }
    }

    static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> subscriber;

        SubscriberOnError(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        public void accept(Throwable th) throws Exception {
            this.subscriber.onError(th);
        }
    }

    static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> subscriber;

        SubscriberOnComplete(Subscriber<T> subscriber2) {
            this.subscriber = subscriber2;
        }

        public void run() throws Exception {
            this.subscriber.onComplete();
        }
    }

    public static <T> Consumer<T> subscriberOnNext(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T> Consumer<Throwable> subscriberOnError(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Action subscriberOnComplete(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final T t;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t2) {
            this.combiner = biFunction;
            this.t = t2;
        }

        public R apply(U u) throws Exception {
            return this.combiner.apply(this.t, u);
        }
    }

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> combiner;
        private final Function<? super T, ? extends Publisher<? extends U>> mapper;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.combiner = biFunction;
            this.mapper = function;
        }

        public Publisher<R> apply(T t) throws Exception {
            return new FlowableMapPublisher((Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.combiner, t));
        }
    }

    public static <T, U, R> Function<T, Publisher<R>> flatMapWithCombiner(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> mapper;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.mapper = function;
        }

        public Publisher<U> apply(T t) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Iterable"));
        }
    }

    public static <T, U> Function<T, Publisher<U>> flatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable) {
        return new ReplayCallable(flowable);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i) {
        return new BufferedReplayCallable(flowable, i);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(flowable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableFlowable<T>> replayCallable(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(flowable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> replayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        public void accept(Subscription subscription) throws Exception {
            subscription.request(LongCompanionObject.MAX_VALUE);
        }
    }

    static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> zipper;

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.zipper = function;
        }

        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return Flowable.zipIterable(list, this.zipper, false, Flowable.bufferSize());
        }
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> zipIterable(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;

        ReplayCallable(Flowable<T> flowable) {
            this.parent = flowable;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay();
        }
    }

    static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;

        BufferedReplayCallable(Flowable<T> flowable, int i) {
            this.parent = flowable;
            this.bufferSize = i;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize);
        }
    }

    static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final int bufferSize;
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        BufferedTimedReplay(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = flowable;
            this.bufferSize = i;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> parent;
        private final Scheduler scheduler;
        private final long time;
        private final TimeUnit unit;

        TimedReplay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.parent = flowable;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
        }

        public ConnectableFlowable<T> call() {
            return this.parent.replay(this.time, this.unit, this.scheduler);
        }
    }

    static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Scheduler scheduler;
        private final Function<? super Flowable<T>, ? extends Publisher<R>> selector;

        ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler2) {
            this.selector = function;
            this.scheduler = scheduler2;
        }

        public Publisher<R> apply(Flowable<T> flowable) throws Exception {
            return Flowable.fromPublisher((Publisher) ObjectHelper.requireNonNull(this.selector.apply(flowable), "The selector returned a null Publisher")).observeOn(this.scheduler);
        }
    }
}
