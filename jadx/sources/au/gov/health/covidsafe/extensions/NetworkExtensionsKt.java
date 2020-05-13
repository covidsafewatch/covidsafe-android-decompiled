package au.gov.health.covidsafe.extensions;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isInternetAvailable", "", "Landroid/content/Context;", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: NetworkExtensions.kt */
public final class NetworkExtensionsKt {
    public static final boolean isInternetAvailable(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "$this$isInternetAvailable");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()) : null;
        if (networkCapabilities == null || (!networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(3))) {
            return false;
        }
        return true;
    }
}
