package rx.plugins;

import rx.exceptions.Exceptions;

public abstract class RxJavaErrorHandler {
    protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Deprecated
    public void handleError(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public String render(Object obj) throws InterruptedException {
        return null;
    }

    public final String handleOnNextValueRendering(Object obj) {
        try {
            return render(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            StringBuilder sb = new StringBuilder();
            sb.append(obj.getClass().getName());
            sb.append(ERROR_IN_RENDERING_SUFFIX);
            return sb.toString();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj.getClass().getName());
            sb2.append(ERROR_IN_RENDERING_SUFFIX);
            return sb2.toString();
        }
    }
}
