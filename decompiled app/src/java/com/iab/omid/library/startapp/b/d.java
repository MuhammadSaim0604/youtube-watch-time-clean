package com.iab.omid.library.startapp.b;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class d {
    private static d a = new d();

    private d() {
    }

    public static d a() {
        return a;
    }

    @VisibleForTesting
    private void a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            a(sb, objArr);
            sb.append(")}");
            a(webView, sb);
        }
    }

    @VisibleForTesting
    private void a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() { // from class: com.iab.omid.library.startapp.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    @VisibleForTesting
    private static void a(StringBuilder sb, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append('\"').append('\"');
            } else if (obj instanceof String) {
                String obj2 = obj.toString();
                if (obj2.startsWith("{")) {
                    sb.append(obj2);
                } else {
                    sb.append('\"').append(obj2).append('\"');
                }
            } else {
                sb.append(obj);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }

    public static boolean a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: ".concat(String.valueOf(str)));
        return true;
    }

    public final void a(WebView webView) {
        a(webView, "finishSession", new Object[0]);
    }

    public final void a(WebView webView, float f) {
        a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    public final void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(webView, "publishVideoEvent", str, jSONObject);
        } else {
            a(webView, "publishVideoEvent", str);
        }
    }

    public final void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        a(webView, "startSession", str, jSONObject, jSONObject2);
    }

    public final void a(WebView webView, JSONObject jSONObject) {
        a(webView, "init", jSONObject);
    }

    public final void b(WebView webView) {
        a(webView, "publishImpressionEvent", new Object[0]);
    }

    public final void b(WebView webView, String str) {
        a(webView, "setNativeViewHierarchy", str);
    }

    public final void c(WebView webView, String str) {
        a(webView, "setState", str);
    }
}
