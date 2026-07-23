package com.startapp.common.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.startapp.adsession.AdSessionContextType;
import com.startapp.networkTest.utils.e;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public final class a {
    private static CookieManager a;
    private final com.startapp.networkTest.utils.a b;
    private final WebView c;
    private final List<e> d = new ArrayList();
    private final String e;
    private final String f;
    private final AdSessionContextType g;

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return;
        }
        a = new CookieManager(new b(context), CookiePolicy.ACCEPT_ALL);
    }

    public static void a(HttpURLConnection httpURLConnection, String str) throws IOException {
        CookieManager cookieManager;
        Map<String, List<String>> map;
        if (Build.VERSION.SDK_INT >= 9 && (cookieManager = a) != null && (map = cookieManager.get(URI.create(str), httpURLConnection.getRequestProperties())) != null && map.size() > 0 && map.get("Cookie").size() > 0) {
            httpURLConnection.addRequestProperty("Cookie", TextUtils.join("=", map.get("Cookie")));
        }
    }

    public static CookieManager a() {
        return a;
    }

    private a(com.startapp.networkTest.utils.a aVar, WebView webView, String str, List<e> list, String str2) {
        this.b = aVar;
        this.c = webView;
        this.e = str;
        if (list != null) {
            this.d.addAll(list);
            this.g = AdSessionContextType.NATIVE;
        } else {
            this.g = AdSessionContextType.HTML;
        }
        this.f = str2;
    }

    public static a a(com.startapp.networkTest.utils.a aVar, WebView webView, String str) {
        com.iab.omid.library.startapp.b.a(aVar, "Partner is null");
        com.iab.omid.library.startapp.b.a(webView, "WebView is null");
        com.iab.omid.library.startapp.b.c(str, "CustomReferenceData is greater than 256 characters");
        return new a(aVar, webView, null, null, str);
    }

    public static a a(com.startapp.networkTest.utils.a aVar, String str, List<e> list, String str2) {
        com.iab.omid.library.startapp.b.a(aVar, "Partner is null");
        com.iab.omid.library.startapp.b.a((Object) str, "OMID JS script content is null");
        com.iab.omid.library.startapp.b.a(list, "VerificationScriptResources is null");
        com.iab.omid.library.startapp.b.c(str2, "CustomReferenceData is greater than 256 characters");
        return new a(aVar, null, str, list, str2);
    }

    public final com.startapp.networkTest.utils.a b() {
        return this.b;
    }

    public final List<e> c() {
        return Collections.unmodifiableList(this.d);
    }

    public final WebView d() {
        return this.c;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.e;
    }

    public final AdSessionContextType g() {
        return this.g;
    }
}
