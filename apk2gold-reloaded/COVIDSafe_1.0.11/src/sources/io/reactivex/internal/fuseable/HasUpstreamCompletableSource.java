package io.reactivex.internal.fuseable;

import io.reactivex.CompletableSource;

public interface HasUpstreamCompletableSource {
    CompletableSource source();
}
