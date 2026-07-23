package com.iab.omid.library.startapp.publisher;

import android.webkit.WebView;
import com.iab.omid.library.startapp.b.d;
import com.startapp.sdk.ads.banner.banner3d.Banner3DSize;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public abstract class AdSessionStatePublisher {
    private com.iab.omid.library.startapp.e.a a;
    private com.iab.omid.library.startapp.adsession.a b;
    private Banner3DSize c;
    private a d;
    private double e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public AdSessionStatePublisher() {
        f();
        this.a = new com.iab.omid.library.startapp.e.a((WebView) null);
    }

    public void a() {
    }

    public final void a(float f) {
        d.a().a(c(), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WebView webView) {
        this.a = new com.iab.omid.library.startapp.e.a(webView);
    }

    public final void a(com.iab.omid.library.startapp.adsession.a aVar) {
        this.b = aVar;
    }

    public final void a(Banner3DSize banner3DSize) {
        this.c = banner3DSize;
    }

    public final void a(String str) {
        d.a().a(c(), str, (JSONObject) null);
    }

    public final void a(String str, double d) {
        if (d > this.e) {
            this.d = a.AD_STATE_VISIBLE;
            d.a().b(c(), str);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        d.a().a(c(), str, jSONObject);
    }

    public void b() {
        this.a.clear();
    }

    public final void b(String str, double d) {
        if (d <= this.e || this.d == a.AD_STATE_HIDDEN) {
            return;
        }
        this.d = a.AD_STATE_HIDDEN;
        d.a().b(c(), str);
    }

    public final WebView c() {
        return (WebView) this.a.get();
    }

    public final com.iab.omid.library.startapp.adsession.a d() {
        return this.b;
    }

    public final Banner3DSize e() {
        return this.c;
    }

    public final void f() {
        this.e = com.iab.omid.library.startapp.b.b();
        this.d = a.AD_STATE_IDLE;
    }

    public final void a(boolean z) {
        if (this.a.get() != null) {
            d.a().c(c(), z ? "foregrounded" : "backgrounded");
        }
    }
}
