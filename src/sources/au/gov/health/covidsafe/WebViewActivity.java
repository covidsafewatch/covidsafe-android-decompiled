package au.gov.health.covidsafe;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lau/gov/health/covidsafe/WebViewActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity extends FragmentActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String URL_ARG = URL_ARG;
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/WebViewActivity$Companion;", "", "()V", "URL_ARG", "", "getURL_ARG", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: WebViewActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getURL_ARG() {
            return WebViewActivity.URL_ARG;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.webview);
        WebView webView = (WebView) findViewById(R.id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView, "webView");
        webView.setWebViewClient(new WebViewClient());
        CharSequence stringExtra = getIntent().getStringExtra(URL_ARG);
        if (stringExtra == null || StringsKt.isBlank(stringExtra)) {
            webView.loadUrl("https://www.australia.gov.au");
        } else {
            webView.loadUrl(getIntent().getStringExtra(URL_ARG));
        }
        webView.setWebChromeClient(new WebViewActivity$onCreate$wbc$1());
    }
}
