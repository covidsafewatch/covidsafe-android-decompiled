package okhttp3.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"okhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DEFAULT$1", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "log", "", "message", "", "okhttp-logging-interceptor"}, k = 1, mv = {1, 1, 16})
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor$Logger$Companion$DEFAULT$1 implements HttpLoggingInterceptor.Logger {
    HttpLoggingInterceptor$Logger$Companion$DEFAULT$1() {
    }

    public void log(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
    }
}
