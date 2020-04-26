package io.reactivex.functions;

public interface Cancellable {
    void cancel() throws Exception;
}
