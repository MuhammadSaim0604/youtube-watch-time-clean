package com.startapp.sdk.ads.a;

import android.os.Handler;
import android.webkit.WebView;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class f extends c {
    @Override // com.startapp.sdk.ads.a.c
    public final void a(WebView webView) {
        super.a(webView);
        if (h().equals("interstitial")) {
            webView.setBackgroundColor(0);
        }
    }

    @Override // com.startapp.sdk.ads.a.c
    protected final void b(final WebView webView) {
        new Handler().postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    webView.setBackgroundColor(0);
                } catch (Exception e) {
                }
            }
        }, 1000L);
    }
}
