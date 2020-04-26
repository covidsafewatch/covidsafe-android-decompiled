package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"okhttp3/Interceptor$Companion$invoke$1", "Lokhttp3/Interceptor;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Interceptor.kt */
public final class OkHttpClient$Builder$addNetworkInterceptor$$inlined$invoke$1 implements Interceptor {
    final /* synthetic */ Function1 $block$inlined;

    public OkHttpClient$Builder$addNetworkInterceptor$$inlined$invoke$1(Function1 function1) {
        this.$block$inlined = function1;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        return (Response) this.$block$inlined.invoke(chain);
    }
}
