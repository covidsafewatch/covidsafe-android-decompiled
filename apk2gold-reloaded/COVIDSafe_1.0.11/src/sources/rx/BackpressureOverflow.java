package rx;

import rx.exceptions.MissingBackpressureException;

public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT;
    public static final Strategy ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
    public static final Strategy ON_OVERFLOW_ERROR;

    static final class DropLatest implements Strategy {
        static final DropLatest INSTANCE = new DropLatest();

        public boolean mayAttemptDrop() {
            return false;
        }

        private DropLatest() {
        }
    }

    static final class DropOldest implements Strategy {
        static final DropOldest INSTANCE = new DropOldest();

        public boolean mayAttemptDrop() {
            return true;
        }

        private DropOldest() {
        }
    }

    static final class Error implements Strategy {
        static final Error INSTANCE = new Error();

        private Error() {
        }

        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    private BackpressureOverflow() {
        throw new IllegalStateException("No instances!");
    }

    static {
        Error error = Error.INSTANCE;
        ON_OVERFLOW_ERROR = error;
        ON_OVERFLOW_DEFAULT = error;
    }
}
