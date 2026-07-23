package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class SplashEventHandler implements c {
    Activity a;
    boolean b;
    SplashState c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private SplashHtml i;
    private BroadcastReceiver j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public enum SplashState {
        LOADING,
        RECEIVED,
        DISPLAYED,
        HIDDEN,
        DO_NOT_DISPLAY
    }

    public SplashEventHandler(Activity activity) {
        this.d = false;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.b = false;
        this.c = SplashState.LOADING;
        this.i = null;
        this.j = new BroadcastReceiver() { // from class: com.startapp.sdk.ads.splash.SplashEventHandler.2
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                SplashEventHandler.this.f();
            }
        };
        this.a = activity;
    }

    public SplashEventHandler(Activity activity, SplashHtml splashHtml) {
        this(activity);
        this.i = splashHtml;
    }

    public final void a(final Runnable runnable, final CacheKey cacheKey) {
        this.d = true;
        com.startapp.sdk.adsbase.remoteconfig.b bVar = new com.startapp.sdk.adsbase.remoteconfig.b() { // from class: com.startapp.sdk.ads.splash.SplashEventHandler.1
            private Runnable d = new Runnable() { // from class: com.startapp.sdk.ads.splash.SplashEventHandler.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    SplashEventHandler.this.b = true;
                    if (SplashEventHandler.this.c != SplashState.DO_NOT_DISPLAY) {
                        SplashEventHandler.this.c(runnable, cacheKey);
                    }
                }
            };

            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a(MetaDataRequest.RequestReason requestReason, boolean z) {
                SplashEventHandler.this.a.runOnUiThread(this.d);
            }

            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a() {
                SplashEventHandler.this.a.runOnUiThread(this.d);
            }
        };
        if (this.c == SplashState.DO_NOT_DISPLAY) {
            i();
            return;
        }
        synchronized (MetaData.h()) {
            if (MetaData.E().i()) {
                bVar.a(null, false);
            } else {
                MetaData.E().a(bVar);
            }
        }
    }

    public final void a() {
        this.d = true;
    }

    public final void a(Runnable runnable) {
        if (this.c == SplashState.LOADING) {
            this.c = SplashState.RECEIVED;
        }
        b(runnable);
    }

    public final void b() {
        this.c = SplashState.DO_NOT_DISPLAY;
        b(null);
    }

    public final boolean b(Runnable runnable, CacheKey cacheKey) {
        if (!this.h) {
            if (this.c == SplashState.LOADING) {
                this.e = false;
                this.c = SplashState.DO_NOT_DISPLAY;
                i();
                return true;
            } else if (this.c == SplashState.RECEIVED) {
                this.b = true;
                c(runnable, cacheKey);
            }
        }
        return false;
    }

    final void c(Runnable runnable, CacheKey cacheKey) {
        AdRulesResult a = AdaptMetaData.a().b().a(AdPreferences.Placement.INAPP_SPLASH, (String) null);
        new StringBuilder("checkAdRulesAndShowAd: shouldDisplayAd ").append(a.a());
        if (a.a()) {
            b(runnable);
            return;
        }
        this.c = SplashState.DO_NOT_DISPLAY;
        if (cacheKey != null) {
            com.startapp.sdk.adsbase.a.a(this.a, com.startapp.sdk.adsbase.a.a(com.startapp.sdk.adsbase.cache.a.a().b(cacheKey)), (String) null, a.c());
        }
        i();
    }

    public final void c() {
        this.c = SplashState.HIDDEN;
        j();
        if (!this.a.isFinishing()) {
            this.a.finish();
        }
    }

    private void b(Runnable runnable) {
        if (this.d) {
            if (this.b || runnable == null) {
                if (this.c == SplashState.RECEIVED && runnable != null) {
                    this.e = false;
                    runnable.run();
                } else if (this.c != SplashState.LOADING) {
                    i();
                }
            }
        }
    }

    public final void a(StartAppAd startAppAd) {
        if (this.c == SplashState.DISPLAYED && !this.g) {
            startAppAd.close();
            c();
        }
    }

    public final void d() {
        if (this.c != SplashState.DISPLAYED && this.c != SplashState.DO_NOT_DISPLAY) {
            this.c = SplashState.DO_NOT_DISPLAY;
            if (!this.e) {
                return;
            }
            j();
        }
    }

    private void i() {
        a(this.i, this);
    }

    private void j() {
        if (!this.f) {
            this.f = true;
            com.startapp.common.b.a(this.a).a(new Intent("com.startapp.android.splashHidden"));
        }
        if (this.j != null) {
            try {
                com.startapp.common.b.a(this.a).a(this.j);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public final void e() {
        this.h = true;
    }

    public final void f() {
        this.g = true;
    }

    public final void g() {
        com.startapp.common.b.a(this.a).a(this.j, new IntentFilter("com.startapp.android.adInfoWasClickedBroadcastListener"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(SplashHtml splashHtml, c cVar) {
        if (splashHtml == null) {
            cVar.h();
            return;
        }
        splashHtml.callback = cVar;
        splashHtml.b();
    }

    @Override // com.startapp.sdk.ads.splash.c
    public final void h() {
        j();
        if (!this.a.isFinishing()) {
            this.a.finish();
        }
    }
}
