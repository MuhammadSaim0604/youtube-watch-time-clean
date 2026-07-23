package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class SplashScreen {
    Activity a;
    SplashEventHandler b;
    CacheKey c;
    SplashHtml d;
    SplashStartAppAd f;
    private SplashConfig h;
    private AdPreferences j;
    private Handler i = new Handler();
    boolean e = false;
    private Runnable k = new Runnable() { // from class: com.startapp.sdk.ads.splash.SplashScreen.1
        @Override // java.lang.Runnable
        public final void run() {
            if (SplashScreen.this.c()) {
                SplashScreen.this.d();
                SplashScreen.this.e();
                return;
            }
            SplashScreen.this.a.finish();
        }
    };
    Runnable g = new AnonymousClass2();
    private AdEventListener l = new AdEventListener() { // from class: com.startapp.sdk.ads.splash.SplashScreen.3
        @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
        public final void onReceiveAd(Ad ad) {
            SplashScreen.this.b.a(SplashScreen.this.g);
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
        public final void onFailedToReceiveAd(Ad ad) {
            if (SplashScreen.this.f != null) {
                SplashScreen.this.b.b();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class SplashStartAppAd extends StartAppAd {
        private static final long serialVersionUID = 1;

        public SplashStartAppAd(Context context) {
            super(context);
            this.placement = AdPreferences.Placement.INAPP_SPLASH;
        }

        @Override // com.startapp.sdk.adsbase.StartAppAd
        protected final AdRulesResult a(String str, AdPreferences.Placement placement) {
            return new AdRulesResult();
        }
    }

    public SplashScreen(Activity activity, SplashConfig splashConfig, AdPreferences adPreferences) {
        this.d = null;
        this.a = activity;
        this.h = splashConfig;
        this.j = adPreferences;
        try {
            this.h.a(this.a);
            if (!g()) {
                this.d = this.h.b(this.a);
            }
            this.b = new SplashEventHandler(activity, this.d);
        } catch (Throwable th) {
            this.b = new SplashEventHandler(activity);
            this.b.a();
            this.b.b();
            new com.startapp.sdk.adsbase.infoevents.e(th).a((Context) activity);
        }
    }

    public final void a() {
        this.b.g();
        boolean z = false;
        int i = this.a.getResources().getConfiguration().orientation;
        if (this.h.getOrientation() == SplashConfig.Orientation.AUTO) {
            if (i == 2) {
                this.h.setOrientation(SplashConfig.Orientation.LANDSCAPE);
            } else {
                this.h.setOrientation(SplashConfig.Orientation.PORTRAIT);
            }
        }
        switch (this.h.getOrientation()) {
            case PORTRAIT:
                if (i == 2) {
                    z = true;
                }
                com.startapp.common.b.b.a(this.a);
                break;
            case LANDSCAPE:
                if (i == 1) {
                    z = true;
                }
                com.startapp.common.b.b.b(this.a);
                break;
        }
        new StringBuilder("Set Orientation: [").append(this.h.getOrientation().toString()).append("]");
        if (!z) {
            this.i.post(this.k);
        } else {
            this.i.postDelayed(this.k, 100L);
        }
    }

    public final void b() {
        this.i.removeCallbacks(this.k);
        this.b.d();
    }

    final boolean c() {
        if (!this.h.a((Context) this.a)) {
            throw new IllegalArgumentException(this.h.getErrorMessage());
        }
        WebView webView = null;
        if (g()) {
            webView = this.h.b((Context) this.a);
        } else if (this.d != null) {
            webView = this.d.c();
        }
        WebView webView2 = webView;
        if (webView2 != null) {
            this.a.setContentView(webView2, new ViewGroup.LayoutParams(-1, -1));
            return true;
        }
        return false;
    }

    final void d() {
        this.f = new SplashStartAppAd(this.a.getApplicationContext());
        this.c = this.f.loadSplash(this.j, this.l);
    }

    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.ads.splash.SplashScreen$2  reason: invalid class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SplashEventHandler.a(SplashScreen.this.d, new c() { // from class: com.startapp.sdk.ads.splash.SplashScreen.2.1
                @Override // com.startapp.sdk.ads.splash.c
                public final void h() {
                    if (!SplashScreen.this.e && SplashScreen.this.f != null) {
                        SplashScreen.this.f.showAd(new AdDisplayListener() { // from class: com.startapp.sdk.ads.splash.SplashScreen.2.1.1
                            @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                            public final void adHidden(Ad ad) {
                                SplashScreen.this.b.c();
                            }

                            @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                            public final void adDisplayed(Ad ad) {
                                SplashScreen.this.b.c = SplashEventHandler.SplashState.DISPLAYED;
                            }

                            @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                            public final void adClicked(Ad ad) {
                                SplashScreen.this.b.f();
                            }

                            @Override // com.startapp.sdk.adsbase.adlisteners.AdDisplayListener
                            public final void adNotDisplayed(Ad ad) {
                            }
                        });
                        SplashScreen.this.f();
                        SplashScreen.this.a.finish();
                    }
                }
            });
        }
    }

    final void e() {
        this.i.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.splash.SplashScreen.4
            @Override // java.lang.Runnable
            public final void run() {
                if (SplashScreen.this.b.b(SplashScreen.this.g, SplashScreen.this.c)) {
                    SplashScreen.this.f = null;
                    SplashScreen.this.c = null;
                }
            }
        }, this.h.a().longValue());
        this.i.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.splash.SplashScreen.5
            @Override // java.lang.Runnable
            public final void run() {
                SplashScreen.this.b.a(SplashScreen.this.g, SplashScreen.this.c);
            }
        }, this.h.getMinSplashTime().getIndex());
    }

    final void f() {
        if (this.h.getMaxAdDisplayTime() != SplashConfig.MaxAdDisplayTime.FOR_EVER) {
            this.i.postDelayed(new Runnable() { // from class: com.startapp.sdk.ads.splash.SplashScreen.6
                @Override // java.lang.Runnable
                public final void run() {
                    SplashScreen.this.b.a(SplashScreen.this.f);
                }
            }, this.h.getMaxAdDisplayTime().getIndex());
        }
    }

    private boolean g() {
        return !this.h.isHtmlSplash() || this.h.c();
    }
}
