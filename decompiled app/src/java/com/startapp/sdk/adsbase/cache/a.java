package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import com.startapp.sdk.adsbase.cache.e;
import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.infoevents.InfoEventCategory;
import com.startapp.sdk.adsbase.j;
import com.startapp.sdk.adsbase.j.u;
import com.startapp.sdk.adsbase.k;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public class a {
    private static final String d = a.class.getSimpleName();
    private static a e = new a();
    protected Context c;
    private e.b i;
    final Map<CacheKey, e> a = new ConcurrentHashMap();
    private Map<String, String> f = new WeakHashMap();
    protected boolean b = false;
    private boolean g = false;
    private Queue<C0037a> h = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StartAppSDK */
    /* renamed from: com.startapp.sdk.adsbase.cache.a$a  reason: collision with other inner class name */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public class C0037a {
        StartAppAd a;
        AdPreferences.Placement b;
        AdPreferences c;
        com.startapp.sdk.adsbase.adlisteners.b d;

        C0037a(StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
            this.a = startAppAd;
            this.b = placement;
            this.c = adPreferences;
            this.d = bVar;
        }
    }

    private a() {
    }

    public static a a() {
        return e;
    }

    public final CacheKey a(Context context, StartAppAd startAppAd, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        if (c(AdPreferences.Placement.INAPP_SPLASH)) {
            return a(context, startAppAd, AdPreferences.Placement.INAPP_SPLASH, adPreferences, bVar);
        }
        return null;
    }

    public final CacheKey a(Context context, AdPreferences adPreferences) {
        if (c(AdPreferences.Placement.INAPP_RETURN)) {
            return a(context, (StartAppAd) null, AdPreferences.Placement.INAPP_RETURN, adPreferences, (com.startapp.sdk.adsbase.adlisteners.b) null);
        }
        return null;
    }

    public final CacheKey a(Context context, StartAppAd startAppAd, StartAppAd.AdMode adMode, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        AdPreferences.Placement placement;
        AdPreferences adPreferences2 = adPreferences;
        if (adPreferences2 == null) {
            adPreferences2 = new AdPreferences();
        }
        AdPreferences adPreferences3 = adPreferences2;
        switch (adMode) {
            case OFFERWALL:
                if (!u.a(128L) && !u.a(64L)) {
                    placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                    break;
                } else {
                    placement = AdPreferences.Placement.INAPP_OFFER_WALL;
                    break;
                }
            case OVERLAY:
            case FULLPAGE:
            case VIDEO:
            case REWARDED_VIDEO:
                placement = AdPreferences.Placement.INAPP_OVERLAY;
                break;
            case AUTOMATIC:
                boolean z = u.a(128L) || u.a(64L);
                boolean a = u.a(4L);
                boolean a2 = u.a(2L);
                if (a && a2 && z) {
                    if (new Random().nextInt(100) >= AdsCommonMetaData.a().b()) {
                        placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                        break;
                    } else if ((new Random().nextInt(100) >= AdsCommonMetaData.a().c() && !adPreferences3.isForceFullpage()) || adPreferences3.isForceOverlay()) {
                        placement = AdPreferences.Placement.INAPP_OVERLAY;
                        break;
                    }
                } else if (a || a2) {
                    placement = AdPreferences.Placement.INAPP_OVERLAY;
                    break;
                } else if (z) {
                    placement = AdPreferences.Placement.INAPP_OFFER_WALL;
                    break;
                }
                break;
            default:
                placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                break;
        }
        AdPreferences.Placement placement2 = placement;
        AdPreferences adPreferences4 = adPreferences2;
        if (adMode.equals(StartAppAd.AdMode.REWARDED_VIDEO)) {
            adPreferences4.setType(Ad.AdType.REWARDED_VIDEO);
        } else if (adMode.equals(StartAppAd.AdMode.VIDEO)) {
            adPreferences4.setType(Ad.AdType.VIDEO);
        }
        return a(context, startAppAd, placement2, adPreferences2, bVar, false, 0);
    }

    public final void a(final Context context) {
        this.c = context.getApplicationContext();
        if (f()) {
            this.g = true;
            final DiskAdCacheManager.b bVar = new DiskAdCacheManager.b() { // from class: com.startapp.sdk.adsbase.cache.a.1
                @Override // com.startapp.sdk.adsbase.cache.DiskAdCacheManager.b
                public final void a(List<DiskAdCacheManager.DiskCacheKey> list) {
                    if (list != null) {
                        try {
                            for (DiskAdCacheManager.DiskCacheKey diskCacheKey : list) {
                                if (a.c(diskCacheKey.placement)) {
                                    String unused = a.d;
                                    new StringBuilder("Loading from disk: ").append(diskCacheKey.placement);
                                    a.this.a(context, null, diskCacheKey.a(), diskCacheKey.b(), null, true, diskCacheKey.c());
                                }
                            }
                        } catch (Throwable th) {
                            new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                        }
                    }
                    a.this.d(context);
                }
            };
            ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final List b = com.startapp.common.b.d.b(context, DiskAdCacheManager.a());
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.2.1
                            {
                                AnonymousClass2.this = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                bVar.a(b);
                            }
                        });
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    }
                }
            });
        }
    }

    public final void a(AdPreferences.Placement placement) {
        if (!this.g) {
            synchronized (this.a) {
                for (e eVar : this.a.values()) {
                    if (eVar.c() == placement) {
                        eVar.e();
                    }
                }
            }
        }
    }

    public final void b() {
        if (!this.g) {
            synchronized (this.a) {
                for (e eVar : this.a.values()) {
                    eVar.e();
                }
            }
        }
    }

    public final void a(final Context context, boolean z) {
        if (f()) {
            ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.cache.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.startapp.common.b.d.c(context, DiskAdCacheManager.a());
                        com.startapp.common.b.d.c(context, DiskAdCacheManager.b());
                        CacheKey cacheKey = null;
                        for (Map.Entry<CacheKey, e> entry : a.this.a.entrySet()) {
                            CacheKey key = entry.getKey();
                            if (key.a() == AdPreferences.Placement.INAPP_SPLASH) {
                                cacheKey = key;
                            } else {
                                e value = entry.getValue();
                                String unused = a.d;
                                new StringBuilder("Saving to disk: ").append(key.toString());
                                DiskAdCacheManager.a(context, key.a(), value.a(), a.c(key), value.j());
                                DiskAdCacheManager.a(context, value, a.c(key));
                            }
                        }
                        if (cacheKey != null) {
                            a.this.a.remove(cacheKey);
                        }
                    } catch (Throwable th) {
                        new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    }
                }
            });
        }
        for (e eVar : this.a.values()) {
            if (eVar.b() == null || !u.a(2L) || !(eVar.b() instanceof ReturnAd) || z || !CacheMetaData.a().b().e()) {
                eVar.g();
            }
            eVar.f();
        }
    }

    public final void b(final Context context) {
        this.b = true;
        final DiskAdCacheManager.c cVar = new DiskAdCacheManager.c() { // from class: com.startapp.sdk.adsbase.cache.a.2
            @Override // com.startapp.sdk.adsbase.cache.DiskAdCacheManager.c
            public final void a() {
                a.this.b = false;
            }
        };
        ThreadManager.a(ThreadManager.Priority.DEFAULT, new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.startapp.common.b.d.c(context, "startapp_ads");
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            cVar.a();
                        }
                    });
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                }
            }
        });
    }

    public final void c(final Context context) {
        com.startapp.sdk.adsbase.remoteconfig.b bVar = new com.startapp.sdk.adsbase.remoteconfig.b() { // from class: com.startapp.sdk.adsbase.cache.a.3
            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a(MetaDataRequest.RequestReason requestReason, boolean z) {
                Set<StartAppAd.AdMode> c;
                String unused = a.d;
                if (z && (c = CacheMetaData.a().b().c()) != null) {
                    for (StartAppAd.AdMode adMode : a.this.a(c)) {
                        new StringBuilder("preCacheAds load ").append(adMode.name());
                        int b = AdsCommonMetaData.a().b();
                        if (adMode == StartAppAd.AdMode.FULLPAGE) {
                            if (b > 0) {
                                a.this.a(context, (StartAppAd) null, StartAppAd.AdMode.FULLPAGE, new AdPreferences(), (com.startapp.sdk.adsbase.adlisteners.b) null);
                            }
                        } else if (adMode != StartAppAd.AdMode.OFFERWALL) {
                            a.this.a(context, (StartAppAd) null, adMode, new AdPreferences(), (com.startapp.sdk.adsbase.adlisteners.b) null);
                        } else if (b < 100) {
                            a.this.a(context, (StartAppAd) null, StartAppAd.AdMode.OFFERWALL, new AdPreferences(), (com.startapp.sdk.adsbase.adlisteners.b) null);
                        }
                        String a = a.a(adMode);
                        if (a != null) {
                            j.b(context, a, Integer.valueOf(j.a(context, a, (Integer) 0).intValue() + 1));
                        }
                    }
                }
            }

            @Override // com.startapp.sdk.adsbase.remoteconfig.b
            public final void a() {
                String unused = a.d;
            }
        };
        synchronized (MetaData.h()) {
            MetaData.E().a(bVar);
        }
    }

    protected final Set<StartAppAd.AdMode> a(Set<StartAppAd.AdMode> set) {
        Iterator<StartAppAd.AdMode> it = set.iterator();
        while (it.hasNext()) {
            StartAppAd.AdMode next = it.next();
            if (j.a(this.c, a(next), (Integer) 0).intValue() >= MetaData.E().M()) {
                new StringBuilder("preCacheAds.remove ").append(next.name());
                it.remove();
            }
        }
        if (!u.a(128L) && !u.a(64L)) {
            set.remove(StartAppAd.AdMode.OFFERWALL);
        }
        if (!u.a(2L) && !u.a(4L)) {
            set.remove(StartAppAd.AdMode.FULLPAGE);
        }
        if (!u.a(4L)) {
            set.remove(StartAppAd.AdMode.REWARDED_VIDEO);
            set.remove(StartAppAd.AdMode.VIDEO);
        }
        return set;
    }

    private int e() {
        return this.a.size();
    }

    public final f a(CacheKey cacheKey) {
        if (cacheKey == null) {
            return null;
        }
        new StringBuilder("Retrieving ad with ").append(cacheKey);
        e eVar = this.a.get(cacheKey);
        if (eVar != null) {
            return eVar.h();
        }
        return null;
    }

    public final f b(CacheKey cacheKey) {
        e eVar = null;
        if (cacheKey != null) {
            eVar = this.a.get(cacheKey);
        }
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public final synchronized List<e> c() {
        return new ArrayList(this.a.values());
    }

    public final String a(String str, String str2) {
        this.f.put(str2, str);
        return str2;
    }

    public final String a(String str) {
        return this.f.get(str);
    }

    public final String b(String str) {
        new StringBuilder("cache size: ").append(this.f.size()).append(" - removing ").append(str);
        return this.f.remove(str);
    }

    private boolean f() {
        return !this.b && CacheMetaData.a().b().d();
    }

    protected final void d(Context context) {
        this.g = false;
        for (C0037a c0037a : this.h) {
            if (c(c0037a.b)) {
                new StringBuilder("Loading pending request for: ").append(c0037a.b);
                a(context, c0037a.a, c0037a.b, c0037a.c, c0037a.d);
            }
        }
        this.h.clear();
    }

    protected static String c(CacheKey cacheKey) {
        return String.valueOf(cacheKey.hashCode()).replace('-', '_');
    }

    public final CacheKey a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar) {
        return a(context, startAppAd, placement, adPreferences, bVar, false, 0);
    }

    protected final CacheKey a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, com.startapp.sdk.adsbase.adlisteners.b bVar, boolean z, int i) {
        e eVar;
        AdPreferences adPreferences2 = adPreferences;
        this.c = context.getApplicationContext();
        if (adPreferences2 == null) {
            adPreferences2 = new AdPreferences();
        }
        CacheKey cacheKey = new CacheKey(placement, adPreferences2);
        if (this.g && !z) {
            new StringBuilder("Adding to pending queue: ").append(placement);
            this.h.add(new C0037a(startAppAd, placement, adPreferences2, bVar));
            return cacheKey;
        }
        AdPreferences adPreferences3 = new AdPreferences(adPreferences2);
        synchronized (this.a) {
            e eVar2 = this.a.get(cacheKey);
            eVar = eVar2;
            if (eVar2 == null) {
                new StringBuilder("CachedAd for ").append(placement).append(" not found. Adding new CachedAd with ").append(cacheKey);
                switch (placement) {
                    case INAPP_SPLASH:
                        eVar = new e(context, placement, adPreferences3, (byte) 0);
                        break;
                    default:
                        eVar = new e(context, placement, adPreferences3);
                        break;
                }
                e eVar3 = eVar;
                if (this.i == null) {
                    this.i = new e.b() { // from class: com.startapp.sdk.adsbase.cache.a.5
                        @Override // com.startapp.sdk.adsbase.cache.e.b
                        public final void a(e eVar4) {
                            synchronized (a.this.a) {
                                CacheKey cacheKey2 = null;
                                Iterator<CacheKey> it = a.this.a.keySet().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    CacheKey next = it.next();
                                    if (a.this.a.get(next) == eVar4) {
                                        cacheKey2 = next;
                                        break;
                                    }
                                }
                                if (cacheKey2 != null) {
                                    a.this.a.remove(cacheKey2);
                                    if (eVar4.c() != AdPreferences.Placement.INAPP_SPLASH) {
                                        new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.ERROR).f("Stop reload in cache").g(cacheKey2.toString()).a(a.this.c);
                                    }
                                }
                            }
                        }
                    };
                }
                eVar3.a(this.i);
                if (z) {
                    eVar.a(c(cacheKey));
                    eVar.d();
                    eVar.a(i);
                }
                a(cacheKey, eVar, context);
            } else {
                new StringBuilder("CachedAd for ").append(placement).append(" already exists.");
                eVar.a(adPreferences3);
            }
        }
        eVar.a(startAppAd, bVar);
        return cacheKey;
    }

    public final void b(AdPreferences.Placement placement) {
        synchronized (this.a) {
            Iterator<Map.Entry<CacheKey, e>> it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey().a() == placement) {
                    it.remove();
                }
            }
        }
    }

    private void a(CacheKey cacheKey, e eVar, Context context) {
        synchronized (this.a) {
            int g = CacheMetaData.a().b().g();
            if (g != 0 && e() >= g) {
                long j = Long.MAX_VALUE;
                CacheKey cacheKey2 = null;
                for (CacheKey cacheKey3 : this.a.keySet()) {
                    e eVar2 = this.a.get(cacheKey3);
                    if (eVar2.c() == eVar.c() && eVar2.c < j) {
                        j = eVar2.c;
                        cacheKey2 = cacheKey3;
                    }
                }
                if (cacheKey2 != null) {
                    this.a.remove(cacheKey2);
                }
            }
            this.a.put(cacheKey, eVar);
            if (Math.random() * 100.0d < CacheMetaData.a().c()) {
                new com.startapp.sdk.adsbase.infoevents.e(InfoEventCategory.GENERAL).f("Cache Size").g(String.valueOf(e())).a(context);
            }
        }
    }

    protected static boolean c(AdPreferences.Placement placement) {
        switch (placement) {
            case INAPP_SPLASH:
                return k.a().k() && !AdsCommonMetaData.a().A();
            case INAPP_RETURN:
                return k.a().j() && !AdsCommonMetaData.a().z();
            default:
                return true;
        }
    }

    public static String a(StartAppAd.AdMode adMode) {
        if (adMode != null) {
            return "autoLoadNotShownAdPrefix" + adMode.name();
        }
        return null;
    }
}
