package rx.internal.util.unsafe;

public interface QueueProgressIndicators {
    long currentConsumerIndex();

    long currentProducerIndex();
}
