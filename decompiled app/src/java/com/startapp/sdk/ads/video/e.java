package com.startapp.sdk.ads.video;

import android.content.Context;
import android.util.Base64;
import com.startapp.sdk.ads.video.c;
import com.startapp.sdk.ads.video.g;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: StartAppSDK */
/* loaded from: /storage/emulated/0/Documents/jadec/sources/com.my.youtubewatchtime.view.sa/dex-files/1.dex */
public final class e {
    private static e a = new e();
    private LinkedList<CachedVideoAd> b = new LinkedList<>();

    static /* synthetic */ void a(e eVar, final Context context, String str, final g.a aVar, final c.a aVar2) {
        if (eVar.b == null) {
            eVar.b = (LinkedList) com.startapp.common.b.d.a(context, "CachedAds");
            if (eVar.b == null) {
                eVar.b = new LinkedList<>();
            }
            if (eVar.a(AdsCommonMetaData.a().I().b())) {
                eVar.a(context);
            }
        }
        try {
            URL url = new URL(str);
            String str2 = url.getHost() + url.getPath().replace("/", "_");
            try {
                String substring = str2.substring(0, str2.lastIndexOf(46));
                str2 = new String(Base64.encodeToString(MessageDigest.getInstance("MD5").digest(substring.getBytes()), 0)).replaceAll("[^a-zA-Z0-9]+", "_") + str2.substring(str2.lastIndexOf(46));
            } catch (NoSuchAlgorithmException e) {
            }
            final CachedVideoAd cachedVideoAd = new CachedVideoAd(str2);
            new g(context, url, str2, new g.a() { // from class: com.startapp.sdk.ads.video.e.2
                @Override // com.startapp.sdk.ads.video.g.a
                public final void a(String str3) {
                    if (aVar != null) {
                        aVar.a(str3);
                    }
                    if (str3 != null) {
                        cachedVideoAd.a(System.currentTimeMillis());
                        cachedVideoAd.a(str3);
                        e.this.a(context, cachedVideoAd);
                    }
                }
            }, new c.a() { // from class: com.startapp.sdk.ads.video.e.3
                @Override // com.startapp.sdk.ads.video.c.a
                public final void a(String str3) {
                    if (aVar2 != null) {
                        aVar2.a(str3);
                    }
                }
            }).a();
        } catch (MalformedURLException e2) {
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    private e() {
    }

    private boolean a(int i) {
        boolean z;
        boolean z2 = false;
        Iterator<CachedVideoAd> it = this.b.iterator();
        while (it.hasNext() && this.b.size() > i) {
            CachedVideoAd next = it.next();
            String b = next.b();
            Iterator<com.startapp.sdk.adsbase.cache.e> it2 = com.startapp.sdk.adsbase.cache.a.a().c().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                com.startapp.sdk.adsbase.cache.e next2 = it2.next();
                if (next2.b() instanceof VideoEnabledAd) {
                    VideoEnabledAd videoEnabledAd = (VideoEnabledAd) next2.b();
                    if (videoEnabledAd.g() != null && videoEnabledAd.g().b() != null && videoEnabledAd.g().b().equals(b)) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                z2 = true;
                it.remove();
                if (next.b() != null) {
                    new File(next.b()).delete();
                    new StringBuilder("cachedVideoAds reached the maximum of ").append(i).append(" videos - removed ").append(next.a()).append(" Size = ").append(this.b.size());
                }
            }
        }
        return z2;
    }

    protected final void a(Context context, CachedVideoAd cachedVideoAd) {
        if (this.b.contains(cachedVideoAd)) {
            this.b.remove(cachedVideoAd);
            new StringBuilder("cachedVideoAds already contained ").append(cachedVideoAd.a()).append(" - removed. Size = ").append(this.b.size());
        }
        a(AdsCommonMetaData.a().I().b() - 1);
        this.b.add(cachedVideoAd);
        a(context);
        new StringBuilder("Added ").append(cachedVideoAd.a()).append(" to cachedVideoAds. Size = ").append(this.b.size());
    }

    private void a(Context context) {
        com.startapp.common.b.d.b(context, "CachedAds", this.b);
    }

    public static e a() {
        return a;
    }
}
