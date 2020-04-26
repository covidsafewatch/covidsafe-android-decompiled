package com.atlassian.mobilekit.module.feedback.commands;

import android.os.Looper;
import com.atlassian.mobilekit.module.core.Command;
import com.atlassian.mobilekit.module.core.Receiver;
import com.atlassian.mobilekit.module.core.UiNotifier;
import com.atlassian.mobilekit.module.core.UiReceiver;

abstract class AbstractCommand<T> implements Command {
    /* access modifiers changed from: private */
    public final Receiver<T> receiver;
    private final UiNotifier uiNotifier;

    AbstractCommand(Receiver<T> receiver2, UiNotifier uiNotifier2) {
        this.receiver = receiver2;
        this.uiNotifier = uiNotifier2;
    }

    /* access modifiers changed from: 0000 */
    public void updateReceiver(final T t) {
        Receiver<T> receiver2 = this.receiver;
        if (receiver2 != null) {
            if (!(receiver2 instanceof UiReceiver) || isMainThread()) {
                this.receiver.receive(t);
            } else {
                this.uiNotifier.post(new Runnable() {
                    public void run() {
                        AbstractCommand.this.receiver.receive(t);
                    }
                });
            }
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
