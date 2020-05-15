package au.gov.health.covidsafe.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"au/gov/health/covidsafe/ui/home/HelpFragment$createWebVieClient$1", "Landroid/webkit/WebViewClient;", "isRedirecting", "", "loadFinished", "onPageFinished", "", "webView", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: HelpFragment.kt */
public final class HelpFragment$createWebVieClient$1 extends WebViewClient {
    final /* synthetic */ View $view;
    private boolean isRedirecting;
    private boolean loadFinished;

    HelpFragment$createWebVieClient$1(View view) {
        this.$view = view;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkParameterIsNotNull(webView, "webView");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        if (!this.loadFinished) {
            this.isRedirecting = true;
        }
        this.loadFinished = false;
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "request.url.toString()");
        if (Intrinsics.areEqual((Object) uri, (Object) "https://www.covidsafe.gov.au/help-topics.html")) {
            webView.loadUrl(webResourceRequest.getUrl().toString());
        } else {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(uri)));
        }
        return true;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(webView, "webView");
        super.onPageStarted(webView, str, bitmap);
        this.loadFinished = false;
        ProgressBar progressBar = (ProgressBar) this.$view.findViewById(R.id.progress);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "view.progress");
        progressBar.setVisibility(0);
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkParameterIsNotNull(webView, "webView");
        super.onPageFinished(webView, str);
        if (!this.isRedirecting) {
            this.loadFinished = true;
        }
        if (!this.loadFinished || this.isRedirecting) {
            this.isRedirecting = false;
            return;
        }
        ProgressBar progressBar = (ProgressBar) this.$view.findViewById(R.id.progress);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "view.progress");
        progressBar.setVisibility(8);
    }
}
