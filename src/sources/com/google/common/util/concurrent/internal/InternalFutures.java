package com.google.common.util.concurrent.internal;

public final class InternalFutures {
    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess internalFutureFailureAccess) {
        return internalFutureFailureAccess.tryInternalFastPathGetFailure();
    }

    private InternalFutures() {
    }
}
