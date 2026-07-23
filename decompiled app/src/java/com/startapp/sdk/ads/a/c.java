package com.startapp.sdk.ads.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.commontracking.CloseTrackingParams;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.h;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.concurrent.TimeUnit;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
public class c extends b {
    protected WebView c;
    protected com.iab.omid.library.startapp.adsession.b d;
    protected RelativeLayout e;
    private Long l;
    private Long m;
    private h n;
    protected long f = 0;
    protected boolean g = true;
    protected boolean h = false;
    protected int i = 0;
    protected boolean j = false;
    protected Runnable k = new Runnable() { // from class: com.startapp.sdk.ads.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            c.this.B();
            c.this.p();
        }
    };
    private Runnable o = new Runnable() { // from class: com.startapp.sdk.ads.a.c.2
        @Override // java.lang.Runnable
        public final void run() {
            c.this.g = true;
            WebView webView = c.this.c;
            if (webView == null) {
                return;
            }
            webView.setOnTouchListener(null);
        }
    };

    @Override // com.startapp.sdk.ads.a.b
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            if (b().hasExtra("lastLoadTime")) {
                this.l = (Long) b().getSerializableExtra("lastLoadTime");
            }
            if (b().hasExtra("adCacheTtl")) {
                this.m = (Long) b().getSerializableExtra("adCacheTtl");
                return;
            }
            return;
        }
        if (bundle.containsKey("postrollHtml")) {
            a(bundle.getString("postrollHtml"));
        }
        if (bundle.containsKey("lastLoadTime")) {
            this.l = (Long) bundle.getSerializable("lastLoadTime");
        }
        if (bundle.containsKey("adCacheTtl")) {
            this.m = (Long) bundle.getSerializable("adCacheTtl");
        }
        this.h = bundle.getBoolean("videoCompletedBroadcastSent", false);
        this.i = bundle.getInt("replayNum");
    }

    @Override // com.startapp.sdk.ads.a.b
    public void b(Bundle bundle) {
        super.b(bundle);
        if (g() != null) {
            bundle.putString("postrollHtml", g());
        }
        if (this.l != null) {
            bundle.putLong("lastLoadTime", this.l.longValue());
        }
        if (this.m != null) {
            bundle.putLong("adCacheTtl", this.m.longValue());
        }
        bundle.putBoolean("videoCompletedBroadcastSent", this.h);
        bundle.putInt("replayNum", this.i);
    }

    @Override // com.startapp.sdk.ads.a.b
    public void u() {
        boolean z;
        if (x() instanceof InterstitialAd) {
            z = ((InterstitialAd) x()).e_();
        } else {
            z = false;
        }
        if (z) {
            p();
            return;
        }
        k.a().a(true);
        if (this.n == null) {
            this.n = new h(c(), i(), C(), E());
        }
        if (this.c == null) {
            this.e = new RelativeLayout(c());
            this.e.setContentDescription("StartApp Ad");
            this.e.setId(1475346432);
            c().setContentView(this.e);
            try {
                this.c = new WebView(c().getApplicationContext());
                this.c.setBackgroundColor(-16777216);
                c().getWindow().getDecorView().findViewById(16908290).setBackgroundColor(7829367);
                this.c.setVerticalScrollBarEnabled(false);
                this.c.setHorizontalScrollBarEnabled(false);
                this.c.getSettings().setJavaScriptEnabled(true);
                com.startapp.common.b.b.a(this.c);
                this.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.startapp.sdk.ads.a.c.3
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return true;
                    }
                });
                this.c.setLongClickable(false);
                this.c.addJavascriptInterface(z(), "startappwall");
                A();
                a(this.c);
                u.a(c(), this.c, g());
                this.j = "true".equals(u.a(g(), "@jsTag@", "@jsTag@"));
                y();
                this.e.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
                a(this.e);
            } catch (Throwable th) {
                new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) c());
                p();
            }
        } else {
            com.startapp.common.b.b.c(this.c);
            this.n.a();
        }
        this.f = SystemClock.uptimeMillis();
    }

    @Override // com.startapp.sdk.ads.a.b
    public final void w() {
        super.w();
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
        u.a(this.c);
    }

    protected void y() {
        this.c.setWebViewClient(new a());
        this.c.setWebChromeClient(new WebChromeClient());
    }

    protected com.startapp.sdk.d.b z() {
        return new com.startapp.sdk.d.b(c(), this.k, this.k, this.o, a(), a(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        this.n.a();
    }

    public void a(WebView webView) {
        this.g = false;
        webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.startapp.sdk.ads.a.c.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.g = true;
                return motionEvent.getAction() == 2;
            }
        });
    }

    protected void b(WebView webView) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        View a2;
        if (MetaData.E().Q() && this.d == null) {
            this.d = com.startapp.sdk.omsdk.a.a(this.c);
            if (this.d != null && this.c != null) {
                if (this.a != null && (a2 = this.a.a()) != null) {
                    this.d.b(a2);
                }
                if (view != null) {
                    this.d.b(view);
                }
                this.d.a(this.c);
                this.d.a();
                com.iab.omid.library.startapp.adsession.a.a(this.d).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, Object... objArr) {
        u.a(this.c, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long a(long j) {
        long j2 = j % 1000;
        long j3 = j2;
        if (j2 == 0) {
            j3 = 1000;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/0.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            c.this.b(webView);
            c.this.a("gClientInterface.setMode", c.this.h());
            c.this.a("enableScheme", "externalLinks");
            c.this.a((View) null);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (webView == null || str == null) {
                return true;
            }
            if (u.a(webView.getContext(), str)) {
                return true;
            }
            if (!c.this.g) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("fake_click").h(c.this.n()).g("jsTag=" + c.this.j).a((Context) c.this.c());
            }
            if (c.this.j && !c.this.g) {
                return false;
            }
            return c.this.a(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r0
            com.startapp.sdk.adsbase.h r5 = r5.n
            r6 = 1
            r5.a(r6)
            r5 = r0
            com.startapp.sdk.adsbase.Ad r5 = r5.x()
            r3 = r5
            r5 = r0
            android.app.Activity r5 = r5.c()
            android.content.Context r5 = r5.getApplicationContext()
            r6 = r0
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r6 = r6.b
            boolean r5 = com.startapp.sdk.adsbase.a.a(r5, r6)
            if (r5 == 0) goto L5b
            r5 = 8
            boolean r5 = com.startapp.sdk.adsbase.j.u.a(r5)
            if (r5 == 0) goto L59
            r5 = r3
            boolean r5 = r5 instanceof com.startapp.sdk.ads.splash.SplashAd
            if (r5 == 0) goto L59
            r5 = 1
        L30:
            if (r5 != 0) goto L5b
            r5 = 1
        L33:
            r3 = r5
            r5 = r0
            r6 = r1
            boolean r5 = r5.b(r6)
            if (r5 == 0) goto L69
            r5 = r1
            int r5 = com.startapp.sdk.adsbase.a.a(r5)     // Catch: java.lang.Exception -> L65
            r4 = r5
            r5 = r0
            boolean[] r5 = r5.d()     // Catch: java.lang.Exception -> L65
            r6 = r4
            boolean r5 = r5[r6]     // Catch: java.lang.Exception -> L65
            if (r5 == 0) goto L5d
            r5 = r3
            if (r5 != 0) goto L5d
            r5 = r0
            r6 = r1
            r7 = r4
            r8 = r2
            r5.a(r6, r7, r8)     // Catch: java.lang.Exception -> L65
        L56:
            r5 = 1
            r0 = r5
        L58:
            return r0
        L59:
            r5 = 0
            goto L30
        L5b:
            r5 = 0
            goto L33
        L5d:
            r5 = r0
            r6 = r1
            r7 = r4
            r8 = r2
            r5.b(r6, r7, r8)     // Catch: java.lang.Exception -> L65
            goto L56
        L65:
            r5 = move-exception
            r5 = 0
            r0 = r5
            goto L58
        L69:
            r5 = r0
            boolean[] r5 = r5.d()
            r6 = 0
            boolean r5 = r5[r6]
            if (r5 == 0) goto L7e
            r5 = r3
            if (r5 != 0) goto L7e
            r5 = r0
            r6 = r1
            r7 = 0
            r8 = r2
            r5.a(r6, r7, r8)
            goto L56
        L7e:
            r5 = r0
            r6 = r1
            r7 = 0
            r8 = r2
            r5.b(r6, r7, r8)
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.a.c.a(java.lang.String, boolean):boolean");
    }

    protected boolean b(String str) {
        return !this.j && str.contains("index=");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        String[] l = l();
        if (l != null && l.length > 0 && l()[0] != null) {
            com.startapp.sdk.adsbase.a.b(c(), l()[0], a());
        }
    }

    private void a(String str, int i, boolean z) {
        String str2;
        String str3;
        Activity c = c();
        if (i < j().length) {
            str2 = j()[i];
        } else {
            str2 = null;
        }
        if (i < k().length) {
            str3 = k()[i];
        } else {
            str3 = null;
        }
        com.startapp.sdk.adsbase.a.a(c, str, str2, str3, a(), AdsCommonMetaData.a().B(), AdsCommonMetaData.a().C(), a(i), b(i), z, new Runnable() { // from class: com.startapp.sdk.ads.a.c.5
            @Override // java.lang.Runnable
            public final void run() {
                c.this.p();
            }
        });
    }

    private void b(String str, int i, boolean z) {
        String str2;
        com.startapp.common.b.a(c()).a(new Intent("com.startapp.android.OnClickCallback"));
        boolean a2 = com.startapp.sdk.adsbase.a.a(c().getApplicationContext(), this.b);
        Activity c = c();
        if (i < j().length) {
            str2 = j()[i];
        } else {
            str2 = null;
        }
        com.startapp.sdk.adsbase.a.a(c, str, str2, a(), a(i) && !a2, z);
        p();
    }

    @Override // com.startapp.sdk.ads.a.b
    public void p() {
        super.p();
        k.a().a(false);
        if (this.n != null) {
            this.n.a(false);
        }
        c().runOnUiThread(new Runnable() { // from class: com.startapp.sdk.ads.a.c.6
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.c != null) {
                    com.startapp.common.b.b.b(c.this.c);
                }
            }
        });
    }

    @Override // com.startapp.sdk.ads.a.b
    public void s() {
        if (this.n != null) {
            this.n.b();
        }
        if (this.a != null && this.a.b()) {
            this.a.e();
        }
        if (this.c != null) {
            com.startapp.common.b.b.b(this.c);
        }
        if (h().equals("back")) {
            p();
        }
    }

    private TrackingParams a() {
        return new CloseTrackingParams(D(), m());
    }

    protected TrackingParams C() {
        return new TrackingParams(m());
    }

    protected long D() {
        return (SystemClock.uptimeMillis() - this.f) / 1000;
    }

    @Override // com.startapp.sdk.ads.a.b
    public boolean r() {
        B();
        k.a().a(false);
        this.n.a(false);
        return false;
    }

    protected long E() {
        return o() != null ? TimeUnit.SECONDS.toMillis(o().longValue()) : TimeUnit.SECONDS.toMillis(MetaData.E().F());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F() {
        if (H() && !this.h && this.i == 0) {
            this.h = true;
            com.startapp.common.b.a(c()).a(new Intent("com.startapp.android.OnVideoCompleted"));
            G();
        }
    }

    protected void G() {
    }

    protected boolean H() {
        return false;
    }
}
