package rx.observers;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;
import rx.exceptions.CompositeException;

@Deprecated
public class TestObserver<T> implements Observer<T> {
    private static final Observer<Object> INERT = new Observer<Object>() {
        public void onCompleted() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }
    };
    private final Observer<T> delegate;
    private final List<Notification<T>> onCompletedEvents;
    private final List<Throwable> onErrorEvents;
    private final List<T> onNextEvents;

    public TestObserver(Observer<T> observer) {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = observer;
    }

    public TestObserver() {
        this.onNextEvents = new ArrayList();
        this.onErrorEvents = new ArrayList();
        this.onCompletedEvents = new ArrayList();
        this.delegate = INERT;
    }

    public void onCompleted() {
        this.onCompletedEvents.add(Notification.createOnCompleted());
        this.delegate.onCompleted();
    }

    public List<Notification<T>> getOnCompletedEvents() {
        return Collections.unmodifiableList(this.onCompletedEvents);
    }

    public void onError(Throwable th) {
        this.onErrorEvents.add(th);
        this.delegate.onError(th);
    }

    public List<Throwable> getOnErrorEvents() {
        return Collections.unmodifiableList(this.onErrorEvents);
    }

    public void onNext(T t) {
        this.onNextEvents.add(t);
        this.delegate.onNext(t);
    }

    public List<T> getOnNextEvents() {
        return Collections.unmodifiableList(this.onNextEvents);
    }

    public List<Object> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.onNextEvents);
        arrayList.add(this.onErrorEvents);
        arrayList.add(this.onCompletedEvents);
        return Collections.unmodifiableList(arrayList);
    }

    public void assertReceivedOnNext(List<T> list) {
        if (this.onNextEvents.size() != list.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Number of items does not match. Provided: ");
            sb.append(list.size());
            sb.append("  Actual: ");
            sb.append(this.onNextEvents.size());
            sb.append(".\nProvided values: ");
            sb.append(list);
            sb.append("\nActual values: ");
            sb.append(this.onNextEvents);
            sb.append(StringUtils.EOL);
            assertionError(sb.toString());
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            Object obj2 = this.onNextEvents.get(i);
            String str = "Value at index: ";
            if (obj == null) {
                if (obj2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(i);
                    sb2.append(" expected to be [null] but was: [");
                    sb2.append(obj2);
                    sb2.append("]\n");
                    assertionError(sb2.toString());
                }
            } else if (!obj.equals(obj2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(i);
                sb3.append(" expected to be [");
                sb3.append(obj);
                String str2 = "] (";
                sb3.append(str2);
                sb3.append(obj.getClass().getSimpleName());
                sb3.append(") but was: [");
                sb3.append(obj2);
                sb3.append(str2);
                sb3.append(obj2 != null ? obj2.getClass().getSimpleName() : "null");
                sb3.append(")\n");
                assertionError(sb3.toString());
            }
        }
    }

    public void assertTerminalEvent() {
        if (this.onErrorEvents.size() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Too many onError events: ");
            sb.append(this.onErrorEvents.size());
            assertionError(sb.toString());
        }
        if (this.onCompletedEvents.size() > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Too many onCompleted events: ");
            sb2.append(this.onCompletedEvents.size());
            assertionError(sb2.toString());
        }
        if (this.onCompletedEvents.size() == 1 && this.onErrorEvents.size() == 1) {
            assertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.onCompletedEvents.isEmpty() && this.onErrorEvents.isEmpty()) {
            assertionError("No terminal events received.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void assertionError(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 32);
        sb.append(str);
        sb.append(" (");
        int size = this.onCompletedEvents.size();
        sb.append(size);
        sb.append(" completion");
        if (size != 1) {
            sb.append('s');
        }
        sb.append(')');
        if (!this.onErrorEvents.isEmpty()) {
            int size2 = this.onErrorEvents.size();
            sb.append(" (+");
            sb.append(size2);
            sb.append(" error");
            if (size2 != 1) {
                sb.append('s');
            }
            sb.append(')');
        }
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.onErrorEvents.isEmpty()) {
            if (this.onErrorEvents.size() == 1) {
                assertionError.initCause((Throwable) this.onErrorEvents.get(0));
            } else {
                assertionError.initCause(new CompositeException((Collection<? extends Throwable>) this.onErrorEvents));
            }
        }
        throw assertionError;
    }
}
