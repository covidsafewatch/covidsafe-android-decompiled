package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledFuture;

public interface ListenableScheduledFuture<V> extends ScheduledFuture<V>, ListenableFuture<V> {
}
