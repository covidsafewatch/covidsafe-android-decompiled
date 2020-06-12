package au.gov.health.covidsafe.extensions;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isInternetAvailable", "", "Landroid/content/Context;", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: NetworkExtensions.kt */
public final class NetworkExtensionsKt {
    public static final boolean isInternetAvailable(Context context) {
        int type;
        Intrinsics.checkParameterIsNotNull(context, "$this$isInternetAvailable");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null) {
                    return false;
                }
                if (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
                    return true;
                }
                return false;
            }
            for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
                Intrinsics.checkExpressionValueIsNotNull(networkInfo, "networkInfo");
                if (networkInfo.isConnected() && ((type = networkInfo.getType()) == 0 || type == 1 || type == 9)) {
                    return true;
                }
            }
        }
        return false;
    }
}
