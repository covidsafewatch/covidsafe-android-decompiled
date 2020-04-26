package au.gov.health.covidsafe.logging;

import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lau/gov/health/covidsafe/logging/CentralLog;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CentralLog.kt */
public final class CentralLog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static PowerManager pm;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eJ\b\u0010\u000f\u001a\u00020\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lau/gov/health/covidsafe/logging/CentralLog$Companion;", "", "()V", "pm", "Landroid/os/PowerManager;", "d", "", "tag", "", "message", "e", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getIdleStatus", "i", "setPowerManager", "powerManager", "shouldLog", "", "w", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: CentralLog.kt */
    public static final class Companion {
        private final boolean shouldLog() {
            return false;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setPowerManager(PowerManager powerManager) {
            Intrinsics.checkParameterIsNotNull(powerManager, "powerManager");
            CentralLog.pm = powerManager;
        }

        private final String getIdleStatus() {
            if (Build.VERSION.SDK_INT < 23) {
                return " NO-DOZE-FEATURE ";
            }
            PowerManager access$getPm$cp = CentralLog.pm;
            return (access$getPm$cp == null || true != access$getPm$cp.isDeviceIdleMode()) ? " NOT-IDLE " : " IDLE ";
        }

        public final void d(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.d(str, companion.getIdleStatus() + str2);
            }
        }

        public final void d(String str, String str2, Throwable th) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.d(str, companion.getIdleStatus() + str2, th);
            }
        }

        public final void w(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.w(str, companion.getIdleStatus() + str2);
            }
        }

        public final void i(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.i(str, companion.getIdleStatus() + str2);
            }
        }

        public final void e(String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.e(str, companion.getIdleStatus() + str2);
            }
        }

        public final void e(String str, String str2, Exception exc) {
            Intrinsics.checkParameterIsNotNull(str, "tag");
            Intrinsics.checkParameterIsNotNull(str2, "message");
            Intrinsics.checkParameterIsNotNull(exc, "exception");
            Companion companion = this;
            if (companion.shouldLog()) {
                Log.e(str, companion.getIdleStatus() + str2, exc);
            }
        }
    }
}
