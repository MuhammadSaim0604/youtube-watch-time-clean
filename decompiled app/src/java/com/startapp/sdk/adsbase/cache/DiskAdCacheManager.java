package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.common.ThreadManager;
import com.startapp.sdk.ads.list3d.g;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.f;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.File;
import java.io.Serializable;
import java.util.List;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class DiskAdCacheManager {
    public String a = "";
    public int b = -1;

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface a {
        void a(f fVar);
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface b {
        void a(List<DiskCacheKey> list);
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public interface c {
        void a();
    }

    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    protected static class DiskCacheKey implements Serializable {
        private static final long serialVersionUID = 1;
        protected AdPreferences adPreferences;
        private int numberOfLoadedAd;
        protected AdPreferences.Placement placement;

        protected DiskCacheKey(AdPreferences.Placement placement, AdPreferences adPreferences) {
            this.placement = placement;
            this.adPreferences = adPreferences;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final AdPreferences.Placement a() {
            return this.placement;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final AdPreferences b() {
            return this.adPreferences;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final int c() {
            return this.numberOfLoadedAd;
        }

        protected final void a(int i) {
            this.numberOfLoadedAd = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: StartAppSDK */
    /* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
    public static class DiskCachedAd implements Serializable {
        private static final long serialVersionUID = 1;
        private f ad;
        private String html;

        protected DiskCachedAd(f fVar) {
            this.ad = fVar;
            if (this.ad == null || !(this.ad instanceof HtmlAd)) {
                return;
            }
            this.html = ((HtmlAd) this.ad).j();
        }

        protected final f a() {
            return this.ad;
        }

        protected final String b() {
            return this.html;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, AdPreferences.Placement placement, AdPreferences adPreferences, String str, int i) {
        DiskCacheKey diskCacheKey = new DiskCacheKey(placement, adPreferences);
        diskCacheKey.a(i);
        com.startapp.common.b.d.a(context, a(), str, diskCacheKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, e eVar, String str) {
        com.startapp.common.b.d.a(context, b(), str, new DiskCachedAd(eVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(final Context context, final String str, final a aVar, final com.startapp.sdk.adsbase.adlisteners.b bVar) {
        ThreadManager.a(ThreadManager.Priority.HIGH, new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    final DiskCachedAd diskCachedAd = (DiskCachedAd) com.startapp.common.b.d.a(context, DiskAdCacheManager.b(), str);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (diskCachedAd == null) {
                                    new StringBuilder("File not found or error: ").append(str);
                                    bVar.b(null);
                                } else if (diskCachedAd.a() == null || !diskCachedAd.a().isReady()) {
                                    bVar.b(null);
                                } else if (!diskCachedAd.a().e_()) {
                                    DiskAdCacheManager.a(context, diskCachedAd, aVar, bVar);
                                } else {
                                    bVar.b(null);
                                }
                            } catch (Throwable th) {
                                new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                                bVar.b(null);
                            }
                        }
                    });
                } catch (Throwable th) {
                    new com.startapp.sdk.adsbase.infoevents.e(th).a(context);
                    bVar.b(null);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static void a(android.content.Context r16, com.startapp.sdk.adsbase.cache.DiskAdCacheManager.DiskCachedAd r17, com.startapp.sdk.adsbase.cache.DiskAdCacheManager.a r18, final com.startapp.sdk.adsbase.adlisteners.b r19) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.cache.DiskAdCacheManager.a(android.content.Context, com.startapp.sdk.adsbase.cache.DiskAdCacheManager$DiskCachedAd, com.startapp.sdk.adsbase.cache.DiskAdCacheManager$a, com.startapp.sdk.adsbase.adlisteners.b):void");
    }

    private static void a(OfferWall3DAd offerWall3DAd, com.startapp.sdk.adsbase.adlisteners.b bVar, List<AdDetails> list) {
        com.startapp.sdk.ads.list3d.f a2 = g.a().a(offerWall3DAd.a());
        a2.a();
        for (AdDetails adDetails : list) {
            a2.a(adDetails);
        }
        bVar.a(offerWall3DAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a() {
        return "startapp_ads".concat(File.separator).concat("keys");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        return "startapp_ads".concat(File.separator).concat("interstitials");
    }
}
