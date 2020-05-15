package au.gov.health.covidsafe;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import au.gov.health.covidsafe.logging.CentralLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"au/gov/health/covidsafe/WebViewActivity$onCreate$wbc$1", "Landroid/webkit/WebChromeClient;", "onCloseWindow", "", "w", "Landroid/webkit/WebView;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity$onCreate$wbc$1 extends WebChromeClient {
    WebViewActivity$onCreate$wbc$1() {
    }

    public void onCloseWindow(WebView webView) {
        Intrinsics.checkParameterIsNotNull(webView, "w");
        CentralLog.Companion.d("WebViewActivity", "Window trying to close");
    }
}
