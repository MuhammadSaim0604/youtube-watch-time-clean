package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.startapp.sdk.ads.interstitials.OverlayAd;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class e {
    private static final String g = e.class.getSimpleName();
    protected f a;
    protected AtomicBoolean b;
    protected long c;
    protected d d;
    protected com.startapp.sdk.adsbase.cache.b e;
    protected final Map<com.startapp.sdk.adsbase.adlisteners.b, List<StartAppAd>> f;
    private final AdPreferences.Placement h;
    private Context i;
    private ActivityExtra j;
    private AdPreferences k;
    private String l;
    private boolean m;
    private int n;
    private boolean o;
    private Long p;
    private b q;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface b {
        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class a implements AdEventListener {
        private boolean a = false;
        private boolean b = false;

        a() {
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
        public final void onReceiveAd(Ad ad) {
            List<StartAppAd> a;
            boolean z = false;
            if (e.this.a != null && e.this.a.e()) {
                z = true;
            }
            if (!this.a && !z) {
                this.a = true;
                synchronized (e.this.f) {
                    for (com.startapp.sdk.adsbase.adlisteners.b bVar : e.this.f.keySet()) {
                        if (bVar != null && (a = e.this.a(e.this.f, bVar)) != null) {
                            for (StartAppAd startAppAd : a) {
                                startAppAd.setErrorMessage(ad.getErrorMessage());
                                bVar.a(startAppAd);
                            }
                        }
                    }
                    e.this.f.clear();
                }
            }
            e.this.d.f();
            e.this.e.a();
            e.this.b.set(false);
        }

        @Override // com.startapp.sdk.adsbase.adlisteners.AdEventListener
        public final void onFailedToReceiveAd(Ad ad) {
            List<StartAppAd> a;
            ConcurrentHashMap concurrentHashMap = null;
            if (!this.b) {
                synchronized (e.this.f) {
                    concurrentHashMap = new ConcurrentHashMap(e.this.f);
                    e.this.a = null;
                    e.this.f.clear();
                }
            }
            if (concurrentHashMap != null) {
                for (com.startapp.sdk.adsbase.adlisteners.b bVar : concurrentHashMap.keySet()) {
                    if (bVar != null && (a = e.this.a(concurrentHashMap, bVar)) != null) {
                        for (StartAppAd startAppAd : a) {
                            startAppAd.setErrorMessage(ad.getErrorMessage());
                            bVar.b(startAppAd);
                        }
                    }
                }
            }
            this.b = true;
            e.this.e.f();
            e.this.d.a();
            e.this.b.set(false);
        }
    }

    public e(Context context, AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.a = null;
        this.b = new AtomicBoolean(false);
        this.l = null;
        this.m = false;
        this.d = null;
        this.e = null;
        this.f = new ConcurrentHashMap();
        this.o = true;
        this.h = placement;
        this.k = adPreferences;
        if (context instanceof Activity) {
            this.i = context.getApplicationContext();
            this.j = new ActivityExtra((Activity) context);
        } else {
            this.i = context;
            this.j = null;
        }
        this.d = new d(this);
        this.e = new com.startapp.sdk.adsbase.cache.b(this);
    }

    public e(Context context, AdPreferences.Placement placement, AdPreferences adPreferences, byte b2) {
        this(context, placement, adPreferences);
        this.o = false;
    }

    public final AdPreferences a() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AdPreferences adPreferences) {
        this.k = adPreferences;
    }

    public final f b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AdPreferences.Placement c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        this.m = true;
    }

    protected final List<StartAppAd> a(Map<com.startapp.sdk.adsbase.adlisteners.b, List<StartAppAd>> map, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        try {
            return map.get(bVar);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.i);
            return null;
        }
    }

    private void a(Map<com.startapp.sdk.adsbase.adlisteners.b, List<StartAppAd>> map, com.startapp.sdk.adsbase.adlisteners.b bVar, List<StartAppAd> list) {
        try {
            map.put(bVar, list);
        } catch (Throwable th) {
            new com.startapp.sdk.adsbase.infoevents.e(th).a(this.i);
        }
    }

    public final void a(StartAppAd startAppAd, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        a(startAppAd, bVar, false, true);
    }

    private void a(StartAppAd startAppAd, com.startapp.sdk.adsbase.adlisteners.b bVar, boolean z, boolean z2) {
        synchronized (this.f) {
            if (!(!l() || p() || z)) {
                new StringBuilder().append(this.h).append(" ad already loaded");
                if (startAppAd != null && bVar != null) {
                    bVar.a(startAppAd);
                }
            } else {
                if (startAppAd != null && bVar != null) {
                    List<StartAppAd> a2 = a(this.f, bVar);
                    ArrayList arrayList = a2;
                    if (a2 == null) {
                        arrayList = new ArrayList();
                        a(this.f, bVar, arrayList);
                    }
                    arrayList.add(startAppAd);
                }
                if (!this.b.compareAndSet(false, true)) {
                    new StringBuilder().append(this.h).append(" ad is currently loading");
                    return;
                }
                this.d.g();
                this.e.g();
                a(z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        boolean z;
        new StringBuilder("Invalidating: ").append(this.h);
        if (l()) {
            Context context = this.i;
            Ad ad = (Ad) this.a;
            if (ad != null) {
                HashSet hashSet = new HashSet();
                if (ad instanceof HtmlAd) {
                    z = com.iab.omid.library.startapp.b.a(context, com.iab.omid.library.startapp.b.a(((HtmlAd) ad).j(), 0), 0, hashSet, new ArrayList()).booleanValue();
                } else if (ad instanceof JsonAd) {
                    z = com.iab.omid.library.startapp.b.a(context, ((JsonAd) ad).g(), 0, (Set<String>) hashSet, false).size() == 0;
                }
                if (!z || p()) {
                    a(null, null, true, false);
                } else if (!this.b.get()) {
                    this.d.f();
                    return;
                } else {
                    return;
                }
            }
            z = false;
            if (!z) {
            }
            a(null, null, true, false);
        } else if (!this.b.get()) {
            this.e.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        this.e.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        this.d.h();
    }

    private boolean l() {
        return this.a != null && this.a.isReady();
    }

    public final f h() {
        f fVar = null;
        if (l()) {
            fVar = this.a;
            this.n = 0;
            this.p = null;
            if (!AdsConstants.b.booleanValue() && this.o) {
                new StringBuilder("Ad shown, reloading ").append(this.h);
                a(null, null, true, true);
            } else if (!this.o) {
                if (this.q != null) {
                    this.q.a(this);
                }
                if (this.d != null) {
                    this.d.a();
                }
            }
        }
        return fVar;
    }

    private f m() {
        f splashAd;
        switch (this.h) {
            case INAPP_FULL_SCREEN:
                splashAd = new OverlayAd(this.i);
                break;
            case INAPP_OVERLAY:
                if (u.a(4L)) {
                    splashAd = new VideoEnabledAd(this.i);
                    break;
                } else {
                    splashAd = new OverlayAd(this.i);
                    break;
                }
            case INAPP_OFFER_WALL:
                boolean z = new Random().nextInt(100) < AdsCommonMetaData.a().d();
                boolean isForceOfferWall3D = this.k.isForceOfferWall3D();
                boolean z2 = !this.k.isForceOfferWall2D();
                boolean a2 = u.a(64L);
                if ((u.a(64L) && !u.a(128L)) || (a2 && ((z || isForceOfferWall3D) && z2))) {
                    splashAd = new OfferWall3DAd(this.i);
                    break;
                } else {
                    splashAd = new OfferWallAd(this.i);
                    break;
                }
                break;
            case INAPP_RETURN:
                splashAd = new ReturnAd(this.i);
                break;
            case INAPP_SPLASH:
                splashAd = new SplashAd(this.i);
                break;
            default:
                splashAd = new OverlayAd(this.i);
                break;
        }
        new StringBuilder("ad Type: [").append(splashAd.getClass().toString()).append("]");
        return splashAd;
    }

    private void a(boolean z) {
        if (this.a != null) {
            this.a.a(false);
        }
        if (n()) {
            this.m = false;
            b(z);
            return;
        }
        c(z);
    }

    private boolean n() {
        return this.m && this.l != null;
    }

    private void b(final boolean z) {
        new StringBuilder("Loading ").append(this.h).append(" from disk file name: ").append(this.l);
        final a aVar = new a();
        DiskAdCacheManager.a(this.i, this.l, new DiskAdCacheManager.a() { // from class: com.startapp.sdk.adsbase.cache.e.2
            @Override // com.startapp.sdk.adsbase.cache.DiskAdCacheManager.a
            public final void a(f fVar) {
                String unused = e.g;
                new StringBuilder("Success loading from disk: ").append(e.this.h);
                e.this.a = fVar;
            }
        }, new com.startapp.sdk.adsbase.adlisteners.b() { // from class: com.startapp.sdk.adsbase.cache.e.1
            @Override // com.startapp.sdk.adsbase.adlisteners.b
            public final void a(Ad ad) {
                aVar.onReceiveAd(ad);
            }

            @Override // com.startapp.sdk.adsbase.adlisteners.b
            public final void b(Ad ad) {
                String unused = e.g;
                new StringBuilder("Failed to load ").append(e.this.h).append(" from disk");
                e.this.a = null;
                e.this.c(z);
            }
        });
    }

    public final void a(b bVar) {
        this.q = bVar;
    }

    public final boolean i() {
        if (this.n < MetaData.E().L()) {
            this.n++;
            a(null, null, true, false);
            return true;
        }
        if (this.q != null) {
            this.q.a(this);
        }
        return false;
    }

    public final int j() {
        return this.n;
    }

    public final void a(int i) {
        this.n = i;
    }

    private boolean o() {
        Long h = AdsCommonMetaData.a().h();
        if (h != null && this.p != null && SystemClock.elapsedRealtime() - this.p.longValue() < h.longValue()) {
            final Context context = this.i;
            final AdPreferences.Placement placement = this.h;
            new a().onFailedToReceiveAd(new Ad(context, placement) { // from class: com.startapp.sdk.adsbase.cache.CachedAd$3
                @Override // com.startapp.sdk.adsbase.Ad
                protected final void a(AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
                }

                @Override // com.startapp.sdk.adsbase.Ad
                public String getAdId() {
                    return null;
                }

                @Override // com.startapp.sdk.adsbase.Ad
                public String getErrorMessage() {
                    return "explicit call: nofill [204]";
                }
            });
            u.a(this.i, true, "Failed to load " + this.h.name() + " ad: NO FILL");
            return true;
        }
        this.p = Long.valueOf(SystemClock.elapsedRealtime());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (!z || !o()) {
            this.a = m();
            this.a.setActivityExtra(this.j);
            this.k.setAutoLoadAmount(this.n);
            this.a.load(this.k, new a());
            this.c = System.currentTimeMillis();
        }
    }

    private boolean p() {
        if (this.a == null) {
            return false;
        }
        return this.a.e_();
    }
}
