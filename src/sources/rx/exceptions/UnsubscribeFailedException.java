package rx.exceptions;

public final class UnsubscribeFailedException extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsubscribeFailedException(Throwable th) {
        super(th == null ? new NullPointerException() : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsubscribeFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }
}
