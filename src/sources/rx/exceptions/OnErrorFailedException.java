package rx.exceptions;

public class OnErrorFailedException extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorFailedException(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorFailedException(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
    }
}
