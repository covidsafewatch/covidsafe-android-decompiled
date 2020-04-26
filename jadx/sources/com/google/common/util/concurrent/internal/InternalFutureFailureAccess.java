package com.google.common.util.concurrent.internal;

public abstract class InternalFutureFailureAccess {
    /* access modifiers changed from: protected */
    public abstract Throwable tryInternalFastPathGetFailure();

    protected InternalFutureFailureAccess() {
    }
}
